package com.delta.PRA.PNRJ.EJB;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessPRAJHomeBean_73a7bda3
 */
public class EJSStatelessPRAJHomeBean_73a7bda3 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessPRAJHomeBean_73a7bda3
	 */
	public EJSStatelessPRAJHomeBean_73a7bda3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.delta.PRA.PNRJ.EJB.PNRJ create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.delta.PRA.PNRJ.EJB.PNRJ result = null;
boolean createFailed = false;
try {
	result = (com.delta.PRA.PNRJ.EJB.PNRJ) super.createWrapper(null);
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
	/**
	 * create_Local
	 */
	public com.delta.PRA.PNRJ.EJB.PNRJLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.delta.PRA.PNRJ.EJB.PNRJLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.delta.PRA.PNRJ.EJB.PNRJLocal) super.createWrapper_Local(null);
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
