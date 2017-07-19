/*
 * Created on Nov 9, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.SPLJ.helper;

import java.rmi.RemoteException;

import javax.ejb.HomeHandle;
import javax.rmi.PortableRemoteObject;

import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.PRA.SPLJ.EJB.SPLJHome;
import com.nwa.PRA.EJBServiceLocHelper.EJBServiceLocator;

/**
 * @author jra 
 * joseph roy acapulco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EJBLookup {

	public SPLJ lookupEjb() throws Exception{

		HomeHandle handle = null;
		EJBServiceLocator s = EJBServiceLocator.getInstance();

		handle = s.getEJBHomeHandle("ejb/com/nwa/PRA/SPLJ/EJB/SPLJHome", SPLJHome.class);
		SPLJHome spljHome = null;
		try {
			spljHome = (SPLJHome) PortableRemoteObject.narrow(handle.getEJBHome(), SPLJHome.class);
		} catch (ClassCastException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (RemoteException e1) {
			System.out.println("Handle may be invalid");
			e1.printStackTrace();
		}
		SPLJ splj = spljHome.create();  // remote Interface
		return splj;
	}

}
