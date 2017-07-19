package com.delta.PRA.SPLJ.EJB;

import java.sql.Connection;

import java.sql.Timestamp;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.delta.PRA.SPLJ.data.PairValue;

import com.delta.PRA.SPLJ.data.SPLData;

import com.delta.PRA.SPLJ.data.SPLSelectedData;

import com.nwa.PRA.CustExceptions.DBException;

import com.nwa.PRA.DataSourceLocHelper.DataSourceLocator;

import com.nwa.PRA.DataSourceLocHelper.DataSourceLocatorException;

import com.nwa.PRA.logger.Logger;

/**
 * 
 * Bean implementation class for Enterprise Bean: SPLJ
 * 
 * @author Ann Yamat
 * 
 *         Modified by Hari Somagatta - Compatable with JDK1.5
 */

public class SPLJBean implements javax.ejb.SessionBean {

	/**

	 * 

	 */

	private static final long serialVersionUID = 1L;

	private javax.ejb.SessionContext mySessionCtx;

	/**
	 * 
	 * getSessionContext
	 */

	public javax.ejb.SessionContext getSessionContext() {

		return mySessionCtx;

	}

	/**
	 * 
	 * setSessionContext
	 */

	public void setSessionContext(javax.ejb.SessionContext ctx) {

		mySessionCtx = ctx;

	}

	/**
	 * 
	 * ejbCreate
	 */

	public void ejbCreate() throws javax.ejb.CreateException {

	}

	/**
	 * 
	 * ejbActivate
	 */

	public void ejbActivate() {

	}

	/**
	 * 
	 * ejbPassivate
	 */

	public void ejbPassivate() {

	}

	/**
	 * 
	 * ejbRemove
	 */

	public void ejbRemove() {

	}

	public String getTestMessage() {

		return "Test Message";

	}

	private Connection getConnection()

	throws SQLException {

		DataSourceLocator dsl = DataSourceLocator.getInstance();

		DataSource db2ds = null;

		try {

			// Changed due to production database is changed to jdbc/ds2 - Marc
			// 20070416

			// db2ds = dsl.getDataSource("jdbc/ds1");

			db2ds = dsl.getDataSource("jdbc/ds2");

			// On Demand changed jndi to test for local server (change back)
			// 7/21/2016
			// db2ds = dsl.getDataSource("jdbc/ds2dvl");
			// On Demand changed jndi to test for local server (change back)

		} catch (DataSourceLocatorException e) {

			e.printStackTrace();

		}

		Connection conn = null;

		for (int i = 1; i < 6; i++) {

			try {

				Logger.log(SPLJBean.class, Logger.LEVEL_DEBUG,
						"In SPLJBean - *** getConnection: Obtaining a connection. Try = "
								+ i);

				conn = db2ds.getConnection();

				conn.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);

				Logger.log(SPLJBean.class, Logger.LEVEL_DEBUG,
						"In SPLJBean - *** getConnection: Connected on try "
								+ i);

				break;

			} catch (SQLException e1) {

				try {

					Logger.log(SPLJBean.class, Logger.LEVEL_DEBUG,
							"In SPLJBean - *** getConnection: Connection failed. Trying to reconnect... ");

					Thread.sleep(500);

					// i++;

					e1.printStackTrace();

					// throw e1;

				} catch (InterruptedException ie) {

					ie.printStackTrace();

				}

				continue;

			}

		}

		if (conn == null) {

			throw new SQLException(
					"Could not establish the Database Connection");

		}

