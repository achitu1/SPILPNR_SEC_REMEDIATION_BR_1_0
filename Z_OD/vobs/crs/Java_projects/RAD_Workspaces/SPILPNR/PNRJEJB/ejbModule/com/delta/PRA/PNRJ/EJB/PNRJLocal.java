package com.delta.PRA.PNRJ.EJB;

import java.util.ArrayList;

import com.nwa.PRA.CustExceptions.DBException;

/**
 * Local interface for Enterprise Bean: PNRJ
 */
public interface PNRJLocal extends javax.ejb.EJBLocalObject {

	public ArrayList call_name_lookup(String surName, String travelDate,
			String flightNum, String alCode, String origin, String dest)
			throws DBException;
	public ArrayList call_name_lookup_range(String surName, String travelDate,
			String flightNum, String alCode, String origin, String dest)
			throws DBException;
	public ArrayList call_airline_flightnum_lookup(String airLine,
			String flightNum, String travelDate, String surName, String origin,
			String dest) throws DBException;

	public ArrayList call_cc_lookup(String userId, String ccCode, String ccNum)
			throws DBException;

	public ArrayList call_cc_lookup(String ccCode,String tokenizedCreditCard)
			throws DBException;

	public ArrayList call_employee_lookup(String empNum) throws DBException;

	public ArrayList call_freqflier_lookup(String frqflierid,
			String freqfliernum) throws DBException;

	public ArrayList call_tkt_lookup(String tktnum) throws DBException;

	public ArrayList call_origdest_lookup(String origin, String destination,
			String travelDate, String surName, String alCode, String flightNum)
			throws DBException;

	public String retrievePnrCrtnYearMo(String pnrCrtnDte) throws DBException;

	public ArrayList call_pnr_lookup(String pnrLoctr) throws DBException;

	public ArrayList call_pnrDetail_lookup(String pnrLocator, String pnrCrtnDte)
			throws DBException;//On Demand begins	public ArrayList on_demand_call_pnrDetail_lookup(String pnrLocator, String pnrCrtnDte)			throws DBException;	// On demand ends

	public String call_pnrText_lookup(String pnrLoctr, String pnrCrtnDte)
			throws DBException;

	public ArrayList call_default_lookup_detail(ArrayList pnrList)
			throws DBException;

	public ArrayList call_fop_lookup(String userId, String pnrLoctrNum)
			throws DBException;
}
