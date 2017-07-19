package genMethods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import Objects.Passenger;
import Objects.Waitlist;

public class GenMethods {

	public static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public static String toYrMo(String string) {
		String LEG_LCL_DPTR_YRMO_YR = string.substring(4, 8);
		String LEG_LCL_DPTR_YRMO_MO = string.substring(0, 2);
		String LEG_LCL_DPTR_YRMO = LEG_LCL_DPTR_YRMO_YR + LEG_LCL_DPTR_YRMO_MO;
		return LEG_LCL_DPTR_YRMO;// /

	}

	public static String stringToDate(String x) {
		String convert;
		convert = x.substring(4, 8) + "-" + x.substring(0, 2) + "-"
				+ x.substring(2, 4);
		return convert;

	}

	public static String CustNumSeparateFirst(String x) {
		String convert;
		convert = x.substring(0, 2);
		return convert;
	}

	public static String CustNumSeparateLast(String x) {
		String convert;
		convert = x.substring(3, 5);
		return convert;
	}
	public static Timestamp timeZonetoEST() throws ParseException {
		// SimpleDateFormat sdf = new
		// SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
		Date date = new Date();
		String s = sdf.format(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss.SSS");
		Date parsedDate = dateFormat.parse(s);
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		return timestamp;
	}
	public static Timestamp timeZonetoGMT() throws ParseException {
		// SimpleDateFormat sdf = new
		// SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date = new Date();
		String s = sdf.format(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss.SSS");
		Date parsedDate = dateFormat.parse(s);
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		return timestamp;
	}

	public static boolean doesPLUSasciiExist(String s) {
		char c[] = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if ((int) c[i] == 43) {
				return true;
			}
		}
		return false;
	}

	public static int getFirstAsciiFromStringtoInt(String x) {
		char c[] = x.toCharArray();
		return (int) c[0];

	}

	public static int getLastAsciiFromStringtoInt(String x) {
		char c[] = x.toCharArray();
		return (int) c[(c.length) - 1];

	}

	public static int getSecondToLastAsciiFromStringtoInt(String x) {
		char c[] = x.toCharArray();
		return (int) c[(c.length) - 2];

	}

	public static int getFirstAsciiFromString(String x) {
		int ascii = 0;
		if (x.equals("")) {
			char c[] = x.toCharArray();
			ascii = (int) c[0];

		} else {
			ascii = 1;
		}
		// ascii = (int) c[0];
		return ascii;
	}

	public static String readFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		try {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}

			return stringBuilder.toString();
		} finally {
			reader.close();
		}
	}

	public static void printWaitlist(Waitlist waitlist) {
		System.out.println("LEG_LCL_DPTR_YRMO: "
				+ waitlist.getLEG_LCL_DPTR_YRMO() + "	" + "LEG_LCL_DPTR_DTE: "
				+ waitlist.getLEG_LCL_DPTR_DTE() + "	" + "OP_AL_CDE: "
				+ waitlist.getOP_AL_CDE() + "	" + "OP_FLT_NUM: "
				+ waitlist.getOP_FLT_NUM() + "	" + "LEG_ORIG_AP_CDE: "
				+ waitlist.getLEG_ORIG_AP_CDE() + "	" + "MULT_DPTR_SEQ_NUM: "
				+ waitlist.getMULT_DPTR_SEQ_NUM() + "	" + "WL_PSGR_LST_NUM: "
				+ waitlist.getWL_PSGR_LST_NUM() + "	" + "PNR_LOCTR_NUM: "
				+ waitlist.getPNR_LOCTR_NUM() + "	" + "PNR_FILE_ADDR: "
				+ waitlist.getPNR_FILE_ADDR() + "PSGR_NME: "
				+ waitlist.getPSGR_NME() + "	" + "WL_VRFY_TYP_CDE: "
				+ waitlist.getWL_VRFY_TYP_CDE() + "	" + "WL_BRD_TYP_CDE: "
				+ waitlist.getWL_BRD_TYP_CDE() + "	" + "WL_RES_TYP_CDE: "
				+ waitlist.getWL_RES_TYP_CDE() + "	" + "SEG_DEST_AP_CDE: "
				+ waitlist.getSEG_DEST_AP_CDE() + "	" + "WL_SVC_TYP_CDE: "
				+ waitlist.getWL_SVC_TYP_CDE() + "	" + "WL_TYP_CDE: "
				+ waitlist.getWL_TYP_CDE() + "	" + "TRVL_CL_CDE: "
				+ waitlist.getTRVL_CL_CDE() + "	" + "EMP_SEN_DTE: "
				+ waitlist.getEMP_SEN_DTE() + "	" + "WL_UTC_CRTN_TME: "
				+ waitlist.getWL_UTC_CRTN_TME());
	}

	public static void printPassenger(Passenger passenger) {
		System.out.println("LEG_LCL_DPTR_YRMO: "
				+ passenger.getLEG_LCL_DPTR_YRMO() + "	" + "LEG_LCL_DPTR_DTE: "
				+ passenger.getLEG_LCL_DPTR_DTE() + "	" + "OP_AL_CDE: "
				+ passenger.getOP_AL_CDE() + "	" + "OP_FLT_NUM: "
				+ passenger.getOP_FLT_NUM() + "	" + "LEG_ORIG_AP_CDE: "
				+ passenger.getLEG_ORIG_AP_CDE() + "MULT_DPTR_SEQ_NUM: "
				+ passenger.getMULT_DPTR_SEQ_NUM() + "	" + "ROW_SEAT_NUM: "
				+ passenger.getROW_SEAT_NUM() + "	" + "PAX_SEAT_STT_CD: "
				+ passenger.getPAX_SEAT_STT_CD() + "	" + "PNR_LOCTR_NUM: "
				+ passenger.getPNR_LOCTR_NUM() + "	" + "BKG_CRTN_GDT: "
				+ passenger.getBKG_CRTN_GDT() + "	" + "PNR_FILE_ADDR: "
				+ passenger.getPNR_FILE_ADDR() + "	" + "ITINSEG_DESTAP_CDE: "
				+ passenger.getITINSEG_DESTAP_CDE() + "	" + "INV_CL_CDE: "
				+ passenger.getINV_CL_CDE() + "	" + "SPIL_TYP_CDE: "
				+ passenger.getSPIL_TYP_CDE() + "	" + "CUST_ID: "
				+ passenger.getCUST_ID() + "CUST_FRST_NM_NB: "
				+ passenger.getCUST_FRST_NM_NB() + "CUST_LST_NM_NB: "
				+ passenger.getCUST_LST_NM_NB() + "	" + "PSGR_NME: "
				+ passenger.getPSGR_NME() + "	" + "SSR_TYP_CDE: "
				+ passenger.getSSR_TYP_CDE() + "	" + "ARRSEG_OP_AL_CDE: "
				+ passenger.getARRSEG_OP_AL_CDE() + "	" + "ARRSEG_OP_FLT_NUM: "
				+ passenger.getARRSEG_OP_FLT_NUM() + "	"
				+ "ARRSEG_ORIGAP_CDE: " + passenger.getARRSEG_ORIGAP_CDE()
				+ "	" + "NEXTSEG_OP_AL_CDE: "
				+ passenger.getNEXTSEG_OP_AL_CDE() + "	"
				+ "NEXTSEG_OP_FLT_NUM: " + passenger.getNEXTSEG_OP_FLT_NUM()
				+ "	" + "NEXTSEG_DESTAP_CDE: "
				+ passenger.getNEXTSEG_DESTAP_CDE() + "	" + "TKT_NUM: "
				+ passenger.getTKT_NUM() + "	" + "TKT_DOC_ISS_LDT: "
				+ passenger.getTKT_DOC_ISS_LDT() + "	" + "FF_AL_CDE: "
				+ passenger.getFF_AL_CDE() + "	" + "FF_ID: "
				+ passenger.getFF_ID() + "	" + "FF_TIER_LVL_DESC: "
				+ passenger.getFF_TIER_LVL_DESC() + "	" + "GOVT_DOC_NUM: "
				+ passenger.getGOVT_DOC_NUM() + "	" + "BKD_CPMT_CD: "
				+ passenger.getBKD_CPMT_CD() + "	" + "ACTL_CPMT_CD: "
				+ passenger.getACTL_CPMT_CD() + "PAX_CKIN_LDT: "
				+ passenger.getPAX_CKIN_LDT() + "	" + "PAX_CKIN_LTM: "
				+ passenger.getPAX_CKIN_LTM() + "PAX_OBRD_IND: "
				+ passenger.getPAX_OBRD_IND() + "	" + "PAX_OBRD_LDT: "
				+ passenger.getPAX_OBRD_LDT() + "	" + "PAX_OBRD_LTM: "
				+ passenger.getPAX_OBRD_LTM() + "	" + "FLT_CX_IND: "
				+ passenger.getFLT_CX_IND());
	}

	// ///////////////

	public static Timestamp convertStringToTimestamp(String str_date) {
		try {
			System.out.println("DATE--" + str_date);
			DateFormat formatter;
			// "yyyy-MM-dd hh:mm:ss.SSS"
			formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS");
			Date date = (Date) formatter.parse(str_date);

			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

			return timeStampDate;
		} catch (ParseException e) {
			System.out
					.println("GenMethods - convertStringToTimestamp() method Exception :"
							+ e);
			return null;
		}
	}

	// /////////////////////////
	public static boolean isLocAlpha(String name) {
	    char[] chars = name.toCharArray();

	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }

	    return true;
	}
	public static boolean flightNumStringTester(String s) {
		boolean testBool = false;
		if (s.length()!= 4){
			return testBool;

		}
		if (s.substring(0, 1).equals("0") || s.substring(0, 1).equals("1")
				|| s.substring(0, 1).equals("2") || s.substring(0, 1).equals("3")
				|| s.substring(0, 1).equals("4") || s.substring(0, 1).equals("5")
				|| s.substring(0, 1).equals("6") || s.substring(0, 1).equals("7")
				|| s.substring(0, 1).equals("8") || s.substring(0, 1).equals("9")) {
			if (s.substring(1, 2).equals("0") || s.substring(1, 2).equals("1")
					|| s.substring(1, 2).equals("2") || s.substring(1, 2).equals("3")
					|| s.substring(1, 2).equals("4") || s.substring(1, 2).equals("5")
					|| s.substring(1, 2).equals("6") || s.substring(1, 2).equals("7")
					|| s.substring(1, 2).equals("8") || s.substring(1, 2).equals("9")) {
				if (s.substring(2, 3).equals("0") || s.substring(2, 3).equals("1")
						|| s.substring(2, 3).equals("2") || s.substring(2, 3).equals("3")
						|| s.substring(2, 3).equals("4") || s.substring(2, 3).equals("5")
						|| s.substring(2, 3).equals("6") || s.substring(2, 3).equals("7")
						|| s.substring(2, 3).equals("8") || s.substring(2, 3).equals("9")) {
					if (s.substring(3, 4).equals("0") || s.substring(3, 4).equals("1")
							|| s.substring(3, 4).equals("2") || s.substring(3, 4).equals("3")
							|| s.substring(3, 4).equals("4") || s.substring(3, 4).equals("5")
							|| s.substring(3, 4).equals("6") || s.substring(3, 4).equals("7")
							|| s.substring(3, 4).equals("8") || s.substring(3, 4).equals("9")) {
						testBool = true;
					}
				}
			}
		}
		else{
			testBool = false;
		}
		return testBool;
	}

	public static boolean dateStringTester(String s) {
		boolean testBool = false;

		if (s.equals("01JAN") ||

		s.equals("02JAN") || s.equals("03JAN") || s.equals("04JAN") || s.equals("05JAN")
				|| s.equals("06JAN") || s.equals("07JAN") || s.equals("08JAN") || s.equals("09JAN")
				|| s.equals("10JAN") || s.equals("11JAN") || s.equals("12JAN") || s.equals("13JAN")
				|| s.equals("14JAN") || s.equals("15JAN") || s.equals("16JAN") || s.equals("17JAN")
				|| s.equals("18JAN") || s.equals("19JAN") || s.equals("20JAN") || s.equals("21JAN")
				|| s.equals("22JAN") || s.equals("23JAN") || s.equals("24JAN") || s.equals("25JAN")
				|| s.equals("26JAN") || s.equals("27JAN") || s.equals("28JAN") || s.equals("29JAN")
				|| s.equals("30JAN") || s.equals("31JAN") || s.equals("01FEB") || s.equals("02FEB")
				|| s.equals("03FEB") || s.equals("04FEB") || s.equals("05FEB") || s.equals("06FEB")
				|| s.equals("07FEB") || s.equals("08FEB") || s.equals("09FEB") || s.equals("10FEB")
				|| s.equals("11FEB") || s.equals("12FEB") || s.equals("13FEB") || s.equals("14FEB")
				|| s.equals("15FEB") || s.equals("16FEB") || s.equals("17FEB") || s.equals("18FEB")
				|| s.equals("19FEB") || s.equals("20FEB") || s.equals("21FEB") || s.equals("22FEB")
				|| s.equals("23FEB") || s.equals("24FEB") || s.equals("25FEB") || s.equals("26FEB")
				|| s.equals("27FEB") || s.equals("28FEB") || s.equals("29FEB") || s.equals("01MAR")
				|| s.equals("02MAR") || s.equals("03MAR") || s.equals("04MAR") || s.equals("05MAR")
				|| s.equals("06MAR") || s.equals("07MAR") || s.equals("08MAR") || s.equals("09MAR")
				|| s.equals("10MAR") || s.equals("11MAR") || s.equals("12MAR") || s.equals("13MAR")
				|| s.equals("14MAR") || s.equals("15MAR") || s.equals("16MAR") || s.equals("17MAR")
				|| s.equals("18MAR") || s.equals("19MAR") || s.equals("20MAR") || s.equals("21MAR")
				|| s.equals("22MAR") || s.equals("23MAR") || s.equals("24MAR") || s.equals("25MAR")
				|| s.equals("26MAR") || s.equals("27MAR") || s.equals("28MAR") || s.equals("29MAR")
				|| s.equals("30MAR") || s.equals("31MAR") || s.equals("01APR") || s.equals("02APR")
				|| s.equals("03APR") || s.equals("04APR") || s.equals("05APR") || s.equals("06APR")
				|| s.equals("07APR") || s.equals("08APR") || s.equals("09APR") || s.equals("10APR")
				|| s.equals("11APR") || s.equals("12APR") || s.equals("13APR") || s.equals("14APR")
				|| s.equals("15APR") || s.equals("16APR") || s.equals("17APR") || s.equals("18APR")
				|| s.equals("19APR") || s.equals("20APR") || s.equals("21APR") || s.equals("22APR")
				|| s.equals("23APR") || s.equals("24APR") || s.equals("25APR") || s.equals("26APR")
				|| s.equals("27APR") || s.equals("28APR") || s.equals("29APR") || s.equals("30APR")
				|| s.equals("01MAY") || s.equals("02MAY") || s.equals("03MAY") || s.equals("04MAY")
				|| s.equals("05MAY") || s.equals("06MAY") || s.equals("07MAY") || s.equals("08MAY")
				|| s.equals("09MAY") || s.equals("10MAY") || s.equals("11MAY") || s.equals("12MAY")
				|| s.equals("13MAY") || s.equals("14MAY") || s.equals("15MAY") || s.equals("16MAY")
				|| s.equals("17MAY") || s.equals("18MAY") || s.equals("19MAY") || s.equals("20MAY")
				|| s.equals("21MAY") || s.equals("22MAY") || s.equals("23MAY") || s.equals("24MAY")
				|| s.equals("25MAY") || s.equals("26MAY") || s.equals("27MAY") || s.equals("28MAY")
				|| s.equals("29MAY") || s.equals("30MAY") || s.equals("31MAY") || s.equals("01JUN")
				|| s.equals("02JUN") || s.equals("03JUN") || s.equals("04JUN") || s.equals("05JUN")
				|| s.equals("06JUN") || s.equals("07JUN") || s.equals("08JUN") || s.equals("09JUN")
				|| s.equals("10JUN") || s.equals("11JUN") || s.equals("12JUN") || s.equals("13JUN")
				|| s.equals("14JUN") || s.equals("15JUN") || s.equals("16JUN") || s.equals("17JUN")
				|| s.equals("18JUN") || s.equals("19JUN") || s.equals("20JUN") || s.equals("21JUN")
				|| s.equals("22JUN") || s.equals("23JUN") || s.equals("24JUN") || s.equals("25JUN")
				|| s.equals("26JUN") || s.equals("27JUN") || s.equals("28JUN") || s.equals("29JUN")
				|| s.equals("30JUN") || s.equals("01JUL") || s.equals("02JUL") || s.equals("03JUL")
				|| s.equals("04JUL") || s.equals("05JUL") || s.equals("06JUL") || s.equals("07JUL")
				|| s.equals("08JUL") || s.equals("09JUL") || s.equals("10JUL") || s.equals("11JUL")
				|| s.equals("12JUL") || s.equals("13JUL") || s.equals("14JUL") || s.equals("15JUL")
				|| s.equals("16JUL") || s.equals("17JUL") || s.equals("18JUL") || s.equals("19JUL")
				|| s.equals("20JUL") || s.equals("21JUL") || s.equals("22JUL") || s.equals("23JUL")
				|| s.equals("24JUL") || s.equals("25JUL") || s.equals("26JUL") || s.equals("27JUL")
				|| s.equals("28JUL") || s.equals("29JUL") || s.equals("30JUL") || s.equals("31JUL")
				|| s.equals("01AUG") || s.equals("02AUG") || s.equals("03AUG") || s.equals("04AUG")
				|| s.equals("05AUG") || s.equals("06AUG") || s.equals("07AUG") || s.equals("08AUG")
				|| s.equals("09AUG") || s.equals("10AUG") || s.equals("11AUG") || s.equals("12AUG")
				|| s.equals("13AUG") || s.equals("14AUG") || s.equals("15AUG") || s.equals("16AUG")
				|| s.equals("17AUG") || s.equals("18AUG") || s.equals("19AUG") || s.equals("20AUG")
				|| s.equals("21AUG") || s.equals("22AUG") || s.equals("23AUG") || s.equals("24AUG")
				|| s.equals("25AUG") || s.equals("26AUG") || s.equals("27AUG") || s.equals("28AUG")
				|| s.equals("29AUG") || s.equals("30AUG") || s.equals("31AUG") || s.equals("01SEP")
				|| s.equals("02SEP") || s.equals("03SEP") || s.equals("04SEP") || s.equals("05SEP")
				|| s.equals("06SEP") || s.equals("07SEP") || s.equals("08SEP") || s.equals("09SEP")
				|| s.equals("10SEP") || s.equals("11SEP") || s.equals("12SEP") || s.equals("13SEP")
				|| s.equals("14SEP") || s.equals("15SEP") || s.equals("16SEP") || s.equals("17SEP")
				|| s.equals("18SEP") || s.equals("19SEP") || s.equals("20SEP") || s.equals("21SEP")
				|| s.equals("22SEP") || s.equals("23SEP") || s.equals("24SEP") || s.equals("25SEP")
				|| s.equals("26SEP") || s.equals("27SEP") || s.equals("28SEP") || s.equals("29SEP")
				|| s.equals("30SEP") || s.equals("01OCT") || s.equals("02OCT") || s.equals("03OCT")
				|| s.equals("04OCT") || s.equals("05OCT") || s.equals("06OCT") || s.equals("07OCT")
				|| s.equals("08OCT") || s.equals("09OCT") || s.equals("10OCT") || s.equals("11OCT")
				|| s.equals("12OCT") || s.equals("13OCT") || s.equals("14OCT") || s.equals("15OCT")
				|| s.equals("16OCT") || s.equals("17OCT") || s.equals("18OCT") || s.equals("19OCT")
				|| s.equals("20OCT") || s.equals("21OCT") || s.equals("22OCT") || s.equals("23OCT")
				|| s.equals("24OCT") || s.equals("25OCT") || s.equals("26OCT") || s.equals("27OCT")
				|| s.equals("28OCT") || s.equals("29OCT") || s.equals("30OCT") || s.equals("31OCT")
				|| s.equals("01NOV") || s.equals("02NOV") || s.equals("03NOV") || s.equals("04NOV")
				|| s.equals("05NOV") || s.equals("06NOV") || s.equals("07NOV") || s.equals("08NOV")
				|| s.equals("09NOV") || s.equals("10NOV") || s.equals("11NOV") || s.equals("12NOV")
				|| s.equals("13NOV") || s.equals("14NOV") || s.equals("15NOV") || s.equals("16NOV")
				|| s.equals("17NOV") || s.equals("18NOV") || s.equals("19NOV") || s.equals("20NOV")
				|| s.equals("21NOV") || s.equals("22NOV") || s.equals("23NOV") || s.equals("24NOV")
				|| s.equals("25NOV") || s.equals("26NOV") || s.equals("27NOV") || s.equals("28NOV")
				|| s.equals("29NOV") || s.equals("30NOV") || s.equals("01DEC") || s.equals("02DEC")
				|| s.equals("03DEC") || s.equals("04DEC") || s.equals("05DEC") || s.equals("06DEC")
				|| s.equals("07DEC") || s.equals("08DEC") || s.equals("09DEC") || s.equals("10DEC")
				|| s.equals("11DEC") || s.equals("12DEC") || s.equals("13DEC") || s.equals("14DEC")
				|| s.equals("15DEC") || s.equals("16DEC") || s.equals("17DEC") || s.equals("18DEC")
				|| s.equals("19DEC") || s.equals("20DEC") || s.equals("21DEC") || s.equals("22DEC")
				|| s.equals("23DEC") || s.equals("24DEC") || s.equals("25DEC") || s.equals("26DEC")
				|| s.equals("27DEC") || s.equals("28DEC") || s.equals("29DEC") || s.equals("30DEC")
				|| s.equals("31DEC") ){
			testBool = true;
		}
		else {
			testBool = false;
		}
		return testBool;
	}
}
