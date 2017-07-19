package parsers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import Objects.Waitlist;

import Objects.Passenger;
import genMethods.GenMethods;

public class Parsers {

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
	// static final int TWENTYTWO = 22;
	static final int TWENTYTHREE = 23;
	static final int TWENTYFOUR = 24;
	static final int TWENTYFIVE = 25;
	static final int TWENTYSIX = 26;
	static final int TWENTYSEVEN = 27;
	static final int TWENTYEIGHT = 28;
	static final int TWENTYNINE = 29;
	static final int THIRTY = 30;
	static final int THIRTYONE = 31;
	static final int FORTYTHREE = 43;
	static final int FORTYEIGHT = 48;
	static final int EIGHTY = 80;

	static final String simpleDateFormatString = "yyyy-MM-dd"; // /yyyy-MM-dd
	static final String GMTString = "GMT";

	public static ArrayList<Waitlist> waitlistListLoad(List<String> list) {

		DateFormat dateFormat = new SimpleDateFormat(simpleDateFormatString);
		dateFormat.setTimeZone(TimeZone.getTimeZone(GMTString));
		ArrayList<Waitlist> waitlist = new ArrayList<Waitlist>();
		// System.out.println("LEG_LCL_DPTR_YRMO: " + list.get(3));

		String LEG_LCL_DPTR_YRMO = GenMethods.toYrMo(list.get(THREE));
		//String LEG_LCL_DPTR_DTE = (list.get(THREE));
		String LEG_LCL_DPTR_DTE = GenMethods.stringToDate(list.get(THREE));
		String OP_AL_CDE = list.get(ONE);
		String OP_FLT_NUM = list.get(TWO);
		String LEG_ORIG_AP_CDE = list.get(FOUR);
		String WL_UTC_CRTN_TME = emptyString, WL_RES_TYP_CDE = emptyString, WL_BRD_TYP_CDE = emptyString, EMP_SEN_DTE = emptyString;
		String WL_TYP_CDE = emptyString, PNR_LOCTR_NUM = emptyString, PNR_FILE_ADDR = emptyString;
		String PSGR_NME = emptyString;
		String WL_SVC_TYP_CDE = emptyString;
		String TRVL_CL_CDE = emptyString, WL_PSGR_LST_NUM = emptyString, SEG_DEST_AP_CDE = emptyString, WL_VRFY_TYP_CDE;
		int passcount = ZERO;
		for (int i = 0; i < list.size(); i++) {
			// if (list.get(i).endsWith(" 0P")) {
			if (!list.get(i).isEmpty() && list.get(i).length() > ONE) {
				//System.out.println(list.get(i).toString());
				//System.out.println("List size is " + list.size());
				if ((GenMethods.getLastAsciiFromStringtoInt(list.get(i)) == EIGHTY)
						&& (GenMethods.getSecondToLastAsciiFromStringtoInt(list
								.get(i)) == FORTYEIGHT)&& GenMethods.doesPLUSasciiExist(list.get(i))) {
					
					
					Waitlist w1 = new Waitlist();

					if ((!list.get(i + /*ONE*/1).isEmpty())
							&& (!list.get(i + 1/*ONE*/).equals(emptyString))
							&& !list.get(i).equals(null)) {
						//
					//	System.out.println("WL LIST: " + list.get(i + 1/*ONE*/));
						//
						PNR_LOCTR_NUM = list.get(i + 1/*ONE*/);
					} else
						PNR_LOCTR_NUM = emptyString;
					if ((!list.get(i + 2/*TWO*/).isEmpty())
							&& (!list.get(i + 2/*TWO*/).equals(emptyString))) {

						PNR_FILE_ADDR = list.get(i + 2/*TWO*/);
					} else
						PNR_FILE_ADDR = emptyString;

					if ((!list.get(i + 3/*THREE*/).isEmpty())
							&& (!list.get(i + 3/*THREE*/).equals(emptyString))) {

						list.get(i + 3/*THREE*/);
					} else {
					}
					if ((!list.get(i + 4).isEmpty())
							&& (!list.get(i + 4).equals(emptyString))) {

						WL_PSGR_LST_NUM = list.get(i + 4);

					} else
						WL_PSGR_LST_NUM = emptyString;
					if ((!list.get(i + 5/*FIVE*/).isEmpty())
							&& (!list.get(i + 5/*FIVE*/).equals(emptyString))) {

						WL_VRFY_TYP_CDE = list.get(i + 5/*FIVE*/).substring(ZERO,
								ONE);
					} else {
						WL_VRFY_TYP_CDE = emptyString;
					}

					if ((!list.get(i + 6/*SIX*/).isEmpty())
							&& (!list.get(i + 6/*SIX*/).equals(emptyString))) {

						WL_BRD_TYP_CDE = list.get(i + 6/*SIX*/);
					} else {
						WL_BRD_TYP_CDE="";
					}

					if ((!list.get(i + 7/*SEVEN*/).isEmpty())
							&& (!list.get(i + 7/*SEVEN*/).equals(emptyString))) {

						WL_RES_TYP_CDE = list.get(i + 7/*SEVEN*/);
					} else {
						WL_RES_TYP_CDE = "";

					}


					if ((!list.get(i + 8/*EIGHT*/).isEmpty())
							&& (!list.get(i + 8/*EIGHT*/).equals(emptyString))) {

						SEG_DEST_AP_CDE = list.get(i + 8/*EIGHT*/);
					} else
						{
						SEG_DEST_AP_CDE = "";
						}
				//		LEG_ORIG_AP_CDE = emptyString;
				//	LEG_ORIG_AP_CDE = list.get(i + 8/*EIGHT*/);


					if ((!list.get(i + 9/*NINE*/).isEmpty())
							&& (!list.get(i + 9/*NINE*/).equals(emptyString))) {
						WL_SVC_TYP_CDE = list.get(i + 9/*NINE*/);
					} else
						WL_SVC_TYP_CDE = emptyString;
					if ((!list.get(i + 10/*TEN*/).isEmpty())
							&& (!list.get(i + 10/*TEN*/).equals(emptyString))) {
						WL_TYP_CDE = list.get(i + 10/*TEN*/);
					} else{
						WL_TYP_CDE = emptyString;
					}
					if ((!list.get(i + 11).isEmpty())
							&& (!list.get(i + 11).equals(emptyString))) {
					TRVL_CL_CDE = list.get(i + 11);
					}
					else{
						TRVL_CL_CDE=emptyString;
					}
					if ((!list.get(i + 12/*TWELVE*/).isEmpty())
							&& (!list.get(i + 12/*TWELVE*/).equals(emptyString))) {
						EMP_SEN_DTE = list.get(i + 12/*TWELVE*/).substring(FOUR,
								EIGHT)
								+ "-"
								+ list.get(i + 12/*TWELVE*/).substring(ZERO, TWO)
								+ "-"
								+ list.get(i + 12/*TWELVE*/).substring(TWO, FOUR);
					} else {
						EMP_SEN_DTE = "1900-01-01";
					}

					if ((!list.get(i + 13/*THIRTEEN*/).isEmpty())
							&& (!list.get(i + 13/*THIRTEEN*/).equals(emptyString))) {
						WL_UTC_CRTN_TME = list.get(i + 13/*THIRTEEN*/).substring(
								ZERO, TWO)
								+ "."
								+ list.get(i + 13/*THIRTEEN*/).substring(TWO, FOUR)
								+ ".00";
					} else
						WL_UTC_CRTN_TME = "12.59.00";

					if ((!list.get(i + 14/*FOURTEEN*/).isEmpty())
							&& (!list.get(i + 14/*FOURTEEN*/).equals(emptyString))) {
						PSGR_NME = list.get(i + 14/*FOURTEEN*/);
						String plusStr = "+";
						if (list.get(i + 14/*FOURTEEN*/).contains(plusStr)) {
						//	System.out.println("plusStr: " + plusStr);
							PSGR_NME = list.get(i + 14/*FOURTEEN*/).substring(ZERO,
									list.get(i + 14/*FOURTEEN*/).indexOf(plusStr));
						//	System.out.println("PSGR_NME: " + PSGR_NME);
						}
					} else if ((list.get(i + 14/*FOURTEEN*/).isEmpty())
							|| (!list.get(i + 14/*FOURTEEN*/).equals(emptyString))) {
						PSGR_NME=emptyString;
						
					}

					w1.setWL_UTC_CRTN_TME(WL_UTC_CRTN_TME);
					w1.setWL_BRD_TYP_CDE(WL_BRD_TYP_CDE);
					w1.setWL_SVC_TYP_CDE(WL_SVC_TYP_CDE);
					w1.setWL_TYP_CDE(WL_TYP_CDE);
					w1.setWL_RES_TYP_CDE(WL_RES_TYP_CDE);
					w1.setLEG_LCL_DPTR_YRMO(LEG_LCL_DPTR_YRMO);
					w1.setWL_PSGR_LST_NUM(WL_PSGR_LST_NUM);
					w1.setLEG_LCL_DPTR_DTE(LEG_LCL_DPTR_DTE);
					w1.setSEG_DEST_AP_CDE(SEG_DEST_AP_CDE);
					w1.setOP_AL_CDE(OP_AL_CDE);
					w1.setTRVL_CL_CDE(TRVL_CL_CDE);
					w1.setOP_FLT_NUM(OP_FLT_NUM);
					w1.setLEG_ORIG_AP_CDE(LEG_ORIG_AP_CDE);
					w1.setPNR_LOCTR_NUM(PNR_LOCTR_NUM);
					w1.setPNR_FILE_ADDR(PNR_FILE_ADDR);
					w1.setPSGR_NME(PSGR_NME);
					w1.setWL_VRFY_TYP_CDE(WL_VRFY_TYP_CDE);
					w1.setEMP_SEN_DTE(EMP_SEN_DTE);
					waitlist.add(w1);

				//	System.out.println("WL Passenger count: " + ++passcount);

					if (i + 15 >= list.size()) {
					//	System.out.println("Fifteen plus i is " + i
					//			+ 15);
					//	System.out.println("List size is " + list.size());
						return waitlist;
					}
				}
			}
		}
		return waitlist;
	}

