package com.delta.jobs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
public class CreditCardEncryptorServlet_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  boolean isJobStarted;
	private static String PROPERTY_FILE_NAME = "TPNRCCIx_2.txt";
	private static String UNIQUE_CC_FILE= "TPNRUNQCCIx_2.txt";
	//private static String UNIQUE_CC_FILE= "TPNRUNQCCIx.txt";
	static String file =null;
//	static BufferedWriter bufferedWriter = null;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreditCardEncryptorServlet_2() {
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
			System.out.println("Remote Host is :" +request.getRemoteHost());
			if(action != null && action.equals("start")){
				String sourceFile  = null; 
				System.out.println(request.getRemoteHost());
				//Int
//				if( request.getRemoteHost().equals("mspj8103148.delta.rl.delta.com")){
//					endpointUrl = "https://webservices-si.delta.com:36518/pcitokenmgr";
//					sourceFile  =getPropertyValue(false, PROPERTY_FILE_NAME);
//					//sourceFile  =SOURCE_CC_FILE_PROPERTY_INT;
//				}else 
				if(request.getRemoteHost().equals("mspj8103148.delta.rl.delta.com")){
					endpointUrl = "https://webservices.delta.com:36518/pcitokenmgr";
					sourceFile  =getPropertyValue(true, PROPERTY_FILE_NAME);
			
				}else{
					Logger.log(CreditCardEncryptorServlet_2.class, Logger.LEVEL_ERROR, "Endpoint is null for the host IP:"+request.getRemoteHost());
					endpointUrl = "http://tatla03cfap210.cfdelta.cfrl.delta.com:36518/pcitokenmgr";
					sourceFile  =getPropertyValue(true, PROPERTY_FILE_NAME);
		
				}
				System.out.println("End point:"+endpointUrl);
				System.out.println("Source File:"+sourceFile);			
				
				
				input = new BufferedReader(new FileReader(sourceFile));
				long records =0;
				
				//Read from Uniquerecords file
				int count=0;
				List<String> list = null;
				while ((line = input.readLine()) != null) {
					//process each line to get the fields
					if(count == 0){
						list = new ArrayList<String>();
					}
					if(line.trim().length() >0){
							list.add(line.trim());
					}
					count=count+1;
					if(count ==1000){
						System.out.println("Calling SOA for 1000 records");
						CreditCardEncryptorServlet_2.getEncryptedCC(list,"SPL",endpointUrl);
						count =0;
						System.out.println("Records Written to file is; "+(records+1));
					}			
					records = records+1;
					
				}
				System.out.println("No of records in file "+records);
				
				
				if(count>0){
					CreditCardEncryptorServlet_2.getEncryptedCC(list,"SPL",endpointUrl);

				}		
				destroy();
			}else if(action != null && action.equals("stop")){
				destroy();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			destroy();
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
		
		out.println("<form method='POST' action='CreditCardEncryptorServlet_2?action=start'>");
	
	//	out.println("<form method='POST' action='CreditCardEncryptorServlet_2?action=stop'>");
		
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

	private static void writeToFile(StringBuffer sb) throws IOException {
		BufferedWriter	writer = null;
		try {
			if(file == null){
				file =getPropertyValue(false,UNIQUE_CC_FILE);
				System.out.println("Output   File name is  "+file);
			}	
			writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(sb.toString());
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// Close the BufferedWriter
			try {
				if (writer != null) {
					writer.flush();
					writer.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}

	public void destroy() {

	}
	

public static void getEncryptedCC(List<String> creditCards, String userId, String endpointUrl) throws Exception{
		
		PciTokenMgr_Service service = new PciTokenMgr_Service();
		PciTokenMgr proxy = service.getPciTokenMgrEP();
		if(userId == null){
			userId = "PNRJOB";
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
		stringArray.getString().addAll(creditCards);
		//stringArray.getString().add(creditCardNumber);//credit card number
		String tokenizedCreditCard= null;
		
		LookupArrayOfTokensRequest serviceRequest = new LookupArrayOfTokensRequest();
		serviceRequest.setRequestInfo(pciInfo);
		serviceRequest.setCreditCardNumList(stringArray);
		
		
		LookupArrayOfTokensResponse	 serviceResponse = proxy.lookupArrayOfTokens(serviceRequest);
		//Map<String,String> creditMap = null;
		StringBuffer sb = new StringBuffer();
		if(serviceResponse !=null){
			if(serviceResponse.getLookupArrayOfTokensResult() != null && serviceResponse.getLookupArrayOfTokensResult().getStatusList() != null 
					&& serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem()!= null){
				Logger.log(CreditCardEncryptorServlet_2.class, Logger.LEVEL_INFO, serviceResponse.getLookupArrayOfTokensResult().getRawTraceText());
				List<PciTokItemStatus> list = serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem();
				//ArrayOfPciTokItemStatus PciTokItemStatus= serviceResponse.getLookupArrayOfTokensResult().getStatusList();
				
			
				
				if(list != null && !list.isEmpty()){
					//creditMap = new HashMap();
					for(Iterator<PciTokItemStatus> i =list.iterator();i.hasNext();){
						PciTokItemStatus status = (PciTokItemStatus)i.next();
						
						if(status.getToken() != null){
							tokenizedCreditCard= status.getToken().getFullToken();
						}
						//creditMap.put(status.getCreditCardNumber().getFullCardNumber(), tokenizedCreditCard);
						sb.append(status.getCreditCardNumber().getFullCardNumber()+"|"+ tokenizedCreditCard);
						sb.append(System.getProperty("line.separator"));
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
			
		System.out.println("Writing to File : ");
		writeToFile(sb);
		//return creditMap;
	}


public static String getPropertyValue(boolean isLocalMachine,
		String fileName) throws IOException {

	String propetyValue = null;

	propetyValue = System.getProperty("NWA_DATA")+ File.separator +	fileName;

	return propetyValue;
}


}