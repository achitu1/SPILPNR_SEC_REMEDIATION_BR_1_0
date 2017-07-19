package com.delta.PNRJ.forms;



import java.sql.Timestamp;
import java.util.ArrayList;



import javax.servlet.http.HttpServletRequest;



import org.apache.struts.action.ActionError;

import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionMapping;

import org.apache.struts.validator.ValidatorForm;



/**

 * Form bean for a Struts application.

 * 

 * @version 1.0

 * @author

 */

public class PNRJ002_OnDemandlookupDefaultForm extends ValidatorForm {
	
	private Timestamp timeStamp = null;

	private Timestamp selTimeStamp = null;

	public Timestamp getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}







	private String userName = null;

	private String pnrLocator = null;

	private String frequentFlyerNumber = null;

	private String ticketNumber = null;

	// private String creditCardNumber = null;

	private String creditCardNumber = "";

	private String employeeNumber = null;

	private ArrayList pnrList = null;

	private String pnrDetail = null;

	private String userAuthorizedCC = null;

	private ArrayList pnrTextList = null;

	// private String pnrTextList = null;

	private String selPnrLoctrNum = null;

	private String selPnrCrtnDate = null;

	private String selPassenger = null;

	private String selFlightNumber = null;

	private String loctrNum = "A";

	private String crtnDate = "A";

	private String travelDateSort = "A";

	private String mkAlCode = "A";

	private String fltNum = "A";

	private String segOrigApCode = "A";

	private String segDestApCode = "A";

	private String psngrNme = "A";

	private String invClCode = "A";

	private String segStatusCode = "A";

	private boolean showRedisplay = true;

	private ArrayList fopList = null;

	private boolean selectFop = false;

	private String isAllowedOtherPnr = "false";

	private String over1000Lines = "";

	private String pnrCount;



	public String getPnrCount() {

		return pnrCount;

	}



	public void setPnrCount(String pnrCount) {

		this.pnrCount = pnrCount;

	}



	public String getOver1000Lines() {

		return over1000Lines;

	}



	public void setOver1000Lines(String over1000Lines) {

		this.over1000Lines = over1000Lines;

	}



	/**

	 * @return

	 */

	public String getCreditCardNumber() {

		return creditCardNumber;

	}



	/**

	 * @return

	 */

	public String getFrequentFlyerNumber() {

		return frequentFlyerNumber;

	}



	/**

	 * @return

	 */

	public String getPnrLocator() {

		return pnrLocator;

	}



	/**

	 * @return

	 */

	public String getTicketNumber() {

		return ticketNumber;

	}



	/**

	 * @param string

	 */

	public void setCreditCardNumber(String string) {

		creditCardNumber = string;

	}



	/**

	 * @param string

	 */

	public void setFrequentFlyerNumber(String string) {

		frequentFlyerNumber = string;

	}



	/**

	 * @param string

	 */

	public void setPnrLocator(String string) {

		pnrLocator = string;

	}



	/**

	 * @param string

	 */

	public void setTicketNumber(String string) {

		ticketNumber = string;

	}



	/**

	 * @return

	 */

	public String getEmployeeNumber() {

		return employeeNumber;

	}



	/**

	 * @param string

	 */

	public void setEmployeeNumber(String string) {

		employeeNumber = string;

	}



	/**

	 * @return

	 */

	public ArrayList getPnrList() {

		return pnrList;

	}



	/**

	 * @param list

	 */

	public void setPnrList(ArrayList list) {

		pnrList = list;

	}



	/**

	 * @return

	 */

	public String getPnrDetail() {

		return pnrDetail;

	}



	/**

	 * @param string

	 */

	public void setPnrDetail(String string) {

		pnrDetail = string;

	}



	/**

	 * @return

	 */

	public String getUserAuthorizedCC() {

		return userAuthorizedCC;

	}



	/**

	 * @param string

	 */

	public void setUserAuthorizedCC(String string) {

		userAuthorizedCC = string;

	}



	/**

	 * @return

	 */

	public ArrayList getPnrTextList() {

		return pnrTextList;

	}



	/**

	 * @param list

	 */

	public void setPnrTextList(ArrayList list) {

		pnrTextList = list;

	}



	/**

	 * @return

	 */

	public String getSelPnrCrtnDate() {

		return selPnrCrtnDate;

	}



	/**

	 * @return

	 */

	public String getSelPnrLoctrNum() {

		return selPnrLoctrNum;

	}



	/**

	 * @param string

	 */

	public void setSelPnrCrtnDate(String string) {

		selPnrCrtnDate = string;

	}



	/**

	 * @param string

	 */

	public void setSelPnrLoctrNum(String string) {

		selPnrLoctrNum = string;

	}



	/**

	 * @return

	 */

	public String getCrtnDate() {

		return crtnDate;

	}



	/**

	 * @return

	 */

	public String getFltNum() {

		return fltNum;

	}



	/**

	 * @return

	 */

	public String getInvClCode() {

		return invClCode;

	}



	/**

	 * @return

	 */

	public String getLoctrNum() {

		return loctrNum;

	}



	/**

	 * @return

	 */

	public String getMkAlCode() {

		return mkAlCode;

	}



	/**

	 * @return

	 */

	public String getPsngrNme() {

		return psngrNme;

	}



	/**

	 * @return

	 */

	public String getSegDestApCode() {

		return segDestApCode;

	}



	/**

	 * @return

	 */

	public String getSegOrigApCode() {

		return segOrigApCode;

	}



	/**

	 * @return

	 */

	public String getSegStatusCode() {

		return segStatusCode;

	}



	/**

	 * @param string

	 */

	public void setCrtnDate(String string) {

		crtnDate = string;

	}



	/**

	 * @param string

	 */

	public void setFltNum(String string) {

		fltNum = string;

	}



	/**

	 * @param string

	 */

	public void setInvClCode(String string) {

		invClCode = string;

	}



	/**

	 * @param string

	 */

	public void setLoctrNum(String string) {

		loctrNum = string;

	}



	/**

	 * @param string

	 */

	public void setMkAlCode(String string) {

		mkAlCode = string;

	}



	/**

	 * @param string

	 */

	public void setPsngrNme(String string) {

		psngrNme = string;

	}



	/**

	 * @param string

	 */

	public void setSegDestApCode(String string) {

		segDestApCode = string;

	}



	/**

	 * @param string

	 */

	public void setSegOrigApCode(String string) {

		segOrigApCode = string;

	}



	/**

	 * @param string

	 */

	public void setSegStatusCode(String string) {

		segStatusCode = string;

	}



	/**

	 * @return

	 */

	public String getTravelDateSort() {

		return travelDateSort;

	}



	/**

	 * @param string

	 */

	public void setTravelDateSort(String string) {

		travelDateSort = string;

	}



	/**

	 * @return

	 */

	public boolean isShowRedisplay() {

		return showRedisplay;

	}



	/**

	 * @param b

	 */

	public void setShowRedisplay(boolean b) {

		showRedisplay = b;

	}



	/**

	 * @return

	 */

	public String getSelPassenger() {

		return selPassenger;

	}



	/**

	 * @param string

	 */

	public void setSelPassenger(String string) {

		selPassenger = string;

	}



	/**

	 * @return

	 */

	public String getSelFlightNumber() {

		return selFlightNumber;

	}



	/**

	 * @param string

	 */

	public void setSelFlightNumber(String string) {

		selFlightNumber = string;

	}



	/**

	 * @return

	 */

	public String getUserName() {

		return userName;

	}



	/**

	 * @param string

	 */

	public void setUserName(String string) {

		userName = string;

	}



	/**

	 * @return

	 */

	public ArrayList getFopList() {

		return fopList;

	}



	/**

	 * @param list

	 */

	public void setFopList(ArrayList list) {

		fopList = list;

	}



	/**

	 * @return

	 */

	public boolean isSelectFop() {

		return selectFop;

	}



	/**

	 * @param b

	 */

	public void setSelectFop(boolean b) {

		selectFop = b;

	}



	/**

	 * @return

	 */

	public String getIsAllowedOtherPnr() {

		return isAllowedOtherPnr;

	}



	/**

	 * @param string

	 */

	public void setIsAllowedOtherPnr(String string) {

		isAllowedOtherPnr = string;

	}

	

	

	

	/* (non-Javadoc)

	 * @see org.apache.struts.validator.ValidatorForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)

	 */

	@Override

	public ActionErrors validate(ActionMapping mapping,

			HttpServletRequest request) {

		

		ActionErrors actionErrors = new ActionErrors();

		

		if((creditCardNumber == null || creditCardNumber.trim().length()<=0) &&

			(employeeNumber == null || employeeNumber.trim().length() <= 0) &&

			(frequentFlyerNumber == null || frequentFlyerNumber.trim().length() <=0) &&

			(pnrLocator == null || pnrLocator.trim().length() <=0) &&

			(ticketNumber == null || ticketNumber.trim().length() <=0)){

			

				actionErrors.add("name", new ActionError("error.other.query.fields"));

			}

		

		return actionErrors;

	}



	public Timestamp getSelTimeStamp() {
		return selTimeStamp;
	}



	public void setSelTimeStamp(Timestamp selTimeStamp) {
		this.selTimeStamp = selTimeStamp;
	}

}

