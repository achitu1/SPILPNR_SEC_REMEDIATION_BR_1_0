package com.delta.jobs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.ws.BindingProvider;

import com.delta.PRA.PNRJ.EJB.PNRJBean;
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
public class CreditCardEncryptorSOAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Context ctx = null;
	private final String DATA_SOURCE = "jdbc/ds2";
	private Connection conn = null;
	boolean committed = false;
	
	private static String SOURCE_SPIL_FILE_PROPERTY = System
	.getProperty("NWA_DATA")
	+ "/CreditCardEncryption.txt";

private static String INSERT_SQL = "INSERT INTO DB2CRS.T_PNRHST_IX_FOPCC (PNR_LOCTR_NUM,PNR_CRTN_DTE,CC_CO_CDE,CC_NUM,GDS_CDE) VALUES (?,?,?,?,?)";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreditCardEncryptorSOAServlet() {
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
		PreparedStatement stmt = null;
		
		try {
			input = new BufferedReader(
					new FileReader(SOURCE_SPIL_FILE_PROPERTY));

			long totalNoOfRecords = 0;
			String line = null;
			int noOfRecords = 0;
			while ((line = input.readLine()) != null) {
				if (line.trim().length() >= 31) {

					noOfRecords = noOfRecords + 1;
					if (noOfRecords == 1) {
						committed = false;
					}
					String pnr = line.substring(0, 6);
					String cdate = line.substring(6, 14);
					String ccode = line.substring(14, 16);
					String ccNum = line.substring(16, line.length());

					if (noOfRecords == 1) {
						committed = false;
						System.out
								.println("Now Started Processing chunk staring with PNR - "
										+ pnr + " " + cdate);
					}
			
					System.out.println(ccNum);
					String CC = CreditCardEncryptorSOAServlet.getEncryptedCC(ccNum, null);
					if (CC != null && CC.trim().equals("")) {
						stmt = conn.prepareStatement(INSERT_SQL);
						stmt.setString(1, pnr);
						java.util.Date formattedDate = convertStringToDate(
								cdate, "yyyymmdd");
						stmt.setDate(2, new java.sql.Date(formattedDate
								.getTime()));

						stmt.setString(3, ccode);
						stmt.setString(4, CC);

						// stmt.executeUpdate();

						if (noOfRecords == 1000) {
							if (!conn.isClosed()) {
								// commit records for every 1000 records.
								conn.commit();
								totalNoOfRecords = totalNoOfRecords
										+ noOfRecords;
								noOfRecords = 0;

							}
						}
					}else{
						System.out.println("tokenized Credit card is  null- " + CC);
					}

				}
			}
			// last few records
			if (noOfRecords > 0) {
				if (conn != null && !conn.isClosed()) {
					conn.commit();
					totalNoOfRecords = totalNoOfRecords + noOfRecords;
					noOfRecords = 0;

				}
			}
			System.out.println("Total Number of records inserted - "
					+ totalNoOfRecords);
					
			
		}catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception"+e.toString());
			e.printStackTrace();
		} finally {

			try {
				if (conn != null && !conn.isClosed() && !committed) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			closeResources(null, stmt, conn);
			if (input != null)
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}


	}

	public void destroy() {

	}	

	public Connection getDB2Connection() throws SQLException {
		// Type 4, use this!

		try {
			// if connection is null

			DataSource ds = null;
			if (ctx == null)
				ctx = new InitialContext();

			ds = (DataSource) ctx.lookup(DATA_SOURCE);
			if (ds == null) {
				throw new SQLException(
						"No DB2 Datasource Found for JNDI name :" + DATA_SOURCE);
			}
			conn = ds.getConnection();
			if (conn == null) {
				throw new SQLException(
						"No DB2 connection found for JNDI name :" + DATA_SOURCE);
			}

		} catch (NamingException exception) {
			Logger.log(PNRJBean.class, Logger.LEVEL_ERROR,
					"NamingException caught. Error is "
							+ exception.getMessage());
			throw new SQLException(
					"DB_CONNECT_ERROR:DB2 connection not established");
		} catch (SQLException exception) {
			Logger.log(PNRJBean.class, Logger.LEVEL_ERROR,
					"SQLException caught. Error is " + exception.getMessage());
			throw new SQLException(
					"DB_CONNECT_ERROR:DB2 connection not established");

		}

		return conn;
	}

	private void closeResources(ResultSet rs, Statement s, Connection c) {

		try {
			if (rs != null) {
				rs.close();
			}

			if (s != null) {
				s.close();
			}

			if (c != null && !c.isClosed()) {
				c.setAutoCommit(true);
				c.close();
			}
		} catch (SQLException e) {
			Logger.log(PNRJBean.class, Logger.LEVEL_ERROR,
					"In PNRJBean - error in closing resources "
							+ e.getMessage());
		}
	}

	public static Date convertStringToDate(String stringDate, String format)
			throws ParseException {
		DateFormat df = new SimpleDateFormat(format);
		Date date = df.parse(stringDate);
		return date;
	}	
	
	
public static String getEncryptedCC(String creditCardNumber, String userId) throws Exception{
		
		//String endpointUrl = ConfigurationUtil.getPropertyValueFromEnvironmentSettings(SERVICE_URL);
		String endpointUrl ="https://webservices-si.delta.com:36518/pcitokenmgr";
		//String endpointUrl ="http://tatladmitap53.cfitdelta.cfitrl.delta.com:36518/pcitokenmgr";
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
		stringArray.getString().add(creditCardNumber);//credit card number
		String tokenizedCreditCard= null;
		
		LookupArrayOfTokensRequest serviceRequest = new LookupArrayOfTokensRequest();
		serviceRequest.setRequestInfo(pciInfo);
		serviceRequest.setCreditCardNumList(stringArray);
		System.out.println("creditCardNumber: "+creditCardNumber);
		
		//PciTokenMgr_EPProxy proxy  = new  PciTokenMgr_EPProxy();
		LookupArrayOfTokensResponse	 serviceResponse = proxy.lookupArrayOfTokens(serviceRequest);
		
		String statusCode =serviceResponse.getLookupArrayOfTokensResult().getStatusCode();
		System.out.println(statusCode + " " +serviceResponse.getLookupArrayOfTokensResult().getStatusText());
		if(statusCode == null || statusCode.trim().equals("")){		
			PciTokItemStatus status = (PciTokItemStatus)serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem().get(0);
			System.out.println(status);
			tokenizedCreditCard= status.getToken().getFullToken();
		//	System.out.println("tokenizedCreditCard :"+tokenizedCreditCard);
		}
		return tokenizedCreditCard;
	}

}
