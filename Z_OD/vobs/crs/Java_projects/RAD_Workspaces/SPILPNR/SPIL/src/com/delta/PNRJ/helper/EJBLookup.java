/*
 * Created on Nov 9, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.PNRJ.helper;

import java.rmi.RemoteException;

import javax.ejb.HomeHandle;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.delta.PRA.PNRJ.EJB.PNRJ;
import com.delta.PRA.PNRJ.EJB.PNRJHome;
import com.delta.PRA.PNRJ.EJB.PNRJLocal;
import com.delta.PRA.PNRJ.EJB.PNRJLocalHome;
import com.nwa.PRA.EJBServiceLocHelper.EJBServiceLocator;

/**
 * @author To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EJBLookup {

	public PNRJ lookupEjb() throws Exception {

		HomeHandle handle = null;
		EJBServiceLocator s = EJBServiceLocator.getInstance();
		// commented by Dennis 11-11-2004
		handle = s.getEJBHomeHandle("ejb/com/nwa/PRA/PNRJ/EJB/PNRJHome",
				PNRJHome.class);
		PNRJHome pnrjHome = null;
		try {
			pnrjHome = (PNRJHome) PortableRemoteObject.narrow(handle
					.getEJBHome(), PNRJHome.class);
		} catch (ClassCastException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (RemoteException e1) {
			System.out.println("Handle may be invalid");
			e1.printStackTrace();
		}
		PNRJ pnrj = pnrjHome.create(); // remote Interface
		return pnrj;
	}

	public PNRJLocal getPNRJLocalRef() throws Exception {
		PNRJLocalHome localPnrj = null;
		PNRJLocal pnrj = null;
		InitialContext initCtx = null;
		try {
			initCtx = new InitialContext();

			Object ejbObject = initCtx
					.lookup("java:comp/env/ejb/com/nwa/PRA/PNRJ/EJB/PNRJHome");
			localPnrj = (PNRJLocalHome) PortableRemoteObject.narrow(ejbObject,
					PNRJLocalHome.class);
			pnrj = localPnrj.create();
		} catch (Exception e) {
			System.out.println("Error in creating the EJB reference "
					+ e.toString());
			throw new Exception("Error in creating the EJB referrence");
		}

		return pnrj;
	}
}
