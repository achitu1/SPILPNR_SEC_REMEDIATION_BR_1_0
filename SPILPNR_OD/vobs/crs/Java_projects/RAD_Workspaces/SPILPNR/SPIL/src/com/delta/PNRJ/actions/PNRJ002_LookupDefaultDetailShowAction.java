package com.delta.PNRJ.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.delta.schemas.pci.v1.pciitemstat.PciTokItemStatus;
import com.delta.schemas.pci.v1.requestinfo.PciRequestInfo;
import com.delta.soa.pci.soagov.v1.ArrayOfString;
import com.delta.soa.pci.soagov.v1.DecodeArrayOfTokensRequest;
import com.delta.soa.pci.soagov.v1.DecodeArrayOfTokensResponse;
import com.delta.soa.pci.soagov.v1.PciTokenMgr;
import com.delta.soa.pci.soagov.v1.PciTokenMgr_Service;
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
 * 
 */

public class PNRJ002_LookupDefaultDetailShowAction extends Action{
	
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
			Logger.log(PNRJ002_LookupDefaultDetailShowAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_LookupDefaultDetailShowAction");
			Logger.log(PNRJ002_LookupDefaultDetailShowAction.class, Logger.LEVEL_DEBUG, "In LookupDefaultDetailShowAction");
			Logger.log(PNRJ002_LookupDefaultDetailShowAction.class, Logger.LEVEL_DEBUG, "PNR Number is:" + frm.getPnrLocator());
			Logger.log(PNRJ002_LookupDefaultDetailShowAction.class, Logger.LEVEL_DEBUG, "Employee ID is:" + frm.getEmployeeNumber());
			Logger.log(PNRJ002_LookupDefaultDetailShowAction.class, Logger.LEVEL_DEBUG, "Freq Flier is:" + frm.getFrequentFlyerNumber());
			Logger.log(PNRJ002_LookupDefaultDetailShowAction.class, Logger.LEVEL_DEBUG, "Ticket Number is:" + frm.getTicketNumber());
			ActionErrors errorException = new ActionErrors();
			ActionErrors errors = new ActionErrors();
			String link = "success";
			/*  -------------EJB Portion----------------------
			*/	 
			EJBLookup ejbLookup = new EJBLookup();			
			PNRJ pnrjBean = null;   // Home interface
			
			try{
				pnrjBean = ejbLookup.lookupEjb();
				
				String pnrLoctr = frm.getSelPnrLoctrNum();
				String pnrCrtnDte = frm.getSelPnrCrtnDate();

				//get PNR text
				//String pnrTextList = pnrjBean.call_pnrText_lookup(pnrLoctr, pnrCrtnDte);
				String pnrTextString = pnrjBean.call_pnrText_lookup(pnrLoctr, pnrCrtnDte);
				ArrayList pnrTextList = new ArrayList();
				ArrayList pnrList = new ArrayList();
				//check if there was a result in the stored procedure called
				if (pnrTextString.length()==0 || pnrTextString==null) {
					errors.add("listEmpty", new ActionError("error.pnrText.empty"));
//					pnrList = pnrjBean.call_pnr_lookup(pnrLoctr.trim().toUpperCase());
//					frm.setPnrList(pnrList);
				} else {
					int pnrLines = pnrTextString.length()%133 == 0 ? pnrTextString.length()/133 : pnrTextString.length()/133 + 1;
					pnrTextList.addAll(PNRJUtil.getPNRText2Display(pnrLines,  pnrTextString));
					if (pnrTextList.size()> 0){
						String lineOne = (String) pnrTextList.get(0);
						if (lineOne.contains("***PNR HAS MORE THAN 1000 LINES, DISPLAYING FIRST 1000 LINES ONLY.")){
							frm.setOver1000Lines("<A HREF='/SPIL/LongPNRRetriever'>Email PNR</a>");
						}
					}
//					int posLoc = 0;
//					for (int charNum = 0; charNum < pnrLines; charNum++) {
//						if (charNum==pnrLines-1) {
//							pnrTextList.add(pnrTextString.substring(posLoc));
//						} else {
//							pnrTextList.add(pnrTextString.substring(posLoc, posLoc+133));
//							posLoc = posLoc+133;
//						}
//					}
					frm.setShowRedisplay(frm.isShowRedisplay());
				}
				String userId = request.getUserPrincipal().getName(); //to get the authenticated user.
				
				
				//String userIdthatwasentered = request.getRemoteUser(); //to get the authenticated user.
				boolean userinADCredit = request.isUserInRole("querycc"); //to see if this user is in a view-credit-field role
				boolean userinADNoCreditAccs = request.isUserInRole("queryonly"); //to see if this user is in a view-credit-field role
				

				//20080618 -  Issue 4885 - added to check if user currently logged in can view Employee No. field
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
				
//				get the authorizedCC from session
				//KNS - Modified 10/24/2005 for new form based authentication
				
				 //String userAuthorizedCC = (String) request.getSession().getAttribute("userAuthorizedCC");
				 String userAuthorizedCC = "";
				 if(userinADCredit){				 
					 userAuthorizedCC = "TRUE";
				 }else{				 
					 userAuthorizedCC = "FALSE";
				 }		
				 if(userAuthorizedCC == "TRUE"){
					 frm.setUserAuthorizedCC("TRUE");
				 }	
				 else{
					 frm.setUserAuthorizedCC("FALSE");
				 }
				frm.setUserAuthorizedCC(userAuthorizedCC);
				
				// get the authorizedCC from session
				//String userAuthorizedCC = (String) request.getSession().getAttribute("userAuthorizedCC");
				frm.setPnrTextList(pnrTextList);
				generateFOPList(frm, pnrjBean, errors, request, userId);
				
				//20080618 -  Issue 4885 - added to check if user currently logged in can view Employee No. field
				frm.setIsAllowedOtherPnr(CustomValidationRules.isAllowedViewOtherPnr(empGroups));
				
			} 
			 catch (Exception e) {
				Logger.log(PNRJ002_LookupDefaultDetailShowAction.class, Logger.LEVEL_ERROR, e.getMessage());
				errorException.add(ActionErrors.GLOBAL_ERROR, new ActionError("pnr.general.exception", e.getMessage()));
				saveErrors(request, errorException);
				link="failure";
				e.printStackTrace();
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
	private void generateFOPList(PNRJ002_lookupDefaultForm frm, PNRJ pnrjBean, ActionErrors errors, HttpServletRequest request, String userId) throws Exception{ 	
		
		if ("TRUE".equals(frm.getUserAuthorizedCC())){
			ArrayList<PNRData> fopList = new ArrayList<PNRData>();
			
			if (frm.isSelectFop() && errors.isEmpty()){
				
				String tmpPnr = "";
				if (frm.getPnrLocator().length() != 0){
					fopList = pnrjBean.call_fop_lookup(userId, frm.getPnrLocator().trim().toUpperCase());		
					tmpPnr = frm.getPnrLocator();		
				}else if (frm.getSelPnrLoctrNum().length() != 0){
					tmpPnr = frm.getSelPnrLoctrNum();		
					fopList = pnrjBean.call_fop_lookup(userId, frm.getSelPnrLoctrNum().trim().toUpperCase());			
				}
				
				//Added by Ajeet to get the real CC number from SOA.
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
		
		ArrayOfString stringArray =  new ArrayOfString();
		stringArray.getString().addAll(tknzdCCNums);//Tokenized credit card numbers
		
		DecodeArrayOfTokensRequest serviceRequest = new DecodeArrayOfTokensRequest();
		serviceRequest.setRequestInfo(pciInfo);
		serviceRequest.setTokenList(stringArray);
					
		DecodeArrayOfTokensResponse	 serviceResponse = proxy.decodeArrayOfTokens(serviceRequest);
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
//							else{
//								//throw new Exception("SOAERROR::SOA service for credit card lookup exception");
//								errors.add("soaError", new ActionError("soa.creditcard.error", "Credit Card number is empty from SOA"));
//								saveErrors(request, errors);
//							}
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
