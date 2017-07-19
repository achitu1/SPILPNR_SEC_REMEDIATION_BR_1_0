package com.delta.PRA.PNRJ.EJB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import com.delta.PRA.PNRJ.data.PNRData;
import com.nwa.PRA.CustExceptions.DBException;
import com.nwa.PRA.DataSourceLocHelper.DataSourceLocator;
import com.nwa.PRA.DataSourceLocHelper.DataSourceLocatorException;
import com.nwa.PRA.logger.Logger;

/**
 * Bean implementation class for Enterprise Bean: PNRJ
 */
public class PNRJBean implements javax.ejb.SessionBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7588228963832659951L;

	private final String DATA_SOURCE = "jdbc/ds2";
	
	private static final String SERVICE_URL = "endpoint.url";
	
	private javax.ejb.SessionContext mySessionCtx;
	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}
	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}
	
	public static Context ctx = null;

	/**
	 * Gets Connection using datasource.
	 *  
	 * @param dataSource
	 * @return
	 * @throws SQLException
	 * Changed by Hari Somagatta to implement the retry logic.
	 */
	private Connection getConnection(String dataSource)
			throws SQLException {

		DataSourceLocator dsl = DataSourceLocator.getInstance();
		DataSource ds = null;
		try {
			ds = dsl.getDataSource(dataSource);
		} catch (DataSourceLocatorException e) {
			e.printStackTrace();
			throw new SQLException("Data Source can  not be found");
		}
		Connection conn = null;
		for (int i=1; i<6; i++){
			try {
				Logger.log(PNRJBean.class, Logger.LEVEL_DEBUG, "In PNRJBean - *** getConnection: Obtaining a connection. Try = " + i);
				conn = ds.getConnection();
				
				conn.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);
				
				Logger.log(PNRJBean.class, Logger.LEVEL_DEBUG, "In PNRJBean - *** getConnection: Connected on try " + i);
				break;
			} catch (SQLException e1) {
				Logger.log(PNRJBean.class, Logger.LEVEL_DEBUG, "In PNRJBean - *** getConnection: Connection failed. Trying to reconnect... ");
				//i++;
				e1.printStackTrace();
				try {
					//let the thread wait for 500 milliseconds before try next attempt.
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
				//throw e1;
			}
		}
		if(conn == null){
			throw new SQLException("Could not establish the Datbase Connection");
		}
		
		return conn;
	}

	public String call_pnrText_lookup(String pnrLoctr, String pnrCrtnDte) throws DBException{
		 
		 String text="";
		 StringBuffer sqlBuffer = new StringBuffer();
		 String creationYearMo=retrievePnrCrtnYearMo(pnrCrtnDte);
						 
		 Connection conn=null;	
		 Statement stmt =null;
		 try {
			conn = getConnection(DATA_SOURCE);
		 } catch (SQLException e1) {
			 e1.printStackTrace();
			throw new DBException("In PNRJBean - method: call_pnrText_lookup failed.", e1);
		 }
		
		 ResultSet rs = null;
		 ArrayList psgrlist = new ArrayList();
	
		 try {
			
			sqlBuffer.append("select PNR_TXT from DB2CRS.T_PNRHST_TXT where  "+
							"PNR_CRTN_YR_MO='"+creationYearMo+"' and PNR_LOCTR_NUM='"+pnrLoctr+"' and PNR_CRTN_DTE='"+pnrCrtnDte+"' order by pnr_txt_seq_num OPTIMIZE FOR 1 ROW");

			String sql = sqlBuffer.toString();
			Logger.log(PNRJBean.class, Logger.LEVEL_DEBUG, "In PNRJBean - method: call_pnrText_lookup- SQL"+sql);
			stmt = conn.createStatement();				
			rs = stmt.executeQuery(sql);
			long i = 0;
			while (rs.next()) {
				 PNRData pnrdata = new PNRData();
				 i=i+1;
				 text = text+rs.getString("PNR_TXT");	
				 psgrlist.add(pnrdata);
			 }
			Logger.log(PNRJBean.class, Logger.LEVEL_DEBUG, "In PNRJBean - method: call_pnrText_lookup- No.of Lines in DB -"+i);
		 } catch(SQLException e){
			 Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_pnrText_lookup failed.");
			 e.printStackTrace();
			 throw new DBException("In PNRJBean - method: call_pnrText_lookup failed.", e);
		 } 
		 finally {
			// closeConnection(conn);
			 closeResources(rs,stmt,conn);
		 }
		 
	 return text;

	 }
	
	public ArrayList call_pnrDetail_lookup(String pnrLocator, String pnrCrtnDte) throws DBException {
		
		Connection conn=null;
		Statement stmt=null;
		try {
			conn = getConnection(DATA_SOURCE);
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DBException("In PNRJBean - method: call_pnrDetail_lookup failed.", e1);
		}
			ResultSet rs = null;
			ArrayList psgrlist = new ArrayList();
		
			try{
				StringBuffer sqlBuffer = new StringBuffer();
				
				sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE, SEG_SCHED_DPTR_DTE, MKT_AL_CDE, FLT_NUM, " +
											"SEG_ORIG_AP_CDE, SEG_DEST_AP_CDE, PSGR_NME, INV_CL_CDE, SEG_STATS_CDE " +
											"from DB2CRS.T_PNRHST_IX_FLT " +
											"where PNR_LOCTR_NUM='"+pnrLocator+"' and PNR_CRTN_DTE='"+pnrCrtnDte+"'" );
				String sql = sqlBuffer.toString();
				Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method call_pnrDetail_lookup: SQL is -" + sql);
				stmt = conn.createStatement();	
				Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method call_pnrDetail_lookup.After createStatement");			
				rs = stmt.executeQuery(sql);
				Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method call_pnrDetail_lookup: after executeQuery call.");									
										
				while (rs.next()) {
					PNRData pnrdata = new PNRData();
					
					pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
					pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
					pnrdata.setPnrTravelDate(rs.getString("SEG_SCHED_DPTR_DTE").trim());
					pnrdata.setPnrMkAlCode(rs.getString("MKT_AL_CDE").trim());
					pnrdata.setPnrFltNum(rs.getString("FLT_NUM").trim());
					pnrdata.setPnrSegOrigApCode(rs.getString("SEG_ORIG_AP_CDE").trim());
					pnrdata.setPnrSegDestApCode(rs.getString("SEG_DEST_AP_CDE").trim());
					pnrdata.setPnrPsngrNme(fitPsgrName(rs.getString("PSGR_NME").trim()));
					pnrdata.setPnrInvClCode(rs.getString("INV_CL_CDE").trim());
					pnrdata.setPnrSegStatusCode(rs.getString("SEG_STATS_CDE").trim());
	
					psgrlist.add(pnrdata);
					} 
				}catch(SQLException e){
					Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method call_pnrDetail_lookup.");
					e.printStackTrace();
					throw new DBException("In PNRJBean - Method call_pnrDetail_lookup failed.", e);   
				}
				finally {
					// closeConnection(conn);
					 closeResources(rs,stmt,conn);
				 }
				return psgrlist;	
		}
	
	//to fix passenger name length.If the passenger name is too length, cut down to 30 characters
	//in <bean:write no option to set the max length, so controlling here.
	private String fitPsgrName(String name) {
		
		if(name != null & name.trim().length()>35){
			return name.substring(0,35);
		}
		return name;
	}
	public ArrayList call_pnr_lookup(String pnrLoctr) throws DBException 
	 {
		 StringBuffer sqlBuffer = new StringBuffer();
		 
		Connection conn=null;
		Statement stmt = null;
		try {
			conn = getConnection(DATA_SOURCE);
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DBException("In PNRJBean - method: call_pnr_lookup failed.", e1);
		}
		 
		 ResultSet rs = null;
		 ArrayList psgrlist = new ArrayList();
		 ArrayList pnrDetailList = new ArrayList();
		
		 try {

			sqlBuffer.append("select distinct PNR_LOCTR_NUM, PNR_CRTN_DTE " +
									"from DB2CRS.T_PNRHST_IX_FLT " +
									"where PNR_LOCTR_NUM='"+pnrLoctr+"'" );
			String sql = sqlBuffer.toString();
			stmt = conn.createStatement();				
			rs = stmt.executeQuery(sql);									
			Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method call_pnr_lookup: after executeQuery call.");	
			 
			 int pnrCount=0;
			 
			 if(pnrCount==1)
			 {
				while (rs.next()) {
					PNRData pnrdata = new PNRData();
						
					pnrDetailList = call_pnrDetail_lookup(rs.getString("PNR_LOCTR_NUM").trim(), rs.getString("PNR_CRTN_DTE").trim(), conn);
	   
					Iterator i = pnrDetailList.iterator();
					 while(i.hasNext())
					 {
					  PNRData p = (PNRData)i.next();
					  psgrlist.add(p);
					 }	
	
					   psgrlist.add(pnrdata);
					   pnrCount++;
				 }
			 }
			 else if (pnrCount!=1)
			 {
				while (rs.next()) {
					PNRData pnrdata = new PNRData();
					
					pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
					pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
					psgrlist.add(pnrdata);					
				}
			 }
			 
		 } catch(SQLException e){
			 //Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - Stored proc DB2CRS.P9801S01 failed.");
			 Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_pnr_lookup failed.");
			 e.printStackTrace();
			 //throw new DBException("In PNRJBean - Stored proc DB2CRS.P9801S01 failed.", e);   
			 throw new DBException("In PNRJBean - method: call_pnr_lookup failed.", e);
		 } finally {
			 //closeConnection(conn);
			 closeResources(rs,stmt,conn);
				
		 }

	 return psgrlist;

	 }
	 			 
	public ArrayList call_name_lookup(String surName, String travelDate, String flightNum, String alCode, String origin, String dest) throws DBException 
		{
			StringBuffer sqlBuffer = new StringBuffer();

			Connection conn=null;	
			Statement stmt = null;
			try {
				conn = getConnection(DATA_SOURCE);
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DBException("In PNRJBean - method: call_name_lookup failed.", e1);
			}
			
			ResultSet rs = null;
			ArrayList psgrlist = new ArrayList();
			
			try {
								
				sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE, SEG_SCHED_DPTR_DTE, MKT_AL_CDE, FLT_NUM, ");
				sqlBuffer.append("SEG_ORIG_AP_CDE, SEG_DEST_AP_CDE, PSGR_NME, INV_CL_CDE, SEG_STATS_CDE ");
				sqlBuffer.append("from DB2CRS.T_PNRHST_IX_FLT ");
				sqlBuffer.append("where SEG_SCHED_DPTR_DTE='"+travelDate+"' and PSGR_NME like '"+surName+"%'");
				
				if (flightNum != null && !flightNum.equals("")) {
					sqlBuffer.append(" and FLT_NUM='" + flightNum + "'");
				}
				if (alCode != null && !alCode.equals("")) {
					sqlBuffer.append(" and MKT_AL_CDE='" + alCode + "'");
				}
				if (origin != null && !origin.equals("")) {
					sqlBuffer.append(" and SEG_ORIG_AP_CDE='" + origin + "'");
				}
				if (dest != null && !dest.equals("")) {
					sqlBuffer.append(" and SEG_DEST_AP_CDE='" + dest + "'");
				}

				String sql = sqlBuffer.toString();
				
				stmt = conn.createStatement();				
				rs = stmt.executeQuery(sql);
				
				
				while (rs.next()) {
					PNRData pnrdata = new PNRData();
									
					pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
					pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
					pnrdata.setPnrTravelDate(rs.getString("SEG_SCHED_DPTR_DTE").trim());
					pnrdata.setPnrMkAlCode(rs.getString("MKT_AL_CDE").trim());
					pnrdata.setPnrFltNum(rs.getString("FLT_NUM").trim());
					pnrdata.setPnrSegOrigApCode(rs.getString("SEG_ORIG_AP_CDE").trim());
					pnrdata.setPnrSegDestApCode(rs.getString("SEG_DEST_AP_CDE").trim());
					pnrdata.setPnrPsngrNme(fitPsgrName(rs.getString("PSGR_NME").trim()));
					pnrdata.setPnrInvClCode(rs.getString("INV_CL_CDE").trim());
					pnrdata.setPnrSegStatusCode(rs.getString("SEG_STATS_CDE").trim());
					
					psgrlist.add(pnrdata);
				}
			} catch(SQLException e){
				//Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - Stored proc DB2CRS.P9701S03 failed.");
				Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_name_lookup failed.");
				e.printStackTrace();
				//throw new DBException("In PNRJBean - Stored proc DB2CRS.P9701S03 failed.", e);   
				throw new DBException("In PNRJBean - method: call_name_lookup failed.", e);
			} finally {
				// closeConnection(conn);
				 closeResources(rs,stmt,conn);
			 }
		
		return psgrlist;	
		}
	public ArrayList call_name_lookup_range(String surName, String travelDate, String flightNum, String alCode, String origin, String dest) throws DBException 
	{
		StringBuffer sqlBuffer = new StringBuffer();

		Connection conn=null;	
		Statement stmt = null;
		try {
			conn = getConnection(DATA_SOURCE);
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DBException("In PNRJBean - method: call_name_lookup_range failed.", e1);
		}
		
		ResultSet rs = null;
		ArrayList psgrlist = new ArrayList();
		
		try {
							
			sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE, SEG_SCHED_DPTR_DTE, MKT_AL_CDE, FLT_NUM, ");
			sqlBuffer.append("SEG_ORIG_AP_CDE, SEG_DEST_AP_CDE, PSGR_NME, INV_CL_CDE, SEG_STATS_CDE ");
			sqlBuffer.append("from DB2CRS.T_PNRHST_IX_FLT ");
			sqlBuffer.append("where (SEG_SCHED_DPTR_DTE='" + travelDate + "' ");
			sqlBuffer.append("or SEG_SCHED_DPTR_DTE='" + getNextDate(travelDate, 1) + "' ");
			sqlBuffer.append("or SEG_SCHED_DPTR_DTE='" + getNextDate(travelDate, -1) + "' ");
			sqlBuffer.append(") and PSGR_NME like '"+surName+"%'");
			
			if (flightNum != null && !flightNum.equals("")) {
				sqlBuffer.append(" and FLT_NUM='" + flightNum + "'");
			}
			if (alCode != null && !alCode.equals("")) {
				sqlBuffer.append(" and MKT_AL_CDE='" + alCode + "'");
			}
			if (origin != null && !origin.equals("")) {
				sqlBuffer.append(" and SEG_ORIG_AP_CDE='" + origin + "'");
			}
			if (dest != null && !dest.equals("")) {
				sqlBuffer.append(" and SEG_DEST_AP_CDE='" + dest + "'");
			}

			String sql = sqlBuffer.toString();
			
			stmt = conn.createStatement();				
			rs = stmt.executeQuery(sql);
			
			
			while (rs.next()) {
				PNRData pnrdata = new PNRData();
								
				pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
				pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
				pnrdata.setPnrTravelDate(rs.getString("SEG_SCHED_DPTR_DTE").trim());
				pnrdata.setPnrMkAlCode(rs.getString("MKT_AL_CDE").trim());
				pnrdata.setPnrFltNum(rs.getString("FLT_NUM").trim());
				pnrdata.setPnrSegOrigApCode(rs.getString("SEG_ORIG_AP_CDE").trim());
				pnrdata.setPnrSegDestApCode(rs.getString("SEG_DEST_AP_CDE").trim());
				pnrdata.setPnrPsngrNme(fitPsgrName(rs.getString("PSGR_NME").trim()));
				pnrdata.setPnrInvClCode(rs.getString("INV_CL_CDE").trim());
				pnrdata.setPnrSegStatusCode(rs.getString("SEG_STATS_CDE").trim());
				
				psgrlist.add(pnrdata);
			}
		} catch(SQLException e){
			//Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - Stored proc DB2CRS.P9701S03 failed.");
			Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_name_lookup failed.");
			e.printStackTrace();
			//throw new DBException("In PNRJBean - Stored proc DB2CRS.P9701S03 failed.", e);   
			throw new DBException("In PNRJBean - method: call_name_lookup failed.", e);
		} finally {
			// closeConnection(conn);
			 closeResources(rs,stmt,conn);
		 }
	
	return psgrlist;	
	}	
	  public ArrayList call_airline_flightnum_lookup(String airLine, String flightNum, String travelDate, String surName, String origin, String dest) throws DBException 
		  {
			  StringBuffer sqlBuffer = new StringBuffer();
			
			Connection conn=null;		
			Statement stmt = null;
			try {
				conn = getConnection(DATA_SOURCE);
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DBException("In PNRJBean - method: call_airline_flightnum_lookup failed.", e1);
			}
			
			  ResultSet rs = null;
			  ArrayList psgrlist = new ArrayList();
			
			  try {
								  
				  sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE, SEG_SCHED_DPTR_DTE, MKT_AL_CDE, FLT_NUM, ");
				  sqlBuffer.append("SEG_ORIG_AP_CDE, SEG_DEST_AP_CDE, PSGR_NME, INV_CL_CDE, SEG_STATS_CDE ");
				  sqlBuffer.append("from DB2CRS.T_PNRHST_IX_FLT ");
				  sqlBuffer.append("where SEG_SCHED_DPTR_DTE='"+travelDate+"' and MKT_AL_CDE='"+airLine+"' and FLT_NUM='"+flightNum+"'" );
				  
				  if (surName != null && !surName.equals("")) {
					sqlBuffer.append(" and PSGR_NME like '" + surName + "%'");
				  }
				  if (origin != null && !origin.equals("")) {
					sqlBuffer.append(" and SEG_ORIG_AP_CDE='" + origin + "'");
				  }
				  if (dest != null && !dest.equals("")) {
					sqlBuffer.append(" and SEG_DEST_AP_CDE='" + dest + "'");
				  }

				  String sql = sqlBuffer.toString();
				  stmt = conn.createStatement();				
				  rs = stmt.executeQuery(sql);
								
				  while (rs.next()) {
					  PNRData pnrdata = new PNRData();
								
					  pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
					  pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
					  pnrdata.setPnrTravelDate(rs.getString("SEG_SCHED_DPTR_DTE").trim());
					  pnrdata.setPnrMkAlCode(rs.getString("MKT_AL_CDE").trim());
					  pnrdata.setPnrFltNum(rs.getString("FLT_NUM").trim());
					  pnrdata.setPnrSegOrigApCode(rs.getString("SEG_ORIG_AP_CDE").trim());
					  pnrdata.setPnrSegDestApCode(rs.getString("SEG_DEST_AP_CDE").trim());
					  pnrdata.setPnrPsngrNme(fitPsgrName(rs.getString("PSGR_NME").trim()));
					  pnrdata.setPnrInvClCode(rs.getString("INV_CL_CDE").trim());
					  pnrdata.setPnrSegStatusCode(rs.getString("SEG_STATS_CDE").trim());
					  
					  psgrlist.add(pnrdata);
				  }
			  } catch(SQLException e){
				  //Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - Stored proc DB2CRS.P9701S02 failed.");
				  Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_airline_flightnum_lookup failed.");
				  e.printStackTrace();
				  //throw new DBException("In PNRJBean - Stored proc DB2CRS.P9701S02 failed.", e);   
				  throw new DBException("In PNRJBean - method: call_airline_flightnum_lookup failed.", e);
			  } finally {
					// closeConnection(conn);
					 closeResources(rs,stmt,conn);
				}
		
		  return psgrlist;	
		  }
	
	public ArrayList call_cc_lookup(String userId, String ccCode, String ccNum) throws DBException  {
				
				Connection conn=null; 
				try {
					conn = getConnection(DATA_SOURCE);
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new DBException("In PNRJBean - method: call_cc_lookup failed.", e1);
				}
			
				 CallableStatement cs = null;
				 ResultSet rs = null;
				 ArrayList psgrlist = new ArrayList();
				
				 try {
		
					cs = conn.prepareCall("{CALL DB2CRS.CRSSP001(?,?,?,?,?, ?,?,?,?,?)}"); 	//edited (20040414)
					//P9704S02 -old procedure
					//CRSSP001 - new procedure
					cs.setString(1, userId.trim());
					cs.setString(2, ccCode.trim());
					cs.setString(3, ccNum.trim());
					cs.registerOutParameter(4, java.sql.Types.INTEGER);
					cs.registerOutParameter(5, java.sql.Types.CHAR);
					
					//additional SP changes (20040414)
					cs.registerOutParameter(6, java.sql.Types.CHAR);
					cs.registerOutParameter(7, java.sql.Types.CHAR);
					cs.registerOutParameter(8, java.sql.Types.CHAR);
					cs.registerOutParameter(9, java.sql.Types.CHAR);
					cs.registerOutParameter(10, java.sql.Types.CHAR);
					
					cs.execute();
					rs = cs.getResultSet();
					Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - CRSSP001 executed.");	
					while (rs.next()){						
						PNRData pnrdata = new PNRData();
						pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
						pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
						
						psgrlist.add(pnrdata);

					}
					 
				 } catch(SQLException e){
					 //Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - Stored proc DB2CRS.P9704S02 failed.");
					 Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_cc_lookup failed.");
					 e.printStackTrace();
					 //throw new DBException("In PNRJBean - Stored proc DB2CRS.P9704S02 failed.", e);   
					 throw new DBException("In PNRJBean - method: call_cc_lookup failed.", e);
				 } finally {
					// closeConnection(conn);
					 if(cs != null){
						 try {
							cs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					 }
					 closeResources(rs,null,conn);
					 
				 }
		
			 return psgrlist;	
			 } 
	 
	  
	  public ArrayList call_cc_lookup(String ccCode,String tokenizedCreditcard) throws DBException  {
			
			Connection conn=null; 		
			StringBuffer sqlBuffer = new StringBuffer();
			Statement stmt = null;			
						
			try {
				conn = getConnection(DATA_SOURCE);
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DBException("In PNRJBean - method: call_cc_lookup getConnection() -failed.", e1);
			}
		
			 ResultSet rs = null;
			 ArrayList psgrlist = new ArrayList();
			
			 try {
			
			
				stmt = conn.createStatement();				
//				 rs = stmt.executeQuery("select PNR_LOCTR_NUM, PNR_CRTN_DTE from DB2CRS.T_PNRHST_IX_FOPCC " +
//												 "where CC_CO_CDE='"+ccCode+"' and CC_NUM='"+ccNum+"'");
				sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE from DB2CRS.T_PNRHST_IX_FOPCC " +
						 "where CC_CO_CDE='"+ccCode+"' AND CC_NUM='"+tokenizedCreditcard+"'");
				 rs = stmt.executeQuery(sqlBuffer.toString());
				
				Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - call_cc_lookup with Tokenized CC executed.");	
				while (rs.next()){						
					PNRData pnrdata = new PNRData();
					pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
					pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
					
					psgrlist.add(pnrdata);

				}				
				 
			 } catch(SQLException e){
				 Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_cc_lookup failed.");
				 e.printStackTrace();  
				 throw new DBException("In PNRJBean - method: call_cc_lookup failed.", e);
			 } finally {
					// closeConnection(conn);
				 closeResources(rs,stmt,conn);
			 }
	
		 return psgrlist;	
		 }
	  
	  
	  
	  /*
	  public ArrayList call_fop_lookupFromSOA(String userId, String pnrLoctrNum) throws DBException{
			
			
			 try {
				 String endpointUrl = ConfigurationUtil.getPropertyValueFromEnvironmentSettings(SERVICE_URL);
					
					
					PciTokenMgr_Service service = new PciTokenMgr_Service();
					PciTokenMgr proxy = service.getPciTokenMgrEP();
					 
					Map<String, Object> ctxt = ((BindingProvider)proxy ).getRequestContext();
					ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
					
					PciRequestInfo pciInfo =  new PciRequestInfo();
					pciInfo.setAgentDutyCode(userId);
					pciInfo.setAgentSineCode(userId);
					pciInfo.setAppChannelName("SPIL/PNR");
					pciInfo.setAppCompanyName("Northwest Airlines");
					pciInfo.setAppVersion("1.1");
					pciInfo.setIsAppInternal(true);
					pciInfo.setIsDebugInfoRequested(false);
					
					ArrayOfString stringArray =  new ArrayOfString();
					stringArray.getString().add(frm.getCreditCardNumber());//credit card number
					
					
					LookupArrayOfTokensRequest serviceRequest = new LookupArrayOfTokensRequest();
					serviceRequest.setRequestInfo(pciInfo);
					serviceRequest.setCreditCardNumList(stringArray);
					
					
					//PciTokenMgr_EPProxy proxy  = new  PciTokenMgr_EPProxy();
					LookupArrayOfTokensResponse	 serviceResponse = proxy.lookupArrayOfTokens(serviceRequest);
					Logger.log(PNRJBean.class, Logger.LEVEL_INFO, serviceResponse.getLookupArrayOfTokensResult().getRawTraceText());
					PciTokItemStatus status = (PciTokItemStatus)serviceResponse.getLookupArrayOfTokensResult().getStatusList().getStatusItem().get(0);
					System.out.println(status.getToken().getFullToken());

					String tokenizedCreditCard= status.getToken().getFullToken();
				
				
				
				if (pnrCount != 0){
									
					for (int x = 0; x < pnrCount; x++){
									
						PNRData pnrdata = new PNRData();
						pnrdata.setPnrLoctrNum(pnrLoctrNum);
						pnrdata.setPnrCrtnDate(cs.getString(dateCount));
						pnrdata.setPnrCCCode(cs.getString(codeCount));
						pnrdata.setPnrCCNum(cs.getString(ccCount));						 
						pnrdata.setPnrCreditCard(pnrdata.getPnrCCCode() + pnrdata.getPnrCCNum());
						psgrlist.add(pnrdata);
						
						dateCount++;
						codeCount++;
						ccCount++;
					}
				}
	
			 } catch(SQLException e){
				 Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_fop_lookup failed.");
				 e.printStackTrace();
				 throw new DBException("In PNRJBean - method: call_fop_lookup failed.", e);
			 } finally {
				// closeConnection(conn);
				 if(cs != null){
					 try {
						cs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				 }
				 closeResources(null,null,conn);
			 }
	
		 return psgrlist;	
		 }  */

	public ArrayList call_fop_lookup(String userId, String pnrLoctrNum) throws DBException{
		
				Connection conn=null;
				ResultSet rs = null;
				try {
					conn = getConnection(DATA_SOURCE);
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new DBException("In PNRJBean - method: call_fop_lookup failed.", e1);
				}
			
//				 CallableStatement cs = null;
				 ArrayList psgrlist = new ArrayList();
				 StringBuffer sqlBuffer = new StringBuffer();
				 try {
					
//					cs = conn.prepareCall("{CALL DB2CRS.CRSSP002(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}");	//edited (20080414)
//					//P9704S01 -old procedure
//					//CRSSP002 - new procedure
//					cs.setString(1, userId.trim());
//					cs.setString(2, pnrLoctrNum.trim());
//					cs.registerOutParameter(3, java.sql.Types.INTEGER);
//					cs.registerOutParameter(4, java.sql.Types.CHAR);
//					
//					//additional SP changes (20080414)
//					cs.registerOutParameter(5, java.sql.Types.CHAR);
//					cs.registerOutParameter(6, java.sql.Types.CHAR);
//					cs.registerOutParameter(7, java.sql.Types.CHAR);
//					cs.registerOutParameter(8, java.sql.Types.CHAR);
//					cs.registerOutParameter(9, java.sql.Types.CHAR);
//					
//					cs.registerOutParameter(10, java.sql.Types.INTEGER);
//					
//					cs.registerOutParameter(11, java.sql.Types.CHAR);
//					cs.registerOutParameter(12, java.sql.Types.CHAR);
//					cs.registerOutParameter(13, java.sql.Types.CHAR);
//					cs.registerOutParameter(14, java.sql.Types.CHAR);
//					cs.registerOutParameter(15, java.sql.Types.CHAR);
//					cs.registerOutParameter(16, java.sql.Types.CHAR);
//					
//					cs.registerOutParameter(17, java.sql.Types.CHAR);
//					cs.registerOutParameter(18, java.sql.Types.CHAR);
//					cs.registerOutParameter(19, java.sql.Types.CHAR);
//					cs.registerOutParameter(20, java.sql.Types.CHAR);
//					cs.registerOutParameter(21, java.sql.Types.CHAR);
//					cs.registerOutParameter(22, java.sql.Types.CHAR);
//					
//					cs.registerOutParameter(23, java.sql.Types.CHAR);
//					cs.registerOutParameter(24, java.sql.Types.CHAR);
//					cs.registerOutParameter(25, java.sql.Types.CHAR);
//					cs.registerOutParameter(26, java.sql.Types.CHAR);
//					cs.registerOutParameter(27, java.sql.Types.CHAR);
//					cs.registerOutParameter(28, java.sql.Types.CHAR);
//				
//					//cs.executeQuery();
//					cs.executeUpdate();
//					Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - DB2CRS.P9704S01 executed.");	
//		
//					//edited (20080414)
//					int pnrCount = cs.getInt(10); 
//					int dateCount =11;
//					int codeCount = 17;
//					int ccCount = 23;
					
//					if (pnrCount != 0){
//										
//						for (int x = 0; x < pnrCount; x++){
//										
//							PNRData pnrdata = new PNRData();
//							pnrdata.setPnrLoctrNum(pnrLoctrNum);
//							pnrdata.setPnrCrtnDate(cs.getString(dateCount));
//							pnrdata.setPnrCCCode(cs.getString(codeCount));
//							pnrdata.setPnrCCNum(cs.getString(ccCount));						 
//							pnrdata.setPnrCreditCard(pnrdata.getPnrCCCode() + pnrdata.getPnrCCNum());
//							psgrlist.add(pnrdata);
//							
//							dateCount++;
//							codeCount++;
//							ccCount++;
//						}
//					}
				
					sqlBuffer.append("select PNR_CRTN_DTE, CC_CO_CDE, CC_NUM from DB2CRS.T_PNRHST_IX_FOPCC " +
									 "where PNR_LOCTR_NUM='"+pnrLoctrNum+"'");
					String sql = sqlBuffer.toString();
					Statement stmt = conn.createStatement();				
					rs = stmt.executeQuery(sql);
													 
					 while (rs.next()) {

						PNRData pnrdata = new PNRData();
						pnrdata.setPnrLoctrNum(pnrLoctrNum);
						pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
						pnrdata.setPnrCCCode(rs.getString("CC_CO_CDE").trim());
						pnrdata.setPnrCCNum(rs.getString("CC_NUM").trim());						 
						pnrdata.setPnrCreditCard(pnrdata.getPnrCCCode() + pnrdata.getPnrCCNum());
						psgrlist.add(pnrdata);
						
					 }
					 
					// end of changes (20080319)
				 } catch(SQLException e){
					 Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_fop_lookup failed.");
					 e.printStackTrace();
					 throw new DBException("In PNRJBean - method: call_fop_lookup failed.", e);
				 } finally {
					// closeConnection(conn);
//					 if(cs != null){
//						 try {
//							cs.close();
//						} catch (SQLException e) {
//							e.printStackTrace();
//						}
//					 }
					 closeResources(null,null,conn);
				 }
		
			 return psgrlist;	
			 }
			 	
	public ArrayList call_employee_lookup(String empNum) throws DBException 
				 {
					Connection conn=null;
					Statement stmt = null;
					try {
						conn = getConnection(DATA_SOURCE);
					} catch (SQLException e1) {
						e1.printStackTrace();
						throw new DBException("In PNRJBean - method: call_employee_lookup failed.", e1);
					}
					
					 ResultSet rs = null;
					 ArrayList psgrlist = new ArrayList();
					
					
					 try {
						 
						//KNS - updated 1/25/2006 //
						StringBuffer sqlBuffer = new StringBuffer();
						sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE from DB2CRS.T_PNRHST_IX_FOPEMP where EMP_NUM='"+empNum+"'");
						String sql = sqlBuffer.toString();
						Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method: call_employee_lookup: SQL executing is: "+sql);
						Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method: call_employee_lookup: before createStatement command");
						stmt = conn.createStatement();				
						Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method: call_employee_lookup: before executeQuery command");
						rs = stmt.executeQuery(sql);
						Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method: call_employee_lookup: after executeQuery command"); 
						
				
						 while (rs.next()) {
							
							 PNRData pnrdata = new PNRData();	
							 pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
							 pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
							 
							 psgrlist.add(pnrdata);
						 }
					 } catch(SQLException e){
						 //Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - Stored proc DB2CRS.P9705S01 failed.");
						 Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_employee_lookup failed.");
						 e.printStackTrace();
						 //throw new DBException("In PNRJBean - Stored proc DB2CRS.P9705S01 failed.", e);   
						 throw new DBException("In PNRJBean - method: call_employee_lookup failed.", e);
					 } finally {
							// closeConnection(conn);
						 closeResources(rs,stmt,conn);
					 }
		
				 return psgrlist;	
				 }


	public ArrayList call_tkt_lookup(String tktnum) throws DBException 
			  {
				  StringBuffer sqlBuffer = new StringBuffer();
				  
				Connection conn=null;
				Statement stmt = null;
				try {
					conn = getConnection(DATA_SOURCE);
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new DBException("In PNRJBean - method: call_tkt_lookup failed.", e1);
				}
				  
				  ResultSet rs = null;
				  ArrayList psgrlist = new ArrayList();
			
				  try {
				
					  sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE from DB2CRS.T_PNRHST_IX_TKT " +
										 "where TKT_NUM='"+tktnum+"'");
					  String sql = sqlBuffer.toString();
					  stmt = conn.createStatement();				
					  rs = stmt.executeQuery(sql);
					  				
					  while (rs.next()) {

						  PNRData pnrdata = new PNRData();
						  
						  //pnrDetailList = call_pnrDetail_lookup(rs.getString("PNR_LOCTR_NUM").trim(), rs.getString("PNR_CRTN_DTE").trim(), conn);		
						  pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
						  pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
					
						psgrlist.add(pnrdata);
					  }
				  } catch(SQLException e){
					  //Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - Stored proc DB2CRS.P9703S01 failed.");
					  Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_tkt_lookup failed.");
					  e.printStackTrace();
					  //throw new DBException("In PNRJBean - Stored proc DB2CRS.P9703S01 failed.", e);   
					  throw new DBException("In PNRJBean - method: call_tkt_lookup failed.", e);
				  } finally {
						// closeConnection(conn);
						 closeResources(rs,stmt,conn);
					}
		
			  return psgrlist;	
			  }

	/**
	 * call_tkt_lookup
	 * @param pnrList
	 * @return
	 * @throws DBException
	 */
	public ArrayList call_default_lookup_detail(ArrayList pnrList) throws DBException {

			Connection conn=null;
			try {
				conn = getConnection(DATA_SOURCE);
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DBException("In PNRJBean - method: call_default_lookup_detail failed.", e1);
			}
			ArrayList psgrlist = new ArrayList();
			ArrayList pnrDetailList = new ArrayList();
			
			try {
			
				for(int i = 0; i < pnrList.size(); i++){

					PNRData pnrdata = (PNRData)pnrList.get(i);
					pnrDetailList = call_pnrDetail_lookup(pnrdata.getPnrLoctrNum(), pnrdata.getPnrCrtnDate(), conn);	

					if (!pnrDetailList.isEmpty()) {
						psgrlist.addAll(pnrDetailList);								
					}
				}
			} finally {
				// closeConnection(conn);
				 closeResources(null,null,conn);
			 }
		
			return psgrlist;	
	}
		
	public ArrayList call_freqflier_lookup(String frqflierid, String freqfliernum) throws DBException 
			{
				StringBuffer sqlBuffer = new StringBuffer();

				Connection conn=null;
				Statement stmt = null;
				try {
					conn = getConnection(DATA_SOURCE);
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new DBException("In PNRJBean - method: call_freqflier_lookup failed.", e1);
				}
			
				ResultSet rs = null;
				ArrayList psgrlist = new ArrayList();
			
				try {
				
					sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE from DB2CRS.T_PNRHST_IX_FF " +
										   "where FREQFLR_MLG_AL_CDE='"+frqflierid+"' and FREQ_FLR_ID='"+freqfliernum+"'");
					String sql = sqlBuffer.toString();
					stmt = conn.createStatement();				
					rs = stmt.executeQuery(sql);
					
				
					while (rs.next()) {
						
						PNRData pnrdata = new PNRData();
						pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
						pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
						
						psgrlist.add(pnrdata);
					}
				} catch(SQLException e){
					//Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - Stored proc DB2CRS.P9702S01 failed.");
					Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_freqflier_lookup failed.");
					e.printStackTrace();
					//throw new DBException("In PNRJBean - Stored proc DB2CRS.P9702S01 failed.", e);   
					throw new DBException("In PNRJBean - method: call_freqflier_lookup failed.", e);
				} finally {
					// closeConnection(conn);
					 closeResources(rs,stmt,conn);
				 }
		
			return psgrlist;	
			}
			

	public ArrayList call_origdest_lookup(String origin, String destination, String travelDate, String surName, String alCode, String flightNum) throws DBException 
		{
			StringBuffer sqlBuffer = new StringBuffer();
			Connection conn=null;	
			Statement stmt = null;
			try {
				conn = getConnection(DATA_SOURCE);
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DBException("In PNRJBean - method: call_origdest_lookup failed.", e1);
			}
			
			ResultSet rs = null;
			ArrayList psgrlist = new ArrayList();
			
			try {
				
				sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE, SEG_SCHED_DPTR_DTE, MKT_AL_CDE, FLT_NUM, ");
				sqlBuffer.append("SEG_ORIG_AP_CDE, SEG_DEST_AP_CDE, PSGR_NME, INV_CL_CDE, SEG_STATS_CDE ");
				sqlBuffer.append("from DB2CRS.T_PNRHST_IX_FLT ");
				sqlBuffer.append("where SEG_ORIG_AP_CDE='"+origin+"' and SEG_DEST_AP_CDE='"+destination+"' and SEG_SCHED_DPTR_DTE='"+travelDate+"'" );
				
				if (surName != null && !surName.equals("")) {
					sqlBuffer.append(" and PSGR_NME like '" + surName + "%'");
				}
				if (alCode != null && !alCode.equals("")) {
					sqlBuffer.append(" and MKT_AL_CDE='" + alCode + "'");
				}
				if (flightNum != null && !flightNum.equals("")) {
					sqlBuffer.append(" and FLT_NUM='" + flightNum + "'");
				}
				
				String sql = sqlBuffer.toString();				
				
				stmt = conn.createStatement();				
				rs = stmt.executeQuery(sql);
				
				
				while (rs.next()) {
					PNRData pnrdata = new PNRData();
									
					pnrdata.setPnrLoctrNum(rs.getString("PNR_LOCTR_NUM").trim());
					pnrdata.setPnrCrtnDate(rs.getString("PNR_CRTN_DTE").trim());
					pnrdata.setPnrTravelDate(rs.getString("SEG_SCHED_DPTR_DTE").trim());
					pnrdata.setPnrMkAlCode(rs.getString("MKT_AL_CDE").trim());
					pnrdata.setPnrFltNum(rs.getString("FLT_NUM").trim());
					pnrdata.setPnrSegOrigApCode(rs.getString("SEG_ORIG_AP_CDE").trim());
					pnrdata.setPnrSegDestApCode(rs.getString("SEG_DEST_AP_CDE").trim());
					pnrdata.setPnrPsngrNme(fitPsgrName(rs.getString("PSGR_NME").trim()));
					pnrdata.setPnrInvClCode(rs.getString("INV_CL_CDE").trim());
					pnrdata.setPnrSegStatusCode(rs.getString("SEG_STATS_CDE").trim());
					
					psgrlist.add(pnrdata);
				}
			} catch(SQLException e){
				Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_origdest_lookup failed.");
				e.printStackTrace();
				throw new DBException("In PNRJBean - method: call_origdest_lookup failed.", e);   
			} finally {
				// closeConnection(conn);
				 closeResources(rs,stmt,conn);
			 }
		
		return psgrlist;	
		}


