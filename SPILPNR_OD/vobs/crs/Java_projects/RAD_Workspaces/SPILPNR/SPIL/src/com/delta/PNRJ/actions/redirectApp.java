/*
 * Created on Apr 6, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.PNRJ.actions;

/**
 * @author C52260
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nwa.PRA.logger.Logger;

/**

 * @version       1.0

 * @author

 */

public class redirectApp extends Action {
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		Logger.log(redirectApp.class, Logger.LEVEL_DEBUG,"*****************************In redirect App************************");
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		String forwardString = "";

		//Get the session
		HttpSession session = request.getSession();
		
		try {
			//String app = (String)session.getAttribute("PNRJ002");
			forwardString="PNRJ002_init";
		} catch (Exception e) {
			Logger.log(redirectApp.class, Logger.LEVEL_DEBUG,"Error navigating to application");
			errors.add("name", new ActionError("id"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);

		} else {
			forward = mapping.findForward(forwardString);
		}

		return (forward);
	}

}
