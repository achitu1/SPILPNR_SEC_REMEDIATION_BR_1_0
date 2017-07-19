package DAO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.sql.DataSource;

//import com.delta.PRA.PNRJ.EJB.PNRJBean;
import com.nwa.PRA.DataSourceLocHelper.DataSourceLocator;
import com.nwa.PRA.DataSourceLocHelper.DataSourceLocatorException;
import com.nwa.PRA.logger.Logger;

//import org.apache.log4j.Logger;

import Objects.Waitlist;

import Objects.Passenger;
import genMethods.GenMethods;

public class SPLDAO implements javax.ejb.SessionBean {

	private static Connection getConnection(String dataSource)

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

		for (int i = 1; i < 6; i++) {

			try {

				conn = ds.getConnection();

				conn.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);

				break;

			} catch (SQLException e1) {

				// i++;

				e1.printStackTrace();

				try {

					// let the thread wait for 500 milliseconds before try next
					// attempt.

					Thread.sleep(500);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}

				continue;

				// throw e1;

			}

		}

		if (conn == null) {

			throw new SQLException("Could not establish the Datbase Connection");

		}

		return conn;

	}

	private static final long serialVersionUID = -7588228963832659951L;

	private final static String DATA_SOURCE = "jdbc/ds2w";

	private static final String SERVICE_URL = "endpoint.url";

	private javax.ejb.SessionContext mySessionCtx;

	public javax.ejb.SessionContext getSessionContext() {

		return mySessionCtx;

	}

	public static Context ctx = null;
	// ///////////////////////////////////
	static final String emptyString = "";
	static final String SPACE = " ";
	static final String COMMA = ",";
	static final int ZERO = 0;
	static final int ONE = 1;
	static final int TWO = 2;
	static final int THREE = 3;
	static final int FOUR = 4;
	static final int FIVE = 5;
	static final int SIX = 6;
	static final int SEVEN = 7;
	static final int EIGHT = 8;
	static final int NINE = 9;
	static final int TEN = 10;
	static final int ELEVEN = 11;
	static final int TWELVE = 12;
	static final int THIRTEEN = 13;
	static final int FOURTEEN = 14;
	static final int FIFTEEN = 15;
	static final int SIXTEEN = 16;
	static final int SEVENTEEN = 17;
	static final int EIGHTEEN = 18;
	static final int NINETEEN = 19;
	static final int TWENTY = 20;
	static final int TWENTYONE = 21;
	static final int TWENTYTWO = 22;
	static final int TWENTYTHREE = 23;
	static final int TWENTYFOUR = 24;
	static final int TWENTYFIVE = 25;
	static final int TWENTYSIX = 26;
	static final int TWENTYSEVEN = 27;
	static final int TWENTYEIGHT = 28;
	static final int TWENTYNINE = 29;
	static final int THIRTY = 30;
	static final int THIRTYONE = 31;
	static final int THIRTYTWO = 32;
	static final int THIRTYTHREE = 33;
	static final int THIRTYFOUR = 34;
	static final int THIRTYFIVE = 35;
	static final int THIRTYSIX = 36;
	static final int THIRTYSEVEN = 37;
	static final int THIRTYEIGHT = 38;
	static final int THIRTYNINE = 39;
	static final int FORTY = 40;
	static final int FORTYONE = 41;
	static final int FORTYTWO = 42;

	static final int FIFTY = 50;
	static final int EIGHTY = 80;

	public static void loadRemarkstoDB2(ArrayList<Objects.Passenger> list,
			String sqlDate, java.sql.Timestamp ts) throws SQLException {

		// Load the driver

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection(DATA_SOURCE);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
			System.out
					.println("Class.forName(com.ibm.db2.jcc.DB2Driver)Failed;");

		}
		int RMK_SEQ_NUMCounter = 0;

		for (int i = 0; i < list.size(); i++) {

			RMK_SEQ_NUMCounter = 0;

			try {
				pstmt = (PreparedStatement) con
						.prepareStatement("INSERT INTO DB2CRS.T_SPIL_PSGR_RMK_OD ("
								+ "LEG_LCL_DPTR_YRMO, "
								+ "LEG_LCL_DPTR_DTE, "
								+ "OP_AL_CDE, "
								+ "OP_FLT_NUM, "
								+ "LEG_ORIG_AP_CDE, "
								+ "MULT_DPTR_SEQ_NUM, "
								+ "ROW_SEAT_NUM, "
								+ "PAX_SEAT_STT_CD, "
								+ //
								"RMK_SEQ_NUM, "
								+ "RMK_TYP_CDE, "
								+ "RMK_TXT, "
								+ "REC_PROC_DT, "
								+ "FILE_RCVD_LTS) " // PAX_CKIN_LTM
								+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if ((!list.get(i).getREMARKS_STRING().equals(emptyString))
					&& (!list.get(i).getREMARKS_STRING().equals(SPACE))
					&& (!list.get(i).getREMARKS_STRING().equals(null)))
			/* && list.get(i + 23).contains("\\,")) */{
				List<String> RemarkslistSplitUp = new ArrayList<String>(
						Arrays.asList(list.get(i).getREMARKS_STRING()));

				if (list.get(i).getREMARKS_STRING().contains(/* COMMA */",")) {
					RemarkslistSplitUp = Arrays.asList(list.get(i)
							.getREMARKS_STRING().split(/* COMMA */","));
				}
				for (int z = 0; z < RemarkslistSplitUp.size(); z++) {
					if (z <= 20 - 1) { // only 20 remarks may go in db
						if (RemarkslistSplitUp.get(z).length() >= /* FIFTY */50) {
							RemarkslistSplitUp.set(z, RemarkslistSplitUp.get(z)
									.substring(ZERO, FIFTY));
						}

						pstmt.setString(ONE, list.get(i).getLEG_LCL_DPTR_YRMO());//

						// ////////////////////////////////////////////////////////////////////////
						pstmt.setDate(TWO, java.sql.Date.valueOf(list.get(i)
								.getLEG_LCL_DPTR_DTE()));//

						// ////////////////////////////////////////////////////////////////////////

						pstmt.setString(THREE, list.get(i).getOP_AL_CDE());//

						// ///////////////////////////////////////////////////////////////////////
						pstmt.setString(FOUR, list.get(i).getOP_FLT_NUM());//

						pstmt.setString(FIVE, list.get(i).getLEG_ORIG_AP_CDE());//

						// ////////////////////////////////////////////////////////////////////////////
						pstmt.setInt(SIX, ONE);// MULT_DPTR_SEQ_NUM
						// /////////////////////////////////////////////////////////
						pstmt.setString(SEVEN, list.get(i).getROW_SEAT_NUM());//
						// ////////////////////////////////////////////////////////////
						String PAX_SEAT_STT_CD = list.get(i)
								.getPAX_SEAT_STT_CD();
						if ((!PAX_SEAT_STT_CD.isEmpty())
								&& (!PAX_SEAT_STT_CD.equals(emptyString) && (PAX_SEAT_STT_CD != null))) {
							/*
							 * System.out.println("PAX_SEAT_STT_CD pstm value: "
							 * + PAX_SEAT_STT_CD);
							 */
							pstmt.setString(EIGHT, PAX_SEAT_STT_CD);
						}
						if ((PAX_SEAT_STT_CD.isEmpty())
								|| (PAX_SEAT_STT_CD.equals(emptyString) || (PAX_SEAT_STT_CD == null))) {
							pstmt.setString(EIGHT, PAX_SEAT_STT_CD);
						}
						// ////////////////////////////////////////////////////////////////////

						pstmt.setInt(NINE, ++RMK_SEQ_NUMCounter);// RMK_SEQ_NUM
						/*
						 * System.out.println("RMK_SEQ_NUMCounter: " +
						 * RMK_SEQ_NUMCounter);
						 */
						// //////////////////////////////////////////////////////////////////
						String RMK_TYP_CDE = list.get(i).getSSR_TYP_CDE();
						if ((!RMK_TYP_CDE.isEmpty())
								&& (!RMK_TYP_CDE.equals(emptyString) && (RMK_TYP_CDE != null))) {
							/*
							 * System.out.println("RMK_TYP_CDE pstm value: " +
							 * RMK_TYP_CDE);
							 */
							pstmt.setString(TEN, RMK_TYP_CDE);
						}
						if ((RMK_TYP_CDE.isEmpty())
								|| (RMK_TYP_CDE.equals(emptyString) || (RMK_TYP_CDE == null))) {
							pstmt.setString(TEN, RMK_TYP_CDE);
						}

						// /////////////////////////////////////////////////////////////////
						pstmt.setString(ELEVEN, RemarkslistSplitUp.get(z));// RMK_TXT

						pstmt.setDate(TWELVE, Date.valueOf(sqlDate)); // REC_PROC_DT
						pstmt.setTimestamp(THIRTEEN, ts);// FILE_RCVD_LTS

						try {
							pstmt.addBatch();
							if ((RemarkslistSplitUp.size() - /* ONE */1 <= z)
									|| z == /* TWENTY */20 - /* ONE */1) {
								int[] loadSuccess = pstmt.executeBatch();
								/*System.out.println("T_SPIL_PSGR_RMK_OD: "
										+ loadSuccess[ZERO]);*/
								// System.out.println("Loaded: " +
								// loadSuccess[0]);
							}
						}
						// System.out.println("loadSuccess: "+loadSuccess[0]);
						catch (SQLException e) {
						//	e.printStackTrace();
							System.err.println("SQL EXCEPTION: ");
							/*System.err.println(" LEG_LCL_DPTR_YRMO: "
									+ list.get(i).getLEG_LCL_DPTR_YRMO()
									+ " LEG_LCL_DPTR_DTE: "
									+ list.get(i).getLEG_LCL_DPTR_DTE()
									+ " OP_AL_CDE: "
									+ list.get(i).getOP_AL_CDE()
									+ " OP_FLT_NUM: "
									+ list.get(i).getOP_FLT_NUM()
									+ " LEG_ORIG_AP_CDE: "
									+ list.get(i).getLEG_ORIG_AP_CDE()
									+ " MULT_DPTR_SEQ_NUM: "
									+ list.get(i).getMULT_DPTR_SEQ_NUM()
									+ " ROW_SEAT_NUM: "
									+ list.get(i).getROW_SEAT_NUM()
									+ " PAX_SEAT_STT_CD: "
									+ list.get(i).getPAX_SEAT_STT_CD()
									+ " RMK_SEQ_NUMCounter: "
									+ RMK_SEQ_NUMCounter + " RMK_TYP_CDE: "
									+ list.get(i).getSSR_TYP_CDE()
									+ " RMK_TXT: " + RemarkslistSplitUp.get(z)
									+ " sqlDate: " + sqlDate + " Timestamp: "
									+ ts);*/
							 e.printStackTrace();
						}
					}
				}
			}

		}
		// int[] loadSuccess = pstmt.executeBatch();
		// System.out.println("Load Success: " + loadSuccess);
		con.close();
		pstmt.close();

	}

	public static String PassArrayDB2LoadWL(ArrayList<Waitlist> passlist,
			java.sql.Timestamp ts, String sqlDate) throws SQLException {

		// System.setProperty("db2.jcc.charsetDecoderEncoder", "3");

		// Load the driver

		System.setProperty("db2.jcc.charsetDecoderEncoder", "3");
		Connection con = null;
		PreparedStatement pstmt = null;

		// int batchCount = ZERO;
		String stringSuccessFail = "Fail";

		try {
			con = getConnection(DATA_SOURCE);
		//	con.setAutoCommit(true);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.err.println("com.ibm.db2.jcc.DB2 Driver Failed;");
		}
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		// con = DriverManager.getConnection(urlPrefix + url, user, password);
		// Commit changes manually

		// con.setAutoCommit(true);

		// System.out.println("**** Created a JDBC connection to the data source");
		// Logger.log("**** Created a JDBC connection to the data source");
		pstmt = (PreparedStatement) con
				.prepareStatement("INSERT INTO db2crs.T_SPIL_WL_PSGR_OD (LEG_LCL_DPTR_YRMO, "
						+ "LEG_LCL_DPTR_DTE, "
						+ "OP_AL_CDE, "
						+ "OP_FLT_NUM, "
						+ "LEG_ORIG_AP_CDE, "
						+ "MULT_DPTR_SEQ_NUM, "
						+ "WL_PSGR_LST_NUM, "
						+ "PNR_LOCTR_NUM, "
						+ "PNR_FILE_ADDR, "
						+ "PSGR_NME, "
						+ "WL_VRFY_TYP_CDE, "
						+ "WL_BRD_TYP_CDE, "
						+ "WL_RES_TYP_CDE, "
						+ "SEG_DEST_AP_CDE, "
						+ "WL_SVC_TYP_CDE, "
						+ "WL_TYP_CDE, "
						+ "TRVL_CL_CDE, "
						+ "EMP_SEN_DTE, "
						+ "WL_UTC_CRTN_TME, "
						+ "REC_PROC_DT, "
						+ "FILE_RCVD_LTS) " // PAX_CKIN_LTM
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");// 'DL',

		for (int i = 0; i < passlist.size(); i++) {

			/*System.out.println("LEG_LCL_DPTR_YRMO pstm value: "
					+ passlist.get(i).getLEG_LCL_DPTR_YRMO());*/

			if ((!passlist.get(i).getLEG_LCL_DPTR_YRMO().isEmpty())
					&& (!passlist.get(i).getLEG_LCL_DPTR_YRMO()
							.equals(emptyString) && (passlist.get(i)
							.getLEG_LCL_DPTR_YRMO() != null))) {
				pstmt.setString(ONE, passlist.get(i).getLEG_LCL_DPTR_YRMO());//
				/*System.out.println("LEG_LCL_DPTR_DTE pstm value: "
						+ java.sql.Date.valueOf(passlist.get(i)
								.getLEG_LCL_DPTR_DTE()));*/
			}
			if ((passlist.get(i).getLEG_LCL_DPTR_YRMO().isEmpty())
					|| (passlist.get(i).getLEG_LCL_DPTR_YRMO()
							.equals(emptyString) || (passlist.get(i)
							.getLEG_LCL_DPTR_YRMO() == null))) {
			}
			// ////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getLEG_LCL_DPTR_DTE().isEmpty())
					&& (!passlist.get(i).getLEG_LCL_DPTR_DTE()
							.equals(emptyString) && (passlist.get(i)
							.getLEG_LCL_DPTR_DTE() != null))) {

				/*System.out.println("passlist.get(i).getLEG_LCL_DPTR_DTE(): "
						+ passlist.get(i).getLEG_LCL_DPTR_DTE());*/

				String LEG_LCL_DPTR_DTE = passlist.get(i).getLEG_LCL_DPTR_DTE();

				pstmt.setDate(TWO, java.sql.Date.valueOf(LEG_LCL_DPTR_DTE));//
			}

			// ////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getOP_AL_CDE().isEmpty()) &&
			 * (!passlist.get(i).getOP_AL_CDE().equals(emptyString) && (passlist
			 * .get(i).getOP_AL_CDE() != null))) {
			 * 
			 * pstmt.setString(THREE, "DL");//
			 * passlist.get(i).getOP_AL_CDE());// }
			 */
			/*
			 * if ((passlist.get(i).getOP_AL_CDE().isEmpty()) ||
			 * (passlist.get(i).getOP_AL_CDE().equals(emptyString) || (passlist
			 * .get(i).getOP_AL_CDE() == null))) { pstmt.setString(THREE,
			 * "DL");// }
			 */
			pstmt.setString(THREE, "DL");//

			// //////////////////////////////////////////////////////////////////////////

			/*
			 * if ((!passlist.get(i).getOP_FLT_NUM().isEmpty()) &&
			 * (!passlist.get(i).getOP_FLT_NUM().equals(emptyString) &&
			 * (passlist .get(i).getOP_FLT_NUM() != null))) {
			 * 
			 * System.out.println("OP_FLT_NUM pstm value: " +
			 * passlist.get(i).getOP_FLT_NUM());
			 * 
			 * pstmt.setString(FOUR, passlist.get(i).getOP_FLT_NUM());// }
			 */
			if ((passlist.get(i).getOP_FLT_NUM().isEmpty())
					|| (passlist.get(i).getOP_FLT_NUM().equals(emptyString) || (passlist
							.get(i).getOP_FLT_NUM() == null))) {
				pstmt.setString(FOUR, emptyString);//
			} else {
				pstmt.setString(FOUR, passlist.get(i).getOP_FLT_NUM());
			}//

			// //////////////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getLEG_ORIG_AP_CDE().isEmpty()) &&
			 * (!passlist.get(i).getLEG_ORIG_AP_CDE() .equals(emptyString) &&
			 * (passlist.get(i) .getLEG_ORIG_AP_CDE() != null))) {
			 * 
			 * System.out.println("LEG_ORIG_AP_CDE pstm value: " +
			 * passlist.get(i).getLEG_ORIG_AP_CDE());
			 * 
			 * pstmt.setString(FIVE, passlist.get(i).getLEG_ORIG_AP_CDE()); }
			 */
			if ((passlist.get(i).getLEG_ORIG_AP_CDE().isEmpty())
					|| (passlist.get(i).getLEG_ORIG_AP_CDE()
							.equals(emptyString) || (passlist.get(i)
							.getLEG_ORIG_AP_CDE() == null))) {
				pstmt.setString(FIVE, emptyString);//
			} else {
				pstmt.setString(FIVE, passlist.get(i).getLEG_ORIG_AP_CDE());
			}
			// //////////////////////////////////////////////////////////////////////////

			pstmt.setInt(SIX, ONE);// T_SPIL_PSGR__MULT_DPTR_SEQ_NUM);
			// /////////////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getWL_PSGR_LST_NUM().isEmpty()) &&
			 * (!passlist.get(i).getWL_PSGR_LST_NUM() .equals(emptyString) &&
			 * (passlist.get(i) .getWL_PSGR_LST_NUM() != null))) {
			 * 
			 * System.out.println("WL_PSGR_LST_NUM pstm value: " +
			 * passlist.get(i).getWL_PSGR_LST_NUM());
			 * 
			 * pstmt.setInt(SEVEN,
			 * Integer.parseInt(passlist.get(i).getWL_PSGR_LST_NUM())); }
			 */
			if ((passlist.get(i).getWL_PSGR_LST_NUM().isEmpty())
					|| (passlist.get(i).getWL_PSGR_LST_NUM()
							.equals(emptyString) || (passlist.get(i)
							.getWL_PSGR_LST_NUM() == null))) {
				pstmt.setInt(SEVEN, ZERO);
			} else {
				pstmt.setInt(SEVEN,
						Integer.parseInt(passlist.get(i).getWL_PSGR_LST_NUM()));
			}
			// //////////////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getPNR_LOCTR_NUM().isEmpty()) &&
			 * (!passlist.get(i).getPNR_LOCTR_NUM().equals(emptyString) &&
			 * (passlist .get(i).getPNR_LOCTR_NUM() != null))) {
			 * 
			 * System.out.println("PNR_LOCTR_NUM pstm value: " +
			 * passlist.get(i).getPNR_LOCTR_NUM());
			 * 
			 * pstmt.setString(EIGHT, passlist.get(i).getPNR_LOCTR_NUM()); }
			 */
			if ((passlist.get(i).getPNR_LOCTR_NUM().isEmpty())
					|| (passlist.get(i).getPNR_LOCTR_NUM().equals(emptyString) || (passlist
							.get(i).getPNR_LOCTR_NUM() == null))) {
				pstmt.setString(EIGHT, passlist.get(i).getPNR_LOCTR_NUM());
			} else {
				pstmt.setString(EIGHT, passlist.get(i).getPNR_LOCTR_NUM());

			}
			// //////////////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getPNR_FILE_ADDR().isEmpty()) &&
			 * (!passlist.get(i).getPNR_FILE_ADDR().equals(emptyString) &&
			 * (passlist .get(i).getPNR_FILE_ADDR() != null))) {
			 * 
			 * System.out.println("getPNR_FILE_ADDR pstm value: " +
			 * passlist.get(i).getPNR_FILE_ADDR());
			 * 
			 * pstmt.setString(NINE, passlist.get(i).getPNR_FILE_ADDR()); }
			 */
			if ((passlist.get(i).getPNR_FILE_ADDR().isEmpty())
					|| (passlist.get(i).getPNR_FILE_ADDR().equals(emptyString) || (passlist
							.get(i).getPNR_FILE_ADDR() == null))) {
				pstmt.setString(NINE, emptyString);
			} else {
				pstmt.setString(NINE, passlist.get(i).getPNR_FILE_ADDR());
			}
			// //////////////////////////////////////////////////////////////////////////

			/*System.out.println("PSGR_NME pstm value: "
					+ passlist.get(i).getPSGR_NME());*/

			/*
			 * if ((!passlist.get(i).getPSGR_NME().isEmpty()) &&
			 * (!passlist.get(i).getPSGR_NME().equals(emptyString) && (passlist
			 * .get(i).getPSGR_NME() != null))) { pstmt.setString(TEN,
			 * passlist.get(i).getPSGR_NME()); }
			 */
			if ((passlist.get(i).getPSGR_NME().isEmpty())
					|| (passlist.get(i).getPSGR_NME().equals(emptyString) || (passlist
							.get(i).getPSGR_NME() == null))) {
				pstmt.setString(TEN, emptyString);
			} else {
				pstmt.setString(TEN, passlist.get(i).getPSGR_NME());
			}
			// //////////////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getWL_VRFY_TYP_CDE().isEmpty()) &&
			 * (!passlist.get(i).getWL_VRFY_TYP_CDE() .equals(emptyString) &&
			 * (passlist.get(i) .getWL_VRFY_TYP_CDE() != null))) {
			 * 
			 * System.out.println("WL_VRFY_TYP_CDE pstm value: " +
			 * passlist.get(i).getWL_VRFY_TYP_CDE());
			 * 
			 * pstmt.setString(ELEVEN, passlist.get(i).getWL_VRFY_TYP_CDE()); }
			 */
			if ((passlist.get(i).getWL_VRFY_TYP_CDE().isEmpty())
					|| (passlist.get(i).getWL_VRFY_TYP_CDE()
							.equals(emptyString) || (passlist.get(i)
							.getWL_VRFY_TYP_CDE() == null))) {
				pstmt.setString(ELEVEN, emptyString);
			} else {
				pstmt.setString(ELEVEN, passlist.get(i).getWL_VRFY_TYP_CDE());

			}
			// ////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getWL_BRD_TYP_CDE().isEmpty()) &&
			 * (!passlist.get(i).getWL_BRD_TYP_CDE() .equals(emptyString) &&
			 * (passlist.get(i) .getWL_BRD_TYP_CDE() != null))) {
			 * 
			 * System.out.println("WL_BRD_TYP_CDE pstm value: " +
			 * passlist.get(i).getWL_BRD_TYP_CDE());
			 * 
			 * pstmt.setString(TWELVE, passlist.get(i).getWL_BRD_TYP_CDE()); }
			 */
			if ((passlist.get(i).getWL_BRD_TYP_CDE().isEmpty())
					|| (passlist.get(i).getWL_BRD_TYP_CDE().equals(emptyString) || (passlist
							.get(i).getWL_BRD_TYP_CDE() == null))) {
				pstmt.setString(TWELVE, emptyString);
			} else {
				pstmt.setString(TWELVE, passlist.get(i).getWL_BRD_TYP_CDE());
			}
			// ////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getWL_RES_TYP_CDE().isEmpty()) &&
			 * (!passlist.get(i).getWL_RES_TYP_CDE() .equals(emptyString) &&
			 * (passlist.get(i) .getWL_RES_TYP_CDE() != null))) {
			 * 
			 * System.out.println("getWL_RES_TYP_CDE pstm value: " +
			 * passlist.get(i).getWL_RES_TYP_CDE());
			 * 
			 * pstmt.setString(THIRTEEN, passlist.get(i).getWL_RES_TYP_CDE()); }
			 */
			if ((passlist.get(i).getWL_RES_TYP_CDE().isEmpty())
					|| (passlist.get(i).getWL_RES_TYP_CDE().equals(emptyString) || (passlist
							.get(i).getWL_RES_TYP_CDE() == null))) {
				pstmt.setString(THIRTEEN, emptyString);
			} else {
				pstmt.setString(THIRTEEN, passlist.get(i).getWL_RES_TYP_CDE());

			}
			// ////////////////////////////////////////////////////////////////////

			/*
			 * if ((!passlist.get(i).getSEG_DEST_AP_CDE().isEmpty()) &&
			 * (!passlist.get(i).getSEG_DEST_AP_CDE() .equals(emptyString) &&
			 * (passlist.get(i) .getSEG_DEST_AP_CDE() != null))) {
			 * 
			 * System.out.println("getSEG_DEST_AP_CDE pstm value: " +
			 * passlist.get(i).getSEG_DEST_AP_CDE());
			 * 
			 * pstmt.setString(FOURTEEN, passlist.get(i).getSEG_DEST_AP_CDE());
			 * }
			 */
			if ((passlist.get(i).getSEG_DEST_AP_CDE().isEmpty())
					|| (passlist.get(i).getSEG_DEST_AP_CDE()
							.equals(emptyString) || (passlist.get(i)
							.getSEG_DEST_AP_CDE() == null))) {
				pstmt.setString(FOURTEEN, emptyString);
			} else {
				pstmt.setString(FOURTEEN, passlist.get(i).getSEG_DEST_AP_CDE());
			}
			// ////////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getWL_SVC_TYP_CDE().isEmpty()) &&
			 * (!passlist.get(i).getWL_SVC_TYP_CDE() .equals(emptyString) &&
			 * (passlist.get(i) .getWL_SVC_TYP_CDE() != null))) {
			 * 
			 * System.out.println("WL_SVC_TYP_CDE pstm value: " +
			 * passlist.get(i).getWL_SVC_TYP_CDE());
			 * 
			 * pstmt.setString(FIFTEEN, passlist.get(i).getWL_SVC_TYP_CDE()); }
			 */
			if ((passlist.get(i).getWL_SVC_TYP_CDE().isEmpty())
					|| (passlist.get(i).getWL_SVC_TYP_CDE().equals(emptyString) || (passlist
							.get(i).getWL_SVC_TYP_CDE() == null))) {
				pstmt.setString(FIFTEEN, emptyString);
			} else {
				pstmt.setString(FIFTEEN, passlist.get(i).getWL_SVC_TYP_CDE());

			}
			// ////////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getWL_TYP_CDE().isEmpty()) &&
			 * (!passlist.get(i).getWL_TYP_CDE().equals(emptyString) &&
			 * (passlist .get(i).getWL_TYP_CDE() != null))) {
			 * 
			 * System.out.println("WL_TYP_CDE pstm value: " +
			 * passlist.get(i).getWL_TYP_CDE());
			 * 
			 * pstmt.setString(SIXTEEN, passlist.get(i).getWL_TYP_CDE()); }
			 */
			if ((passlist.get(i).getWL_TYP_CDE().isEmpty())
					|| (passlist.get(i).getWL_TYP_CDE().equals(emptyString) || (passlist
							.get(i).getWL_TYP_CDE() == null))) {
				pstmt.setString(SIXTEEN, emptyString);
			} else {
				pstmt.setString(SIXTEEN, passlist.get(i).getWL_TYP_CDE());

			}
			// ////////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getTRVL_CL_CDE().isEmpty()) &&
			 * (!passlist.get(i).getTRVL_CL_CDE().equals(emptyString) &&
			 * (passlist .get(i).getTRVL_CL_CDE() != null))) {
			 * 
			 * System.out.println("TRVL_CL_CDE pstm value: " +
			 * passlist.get(i).getTRVL_CL_CDE());
			 * 
			 * pstmt.setString(SEVENTEEN, passlist.get(i).getTRVL_CL_CDE());// }
			 */

			if ((passlist.get(i).getTRVL_CL_CDE().isEmpty())
					|| (passlist.get(i).getTRVL_CL_CDE().equals(emptyString) || (passlist
							.get(i).getTRVL_CL_CDE() == null))) {
				pstmt.setString(SEVENTEEN, emptyString);
			} else {
				pstmt.setString(SEVENTEEN, passlist.get(i).getTRVL_CL_CDE());//
			}
			// /////////////////////////////////////////////////////////////////////
			if ((passlist.get(i).getEMP_SEN_DTE().isEmpty())
					|| (passlist.get(i).getEMP_SEN_DTE().equals(emptyString) || (passlist
							.get(i).getEMP_SEN_DTE() == null))) {
				pstmt.setString(EIGHTEEN, "1900-01-01");
			} else {
				pstmt.setString(EIGHTEEN, passlist.get(i).getEMP_SEN_DTE());
			}
			/*
			 * if ((!passlist.get(i).getEMP_SEN_DTE().isEmpty()) &&
			 * (!passlist.get(i).getEMP_SEN_DTE().equals(emptyString) &&
			 * (passlist .get(i).getEMP_SEN_DTE() != null))) {
			 * 
			 * pstmt.setString(EIGHTEEN, passlist.get(i).getEMP_SEN_DTE()); }
			 * else { pstmt.setString(EIGHTEEN, "1900-01-01"); }
			 */

			// /////////////////////////////////////////////////////////////////////
			/*
			 * if ((!passlist.get(i).getWL_UTC_CRTN_TME().isEmpty()) &&
			 * (!passlist.get(i).getWL_UTC_CRTN_TME() .equals(emptyString) &&
			 * (passlist.get(i) .getWL_UTC_CRTN_TME() != null))) {
			 * 
			 * System.out.println("WL_UTC_CRTN_TME pstm value: " +
			 * passlist.get(i).getWL_UTC_CRTN_TME());
			 * 
			 * pstmt.setString(NINETEEN,
			 * passlist.get(i).getWL_UTC_CRTN_TME());//
			 * "20.56.00");//passlist.get(i).getWL_UTC_CRTN_TME()); }
			 */

			if ((passlist.get(i).getWL_UTC_CRTN_TME().isEmpty())
					|| (passlist.get(i).getWL_UTC_CRTN_TME()
							.equals(emptyString) || (passlist.get(i)
							.getWL_UTC_CRTN_TME() == null))) {
				pstmt.setString(NINETEEN, "1900-01-01");
			} else {
				pstmt.setString(NINETEEN, passlist.get(i).getWL_UTC_CRTN_TME());

			}
			// ///////////////////////////////////////////////////////////////////

			pstmt.setDate(TWENTY, Date.valueOf(sqlDate));// REC_PROC_DT//REC_PROC_DT

			pstmt.setTimestamp(TWENTYONE, ts);
			try {
				// int worked = pstmt.executeUpdate();
				pstmt.addBatch();
				int[] numUpd1 = pstmt.executeBatch();
			//	System.out.println("Waitlist Batch updated " + numUpd1[0]);
				// batchCount++;
				// int[] numUpd1 = pstmt.executeBatch();
				// System.out.println(numUpd1[0]);
				/*
				 * if ((passlist.size() - ONE) <= i) { int[] numUpd1 =
				 * pstmt.executeBatch(); System.out.println("WL Load Success: "
				 * + numUpd1); System.out.println("Batch executed " +
				 * batchCount);
				 * 
				 * }
				 */

			} catch (SQLException e1) {
				System.err.println("SQL Exception Caught in WL: ");
				String ERR = passlist.get(i).getROW_SEAT_NUM() + SPACE
						+ passlist.get(i).getPNR_LOCTR_NUM() + SPACE
						+ passlist.get(i).getPSGR_NME();
				System.err.println(ERR);
				// Logger.log("Fail in batch load");
				// e1.printStackTrace();
				continue;
			}

			stringSuccessFail = "success";

		}
		con.close();
		pstmt.close();

		return stringSuccessFail;
	}

	public static String PassArrayDB2Load(ArrayList<Passenger> passlist,
			java.sql.Timestamp ts, String DateString) throws SQLException {
		System.setProperty("db2.jcc.charsetDecoderEncoder", "3");

		// Load the driver

	String stringSuccessFail = emptyString;
		int RMK_SEQ_NUMCounter = 0;
		/*
		 * Class.forName("com.ibm.db2.jcc.DB2Driver"); con =
		 * getConnection(DATA_SOURCE);
		 */
		// con.setAutoCommit(true);

	//	con = DriverManager.getConnection(urlPrefix + url, user, password);
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection(DATA_SOURCE);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
			System.out
					.println("Class.forName(com.ibm.db2.jcc.DB2Driver)Failed;");

		}
		pstmt = (PreparedStatement) con
				.prepareStatement("INSERT INTO DB2CRS.T_SPIL_PSGR_OD (LEG_LCL_DPTR_YRMO, LEG_LCL_DPTR_DTE, OP_AL_CDE, OP_FLT_NUM, LEG_ORIG_AP_CDE, MULT_DPTR_SEQ_NUM, "
						+ "ROW_SEAT_NUM, PAX_SEAT_STT_CD, PNR_LOCTR_NUM, BKG_CRTN_GDT, PNR_FILE_ADDR, ITINSEG_DESTAP_CDE, INV_CL_CDE, SPIL_TYP_CDE, CUST_ID, CUST_FRST_NM_NB, "
						+ "CUST_LST_NM_NB, PSGR_NME, SSR_TYP_CDE, ARRSEG_OP_AL_CDE, ARRSEG_OP_FLT_NUM, ARRSEG_ORIGAP_CDE, NEXTSEG_OP_AL_CDE, NEXTSEG_OP_FLT_NUM, NEXTSEG_DESTAP_CDE, "
						+ "TKT_NUM, TKT_DOC_ISS_LDT, FF_AL_CDE, FF_ID, FF_TIER_LVL_DESC, GOVT_DOC_NUM, BKD_CPMT_CD, ACTL_CPMT_CD, PAX_CKIN_LDT, PAX_CKIN_LTM, PAX_OBRD_IND, PAX_OBRD_LDT, "
						+ "PAX_OBRD_LTM, FLT_CX_IND, REC_PROC_DT, FILE_RCVD_LTS) " // PAX_CKIN_LTM
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		for (int i = 0; i < passlist.size(); i++) {
			RMK_SEQ_NUMCounter++;

			if ((!passlist.get(i).getLEG_LCL_DPTR_YRMO().isEmpty())
					&& (!passlist.get(i).getLEG_LCL_DPTR_YRMO()
							.equals(emptyString) && (passlist.get(i)
							.getLEG_LCL_DPTR_YRMO() != null))) {
				pstmt.setString(ONE, passlist.get(i).getLEG_LCL_DPTR_YRMO());//
			}
			if ((!passlist.get(i).getLEG_LCL_DPTR_DTE().isEmpty())
					&& (!passlist.get(i).getLEG_LCL_DPTR_DTE()
							.equals(emptyString) && (passlist.get(i)
							.getLEG_LCL_DPTR_DTE() != null))) {
				pstmt.setDate(TWO, java.sql.Date.valueOf(passlist.get(i)
						.getLEG_LCL_DPTR_DTE()));
			}
			if ((passlist.get(i).getLEG_LCL_DPTR_DTE().isEmpty())
					|| (passlist.get(i).getLEG_LCL_DPTR_DTE()
							.equals(emptyString) || (passlist.get(i)
							.getLEG_LCL_DPTR_DTE() == null))) {
				pstmt.setDate(TWO, null);
			}
			if ((!passlist.get(i).getOP_AL_CDE().isEmpty())
					&& (!passlist.get(i).getOP_AL_CDE().equals(emptyString) && (passlist
							.get(i).getOP_AL_CDE() != null))) {
				pstmt.setString(THREE, passlist.get(i).getOP_AL_CDE());//
			}
			if ((passlist.get(i).getOP_AL_CDE().isEmpty())
					|| (passlist.get(i).getOP_AL_CDE().equals(emptyString) || (passlist
							.get(i).getOP_AL_CDE() == null))) {
				pstmt.setString(THREE, emptyString);
			}
			if ((!passlist.get(i).getOP_FLT_NUM().isEmpty())
					&& (!passlist.get(i).getOP_FLT_NUM().equals(emptyString) && (passlist
							.get(i).getOP_FLT_NUM() != null))) {
				pstmt.setString(FOUR, passlist.get(i).getOP_FLT_NUM());//
			}
			if ((passlist.get(i).getOP_FLT_NUM().isEmpty())
					|| (passlist.get(i).getOP_FLT_NUM().equals(emptyString) || (passlist
							.get(i).getOP_FLT_NUM() == null))) {
				pstmt.setString(FOUR, emptyString);//
			}
			if ((!passlist.get(i).getLEG_ORIG_AP_CDE().isEmpty())
					&& (!passlist.get(i).getLEG_ORIG_AP_CDE()
							.equals(emptyString) && (passlist.get(i)
							.getLEG_ORIG_AP_CDE() != null))) {
				pstmt.setString(FIVE, passlist.get(i).getLEG_ORIG_AP_CDE());//
			}
			if ((passlist.get(i).getLEG_ORIG_AP_CDE().isEmpty())
					|| (passlist.get(i).getLEG_ORIG_AP_CDE()
							.equals(emptyString) || (passlist.get(i)
							.getLEG_ORIG_AP_CDE() == null))) {
				pstmt.setString(FIVE, passlist.get(i).getLEG_ORIG_AP_CDE());//
			}
			pstmt.setInt(SIX, ONE);// T_SPIL_PSGR__MULT_DPTR_SEQ_NUM);
			if ((!passlist.get(i).getROW_SEAT_NUM().isEmpty())
					&& (!passlist.get(i).getROW_SEAT_NUM().equals(emptyString) && (passlist
							.get(i).getROW_SEAT_NUM() != null))) {
				// System.out.println("ROW_SEAT_NUM pstm value: "
				// + passlist.get(i).getROW_SEAT_NUM());
				pstmt.setString(SEVEN, passlist.get(i).getROW_SEAT_NUM());//
			}
			if ((passlist.get(i).getROW_SEAT_NUM().isEmpty())
					|| (passlist.get(i).getROW_SEAT_NUM().equals(emptyString) || (passlist
							.get(i).getROW_SEAT_NUM() == null))) {
				pstmt.setString(SEVEN, String.valueOf(i));// emptyString);//
			}
			// //////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getPAX_SEAT_STT_CD().isEmpty())
					&& (!passlist.get(i).getPAX_SEAT_STT_CD()
							.equals(emptyString) && (passlist.get(i)
							.getPAX_SEAT_STT_CD() != null))) {
				// System.out.println("PAX_SEAT_STT_CD pstm value: "
				// + passlist.get(i).getPAX_SEAT_STT_CD());
				pstmt.setString(EIGHT, passlist.get(i).getPAX_SEAT_STT_CD());
			}
			if ((passlist.get(i).getPAX_SEAT_STT_CD().isEmpty())
					|| (passlist.get(i).getPAX_SEAT_STT_CD()
							.equals(emptyString) || (passlist.get(i)
							.getPAX_SEAT_STT_CD() == null))) {
				pstmt.setString(EIGHT, passlist.get(i).getPAX_SEAT_STT_CD());
			}
			// //////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getPNR_LOCTR_NUM().isEmpty())
					&& (!passlist.get(i).getPNR_LOCTR_NUM().equals(emptyString) && (passlist
							.get(i).getPNR_LOCTR_NUM() != null))) {
				// System.out.println("PNR_LOCTR_NUM pstm value: "
				// + passlist.get(i).getPNR_LOCTR_NUM());
				pstmt.setString(NINE, passlist.get(i).getPNR_LOCTR_NUM());
			}
			if ((passlist.get(i).getPNR_LOCTR_NUM().isEmpty())
					|| (passlist.get(i).getPNR_LOCTR_NUM().equals(emptyString) || (passlist
							.get(i).getPNR_LOCTR_NUM() == null))) {
				pstmt.setString(NINE, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////////
			// System.out.println("BKG_CRTN_GDT pstm value: "
			// + passlist.get(i).getBKG_CRTN_GDT());
			if ((!passlist.get(i).getBKG_CRTN_GDT().isEmpty())
					&& (!passlist.get(i).getBKG_CRTN_GDT().equals(emptyString) && (passlist
							.get(i).getBKG_CRTN_GDT() != null))) {
				pstmt.setDate(TEN, java.sql.Date.valueOf(passlist.get(i)
						.getBKG_CRTN_GDT()));
			}
			if ((passlist.get(i).getBKG_CRTN_GDT().isEmpty())
					|| (passlist.get(i).getBKG_CRTN_GDT().equals(emptyString) || (passlist
							.get(i).getBKG_CRTN_GDT() == null))) {
				pstmt.setDate(TEN, null);
			}
			// //////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getPNR_FILE_ADDR().isEmpty())
					&& (!passlist.get(i).getPNR_FILE_ADDR().equals(emptyString) && (passlist
							.get(i).getPNR_FILE_ADDR() != null))) {
				// System.out.println("PNR_FILE_ADDR pstm value: "
				// + passlist.get(i).getPNR_FILE_ADDR());
				pstmt.setString(ELEVEN, passlist.get(i).getPNR_FILE_ADDR());
			}
			if ((passlist.get(i).getPNR_FILE_ADDR().isEmpty())
					|| (passlist.get(i).getPNR_FILE_ADDR().equals(emptyString) || (passlist
							.get(i).getPNR_FILE_ADDR() == null))) {
				pstmt.setString(ELEVEN, emptyString);
			}
			// ////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getITINSEG_DESTAP_CDE().isEmpty())
					&& (!passlist.get(i).getITINSEG_DESTAP_CDE()
							.equals(emptyString) && (passlist.get(i)
							.getITINSEG_DESTAP_CDE() != null))) {
				// System.out.println("ITINSEG_DESTAP_CDE pstm value: "
				// + passlist.get(i).getITINSEG_DESTAP_CDE());
				pstmt.setString(TWELVE, passlist.get(i).getITINSEG_DESTAP_CDE());
			}
			if ((passlist.get(i).getITINSEG_DESTAP_CDE().isEmpty())
					|| (passlist.get(i).getITINSEG_DESTAP_CDE()
							.equals(emptyString) || (passlist.get(i)
							.getITINSEG_DESTAP_CDE() == null))) {
				pstmt.setString(TWELVE, emptyString);
			}
			// ////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getINV_CL_CDE().isEmpty())
					&& (!passlist.get(i).getINV_CL_CDE().equals(emptyString) && (passlist
							.get(i).getINV_CL_CDE() != null))) {
				// System.out.println("getINV_CL_CDE pstm value: "
				// + passlist.get(i).getINV_CL_CDE());
				pstmt.setString(THIRTEEN, passlist.get(i).getINV_CL_CDE());
			}
			if ((passlist.get(i).getINV_CL_CDE().isEmpty())
					|| (passlist.get(i).getINV_CL_CDE().equals(emptyString) || (passlist
							.get(i).getINV_CL_CDE() == null))) {
				pstmt.setString(THIRTEEN, emptyString);
			}
			// ////////////////////////////////////////////////////////////////////

			if ((!passlist.get(i).getSPIL_TYP_CDE().isEmpty())
					&& (!passlist.get(i).getSPIL_TYP_CDE().equals(emptyString) && (passlist
							.get(i).getSPIL_TYP_CDE() != null))) {
				// System.out.println("getSPIL_TYP_CDE pstm value: "
				// + passlist.get(i).getSPIL_TYP_CDE());
				pstmt.setString(FOURTEEN, passlist.get(i).getSPIL_TYP_CDE());
			}
			if ((passlist.get(i).getSPIL_TYP_CDE().isEmpty())
					|| (passlist.get(i).getSPIL_TYP_CDE().equals(emptyString) || (passlist
							.get(i).getSPIL_TYP_CDE() == null))) {
				pstmt.setString(FOURTEEN, emptyString);
			}
			// ////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getCUST_ID().isEmpty())
					&& (!passlist.get(i).getCUST_ID().equals(emptyString) && (passlist
							.get(i).getCUST_ID() != null))) {
				// System.out.println("CUST_ID pstm value: "
				// + passlist.get(i).getCUST_ID());
				pstmt.setString(FIFTEEN, passlist.get(i).getCUST_ID());
			}
			if ((passlist.get(i).getCUST_ID().isEmpty())
					|| (passlist.get(i).getCUST_ID().equals(emptyString) || (passlist
							.get(i).getCUST_ID() == null))) {
				pstmt.setString(FIFTEEN, emptyString);
			}
			// ////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getCUST_FRST_NM_NB().isEmpty())
					&& (!passlist.get(i).getCUST_ID().equals(emptyString) && (passlist
							.get(i).getCUST_FRST_NM_NB() != null))) {
				// System.out.println("getCUST_FRST_NM_NB pstm value: "
				// + passlist.get(i).getCUST_FRST_NM_NB());
				pstmt.setString(SIXTEEN, passlist.get(i).getCUST_FRST_NM_NB());
			}
			if ((passlist.get(i).getCUST_FRST_NM_NB().isEmpty())
					|| (passlist.get(i).getCUST_FRST_NM_NB()
							.equals(emptyString) || (passlist.get(i)
							.getCUST_FRST_NM_NB() == null))) {
				pstmt.setString(SIXTEEN, emptyString);
			}
			// ////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getCUST_LST_NM_NB().isEmpty())
					&& (!passlist.get(i).getCUST_LST_NM_NB()
							.equals(emptyString) && (passlist.get(i)
							.getCUST_LST_NM_NB() != null))) {
				// System.out.println("CUST_LST_NM_NB pstm value: "
				// + passlist.get(i).getCUST_LST_NM_NB());
				pstmt.setString(SEVENTEEN, passlist.get(i).getCUST_LST_NM_NB());//
			}
			if ((passlist.get(i).getCUST_LST_NM_NB().isEmpty())
					|| (passlist.get(i).getCUST_LST_NM_NB().equals(emptyString) || (passlist
							.get(i).getCUST_LST_NM_NB() == null))) {
				pstmt.setString(SEVENTEEN, emptyString);
			}
			// /////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getPSGR_NME().isEmpty())
					&& (!passlist.get(i).getPSGR_NME().equals(emptyString) && (passlist
							.get(i).getPSGR_NME() != null))) {
				// System.out.println("PSGR_NME pstm value: "
				// + passlist.get(i).getPSGR_NME());
				pstmt.setString(EIGHTEEN, passlist.get(i).getPSGR_NME());//
			}
			if ((passlist.get(i).getPSGR_NME().isEmpty())
					|| (passlist.get(i).getPSGR_NME().equals(emptyString) || (passlist
							.get(i).getPSGR_NME() == null))) {
				pstmt.setString(EIGHTEEN, emptyString);
			}
			// /////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getSSR_TYP_CDE().isEmpty())
					&& (!passlist.get(i).getSSR_TYP_CDE().equals(emptyString) && (passlist
							.get(i).getSSR_TYP_CDE() != null))) {
				// System.out.println("SSR_TYP_CDE pstm value: "
				// + passlist.get(i).getSSR_TYP_CDE());
				pstmt.setString(NINETEEN, passlist.get(i).getSSR_TYP_CDE());// passlist.get(i).getSSR_TYP_CDE());
			}
			if ((passlist.get(i).getPSGR_NME().isEmpty())
					|| (passlist.get(i).getSSR_TYP_CDE().equals(emptyString) || (passlist
							.get(i).getSSR_TYP_CDE() == null))) {
				pstmt.setString(NINETEEN, emptyString);
			}
			// ///////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getARRSEG_OP_AL_CDE().isEmpty())
					&& (!passlist.get(i).getARRSEG_OP_AL_CDE()
							.equals(emptyString) && (passlist.get(i)
							.getARRSEG_OP_AL_CDE() != null))) {
				// System.out.println("ARRSEG_OP_AL_CDE pstm value: "
				// + passlist.get(i).getARRSEG_OP_AL_CDE());
				pstmt.setString(TWENTY, passlist.get(i).getARRSEG_OP_AL_CDE());//
			}
			if ((passlist.get(i).getARRSEG_OP_AL_CDE().isEmpty())
					|| (passlist.get(i).getARRSEG_OP_AL_CDE()
							.equals(emptyString) || (passlist.get(i)
							.getARRSEG_OP_AL_CDE() == null))) {
				pstmt.setString(TWENTY, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getARRSEG_OP_FLT_NUM().isEmpty())
					&& (!passlist.get(i).getARRSEG_OP_FLT_NUM()
							.equals(emptyString) && (passlist.get(i)
							.getARRSEG_OP_FLT_NUM() != null))) {
				// System.out.println("getARRSEG_OP_FLT_NUM pstm value: "
				// + passlist.get(i).getARRSEG_OP_FLT_NUM());
				pstmt.setString(TWENTYONE, passlist.get(i)
						.getARRSEG_OP_FLT_NUM());// /////////
			}
			if ((passlist.get(i).getARRSEG_OP_FLT_NUM().isEmpty())
					|| (passlist.get(i).getARRSEG_OP_FLT_NUM()
							.equals(emptyString) || (passlist.get(i)
							.getARRSEG_OP_FLT_NUM() == null))) {
				pstmt.setString(TWENTYONE, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getARRSEG_ORIGAP_CDE().isEmpty())
					&& (!passlist.get(i).getARRSEG_ORIGAP_CDE()
							.equals(emptyString) && (passlist.get(i)
							.getARRSEG_ORIGAP_CDE() != null))) {
				// System.out.println("getARRSEG_ORIGAP_CDE pstm value: "
				// + passlist.get(i).getARRSEG_ORIGAP_CDE());
				pstmt.setString(TWENTYTWO, passlist.get(i)
						.getARRSEG_ORIGAP_CDE());
			}
			if ((passlist.get(i).getARRSEG_ORIGAP_CDE().isEmpty())
					|| (passlist.get(i).getARRSEG_ORIGAP_CDE()
							.equals(emptyString) || (passlist.get(i)
							.getARRSEG_ORIGAP_CDE() == null))) {
				pstmt.setString(TWENTYTWO, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getNEXTSEG_OP_AL_CDE().isEmpty())
					&& (!passlist.get(i).getNEXTSEG_OP_AL_CDE()
							.equals(emptyString) && (passlist.get(i)
							.getNEXTSEG_OP_AL_CDE() != null))) {
				// System.out.println("getNEXTSEG_OP_AL_CDE pstm value: "
				// + passlist.get(i).getNEXTSEG_OP_AL_CDE());
				pstmt.setString(TWENTYTHREE, passlist.get(i)
						.getNEXTSEG_OP_AL_CDE());//
			}
			if ((passlist.get(i).getNEXTSEG_OP_AL_CDE().isEmpty())
					|| (passlist.get(i).getNEXTSEG_OP_AL_CDE()
							.equals(emptyString) || (passlist.get(i)
							.getNEXTSEG_OP_AL_CDE() == null))) {
				pstmt.setString(TWENTYTHREE, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getNEXTSEG_OP_FLT_NUM().isEmpty())
					&& (!passlist.get(i).getNEXTSEG_OP_FLT_NUM()
							.equals(emptyString) && (passlist.get(i)
							.getNEXTSEG_OP_FLT_NUM() != null))) {
				// System.out.println("getNEXTSEG_OP_FLT_NUM pstm value: "
				// + passlist.get(i).getNEXTSEG_OP_FLT_NUM());
				pstmt.setString(TWENTYFOUR, passlist.get(i)
						.getNEXTSEG_OP_FLT_NUM());//
			}
			if ((passlist.get(i).getNEXTSEG_OP_FLT_NUM().isEmpty())
					|| (passlist.get(i).getNEXTSEG_OP_FLT_NUM()
							.equals(emptyString) || (passlist.get(i)
							.getNEXTSEG_OP_FLT_NUM() == null))) {
				pstmt.setString(TWENTYFOUR, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getNEXTSEG_DESTAP_CDE().isEmpty())
					&& (!passlist.get(i).getNEXTSEG_DESTAP_CDE()
							.equals(emptyString) && (passlist.get(i)
							.getNEXTSEG_DESTAP_CDE() != null))) {
				// System.out.println("getNEXTSEG_DESTAP_CDE pstm value: "
				// + passlist.get(i).getNEXTSEG_DESTAP_CDE());
				pstmt.setString(TWENTYFIVE, passlist.get(i)
						.getNEXTSEG_DESTAP_CDE());//
			}
			if ((passlist.get(i).getNEXTSEG_DESTAP_CDE().isEmpty())
					|| (passlist.get(i).getNEXTSEG_DESTAP_CDE()
							.equals(emptyString) || (passlist.get(i)
							.getNEXTSEG_DESTAP_CDE() == null))) {
				pstmt.setString(TWENTYFIVE, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getTKT_NUM().isEmpty())
					&& (!passlist.get(i).getTKT_NUM().equals(emptyString) && (passlist
							.get(i).getTKT_NUM() != null))) {
				// System.out.println("getTKT_NUM pstm value: "
				// + passlist.get(i).getTKT_NUM());
				pstmt.setString(TWENTYSIX, passlist.get(i).getTKT_NUM());
			}
			if ((passlist.get(i).getTKT_NUM().isEmpty())
					|| (passlist.get(i).getTKT_NUM().equals(emptyString) || (passlist
							.get(i).getTKT_NUM() == null))) {
				pstmt.setString(TWENTYSIX, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////

			if ((!passlist.get(i).getTKT_DOC_ISS_LDT().isEmpty())
					&& (!passlist.get(i).getTKT_DOC_ISS_LDT()
							.equals(emptyString) && (passlist.get(i)
							.getTKT_DOC_ISS_LDT() != null))) {
				// System.out.println("getTKT_DOC_ISS_LDT pstm value: "
				// + passlist.get(i).getTKT_DOC_ISS_LDT());
				// pstmt.setString(26, passlist.get(i).getTKT_DOC_ISS_LDT());
				pstmt.setDate(TWENTYSEVEN, java.sql.Date.valueOf(passlist
						.get(i).getTKT_DOC_ISS_LDT()));
			}
			if ((passlist.get(i).getTKT_DOC_ISS_LDT().isEmpty())
					|| (passlist.get(i).getTKT_DOC_ISS_LDT()
							.equals(emptyString) || (passlist.get(i)
							.getTKT_DOC_ISS_LDT() == null))) {
				pstmt.setString(TWENTYSEVEN, null);
			}
			// //////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getFF_AL_CDE().isEmpty())
					&& (!passlist.get(i).getFF_AL_CDE().equals(emptyString) && (passlist
							.get(i).getFF_AL_CDE() != null))) {
				// System.out.println("getFF_AL_CDE pstm value: ");
				pstmt.setString(TWENTYEIGHT, passlist.get(i).getFF_AL_CDE());
			}
			if ((passlist.get(i).getFF_AL_CDE().isEmpty())
					|| (passlist.get(i).getFF_AL_CDE().equals(emptyString) || (passlist
							.get(i).getFF_AL_CDE() == null))) {
				pstmt.setString(TWENTYEIGHT, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getFF_ID().isEmpty())
					&& (!passlist.get(i).getFF_ID().equals(emptyString) && (passlist
							.get(i).getFF_ID() != null))) {
				// System.out.println("getFF_ID pstm value: "
				// + passlist.get(i).getFF_ID());
				pstmt.setString(TWENTYNINE, passlist.get(i).getFF_ID());
			}
			if ((passlist.get(i).getFF_ID().isEmpty())
					|| (passlist.get(i).getFF_ID().equals(emptyString) || (passlist
							.get(i).getFF_ID() == null))) {
				pstmt.setString(TWENTYNINE, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getFF_TIER_LVL_DESC().isEmpty())
					&& (!passlist.get(i).getFF_TIER_LVL_DESC()
							.equals(emptyString) && (passlist.get(i)
							.getFF_TIER_LVL_DESC() != null))) {
				// System.out.println("getFF_TIER_LVL_DESC pstm value: "
				// + passlist.get(i).getFF_TIER_LVL_DESC());
				pstmt.setString(THIRTY, passlist.get(i).getFF_TIER_LVL_DESC());
			}
			if ((passlist.get(i).getFF_TIER_LVL_DESC().isEmpty())
					|| (passlist.get(i).getFF_TIER_LVL_DESC()
							.equals(emptyString) || (passlist.get(i)
							.getFF_TIER_LVL_DESC() == null))) {
				pstmt.setString(THIRTY, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getGOVT_DOC_NUM().isEmpty())
					&& (!passlist.get(i).getGOVT_DOC_NUM().equals(emptyString) && (passlist
							.get(i).getGOVT_DOC_NUM() != null))) {
				// System.out.println("getGOVT_DOC_NUM pstm value: "
				// + passlist.get(i).getGOVT_DOC_NUM());
				pstmt.setString(THIRTYONE, passlist.get(i).getGOVT_DOC_NUM());
			}
			if ((passlist.get(i).getGOVT_DOC_NUM().isEmpty())
					|| (passlist.get(i).getGOVT_DOC_NUM().equals(emptyString) || (passlist
							.get(i).getGOVT_DOC_NUM() == null))) {
				pstmt.setString(THIRTYONE, emptyString);
			}

			// //////////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getBKD_CPMT_CD().isEmpty())
					&& (!passlist.get(i).getBKD_CPMT_CD().equals(emptyString) && (passlist
							.get(i).getBKD_CPMT_CD() != null))) {
				// System.out.println("getBKD_CPMT_CD pstm value: "
				// + passlist.get(i).getBKD_CPMT_CD());
				pstmt.setString(THIRTYTWO, passlist.get(i).getBKD_CPMT_CD());
			}
			if ((passlist.get(i).getBKD_CPMT_CD().isEmpty())
					|| (passlist.get(i).getBKD_CPMT_CD().equals(emptyString) || (passlist
							.get(i).getBKD_CPMT_CD() == null))) {
				pstmt.setString(THIRTYTWO, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getACTL_CPMT_CD().isEmpty())
					&& (!passlist.get(i).getACTL_CPMT_CD().equals(emptyString) && (passlist
							.get(i).getACTL_CPMT_CD() != null))) {
				// System.out.println("getACTL_CPMT_CD pstm value: "
				// + passlist.get(i).getACTL_CPMT_CD());
				pstmt.setString(THIRTYTHREE, passlist.get(i).getACTL_CPMT_CD());
			}
			if ((passlist.get(i).getACTL_CPMT_CD().isEmpty())
					|| (passlist.get(i).getACTL_CPMT_CD().equals(emptyString) || (passlist
							.get(i).getACTL_CPMT_CD() == null))) {
				pstmt.setString(THIRTYTHREE, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getPAX_CKIN_LDT().isEmpty())
					&& (!passlist.get(i).getPAX_CKIN_LDT().equals(emptyString) && (passlist
							.get(i).getPAX_CKIN_LDT() != null))) {
				// System.out.println("getPAX_CKIN_LDT pstm value: "
				// + passlist.get(i).getPAX_CKIN_LDT());
				pstmt.setDate(THIRTYFOUR, java.sql.Date.valueOf(passlist.get(i)
						.getPAX_CKIN_LDT()));
			}
			if ((passlist.get(i).getPAX_CKIN_LDT().isEmpty())
					|| (passlist.get(i).getPAX_CKIN_LDT().equals(emptyString) || (passlist
							.get(i).getPAX_CKIN_LDT() == null))) {
				pstmt.setString(THIRTYFOUR, null);
			}
			// //////////////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getPAX_CKIN_LTM().isEmpty())
					&& (!passlist.get(i).getPAX_CKIN_LTM().equals(emptyString) && (passlist
							.get(i).getPAX_CKIN_LTM() != null))) {
				// System.out.println("PAX_CKIN_LTM pstm value: "
				// + passlist.get(i).getPAX_CKIN_LTM());
				pstmt.setString(THIRTYFIVE, passlist.get(i).getPAX_CKIN_LTM());
			}
			if ((passlist.get(i).getPAX_CKIN_LTM().isEmpty())
					|| (passlist.get(i).getPAX_CKIN_LTM().equals(emptyString) || (passlist
							.get(i).getPAX_CKIN_LTM() == null))) {
				pstmt.setString(THIRTYFIVE, null);
			}
			// //////////////////////////////////////////////////////////////////////////////////

			// System.out.println("getPAX_OBRD_IND pstm value: ");// +
			// passlist.get(i).getPAX_OBRD_IND());
			if ((!passlist.get(i).getPAX_OBRD_IND().isEmpty())
					&& (!passlist.get(i).getPAX_OBRD_IND().equals(emptyString) && (passlist
							.get(i).getPAX_OBRD_IND() != null))) {
				pstmt.setString(THIRTYSIX, passlist.get(i).getPAX_OBRD_IND());
			}
			if ((passlist.get(i).getPAX_OBRD_IND().isEmpty())
					|| (passlist.get(i).getPAX_OBRD_IND().equals(emptyString) || (passlist
							.get(i).getPAX_OBRD_IND() == null))) {
				pstmt.setString(THIRTYSIX, emptyString);
			}
			// //////////////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getPAX_OBRD_LDT().isEmpty())
					&& (!passlist.get(i).getPAX_OBRD_LDT().equals(emptyString) && (passlist
							.get(i).getPAX_OBRD_LDT() != null))) {
				// System.out.println("getPAX_OBRD_LDT pstm value: "
				// + passlist.get(i).getPAX_OBRD_LDT());
				pstmt.setDate(THIRTYSEVEN, java.sql.Date.valueOf(passlist
						.get(i).getLEG_LCL_DPTR_DTE()));//
			}
			if ((passlist.get(i).getPAX_OBRD_LDT().isEmpty())
					|| (passlist.get(i).getPAX_OBRD_LDT().equals(emptyString) || (passlist
							.get(i).getPAX_OBRD_LDT() == null))) {
				pstmt.setString(THIRTYSEVEN, null);
			}
			// //////////////////////////////////////////////////////////////////////////////////

			if ((!passlist.get(i).getPAX_OBRD_LTM().isEmpty())
					&& (!passlist.get(i).getPAX_OBRD_LTM().equals(emptyString) && (passlist
							.get(i).getPAX_OBRD_LTM() != null))) {
				// System.out.println("getPAX_OBRD_LTM"
				// + passlist.get(i).getPAX_OBRD_LTM());
				pstmt.setString(THIRTYEIGHT, passlist.get(i).getPAX_OBRD_LTM());
			}
			if ((passlist.get(i).getPAX_OBRD_LTM().isEmpty())
					|| (passlist.get(i).getPAX_OBRD_LTM().equals(emptyString) || (passlist
							.get(i).getPAX_OBRD_LTM() == null))) {
				pstmt.setString(THIRTYEIGHT, null);
			}
			// //////////////////////////////////////////////////////////////////////////////////
			if ((!passlist.get(i).getFLT_CX_IND().isEmpty())
					&& (!passlist.get(i).getFLT_CX_IND().equals(emptyString) && (passlist
							.get(i).getFLT_CX_IND() != null))) {
				// System.out.println("getFLT_CX_IND pstm value: "
				// + passlist.get(i).getFLT_CX_IND());
				pstmt.setString(THIRTYNINE, passlist.get(i).getFLT_CX_IND());
			}
			if ((passlist.get(i).getFLT_CX_IND().isEmpty())
					|| (passlist.get(i).getFLT_CX_IND().equals(emptyString) || (passlist
							.get(i).getFLT_CX_IND() == null))) {
				pstmt.setString(THIRTYNINE, emptyString);
			}

			pstmt.setDate(FORTY, Date.valueOf(DateString));// REC_PROC_DT
			pstmt.setTimestamp(FORTYONE, ts);

			try {
				// pstmt.executeUpdate();
				pstmt.addBatch();
				if ((i == (passlist.size() - 1)) || (i % 80 == 0)) {
					int[] psList = pstmt.executeBatch();
					System.out
							.println("SPIL PSGR BATCH EXECUTED: " + psList[0]);
				}

			} catch (SQLException e1) {
				//GenMethods.printPassenger(passlist.get(i));
				// Logger.log("Fail in batch load");

				e1.printStackTrace();
				stringSuccessFail = "failed";
				// continue;
			}

		}
		// System.out.println("Batch executed with return type " + numUpd1[0]);
		con.close();

		pstmt.close();
		return stringSuccessFail;

	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSessionContext(SessionContext ctx) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub

	}

}
