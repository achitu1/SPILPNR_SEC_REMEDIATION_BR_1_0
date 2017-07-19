/*

 * Created on Dec 12, 2005

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



import com.delta.SPLJ.forms.SPLJ001_OnDemandSsrInquiryForm;

import com.nwa.PRA.logger.Logger;



/**

 * @author 

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJ001_OnDemandSsrInquiryAction extends Action {



	private HttpSession session;



	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, " ---Start of SPLJ001_OnDemandSsrInquiryAction--- ");



			session = request.getSession();

			ActionErrors errorException = new ActionErrors();



			SPLJ001_OnDemandSsrInquiryForm frm = (SPLJ001_OnDemandSsrInquiryForm) form;

			if (request.getParameter("alCde") != null){

				frm.setAirlineCode(request.getParameter("alCde"));

			}

			if (request.getParameter("fltNum") != null){

				frm.setFlightNumber(request.getParameter("fltNum"));

			}

			if (request.getParameter("lclDepDte") != null){

				frm.setLocalDepartureDate(request.getParameter("lclDepDte"));

			}

								

		return mapping.findForward("success");

	}

}

