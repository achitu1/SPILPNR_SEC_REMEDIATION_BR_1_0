
package com.delta.PRA.SPLJ.data;



import java.io.Serializable;



/**

 * @author jra

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJDataOD implements Serializable {

	public String timestamp;	// added for OD
	
	public String flightNumber;	   

	public String localDepartureDate;	   

	public String passengerName;	   

	public String seatAssignment;	   

	public String pnrLocator;	   

	public String ticketNumber;	   

	public String frequentFlierAirline;	   

	public String frequentFlierId;	   

	public String frequentFlierTier;	 



	public String airlineCode;

	public String legOrigApCode;

	public String class1;

	public String bookedClass;

	public String flownClass;

	public String type;



	//Ajeet Added new fields

	public String customerID;

	public String pnrCreateDate;

	public String ticketIssueDate;

	public String checkinDate;

	public String checkinTime;

	public String onBoardDate;

	public String onBoardTime;

	private String cnclInd;

			

	public String seqNum;



	public String waitlistAirlineCode;

	public String waitlistFlightNumber;	   

	public String waitlistLocalDepartureDate;

	public String waitlistPNRLocator;

	public String waitlistSequence;	   

	public String waitlistName;	   

	public String waitlistV;	   

	public String waitlistB;	   

	public String waitlistR;	   

	public String waitlistOrigin;

	public String waitlistDestination;	   

	public String waitlistService;

	public String waitlistBookedClass;

	public String waitlistFlownClass;

	public String waitlistPTY;	   

	public String waitlistType;	   

	public String waitlistCLS;	   

	public String waitlistSeniority;	   

	public String waitlistTime;	 



	/**

	 * @return

	 */

	public String getFlightNumber() {

		return flightNumber;

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

	 * @return

	 */

	public String getSeatAssignment() {

		return seatAssignment;

	}



	/**

	 * @return

	 */

	public String getTicketNumber() {

		return ticketNumber;

	}



	/**

	 * @return

	 */

	public String getWaitlistB() {

		return waitlistB;

	}



	/**

	 * @return

	 */

	public String getWaitlistCLS() {

		return waitlistCLS;

	}



	/**

	 * @return

	 */

	public String getWaitlistDestination() {

		return waitlistDestination;

	}



	/**

	 * @return

	 */

	public String getWaitlistFlightNumber() {

		return waitlistFlightNumber;

	}



	/**

	 * @return

	 */

	public String getWaitlistLocalDepartureDate() {

		return waitlistLocalDepartureDate;

	}



	/**

	 * @return

	 */

	public String getWaitlistName() {

		return waitlistName;

	}



	/**

	 * @return

	 */

	public String getWaitlistPNRLocator() {

		return waitlistPNRLocator;

	}



	/**

	 * @return

	 */

	public String getWaitlistPTY() {

		return waitlistPTY;

	}



	/**

	 * @return

	 */

	public String getWaitlistR() {

		return waitlistR;

	}



	/**

	 * @return

	 */

	public String getWaitlistSeniority() {

		return waitlistSeniority;

	}



	/**

	 * @return

	 */

	public String getWaitlistSequence() {

		return waitlistSequence;

	}



	/**

	 * @return

	 */

	public String getWaitlistService() {

		return waitlistService;

	}



	/**

	 * @return

	 */

	public String getWaitlistTime() {

		return waitlistTime;

	}



	/**

	 * @return

	 */

	public String getWaitlistType() {

		return waitlistType;

	}



	/**

	 * @return

	 */

	public String getWaitlistV() {

		return waitlistV;

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

	 * @param string

	 */

	public void setSeatAssignment(String string) {

		seatAssignment = string;

	}



	/**

	 * @param string

	 */

	public void setTicketNumber(String string) {

		ticketNumber = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistB(String string) {

		waitlistB = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistCLS(String string) {

		waitlistCLS = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistDestination(String string) {

		waitlistDestination = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistFlightNumber(String string) {

		waitlistFlightNumber = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistLocalDepartureDate(String string) {

		waitlistLocalDepartureDate = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistName(String string) {

		waitlistName = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistPNRLocator(String string) {

		waitlistPNRLocator = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistPTY(String string) {

		waitlistPTY = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistR(String string) {

		waitlistR = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistSeniority(String string) {

		waitlistSeniority = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistSequence(String string) {

		waitlistSequence = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistService(String string) {

		waitlistService = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistTime(String string) {

		waitlistTime = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistType(String string) {

		waitlistType = string;

	}



	/**

	 * @param string

	 */

	public void setWaitlistV(String string) {

		waitlistV = string;

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

	public void setSeqNum(String string) {

		seqNum = string;

	}



	/**

	 * @return

	 */

	public String getLegOrigApCode() {

		return legOrigApCode;

	}



	/**

	 * @param string

	 */

	public void setLegOrigApCode(String string) {

		legOrigApCode = string;

	}



	/**

	 * @return

	 */

	public String getAirlineCode() {

		return airlineCode;

	}



	/**

	 * @param string

	 */

	public void setAirlineCode(String string) {

		airlineCode = string;

	}



	/**

	 * @return

	 */

	public String getWaitlistAirlineCode() {

		return waitlistAirlineCode;

	}



	/**

	 * @param string

	 */

	public void setWaitlistAirlineCode(String string) {

		waitlistAirlineCode = string;

	}



	/**

	 * @return

	 */

	public String getWaitlistOrigin() {

		return waitlistOrigin;

	}



	/**

	 * @param string

	 */

	public void setWaitlistOrigin(String string) {

		waitlistOrigin = string;

	}



	/**

	 * @return

	 */

	public String getClass1() {

		return class1;

	}



	/**

	 * @param string

	 */

	public void setClass1(String string) {

		class1 = string;

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



	public String getWaitlistBookedClass() {

		return waitlistBookedClass;

	}



	public void setWaitlistBookedClass(String waitlistBookedClass) {

		this.waitlistBookedClass = waitlistBookedClass;

	}



	public String getWaitlistFlownClass() {

		return waitlistFlownClass;

	}



	public void setWaitlistFlownClass(String waitlistFlownClass) {

		this.waitlistFlownClass = waitlistFlownClass;

	}



	public String getCnclInd() {

		return cnclInd;

	}



	public void setCnclInd(String cnclInd) {

		this.cnclInd = cnclInd;

	}

	

}