	public static ArrayList<Objects.Passenger> parsePassengerToObjects(
			ArrayList<String> list) {
		ArrayList<Passenger> passlist = new ArrayList<Passenger>();
		java.sql.Timestamp ts = new java.sql.Timestamp(
				new java.util.Date().getTime());// FILE_RCVD_LTS
		String LEG_LCL_DPTR_YRMO = GenMethods.toYrMo(list.get(THREE));
		String LEG_LCL_DPTR_DTE = (list.get(THREE));
		LEG_LCL_DPTR_DTE = GenMethods.stringToDate(list.get(THREE));
		String OP_AL_CDE = list.get(ONE);
		String OP_FLT_NUM = list.get(TWO);
		String LEG_ORIG_AP_CDE = list.get(FOUR);
		String FLT_CX_IND = list.get(FIVE);
		String ROW_SEAT_NUM = emptyString, PAX_SEAT_STT_CD = emptyString, PNR_LOCTR_NUM = emptyString, BKG_CRTN_GDT = null, PNR_FILE_ADDR = emptyString, ITINSEG_DESTAP_CDE = emptyString, INV_CL_CDE = emptyString, SPIL_TYP_CDE = emptyString;
		String CUST_ID = emptyString, CUST_FRST_NM_NB = emptyString, CUST_LST_NM_NB = emptyString, PSGR_NME = emptyString, SSR_TYP_CDE = emptyString, ARRSEG_OP_AL_CDE = emptyString;
		String ARRSEG_OP_FLT_NUM = emptyString, ARRSEG_ORIGAP_CDE = emptyString, NEXTSEG_OP_AL_CDE = emptyString;
		String NEXTSEG_OP_FLT_NUM = emptyString, NEXTSEG_DESTAP_CDE = emptyString, TKT_NUM = emptyString, TKT_DOC_ISS_LDT = null, FF_AL_CDE = emptyString, FF_ID = emptyString, FF_TIER_LVL_DESC = emptyString, GOVT_DOC_NUM = emptyString;
		String BKD_CPMT_CD = emptyString, PAX_CKIN_LDT = emptyString, ACTL_CPMT_CD = emptyString;
		String PAX_CKIN_LTM = emptyString, PAX_OBRD_IND = emptyString, PAX_OBRD_LDT = emptyString, PAX_OBRD_LTM = emptyString, REMARKS_STRING = emptyString;
		int passcount = 0;
		int waitlistSeatCounter = 0;

		for (int i = 0; i != list.size(); i++) {

			if (list.get(i).endsWith(" S")) {
				if (GenMethods.getSecondToLastAsciiFromStringtoInt(list.get(i)) != FORTYEIGHT) {
					if (GenMethods.doesPLUSasciiExist(list.get(i))) {

						Passenger p1 = new Passenger();
						String delimeterComma = "\\,";
						if ((!list.get(i + /*TWENTYTHREE*/23).isEmpty())
								&& !list.get(i + /*TWENTYTHREE*/23).equals(
										emptyString)) {
							REMARKS_STRING = list.get(i + /*TWENTYTHREE*/23);
							list.get(i + /*TWENTYTHREE*/23).split(delimeterComma);
						}
						// //////////////////////////////
						if ((!list.get(i + /*FIVE*/5).isEmpty())
								&& (!list.get(i + /*FIVE*/5).equals(emptyString))
								&& (!list.get(i + /*FIVE*/5).equals("99X"))
								&& ((!list.get(i + /*EIGHT*/8).equals("IN")))) { // checks
																			// that
																			// SPIL_TYP_CDE
																			// does
																			// not
																			// equal
																			// 'IN')
							ROW_SEAT_NUM = list.get(i + /*FIVE*/5);
						}
						// ///////Infant ET changes begins
						else if ((!list.get(i + /*FIVE*/5).isEmpty())
								&& (!list.get(i + /*FIVE*/5).equals(emptyString))
								&& (!list.get(i + /*FIVE*/5).equals("99X"))
								&& ((list.get(i + /*EIGHT*/8).equals("IN")))) { // checks
																			// that
																			// SPIL_TYP_CDE
																			// does
																			// equal
																			// 'IN'
																			// and
																			// there
																			// is
																			// a
																			// seat
																			// number

							ROW_SEAT_NUM = list.get(i + /*FIVE*/5) + "I";
						} else if (list.get(i + /*EIGHT*/8).equals("IN")
								&& waitlistSeatCounter < 99) {
							ROW_SEAT_NUM = "X"
									+ String.format("%02d",
											++waitlistSeatCounter) + "I";
						}
						// //////Infant ET changes ends
						else if (waitlistSeatCounter < 99) {
							ROW_SEAT_NUM = "X"
									+ String.format("%02d",
											++waitlistSeatCounter);
						} else {
							ROW_SEAT_NUM = "X"
									+ String.format("%03d",
											++waitlistSeatCounter);

						}
				//		System.out.println("ROW_SEAT_NUM: " + ROW_SEAT_NUM);
						// ///////////////////////////////////////////
						if ((!list.get(i + /*FOUR*/4).isEmpty())
								&& (!list.get(i + /*FOUR*/4).equals(emptyString))) {
							PAX_SEAT_STT_CD = list.get(i + /*FOUR*/4);
						} else
							PAX_SEAT_STT_CD = emptyString;
						/*
						 * System.out.println("PAX_SEAT_STT_CD: " +
						 * PAX_SEAT_STT_CD);
						 */
						if ((!list.get(i + /*ONE*/1).isEmpty())
								&& (!list.get(i + /*ONE*/1).equals(emptyString))) {
							PNR_LOCTR_NUM = list.get(i + /*ONE*/1);
						} else
							PNR_LOCTR_NUM = emptyString;
						/*
						 * System.out.println("PNR_LOCTR_NUM: " +
						 * PNR_LOCTR_NUM);
						 */
						if ((!list.get(i + /*TWENTYSIX*/26).isEmpty())
								&& (!list.get(i + /*TWENTYSIX*/26)
										.equals(emptyString))) {

							BKG_CRTN_GDT = GenMethods.stringToDate(list.get(i
									+ /*TWENTYSIX*/26));
							/*
							 * System.out.println("BKG_CRTN_GDT: " +
							 * BKG_CRTN_GDT);
							 */} else
							BKG_CRTN_GDT = emptyString;

						if ((!list.get(i + /*TWO*/2).isEmpty())
								&& (!list.get(i + /*TWO*/2).equals(emptyString))) {

							PNR_FILE_ADDR = list.get(i + /*TWO*/2);
							/*
							 * System.out.println("PNR_FILE_ADDR: " +
							 * PNR_FILE_ADDR);
							 */
						} else
							PNR_FILE_ADDR = emptyString;

						if ((!list.get(i + /*SIX*/6).isEmpty())
								&& (!list.get(i + /*SIX*/6).equals(emptyString))) {

							ITINSEG_DESTAP_CDE = list.get(i + /*SIX*/6);
							// System.out.println("ITINSEG_DESTAP_CDE: " +
							// ITINSEG_DESTAP_CDE);
						} else
							ITINSEG_DESTAP_CDE = emptyString;

						if ((!list.get(i + /*EIGHT*/8).isEmpty())
								&& (!list.get(i + /*EIGHT*/8).equals(emptyString))) {
							// System.out.println("INV_CL_CDE: " + INV_CL_CDE);
							SPIL_TYP_CDE = list.get(i + /*EIGHT*/8);
						} else
							SPIL_TYP_CDE = emptyString;

						// System.out.println("SPIL_TYP_CDE: " + SPIL_TYP_CDE);
						if ((!list.get(i + /*TWENTYFIVE*/25).isEmpty())
								&& (!list.get(i + /*TWENTYFIVE*/25).equals(
										emptyString))) {
							CUST_ID = list.get(i + /*TWENTYFIVE*/25);
						} else
							CUST_ID = emptyString;

						// System.out.println("CUST_ID: " + CUST_ID);
						if ((!list.get(i + /*TWENTYFOUR*/24).isEmpty())
								&& (!list.get(i + /*TWENTYFOUR*/24).equals(
										emptyString))) {

							CUST_FRST_NM_NB = GenMethods
									.CustNumSeparateFirst(list.get(i
											+ /*TWENTYFOUR*/24));
						} else
							CUST_FRST_NM_NB = emptyString;

						// System.out.println("CUST_FRST_NM_NB: " +
						// CUST_FRST_NM_NB);
						if ((!list.get(i + /*TWENTYFOUR*/24).isEmpty())
								&& (!list.get(i + /*TWENTYFOUR*/24).equals(
										emptyString))) {

							CUST_LST_NM_NB = GenMethods
									.CustNumSeparateLast(list.get(i
											+ /*TWENTYFOUR*/24));
						} else
							CUST_LST_NM_NB = emptyString;

						// System.out.println("CUST_LST_NM_NB: " +
						// CUST_LST_NM_NB);
						if ((!list.get(i + /*TWENTYONE*/21).isEmpty())
								&& (!list.get(i + /*TWENTYONE*/21)
										.equals(emptyString))) {
							PSGR_NME = list.get(i + /*TWENTYONE*/21);
						} else
							PSGR_NME = emptyString;

						if ((!list.get(i + /*TWENTYTHREE*/23).isEmpty()
								&& !list.get(i + /*TWENTYTHREE*/23)
										.substring(ZERO, ONE).isEmpty()
								&& !list.get(i + /*TWENTYTHREE*/23)
										.substring(ONE, TWO).isEmpty()
								&& !list.get(i + /*TWENTYTHREE*/23)
										.substring(TWO, THREE).isEmpty() && !list
								.get(i + /*TWENTYTHREE*/23).substring(THREE, FOUR)
								.isEmpty())
								&& (!list.get(i + /*TWENTYTHREE*/23).equals(
										emptyString))) {
							SSR_TYP_CDE = list.get(i + /*TWENTYTHREE*/23).substring(
									ZERO, FOUR);
							// REMARKS_STRING = list.get(i + TWENTYTHREE);
							/*
							 * System.out.println("SSR_TYP_CDE: " +
							 * SSR_TYP_CDE);
							 * System.out.println("REMARKS_STRING: " +
							 * REMARKS_STRING);
							 */
						} else {
							SSR_TYP_CDE = emptyString;
							REMARKS_STRING = emptyString;
						}
						if ((!list.get(i + /*TEN*/10).isEmpty())
								&& (!list.get(i + /*TEN*/10).equals(emptyString))) {
							ARRSEG_OP_AL_CDE = list.get(i + /*TEN*/10);

						} else
							ARRSEG_OP_AL_CDE = emptyString;
						if ((!list.get(i + /*ELEVEN*/11).isEmpty())
								&& (!list.get(i + /*ELEVEN*/11).equals(emptyString))) {
							ARRSEG_OP_FLT_NUM = list.get(i + /*ELEVEN*/11);
							// }
						} else
							ARRSEG_OP_FLT_NUM = emptyString;

						if ((!list.get(i + /*TWELVE*/12).isEmpty())
								&& (!list.get(i +  /*TWELVE*/12).equals(emptyString))) {
							ARRSEG_ORIGAP_CDE = list.get(i +  /*TWELVE*/12);
						} else
							ARRSEG_ORIGAP_CDE = emptyString;

						// System.out.println("ARRSEG_ORIGAP_CDE: " +
						// ARRSEG_ORIGAP_CDE);

						if ((!list.get(i + /*THIRTEEN*/13).isEmpty())
								&& (!list.get(i + /*THIRTEEN*/13).equals(emptyString))) {
							NEXTSEG_OP_AL_CDE = list.get(i + /*THIRTEEN*/13);
						} else
							NEXTSEG_OP_AL_CDE = emptyString;
						// System.out.println("NEXTSEG_OP_AL_CDE: " +
						// NEXTSEG_OP_AL_CDE);

						if ((!list.get(i + /*FOURTEEN*/14).isEmpty())
								&& (!list.get(i + /*FOURTEEN*/14).equals(emptyString))) {
							NEXTSEG_OP_FLT_NUM = list.get(i + /*FOURTEEN*/14);
						} else
							NEXTSEG_OP_FLT_NUM = emptyString;

						// System.out.println("NEXTSEG_OP_FLT_NUM: " +
						// NEXTSEG_OP_FLT_NUM);
						if ((!list.get(i + /*FIFTEEN*/15).isEmpty())
								&& (!list.get(i + /*FIFTEEN*/15).equals(emptyString))) {
							NEXTSEG_DESTAP_CDE = list.get(i + /*FIFTEEN*/15);
						} else
							NEXTSEG_DESTAP_CDE = emptyString;

						// System.out.println("NEXTSEG_DESTAP_CDE: " +
						// NEXTSEG_DESTAP_CDE);

						if ((!list.get(i + /*SEVENTEEN*/17).isEmpty())
								&& (!list.get(i + /*SEVENTEEN*/17)
										.equals(emptyString))) {
							TKT_NUM = list.get(i + /*SEVENTEEN*/17);
						} else
							TKT_NUM = emptyString;

						if ((!list.get(i + /*TWENTYSEVEN*/27).isEmpty())
								&& (!list.get(i + /*TWENTYSEVEN*/27).equals(
										emptyString))
								&& (!list.get(i + /*TWENTYSEVEN*/27).equals(null))) {
							TKT_DOC_ISS_LDT = GenMethods.stringToDate(list
									.get(i + /*TWENTYSEVEN*/27));
						} else {
							TKT_DOC_ISS_LDT = emptyString;
						}

						// System.out.println("TKT_DOC_ISS_LDT: " +
						// TKT_DOC_ISS_LDT);

						if ((!list.get(i + /*EIGHTEEN*/18).isEmpty())
								&& (!list.get(i + /*EIGHTEEN*/18).equals(emptyString))) {
							FF_AL_CDE = list.get(i + /*EIGHTEEN*/18);
						} else
							FF_AL_CDE = emptyString;

						// System.out.println("FF_AL_CDE: " + FF_AL_CDE);

						if ((!list.get(i + /*NINETEEN*/19).isEmpty())
								&& (!list.get(i + /*NINETEEN*/19).equals(emptyString))) {
							FF_ID = list.get(i + /*NINETEEN*/19);
						} else
							FF_ID = emptyString;

						// System.out.println("FF_ID: " + FF_ID);

						if ((!list.get(i + /*SIXTEEN*/16).isEmpty())
								&& (!list.get(i + /*SIXTEEN*/16).equals(emptyString))) {
							FF_TIER_LVL_DESC = list.get(i + /*SIXTEEN*/16);
						} else
							FF_TIER_LVL_DESC = emptyString;

						// System.out.println("FF_TIER_LVL_DESC: " +
						// FF_TIER_LVL_DESC);

						if ((!list.get(i + /*TWENTY*/20).isEmpty())
								&& (!list.get(i + /*TWENTY*/20).equals(emptyString))) {
							GOVT_DOC_NUM = list.get(i + /*TWENTY*/20);
						} else
							GOVT_DOC_NUM = emptyString;

						// System.out.println("GOVT_DOC_NUM: " + GOVT_DOC_NUM);
						if ((!list.get(i + /*TWENTYEIGHT*/28).isEmpty())
								&& (!list.get(i + /*TWENTYEIGHT*/28).equals(
										emptyString))) {
							BKD_CPMT_CD = list.get(i + /*TWENTYEIGHT*/28).substring(
									ZERO, ONE);
						} else
							BKD_CPMT_CD = emptyString;

						// System.out.println("BKD_CPMT_CD: " + BKD_CPMT_CD);
						if ((!list.get(i + /*TWENTYEIGHT*/28).isEmpty())
								&& (!list.get(i + /*TWENTYEIGHT*/28).equals(
										emptyString))) {
							ACTL_CPMT_CD = list.get(i + /*TWENTYEIGHT*/28).substring(
									ONE, TWO);
						} else
							ACTL_CPMT_CD = emptyString;

						// System.out.println("ACTL_CPMT_CD: " + ACTL_CPMT_CD);

						if ((!list.get(i + /*TWENTYNINE*/29).isEmpty())
								&& (!list.get(i + /*TWENTYNINE*/29).equals(
										emptyString))
								&& (GenMethods.getFirstAsciiFromString(list
										.get(i + /*TWENTYNINE*/29))) != FORTYTHREE) {
							PAX_CKIN_LDT = GenMethods.stringToDate(list.get(i
									+ /*TWENTYNINE*/29));
						} else
							PAX_CKIN_LDT = emptyString;

						// System.out.println("PAX_CKIN_LDT: " + PAX_CKIN_LDT);

						if ((!list.get(i + /*THIRTY*/30).isEmpty())
								&& (!list.get(i + /*THIRTY*/30).equals(emptyString))

								&& (GenMethods.getFirstAsciiFromString(list
										.get(i + /*THIRTY*/30)) != FORTYTHREE)) {

							PAX_CKIN_LTM = list.get(i + /*THIRTY*/30).substring(ZERO,
									TWO)
									+ "."
									+ list.get(i + /*THIRTY*/30).substring(TWO, FOUR)
									+ ".00";
						} else
							PAX_CKIN_LTM = emptyString;

						if (!list.get(i + /*THIRTYONE*/31).isEmpty()
								&& !list.get(i + /*THIRTYONE*/31).equals(emptyString)) {

							if (GenMethods.getFirstAsciiFromString(list.get(i
									+ /*THIRTYONE*/31)) != FORTYTHREE) {

								PAX_OBRD_LDT = GenMethods.stringToDate(list
										.get(i + /*THIRTYONE*/31));
							}
						} else
							PAX_OBRD_LDT = emptyString;

						String PAX_OBRD_LTM_StringClean = list.get(i + /*THIRTY*/30)
								.replaceAll("\\D+", emptyString);
						if (PAX_OBRD_LTM_StringClean.equals(emptyString)
								&& !PAX_OBRD_LTM_StringClean.equals(null)
								&& !PAX_OBRD_LTM_StringClean.equals(SPACE)) {
							PAX_OBRD_LTM = PAX_OBRD_LTM_StringClean;
						} else
							PAX_OBRD_LTM = emptyString;

						// System.out.println("PAX_OBRD_LTM: " + PAX_OBRD_LTM);
						p1.setLEG_LCL_DPTR_YRMO(LEG_LCL_DPTR_YRMO);
						// System.out.println("LEG_LCL_DPTR_YRMO "
						// + p1.getLEG_LCL_DPTR_YRMO());
						p1.setLEG_LCL_DPTR_DTE(LEG_LCL_DPTR_DTE);
						// System.out.println("LEG_LCL_DPTR_DTE "
						// + p1.getLEG_LCL_DPTR_DTE());
						p1.setOP_AL_CDE(OP_AL_CDE);

						p1.setOP_FLT_NUM(OP_FLT_NUM);
						// System.out.println(p1.getOP_FLT_NUM());

						p1.setLEG_ORIG_AP_CDE(LEG_ORIG_AP_CDE);
						// System.out.println(p1.getLEG_ORIG_AP_CDE());

						// System.out.println(p1.getOP_FLT_NUM());
						// System.out.println("LEG_ORIG_AP_CDE: "
						// + p1.getLEG_ORIG_AP_CDE());

						p1.setROW_SEAT_NUM(ROW_SEAT_NUM);
						// System.out.println("ROW_SEAT_NUM: " +
						// p1.getROW_SEAT_NUM());

						p1.setPAX_SEAT_STT_CD(PAX_SEAT_STT_CD);
						// System.out.println("PAX_SEAT_STT_CD: "
						// + p1.getPAX_SEAT_STT_CD());

						p1.setPNR_LOCTR_NUM(PNR_LOCTR_NUM);
						// System.out.println("PNR_LOCTR_NUM: " +
						// p1.getPNR_LOCTR_NUM());

						p1.setBKG_CRTN_GDT(BKG_CRTN_GDT);
						// System.out.println("BKG_CRTN_GDT: " + BKG_CRTN_GDT);

						p1.setPNR_FILE_ADDR(PNR_FILE_ADDR);
						// System.out.println("BKG_CRTN_GDT: " +
						// p1.getPNR_FILE_ADDR());

						p1.setITINSEG_DESTAP_CDE(ITINSEG_DESTAP_CDE);
						// System.out.println("ITINSEG_DESTAP_CDE: "
						// + p1.getITINSEG_DESTAP_CDE());

						p1.setINV_CL_CDE(INV_CL_CDE);
						// System.out.println("INV_CL_CDE: " +
						// p1.getINV_CL_CDE());

						p1.setSPIL_TYP_CDE(SPIL_TYP_CDE);
						// System.out.println("SPIL_TYP_CDE: " +
						// p1.getSPIL_TYP_CDE());

						p1.setCUST_ID(CUST_ID);
						// System.out.println("SPIL_TYP_CDE: " +
						// p1.getCUST_ID());

						p1.setCUST_FRST_NM_NB(CUST_FRST_NM_NB);
						// System.out.println("CUST_FRST_NM_NB: " +
						// CUST_FRST_NM_NB);

						p1.setCUST_LST_NM_NB(CUST_LST_NM_NB);
						// System.out.println("CUST_LST_NM_NB: " +
						// p1.getCUST_LST_NM_NB());

						p1.setPSGR_NME(PSGR_NME);
						// System.out.println("CUST_LST_NM_NB: " +
						// p1.getPSGR_NME());

						p1.setSSR_TYP_CDE(SSR_TYP_CDE);
						// System.out.println("SSR_TYP_CDE: " + SSR_TYP_CDE);

						p1.setARRSEG_OP_AL_CDE(ARRSEG_OP_AL_CDE);
						// System.out.println("ARRSEG_OP_AL_CDE: "
						// + p1.getARRSEG_OP_AL_CDE());

						p1.setARRSEG_OP_FLT_NUM(ARRSEG_OP_FLT_NUM);
						// System.out.println("ARRSEG_OP_FLT_NUM: "
						// + p1.getARRSEG_OP_FLT_NUM());

						p1.setARRSEG_ORIGAP_CDE(ARRSEG_ORIGAP_CDE);
						// System.out.println("ARRSEG_ORIGAP_CDE: "
						// + p1.getARRSEG_ORIGAP_CDE());

						p1.setNEXTSEG_OP_AL_CDE(NEXTSEG_OP_AL_CDE);
						// System.out.println("NEXTSEG_OP_AL_CDE: "
						// + p1.getNEXTSEG_OP_AL_CDE());

						p1.setNEXTSEG_OP_FLT_NUM(NEXTSEG_OP_FLT_NUM);
						// System.out.println("NEXTSEG_OP_FLT_NUM: "
						// + p1.getNEXTSEG_OP_FLT_NUM());

						p1.setNEXTSEG_DESTAP_CDE(NEXTSEG_DESTAP_CDE);
						// System.out.println("NEXTSEG_DESTAP_CDE: "
						// + p1.getNEXTSEG_DESTAP_CDE());

						p1.setTKT_NUM(TKT_NUM);
						// System.out.println("TKT_NUM: " + p1.getTKT_NUM());

						p1.setTKT_DOC_ISS_LDT(TKT_DOC_ISS_LDT);
						// System.out.println("TKT_DOC_ISS_LDT: "
						// + p1.getTKT_DOC_ISS_LDT());

						p1.setFF_AL_CDE(FF_AL_CDE);
						// System.out.println("FF_AL_CDE: " +
						// p1.getFF_AL_CDE());

						p1.setFF_ID(FF_ID);
						// System.out.println("FF_ID: " + p1.getFF_ID());

						p1.setFF_TIER_LVL_DESC(FF_TIER_LVL_DESC);
						// System.out.println("FF_TIER_LVL_DESC: "
						// + p1.getFF_TIER_LVL_DESC());

						p1.setGOVT_DOC_NUM(GOVT_DOC_NUM);
						// System.out.println("GOVT_DOC_NUM: " +
						// p1.getGOVT_DOC_NUM());

						p1.setBKD_CPMT_CD(BKD_CPMT_CD);
						// System.out.println("BKD_CPMT_CD: " +
						// p1.getBKD_CPMT_CD());

						p1.setACTL_CPMT_CD(ACTL_CPMT_CD);
						// System.out.println("ACTL_CPMT_CD: " +
						// p1.getACTL_CPMT_CD());

						p1.setPAX_CKIN_LDT(PAX_CKIN_LDT);
						// System.out.println("PAX_CKIN_LDT: " +
						// p1.getPAX_CKIN_LDT());

						p1.setPAX_CKIN_LTM(PAX_CKIN_LTM);
						// System.out.println("PAX_CKIN_LTM: " +
						// p1.getPAX_CKIN_LTM());

						p1.setPAX_OBRD_IND(PAX_OBRD_IND);
						// System.out.println("PAX_OBRD_IND: " +
						// p1.getPAX_OBRD_IND());

						p1.setPAX_OBRD_LDT(PAX_OBRD_LDT);
						// System.out.println("PAX_OBRD_LDT-Before object placement: "
						// + p1.getPAX_OBRD_LDT());
						if (list.get(i + /*THIRTYONE*/31) != null
								&& !list.get(i + /*THIRTYONE*/31).isEmpty()
								&& GenMethods.getFirstAsciiFromString(list
										.get(i + /*THIRTYONE*/31)) != /*FORTYTHREE*/43) {
							PAX_OBRD_LDT = GenMethods.stringToDate(list.get(i
									+ /*THIRTYONE*/31));
						}
						p1.setREMARKS_STRING(REMARKS_STRING);
						p1.setPAX_OBRD_LTM(PAX_OBRD_LTM);
						p1.setFLT_CX_IND(FLT_CX_IND);
						passcount++;
				//		System.out.println("Passenger count: " + passcount);
						passlist.add(p1);
					}
				}
			}
		}

		return passlist;
	}

}
