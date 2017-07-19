package Objects;

public class Passenger {
//	Passenger passenger = new Passenger();
	private String REMARKS_STRING = "";
	private String LEG_LCL_DPTR_YRMO="";
	private String LEG_LCL_DPTR_DTE=null;
	private String OP_AL_CDE="";
	private String OP_FLT_NUM="";
	private String LEG_ORIG_AP_CDE="";
	private int MULT_DPTR_SEQ_NUM=1;
	private String ROW_SEAT_NUM="";
	private String PAX_SEAT_STT_CD="";
	private String PNR_LOCTR_NUM="";
	private String BKG_CRTN_GDT=null;
	private String PNR_FILE_ADDR="";
	private String ITINSEG_DESTAP_CDE="";
	private String INV_CL_CDE="";
	private String SPIL_TYP_CDE="";
	private String CUST_ID="";
	private String CUST_FRST_NM_NB="";
	private String CUST_LST_NM_NB="";
	private String PSGR_NME="";
	private String SSR_TYP_CDE="";
	private String ARRSEG_OP_AL_CDE="";
	private String ARRSEG_OP_FLT_NUM="";
	private String ARRSEG_ORIGAP_CDE="";
	private String NEXTSEG_OP_AL_CDE="";
	private String NEXTSEG_OP_FLT_NUM="";
	private String NEXTSEG_DESTAP_CDE="";
	private String TKT_NUM="";
	private String TKT_DOC_ISS_LDT=null;
	private String FF_AL_CDE="";
	private String FF_ID="";
	private String FF_TIER_LVL_DESC="";
	private String GOVT_DOC_NUM="";
	private String BKD_CPMT_CD="";
	private String ACTL_CPMT_CD="";
	private String PAX_CKIN_LDT=null;
	private String PAX_CKIN_LTM=null;
	private String PAX_OBRD_IND="";
	private String PAX_OBRD_LDT=null;
	private String PAX_OBRD_LTM=null;
	private String FLT_CX_IND="";

	public String getLEG_LCL_DPTR_YRMO() {
		return LEG_LCL_DPTR_YRMO;
	}

	public void setLEG_LCL_DPTR_YRMO(String lEG_LCL_DPTR_YRMO) {
		LEG_LCL_DPTR_YRMO = lEG_LCL_DPTR_YRMO;
	}

	public String getLEG_LCL_DPTR_DTE() {
		return LEG_LCL_DPTR_DTE;
	}

	public void setLEG_LCL_DPTR_DTE(String lEG_LCL_DPTR_DTE) {
		LEG_LCL_DPTR_DTE = lEG_LCL_DPTR_DTE;
	}

	public String getOP_AL_CDE() {
		return OP_AL_CDE;
	}

	public void setOP_AL_CDE(String oP_AL_CDE) {
		OP_AL_CDE = oP_AL_CDE;
	}

	public String getOP_FLT_NUM() {
		return OP_FLT_NUM;
	}

	public void setOP_FLT_NUM(String oP_FLT_NUM) {
		OP_FLT_NUM = oP_FLT_NUM;
	}

	public String getLEG_ORIG_AP_CDE() {
		return LEG_ORIG_AP_CDE;
	}

	public void setLEG_ORIG_AP_CDE(String lEG_ORIG_AP_CDE) {
		LEG_ORIG_AP_CDE = lEG_ORIG_AP_CDE;
	}

	public int getMULT_DPTR_SEQ_NUM() {
		return MULT_DPTR_SEQ_NUM;
	}

	public void setMULT_DPTR_SEQ_NUM(int mULT_DPTR_SEQ_NUM) {
		MULT_DPTR_SEQ_NUM = mULT_DPTR_SEQ_NUM;
	}

	public String getROW_SEAT_NUM() {
		return ROW_SEAT_NUM;
	}

	public void setROW_SEAT_NUM(String rOW_SEAT_NUM) {
		ROW_SEAT_NUM = rOW_SEAT_NUM;
	}

	public String getPAX_SEAT_STT_CD() {
		return PAX_SEAT_STT_CD;
	}

	public void setPAX_SEAT_STT_CD(String pAX_SEAT_STT_CD) {
		PAX_SEAT_STT_CD = pAX_SEAT_STT_CD;
	}

