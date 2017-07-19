package com.delta.PNRJ.actions;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import org.apache.struts.action.Action;

import org.apache.struts.action.ActionError;

import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionForward;

import org.apache.struts.action.ActionMapping;



import com.delta.PNRJ.forms.PNRJ002_OnDemandlookupFlightForm;

import com.nwa.PRA.logger.Logger;



public class PNRJ002_OnDemandLookupFlightAction extends Action{

	

	private HttpSession session;

	public ActionForward execute(ActionMapping mapping, 

								ActionForm form, 

								HttpServletRequest request, 

								HttpServletResponse response) 

			throws Exception{

			session = request.getSession();

			session.removeAttribute("lookupDefaultForm");

			session.removeAttribute("lookupFlightForm");

			session.removeAttribute("lookupOrigDestForm");

			session.removeAttribute("lookupPassengerForm");

			session.setAttribute("module","flight");

			PNRJ002_OnDemandlookupFlightForm frm = (PNRJ002_OnDemandlookupFlightForm) form;

			Logger.log(PNRJ002_OnDemandLookupFlightAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_OnDemandLookupFlightAction");

			ActionErrors errorException = new ActionErrors();

			String link = "success";

			

			try{



				// clear all form fields

				frm.setAirlineCode("");

				frm.setDestination("");

				frm.setFlightNumber("");

				frm.setOrigin("");

				frm.setPassengerName("");

				frm.setTravelDate(null);

				



			} 

			 catch (Exception e) {

				Logger.log(PNRJ002_OnDemandLookupFlightAction.class, Logger.LEVEL_ERROR, e.getMessage());

				errorException.add(ActionErrors.GLOBAL_ERROR, 

				new ActionError("string.message"));

				saveErrors(request, errorException);

				link="failure";

			}

			return mapping.findForward(link);			

	}

}

