/*
 * Created on Jan 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.SPLJ.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.delta.SPLJ.forms.LoginForm;




/**
 * @author Ann Yamat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

	public class LogoutAction extends Action {

		public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
					
		   ////
		   ActionMessages messages = new ActionMessages();
		   ActionErrors errors = new ActionErrors();
		   ActionForward forward = new ActionForward();
		   String forwardString = new String("success");
		   //Get the session
		   HttpSession session = request.getSession();
		   session.invalidate();
		   forward = mapping.findForward(forwardString);

		   //2006-01-11 n24772 - added for automatic window closing
		   LoginForm frm = (LoginForm) form;
		   frm.setActionNavigator("logout");

		   return (forward);
		}
	}
