/*

 * Created on Dec 12, 2005

 *

 * To change the template for this generated file go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

package com.delta.SPLJ.forms;



import java.sql.Timestamp;
import java.util.ArrayList;



import org.apache.struts.validator.ValidatorForm;



/**

 * @author jra

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJ001_OnDemandSsrInquiryForm extends ValidatorForm {
	private String timeStampString;
	private String seltimeStampString;
	private Timestamp timeStamp = null;

	private String airlineCode;

	private String flightNumber;

	private String localDepartureDate;

	private String ssrCode = "";

	

	private ArrayList selectList;

	private String legOrigApCode;

	private String seqNum;

	private String selLegOrigApCode;

	private String selSeqNum;	

	private String selRowSeat;	

	private String selPassenger;	

	private String rowSelected;	

	private String selPnr;

	

	// selected record 

	private String flightNum;

	private String depDate;

	private String boardPoint;

	private String offPoint;

	private String pnr;

	private String class1;

	private String type;

	private String conFrom1;

	private String conFrom2;

	private String conTo1;

	private String conTo2;

	private String ssr;

	private ArrayList remList;

	private String flagList;

	private String download;

	private String departureAirport;

	private String destinationAirport;

	private String ticketNumber;

	private String frequentFlierAirline;

	private String frequentFlierId;

	private String frequentFlierTier;

	private String pnrCount;

	//Ajeet Added new fields on 12/09/2011

	private String bookedClass;

	private String flownClass;

	private String customerID;

	private String pnrCreateDate;

	private String ticketIssueDate;

	private String checkinDate;

	private String checkinTime;

	private String onBoardDate;

	private String onBoardTime;

	private String cnclInd;

	

	public String getPnrCount() {

		return pnrCount;

	}



	public void setPnrCount(String pnrCount) {

		this.pnrCount = pnrCount;

	}



	/**

	 * @return

	 */

	public String getAirlineCode() {

		return airlineCode;

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

	public String getLocalDepartureDate() {

		return localDepartureDate;

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

	public void setFlightNumber(String string) {

		flightNumber = string;

	}



	/**

	 * @param string

	 */

	public void setLocalDepartureDate(String string) {

		localDepartureDate = string;

	}



	/**

	 * @return

	 */

	public ArrayList getSelectList() {

		return selectList;

	}



	/**

	 * @param list

	 */

	public void setSelectList(ArrayList list) {

		selectList = list;

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

	public String getSsr() {

		return ssr;

	}



	/**

	 * @return

	 */

	public String getType() {

		return type;

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

	public void setSsr(String string) {

		ssr = string;

	}



	/**

	 * @param string

	 */

	public void setType(String string) {

		type = string;

	}



	/**

	 * @return

	 */

	public String getLegOrigApCode() {

		return legOrigApCode;

	}



	/**

	 * @return

	 */

	public String getSeqNum() {

		return seqNum;

	}



	/**

	 * @param string

	 */

	public void setLegOrigApCode(String string) {

		legOrigApCode = string;

	}



	/**

	 * @param string

	 */

	public void setSeqNum(String string) {

		seqNum = string;

	}



	/**

	 * @return

	 */

	public String getSelLegOrigApCode() {

		return selLegOrigApCode;

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

	public void setSelLegOrigApCode(String string) {

		selLegOrigApCode = string;

	}



	/**

	 * @param string

	 */

	public void setSelSeqNum(String string) {

		selSeqNum = string;

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

	public void setSelRowSeat(String string) {

		selRowSeat = string;

	}



	/**

	 * @return

	 */

	public String getRowSelected() {

		return rowSelected;

	}



	/**

	 * @param string

	 */

	public void setRowSelected(String string) {

		rowSelected = string;

	}



	/**

	 * @return

	 */

	public ArrayList getRemList() {

		return remList;

	}



	/**

	 * @param list

	 */

	public void setRemList(ArrayList list) {

		remList = list;

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

	public String getFlagList() {

		return flagList;

	}



	/**

	 * @param string

	 */

	public void setFlagList(String string) {

		flagList = string;

	}



	/**

	 * @return

	 */

	public String getDownload() {

		return download;

	}



	/**

	 * @param string

	 */

	public void setDownload(String string) {

		download = string;

	}



	/**

	 * @return

	 */

	public String getDepartureAirport() {

		return departureAirport;

	}



	/**

	 * @return

	 */

	public String getDestinationAirport() {

		return destinationAirport;

	}



	/**

	 * @param string

	 */

	public void setDepartureAirport(String string) {

		departureAirport = string;

	}



	/**

	 * @param string

	 */

	public void setDestinationAirport(String string) {

		destinationAirport = string;

	}



	/**

	 * @return

	 */

	public String getFrequentFlierAirline() {

		return frequentFlierAirline;

	}



	/**

	 * @return

	 */

	public String getFrequentFlierId() {

		return frequentFlierId;

	}



	/**

	 * @return

	 */

	public String getFrequentFlierTier() {

		return frequentFlierTier;

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

	public void setFrequentFlierAirline(String string) {

		frequentFlierAirline = string;

	}



	/**

	 * @param string

	 */

	public void setFrequentFlierId(String string) {

		frequentFlierId = string;

	}



	/**

	 * @param string

	 */

	public void setFrequentFlierTier(String string) {

		frequentFlierTier = string;

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

	public String getSsrCode() {

		return ssrCode;

	}



	/**

	 * @param string

	 */

	public void setSsrCode(String string) {

		ssrCode = string;

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



	public String getCnclInd() {

		return cnclInd;

	}



	public void setCnclInd(String cnclInd) {

		this.cnclInd = cnclInd;

	}



	public String getSelPnr() {

		return selPnr;

	}



	public void setSelPnr(String selPnr) {

		this.selPnr = selPnr;

	}



	public Timestamp getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}



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



}