	public String getPNR_LOCTR_NUM() {
		return PNR_LOCTR_NUM;
	}

	public void setPNR_LOCTR_NUM(String pNR_LOCTR_NUM) {
		PNR_LOCTR_NUM = pNR_LOCTR_NUM;
	}

	public String getBKG_CRTN_GDT() {
		return BKG_CRTN_GDT;
	}

	public void setBKG_CRTN_GDT(String bKG_CRTN_GDT) {
		BKG_CRTN_GDT = bKG_CRTN_GDT;
	}

	public String getPNR_FILE_ADDR() {
		return PNR_FILE_ADDR;
	}

	public void setPNR_FILE_ADDR(String pNR_FILE_ADDR) {
		PNR_FILE_ADDR = pNR_FILE_ADDR;
	}

	public String getITINSEG_DESTAP_CDE() {
		return ITINSEG_DESTAP_CDE;
	}

	public void setITINSEG_DESTAP_CDE(String iTINSEG_DESTAP_CDE) {
		ITINSEG_DESTAP_CDE = iTINSEG_DESTAP_CDE;
	}

	public String getINV_CL_CDE() {
		return INV_CL_CDE;
	}

	public void setINV_CL_CDE(String iNV_CL_CDE) {
		INV_CL_CDE = iNV_CL_CDE;
	}

	public String getSPIL_TYP_CDE() {
		return SPIL_TYP_CDE;
	}

	public void setSPIL_TYP_CDE(String sPIL_TYP_CDE) {
		SPIL_TYP_CDE = sPIL_TYP_CDE;
	}

	public String getCUST_ID() {
		return CUST_ID;
	}

	public void setCUST_ID(String cUST_ID) {
		CUST_ID = cUST_ID;
	}

	public String getCUST_FRST_NM_NB() {
		return CUST_FRST_NM_NB;
	}

	public void setCUST_FRST_NM_NB(String cUST_FRST_NM_NB) {
		CUST_FRST_NM_NB = cUST_FRST_NM_NB;
	}

	public String getCUST_LST_NM_NB() {
		return CUST_LST_NM_NB;
	}

	public void setCUST_LST_NM_NB(String cUST_LST_NM_NB) {
		CUST_LST_NM_NB = cUST_LST_NM_NB;
	}

	public String getPSGR_NME() {
		return PSGR_NME;
	}

	public void setPSGR_NME(String pSGR_NME) {
		PSGR_NME = pSGR_NME;
	}

	public String getSSR_TYP_CDE() {
		return SSR_TYP_CDE;
	}

	public void setSSR_TYP_CDE(String sSR_TYP_CDE) {
		SSR_TYP_CDE = sSR_TYP_CDE;
	}

	public String getARRSEG_OP_AL_CDE() {
		return ARRSEG_OP_AL_CDE;
	}

	public void setARRSEG_OP_AL_CDE(String aRRSEG_OP_AL_CDE) {
		ARRSEG_OP_AL_CDE = aRRSEG_OP_AL_CDE;
	}

	public String getARRSEG_OP_FLT_NUM() {
		return ARRSEG_OP_FLT_NUM;
	}

	public void setARRSEG_OP_FLT_NUM(String aRRSEG_OP_FLT_NUM) {
		ARRSEG_OP_FLT_NUM = aRRSEG_OP_FLT_NUM;
	}

	public String getARRSEG_ORIGAP_CDE() {
		return ARRSEG_ORIGAP_CDE;
	}

	public void setARRSEG_ORIGAP_CDE(String aRRSEG_ORIGAP_CDE) {
		ARRSEG_ORIGAP_CDE = aRRSEG_ORIGAP_CDE;
	}

	public String getNEXTSEG_OP_AL_CDE() {
		return NEXTSEG_OP_AL_CDE;
	}

	public void setNEXTSEG_OP_AL_CDE(String nEXTSEG_OP_AL_CDE) {
		NEXTSEG_OP_AL_CDE = nEXTSEG_OP_AL_CDE;
	}

	public String getNEXTSEG_OP_FLT_NUM() {
		return NEXTSEG_OP_FLT_NUM;
	}

