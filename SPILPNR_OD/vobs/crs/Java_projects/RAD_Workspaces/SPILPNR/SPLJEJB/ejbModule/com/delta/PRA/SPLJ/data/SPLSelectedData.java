/*

 * Created on Dec 13, 2005

 *

 * To change the template for this generated file go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

package com.delta.PRA.SPLJ.data;



import java.io.Serializable;
import java.sql.Timestamp;



/**

 * @author jra

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLSelectedData extends SPLData implements Serializable {	

	public Timestamp timeStamp; // od addition 8/17/2016

	public Timestamp selTimeStamp; // od addition 8/17/2016

	public String timeStampString; // od addition 1/3/2017
	public String seltimeStampString;



	public String flightNum;	   

	public String depDate;	   

	public String boardPoint;	   

	public String offPoint;	   

	public String pnr;	   

	public String class1;

	public String bookedClass;

	public String flownClass;

	public String type;	   

	public String conFrom1;	   

	public String conFrom2;	 

	public String conTo1;	   

	public String conTo2;

	public String ssrCde;

	public String remarks1;

	public String remarks2;

	public String remarks3;

	public String selRowSeat;

	public String selLegstat;

	public String selPassenger;

	public String selPnr;

	public String selLegOrigApCode;

	public String selSeqNum;

	

	//Ajeet Added new fields

	public String customerID;

	public String pnrCreateDate;

	public String ticketIssueDate;

	public String checkinDate;

	public String checkinTime;

	public String onBoardDate;

	public String onBoardTime;

	private String cnclInd;

		

	/**

	 * @return

	 */
	//begin od change 08/17/2016
	public String getSeltimeStampString() {
		return seltimeStampString;
	}



	public void setSeltimeStampString(String seltimeStampString) {
		this.seltimeStampString = seltimeStampString;
	}



	public String getTimeStampString() {
		return timeStampString;
	}



	public void setTimeStampString(String timeStampString) {
		this.timeStampString = timeStampString;
	}



	public Timestamp getSelTimeStamp() {
		return selTimeStamp;
	}



	public void setSelTimeStamp(Timestamp selTimeStamp) {
		this.selTimeStamp = selTimeStamp;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
//end od change 08/17/2016


	public String getRemarks1() {

		return remarks1;

	}



	/**

	 * @param string

	 */

	public void setRemarks1(String string) {

		remarks1 = string;

	}



	/**

	 * @return

	 */

	public String getBoardPoint() {

		return boardPoint;

	}



	/**

	 * @return

	 */

	public String getClass1() {

		return class1;

	}



	/**

	 * @return

	 */

	public String getConFrom1() {

		return conFrom1;

	}



	/**

	 * @return

	 */

	public String getConFrom2() {

		return conFrom2;

	}



	/**

	 * @return

	 */

	public String getConTo1() {

		return conTo1;

	}



	/**

	 * @return

	 */

	public String getConTo2() {

		return conTo2;

	}



	/**

	 * @return

	 */

	public String getDepDate() {

		return depDate;

	}



	/**

	 * @return

	 */

	public String getFlightNum() {

		return flightNum;

	}



	/**

	 * @return

	 */

	public String getOffPoint() {

		return offPoint;

	}



	/**

	 * @return

	 */

	public String getPnr() {

		return pnr;

	}



	/**

	 * @return

	 */

	public String getRemarks2() {

		return remarks2;

	}



	/**

	 * @return

	 */

	public String getRemarks3() {

		return remarks3;

	}



	/**

	 * @return

	 */

	public String getSsrCde() {

		return ssrCde;

	}



	

	/**

	 * @param string

	 */

	public void setBoardPoint(String string) {

		boardPoint = string;

	}



	/**

	 * @param string

	 */

	public void setClass1(String string) {

		class1 = string;

	}



	/**

	 * @param string

	 */

	public void setConFrom1(String string) {

		conFrom1 = string;

	}



	/**

	 * @param string

	 */

	public void setConFrom2(String string) {

		conFrom2 = string;

	}



	/**

	 * @param string

	 */

	public void setConTo1(String string) {

		conTo1 = string;

	}



	/**

	 * @param string

	 */

	public void setConTo2(String string) {

		conTo2 = string;

	}



	/**

	 * @param string

	 */

	public void setDepDate(String string) {

		depDate = string;

	}



	/**

	 * @param string

	 */

	public void setFlightNum(String string) {

		flightNum = string;

	}



	/**

	 * @param string

	 */

	public void setOffPoint(String string) {

		offPoint = string;

	}



	/**

	 * @param string

	 */

	public void setPnr(String string) {

		pnr = string;

	}



	/**

	 * @param string

	 */

	public void setRemarks2(String string) {

		remarks2 = string;

	}



	/**

	 * @param string

	 */

	public void setRemarks3(String string) {

		remarks3 = string;

	}



	/**

	 * @param string

	 */

	public void setSsrCde(String string) {

		ssrCde = string;

	}



	/**

	 * @return

	 */

	public String getSelPassenger() {

		return selPassenger;

	}



	/**

	 * @return

	 */

	public String getSelRowSeat() {

		return selRowSeat;

	}



	/**

	 * @param string

	 */

	public void setSelPassenger(String string) {

		selPassenger = string;

	}



	/**

	 * @param string

	 */

	public void setSelRowSeat(String string) {

		selRowSeat = string;

	}



	/**

	 * @return

	 */

	public String getSelLegOrigApCode() {

		return selLegOrigApCode;

	}



	/**

	 * @param string

	 */

	public void setSelLegOrigApCode(String string) {

		selLegOrigApCode = string;

	}



	/**

	 * @return

	 */

	public String getSelSeqNum() {

		return selSeqNum;

	}



	/**

	 * @param string

	 */

	public void setSelSeqNum(String string) {

		selSeqNum = string;

	}



	public String getBookedClass() {

		return bookedClass;

	}



	public void setBookedClass(String bookedClass) {

		this.bookedClass = bookedClass;

	}



	public String getFlownClass() {

		return flownClass;

	}



	public void setFlownClass(String flownClass) {

		this.flownClass = flownClass;

	}



	public String getType() {

		return type;

	}



	public void setType(String type) {

		this.type = type;

	}



	public String getCustomerID() {

		return customerID;

	}



	public void setCustomerID(String customerID) {

		this.customerID = customerID;

	}



	public String getPnrCreateDate() {

		return pnrCreateDate;

	}



	public void setPnrCreateDate(String pnrCreateDate) {

		this.pnrCreateDate = pnrCreateDate;

	}



	public String getTicketIssueDate() {

		return ticketIssueDate;

	}



	public void setTicketIssueDate(String ticketIssueDate) {

		this.ticketIssueDate = ticketIssueDate;

	}



	public String getCheckinDate() {

		return checkinDate;

	}



	public void setCheckinDate(String checkinDate) {

		this.checkinDate = checkinDate;

	}



	public String getCheckinTime() {

		return checkinTime;

	}



	public void setCheckinTime(String checkinTime) {

		this.checkinTime = checkinTime;

	}



	public String getOnBoardDate() {

		return onBoardDate;

	}



	public void setOnBoardDate(String onBoardDate) {

		this.onBoardDate = onBoardDate;

	}



	public String getOnBoardTime() {

		return onBoardTime;

	}



	public void setOnBoardTime(String onBoardTime) {

		this.onBoardTime = onBoardTime;

	}



	public String getCnclInd() {

		return cnclInd;

	}



	public void setCnclInd(String cnclInd) {

		this.cnclInd = cnclInd;

	}



	public String getSelLegstat() {

		return selLegstat;

	}



	public void setSelLegstat(String selLegstat) {

		this.selLegstat = selLegstat;

	}



	public String getSelPnr() {

		return selPnr;

	}



	public void setSelPnr(String selPnr) {

		this.selPnr = selPnr;

	}

	

}

