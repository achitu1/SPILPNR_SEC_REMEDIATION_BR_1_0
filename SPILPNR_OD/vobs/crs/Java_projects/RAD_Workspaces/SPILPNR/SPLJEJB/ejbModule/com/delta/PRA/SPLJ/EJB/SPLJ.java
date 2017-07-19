package com.delta.PRA.SPLJ.EJB;

import java.rmi.RemoteException;
import java.sql.Timestamp;

import java.util.ArrayList;

import com.delta.PRA.SPLJ.data.PairValue;

import com.delta.PRA.SPLJ.data.SPLData;

import com.delta.PRA.SPLJ.data.SPLSelectedData;
import com.ibm.ws.http.HttpException;

import com.nwa.PRA.CustExceptions.DBException;

/**
 * 
 * Remote interface for Enterprise Bean: SPLJ
 */

public interface SPLJ extends javax.ejb.EJBObject {

	public String getTestMessage() throws java.rmi.RemoteException;

	// public boolean checkAuthorizationForApp(String groups, String app)

	// throws DBException,java.rmi.RemoteException;

	// On demand changes begin

	public ArrayList<SPLData> call_waitlist_inquiry_lookup_OD(

	String airlineCode,

	String flightNumber,

	String localDepartureDate,

	String passengerName,

	String pnrLocator,

	Timestamp timeStamp)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLData> call_other_inquiry_lookup_OD(

	String ticketNumber,

	String pnrLocator,

	String governmentId)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLSelectedData> call_selected_record_lookup_waitlist_OD(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String passengerName,

	String pnrLocator,

	Timestamp timeStamp)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLData> call_frequent_flier_inquiry_lookup_OD(

	String airlineCode,

	String programId)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLData> call_passenger_inquiry_lookup_OD(

	String passengerName,

	String localDepartureDate)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLSelectedData> call_selected_record_remarks_lookup_OD(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String legOrigApCode,

	String seqNum,

	String rowSeat,

	String pnrNum,

	Timestamp timestamp)

	throws DBException, java.rmi.RemoteException;

	// public ArrayList<SPLData> call_on_Demand_Request(

	public ArrayList<SPLSelectedData> call_selected_record_lookup_OD(
			String localDepartureDate,

			String airlineCode,

			String flightNumber,

			String legOrigApCode,

			String seqNum,

			String rowSeat,

			String pnrNum,
			// on demand begin
			java.sql.Timestamp timeStamp) throws DBException,
			java.rmi.RemoteException;

	// on demand end
	public boolean call_on_Demand_Request(

	String email,

	String flightNumber,

	String localDepartureDate,

	String legOrigApCode)

	throws HttpException, java.rmi.RemoteException;

	public ArrayList<SPLData> call_flight_inquiry_lookup_OD(

	String airlineCode,

	String flightNumber,

	String localDepartureDate,

	String depApt,

	String desApt)

	throws DBException, java.rmi.RemoteException;

	// On demand changes end

	public ArrayList<SPLData> call_flight_inquiry_lookup(

	String airlineCode,

	String flightNumber,

	String localDepartureDate,

	String depApt,

	String desApt)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLData> call_passenger_inquiry_lookup(

	String passengerName,

	String localDepartureDate)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLData> call_frequent_flier_inquiry_lookup(

	String airlineCode,

	String programId)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLData> call_other_inquiry_lookup(

	String ticketNumber,

	String pnrLocator,

	String governmentId)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLData> call_waitlist_inquiry_lookup(

	String airlineCode,

	String flightNumber,

	String localDepartureDate,

	String passengerName,

	String pnrLocator)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLSelectedData> call_selected_record_lookup(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String legOrigApCode,

	String seqNum,

	String rowSeat,

	String pnrNum)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLSelectedData> call_selected_record_remarks_lookup(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String legOrigApCode,

	String seqNum,

	String rowSeat,

	String pnrNum)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLSelectedData> call_selected_record_lookup_waitlist(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String passengerName,

	String pnrLocator)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLData> call_passenger_lookup_waitlist(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String pnrLocator)

	throws DBException, java.rmi.RemoteException;

	// queries j - p (for help codes). glee added.

	public ArrayList<SPLData> call_query_i(String pnr) throws DBException,
			RemoteException;

	public ArrayList<PairValue> call_query_j() throws DBException,
			RemoteException;

	public ArrayList<PairValue> call_query_k() throws DBException,
			RemoteException;

	public ArrayList<PairValue> call_query_l() throws DBException,
			RemoteException;

	public ArrayList<PairValue> call_query_m() throws DBException,
			RemoteException;

	public ArrayList<PairValue> call_query_n() throws DBException,
			RemoteException;

	public ArrayList<PairValue> call_query_o() throws DBException,
			RemoteException;

	public ArrayList<PairValue> call_query_p() throws DBException,
			RemoteException;

	/**
	 * 
	 * @param localDepartureDate
	 * 
	 * @param airlineCode
	 * 
	 * @param flightNumber
	 * 
	 * @return
	 */

	public ArrayList<SPLSelectedData> call_ssr_inquiry_lookup(
			String localDepartureDate, String airlineCode, String flightNumber,

			String ssrCodet) throws DBException, RemoteException;

	public ArrayList<SPLData> call_passenger_lookup_waitlist_OD(

	String localDepartureDate,

	String airlineCode,

	String flightNumber,

	String pnrLocator,

	Timestamp timeStamp)

	throws DBException, java.rmi.RemoteException;

	public ArrayList<SPLSelectedData>  call_ssr_inquiry_lookup_OD(String localDepartureDate,
			String airlineCode, String flightNumber, String ssrCode)throws DBException, RemoteException;
}