		return conn;

	}

	// On Demand Changes begin

	public boolean call_on_Demand_Request(String email, String flightNumber,
			String localDepartureDate, String legOrigApCode) {
		if (email != null && flightNumber != null && localDepartureDate != null
				&& legOrigApCode != null) {
			return true;
		} else {
			return false;
		}

	}

	// On Demand Changes end

	public ArrayList<PairValue> call_query_j() throws DBException {

		Connection conn = null;

		ArrayList<PairValue> list = new ArrayList<PairValue>();

		ResultSet rs = null;

		Statement stmt = null;

		try {

			conn = getConnection();

			String sql = "SELECT  spil_typ_cde, spil_typ_desc FROM DB2CRS.T_SPIL_TYP";

			// CallableStatement cs = conn.prepareCall(sql);

			// ResultSet rs = cs.executeQuery(sql);

			stmt = conn.createStatement();

			// kims code

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				if (list == null) {

					list = new ArrayList<PairValue>();

				}

				PairValue pv = new PairValue();

				pv.setCode(rs.getString("spil_typ_cde"));

				pv.setValue(rs.getString("spil_typ_desc"));

				list.add(pv);

			}

		} catch (Exception e) {

			Logger.log(this.getClass(), Logger.LEVEL_ERROR, "QUERY J FAILED");

			e.printStackTrace();

			throw new DBException(e.getMessage());

		} finally {

			closeResources(rs, stmt, conn);

		}

		return list;

	}

	public ArrayList<PairValue> call_query_k() throws DBException {

		Connection conn = null;

		ResultSet rs = null;

		Statement stmt = null;

		ArrayList<PairValue> list = new ArrayList<PairValue>();

		try {

			conn = getConnection();

			String sql = "SELECT  ssr_typ_cde, ssr_typ_desc	FROM DB2CRS.T_SSR_TYP";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				if (list == null) {

					list = new ArrayList<PairValue>();

				}

				PairValue pv = new PairValue();

				pv.setCode(rs.getString("ssr_typ_cde"));

				pv.setValue(rs.getString("ssr_typ_desc"));

				list.add(pv);

			}

		} catch (Exception e) {

			Logger.log(this.getClass(), Logger.LEVEL_ERROR, "QUERY K FAILED");

			e.printStackTrace();

			throw new DBException(e.getMessage());

		} finally {

			closeResources(rs, stmt, conn);

		}

		return list;

	}

	public ArrayList<PairValue> call_query_l() throws DBException {

		Connection conn = null;

		ResultSet rs = null;

		Statement stmt = null;

		ArrayList<PairValue> list = new ArrayList<PairValue>();

		try {

			conn = getConnection();

			String sql = "SELECT  WL_TYP_CDE, WL_TYP_DESC FROM DB2CRS.T_WL_TYP";

			// rs = conn.prepareCall(sql).executeQuery();

			// kims code

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				if (list == null) {

					list = new ArrayList<PairValue>();

				}

				PairValue pv = new PairValue();

				pv.setCode(rs.getString("WL_TYP_CDE"));

				pv.setValue(rs.getString("WL_TYP_DESC"));

				list.add(pv);

			}

		} catch (Exception e) {

			Logger.log(this.getClass(), Logger.LEVEL_ERROR, "QUERY L FAILED");

			e.printStackTrace();

			throw new DBException(e.getMessage());

		} finally {

			closeResources(rs, stmt, conn);

		}

		return list;

	}

	public ArrayList<PairValue> call_query_m() throws DBException {

		Connection conn = null;

		ResultSet rs = null;

		Statement stmt = null;

		ArrayList<PairValue> list = new ArrayList<PairValue>();

		try {

			conn = getConnection();

			String sql = "SELECT  WL_VRFY_TYP_CDE, WL_VRFY_TYP_DESC	FROM DB2CRS.T_WL_VRFY_TYP";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				if (list == null) {

					list = new ArrayList<PairValue>();

				}

				PairValue pv = new PairValue();

				pv.setCode(rs.getString("WL_VRFY_TYP_CDE"));

				pv.setValue(rs.getString("WL_VRFY_TYP_DESC"));

				list.add(pv);

			}

		} catch (Exception e) {

			Logger.log(this.getClass(), Logger.LEVEL_ERROR, "QUERY M FAILED");

			e.printStackTrace();

			throw new DBException(e.getMessage());

		} finally {

			closeResources(rs, stmt, conn);

		}

		return list;

	}

	public ArrayList<PairValue> call_query_n() throws DBException {

		Connection conn = null;

		ResultSet rs = null;

		Statement stmt = null;

		ArrayList<PairValue> list = new ArrayList<PairValue>();

		try {

			conn = getConnection();

			String sql = "SELECT  WL_BRD_TYP_CDE, WL_BRD_TYP_DESC FROM DB2CRS.T_WL_BRD_TYP";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PairValue pv = new PairValue();

				pv.setCode(rs.getString("WL_BRD_TYP_CDE"));

				pv.setValue(rs.getString("WL_BRD_TYP_DESC"));

				list.add(pv);

			}

		} catch (Exception e) {

			Logger.log(this.getClass(), Logger.LEVEL_ERROR, "QUERY N FAILED");

			e.printStackTrace();

			throw new DBException(e.getMessage());

		} finally {

			closeResources(rs, stmt, conn);

		}

		return list;

	}

	public ArrayList<PairValue> call_query_o() throws DBException {

		Connection conn = null;

		ResultSet rs = null;

		Statement stmt = null;

		ArrayList<PairValue> list = new ArrayList<PairValue>();

		try {

			conn = getConnection();

			String sql = "SELECT  WL_RES_TYP_CDE, WL_RES_TYP_DESC FROM DB2CRS.T_WL_RES_TYP";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				if (list == null) {

					list = new ArrayList<PairValue>();

				}

				PairValue pv = new PairValue();

				pv.setCode(rs.getString("WL_RES_TYP_CDE"));

				pv.setValue(rs.getString("WL_RES_TYP_DESC"));

				list.add(pv);

			}

		} catch (Exception e) {

			Logger.log(this.getClass(), Logger.LEVEL_ERROR, "QUERY O FAILED");

			e.printStackTrace();

			throw new DBException(e.getMessage());

		} finally {

			closeResources(rs, stmt, conn);

		}

		return list;

	}

	public ArrayList<PairValue> call_query_p() throws DBException {

		DataSourceLocator dsl = DataSourceLocator.getInstance();

		DataSource db2ds = null;

		Connection conn = null;

		ResultSet rs = null;

		Statement stmt = null;

		ArrayList<PairValue> list = new ArrayList<PairValue>();

		try {

			// Changed due to production database is changed to jdbc/ds2 - Marc
			// 20070416

			// db2ds = dsl.getDataSource("jdbc/ds1");

			db2ds = dsl.getDataSource("jdbc/ds2");

			conn = db2ds.getConnection();

			String sql = "SELECT  WL_SVC_TYP_CDE, WL_SVC_TYP_DESC FROM DB2CRS.T_WL_SVC_TYP";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				if (list == null) {

					list = new ArrayList<PairValue>();

				}

				PairValue pv = new PairValue();

				pv.setCode(rs.getString("WL_SVC_TYP_CDE"));

				pv.setValue(rs.getString("WL_SVC_TYP_DESC"));

				list.add(pv);

			}

		} catch (Exception e) {

			Logger.log(this.getClass(), Logger.LEVEL_ERROR, "QUERY P FAILED");

			e.printStackTrace();

			throw new DBException(e.getMessage());

		} finally {

			closeResources(rs, stmt, conn);

		}

		return list;

	}

	public ArrayList<SPLData> call_query_i(String pnrLocator)
			throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("WL_PSGR_LST_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("WL_VRFY_TYP_CDE, ");

		sqlBuffer.append("WL_BRD_TYP_CDE, ");

		sqlBuffer.append("WL_RES_TYP_CDE, ");

		sqlBuffer.append("SEG_DEST_AP_CDE, ");

		sqlBuffer.append("WL_SVC_TYP_CDE, ");

		sqlBuffer.append("WL_TYP_CDE, ");

		sqlBuffer.append("TRVL_CL_CDE, ");

		sqlBuffer.append("EMP_SEN_DTE, ");

		sqlBuffer.append("WL_UTC_CRTN_TME ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_WL_PSGR ");

		sqlBuffer.append("WHERE ");

		sqlBuffer.append("PNR_LOCTR_NUM = '" + pnrLocator + "' ");

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setWaitlistFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setWaitlistLocalDepartureDate(rs
						.getString("LEG_LCL_DPTR_DTE"));

				data.setWaitlistPNRLocator(rs.getString("PNR_LOCTR_NUM"));

				data.setWaitlistSequence(rs.getString("WL_PSGR_LST_NUM"));

				data.setWaitlistName(rs.getString("PSGR_NME"));

				data.setWaitlistV(rs.getString("WL_VRFY_TYP_CDE"));

				data.setWaitlistB(rs.getString("WL_BRD_TYP_CDE"));

				data.setWaitlistR(rs.getString("WL_RES_TYP_CDE"));

				data.setWaitlistDestination(rs.getString("SEG_DEST_AP_CDE"));

				data.setWaitlistService(rs.getString("WL_SVC_TYP_CDE"));

				// data.setWaitlistPTY(rs.getString("")) not sure

				data.setWaitlistPTY(rs.getString("WL_PSGR_LST_NUM"));

				data.setWaitlistType(rs.getString("WL_TYP_CDE"));

				data.setWaitlistCLS(rs.getString("TRVL_CL_CDE"));

				data.setWaitlistSeniority(rs.getString("EMP_SEN_DTE"));

				data.setWaitlistTime(rs.getString("WL_UTC_CRTN_TME"));

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setLocalDepartureDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				data.setSeatAssignment("");

				// Ajeet: Split Waitlist service to Booked and Flown Waitlist
				// Class

				String waitlistService = rs.getString("WL_SVC_TYP_CDE");

				String newWaitBkdClass = null;

				String newWaitFlnClass = null;

				if ((waitlistService != null)
						&& (!waitlistService.trim().equals("")))

				{

					newWaitBkdClass = waitlistService.trim().substring(0, 1);

					if (waitlistService.trim().length() >= 2)

					{

						newWaitFlnClass = waitlistService.trim()
								.substring(1, 2);

					}

				}

				data.setWaitlistBookedClass(newWaitBkdClass);

				data.setWaitlistFlownClass(newWaitFlnClass);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_query_i.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_query_i " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_waitlist_inquiry_lookup(

	String airlineCode,

	String flightNumber,

	String localDepartureDate,

	String passengerName,

	String pnrLocator)

	throws DBException {

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
				"In waitlist Inquiry call in EJB");

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("WL_PSGR_LST_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("WL_VRFY_TYP_CDE, ");

		sqlBuffer.append("WL_BRD_TYP_CDE, ");

		sqlBuffer.append("WL_RES_TYP_CDE, ");

		sqlBuffer.append("SEG_DEST_AP_CDE, ");

		sqlBuffer.append("WL_SVC_TYP_CDE, ");

		sqlBuffer.append("WL_TYP_CDE, ");

		sqlBuffer.append("TRVL_CL_CDE, ");

		sqlBuffer.append("EMP_SEN_DTE, ");

		sqlBuffer.append("WL_UTC_CRTN_TME ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_WL_PSGR ");

		sqlBuffer.append("WHERE ");

		if (airlineCode.length() > 0) {

			sqlBuffer.append("OP_AL_CDE = '" + airlineCode + "' ");

			if ((flightNumber.length() > 0)

			|| (localDepartureDate.length() > 0)

			|| (passengerName.length() > 0)

			|| (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (flightNumber.length() > 0) {

			sqlBuffer.append("OP_FLT_Num = '" + flightNumber + "' ");

			if ((localDepartureDate.length() > 0)

			|| (passengerName.length() > 0)

			|| (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (localDepartureDate.length() > 0) {

			sqlBuffer.append("LEG_LCL_DPTR_YRMO = '"

			+ retrieveYearMonth(localDepartureDate)

			+ "' ");

			sqlBuffer.append(

			"AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

			if ((passengerName.length() > 0) || (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (passengerName.length() > 0) {

			sqlBuffer.append("PSGR_NME LIKE '" + passengerName + "%' ");

			if (pnrLocator.length() > 0) {

				sqlBuffer.append("AND ");

			}

		}

		if (pnrLocator.length() > 0) {

			sqlBuffer.append("PNR_LOCTR_NUM = '" + pnrLocator + "' ");

		}

		sqlBuffer
				.append("ORDER BY LEG_ORIG_AP_CDE, OP_FLT_NUM, LEG_LCL_DPTR_DTE, WL_PSGR_LST_NUM ");

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
					"In waitlist Inquiry call in EJB - query was called and returned");

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setWaitlistFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setWaitlistLocalDepartureDate(rs
						.getString("LEG_LCL_DPTR_DTE"));

				data.setWaitlistOrigin(rs.getString("LEG_ORIG_AP_CDE"));

				data.setWaitlistPNRLocator(rs.getString("PNR_LOCTR_NUM"));

				String tempWNum = rs.getString("WL_PSGR_LST_NUM");

				// pad waitlist num for sorting in scroll list

				if (tempWNum.trim().length() < 2) {

					tempWNum = "000" + tempWNum;

				} else if (tempWNum.trim().length() < 3) {

					tempWNum = "00" + tempWNum;

				} else if (tempWNum.trim().length() < 4) {

					tempWNum = "0" + tempWNum;

				}

				// original code

				data.setWaitlistSequence(tempWNum);

				// Added by Hari to display the wait list for DL flights some
				// thing like '1-02' etc

				// String listNum = rs.getString("WL_PSGR_LST_NUM");

				// //Date dptrDate =
				// SPLJUtil.formatDate(rs.getString("LEG_LCL_DPTR_DTE"));

				// if(listNum != null & listNum.trim().length()>=3 &&
				// !rs.getString("LEG_LCL_DPTR_DTE").equals("01/01/2011")){

				// data.setWaitlistSequence(listNum.substring(0,listNum.length()-2)+"-"+listNum.substring(listNum.length()-2,listNum.length()));

				// }

				data.setWaitlistName(rs.getString("PSGR_NME"));

				data.setWaitlistV(rs.getString("WL_VRFY_TYP_CDE"));

				data.setWaitlistB(rs.getString("WL_BRD_TYP_CDE"));

				data.setWaitlistR(rs.getString("WL_RES_TYP_CDE"));

				data.setWaitlistDestination(rs.getString("SEG_DEST_AP_CDE"));

				data.setWaitlistService(rs.getString("WL_SVC_TYP_CDE"));

				// Ajeet: Split Waitlist service to Booked and Flown Waitlist
				// Class

				String waitlistService = rs.getString("WL_SVC_TYP_CDE");

				String newWaitBkdClass = null;

				String newWaitFlnClass = null;

				if ((waitlistService != null)
						&& (!waitlistService.trim().equals("")))

				{

					newWaitBkdClass = waitlistService.trim().substring(0, 1);

					if (waitlistService.trim().length() >= 2)

					{

						newWaitFlnClass = waitlistService.trim()
								.substring(1, 2);

					}

				}

				data.setWaitlistBookedClass(newWaitBkdClass);

				data.setWaitlistFlownClass(newWaitFlnClass);

				data.setWaitlistPTY(rs.getString("WL_PSGR_LST_NUM"));

				data.setWaitlistType(rs.getString("WL_TYP_CDE"));

				data.setWaitlistCLS(rs.getString("TRVL_CL_CDE"));

				if (rs.getString("EMP_SEN_DTE").equals("1900-01-01")) {

					data.setWaitlistSeniority("000000");

				} else if (rs.getString("EMP_SEN_DTE").equals("0001-01-01")) {

					data.setWaitlistSeniority("INVALD");

				}

				else {

					data.setWaitlistSeniority(rs.getString("EMP_SEN_DTE"));

				}

				data.setWaitlistTime(rs.getString("WL_UTC_CRTN_TME"));

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_waitlist_inquiry_lookup.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_waitlist_inquiry_lookup " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_other_inquiry_lookup(

	String ticketNumber,

	String pnrLocator,

	String governmentId)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("ROW_SEAT_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("ITINSEG_DESTAP_CDE, ");

		sqlBuffer.append("INV_CL_CDE, ");

		sqlBuffer.append("BKD_CPMT_CD, ");

		sqlBuffer.append("ACTL_CPMT_CD, ");

		sqlBuffer.append("SPIL_TYP_CDE, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("SSR_TYP_CDE, ");

		sqlBuffer.append("CUST_ID, ");

		sqlBuffer.append("BKG_CRTN_GDT, ");

		sqlBuffer.append("TKT_DOC_ISS_LDT, ");

		sqlBuffer.append("PAX_CKIN_LDT, ");

		sqlBuffer.append("PAX_CKIN_LTM, ");

		sqlBuffer.append("PAX_OBRD_LDT, ");

		sqlBuffer.append("PAX_OBRD_LTM, ");

		sqlBuffer.append("FLT_CX_IND, ");

		sqlBuffer.append("ARRSEG_OP_AL_CDE, ");

		sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");

		sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");

		sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");

		sqlBuffer.append("TKT_NUM, ");

		sqlBuffer.append("FF_AL_CDE, ");

		sqlBuffer.append("FF_ID, ");

		sqlBuffer.append("FF_TIER_LVL_DESC, ");

		sqlBuffer.append("GOVT_DOC_NUM ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR ");

		sqlBuffer.append("WHERE ");

		if (ticketNumber.length() > 0) {

			sqlBuffer.append("TKT_NUM = '" + ticketNumber + "' ");

			if ((pnrLocator.length() > 0) || (governmentId.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (pnrLocator.length() > 0) {

			sqlBuffer.append("PNR_LOCTR_NUM = '" + pnrLocator + "' ");

			if (governmentId.length() > 0) {

				sqlBuffer.append("AND ");

			}

		}

		if (governmentId.length() > 0) {

			sqlBuffer.append("GOVT_DOC_NUM = '" + governmentId + "' ");

		}

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setLocalDepartureDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setPassengerName(rs.getString("PSGR_NME"));

				data.setSeatAssignment(rs.getString("ROW_SEAT_NUM"));

				data.setPnrLocator(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");
				// on demand begin
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));

				data.setTimeStampString(rs.getTimestamp("FILE_RCVD_LTS")
						.toString());
				// on demand end
				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA"))
								&& (!origSpilTypCde.trim().equals(""))
						// infant ET code change begins

						&& (!origSpilTypCde.trim().equals("IN")))

				// infant ET code change begins

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if (origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends

				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_other_inquiry_lookup.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_other_inquiry_lookup " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_frequent_flier_inquiry_lookup(

	String airlineCode,

	String programId)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("ROW_SEAT_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("ITINSEG_DESTAP_CDE, ");

		sqlBuffer.append("INV_CL_CDE, ");

		sqlBuffer.append("BKD_CPMT_CD, ");

		sqlBuffer.append("ACTL_CPMT_CD, ");

		sqlBuffer.append("SPIL_TYP_CDE, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("SSR_TYP_CDE, ");

		sqlBuffer.append("CUST_ID, ");

		sqlBuffer.append("BKG_CRTN_GDT, ");

		sqlBuffer.append("TKT_DOC_ISS_LDT, ");

		sqlBuffer.append("PAX_CKIN_LDT, ");

		sqlBuffer.append("PAX_CKIN_LTM, ");

		sqlBuffer.append("PAX_OBRD_LDT, ");

		sqlBuffer.append("PAX_OBRD_LTM, ");

		sqlBuffer.append("FLT_CX_IND, ");

		sqlBuffer.append("ARRSEG_OP_AL_CDE, ");

		sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");

		sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");

		sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");

		sqlBuffer.append("TKT_NUM, ");

		sqlBuffer.append("FF_AL_CDE, ");

		sqlBuffer.append("FF_ID, ");

		sqlBuffer.append("FF_TIER_LVL_DESC, ");

		sqlBuffer.append("GOVT_DOC_NUM ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR ");

		sqlBuffer.append("WHERE FF_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND FF_ID = '" + programId + "' ");

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setLocalDepartureDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setPassengerName(rs.getString("PSGR_NME"));

				data.setSeatAssignment(rs.getString("ROW_SEAT_NUM"));

				data.setPnrLocator(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA"))
								&& (!origSpilTypCde.trim().equals(""))// infant
																		// ET
																		// code
																		// change
																		// begins

						&& (!origSpilTypCde.trim().equals("IN")))

				// infant ET code change ends

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins

				else if (origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends
				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_frequent_flier_inquiry_lookup.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_frequent_flier_inquiry_lookup "

			+ e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_passenger_inquiry_lookup(

	String passengerName,

	String localDepartureDate)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("ROW_SEAT_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("ITINSEG_DESTAP_CDE, ");

		sqlBuffer.append("INV_CL_CDE, ");

		sqlBuffer.append("BKD_CPMT_CD, ");

		sqlBuffer.append("ACTL_CPMT_CD, ");

		sqlBuffer.append("SPIL_TYP_CDE, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("SSR_TYP_CDE, ");

		sqlBuffer.append("CUST_ID, ");

		sqlBuffer.append("BKG_CRTN_GDT, ");

		sqlBuffer.append("TKT_DOC_ISS_LDT, ");

		sqlBuffer.append("PAX_CKIN_LDT, ");

		sqlBuffer.append("PAX_CKIN_LTM, ");

		sqlBuffer.append("PAX_OBRD_LDT, ");

		sqlBuffer.append("PAX_OBRD_LTM, ");

		sqlBuffer.append("FLT_CX_IND, ");

		sqlBuffer.append("ARRSEG_OP_AL_CDE, ");

		sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");

		sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");

		sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");

		sqlBuffer.append("TKT_NUM, ");

		sqlBuffer.append("FF_AL_CDE, ");

		sqlBuffer.append("FF_ID, ");

		sqlBuffer.append("FF_TIER_LVL_DESC, ");

		sqlBuffer.append("GOVT_DOC_NUM ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR ");

		sqlBuffer.append(

		"WHERE LEG_LCL_DPTR_YRMO = '"

		+ retrieveYearMonth(localDepartureDate)

		+ "' ");

		sqlBuffer.append(

		"AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND PSGR_NME LIKE '" + passengerName + "%' ");

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setLocalDepartureDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setPassengerName(rs.getString("PSGR_NME"));

				data.setSeatAssignment(rs.getString("ROW_SEAT_NUM"));

				data.setPnrLocator(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA"))
								&& (!origSpilTypCde.trim().equals(""))// infant
																		// ET
																		// code
																		// change
																		// begins

						&& (!origSpilTypCde.trim().equals("IN")))

				// infant ET code change begins)

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if (origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends
				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_passenger_inquiry_lookup.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_passenger_inquiry_lookup " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_flight_inquiry_lookup(

	String airlineCode,

	String flightNumber,

	String localDepartureDate,

	String depApt,

	String desApt)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("ROW_SEAT_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("ITINSEG_DESTAP_CDE, ");

		sqlBuffer.append("INV_CL_CDE, ");

		sqlBuffer.append("BKD_CPMT_CD, ");

		sqlBuffer.append("ACTL_CPMT_CD, ");

		sqlBuffer.append("SPIL_TYP_CDE, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("SSR_TYP_CDE, ");

		sqlBuffer.append("CUST_ID, ");

		sqlBuffer.append("BKG_CRTN_GDT, ");

		sqlBuffer.append("TKT_DOC_ISS_LDT, ");

		sqlBuffer.append("PAX_CKIN_LDT, ");

		sqlBuffer.append("PAX_CKIN_LTM, ");

		sqlBuffer.append("PAX_OBRD_LDT, ");

		sqlBuffer.append("PAX_OBRD_LTM, ");

		sqlBuffer.append("FLT_CX_IND, ");

		sqlBuffer.append("ARRSEG_OP_AL_CDE, ");

		sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");

		sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");

		sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");

		sqlBuffer.append("TKT_NUM, ");

		sqlBuffer.append("FF_AL_CDE, ");

		sqlBuffer.append("FF_ID, ");

		sqlBuffer.append("FF_TIER_LVL_DESC, ");

		sqlBuffer.append("GOVT_DOC_NUM ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR ");

		sqlBuffer.append(

		"WHERE LEG_LCL_DPTR_YRMO = '"

		+ retrieveYearMonth(localDepartureDate)

		+ "' ");

		sqlBuffer.append(

		"AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		if ((depApt != null) && (!depApt.trim().equals(""))) {

			sqlBuffer.append("AND LEG_ORIG_AP_CDE = '" + depApt.trim() + "' ");

		}

		if ((desApt != null) && (!desApt.trim().equals(""))) {

			sqlBuffer.append("AND ITINSEG_DESTAP_CDE = '" + desApt.trim()
					+ "' ");

		}

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setLocalDepartureDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setPassengerName(rs.getString("PSGR_NME"));

				data.setSeatAssignment(rs.getString("ROW_SEAT_NUM"));

				data.setPnrLocator(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA"))
								&& (!origSpilTypCde.trim().equals(""))
						// infant ET code change begins

						&& (!origSpilTypCde.trim().equals("IN")))

				// infant ET code change begins)

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if (origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends
				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_flight_inquiry_lookup.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_flight_inquiry_lookup " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public String retrieveYearMonth(String date) throws DBException {

		String year = null;

		String month = null;

		String yearMonth = null;

		try {

			// date format CCYY-MM-DD

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "date --> " + date);

			year = date.substring(0, 4);

			month = date.substring(5, 7);

			yearMonth = year + month;

			/*
			 * 
			 * int yrMo = Integer.parseInt(yearMonth);
			 * 
			 * if (yrMo < 200201)
			 * 
			 * yearMonth = "200201";
			 */

		} catch (Exception e) {

			e.printStackTrace();

			throw new DBException(e.getMessage());

		}

		return yearMonth;

	}

	/** Added for selected record data QUERY Q **/

	public ArrayList<SPLSelectedData> call_selected_record_lookup(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String legOrigApCode,

	String seqNum,

	String rowSeat,

	String pnrNum)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLSelectedData> selectList = new ArrayList<SPLSelectedData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("ROW_SEAT_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("ITINSEG_DESTAP_CDE, ");

		sqlBuffer.append("INV_CL_CDE, ");

		sqlBuffer.append("BKD_CPMT_CD, ");

		sqlBuffer.append("ACTL_CPMT_CD, ");

		sqlBuffer.append("SPIL_TYP_CDE, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("SSR_TYP_CDE, ");

		sqlBuffer.append("CUST_ID, ");

		sqlBuffer.append("BKG_CRTN_GDT, ");

		sqlBuffer.append("TKT_DOC_ISS_LDT, ");

		sqlBuffer.append("PAX_CKIN_LDT, ");

		sqlBuffer.append("PAX_CKIN_LTM, ");

		sqlBuffer.append("PAX_OBRD_LDT, ");

		sqlBuffer.append("PAX_OBRD_LTM, ");

		sqlBuffer.append("FLT_CX_IND, ");

		sqlBuffer.append("ARRSEG_OP_AL_CDE, ");

		sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");

		sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");

		sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");

		sqlBuffer.append("TKT_NUM, ");

		sqlBuffer.append("FF_AL_CDE, ");

		sqlBuffer.append("FF_ID, ");

		sqlBuffer.append("FF_TIER_LVL_DESC, ");

		sqlBuffer.append("GOVT_DOC_NUM ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR ");

		sqlBuffer.append("WHERE LEG_LCL_DPTR_YRMO = '"
				+ retrieveYearMonth(localDepartureDate) + "' ");

		sqlBuffer
				.append("AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		sqlBuffer.append("AND LEG_ORIG_AP_CDE = '" + legOrigApCode + "' ");

		sqlBuffer.append("AND MULT_DPTR_SEQ_NUM = " + seqNum + " ");

		sqlBuffer.append("AND ROW_SEAT_NUM = '" + rowSeat + "' ");

		sqlBuffer.append("AND PNR_LOCTR_NUM = '" + pnrNum + "' ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLSelectedData data = new SPLSelectedData();

				data.setFlightNum(rs.getString("OP_AL_CDE").trim()
						+ rs.getString("OP_FLT_NUM"));

				data.setDepDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setBoardPoint(rs.getString("LEG_ORIG_AP_CDE"));

				data.setOffPoint(rs.getString("ITINSEG_DESTAP_CDE"));

				data.setPnr(rs.getString("PNR_LOCTR_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setConFrom1(rs.getString("ARRSEG_OP_AL_CDE").trim()
						+ rs.getString("ARRSEG_OP_FLT_NUM"));

				data.setConFrom2(rs.getString("ARRSEG_ORIGAP_CDE"));

				data.setConTo1(rs.getString("NEXTSEG_OP_AL_CDE").trim()
						+ rs.getString("NEXTSEG_OP_FLT_NUM"));

				data.setConTo2(rs.getString("NEXTSEG_DESTAP_CDE"));

				data.setSelRowSeat(rs.getString("ROW_SEAT_NUM"));

				data.setSelPassenger(rs.getString("PSGR_NME"));

				data.setSelPnr(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA"))
								&& (!origSpilTypCde.trim().equals(""))
						// infant ET code change begins

						&& (!origSpilTypCde.trim().equals("IN")))

				// infant ET code change begins)

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if (origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends
				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				Logger.log(
						this.getClass(),
						Logger.LEVEL_DEBUG,
						"in bean retrived seat and passenger--->"
								+ data.getSelRowSeat() + "-->"
								+ data.getSelPassenger());

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
						"in bean retrived selPnr--->" + data.getSelPnr());

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_selected_record_lookup");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_selected_record_lookup" + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	/*
	 * added for selected record data remarks section
	 * 
	 * QUERY R
	 */

	public ArrayList<SPLSelectedData> call_selected_record_remarks_lookup(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String legOrigApCode,

	String seqNum,

	String rowSeat,

	String pnrNum)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLSelectedData> selectList = new ArrayList<SPLSelectedData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("ROW_SEAT_NUM, ");

		sqlBuffer.append("RMK_SEQ_NUM, ");

		sqlBuffer.append("RMK_TYP_CDE, ");

		sqlBuffer.append("RMK_TXT ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR_RMK ");

		sqlBuffer.append("WHERE LEG_LCL_DPTR_YRMO = '"
				+ retrieveYearMonth(localDepartureDate) + "' ");

		sqlBuffer
				.append("AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		sqlBuffer.append("AND LEG_ORIG_AP_CDE = '" + legOrigApCode + "' ");

		sqlBuffer.append("AND MULT_DPTR_SEQ_NUM = " + seqNum + " ");

		sqlBuffer.append("AND ROW_SEAT_NUM = '" + rowSeat + "' ");

		sqlBuffer.append("ORDER BY RMK_SEQ_NUM");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLSelectedData data = new SPLSelectedData();

				data.setSsrCde(rs.getString("RMK_TYP_CDE"));

				data.setRemarks1(rs.getString("RMK_TXT"));

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_selected_record_lookup");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_selected_record_lookup" + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	// detail query for waitlist tab

	public ArrayList<SPLSelectedData> call_selected_record_lookup_waitlist(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String passengerName,

	String pnrLocator)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLSelectedData> selectList = new ArrayList<SPLSelectedData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("ROW_SEAT_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("ITINSEG_DESTAP_CDE, ");

		sqlBuffer.append("INV_CL_CDE, ");

		sqlBuffer.append("SPIL_TYP_CDE, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("SSR_TYP_CDE, ");

		sqlBuffer.append("BKD_CPMT_CD, ");

		sqlBuffer.append("ACTL_CPMT_CD, ");

		sqlBuffer.append("CUST_ID, ");

		sqlBuffer.append("BKG_CRTN_GDT, ");

		sqlBuffer.append("TKT_DOC_ISS_LDT, ");

		sqlBuffer.append("PAX_CKIN_LDT, ");

		sqlBuffer.append("PAX_CKIN_LTM, ");

		sqlBuffer.append("PAX_OBRD_LDT, ");

		sqlBuffer.append("PAX_OBRD_LTM, ");

		sqlBuffer.append("FLT_CX_IND, ");

		sqlBuffer.append("ARRSEG_OP_AL_CDE, ");

		sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");

		sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");

		sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");

		sqlBuffer.append("TKT_NUM, ");

		sqlBuffer.append("FF_AL_CDE, ");

		sqlBuffer.append("FF_ID, ");

		sqlBuffer.append("FF_TIER_LVL_DESC, ");

		sqlBuffer.append("GOVT_DOC_NUM ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR ");

		sqlBuffer.append("WHERE LEG_LCL_DPTR_YRMO = '"
				+ retrieveYearMonth(localDepartureDate) + "' ");

		sqlBuffer
				.append("AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		sqlBuffer.append("AND PSGR_NME LIKE '" + passengerName + "%' ");

		// sqlBuffer.append("AND PSGR_NME = '" + passengerName + "' ");

		sqlBuffer.append("AND PNR_LOCTR_NUM = '" + pnrLocator + "' ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLSelectedData data = new SPLSelectedData();

				data.setFlightNum(rs.getString("OP_AL_CDE").trim()
						+ rs.getString("OP_FLT_NUM"));

				data.setDepDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setBoardPoint(rs.getString("LEG_ORIG_AP_CDE"));

				data.setOffPoint(rs.getString("ITINSEG_DESTAP_CDE"));

				data.setPnr(rs.getString("PNR_LOCTR_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setType(rs.getString("SPIL_TYP_CDE"));

				data.setConFrom1(rs.getString("ARRSEG_OP_AL_CDE").trim()
						+ rs.getString("ARRSEG_OP_FLT_NUM"));

				data.setConFrom2(rs.getString("ARRSEG_ORIGAP_CDE"));

				data.setConTo1(rs.getString("NEXTSEG_OP_AL_CDE").trim()
						+ rs.getString("NEXTSEG_OP_FLT_NUM"));

				// Added by Hari 04/26/2011

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				// end

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				data.setConTo2(rs.getString("NEXTSEG_DESTAP_CDE"));

				data.setSelRowSeat(rs.getString("ROW_SEAT_NUM"));

				data.setSelPassenger(rs.getString("PSGR_NME"));

				data.setSelLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSelSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA"))
								&& (!origSpilTypCde.trim().equals(""))
						// infant ET code change begins

						&& (!origSpilTypCde.trim().equals("IN")))

				// infant ET code change ends

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				else if(origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends

				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_selected_record_lookup");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_selected_record_lookup" + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	// query for passenger name lookup in waitlist

	public ArrayList<SPLData> call_passenger_lookup_waitlist(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String pnrLocator)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "parameters recieved:"
				+ localDepartureDate + "--" + airlineCode + "--" + flightNumber
				+ "--" + pnrLocator);

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("ROW_SEAT_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("ITINSEG_DESTAP_CDE, ");

		sqlBuffer.append("INV_CL_CDE, ");

		sqlBuffer.append("SPIL_TYP_CDE, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("SSR_TYP_CDE, ");

		sqlBuffer.append("CUST_ID, ");

		sqlBuffer.append("BKG_CRTN_GDT, ");

		sqlBuffer.append("TKT_DOC_ISS_LDT, ");

		sqlBuffer.append("PAX_CKIN_LDT, ");

		sqlBuffer.append("PAX_CKIN_LTM, ");

		sqlBuffer.append("PAX_OBRD_LDT, ");

		sqlBuffer.append("PAX_OBRD_LTM, ");

		sqlBuffer.append("FLT_CX_IND, ");

		sqlBuffer.append("ARRSEG_OP_AL_CDE, ");

		sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");

		sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");

		sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");

		sqlBuffer.append("TKT_NUM, ");

		sqlBuffer.append("FF_AL_CDE, ");

		sqlBuffer.append("FF_ID, ");

		sqlBuffer.append("FF_TIER_LVL_DESC, ");

		sqlBuffer.append("GOVT_DOC_NUM ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR ");

		sqlBuffer.append("WHERE LEG_LCL_DPTR_YRMO = '"
				+ retrieveYearMonth(localDepartureDate) + "' ");

		sqlBuffer
				.append("AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		sqlBuffer.append("AND PNR_LOCTR_NUM = '" + pnrLocator + "' ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setPassengerName(rs.getString("PSGR_NME"));

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_selected_record_lookup");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_selected_record_lookup" + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	/**
	 * 
	 * @param airlineCode
	 * 
	 * @param flightNumber
	 * 
	 * @param localDepartureDate
	 * 
	 * @return
	 */

	public ArrayList<SPLSelectedData> call_ssr_inquiry_lookup(
			String localDepartureDate, String airlineCode, String flightNumber,

			String ssrCode) throws DBException {

		Connection conn = null;

		ArrayList<SPLSelectedData> selectList = new ArrayList<SPLSelectedData>();

		ResultSet rs = null;

		Statement stmt = null;

		String localDepartureYrMo = localDepartureDate.substring(0, 4)
				+ localDepartureDate.substring(5, 7);

		try {

			StringBuffer sqlstr = new StringBuffer();

			sqlstr.append("SELECT  RMK.OP_AL_CDE as Airline, ");

			sqlstr.append("        RMK.OP_FLT_NUM as Flight_Num, ");

			sqlstr.append("        RMK.LEG_ORIG_AP_CDE as Board_Pt, ");

			sqlstr.append("        RMK.LEG_LCL_DPTR_DTE as Dept_Date, ");

			sqlstr.append("        RTRIM(PSGR.PSGR_NME) as Passenger_Name, ");

			sqlstr.append("        RMK.RMK_TYP_CDE as Ssr_Cde, ");

			sqlstr.append("        RMK.RMK_TXT as Remark_txt, ");

			sqlstr.append("        PSGR.INV_CL_CDE as Class, ");

			sqlstr.append("        RMK.ROW_SEAT_NUM as Seat_Num, ");

			sqlstr.append("        PSGR.PNR_LOCTR_NUM as Pnr_Loctr, ");

			sqlstr.append("        RMK.LEG_LCL_DPTR_YRMO, ");

			sqlstr.append("        RMK.MULT_DPTR_SEQ_NUM as Seq_Num, ");

			sqlstr.append("        RMK.RMK_SEQ_NUM ");

			sqlstr.append("FROM    DB2CRS.T_SPIL_PSGR_RMK RMK, ");

			sqlstr.append("        DB2CRS.T_SPIL_PSGR PSGR ");

			sqlstr.append("WHERE   RMK.LEG_LCL_DPTR_YRMO = '"
					+ localDepartureYrMo + "' ");

			sqlstr.append("AND     RMK.LEG_LCL_DPTR_DTE = '"
					+ localDepartureDate + "' ");

			sqlstr.append("AND     RMK.OP_AL_CDE = '" + airlineCode + "' ");

			sqlstr.append("AND     RMK.OP_FLT_NUM = '" + flightNumber + "' ");

			if (!ssrCode.equals("")) {

				// sqlstr.append(" AND (RMK.RMK_TYP_CDE LIKE '%" + ssrCode +
				// "%' " +

				// This is changed by Hari to improve the performance of data
				// pull

				// up on Brenda's suggestion - 03/07/2011

				sqlstr.append(" AND (RMK.RMK_TYP_CDE = '" + ssrCode + "' "
						+ "OR RMK.RMK_TXT LIKE '%" + ssrCode + "%' )");

			}

			sqlstr.append("AND RMK.LEG_LCL_DPTR_YRMO  = PSGR.LEG_LCL_DPTR_YRMO ");

			sqlstr.append("AND RMK.LEG_LCL_DPTR_DTE = PSGR.LEG_LCL_DPTR_DTE ");

			sqlstr.append("AND RMK.OP_AL_CDE = PSGR.OP_AL_CDE ");

			sqlstr.append("AND RMK.OP_FLT_NUM = PSGR.OP_FLT_NUM ");

			sqlstr.append("AND RMK.LEG_ORIG_AP_CDE = PSGR.LEG_ORIG_AP_CDE ");

			sqlstr.append("AND RMK.MULT_DPTR_SEQ_NUM = PSGR.MULT_DPTR_SEQ_NUM ");

			sqlstr.append("AND RMK.ROW_SEAT_NUM = PSGR.ROW_SEAT_NUM ");

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlstr.toString());

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, localDepartureDate);

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, airlineCode);

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, flightNumber);

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlstr.toString());

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlstr.toString());

			while (rs.next()) {

				SPLSelectedData data = new SPLSelectedData();

				data.setAirlineCode(rs.getString("Airline"));

				data.setFlightNumber(rs.getString("Flight_Num"));

				data.setLegOrigApCode(rs.getString("Board_Pt"));

				data.setLocalDepartureDate(rs.getString("Dept_Date"));

				data.setPassengerName(rs.getString("Passenger_Name"));

				data.setSsrCde(rs.getString("Ssr_Cde"));

				data.setRemarks1(rs.getString("Remark_txt"));

				data.setClass1(rs.getString("Class"));

				data.setSeatAssignment(rs.getString("Seat_Num"));

				data.setPnrLocator(rs.getString("Pnr_Loctr"));

				data.setSeqNum(rs.getString("Seq_Num"));

				// on demand begin
				// data.setTimeStamp(rs.getTimestamp("RMK.FILE_RCVD_LTS"));
				// on demand end

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(
					SPLJBean.class,
					Logger.LEVEL_ERROR,
					"In SPLJBean - method: call_ssr_inquiry_lookup. "
							+ e.getMessage());

			e.printStackTrace();

			throw new DBException(
					"In SPLJBean - Method: call_ssr_inquiry_lookup " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

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

				c.close();

			}

		} catch (SQLException e) {

			Logger.log(
					SPLJBean.class,
					Logger.LEVEL_ERROR,
					"In SPLJBean - error in closing resources "
							+ e.getMessage());

		}

	}

	// On Demand Changes begin 7/21/16
	public ArrayList<SPLSelectedData> call_selected_record_lookup_OD(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String legOrigApCode,

	String seqNum,

	String rowSeat,

	String pnrNum,

	java.sql.Timestamp timeStamp)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		System.out.println("In SPLJBean.call_selected_record_lookup_OD");

		ArrayList<SPLSelectedData> selectList = new ArrayList<SPLSelectedData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT * ");

		/*
		 * sqlBuffer.append("LEG_LCL_DPTR_DTE, ");
		 * 
		 * sqlBuffer.append("OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("LEG_ORIG_AP_CDE, ");
		 * 
		 * sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("ROW_SEAT_NUM, ");
		 * 
		 * sqlBuffer.append("PNR_LOCTR_NUM, ");
		 * 
		 * sqlBuffer.append("ITINSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("INV_CL_CDE, ");
		 * 
		 * sqlBuffer.append("BKD_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("ACTL_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("SPIL_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("PSGR_NME, ");
		 * 
		 * sqlBuffer.append("SSR_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("CUST_ID, ");
		 * 
		 * sqlBuffer.append("BKG_CRTN_GDT, ");
		 * 
		 * sqlBuffer.append("TKT_DOC_ISS_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LTM, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LTM, ");
		 * 
		 * sqlBuffer.append("FLT_CX_IND, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("TKT_NUM, ");
		 * 
		 * sqlBuffer.append("FF_AL_CDE, ");
		 * 
		 * sqlBuffer.append("FF_ID, ");
		 * 
		 * sqlBuffer.append("FF_TIER_LVL_DESC, ");
		 * 
		 * sqlBuffer.append("GOVT_DOC_NUM ");
		 */

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR_OD ");

		sqlBuffer.append("WHERE LEG_LCL_DPTR_YRMO = '"
				+ retrieveYearMonth(localDepartureDate) + "' ");

		sqlBuffer
				.append("AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		sqlBuffer.append("AND LEG_ORIG_AP_CDE = '" + legOrigApCode + "' ");

		sqlBuffer.append("AND MULT_DPTR_SEQ_NUM = " + seqNum + " ");

		sqlBuffer.append("AND ROW_SEAT_NUM = '" + rowSeat + "' ");

		sqlBuffer.append("AND PNR_LOCTR_NUM = '" + pnrNum + "' ");

		sqlBuffer.append("AND FILE_RCVD_LTS = '" + timeStamp + "' ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLSelectedData data = new SPLSelectedData();

				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS")); // od
																		// addition
																		// 8/17/16
				// System.out.println("call_selected_record_lookup_OD Getter method: "
				// + data.getTimeStamp());

				data.setFlightNum(rs.getString("OP_AL_CDE").trim()
						+ rs.getString("OP_FLT_NUM"));

				data.setDepDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setBoardPoint(rs.getString("LEG_ORIG_AP_CDE"));

				data.setOffPoint(rs.getString("ITINSEG_DESTAP_CDE"));

				data.setPnr(rs.getString("PNR_LOCTR_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setConFrom1(rs.getString("ARRSEG_OP_AL_CDE").trim()
						+ rs.getString("ARRSEG_OP_FLT_NUM"));

				data.setConFrom2(rs.getString("ARRSEG_ORIGAP_CDE"));

				data.setConTo1(rs.getString("NEXTSEG_OP_AL_CDE").trim()
						+ rs.getString("NEXTSEG_OP_FLT_NUM"));

				data.setConTo2(rs.getString("NEXTSEG_DESTAP_CDE"));

				data.setSelRowSeat(rs.getString("ROW_SEAT_NUM"));

				data.setSelPassenger(rs.getString("PSGR_NME"));

				data.setSelPnr(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// on demand begin
				java.sql.Timestamp ts = rs.getTimestamp("FILE_RCVD_LTS");
				// data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				data.setTimeStamp(ts);
				// data.setTimeStampString(String.valueOf(ts));
				data.setTimeStampString(String.valueOf(ts));
				// System.out.println("data.setTimeStampString(String.valueOf(ts))-->"
				// + data.getTimeStampString());
				data.setTimeStampString(ts.toString());
				// System.out.println("data.setTimeStampString(ts.toString())-->"
				// + data.getTimeStampString());

				// on demand end

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA")) && (!origSpilTypCde
								.trim().equals(""))
								// infant ET code change begins
								
								&& (!origSpilTypCde.trim().equals("IN")))								
								
								// infant ET code change begins

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if(origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends

				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				Logger.log(
						this.getClass(),
						Logger.LEVEL_DEBUG,
						"in bean retrived seat and passenger OD--->"
								+ data.getSelRowSeat() + "-->"
								+ data.getSelPassenger());

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
						"in bean retrived selPnr OD--->" + data.getSelPnr());

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_selected_record_lookup_OD");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - DB EXCEPTION - Method: call_selected_record_lookup_OD"
					+ e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_flight_inquiry_lookup_OD(

	String airlineCode,

	String flightNumber,

	String localDepartureDate,

	String depApt,

	String desApt

	)

	throws DBException, ParseException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT ");
		sqlBuffer.append("* ");

		/*
		 * sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");
		 * 
		 * sqlBuffer.append("LEG_LCL_DPTR_DTE, ");
		 * 
		 * sqlBuffer.append("OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("LEG_ORIG_AP_CDE, ");
		 * 
		 * sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("ROW_SEAT_NUM, ");
		 * 
		 * sqlBuffer.append("PNR_LOCTR_NUM, ");
		 * 
		 * sqlBuffer.append("ITINSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("INV_CL_CDE, ");
		 * 
		 * sqlBuffer.append("BKD_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("ACTL_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("SPIL_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("PSGR_NME, ");
		 * 
		 * sqlBuffer.append("SSR_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("CUST_ID, ");
		 * 
		 * sqlBuffer.append("BKG_CRTN_GDT, ");
		 * 
		 * sqlBuffer.append("TKT_DOC_ISS_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LTM, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LTM, ");
		 * 
		 * sqlBuffer.append("FLT_CX_IND, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("TKT_NUM, ");
		 * 
		 * sqlBuffer.append("FF_AL_CDE, ");
		 * 
		 * sqlBuffer.append("FF_ID, ");
		 * 
		 * sqlBuffer.append("FF_TIER_LVL_DESC, ");
		 * 
		 * sqlBuffer.append("GOVT_DOC_NUM ");
		 * 
		 * sqlBuffer.append("FILE_RCVD_LTS "); // added od 8/17/16
		 */

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR_OD ");

		sqlBuffer.append(

		"WHERE LEG_LCL_DPTR_YRMO = '"

		+ retrieveYearMonth(localDepartureDate)

		+ "' ");

		sqlBuffer.append(

		"AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		if ((depApt != null) && (!depApt.trim().equals(""))) {

			sqlBuffer.append("AND LEG_ORIG_AP_CDE = '" + depApt.trim() + "' ");

		}

		if ((desApt != null) && (!desApt.trim().equals(""))) {

			sqlBuffer.append("AND ITINSEG_DESTAP_CDE = '" + desApt.trim()
					+ "' ");

		}

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());
		Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
				"in SPLJBean - call_flight_inquiry_lookup_OD method");

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {
				/*
				 * SimpleDateFormat sdf = new
				 * SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				 * 
				 * 
				 * sdf.setTimeZone(TimeZone.getTimeZone("GMT")); Date date=new
				 * Date(); String s=sdf.format(date); SimpleDateFormat
				 * dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				 */
				// Date parsedDate = dateFormat.parse(s);

				SPLData data = new SPLData();

				Timestamp timestamp = rs.getTimestamp(41);

				data.setTimeStamp(timestamp);
				data.setTimeStampString(timestamp.toString());
				// System.out.println("data.getTimeStamp: " +
				// data.getTimeStamp());

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setLocalDepartureDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setPassengerName(rs.getString("PSGR_NME"));

				data.setSeatAssignment(rs.getString("ROW_SEAT_NUM"));

				data.setPnrLocator(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA")) && (!origSpilTypCde
								.trim().equals("")))
								// infant ET code change begins
								
								&& (!origSpilTypCde.trim().equals("IN")))								
								
								// infant ET code change begins

				

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if(origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends

				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_flight_inquiry_lookup_OD.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_flight_inquiry_lookup_OD " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLSelectedData> call_selected_record_remarks_lookup_OD(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String legOrigApCode,

	String seqNum,

	String rowSeat,

	String pnrNum,

	Timestamp timeStamp)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLSelectedData> selectList = new ArrayList<SPLSelectedData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT * ");

		/*
		 * sqlBuffer.append("LEG_LCL_DPTR_DTE, ");
		 * 
		 * sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");
		 * 
		 * sqlBuffer.append("OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("LEG_ORIG_AP_CDE, ");
		 * 
		 * sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("ROW_SEAT_NUM, ");
		 * 
		 * sqlBuffer.append("RMK_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("RMK_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("RMK_TXT ");
		 */
		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR_RMK_OD ");

		sqlBuffer.append("WHERE LEG_LCL_DPTR_YRMO = '"
				+ retrieveYearMonth(localDepartureDate) + "' ");

		sqlBuffer
				.append("AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		sqlBuffer.append("AND LEG_ORIG_AP_CDE = '" + legOrigApCode + "' ");

		sqlBuffer.append("AND MULT_DPTR_SEQ_NUM = " + seqNum + " ");

		sqlBuffer.append("AND ROW_SEAT_NUM = '" + rowSeat + "' ");

		// /on demand begin
		System.out.println("timeStamp value is: " + timeStamp);
		sqlBuffer.append("AND FILE_RCVD_LTS = '" + timeStamp + "' ");
		// on demand end

		sqlBuffer.append("ORDER BY RMK_SEQ_NUM");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());
		Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
				"In SPLJBean - call_selected_record_remarks_lookup_OD");

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLSelectedData data = new SPLSelectedData();
				// on demand begin
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				data.setTimeStampString(rs.getTimestamp("FILE_RCVD_LTS")
						.toString());
				// on demand end
				data.setSsrCde(rs.getString("RMK_TYP_CDE"));

				data.setRemarks1(rs.getString("RMK_TXT"));
				// on demand begin 8/20
				data.setTimeStamp(rs.getTimestamp(13));
				System.out.println("Timestamp value of SPLSelectedData: "
						+ data.getTimeStamp());
				// on demand end
				System.out.println();
				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_selected_record_lookup_OD");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_selected_record_lookup" + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_passenger_inquiry_lookup_OD(

	String passengerName,

	String localDepartureDate)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		System.out.println("In SPLJBean.call_passenger_inquiry_lookup_OD");

		sqlBuffer.append("SELECT * ");

		/*
		 * sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");
		 * 
		 * sqlBuffer.append("LEG_LCL_DPTR_DTE, ");
		 * 
		 * sqlBuffer.append("OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("LEG_ORIG_AP_CDE, ");
		 * 
		 * sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("ROW_SEAT_NUM, ");
		 * 
		 * sqlBuffer.append("PNR_LOCTR_NUM, ");
		 * 
		 * sqlBuffer.append("ITINSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("INV_CL_CDE, ");
		 * 
		 * sqlBuffer.append("BKD_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("ACTL_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("SPIL_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("PSGR_NME, ");
		 * 
		 * sqlBuffer.append("SSR_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("CUST_ID, ");
		 * 
		 * sqlBuffer.append("BKG_CRTN_GDT, ");
		 * 
		 * sqlBuffer.append("TKT_DOC_ISS_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LTM, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LTM, ");
		 * 
		 * sqlBuffer.append("FLT_CX_IND, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("TKT_NUM, ");
		 * 
		 * sqlBuffer.append("FF_AL_CDE, ");
		 * 
		 * sqlBuffer.append("FF_ID, ");
		 * 
		 * sqlBuffer.append("FF_TIER_LVL_DESC, ");
		 * 
		 * sqlBuffer.append("GOVT_DOC_NUM ");
		 */

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR_OD ");

		sqlBuffer.append(

		"WHERE LEG_LCL_DPTR_YRMO = '"

		+ retrieveYearMonth(localDepartureDate)

		+ "' ");

		sqlBuffer.append(

		"AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND PSGR_NME LIKE '" + passengerName + "%' ");

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setLocalDepartureDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setPassengerName(rs.getString("PSGR_NME"));

				data.setSeatAssignment(rs.getString("ROW_SEAT_NUM"));

				data.setPnrLocator(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// on demand addition
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				data.setTimeStampString(data.getTimeStamp().toString()); // added
																			// for
																			// OD
																			// 1/17/16

				// on demand end

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA")) && (!origSpilTypCde
								.trim().equals(""))
// infant ET code change begins
								
								&& (!origSpilTypCde.trim().equals("IN")))								
								
								// infant ET code change begins

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if(origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends
				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_passenger_inquiry_lookup_OD.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_passenger_inquiry_lookup_OD " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_frequent_flier_inquiry_lookup_OD(

	String airlineCode,

	String programId)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT * ");

		/*
		 * sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");
		 * 
		 * sqlBuffer.append("LEG_LCL_DPTR_DTE, ");
		 * 
		 * sqlBuffer.append("OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("LEG_ORIG_AP_CDE, ");
		 * 
		 * sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("ROW_SEAT_NUM, ");
		 * 
		 * sqlBuffer.append("PNR_LOCTR_NUM, ");
		 * 
		 * sqlBuffer.append("ITINSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("INV_CL_CDE, ");
		 * 
		 * sqlBuffer.append("BKD_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("ACTL_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("SPIL_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("PSGR_NME, ");
		 * 
		 * sqlBuffer.append("SSR_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("CUST_ID, ");
		 * 
		 * sqlBuffer.append("BKG_CRTN_GDT, ");
		 * 
		 * sqlBuffer.append("TKT_DOC_ISS_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LTM, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LTM, ");
		 * 
		 * sqlBuffer.append("FLT_CX_IND, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("TKT_NUM, ");
		 * 
		 * sqlBuffer.append("FF_AL_CDE, ");
		 * 
		 * sqlBuffer.append("FF_ID, ");
		 * 
		 * sqlBuffer.append("FF_TIER_LVL_DESC, ");
		 * 
		 * sqlBuffer.append("GOVT_DOC_NUM ");
		 */

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR_OD ");

		sqlBuffer.append("WHERE FF_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND FF_ID = '" + programId + "' ");

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setLocalDepartureDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setPassengerName(rs.getString("PSGR_NME"));

				data.setSeatAssignment(rs.getString("ROW_SEAT_NUM"));

				data.setPnrLocator(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));
				// On demand code begin
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				data.setTimeStampString(data.getTimeStamp().toString()); // added
																			// for
																			// OD
																			// 1/17/16

				// on demand end // On Demand code ends
				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA")) && (!origSpilTypCde
								.trim().equals(""))
								// infant ET code change begins
								
								&& (!origSpilTypCde.trim().equals("IN")))								
								
								// infant ET code change ends

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if(origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends
				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_frequent_flier_inquiry_lookup.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_frequent_flier_inquiry_lookup "

			+ e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLSelectedData> call_selected_record_lookup_waitlist_OD(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String passengerName,

	String pnrLocator,

	Timestamp timeStamp)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLSelectedData> selectList = new ArrayList<SPLSelectedData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT * ");

		/*
		 * sqlBuffer.append("LEG_LCL_DPTR_DTE, ");
		 * 
		 * sqlBuffer.append("OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("LEG_ORIG_AP_CDE, ");
		 * 
		 * sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("ROW_SEAT_NUM, ");
		 * 
		 * sqlBuffer.append("PNR_LOCTR_NUM, ");
		 * 
		 * sqlBuffer.append("ITINSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("INV_CL_CDE, ");
		 * 
		 * sqlBuffer.append("SPIL_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("PSGR_NME, ");
		 * 
		 * sqlBuffer.append("SSR_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("BKD_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("ACTL_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("CUST_ID, ");
		 * 
		 * sqlBuffer.append("BKG_CRTN_GDT, ");
		 * 
		 * sqlBuffer.append("TKT_DOC_ISS_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LTM, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LTM, ");
		 * 
		 * sqlBuffer.append("FLT_CX_IND, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("TKT_NUM, ");
		 * 
		 * sqlBuffer.append("FF_AL_CDE, ");
		 * 
		 * sqlBuffer.append("FF_ID, ");
		 * 
		 * sqlBuffer.append("FF_TIER_LVL_DESC, ");
		 * 
		 * sqlBuffer.append("GOVT_DOC_NUM ");
		 */

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR_OD ");

		sqlBuffer.append("WHERE LEG_LCL_DPTR_YRMO = '"
				+ retrieveYearMonth(localDepartureDate) + "' ");
		sqlBuffer.append("AND FILE_RCVD_LTS = '" + timeStamp + "' ");

		sqlBuffer
				.append("AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");

		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		sqlBuffer.append("AND PSGR_NME LIKE '" + passengerName + "%' ");

		// sqlBuffer.append("AND PSGR_NME = '" + passengerName + "' ");

		sqlBuffer.append("AND PNR_LOCTR_NUM = '" + pnrLocator + "' ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLSelectedData data = new SPLSelectedData();

				data.setFlightNum(rs.getString("OP_AL_CDE").trim()
						+ rs.getString("OP_FLT_NUM"));

				// on demand begin
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				// on demand end

				data.setDepDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setBoardPoint(rs.getString("LEG_ORIG_AP_CDE"));

				data.setOffPoint(rs.getString("ITINSEG_DESTAP_CDE"));

				data.setPnr(rs.getString("PNR_LOCTR_NUM"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setType(rs.getString("SPIL_TYP_CDE"));

				data.setConFrom1(rs.getString("ARRSEG_OP_AL_CDE").trim()
						+ rs.getString("ARRSEG_OP_FLT_NUM"));

				data.setConFrom2(rs.getString("ARRSEG_ORIGAP_CDE"));

				data.setConTo1(rs.getString("NEXTSEG_OP_AL_CDE").trim()
						+ rs.getString("NEXTSEG_OP_FLT_NUM"));

				// Added by Hari 04/26/2011

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				// end

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				data.setConTo2(rs.getString("NEXTSEG_DESTAP_CDE"));

				data.setSelRowSeat(rs.getString("ROW_SEAT_NUM"));

				data.setSelPassenger(rs.getString("PSGR_NME"));

				data.setSelLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSelSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA")) && (!origSpilTypCde
								.trim().equals(""))
								// infant ET code change begins
								
								&& (!origSpilTypCde.trim().equals("IN")))								
								
								// infant ET code change ends

				)
					

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if(origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends

				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_selected_record_lookup_OD");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_selected_record_lookup_OD" + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_passenger_lookup_waitlist_OD(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String pnrLocator,

	Timestamp timeStamp)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
				"OD parameters recieved:" + localDepartureDate + "--"
						+ airlineCode + "--" + flightNumber + "--" + pnrLocator);

		sqlBuffer.append("SELECT ");

		sqlBuffer.append("LEG_LCL_DPTR_DTE, ");

		sqlBuffer.append("OP_AL_CDE, ");

		sqlBuffer.append("OP_FLT_NUM, ");

		sqlBuffer.append("LEG_ORIG_AP_CDE, ");

		sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");

		sqlBuffer.append("ROW_SEAT_NUM, ");

		sqlBuffer.append("PNR_LOCTR_NUM, ");

		sqlBuffer.append("ITINSEG_DESTAP_CDE, ");

		sqlBuffer.append("INV_CL_CDE, ");

		sqlBuffer.append("SPIL_TYP_CDE, ");

		sqlBuffer.append("PSGR_NME, ");

		sqlBuffer.append("SSR_TYP_CDE, ");

		sqlBuffer.append("CUST_ID, ");

		sqlBuffer.append("BKG_CRTN_GDT, ");

		sqlBuffer.append("TKT_DOC_ISS_LDT, ");

		sqlBuffer.append("PAX_CKIN_LDT, ");

		sqlBuffer.append("PAX_CKIN_LTM, ");

		sqlBuffer.append("PAX_OBRD_LDT, ");

		sqlBuffer.append("PAX_OBRD_LTM, ");

		sqlBuffer.append("FLT_CX_IND, ");

		sqlBuffer.append("ARRSEG_OP_AL_CDE, ");

		sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");

		sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");

		sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");

		sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");

		sqlBuffer.append("TKT_NUM, ");

		sqlBuffer.append("FF_AL_CDE, ");

		sqlBuffer.append("FF_ID, ");

		sqlBuffer.append("FF_TIER_LVL_DESC, ");

		sqlBuffer.append("GOVT_DOC_NUM ");

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR_OD ");

		sqlBuffer.append("WHERE LEG_LCL_DPTR_YRMO = '"
				+ retrieveYearMonth(localDepartureDate) + "' ");

		sqlBuffer
				.append("AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

		sqlBuffer.append("AND OP_AL_CDE = '" + airlineCode + "' ");
		// ////////////
		sqlBuffer.append("AND FILE_RCVD_LTS = '" + timeStamp + "' ");
		// ///////////
		sqlBuffer.append("AND OP_FLT_Num = '" + flightNumber + "' ");

		sqlBuffer.append("AND PNR_LOCTR_NUM = '" + pnrLocator + "' ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				data.setPassengerName(rs.getString("PSGR_NME"));

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_selected_record_lookup_OD");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_selected_record_lookup_OD" + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_other_inquiry_lookup_OD(

	String ticketNumber,

	String pnrLocator,

	String governmentId)

	throws DBException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT * ");

		/*
		 * sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");
		 * 
		 * sqlBuffer.append("LEG_LCL_DPTR_DTE, ");
		 * 
		 * sqlBuffer.append("OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("LEG_ORIG_AP_CDE, ");
		 * 
		 * sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("ROW_SEAT_NUM, ");
		 * 
		 * sqlBuffer.append("PNR_LOCTR_NUM, ");
		 * 
		 * sqlBuffer.append("ITINSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("INV_CL_CDE, ");
		 * 
		 * sqlBuffer.append("BKD_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("ACTL_CPMT_CD, ");
		 * 
		 * sqlBuffer.append("SPIL_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("PSGR_NME, ");
		 * 
		 * sqlBuffer.append("SSR_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("CUST_ID, ");
		 * 
		 * sqlBuffer.append("BKG_CRTN_GDT, ");
		 * 
		 * sqlBuffer.append("TKT_DOC_ISS_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_CKIN_LTM, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LDT, ");
		 * 
		 * sqlBuffer.append("PAX_OBRD_LTM, ");
		 * 
		 * sqlBuffer.append("FLT_CX_IND, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("ARRSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("ARRSEG_ORIGAP_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("NEXTSEG_DESTAP_CDE, ");
		 * 
		 * sqlBuffer.append("TKT_NUM, ");
		 * 
		 * sqlBuffer.append("FF_AL_CDE, ");
		 * 
		 * sqlBuffer.append("FF_ID, ");
		 * 
		 * sqlBuffer.append("FF_TIER_LVL_DESC, ");
		 * 
		 * sqlBuffer.append("GOVT_DOC_NUM ");
		 */

		sqlBuffer.append("FROM DB2CRS.T_SPIL_PSGR_OD ");

		sqlBuffer.append("WHERE ");

		if (ticketNumber.length() > 0) {

			sqlBuffer.append("TKT_NUM = '" + ticketNumber + "' ");

			if ((pnrLocator.length() > 0) || (governmentId.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (pnrLocator.length() > 0) {

			sqlBuffer.append("PNR_LOCTR_NUM = '" + pnrLocator + "' ");

			if (governmentId.length() > 0) {

				sqlBuffer.append("AND ");

			}

		}

		if (governmentId.length() > 0) {

			sqlBuffer.append("GOVT_DOC_NUM = '" + governmentId + "' ");

		}

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			while (rs.next()) {

				SPLData data = new SPLData();

				// on demand begin
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				// on demand end

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setLocalDepartureDate(rs.getString("LEG_LCL_DPTR_DTE"));

				data.setPassengerName(rs.getString("PSGR_NME"));

				data.setSeatAssignment(rs.getString("ROW_SEAT_NUM"));

				data.setPnrLocator(rs.getString("PNR_LOCTR_NUM"));

				data.setTicketNumber(rs.getString("TKT_NUM"));

				data.setFrequentFlierAirline(rs.getString("FF_AL_CDE"));

				data.setFrequentFlierId(rs.getString("FF_ID"));

				data.setFrequentFlierTier(rs.getString("FF_TIER_LVL_DESC"));

				data.setLegOrigApCode(rs.getString("LEG_ORIG_AP_CDE"));

				data.setSeqNum(rs.getString("MULT_DPTR_SEQ_NUM"));

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setClass1(rs.getString("INV_CL_CDE"));

				data.setCustomerID(rs.getString("CUST_ID"));

				data.setPnrCreateDate(rs.getString("BKG_CRTN_GDT"));

				data.setTicketIssueDate(rs.getString("TKT_DOC_ISS_LDT"));

				data.setCheckinDate(rs.getString("PAX_CKIN_LDT"));

				data.setCheckinTime(rs.getString("PAX_CKIN_LTM"));

				data.setOnBoardDate(rs.getString("PAX_OBRD_LDT"));

				data.setOnBoardTime(rs.getString("PAX_OBRD_LTM"));

				data.setCnclInd(rs.getString("FLT_CX_IND"));

				String origSpilTypCde = rs.getString("SPIL_TYP_CDE");

				String origBkdCpmtCd = rs.getString("BKD_CPMT_CD");

				String origActlCpmtCd = rs.getString("ACTL_CPMT_CD");

				String origSeat = rs.getString("ROW_SEAT_NUM");

				data.setTimeStampString(rs.getTimestamp("FILE_RCVD_LTS")
						.toString());
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));

				String newSpilTypCde = null;

				String newBkdCmptCd = null;

				String newActlCmptCd = null;

				// Ajeet- If SpilTyp is SA/PS keep it else make spil typ blank
				// and split spil type into bkd and actl cpmt

				if (

				(origSpilTypCde != null)
						&&

						((!origSpilTypCde.trim().equals("PS"))
								&& (!origSpilTypCde.trim().equals("SA")) && (!origSpilTypCde
								.trim().equals(""))
								
								// infant ET code change begins
								
								&& (!origSpilTypCde.trim().equals("IN")))								
								
								// infant ET code change begins

				)

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = "";

				}
				// infant ET code changes begins
				else if(origSpilTypCde.trim().equals("IN"))

				{

					newBkdCmptCd = origSpilTypCde.trim().substring(0, 1);

					newActlCmptCd = origSpilTypCde.trim().substring(1, 2);

					newSpilTypCde = origSpilTypCde;

				}
				// infant ET code changes ends
				else

				{

					newBkdCmptCd = origBkdCpmtCd;

					newActlCmptCd = origActlCpmtCd;

					newSpilTypCde = origSpilTypCde;

				}

				if (origSeat.trim().endsWith("P")
						|| origSeat.trim().endsWith("R"))

				{

					newSpilTypCde = "JS";

				}

				data.setBookedClass(newBkdCmptCd);

				data.setFlownClass(newActlCmptCd);

				data.setType(newSpilTypCde);

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_other_inquiry_lookup_OD.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_other_inquiry_lookup_OD " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_waitlist_inquiry_lookup_OD(

	String airlineCode,

	String flightNumber,

	String localDepartureDate,

	String passengerName,

	String pnrLocator,

	Timestamp timeStamp)

	throws DBException {

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
				"In waitlist Inquiry call in EJB OD");

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT * ");

		/*
		 * sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");
		 * 
		 * sqlBuffer.append("LEG_LCL_DPTR_DTE, ");
		 * 
		 * sqlBuffer.append("OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("LEG_ORIG_AP_CDE, ");
		 * 
		 * sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("WL_PSGR_LST_NUM, ");
		 * 
		 * sqlBuffer.append("PNR_LOCTR_NUM, ");
		 * 
		 * sqlBuffer.append("PSGR_NME, ");
		 * 
		 * sqlBuffer.append("WL_VRFY_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("WL_BRD_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("WL_RES_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("SEG_DEST_AP_CDE, ");
		 * 
		 * sqlBuffer.append("WL_SVC_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("WL_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("TRVL_CL_CDE, ");
		 * 
		 * sqlBuffer.append("EMP_SEN_DTE, ");
		 * 
		 * sqlBuffer.append("WL_UTC_CRTN_TME ");
		 */

		sqlBuffer.append("FROM DB2CRS.T_SPIL_WL_PSGR_OD ");

		sqlBuffer.append("WHERE ");

		if (airlineCode.length() > 0) {

			sqlBuffer.append("OP_AL_CDE = '" + airlineCode + "' ");

			if ((flightNumber.length() > 0)

			|| (localDepartureDate.length() > 0)

			|| (passengerName.length() > 0)

			|| (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (flightNumber.length() > 0) {

			sqlBuffer.append("OP_FLT_Num = '" + flightNumber + "' ");

			if ((localDepartureDate.length() > 0)

			|| (passengerName.length() > 0)

			|| (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (localDepartureDate.length() > 0) {

			sqlBuffer.append("LEG_LCL_DPTR_YRMO = '"

			+ retrieveYearMonth(localDepartureDate)

			+ "' ");

			sqlBuffer.append(

			"AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

			if ((passengerName.length() > 0) || (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (passengerName.length() > 0) {

			sqlBuffer.append("PSGR_NME LIKE '" + passengerName + "%' ");

			if (pnrLocator.length() > 0) {

				sqlBuffer.append("AND ");

			}

		}

		if (pnrLocator.length() > 0) {

			sqlBuffer.append("PNR_LOCTR_NUM = '" + pnrLocator + "' ");

		}

		sqlBuffer
				.append("ORDER BY LEG_ORIG_AP_CDE, OP_FLT_NUM, LEG_LCL_DPTR_DTE, WL_PSGR_LST_NUM ");

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
					"In waitlist Inquiry OD");

			while (rs.next()) {

				SPLData data = new SPLData();
				// on demand begin
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				data.setTimeStampString(rs.getTimestamp("FILE_RCVD_LTS")
						.toString());

				// on demand end

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setWaitlistFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setWaitlistLocalDepartureDate(rs
						.getString("LEG_LCL_DPTR_DTE"));

				data.setWaitlistOrigin(rs.getString("LEG_ORIG_AP_CDE"));

				data.setWaitlistPNRLocator(rs.getString("PNR_LOCTR_NUM"));

				String tempWNum = rs.getString("WL_PSGR_LST_NUM");

				// pad waitlist num for sorting in scroll list

				if (tempWNum.trim().length() < 2) {

					tempWNum = "000" + tempWNum;

				} else if (tempWNum.trim().length() < 3) {

					tempWNum = "00" + tempWNum;

				} else if (tempWNum.trim().length() < 4) {

					tempWNum = "0" + tempWNum;

				}

				// original code

				data.setWaitlistSequence(tempWNum);

				// Added by Hari to display the wait list for DL flights some
				// thing like '1-02' etc

				// String listNum = rs.getString("WL_PSGR_LST_NUM");

				// //Date dptrDate =
				// SPLJUtil.formatDate(rs.getString("LEG_LCL_DPTR_DTE"));

				// if(listNum != null & listNum.trim().length()>=3 &&
				// !rs.getString("LEG_LCL_DPTR_DTE").equals("01/01/2011")){

				// data.setWaitlistSequence(listNum.substring(0,listNum.length()-2)+"-"+listNum.substring(listNum.length()-2,listNum.length()));

				// }
				// on demand begin
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				data.setTimeStampString(rs.getTimestamp("FILE_RCVD_LTS")
						.toString());
				// on demand end

				data.setWaitlistName(rs.getString("PSGR_NME"));

				data.setWaitlistV(rs.getString("WL_VRFY_TYP_CDE"));

				data.setWaitlistB(rs.getString("WL_BRD_TYP_CDE"));

				data.setWaitlistR(rs.getString("WL_RES_TYP_CDE"));

				data.setWaitlistDestination(rs.getString("SEG_DEST_AP_CDE"));

				data.setWaitlistService(rs.getString("WL_SVC_TYP_CDE"));

				// Ajeet: Split Waitlist service to Booked and Flown Waitlist
				// Class

				String waitlistService = rs.getString("WL_SVC_TYP_CDE");

				String newWaitBkdClass = null;

				String newWaitFlnClass = null;

				if ((waitlistService != null)
						&& (!waitlistService.trim().equals("")))

				{

					newWaitBkdClass = waitlistService.trim().substring(0, 1);

					if (waitlistService.trim().length() >= 2)

					{

						newWaitFlnClass = waitlistService.trim()
								.substring(1, 2);

					}

				}

				data.setWaitlistBookedClass(newWaitBkdClass);

				data.setWaitlistFlownClass(newWaitFlnClass);

				data.setWaitlistPTY(rs.getString("WL_PSGR_LST_NUM"));

				data.setWaitlistType(rs.getString("WL_TYP_CDE"));

				data.setWaitlistCLS(rs.getString("TRVL_CL_CDE"));

				if (rs.getString("EMP_SEN_DTE").equals("1900-01-01")) {

					data.setWaitlistSeniority("000000");

				} else if (rs.getString("EMP_SEN_DTE").equals("0001-01-01")) {

					data.setWaitlistSeniority("INVALD");

				}

				else {

					data.setWaitlistSeniority(rs.getString("EMP_SEN_DTE"));

				}

				data.setWaitlistTime(rs.getString("WL_UTC_CRTN_TME"));

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_waitlist_inquiry_lookup.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_waitlist_inquiry_lookup " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLData> call_waitlist_inquiry_lookup_OD_1(

	String airlineCode,

	String flightNumber,

	String localDepartureDate,

	String passengerName,

	String pnrLocator,

	Timestamp timeStamp)

	throws DBException {

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
				"In waitlist Inquiry call in EJB OD");

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ArrayList<SPLData> selectList = new ArrayList<SPLData>();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("SELECT * ");

		/*
		 * sqlBuffer.append("LEG_LCL_DPTR_YRMO, ");
		 * 
		 * sqlBuffer.append("LEG_LCL_DPTR_DTE, ");
		 * 
		 * sqlBuffer.append("OP_AL_CDE, ");
		 * 
		 * sqlBuffer.append("OP_FLT_NUM, ");
		 * 
		 * sqlBuffer.append("LEG_ORIG_AP_CDE, ");
		 * 
		 * sqlBuffer.append("MULT_DPTR_SEQ_NUM, ");
		 * 
		 * sqlBuffer.append("WL_PSGR_LST_NUM, ");
		 * 
		 * sqlBuffer.append("PNR_LOCTR_NUM, ");
		 * 
		 * sqlBuffer.append("PSGR_NME, ");
		 * 
		 * sqlBuffer.append("WL_VRFY_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("WL_BRD_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("WL_RES_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("SEG_DEST_AP_CDE, ");
		 * 
		 * sqlBuffer.append("WL_SVC_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("WL_TYP_CDE, ");
		 * 
		 * sqlBuffer.append("TRVL_CL_CDE, ");
		 * 
		 * sqlBuffer.append("EMP_SEN_DTE, ");
		 * 
		 * sqlBuffer.append("WL_UTC_CRTN_TME ");
		 */

		sqlBuffer.append("FROM DB2CRS.T_SPIL_WL_PSGR_OD ");

		sqlBuffer.append("WHERE ");

		if (timeStamp != null) {

			sqlBuffer.append("FILE_RCVD_LTS = '" + airlineCode + "' ");

			if ((flightNumber.length() > 0)

			|| (localDepartureDate.length() > 0)

			|| (passengerName.length() > 0)

			|| (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}
		if (airlineCode.length() > 0) {

			sqlBuffer.append("OP_AL_CDE = '" + airlineCode + "' ");

			if ((flightNumber.length() > 0)

			|| (localDepartureDate.length() > 0)

			|| (passengerName.length() > 0)

			|| (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (flightNumber.length() > 0) {

			sqlBuffer.append("OP_FLT_Num = '" + flightNumber + "' ");

			if ((localDepartureDate.length() > 0)

			|| (passengerName.length() > 0)

			|| (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (localDepartureDate.length() > 0) {

			sqlBuffer.append("LEG_LCL_DPTR_YRMO = '"

			+ retrieveYearMonth(localDepartureDate)

			+ "' ");

			sqlBuffer.append(

			"AND LEG_LCL_DPTR_DTE = '" + localDepartureDate + "' ");

			if ((passengerName.length() > 0) || (pnrLocator.length() > 0)) {

				sqlBuffer.append("AND ");

			}

		}

		if (passengerName.length() > 0) {

			sqlBuffer.append("PSGR_NME LIKE '" + passengerName + "%' ");

			if (pnrLocator.length() > 0) {

				sqlBuffer.append("AND ");

			}

		}

		if (pnrLocator.length() > 0) {

			sqlBuffer.append("PNR_LOCTR_NUM = '" + pnrLocator + "' ");

		}

		sqlBuffer
				.append("ORDER BY LEG_ORIG_AP_CDE, OP_FLT_NUM, LEG_LCL_DPTR_DTE, WL_PSGR_LST_NUM ");

		sqlBuffer.append("OPTIMIZE For 1 row ");

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlBuffer.toString());

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlBuffer.toString());

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
					"In waitlist Inquiry OD");

			while (rs.next()) {

				SPLData data = new SPLData();
				// on demand begin
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				data.setTimeStampString(rs.getTimestamp("FILE_RCVD_LTS")
						.toString());

				// on demand end

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				data.setWaitlistFlightNumber(rs.getString("OP_FLT_NUM"));

				data.setWaitlistLocalDepartureDate(rs
						.getString("LEG_LCL_DPTR_DTE"));

				data.setWaitlistOrigin(rs.getString("LEG_ORIG_AP_CDE"));

				data.setWaitlistPNRLocator(rs.getString("PNR_LOCTR_NUM"));

				String tempWNum = rs.getString("WL_PSGR_LST_NUM");

				// pad waitlist num for sorting in scroll list

				if (tempWNum.trim().length() < 2) {

					tempWNum = "000" + tempWNum;

				} else if (tempWNum.trim().length() < 3) {

					tempWNum = "00" + tempWNum;

				} else if (tempWNum.trim().length() < 4) {

					tempWNum = "0" + tempWNum;

				}

				// original code

				data.setWaitlistSequence(tempWNum);

				// Added by Hari to display the wait list for DL flights some
				// thing like '1-02' etc

				// String listNum = rs.getString("WL_PSGR_LST_NUM");

				// //Date dptrDate =
				// SPLJUtil.formatDate(rs.getString("LEG_LCL_DPTR_DTE"));

				// if(listNum != null & listNum.trim().length()>=3 &&
				// !rs.getString("LEG_LCL_DPTR_DTE").equals("01/01/2011")){

				// data.setWaitlistSequence(listNum.substring(0,listNum.length()-2)+"-"+listNum.substring(listNum.length()-2,listNum.length()));

				// }
				// on demand begin
				data.setTimeStamp(rs.getTimestamp("FILE_RCVD_LTS"));
				data.setTimeStampString(rs.getTimestamp("FILE_RCVD_LTS")
						.toString());
				// on demand end

				data.setWaitlistName(rs.getString("PSGR_NME"));

				data.setWaitlistV(rs.getString("WL_VRFY_TYP_CDE"));

				data.setWaitlistB(rs.getString("WL_BRD_TYP_CDE"));

				data.setWaitlistR(rs.getString("WL_RES_TYP_CDE"));

				data.setWaitlistDestination(rs.getString("SEG_DEST_AP_CDE"));

				data.setWaitlistService(rs.getString("WL_SVC_TYP_CDE"));

				// Ajeet: Split Waitlist service to Booked and Flown Waitlist
				// Class

				String waitlistService = rs.getString("WL_SVC_TYP_CDE");

				String newWaitBkdClass = null;

				String newWaitFlnClass = null;

				if ((waitlistService != null)
						&& (!waitlistService.trim().equals("")))

				{

					newWaitBkdClass = waitlistService.trim().substring(0, 1);

					if (waitlistService.trim().length() >= 2)

					{

						newWaitFlnClass = waitlistService.trim()
								.substring(1, 2);

					}

				}

				data.setWaitlistBookedClass(newWaitBkdClass);

				data.setWaitlistFlownClass(newWaitFlnClass);

				data.setWaitlistPTY(rs.getString("WL_PSGR_LST_NUM"));

				data.setWaitlistType(rs.getString("WL_TYP_CDE"));

				data.setWaitlistCLS(rs.getString("TRVL_CL_CDE"));

				if (rs.getString("EMP_SEN_DTE").equals("1900-01-01")) {

					data.setWaitlistSeniority("000000");

				} else if (rs.getString("EMP_SEN_DTE").equals("0001-01-01")) {

					data.setWaitlistSeniority("INVALD");

				}

				else {

					data.setWaitlistSeniority(rs.getString("EMP_SEN_DTE"));

				}

				data.setWaitlistTime(rs.getString("WL_UTC_CRTN_TME"));

				data.setAirlineCode(rs.getString("OP_AL_CDE"));

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(

			SPLJBean.class,

			Logger.LEVEL_ERROR,

			"In SPLJBean - method: call_waitlist_inquiry_lookup.");

			e.printStackTrace();

			throw new DBException(

			"In SPLJBean - Method: call_waitlist_inquiry_lookup " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}

	public ArrayList<SPLSelectedData> call_ssr_inquiry_lookup_OD(
			String localDepartureDate, String airlineCode, String flightNumber,

			String ssrCode) throws DBException {

		Connection conn = null;

		ArrayList<SPLSelectedData> selectList = new ArrayList<SPLSelectedData>();

		ResultSet rs = null;

		Statement stmt = null;

		String localDepartureYrMo = localDepartureDate.substring(0, 4)
				+ localDepartureDate.substring(5, 7);

		try {

			StringBuffer sqlstr = new StringBuffer();

			sqlstr.append("SELECT  RMK.OP_AL_CDE as Airline, ");
			// /On Demand
			sqlstr.append("        RMK.FILE_RCVD_LTS as Time_Stamp, ");

			// On Demand
			sqlstr.append("        RMK.OP_FLT_NUM as Flight_Num, ");

			sqlstr.append("        RMK.LEG_ORIG_AP_CDE as Board_Pt, ");

			sqlstr.append("        RMK.LEG_LCL_DPTR_DTE as Dept_Date, ");

			sqlstr.append("        RTRIM(PSGR.PSGR_NME) as Passenger_Name, ");

			sqlstr.append("        RMK.RMK_TYP_CDE as Ssr_Cde, ");

			sqlstr.append("        RMK.RMK_TXT as Remark_txt, ");

			sqlstr.append("        PSGR.INV_CL_CDE as Class, ");

			sqlstr.append("        RMK.ROW_SEAT_NUM as Seat_Num, ");

			sqlstr.append("        PSGR.PNR_LOCTR_NUM as Pnr_Loctr, ");

			sqlstr.append("        RMK.LEG_LCL_DPTR_YRMO, ");

			sqlstr.append("        RMK.MULT_DPTR_SEQ_NUM as Seq_Num, ");

			sqlstr.append("        RMK.RMK_SEQ_NUM ");

			sqlstr.append("FROM    DB2CRS.T_SPIL_PSGR_RMK_OD RMK, ");

			sqlstr.append("        DB2CRS.T_SPIL_PSGR_OD PSGR ");

			sqlstr.append("WHERE   RMK.LEG_LCL_DPTR_YRMO = '"
					+ localDepartureYrMo + "' ");

			sqlstr.append("AND     RMK.LEG_LCL_DPTR_DTE = '"
					+ localDepartureDate + "' ");

			sqlstr.append("AND     RMK.OP_AL_CDE = '" + airlineCode + "' ");

			sqlstr.append("AND     RMK.OP_FLT_NUM = '" + flightNumber + "' ");

			if (!ssrCode.equals("")) {

				// sqlstr.append(" AND (RMK.RMK_TYP_CDE LIKE '%" + ssrCode +
				// "%' " +

				// This is changed by Hari to improve the performance of data
				// pull

				// up on Brenda's suggestion - 03/07/2011

				sqlstr.append(" AND (RMK.RMK_TYP_CDE = '" + ssrCode + "' "
						+ "OR RMK.RMK_TXT LIKE '%" + ssrCode + "%' )");

			}

			sqlstr.append("AND RMK.LEG_LCL_DPTR_YRMO  = PSGR.LEG_LCL_DPTR_YRMO ");

			sqlstr.append("AND RMK.LEG_LCL_DPTR_DTE = PSGR.LEG_LCL_DPTR_DTE ");

			sqlstr.append("AND RMK.OP_AL_CDE = PSGR.OP_AL_CDE ");

			sqlstr.append("AND RMK.OP_FLT_NUM = PSGR.OP_FLT_NUM ");

			sqlstr.append("AND RMK.LEG_ORIG_AP_CDE = PSGR.LEG_ORIG_AP_CDE ");

			sqlstr.append("AND RMK.MULT_DPTR_SEQ_NUM = PSGR.MULT_DPTR_SEQ_NUM ");

			sqlstr.append("AND RMK.ROW_SEAT_NUM = PSGR.ROW_SEAT_NUM ");

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlstr.toString());

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, localDepartureDate);

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, airlineCode);

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, flightNumber);

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, sqlstr.toString());

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sqlstr.toString());

			while (rs.next()) {

				SPLSelectedData data = new SPLSelectedData();
				// on demand
				data.setTimeStamp(rs.getTimestamp("Time_Stamp"));
				data.setTimeStampString(rs.getTimestamp("Time_Stamp")
						.toString());
				// on demand end
				data.setAirlineCode(rs.getString("Airline"));

				data.setFlightNumber(rs.getString("Flight_Num"));

				data.setLegOrigApCode(rs.getString("Board_Pt"));

				data.setLocalDepartureDate(rs.getString("Dept_Date"));

				data.setPassengerName(rs.getString("Passenger_Name"));

				data.setSsrCde(rs.getString("Ssr_Cde"));

				data.setRemarks1(rs.getString("Remark_txt"));

				data.setClass1(rs.getString("Class"));

				data.setSeatAssignment(rs.getString("Seat_Num"));

				data.setPnrLocator(rs.getString("Pnr_Loctr"));

				data.setSeqNum(rs.getString("Seq_Num"));

				// on demand begin
				data.setTimeStamp(rs.getTimestamp("Time_Stamp"));
				data.setTimeStampString(rs.getTimestamp("Time_Stamp")
						.toString());
				// on demand end

				selectList.add(data);

			}

		} catch (SQLException e) {

			Logger.log(
					SPLJBean.class,
					Logger.LEVEL_ERROR,
					"In SPLJBean - method: call_ssr_inquiry_lookup_OD. "
							+ e.getMessage());

			e.printStackTrace();

			throw new DBException(
					"In SPLJBean - Method: call_ssr_inquiry_lookup_OD " + e);

		} finally {

			closeResources(rs, stmt, conn);

		}

		return selectList;

	}
	// On Demand changes end

}
