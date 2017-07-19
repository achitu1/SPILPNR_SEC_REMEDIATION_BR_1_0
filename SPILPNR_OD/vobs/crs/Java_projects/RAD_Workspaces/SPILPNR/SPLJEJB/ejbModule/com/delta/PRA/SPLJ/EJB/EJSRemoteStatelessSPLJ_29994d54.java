package com.delta.PRA.SPLJ.EJB;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSPLJ_29994d54
 */
public class EJSRemoteStatelessSPLJ_29994d54 extends EJSWrapper implements SPLJ {
	/**
	 * EJSRemoteStatelessSPLJ_29994d54
	 */
	public EJSRemoteStatelessSPLJ_29994d54() throws java.rmi.RemoteException {
		super();	}
	/**
	 * call_on_Demand_Request
	 */
	public boolean call_on_Demand_Request(java.lang.String email, java.lang.String flightNumber, java.lang.String localDepartureDate, java.lang.String legOrigApCode) throws com.ibm.ws.http.HttpException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = email;
				_jacc_parms[1] = flightNumber;
				_jacc_parms[2] = localDepartureDate;
				_jacc_parms[3] = legOrigApCode;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_on_Demand_Request(email, flightNumber, localDepartureDate, legOrigApCode);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTestMessage
	 */
	public java.lang.String getTestMessage() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getTestMessage();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_flight_inquiry_lookup
	 */
	public java.util.ArrayList call_flight_inquiry_lookup(java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String localDepartureDate, java.lang.String depApt, java.lang.String desApt) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = airlineCode;
				_jacc_parms[1] = flightNumber;
				_jacc_parms[2] = localDepartureDate;
				_jacc_parms[3] = depApt;
				_jacc_parms[4] = desApt;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_flight_inquiry_lookup(airlineCode, flightNumber, localDepartureDate, depApt, desApt);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_flight_inquiry_lookup_OD
	 */
	public java.util.ArrayList call_flight_inquiry_lookup_OD(java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String localDepartureDate, java.lang.String depApt, java.lang.String desApt) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = airlineCode;
				_jacc_parms[1] = flightNumber;
				_jacc_parms[2] = localDepartureDate;
				_jacc_parms[3] = depApt;
				_jacc_parms[4] = desApt;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_flight_inquiry_lookup_OD(airlineCode, flightNumber, localDepartureDate, depApt, desApt);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_frequent_flier_inquiry_lookup
	 */
	public java.util.ArrayList call_frequent_flier_inquiry_lookup(java.lang.String airlineCode, java.lang.String programId) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = airlineCode;
				_jacc_parms[1] = programId;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_frequent_flier_inquiry_lookup(airlineCode, programId);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_frequent_flier_inquiry_lookup_OD
	 */
	public java.util.ArrayList call_frequent_flier_inquiry_lookup_OD(java.lang.String airlineCode, java.lang.String programId) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = airlineCode;
				_jacc_parms[1] = programId;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_frequent_flier_inquiry_lookup_OD(airlineCode, programId);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_other_inquiry_lookup
	 */
	public java.util.ArrayList call_other_inquiry_lookup(java.lang.String ticketNumber, java.lang.String pnrLocator, java.lang.String governmentId) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = ticketNumber;
				_jacc_parms[1] = pnrLocator;
				_jacc_parms[2] = governmentId;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_other_inquiry_lookup(ticketNumber, pnrLocator, governmentId);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_other_inquiry_lookup_OD
	 */
	public java.util.ArrayList call_other_inquiry_lookup_OD(java.lang.String ticketNumber, java.lang.String pnrLocator, java.lang.String governmentId) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = ticketNumber;
				_jacc_parms[1] = pnrLocator;
				_jacc_parms[2] = governmentId;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_other_inquiry_lookup_OD(ticketNumber, pnrLocator, governmentId);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_passenger_inquiry_lookup
	 */
	public java.util.ArrayList call_passenger_inquiry_lookup(java.lang.String passengerName, java.lang.String localDepartureDate) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = passengerName;
				_jacc_parms[1] = localDepartureDate;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_passenger_inquiry_lookup(passengerName, localDepartureDate);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_passenger_inquiry_lookup_OD
	 */
	public java.util.ArrayList call_passenger_inquiry_lookup_OD(java.lang.String passengerName, java.lang.String localDepartureDate) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = passengerName;
				_jacc_parms[1] = localDepartureDate;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_passenger_inquiry_lookup_OD(passengerName, localDepartureDate);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_passenger_lookup_waitlist
	 */
	public java.util.ArrayList call_passenger_lookup_waitlist(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String pnrLocator) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = pnrLocator;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_passenger_lookup_waitlist(localDepartureDate, airlineCode, flightNumber, pnrLocator);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_passenger_lookup_waitlist_OD
	 */
	public java.util.ArrayList call_passenger_lookup_waitlist_OD(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String pnrLocator, java.sql.Timestamp timeStamp) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = pnrLocator;
				_jacc_parms[4] = timeStamp;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_passenger_lookup_waitlist_OD(localDepartureDate, airlineCode, flightNumber, pnrLocator, timeStamp);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_query_i
	 */
	public java.util.ArrayList call_query_i(java.lang.String pnr) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = pnr;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_query_i(pnr);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_query_j
	 */
	public java.util.ArrayList call_query_j() throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_query_j();
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_query_k
	 */
	public java.util.ArrayList call_query_k() throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_query_k();
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_query_l
	 */
	public java.util.ArrayList call_query_l() throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_query_l();
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_query_m
	 */
	public java.util.ArrayList call_query_m() throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_query_m();
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_query_n
	 */
	public java.util.ArrayList call_query_n() throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_query_n();
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_query_o
	 */
	public java.util.ArrayList call_query_o() throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_query_o();
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_query_p
	 */
	public java.util.ArrayList call_query_p() throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_query_p();
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_selected_record_lookup
	 */
	public java.util.ArrayList call_selected_record_lookup(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String legOrigApCode, java.lang.String seqNum, java.lang.String rowSeat, java.lang.String pnrNum) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = legOrigApCode;
				_jacc_parms[4] = seqNum;
				_jacc_parms[5] = rowSeat;
				_jacc_parms[6] = pnrNum;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_selected_record_lookup(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat, pnrNum);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_selected_record_lookup_OD
	 */
	public java.util.ArrayList call_selected_record_lookup_OD(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String legOrigApCode, java.lang.String seqNum, java.lang.String rowSeat, java.lang.String pnrNum, java.sql.Timestamp timeStamp) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[8];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = legOrigApCode;
				_jacc_parms[4] = seqNum;
				_jacc_parms[5] = rowSeat;
				_jacc_parms[6] = pnrNum;
				_jacc_parms[7] = timeStamp;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_selected_record_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat, pnrNum, timeStamp);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_selected_record_lookup_waitlist
	 */
	public java.util.ArrayList call_selected_record_lookup_waitlist(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String passengerName, java.lang.String pnrLocator) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = passengerName;
				_jacc_parms[4] = pnrLocator;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_selected_record_lookup_waitlist(localDepartureDate, airlineCode, flightNumber, passengerName, pnrLocator);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_selected_record_lookup_waitlist_OD
	 */
	public java.util.ArrayList call_selected_record_lookup_waitlist_OD(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String passengerName, java.lang.String pnrLocator, java.sql.Timestamp timeStamp) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = passengerName;
				_jacc_parms[4] = pnrLocator;
				_jacc_parms[5] = timeStamp;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_selected_record_lookup_waitlist_OD(localDepartureDate, airlineCode, flightNumber, passengerName, pnrLocator, timeStamp);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_selected_record_remarks_lookup
	 */
	public java.util.ArrayList call_selected_record_remarks_lookup(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String legOrigApCode, java.lang.String seqNum, java.lang.String rowSeat, java.lang.String pnrNum) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = legOrigApCode;
				_jacc_parms[4] = seqNum;
				_jacc_parms[5] = rowSeat;
				_jacc_parms[6] = pnrNum;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_selected_record_remarks_lookup(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat, pnrNum);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 24, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_selected_record_remarks_lookup_OD
	 */
	public java.util.ArrayList call_selected_record_remarks_lookup_OD(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String legOrigApCode, java.lang.String seqNum, java.lang.String rowSeat, java.lang.String pnrNum, java.sql.Timestamp timestamp) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[8];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = legOrigApCode;
				_jacc_parms[4] = seqNum;
				_jacc_parms[5] = rowSeat;
				_jacc_parms[6] = pnrNum;
				_jacc_parms[7] = timestamp;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_selected_record_remarks_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat, pnrNum, timestamp);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 25, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_ssr_inquiry_lookup
	 */
	public java.util.ArrayList call_ssr_inquiry_lookup(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String ssrCodet) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = ssrCodet;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_ssr_inquiry_lookup(localDepartureDate, airlineCode, flightNumber, ssrCodet);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 26, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_ssr_inquiry_lookup_OD
	 */
	public java.util.ArrayList call_ssr_inquiry_lookup_OD(java.lang.String localDepartureDate, java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String ssrCode) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = localDepartureDate;
				_jacc_parms[1] = airlineCode;
				_jacc_parms[2] = flightNumber;
				_jacc_parms[3] = ssrCode;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 27, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_ssr_inquiry_lookup_OD(localDepartureDate, airlineCode, flightNumber, ssrCode);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 27, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_waitlist_inquiry_lookup
	 */
	public java.util.ArrayList call_waitlist_inquiry_lookup(java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String localDepartureDate, java.lang.String passengerName, java.lang.String pnrLocator) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = airlineCode;
				_jacc_parms[1] = flightNumber;
				_jacc_parms[2] = localDepartureDate;
				_jacc_parms[3] = passengerName;
				_jacc_parms[4] = pnrLocator;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 28, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_waitlist_inquiry_lookup(airlineCode, flightNumber, localDepartureDate, passengerName, pnrLocator);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 28, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_waitlist_inquiry_lookup_OD
	 */
	public java.util.ArrayList call_waitlist_inquiry_lookup_OD(java.lang.String airlineCode, java.lang.String flightNumber, java.lang.String localDepartureDate, java.lang.String passengerName, java.lang.String pnrLocator, java.sql.Timestamp timeStamp) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = airlineCode;
				_jacc_parms[1] = flightNumber;
				_jacc_parms[2] = localDepartureDate;
				_jacc_parms[3] = passengerName;
				_jacc_parms[4] = pnrLocator;
				_jacc_parms[5] = timeStamp;
			}
	com.delta.PRA.SPLJ.EJB.SPLJBean beanRef = (com.delta.PRA.SPLJ.EJB.SPLJBean)container.preInvoke(this, 29, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_waitlist_inquiry_lookup_OD(airlineCode, flightNumber, localDepartureDate, passengerName, pnrLocator, timeStamp);
		}
		catch (com.nwa.PRA.CustExceptions.DBException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 29, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
