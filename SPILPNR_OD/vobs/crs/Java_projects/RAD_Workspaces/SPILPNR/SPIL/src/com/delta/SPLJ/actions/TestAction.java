/*

 * Created on Dec 12, 2005

 *

 * To change the template for this generated file go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

package com.delta.SPLJ.actions;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.SPLJ.helper.EJBLookup;
import com.nwa.PRA.logger.Logger;



/**

 * @author jra

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class TestAction extends Action {

	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {



		EJBLookup ejbLookup = new EJBLookup();

		SPLJ spljBean = null;

		

		try {

			spljBean = ejbLookup.lookupEjb();

			

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, " testaction --> " + spljBean.getTestMessage());

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}	



		return mapping.findForward("success");

	}

}

