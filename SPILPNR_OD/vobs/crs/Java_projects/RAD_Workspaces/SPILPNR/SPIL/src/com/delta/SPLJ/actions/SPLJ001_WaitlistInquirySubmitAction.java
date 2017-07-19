/*
 * Created on Dec 12, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.SPLJ.actions;

import java.util.ArrayList;

import org.apache.struts.action.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PNRJ.helper.PNRJUtil;
import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.PRA.SPLJ.data.SPLData;
import com.delta.SPLJ.forms.SPLJ001_WaitlistInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.delta.SPLJ.helper.SPLJUtil;
import com.nwa.PRA.logger.Logger;

/**
 * @author Ann Yamat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SPLJ001_WaitlistInquirySubmitAction extends Action {
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		SPLJ001_WaitlistInquiryForm frm = (SPLJ001_WaitlistInquiryForm) form;
		String link="success";
		
		if (validateWaitlistInquiryForm(frm, request)) {

			ActionErrors errors = new ActionErrors();

			String airlineCode = frm.getAirlineCode().trim().toUpperCase();
			String flightNumber = frm.getFlightNumber().trim().toUpperCase();
			String localDepartureDate = "";
			if (frm.getLocalDepartureDate().trim().length() > 0){
				localDepartureDate = SPLJUtil.formatDate(frm.getLocalDepartureDate().trim());
				frm.setLocalDepartureDate(PNRJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()));
			}
			String passengerName = frm.getPassengerName().trim().toUpperCase();
			String pnrLocator = frm.getPnrLocator().trim().toUpperCase();
			ArrayList selectList = new ArrayList();
			Logger.log(this.getClass(), Logger.LEVEL_INFO, "In waitlist - Flight is "+airlineCode + " - " + flightNumber + " - " + localDepartureDate);
			EJBLookup ejbLookup = new EJBLookup();
			SPLJ spljBean = null;

			try {
				spljBean = ejbLookup.lookupEjb();
				Logger.log(this.getClass(), Logger.LEVEL_INFO, spljBean.getTestMessage());
				selectList = spljBean.call_waitlist_inquiry_lookup(airlineCode, flightNumber, localDepartureDate,	passengerName, pnrLocator);
				Logger.log(this.getClass(), Logger.LEVEL_INFO, "selectList size --> "+selectList.size());
								
				frm.setSelectList(selectList);
				frm.setPnrCount(new Integer (selectList.size()).toString());

			} catch (Exception e) {
				Logger.log(this.getClass(), Logger.LEVEL_ERROR, e.getMessage());
				errors.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("spl.general.exception", e.getMessage()));
				saveErrors(request, errors);
				e.printStackTrace();
			}
		}
		
		if("true".equals(frm.getDownload())){
			link="excel";
		}
		
		return mapping.findForward(link);
	}

	private boolean validateWaitlistInquiryForm(
		SPLJ001_WaitlistInquiryForm frm,
		HttpServletRequest request) {

		String airlineCode = frm.getAirlineCode().trim();
		String flightNumber = frm.getFlightNumber().trim();
		String localDepartureDate = frm.getLocalDepartureDate().trim();
		String passengerName = frm.getPassengerName().trim();
		String pnrLocator = frm.getPnrLocator().trim();

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "airlineCode --> " + airlineCode);
		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "flightNumber --> " + flightNumber);
		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "localDepartureDate --> " + localDepartureDate);
		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "passengerName --> " + passengerName);
		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "pnrLocator --> " + pnrLocator);

		ActionErrors errors = new ActionErrors();

		// User must input some search criteria
		if ((airlineCode.length() == 0)
			&& (flightNumber.length() == 0)
			&& (localDepartureDate.length() == 0)
			&& (passengerName.length() == 0)
			&& (pnrLocator.length() == 0)) {

				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.waitlist.query.fields"));

			saveErrors(request, errors);
			return false;
		}
		// User must enter in data in the Airline Code, Flight Number, Departure Date fields
		if ((airlineCode.length() > 0) || (flightNumber.length() > 0)) {
			if ((airlineCode.length() > 0)
				&& (flightNumber.length() > 0)
				&& (localDepartureDate.length() > 0)) {
				if((passengerName.length()>0)||(pnrLocator.length()>0)){
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.waitlist.query.fields"));
					saveErrors(request, errors);
					return false;
				}else{
					return true;
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.waitlist.query.fields"));	
				saveErrors(request, errors);
				return false;
			}
		}

		// User must enter in data in the Airline Code, Flight Number, Departure Date fields; 
		// or Departure Date and the Passenger Name fields together
		if (localDepartureDate.length() > 0) {
			if ((passengerName.length() > 0)
				|| ((airlineCode.length() > 0) && (flightNumber.length() > 0))) {
				return true;
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.waitlist.query.fields"));	
				saveErrors(request, errors);
				return false;
			}
		}

		// User must enter both Departure Date and the Passenger Name
		if (passengerName.length() > 0) {
			if (localDepartureDate.length() == 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.waitlist.query.fields"));	

				saveErrors(request, errors);
				return false;
			}else 
				if((airlineCode.length()>0)||(flightNumber.length()>0)||(pnrLocator.length()>0)){
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.waitlist.query.fields"));	
				saveErrors(request, errors);
				return false;			
			}
		
		}

		return true;
	}
}
