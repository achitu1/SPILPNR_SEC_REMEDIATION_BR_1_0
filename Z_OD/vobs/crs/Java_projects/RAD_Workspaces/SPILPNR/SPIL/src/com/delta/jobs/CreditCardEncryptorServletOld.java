package com.delta.jobs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;


import com.delta.schemas.pci.v1.pciitemstat.PciTokItemStatus;
import com.delta.schemas.pci.v1.requestinfo.PciRequestInfo;
import com.delta.soa.pci.soagov.v1.ArrayOfString;
import com.delta.soa.pci.soagov.v1.LookupArrayOfTokensRequest;
import com.delta.soa.pci.soagov.v1.LookupArrayOfTokensResponse;
import com.delta.soa.pci.soagov.v1.PciTokenMgr;
import com.delta.soa.pci.soagov.v1.PciTokenMgr_Service;
import com.nwa.PRA.logger.Logger;

/**
 * Servlet implementation class CreditCardEncryptorServlet
 */
public class CreditCardEncryptorServletOld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  boolean isJobStarted;
	private static String PROPERTY_FILE_NAME = "creditcard";
	private static String TARGET_CC_FILE_PROPERTY = "cc.target.file.name";
	private static String SOURCE_CC_FILE_PROPERTY = "cc.source.file.name";
	private static String SOURCE_CC_FILE_PROPERTY_LOCAL = "C:\\data\\TPNRCCIx.txt";
	private static String TARGET_CC_FILE_PROPERTY_LOCAL = "C:\\data\\CCTokenized.txt";
	private static String SOURCE_CC_FILE_PROPERTY_PROD =""; 
	private static String SOURCE_CC_FILE_PROPERTY_INT =""; 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreditCardEncryptorServletOld() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Set the content type(MIME Type) of the response.
		 */
		response.setContentType("text/html");
		BufferedReader input = null;
		String endpointUrl = null;
		String line = null; 
		try {
			
			
			String action =request.getParameter("action");
			System.out.println("action :" + action);
			
			if(action != null && action.equals("start")){
				String sourceFile  = null; 
				System.out.println(request.getRemoteHost());
				//Int
				if( request.getRemoteHost() == "mspj8103148.delta.rl.delta.com"){
					endpointUrl = "https://webservices-si.delta.com:36518/pcitokenmgr";
					//sourceFile  =getPropertyValue(true, SOURCE_CC_FILE_PROPERTY_INT);
					sourceFile  =SOURCE_CC_FILE_PROPERTY_INT;
				}else if(request.getRemoteHost() == "147.118.129.91"){
					endpointUrl = "https://webservices.delta.com:36518/pcitokenmgr";
					//sourceFile  =getPropertyValue(true, SOURCE_CC_FILE_PROPERTY_PROD);
					sourceFile  =SOURCE_CC_FILE_PROPERTY_PROD;
				}else{
					Logger.log(CreditCardEncryptorServletOld.class, Logger.LEVEL_ERROR, "Endpoint is null for the host IP:"+request.getRemoteHost());
					endpointUrl = "http://tatla03cfap210.cfdelta.cfrl.delta.com:36518/pcitokenmgr";
					//sourceFile  =getPropertyValue(true, SOURCE_CC_FILE_PROPERTY_LOCAL);
					sourceFile  =SOURCE_CC_FILE_PROPERTY_LOCAL;
				}
				System.out.println("End point:"+endpointUrl);
				System.out.println("Source File:"+sourceFile);			
				
				
				input = new BufferedReader(new FileReader(sourceFile));
				int records =0;
				List<CreditCard> list = new ArrayList<CreditCard>();
				
				while ((line = input.readLine()) != null) {
					//process each line to get the fields
					 
					CreditCard ccard= new CreditCard();
					
					ccard.setPnr(line.substring(0, 6));
					ccard.setPnrCrtnDt(line.substring(7, 17));
					ccard.setCcCode(line.substring(17, 19));
					ccard.setCcNum(line.substring(19, line.length()));
					
					list.add(ccard);
					records = records+1;
					if(records==1000){
						CreditCardEncryptorServletOld.getEncryptedCC(list,"SPL",endpointUrl);
						list = new ArrayList<CreditCard>();
						records = 0;
					}
				}
				
				if(records>0){
					CreditCardEncryptorServletOld.getEncryptedCC(list,"SPL",endpointUrl);
					//list = new ArrayList<String>();
				}			
			}else if(action != null && action.equals("stop")){
				destroy();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		/*
		 * Write the HTML to the response
		 */
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Credit Encryption Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<form method='POST' action='CreditCardEncryptorServlet?action=start'>");
	
		out.println("<form method='POST' action='CreditCardEncryptorServlet?action=stop'>");
		
		out.println("<table border='1'>");
		out.println("<tbody>");
		
		out.println("<tr>");
		out
				.println("<td><label for='name'>Click Submit Button to start the job </label></td>");
		if(!isJobStarted){
		out
				.println("<td><input type='submit' value='Start Job'> </td></tr>");
	
		}else{
		out.println("<tr>");
		out
				.println("<td><label for='name'>Click Stop Button to stop the job </label></td>");
		out
				.println("<td><input type='submit' value='Stop Job'></td></tr>");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		//response.sendRedirect(request.getContextPath()+"/CreditCardEncryptorServlet");

	}

	public void destroy() {

	}
	

@SuppressWarnings("unchecked")
public static Map<String,String> getEncryptedCC(List<CreditCard> creditCards, String userId, String endpointUrl) throws Exception{
		
		PciTokenMgr_Service service = new PciTokenMgr_Service();
		PciTokenMgr proxy = service.getPciTokenMgrEP();
		if(userId == null){
			userId = "SPILJOB";
		}
		 
		Map<String, Object> ctxt = ((BindingProvider)proxy ).getRequestContext();
		ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
		PciRequestInfo pciInfo =  new PciRequestInfo();
		pciInfo.setAgentDutyCode(userId);
		pciInfo.setAgentSineCode(userId);
		pciInfo.setAppChannelName("SPL");
		pciInfo.setAppCompanyName("Northwest Airlines");
		//pciInfo.setBackendHostId("ZOS");
		pciInfo.setAppVersion("1.1");
		pciInfo.setIsAppInternal(true);
		pciInfo.setIsDebugInfoRequested(true);
		
		ArrayList<String> creditCardNumbers = new ArrayList<String>();
		for(int i =0; i<creditCards.size();i++){
			creditCardNumbers.add(((CreditCard)creditCards.get(i)).getCcNum());
		}
		System.out.println("Input  Size is : "+creditCardNumbers.size());
		ArrayOfString stringArray =  new ArrayOfString();
		stringArray.getString().addAll(creditCardNumbers);
		//stringArray.getString().add(creditCardNumber);//credit card number
		String tokenizedCreditCard= null;
		
		LookupArrayOfTokensRequest serviceRequest = new LookupArrayOfTokensRequest();
		serviceRequest.setRequestInfo(pciInfo);
		serviceRequest.setCreditCardNumList(stringArray);
		
		
		LookupArrayOfTokensResponse	 serviceResponse = proxy.lookupArrayOfTokens(serviceRequest);
		Map<String,String> creditMap = null;
		
		if(serviceResponse !=null){
			if(serviceResponse.getLookupArrayOfTokensResult() != null && serviceResponse.getLookupArrayOfTokensResult().getStatusList() != null 
					&& serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem()!= null){
				Logger.log(CreditCardEncryptorServletOld.class, Logger.LEVEL_INFO, serviceResponse.getLookupArrayOfTokensResult().getRawTraceText());
				List<PciTokItemStatus> list = serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem();
				//ArrayOfPciTokItemStatus PciTokItemStatus= serviceResponse.getLookupArrayOfTokensResult().getStatusList();
				
			
				
				if(list != null && !list.isEmpty()){
					creditMap = new HashMap();
					for(Iterator<PciTokItemStatus> i =list.iterator();i.hasNext();){
						PciTokItemStatus status = (PciTokItemStatus)i.next();
						
						if(status.getToken() != null){
							tokenizedCreditCard= status.getToken().getFullToken();
						}
						creditMap.put(status.getCreditCardNumber().getFullCardNumber(), tokenizedCreditCard);
					}
				}else{
					throw new Exception("SOAERROR::SOA service for credit card lookup exception");
				}
				
			}else{
				throw new Exception("SOAERROR::SOA service for credit card lookup exception");
			}
			
		}else{
			throw new Exception("SOAERROR::SOA service for credit card lookup response was null.");
		}
				
				//PciTokItemStatus status = (PciTokItemStatus)serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem().get(0);
//				if(status.getToken() != null){
//					tokenizedCreditCard= status.getToken().getFullToken();
//					System.out.println("tokenizedCreditCard :"+tokenizedCreditCard);
//				
//					if(tokenizedCreditCard != null && tokenizedCreditCard.trim().length()>0 & ccCde != null){
//						//once you get the tokenized credit card info, send the same to DB to get the PNR data.
//						pnrList = pnrjBean.call_cc_lookup(ccCde,tokenizedCreditCard);
//					}else{
//						Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_ERROR, "tokenizedCreditCard is empty");
//						throw new Exception("SOAERROR::SOA service for credit card lookup exception");
//					}
//				
//					if (!pnrList.isEmpty()){
//						pnrList = pnrjBean.call_default_lookup_detail(pnrList);
//					}
//					
//				}else{
//					throw new Exception("SOAERROR::SOA service for credit card lookup exception");
//				}
//				
//			}else{
//				throw new Exception("SOAERROR::SOA service for credit card lookup exception");
//			}
//			
//		}else{
//			throw new Exception("SOAERROR::SOA service for credit card lookup response was null.");
//		}
		System.out.println("Output  Map Size is : "+creditMap.size());
		List<CreditCard> newList = new ArrayList<CreditCard>();
		for(int i =0; i<creditCards.size();i++){
			CreditCard currentCreditCrd = (CreditCard)creditCards.get(i);
			String tokenizedcc = creditMap.get(currentCreditCrd.getCcNum());
			currentCreditCrd.setTknCCNum(tokenizedcc);
			newList.add(currentCreditCrd);
		}
		writeToFile(newList);
		for(Iterator i = creditMap.keySet().iterator();i.hasNext();){
			String key = (String)i.next();
			//System.out.println(key+" : "+creditMap.get(key));
		}
		return creditMap;
	}


public static String getPropertyValue(boolean isLocalMachine,
		String property) throws IOException {

	String propetyValue = null;
	if (isLocalMachine && property != null) {
		if (property.equals(SOURCE_CC_FILE_PROPERTY)) {
			propetyValue = SOURCE_CC_FILE_PROPERTY_LOCAL;
		} else if (property.equals(TARGET_CC_FILE_PROPERTY)) {
			propetyValue = TARGET_CC_FILE_PROPERTY_LOCAL;
		} 
	} else {
		// By default below program looks for property file under SPIL_DATA
		// environment variable.
		propetyValue = EnvironmentSettings.getPropertyValueFromFile(
				PROPERTY_FILE_NAME, property);

	}

	return propetyValue;
}
private static void writeToFile(List<CreditCard> creditCards) {
	BufferedWriter bufferedWriter = null;
	try {
		//bufferedWriter = new BufferedWriter(new FileWriter("TPNRhstFOPCCIx.txt", true));
		bufferedWriter = new BufferedWriter(new FileWriter(TARGET_CC_FILE_PROPERTY_LOCAL));
		for(int i =0; i<creditCards.size();i++){
			bufferedWriter.write(creditCards.get(i).toString());
			bufferedWriter.append(System.getProperty("line.separator"));
		}

	} catch (FileNotFoundException ex) {
		ex.printStackTrace();
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		// Close the BufferedWriter
		try {
			if (bufferedWriter != null) {
				bufferedWriter.flush();
				bufferedWriter.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

}