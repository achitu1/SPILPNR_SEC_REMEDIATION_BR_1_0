package com.delta.PRA.SPLJ.EJB;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSPLJHomeBean_81f86568
 */
public class EJSStatelessSPLJHomeBean_81f86568 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSPLJHomeBean_81f86568
	 */
	public EJSStatelessSPLJHomeBean_81f86568() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.delta.PRA.SPLJ.EJB.SPLJ create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.delta.PRA.SPLJ.EJB.SPLJ result = null;
boolean createFailed = false;
try {
	result = (com.delta.PRA.SPLJ.EJB.SPLJ) super.createWrapper(null);
}
catch (javax.ejb.CreateException ex) {
	createFailed = true;
	throw ex;
} catch (java.rmi.RemoteException ex) {
	createFailed = true;
	throw ex;
} catch (Throwable ex) {
	createFailed = true;
	throw new CreateFailureException(ex);
} finally {
	if (createFailed) {
		super.createFailure(beanO);
	}
}
return result;	}
}
