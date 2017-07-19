package com.delta.PRA.PNRJ.EJB;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessPRAJ_73a7bda3
 */
public class EJSRemoteStatelessPRAJ_73a7bda3 extends EJSWrapper implements PNRJ {
	/**
	 * EJSRemoteStatelessPRAJ_73a7bda3
	 */
	public EJSRemoteStatelessPRAJ_73a7bda3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * call_pnrText_lookup
	 */
	public java.lang.String call_pnrText_lookup(java.lang.String pnrLoctr, java.lang.String pnrCrtnDte) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = pnrLoctr;
				_jacc_parms[1] = pnrCrtnDte;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_pnrText_lookup(pnrLoctr, pnrCrtnDte);
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
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * retrievePnrCrtnYearMo
	 */
	public java.lang.String retrievePnrCrtnYearMo(java.lang.String pnrCrtnDte) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = pnrCrtnDte;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.retrievePnrCrtnYearMo(pnrCrtnDte);
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
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * call_airline_flightnum_lookup
	 */
	public java.util.ArrayList call_airline_flightnum_lookup(java.lang.String airLine, java.lang.String flightNum, java.lang.String travelDate, java.lang.String surName, java.lang.String origin, java.lang.String dest) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = airLine;
				_jacc_parms[1] = flightNum;
				_jacc_parms[2] = travelDate;
				_jacc_parms[3] = surName;
				_jacc_parms[4] = origin;
				_jacc_parms[5] = dest;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_airline_flightnum_lookup(airLine, flightNum, travelDate, surName, origin, dest);
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
	 * call_cc_lookup
	 */
	public java.util.ArrayList call_cc_lookup(java.lang.String ccCode, java.lang.String tokenizedCreditCard) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = ccCode;
				_jacc_parms[1] = tokenizedCreditCard;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_cc_lookup(ccCode, tokenizedCreditCard);
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
	 * call_cc_lookup
	 */
	public java.util.ArrayList call_cc_lookup(java.lang.String userId, java.lang.String ccCode, java.lang.String ccNum) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = userId;
				_jacc_parms[1] = ccCode;
				_jacc_parms[2] = ccNum;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_cc_lookup(userId, ccCode, ccNum);
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
	 * call_default_lookup_detail
	 */
	public java.util.ArrayList call_default_lookup_detail(java.util.ArrayList pnrList) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = pnrList;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_default_lookup_detail(pnrList);
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
	 * call_employee_lookup
	 */
	public java.util.ArrayList call_employee_lookup(java.lang.String empNum) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = empNum;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_employee_lookup(empNum);
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
	 * call_fop_lookup
	 */
	public java.util.ArrayList call_fop_lookup(java.lang.String userId, java.lang.String pnrLoctrNum) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = userId;
				_jacc_parms[1] = pnrLoctrNum;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_fop_lookup(userId, pnrLoctrNum);
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
	 * call_freqflier_lookup
	 */
	public java.util.ArrayList call_freqflier_lookup(java.lang.String frqflierid, java.lang.String freqfliernum) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = frqflierid;
				_jacc_parms[1] = freqfliernum;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_freqflier_lookup(frqflierid, freqfliernum);
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
	 * call_name_lookup
	 */
	public java.util.ArrayList call_name_lookup(java.lang.String surName, java.lang.String travelDate, java.lang.String flightNum, java.lang.String alCode, java.lang.String origin, java.lang.String dest) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = surName;
				_jacc_parms[1] = travelDate;
				_jacc_parms[2] = flightNum;
				_jacc_parms[3] = alCode;
				_jacc_parms[4] = origin;
				_jacc_parms[5] = dest;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_name_lookup(surName, travelDate, flightNum, alCode, origin, dest);
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
	 * call_name_lookup_range
	 */
	public java.util.ArrayList call_name_lookup_range(java.lang.String surName, java.lang.String travelDate, java.lang.String flightNum, java.lang.String alCode, java.lang.String origin, java.lang.String dest) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = surName;
				_jacc_parms[1] = travelDate;
				_jacc_parms[2] = flightNum;
				_jacc_parms[3] = alCode;
				_jacc_parms[4] = origin;
				_jacc_parms[5] = dest;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_name_lookup_range(surName, travelDate, flightNum, alCode, origin, dest);
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
	 * call_origdest_lookup
	 */
	public java.util.ArrayList call_origdest_lookup(java.lang.String origin, java.lang.String destination, java.lang.String travelDate, java.lang.String surName, java.lang.String alCode, java.lang.String flightNum) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = origin;
				_jacc_parms[1] = destination;
				_jacc_parms[2] = travelDate;
				_jacc_parms[3] = surName;
				_jacc_parms[4] = alCode;
				_jacc_parms[5] = flightNum;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_origdest_lookup(origin, destination, travelDate, surName, alCode, flightNum);
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
	 * call_pnrDetail_lookup
	 */
	public java.util.ArrayList call_pnrDetail_lookup(java.lang.String pnrLocator, java.lang.String pnrCrtnDte) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = pnrLocator;
				_jacc_parms[1] = pnrCrtnDte;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_pnrDetail_lookup(pnrLocator, pnrCrtnDte);
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
	 * call_pnr_lookup
	 */
	public java.util.ArrayList call_pnr_lookup(java.lang.String pnrLoctr) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = pnrLoctr;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_pnr_lookup(pnrLoctr);
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
	 * call_tkt_lookup
	 */
	public java.util.ArrayList call_tkt_lookup(java.lang.String tktnum) throws com.nwa.PRA.CustExceptions.DBException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = tktnum;
			}
	com.delta.PRA.PNRJ.EJB.PNRJBean beanRef = (com.delta.PRA.PNRJ.EJB.PNRJBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.call_tkt_lookup(tktnum);
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
}
