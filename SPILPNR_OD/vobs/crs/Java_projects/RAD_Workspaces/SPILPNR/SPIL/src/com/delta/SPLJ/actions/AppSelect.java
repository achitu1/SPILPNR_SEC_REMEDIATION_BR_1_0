/**
 * 
 */
package com.delta.SPLJ.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PNRJ.actions.redirectApp;
import com.nwa.PRA.logger.Logger;

/**
 * @author f77219
 *
 */
public class AppSelect extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Logger.log(redirectApp.class, Logger.LEVEL_DEBUG,"*****************************In AppSelect************************");
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
