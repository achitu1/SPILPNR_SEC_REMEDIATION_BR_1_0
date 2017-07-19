package com.delta.PNRJ.actions;





import java.net.InetAddress;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.HashSet;

import java.util.Iterator;

import java.util.List;

import java.util.Map;

import java.util.Set;

import java.util.StringTokenizer;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import javax.xml.ws.BindingProvider;



import org.apache.struts.action.Action;

import org.apache.struts.action.ActionError;

import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionForward;

import org.apache.struts.action.ActionMapping;



import com.delta.PNRJ.forms.PNRJ002_lookupDefaultForm;

import com.delta.PNRJ.helper.ConfigurationUtil;

import com.delta.PNRJ.helper.CustomValidationRules;

import com.delta.PNRJ.helper.EJBLookup;

import com.delta.PNRJ.helper.PNRJUtil;

import com.delta.PRA.PNRJ.EJB.PNRJ;

import com.delta.PRA.PNRJ.EJB.PNRJBean;

import com.delta.PRA.PNRJ.data.PNRData;

import com.delta.common.SPILPropertyManager;
import com.delta.soa.updated.PCiTokenManager.*;
//
//import com.delta.schemas.pci.v1.pciitemstat.PciTokItemStatus;
//
//import com.delta.schemas.pci.v1.requestinfo.PciRequestInfo;
//
//import com.delta.soa.pci.soagov.v1.ArrayOfString;
//import com.delta.soa.pci.soagov.v1.PciTokenMgr_EPProxy;
//
//import com.delta.soa.pci.soagov.v1.DecodeArrayOfTokensRequest;
//
//import com.delta.soa.pci.soagov.v1.DecodeArrayOfTokensResponse;
//
//import com.delta.soa.pci.soagov.v1.LookupArrayOfTokensRequest;
//
//import com.delta.soa.pci.soagov.v1.LookupArrayOfTokensResponse;
//
//import com.delta.soa.pci.soagov.v1.PciTokenMgr;
//
//import com.delta.soa.pci.soagov.v1.PciTokenMgr_Service;

import com.nwa.PRA.ADLookupHelper.ADLookupException;

import com.nwa.PRA.logger.Logger;

import com.nwa.adsvmp.ADUtil;

import com.nwa.adsvmp.EmployeeInfo;



////////////////////UPDATES & COMMENTS////////////////////

/*

 * 

 * @author id

 *

 * Program Description

 * 

 * Updates:

 * Date			Initials	Change

 * 20070116		AP			Changed System.out to Logger

 * 20110215		Hari		Changed to read the CC encryption from SOA.
 * 
 * 20161228		AC			Updated CC SOA endpoint.

 */



public class PNRJ002_LookupDefaultSubmitAction extends Action{

	

	private HttpSession session;	

	private static final String SERVICE_URL = "endpoint.url";

	private static String endpointUrl = null;

	

	static{

		

		try{

		endpointUrl = ConfigurationUtil.getPropertyValueFromEnvironmentSettings(SERVICE_URL);

		}catch(Exception e){

			e.printStackTrace();

			

		}

	}

	public ActionForward execute(ActionMapping mapping, 

								ActionForm form, 

								HttpServletRequest request, 

								HttpServletResponse response) 

