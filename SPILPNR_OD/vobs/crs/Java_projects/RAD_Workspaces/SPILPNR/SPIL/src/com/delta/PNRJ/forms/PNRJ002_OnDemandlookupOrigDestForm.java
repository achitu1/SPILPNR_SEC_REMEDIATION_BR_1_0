package com.delta.PNRJ.forms;



import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.struts.validator.ValidatorForm;



/**

 * Form bean for a Struts application.

 * @version 	1.0

 * @author

 */



public class PNRJ002_OnDemandlookupOrigDestForm extends ValidatorForm {



	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private Timestamp timeStamp = null;

	private Timestamp selTimeStamp = null;

	
	private String origin = null;

	private String destination = null;

	private String travelDate = null;

	private String passengerName = null;

	private String airlineCode = null;

	private String flightNumber = null;	

	private ArrayList pnrList = null;

	private String pnrDetail = null;

	private ArrayList pnrTextList = null;

	//private String pnrTextList = null;

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



	private boolean showRedisplay = false;



	/**

	 * @return

	 */

	public String getAirlineCode() {

		return airlineCode;

	}



	/**

	 * @return

	 */

	public String getDestination() {

		return destination;

	}



	/**

	 * @return

	 */

	public String getFlightNumber() {

		return flightNumber;

	}



	/**

	 * @return

	 */

	public String getOrigin() {

		return origin;

	}



	/**

	 * @return

	 */

	public String getPassengerName() {

		return passengerName;

	}



	/**

	 * @return

	 */

	public String getTravelDate() {

		return travelDate;

	}



	/**

	 * @param string

	 */

	public void setAirlineCode(String string) {

		airlineCode = string;

	}



	/**

	 * @param string

	 */

	public void setDestination(String string) {

		destination = string;

	}



	/**

	 * @param string

	 */

	public void setFlightNumber(String string) {

		flightNumber = string;

	}



	/**

	 * @param string

	 */

	public void setOrigin(String string) {

		origin = string;

	}



	/**

	 * @param string

	 */

	public void setPassengerName(String string) {

		passengerName = string;

	}



	/**

	 * @param date

	 */

	public void setTravelDate(String date) {

		travelDate = date;

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

	 * @return

	 */

	public String getTravelDateSort() {

		return travelDateSort;

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



	public Timestamp getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}



	public Timestamp getSelTimeStamp() {
		return selTimeStamp;
	}



	public void setSelTimeStamp(Timestamp selTimeStamp) {
		this.selTimeStamp = selTimeStamp;
	}



}

	