	public void setNEXTSEG_OP_FLT_NUM(String nEXTSEG_OP_FLT_NUM) {
		NEXTSEG_OP_FLT_NUM = nEXTSEG_OP_FLT_NUM;
	}

	public String getNEXTSEG_DESTAP_CDE() {
		return NEXTSEG_DESTAP_CDE;
	}

	public void setNEXTSEG_DESTAP_CDE(String nEXTSEG_DESTAP_CDE) {
		NEXTSEG_DESTAP_CDE = nEXTSEG_DESTAP_CDE;
	}

	public String getTKT_NUM() {
		return TKT_NUM;
	}

	public void setTKT_NUM(String tKT_NUM) {
		TKT_NUM = tKT_NUM;
	}

	public String getTKT_DOC_ISS_LDT() {
		return TKT_DOC_ISS_LDT;
	}

	public void setTKT_DOC_ISS_LDT(String tKT_DOC_ISS_LDT) {
		TKT_DOC_ISS_LDT = tKT_DOC_ISS_LDT;
	}

	public String getFF_AL_CDE() {
		return FF_AL_CDE;
	}

	public void setFF_AL_CDE(String fF_AL_CDE) {
		FF_AL_CDE = fF_AL_CDE;
	}

	public String getFF_ID() {
		return FF_ID;
	}

	public void setFF_ID(String fF_ID) {
		FF_ID = fF_ID;
	}

	public String getFF_TIER_LVL_DESC() {
		return FF_TIER_LVL_DESC;
	}

	public void setFF_TIER_LVL_DESC(String fF_TIER_LVL_DESC) {
		FF_TIER_LVL_DESC = fF_TIER_LVL_DESC;
	}

	public String getGOVT_DOC_NUM() {
		return GOVT_DOC_NUM;
	}

	public void setGOVT_DOC_NUM(String gOVT_DOC_NUM) {
		GOVT_DOC_NUM = gOVT_DOC_NUM;
	}

	public String getBKD_CPMT_CD() {
		return BKD_CPMT_CD;
	}

	public void setBKD_CPMT_CD(String bKD_CPMT_CD) {
		BKD_CPMT_CD = bKD_CPMT_CD;
	}

	public String getACTL_CPMT_CD() {
		return ACTL_CPMT_CD;
	}

	public void setACTL_CPMT_CD(String aCTL_CPMT_CD) {
		ACTL_CPMT_CD = aCTL_CPMT_CD;
	}

	public String getPAX_CKIN_LDT() {
		return PAX_CKIN_LDT;
	}

	public void setPAX_CKIN_LDT(String pAX_CKIN_LDT) {
		PAX_CKIN_LDT = pAX_CKIN_LDT;
	}

	public String getPAX_CKIN_LTM() {
		return PAX_CKIN_LTM;
	}

	public void setPAX_CKIN_LTM(String pAX_CKIN_LTM) {
		PAX_CKIN_LTM = pAX_CKIN_LTM;
	}

	public String getPAX_OBRD_IND() {
		return PAX_OBRD_IND;
	}

	public void setPAX_OBRD_IND(String pAX_OBRD_IND) {
		PAX_OBRD_IND = pAX_OBRD_IND;
	}

	public String getPAX_OBRD_LDT() {
		return PAX_OBRD_LDT;
	}

	public void setPAX_OBRD_LDT(String pAX_OBRD_LDT2) {
		PAX_OBRD_LDT = pAX_OBRD_LDT2;
	}

	public String getPAX_OBRD_LTM() {
		return PAX_OBRD_LTM;
	}

	public void setPAX_OBRD_LTM(String pAX_OBRD_LTM) {
		PAX_OBRD_LTM = pAX_OBRD_LTM;
	}

	public String getFLT_CX_IND() {
		return FLT_CX_IND;
	}

	public void setFLT_CX_IND(String fLT_CX_IND) {
		FLT_CX_IND = fLT_CX_IND;
	}

	public String getREMARKS_STRING() {
		return REMARKS_STRING;
	}

	public void setREMARKS_STRING(String rEMARKS_STRING) {
		REMARKS_STRING = rEMARKS_STRING;
	}

}
