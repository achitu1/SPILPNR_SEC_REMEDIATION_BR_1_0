package Objects;


public class Waitlist extends Passenger {

	private String WL_RES_TYP_CDE = "";
	private String WL_TYP_CDE = "";
	private String WL_SVC_TYP_CDE = "";
	private String TRVL_CL_CDE = "";
	private String WL_PSGR_LST_NUM = "";
	private String WL_VRFY_TYP_CDE="";
	private String WL_BRD_TYP_CDE="";
	private String SEG_DEST_AP_CDE="";
	private String WL_UTC_CRTN_TME="";
	private String EMP_SEN_DTE="";
	
	public void setWL_RES_TYP_CDE(String wL_RES_TYP_CDE) {
		WL_RES_TYP_CDE = wL_RES_TYP_CDE;
	}

	public String getWL_RES_TYP_CDE() {
		return WL_RES_TYP_CDE;
	}

	public void setWL_TYP_CDE(String wL_TYP_CDE) {
		WL_TYP_CDE = wL_TYP_CDE;
	}

	public String getWL_TYP_CDE() {
		return WL_TYP_CDE;
	}

	public void setWL_SVC_TYP_CDE(String wL_SVC_TYP_CDE) {
		WL_SVC_TYP_CDE = wL_SVC_TYP_CDE;
	}

	public String getWL_SVC_TYP_CDE() {
		return WL_SVC_TYP_CDE;
	}

	public void setTRVL_CL_CDE(String tRVL_CL_CDE) {
		TRVL_CL_CDE = tRVL_CL_CDE;
	}

	public String getTRVL_CL_CDE() {
		return TRVL_CL_CDE;
	}

	public void setWL_PSGR_LST_NUM(String wL_PSGR_LST_NUM) {
		WL_PSGR_LST_NUM = wL_PSGR_LST_NUM;
	}

	public String getWL_PSGR_LST_NUM() {
		return WL_PSGR_LST_NUM;
	}

	public void setWL_VRFY_TYP_CDE(String wL_VRFY_TYP_CDE) {
		WL_VRFY_TYP_CDE = wL_VRFY_TYP_CDE;
	}

	public String getWL_VRFY_TYP_CDE() {
		return WL_VRFY_TYP_CDE;
	}

	public void setWL_BRD_TYP_CDE(String wL_BRD_TYP_CDE) {
		WL_BRD_TYP_CDE = wL_BRD_TYP_CDE;
	}

	public String getWL_BRD_TYP_CDE() {
		return WL_BRD_TYP_CDE;
	}

	public void setSEG_DEST_AP_CDE(String sEG_DEST_AP_CDE) {
		SEG_DEST_AP_CDE = sEG_DEST_AP_CDE;
	}

	public String getSEG_DEST_AP_CDE() {
		return SEG_DEST_AP_CDE;
	}

	public void setWL_UTC_CRTN_TME(String wL_UTC_CRTN_TME) {
		WL_UTC_CRTN_TME = wL_UTC_CRTN_TME;
	}

	public String getWL_UTC_CRTN_TME() {
		return WL_UTC_CRTN_TME;
	}

	public void setEMP_SEN_DTE(String eMP_SEN_DTE) {
		EMP_SEN_DTE = eMP_SEN_DTE;
	}

	public String getEMP_SEN_DTE() {
		return EMP_SEN_DTE;
	}
	
	public String EMP_SEN_DTEtoDateString(String s) {
		EMP_SEN_DTE = s.substring(0, 2)+"-"+s.substring(2, 4)+"-"+s.substring(4, 8);
		return EMP_SEN_DTE;
	}
	
}
