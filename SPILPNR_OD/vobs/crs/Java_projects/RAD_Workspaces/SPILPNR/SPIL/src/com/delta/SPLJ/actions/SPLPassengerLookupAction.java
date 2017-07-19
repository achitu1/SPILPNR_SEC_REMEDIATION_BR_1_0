/*
 * Created on Dec 20, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.SPLJ.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.SPLJ.forms.SPLJ001_WaitlistInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.nwa.PRA.logger.Logger;

/**
 * @author Ann Yamat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SPLPassengerLookupAction extends Action {
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "Inside Lookup Action");
		SPLJ001_WaitlistInquiryForm frm = (SPLJ001_WaitlistInquiryForm) form;
		
		EJBLookup ejbLookup = new EJBLookup();
		SPLJ spl = null;
		
		try {
			spl = ejbLookup.lookupEjb();
			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "calling query for passenger lookup");
			ArrayList passengerList = spl.call_passenger_lookup_waitlist(frm.getSelDepartureDate().trim(),frm.getSelAirlineCode().trim(),frm.getSelFlightNumber().trim(),frm.getSelPnr().trim());
			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "passengerList size-->" + passengerList.size());
			frm.setPassengerList(passengerList);
			frm.setSelPnr(frm.getSelPnr());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("success");
	}
}