			throws Exception{



			PNRJ002_lookupDefaultForm frm = (PNRJ002_lookupDefaultForm) form;

			Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_LookupDefaultSubmitAction");

			// initializing the list and detail; so as to assure that the 

			// previous list and details are erased 

			frm.setPnrDetail(null);

			frm.setPnrList(null);

			ActionErrors errorException = new ActionErrors();

			ActionErrors errors = new ActionErrors();

			String link = "success";

			

			// get the authorizedCC from session

			String userAuthorizedCC = "";

			if(request.getSession() != null && request.getSession().getAttribute("userAuthorizedCC") != null)

				userAuthorizedCC = (String) request.getSession().getAttribute("userAuthorizedCC");

			else if(request.isUserInRole("querycc")){

				userAuthorizedCC = "TRUE";

			}

			

			frm.setUserAuthorizedCC(userAuthorizedCC);

						

			//20080618 -  Issue 4885 - added to check if user currently logged in can view Employee No. field

			String userId =  request.getUserPrincipal().getName(); //to get the authenticated user.

			ADUtil adHelper = new ADUtil();

			EmployeeInfo empInfo=null;



			try {

				//Verify this userid is a Northwest Employee

				empInfo = adHelper.getEmployeeInfoFromAD(userId);

				Logger.log(PNRJ002_LookupDefaultAction.class, Logger.LEVEL_DEBUG, " User MemberOf:" + empInfo.getMemberOf());

			} catch (Exception e) {

				//userInAD = false;

				errorException.add("logon", new org.apache.struts.action.ActionError("error.userID.invalid"));

				e.printStackTrace();

			}

			String empGroups = empInfo.getMemberOf();

			

			Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "In LookupDefaultSubmitAction");

			Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "PNR Number is:" + frm.getPnrLocator());

			Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Employee ID is:" + frm.getEmployeeNumber());

			Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Freq Flier is:" + frm.getFrequentFlyerNumber());

			Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Ticket Number is:" + frm.getTicketNumber());

			//  -------------EJB Portion----------------------

				 

			EJBLookup ejbLookup = new EJBLookup();			

			PNRJ pnrjBean = null;   // Home interface

			//PNRJLocal pnrjBean = null;

			String tkt = frm.getTicketNumber();

			try{

				pnrjBean = ejbLookup.lookupEjb();

				//pnrjBean = ejbLookup.getPNRJLocalRef();

				ArrayList pnrDetailList = new ArrayList();

				

				//for issue 386 (20080403)

				ArrayList pnrList = new ArrayList();

				ArrayList fopList = new ArrayList();		

				ArrayList pnrTextList = new ArrayList();

				

				frm.setPnrList(pnrList);

				frm.setPnrTextList(pnrTextList);

				frm.setShowRedisplay(true);		

				frm.setFopList(fopList);	

//				frm.setSelectFop(false);	//edited 20080415

				//end of issue 386

				



				//searching by pnr locator so lets call the stored proc passing locator entered

				if(!frm.getPnrLocator().equals(null) && frm.getPnrLocator().length() != 0){

					int pnrCount=0;

					Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "inside pnr locator");

					

					String pnrCrtnYrMo=null;

					String pnrCrtnDte=null;

					

					pnrList = pnrjBean.call_pnr_lookup(frm.getPnrLocator().trim().toUpperCase());



					pnrCount=pnrList.size();



					if(pnrCount==1){

						

						String pnrNumber=null;

						String pnrCreationDate=null;

						//directly pull up the pnr text for this creation date and pnr number

						Iterator i = pnrList.iterator();

						PNRData data = (PNRData)i.next();

						

						pnrNumber=data.getPnrLoctrNum();

						pnrCreationDate = data.getPnrCrtnDate();

						

						Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Creation Date: "+ pnrCreationDate + "  -  PNR Number: " + pnrNumber);



						//frm.setPnrDetail(pnrjBean.call_pnrText_lookup(pnrNumber, pnrCreationDate));	

						String pnrTextString = pnrjBean.call_pnrText_lookup(pnrNumber, pnrCreationDate);



						//if(frm.getPnrDetail().equals(null) || frm.getPnrDetail().length()==0)

						if(pnrTextString.equals(null) || pnrTextString.length()==0){

							Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Sorry no detail for given pnr and pnr creation date");

							errors.add("listEmpty", new ActionError("error.pnrText.empty"));

						}else{

							Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "retrieved a pnr text record of length "+ pnrTextString.length());

							int pnrLines = pnrTextString.length()%133 == 0 ? pnrTextString.length()/133 : pnrTextString.length()/133 + 1;

							int posLoc = 0;

							

							Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Total number of lines :"+ pnrLines);

							//edited by Hari Somagatta to solve long PNR display issues.

							pnrTextList.addAll(PNRJUtil.getPNRText2Display(pnrLines,  pnrTextString));

							if (pnrTextList.size()> 0){

								String lineOne = (String) pnrTextList.get(0);

								if (lineOne.contains("***PNR HAS MORE THAN 1000 LINES, DISPLAYING FIRST 1000 LINES ONLY.")){

									frm.setOver1000Lines("<A HREF='/SPIL/LongPNRRetriever'>Email PNR</a>");

								}

							}

																					

							frm.setPnrTextList(pnrTextList);														

						}

						frm.setShowRedisplay(false);						

						//Get Credit Card Info

						generateFOPList(frm, pnrjBean, errors, request, userId);

					}else if(pnrCount>1){

						ArrayList tmp = new ArrayList();

						//this should rarely occur

						Iterator i = pnrList.iterator();

						while(i.hasNext()){

							PNRData data = (PNRData)i.next();

							Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Creation Date for multiple pnr numbers:" + data.getPnrCrtnDate());

							pnrDetailList=pnrjBean.call_pnrDetail_lookup(data.getPnrLoctrNum(), data.getPnrCrtnDate());

							if (!pnrDetailList.isEmpty()) {

								tmp.addAll(pnrDetailList);								

							}

						}

						frm.setPnrList(tmp);

						frm.setPnrCount(new Integer(tmp.size()).toString());

						frm.setShowRedisplay(true);		

						generateFOPList(frm, pnrjBean, errors, request, userId);				

					}

					else if(pnrCount==0) {

						

						//for issue 386 (20080403)

						generateFOPList(frm, pnrjBean, errors, request, userId);

						//end of issue 386

						

						//errors.add("listEmpty", new ActionError("error.pnrList.empty"));

						errors.add("listEmpty", new ActionError("error.pnrList.empty", "PNR Locator"));						

					}

				}

				



				//searching by ticket number so lets call the stored proc passing ticket entered

				else if(!frm.getTicketNumber().equals(null) && frm.getTicketNumber().length() != 0){

					Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "In Action trying to get data for tkt number.");

					pnrList = pnrjBean.call_tkt_lookup(frm.getTicketNumber());



					//check if there was a result in the stored procedure called

					if(!pnrList.isEmpty()){

						//AP 20070116 Get Detailed tkt info

						pnrList = pnrjBean.call_default_lookup_detail(pnrList);

					}

					if (pnrList.isEmpty()) {

						//errors.add("listEmpty", new ActionError("error.pnrList.empty"));

						errors.add("listEmpty", new ActionError("error.pnrList.empty", "Ticket No."));

					}

					frm.setPnrList(pnrList);

					frm.setPnrCount(new Integer(pnrList.size()).toString());

				}

							

				else if(!frm.getCreditCardNumber().equals(null) && frm.getCreditCardNumber().trim().length() != 0){

					int ccLength = frm.getCreditCardNumber().trim().length();

					//CC length should be between 13 and 19

					if(ccLength < 13 || ccLength > 19){

						errors.add("invalidcreditcard", new ActionError("errors.creditcard",frm.getCreditCardNumber()));	

					

					}else{				

					

						//String endpointUrl = ConfigurationUtil.getPropertyValueFromEnvironmentSettings(SERVICE_URL); //commented out 12/21/16 for PCI web service endpoint update

						String ccCde=frm.getCreditCardNumber().substring(0,2).toUpperCase();

						String ccNum=frm.getCreditCardNumber().substring(2,ccLength).toUpperCase();

						

					//	PciTokenMgr_Service service = new PciTokenMgr_Service();

					//	PciTokenMgr proxy = service.getPciTokenMgrEP();

						 

						

						

						//Map<String, Object> ctxt = ((BindingProvider)proxy ).getRequestContext();

					//	ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

						

						PciRequestInfo pciInfo =  new PciRequestInfo();

						pciInfo.setAgentDutyCode(userId);

						pciInfo.setAgentSineCode(userId);

						pciInfo.setAppChannelName("SPL");						
						pciInfo.setDeltaPassportUserId(userId);
						System.out.println("<UserID: "+ userId + ">");
						pciInfo.setSysCode("SPL");
						pciInfo.setAppName("SPL");
						pciInfo.setWorkstationName(InetAddress.getLocalHost().getHostName());  
						System.out.println("<WorkstationName: "+ InetAddress.getLocalHost().getHostName() + ">");
						pciInfo.setNetworkAddress(InetAddress.getLocalHost().getHostAddress()); //needed
					
						/////////////// PCI Token Manager code change begins 123016

						//	InetAddress.getLocalHost().get

						//service goes to Db2 instead of Travel port lab.

						//pciInfo.setBackendHostId("ZOS");

						//pciInfo.set

						//pciInfo.setAppCompanyName("Northwest Airlines");

						pciInfo.setAppCompanyName("Delta Airlines");

						pciInfo.setAppVersion("1.1");

						pciInfo.setIsAppInternal(true);

						pciInfo.setIsDebugInfoRequested(false);

						

						ArrayOfString stringArray =  new ArrayOfString();

						stringArray.getString().add(ccNum);//credit card number

						String tokenizedCreditCard=null;

											

												

						LookupArrayOfTokensRequest serviceRequest = new LookupArrayOfTokensRequest();

						serviceRequest.setRequestInfo(pciInfo);

						serviceRequest.setCreditCardNumList(stringArray);


					//	LookupArrayOfTokensResponse	 serviceResponse = proxy.lookupArrayOfTokens(serviceRequest);
						  PciTokenMgr_EPProxy proxys = new PciTokenMgr_EPProxy();

                       //   proxys._getDescriptor().setEndpoint("https://webservices-si.delta.com:36518/pcitokenmgr");
						/*	String Url = SPILPropertyManager.getProperty("PCITOKENMANAGERURL");
							  proxys._getDescriptor().setEndpoint(Url);*/

						  //proxys._getDescriptor().setEndpoint("https://webservices-si.delta.com:36518/pcitokenmgr");
						  proxys._getDescriptor().setEndpoint("https://webservices.delta.com:36518/pcitokenmgr");

                    //      System.out.println("Calling LookupArrayOfToken --> "+proxys._getDescriptor().getEndpoint());
                          LookupArrayOfTokensResponse    serviceResponse = null;
                          try{
                              serviceResponse = proxys.lookupArrayOfTokens(serviceRequest);
                          }catch (Exception ex){
                        	  System.out.println("SOA error "+ex.getMessage());
                          }
  						////////// PCI Token Manager code change ends

						if(serviceResponse !=null){

							if(serviceResponse.getLookupArrayOfTokensResult() != null && serviceResponse.getLookupArrayOfTokensResult().getStatusList() != null 

									&& serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem()!= null){

								Logger.log(PNRJBean.class, Logger.LEVEL_INFO, serviceResponse.getLookupArrayOfTokensResult().getRawTraceText());

								PciTokItemStatus status = (PciTokItemStatus)serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem().get(0);

								//if(status.)

								

								

								if(status.getToken() != null){

									tokenizedCreditCard= status.getToken().getFullToken();

									//System.out.println("tokenizedCreditCard :"+tokenizedCreditCard);

								

									if(tokenizedCreditCard != null && tokenizedCreditCard.trim().length()>0 & ccCde != null){

										//once you get the tokenized credit card info, send the same to DB to get the PNR data.

										pnrList = pnrjBean.call_cc_lookup(ccCde,tokenizedCreditCard);

									}else{

										Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_ERROR, "tokenizedCreditCard is empty");

										errors.add("soaError", new ActionError("soa.creditcard.error", status.getReasonCode()+" - "+status.getReasonText()));

										saveErrors(request, errors);

										//throw new Exception("SOAERROR::SOA service for credit card lookup exception");

									}

								

									if (!pnrList.isEmpty()){

										pnrList = pnrjBean.call_default_lookup_detail(pnrList);

									}

									

								}else{

									errors.add("soaError", new ActionError("soa.creditcard.error", "Status is null"));

									saveErrors(request, errors);

								//	throw new Exception("SOAERROR::SOA service for credit card lookup exception");

								}

								

							}else{

								errors.add("soaError", new ActionError("soa.creditcard.error", "SOA Response has null objects"));

								saveErrors(request, errors);

								//throw new Exception("SOAERROR::SOA service for credit card lookup exception");

							}

							

						}else{

							errors.add("soaError", new ActionError("soa.creditcard.error", "Response from SOA is null"));

							saveErrors(request, errors);

						}

						//check if there was a result from SOA call

						if (pnrList.isEmpty() && errors.size()==0) {

							errors.add("listEmpty", new ActionError("error.pnrList.empty", "Credit Card No."));

						}

						

					}	

						frm.setPnrList(pnrList);

						frm.setPnrCount(new Integer(pnrList.size()).toString());

					

				}

				

				

				//searching by frequent flier so lets call the stored proc passing FF entered

				else if(!frm.getFrequentFlyerNumber().equals(null) && frm.getFrequentFlyerNumber().length() != 0){

					int ffLength = frm.getFrequentFlyerNumber().length();

		

					String ffCde=frm.getFrequentFlyerNumber().substring(0,2).toUpperCase();

					String ffNum=frm.getFrequentFlyerNumber().substring(2,ffLength).toUpperCase();

					

					pnrList = pnrjBean.call_freqflier_lookup(ffCde, ffNum);

					

					if (!pnrList.isEmpty()){

						pnrList = pnrjBean.call_default_lookup_detail(pnrList);

					}

					//check if there was a result in the stored procedure called

					if (pnrList.isEmpty()) {

						//errors.add("listEmpty", new ActionError("error.pnrList.empty"));

						errors.add("listEmpty", new ActionError("error.pnrList.empty", "Frequent Flyer No."));

					}

					frm.setPnrList(pnrList); 

					frm.setPnrCount(new Integer(pnrList.size()).toString());

				

				}

				

				//searching by employee number so lets call the stored proc passing emp num entered

				else if(!frm.getEmployeeNumber().equals(null) && frm.getEmployeeNumber().length() != 0)

				{

					

					//20080710 - added new logic: if user is not in PnrWebP1, the user can only querry their own number
					//updated group name for CorpAD move 20161229
			//		if (!empGroupCheck(empGroups, "PnrWebP1") && !frm.getEmployeeNumber().equalsIgnoreCase(empInfo.getEmployeeNumber()) && !frm.getEmployeeNumber().equalsIgnoreCase(empInfo.getPPRNumber())){
					//SppPnrWebP1 (for int) SppPNRWebP1 (for PROD)
					// CorpAD code change begins (updated to search in Active Directory for group)

			//		if (!empGroupCheck(empGroups, "SplWebA1") && !frm.getEmployeeNumber().equalsIgnoreCase(empInfo.getEmployeeNumber()) && !frm.getEmployeeNumber().equalsIgnoreCase(empInfo.getPPRNumber())){
						if (!request.isUserInRole("queryOtherEmps")&& !frm.getEmployeeNumber().equalsIgnoreCase(empInfo.getEmployeeNumber()) && !frm.getEmployeeNumber().equalsIgnoreCase(empInfo.getPPRNumber())){
							// PCI Token Manager code change ends

						errors.add("notAllowed", new ActionError("error.notAllowed.employeeNo"));

						saveErrors(request, errors);	

						return mapping.findForward(link);					

					}

					

					Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "inside employee number");

					

					pnrList = pnrjBean.call_employee_lookup(frm.getEmployeeNumber());

					Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "back in action for emp lookup");

					//check if there was a result in the stored procedure called

					if (!pnrList.isEmpty()){

						pnrList = pnrjBean.call_default_lookup_detail(pnrList);

					}

					if (pnrList.isEmpty()) {

						errors.add("listEmpty", new ActionError("error.pnrList.empty", "Employee No."));						

					}



					frm.setPnrList(pnrList); 

					frm.setPnrCount(new Integer(pnrList.size()).toString());

				

				}else{

					//nothing entered as input

					

						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.other.query.fields"));	

						saveErrors(request, errors);

						return mapping.findForward("failure");

				}



				//20080618 -  Issue 4885 - added to check if user currently logged in can view Employee No. field

				frm.setIsAllowedOtherPnr(CustomValidationRules.isAllowedViewOtherPnr(empGroups));

				

				Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "End of execute in PNRJ002_LookupDefaultSubmitAction");

			} 

			 catch (Exception e) {

				 System.out.println("Eror message ----> "+e.getMessage());
				 System.out.println("Url ----> "+endpointUrl);
				 System.out.println("stack error messager ----> "+e.getStackTrace());
				Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_ERROR, e.toString());
				Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_ERROR,"logger ");

				e.printStackTrace();

				if(e.getMessage() != null){

					errorException.add(ActionErrors.GLOBAL_ERROR, new ActionError("pnr.general.exception", e.getMessage()));

				}else{

					errorException.add(ActionErrors.GLOBAL_ERROR, new ActionError("pnr.general.exception", "Exception Occured in the application."));

				}

				link="failure";

			}



			if(!errorException.isEmpty() || !errors.isEmpty()){

				   if(link.equals("failure")){

						 saveErrors(request, errorException);

				   } else {

						 saveErrors(request, errors);

				   }

			 }



			return mapping.findForward(link);

	}  

	

	//AP 20070210	Populate the CC fop list		

	private void generateFOPList(PNRJ002_lookupDefaultForm frm, PNRJ pnrjBean, ActionErrors errors, HttpServletRequest request, String userId) throws Exception{ 	//edited 20080403

		

		if ("TRUE".equals(frm.getUserAuthorizedCC())){

			ArrayList<PNRData> fopList = new ArrayList<PNRData>();

			

			if (frm.isSelectFop() &&  errors.isEmpty()){

				String tmpPnr = "";

				if (frm.getPnrLocator().length() != 0){

					fopList = pnrjBean.call_fop_lookup(userId, frm.getPnrLocator().trim().toUpperCase());		

					tmpPnr = frm.getPnrLocator();		

				}else if (frm.getSelPnrLoctrNum().length() != 0){

					tmpPnr = frm.getSelPnrLoctrNum();		

					fopList = pnrjBean.call_fop_lookup(userId, frm.getSelPnrLoctrNum().trim().toUpperCase());			

				}

				//Changed by Hari to get the real CC number from SOA.

				if(!fopList.isEmpty()){

					fopList = getCreditCardsForPNRs(fopList,userId,endpointUrl,errors, request);

				}

				

				if (!tmpPnr.equals("")){

					if (fopList.isEmpty()){

						errors.add("fopListEmpty", new ActionError("error.fopList.empty", tmpPnr));		

						saveErrors(request, errors);	

					}				

				}

			}

			frm.setFopList(fopList);	

			frm.setSelectFop(false);			

		}

	}



	//20080710 - check if a certain adGroup is found in the empGroup 

	private boolean empGroupCheck(String empGroup, String adGroup){

		

		boolean isGroup = false;

		if (null != empGroup){

			if (!"".equals(empGroup.trim())){

				StringTokenizer st = new StringTokenizer(empGroup, ",");

				while(st.hasMoreTokens()) {

					if(st.nextToken().trim().equals(adGroup)){

						isGroup = true;

						return isGroup;

					}

				}	

			}

		}

		return isGroup;

	}

	

	@SuppressWarnings("unchecked")

	public ArrayList<PNRData> getCreditCardsForPNRs(ArrayList<PNRData> pnrs,String userId,String endpointUrl,ActionErrors errors, HttpServletRequest request) throws Exception{

		

		

		ArrayList<PNRData> pnrList = new ArrayList<PNRData>();



		Set<String> tknzdCCNums = new HashSet<String>();

		//Get unique Tokenized credit cards and put them in a set.

		for(int i=0;i<pnrs.size();i++){ 

			PNRData data = (PNRData)pnrs.get(i);

			if(data.getPnrCCNum() != null){

				tknzdCCNums.add(data.getPnrCCNum());

			}

		}

		Map<String,String> creditcardMap = new HashMap<String,String>();

		if(tknzdCCNums.size() > 0){
			PciTokenMgr_Service service = new PciTokenMgr_Service();

			PciTokenMgr proxy = service.getPciTokenMgrEP();

			/*	Removed for updated pcitokenmgr endpoint 12/21/16
		 

			Map<String, Object> ctxt = ((BindingProvider)proxy ).getRequestContext();

			ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

		

			PciRequestInfo pciInfo =  new PciRequestInfo();

			pciInfo.setAgentDutyCode(userId);

			pciInfo.setAgentSineCode(userId);

			pciInfo.setAppChannelName("SPL");

			//pciInfo.setAppCompanyName("Northwest Airlines");

			pciInfo.setAppCompanyName("Delta Airlines");

			pciInfo.setAppVersion("1.1");

			pciInfo.setIsAppInternal(true);

			pciInfo.setIsDebugInfoRequested(false);

			*/
/////	added 12/21/16 - webservice parameters updated
			

			PciRequestInfo pciInfo =  new PciRequestInfo();
			
			pciInfo.setWorkstationName(InetAddress.getLocalHost().getHostName());  
			System.out.println("<Host: "+ InetAddress.getLocalHost().getHostName() + ">");

			pciInfo.setNetworkAddress(InetAddress.getLocalHost().getHostAddress()); 
			
			pciInfo.setDeltaPassportUserId(userId);
			System.out.println("<UserID: "+ userId + ">");
			
			pciInfo.setSysCode("SPL");
			
			

			ArrayOfString stringArray =  new ArrayOfString();

			stringArray.getString().addAll(tknzdCCNums);//Tokenized credit card numbers

			

			DecodeArrayOfTokensRequest serviceRequest = new DecodeArrayOfTokensRequest();

			serviceRequest.setRequestInfo(pciInfo);

			serviceRequest.setTokenList(stringArray);

			 PciTokenMgr_EPProxy proxys = new PciTokenMgr_EPProxy();
			 
			 ///////////////////////////updated 
			/*String Url = SPILPropertyManager.getProperty("PCITOKENMANAGERURL");
			 proxys._getDescriptor().setEndpoint(Url);*/
		//	 proxys._getDescriptor().setEndpoint("https://webservices-si.delta.com:36518/pcitokenmgr");
			 proxys._getDescriptor().setEndpoint("https://webservices.delta.com:36518/pcitokenmgr");
			//    System.out.println("Calling SOA DecodeArrayOfTokens --> "+proxys._getDescriptor().getEndpoint());
			    DecodeArrayOfTokensResponse    serviceResponse = null;
			/////////////////////
			    serviceResponse = proxys.decodeArrayOfTokens(serviceRequest);

		//	DecodeArrayOfTokensResponse	 serviceResponse = proxy.decodeArrayOfTokens(serviceRequest);
				/////	added 12/21/16 - webservice parameters update end


			if(serviceResponse !=null){

				if(serviceResponse.getDecodeArrayOfTokensResult() != null && serviceResponse.getDecodeArrayOfTokensResult().getStatusList() != null 

						&& serviceResponse.getDecodeArrayOfTokensResult().getStatusList().getStatusItem()!= null){

					Logger.log(PNRJBean.class, Logger.LEVEL_INFO, serviceResponse.getDecodeArrayOfTokensResult().getRawTraceText());

					List<PciTokItemStatus> list = serviceResponse.getDecodeArrayOfTokensResult().getStatusList().getStatusItem();

					

					if(list != null && !list.isEmpty()){

						

						for(Iterator<PciTokItemStatus> i =list.iterator();i.hasNext();){

							PciTokItemStatus status = (PciTokItemStatus)i.next();

							

							if(status.getCreditCardNumber() != null ){

								String creditCard = status.getCreditCardNumber().getFullCardNumber();

								if(creditCard != null && creditCard.trim().length()>0 ){

									creditcardMap.put(status.getToken().getFullToken(), creditCard);

								}

//								else{

//									//throw new Exception("SOAERROR::SOA service for credit card lookup exception");

//									errors.add("soaError", new ActionError("soa.creditcard.error", "Credit Card number is empty from SOA"));

//									saveErrors(request, errors);

//								}

							}

							

						}

					}else{

						//throw new Exception("SOAERROR::SOA service for credit card lookup exception");

						errors.add("soaError", new ActionError("soa.creditcard.error", "SOA Response has empty PciTokItemStatus list."));

						saveErrors(request, errors);

					}

					

				}else{

					//throw new Exception("SOAERROR::SOA service for credit card lookup exception");

					errors.add("soaError", new ActionError("soa.creditcard.error", "SOA returned null/empty objects in Response"));

					saveErrors(request, errors);

				}

				

			}else{

				//throw new Exception("SOAERROR::SOA service for credit card lookup response was null.");

				errors.add("soaError", new ActionError("soa.creditcard.error", "SOA Response is null for FOP CC lookup"));

				saveErrors(request, errors);

			}

		}	

		

		for(int i=0;i<pnrs.size();i++){

			PNRData data = (PNRData)pnrs.get(i);

			if(data.getPnrCCNum() != null){

				String ccNum = creditcardMap.get(data.getPnrCCNum());

				data.setPnrCreditCard(ccNum);

			}

			pnrList.add(data);

		}

		

		return pnrList; 

	}

	

}

