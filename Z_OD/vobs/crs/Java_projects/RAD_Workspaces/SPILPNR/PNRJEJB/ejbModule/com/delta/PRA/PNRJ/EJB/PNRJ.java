package com.delta.PRA.PNRJ.EJB;



import java.util.ArrayList;

import com.nwa.PRA.CustExceptions.DBException;

/**

 * Remote interface for Enterprise Bean: PNRJ

 */

public interface PNRJ extends javax.ejb.EJBObject {

	

	public ArrayList call_name_lookup(String surName, String travelDate, String flightNum, String alCode, String origin, String dest)

		throws DBException, java.rmi.RemoteException;

	public ArrayList call_name_lookup_range(String surName, String travelDate, String flightNum, String alCode, String origin, String dest)

	throws DBException, java.rmi.RemoteException;

	//	//////////// PNR Lookup Stored Procedures ******** ///////////////////////

	public ArrayList call_airline_flightnum_lookup(

		String airLine,

		String flightNum,

		String travelDate,

		String surName, 

		String origin, 

		String dest)

		throws DBException, java.rmi.RemoteException;

	public ArrayList call_cc_lookup(String userId, String ccCode, String ccNum)

		throws DBException, java.rmi.RemoteException;

	public ArrayList call_cc_lookup(String ccCode,String tokenizedCreditCard)

	throws DBException, java.rmi.RemoteException;

	

	public ArrayList call_employee_lookup(String empNum)

		throws DBException, java.rmi.RemoteException;

	public ArrayList call_freqflier_lookup(

		String frqflierid,

		String freqfliernum)

		throws DBException, java.rmi.RemoteException;

	public ArrayList call_tkt_lookup(String tktnum)

		throws DBException, java.rmi.RemoteException;

	////////////// PNR Lookup Stored Procedures ******** ///////////////////////		

	public ArrayList call_origdest_lookup(

		String origin,

		String destination,

		String travelDate,

		String surName, 

		String alCode, 

		String flightNum)

		throws DBException, java.rmi.RemoteException;

	public String retrievePnrCrtnYearMo(String pnrCrtnDte) 

		throws DBException, java.rmi.RemoteException;	

	public ArrayList call_pnr_lookup(String pnrLoctr)

		throws DBException, java.rmi.RemoteException;

	public ArrayList call_pnrDetail_lookup(

		String pnrLocator,

		String pnrCrtnDte)

		throws DBException, java.rmi.RemoteException;

	////////////// PNR Lookup Stored Procedures ******** ///////////////////////

	public String call_pnrText_lookup(String pnrLoctr, String pnrCrtnDte)

		throws DBException, java.rmi.RemoteException;



	public ArrayList call_default_lookup_detail(ArrayList pnrList) 

		throws DBException, java.rmi.RemoteException;


	public ArrayList call_fop_lookup(String userId, String pnrLoctrNum) 

		throws DBException, java.rmi.RemoteException;
	
//////////////On demand begin
/*	
	public ArrayList on_demand_call_employee_lookup(String empNum)

			throws DBException, java.rmi.RemoteException;
	
	public ArrayList on_demand_call_freqflier_lookup(

			String frqflierid,

			String freqfliernum)

			throws DBException, java.rmi.RemoteException;
	
	public ArrayList on_demand_call_tkt_lookup(String tktnum)

			throws DBException, java.rmi.RemoteException;
	
	public ArrayList on_demand_call_fop_lookup(String userId, String pnrLoctrNum) 

			throws DBException, java.rmi.RemoteException;

	public ArrayList on_demand_call_pnr_lookup(String pnrLoctr)
		
		throws DBException, java.rmi.RemoteException;

	
	public String on_demand_call_pnrText_lookup(String pnrLoctr, String pnrCrtnDte)

			throws DBException, java.rmi.RemoteException;
	
	public ArrayList on_demand_call_pnrDetail_lookup(

			String pnrLocator,

			String pnrCrtnDte)

			throws DBException, java.rmi.RemoteException;

	public ArrayList on_demand_call_default_lookup_detail(ArrayList pnrList) 

			throws DBException, java.rmi.RemoteException;



	public ArrayList on_demand_call_cc_lookup(String userId, String ccCode, String ccNum)

			throws DBException, java.rmi.RemoteException;

		public ArrayList on_demand_call_cc_lookup(String ccCode,String tokenizedCreditCard)

		throws DBException, java.rmi.RemoteException;

*/		
		// end

}

