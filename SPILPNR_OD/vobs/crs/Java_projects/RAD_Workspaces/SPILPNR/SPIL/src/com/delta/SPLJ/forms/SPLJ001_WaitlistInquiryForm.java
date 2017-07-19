/*
 * Created on Dec 12, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.SPLJ.forms;

import java.util.ArrayList;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author jra
 * 
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SPLJ001_WaitlistInquiryForm extends ValidatorForm {
	private String airlineCode = null;
	private String flightNumber = null;
	private String localDepartureDate = null;
	private String passengerName = null;
	private String pnrLocator = null;
	private ArrayList selectList = null;

	private String selRowSeat;
	private String selPassenger;
	private String selAirlineCode;
	private String selFlightNumber;
	private String selDepartureDate;
	private String selPnr;
	private String selWaitlistNum;
	private String rowSelected;

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
	private String flagLookup;
	private ArrayList passengerList = null;

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

	/**
	 * @return
	 */
	public String getAirlineCode() {
		return airlineCode;
	}

	public String getPnrCount() {
		return pnrCount;
	}

	public void setPnrCount(String pnrCount) {
		this.pnrCount = pnrCount;
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
	 * @return
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * @return
	 */
	public String getPnrLocator() {
		return pnrLocator;
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
	 * @param string
	 */
	public void setPassengerName(String string) {
		passengerName = string;
	}

	/**
	 * @param string
	 */
	public void setPnrLocator(String string) {
		pnrLocator = string;
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
	public ArrayList getRemList() {
		return remList;
	}

	/**
	 * @return
	 */
	public String getRowSelected() {
		return rowSelected;
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
	public String getSelPnr() {
		return selPnr;
	}

	/**
	 * @return
	 */
	public String getSelRowSeat() {
		return selRowSeat;
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
	 * @param list
	 */
	public void setRemList(ArrayList list) {
		remList = list;
	}

	/**
	 * @param string
	 */
	public void setRowSelected(String string) {
		rowSelected = string;
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
	public void setSelPnr(String string) {
		selPnr = string;
	}

	/**
	 * @param string
	 */
	public void setSelRowSeat(String string) {
		selRowSeat = string;
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
	public String getSelAirlineCode() {
		return selAirlineCode;
	}

	/**
	 * @param string
	 */
	public void setSelAirlineCode(String string) {
		selAirlineCode = string;
	}

	/**
	 * @return
	 */
	public String getSelDepartureDate() {
		return selDepartureDate;
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
	public void setSelDepartureDate(String string) {
		selDepartureDate = string;
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
	public String getFlagLookup() {
		return flagLookup;
	}

	/**
	 * @param string
	 */
	public void setFlagLookup(String string) {
		flagLookup = string;
	}

	/**
	 * @return
	 */
	public ArrayList getPassengerList() {
		return passengerList;
	}

	/**
	 * @param list
	 */
	public void setPassengerList(ArrayList list) {
		passengerList = list;
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
	public String getSelWaitlistNum() {
		return selWaitlistNum;
	}

	/**
	 * @param string
	 */
	public void setSelWaitlistNum(String string) {
		selWaitlistNum = string;
	}

	/**
	 * @return the ticketNumber
	 */
	public String getTicketNumber() {
		return ticketNumber;
	}

	/**
	 * @param ticketNumber
	 *            the ticketNumber to set
	 */
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	/**
	 * @return the frequentFlierAirline
	 */
	public String getFrequentFlierAirline() {
		return frequentFlierAirline;
	}

	/**
	 * @param frequentFlierAirline
	 *            the frequentFlierAirline to set
	 */
	public void setFrequentFlierAirline(String frequentFlierAirline) {
		this.frequentFlierAirline = frequentFlierAirline;
	}

	/**
	 * @return the frequentFlierId
	 */
	public String getFrequentFlierId() {
		return frequentFlierId;
	}

	/**
	 * @param frequentFlierId
	 *            the frequentFlierId to set
	 */
	public void setFrequentFlierId(String frequentFlierId) {
		this.frequentFlierId = frequentFlierId;
	}

	/**
	 * @return the frequentFlierTier
	 */
	public String getFrequentFlierTier() {
		return frequentFlierTier;
	}

	/**
	 * @param frequentFlierTier
	 *            the frequentFlierTier to set
	 */
	public void setFrequentFlierTier(String frequentFlierTier) {
		this.frequentFlierTier = frequentFlierTier;
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

}