//	private void closeConnection(Connection conn) throws DBException {
//		
//		try{
//			if(conn != null)
//				conn.close();
//		}catch(SQLException e){
//			e.printStackTrace();
//			throw new DBException(e.getMessage());
//		}
//	}
	
	public ArrayList call_pnrDetail_lookup(String pnrLocator, String pnrCrtnDte, Connection conn) throws DBException {
		
			ResultSet rset = null;
			ArrayList psgrlist = new ArrayList();
			StringBuffer sqlBuffer = new StringBuffer();
			Statement stmt = null;
			Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method: call_pnrDetail_lookup.");
			try{
				
				
				sqlBuffer.append("select PNR_LOCTR_NUM, PNR_CRTN_DTE, SEG_SCHED_DPTR_DTE, MKT_AL_CDE, FLT_NUM, " +
											"SEG_ORIG_AP_CDE, SEG_DEST_AP_CDE, PSGR_NME, INV_CL_CDE, SEG_STATS_CDE " +
											"from DB2CRS.T_PNRHST_IX_FLT " +
											"where PNR_LOCTR_NUM='"+pnrLocator+"' and PNR_CRTN_DTE='"+pnrCrtnDte+"'" );
				String sql = sqlBuffer.toString();
				Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method: call_pnrDetail_lookup. SQL is: "+sql);							
				stmt = conn.createStatement();	
				Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method: after create Statement");
				rset = stmt.executeQuery(sql);
				Logger.log(PNRJBean.class, Logger.LEVEL_INFO, "In PNRJBean - method: after executeQuery");	
				
									
				while (rset.next()) {
					PNRData pnrdata = new PNRData();
				
					pnrdata.setPnrLoctrNum(rset.getString("PNR_LOCTR_NUM").trim());
					pnrdata.setPnrCrtnDate(rset.getString("PNR_CRTN_DTE").trim());
					pnrdata.setPnrTravelDate(rset.getString("SEG_SCHED_DPTR_DTE").trim());
					pnrdata.setPnrMkAlCode(rset.getString("MKT_AL_CDE").trim());
					pnrdata.setPnrFltNum(rset.getString("FLT_NUM").trim());
					pnrdata.setPnrSegOrigApCode(rset.getString("SEG_ORIG_AP_CDE").trim());
					pnrdata.setPnrSegDestApCode(rset.getString("SEG_DEST_AP_CDE").trim());
					pnrdata.setPnrPsngrNme(rset.getString("PSGR_NME").trim());
					pnrdata.setPnrInvClCode(rset.getString("INV_CL_CDE").trim());
					pnrdata.setPnrSegStatusCode(rset.getString("SEG_STATS_CDE").trim());

					psgrlist.add(pnrdata);
					} 
				}catch(SQLException e){
					Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - method: call_pnrDetail_lookup.");
					e.printStackTrace(); 
					throw new DBException("In PNRJBean - Method: call_pnrDetail_lookup failed for PNR "+pnrLocator+".", e);
				}
//				finally {
//					// closeConnection(conn);
//					 closeResources(rset,stmt,null);
//				 }
				return psgrlist;	
		}
	
	public String retrievePnrCrtnYearMo(String pnrCrtnDte) throws DBException {
		
		String creationYear=null;
		String creationMonth=null;
		String pnrCrtnYrMo = null;
		
		try{
			creationYear=pnrCrtnDte.substring(0,4);
			creationMonth=pnrCrtnDte.substring(5,7);
			pnrCrtnYrMo=creationYear+creationMonth;
			
//			int yrMo = Integer.parseInt(pnrCrtnYrMo);
//			if (yrMo < 200201)
//				pnrCrtnYrMo = "200201";
			
		}catch(Exception e){
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
			
		return pnrCrtnYrMo;
		}
	
	public Connection getDB2Connection() throws SQLException {
		// Type 4, use this!

		Connection conn = null;
		
		try {
			DataSource ds = null;
			if(ctx == null)
				ctx = new InitialContext();
			
			ds = (DataSource) ctx.lookup(DATA_SOURCE);
			if (ds == null) {
				throw new SQLException(
						"No DB2 Datasource Found for JNDI name :"
								+ DATA_SOURCE);
			}
			conn = ds.getConnection();
			if (conn == null) {
				throw new SQLException(
						"No DB2 connection found for JNDI name :"
								+ DATA_SOURCE);
			}

		} catch (NamingException exception) {
			Logger.log(PNRJBean.class, Logger.LEVEL_ERROR,"NamingException caught. Error is "
					+ exception.getMessage());
			throw new SQLException("DB_CONNECT_ERROR:DB2 connection not established");
		} catch (SQLException exception) {
			Logger.log(PNRJBean.class, Logger.LEVEL_ERROR,"SQLException caught. Error is "
							+ exception.getMessage());
			throw new SQLException("DB_CONNECT_ERROR:DB2 connection not established");

		}

		return conn;
	}
	
private void closeResources(ResultSet rs, Statement s,Connection c ){
		
		try{
			if(rs != null){
				rs.close();
				rs = null;
			}
			
			if(s!= null){
				s.close();
				s = null;
			}
			
			if(c != null && !c.isClosed()){
				c.close();
				c = null;
			}
		}catch(SQLException e){
			Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, "In PNRJBean - error in closing resources "+e.getMessage());
		}
	}
public static String getNextDate(String value, int amount) {

	String result = null;
	
	if(value == null) {
		return null;
	}
	
	value = value.replace('-', '/');
	Logger.log(PNRJBean.class, Logger.LEVEL_DEBUG, "value = [" + value + "]");
	
	try {
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yy");
		//SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		formatter1.setLenient(false);
		formatter2.setLenient(false);

		Date date = formatter1.parse(value);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(GregorianCalendar.DATE, amount);
		result = formatter2.format(cal.getTime());
	}
	catch(Exception e) {
		Logger.log(PNRJBean.class, Logger.LEVEL_ERROR, e.getMessage());
	}
	
	return result;
	}
}
	
