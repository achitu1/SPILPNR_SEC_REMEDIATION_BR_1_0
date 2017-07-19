package com.delta.jobs;

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

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

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
public class CreditCardEncryptorServlet_Dup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  boolean isJobStarted;
	private static String PROPERTY_FILE_NAME = "creditcard";
	private static String TARGET_CC_FILE_PROPERTY = "cc.target.file.name";
	private static String SOURCE_CC_FILE_PROPERTY = "cc.source.file.name";
	private static String SOURCE_CC_FILE_PROPERTY_LOCAL = "C:\\data\\creditcard.txt";
	private static String TARGET_CC_FILE_PROPERTY_LOCAL = "C:\\data\\CCTokenized.txt";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreditCardEncryptorServlet_Dup() {
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

		SchedulerFactory sf = new StdSchedulerFactory();
		
		try {
			Scheduler sched = sf.getScheduler();
			isJobStarted = sched.isStarted() ;
			System.out.println("is job started :" + isJobStarted);
			String action =request.getParameter("action");
			System.out.println("action :" + action);
			String endpointUrl = null;
			// if not started yet
			CreditCardSchedular schedular = new CreditCardSchedular();
			if (!isJobStarted && action != null && action.equals("start")) {
				String sourceFile  = getPropertyValue(true, SOURCE_CC_FILE_PROPERTY);
				System.out.println(request.getRemoteHost());
				//Int
				if( request.getRemoteHost() == "mspj8103148.delta.rl.delta.com"){
					endpointUrl = "https://webservices-si.delta.com:36518/pcitokenmgr";
				}else if(request.getRemoteHost() == "147.118.129.91"){
					endpointUrl = "https://webservices.delta.com:36518/pcitokenmgr";
				}else{
					Logger.log(CreditCardEncryptorServlet_Dup.class, Logger.LEVEL_ERROR, "Endpoint is null for the host IP:"+request.getRemoteHost());
					endpointUrl = "http://tatla03cfap210.cfdelta.cfrl.delta.com:36518/pcitokenmgr";
				}
				System.out.println(endpointUrl);
				//schedular.startCreditCardSchedular();
				List<String> l = new ArrayList<String>();
				for(int i=0;i<1000;i++){
					if(i%2 == 0)
						l.add("2345678998765432");
					else
						l.add("9876543223456789");
				}
			//	CreditCardEncryptorServlet.getEncryptedCC(l,"f77219",endpointUrl);
				//isJobStarted = true;
			}else if (isJobStarted && action != null && action.equals("stop")){
				schedular.stopCreditCardSchedular();
				//isJobStarted = false;
			}
			if(isJobStarted){
				System.out.println("Job started already " );
			}else{
				System.out.println("Job not started yet");
			}	
		} catch (SchedulerException se) {
			System.out.println(se.toString());
			se.printStackTrace();
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
		if (!isJobStarted){
			out.println("<form method='POST' action='CreditCardEncryptorServlet?action=start'>");
		}else{
			out.println("<form method='POST' action='CreditCardEncryptorServlet?action=stop'>");
		}

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
public static Map<String,String> getEncryptedCC(List<String> creditCardNumbers, String userId, String endpointUrl) throws Exception{
		
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
		
		ArrayOfString stringArray =  new ArrayOfString();
		stringArray.getString().addAll(creditCardNumbers);
		//stringArray.getString().add(creditCardNumber);//credit card number
		String tokenizedCreditCard= null;
		
		LookupArrayOfTokensRequest serviceRequest = new LookupArrayOfTokensRequest();
		serviceRequest.setRequestInfo(pciInfo);
		serviceRequest.setCreditCardNumList(stringArray);
		System.out.println("Input creditCardNumbers Size is : "+creditCardNumbers.size());
		
		LookupArrayOfTokensResponse	 serviceResponse = proxy.lookupArrayOfTokens(serviceRequest);
		Map<String,String> creditMap = null;
		
		if(serviceResponse !=null){
			if(serviceResponse.getLookupArrayOfTokensResult() != null && serviceResponse.getLookupArrayOfTokensResult().getStatusList() != null 
					&& serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem()!= null){
				Logger.log(CreditCardEncryptorServlet_Dup.class, Logger.LEVEL_INFO, serviceResponse.getLookupArrayOfTokensResult().getRawTraceText());
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
		System.out.println("Output creditCardNumbers Map Size is : "+creditMap.size());
		for(Iterator i = creditMap.keySet().iterator();i.hasNext();){
			String key = (String)i.next();
			System.out.println(key+" : "+creditMap.get(key));
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

}