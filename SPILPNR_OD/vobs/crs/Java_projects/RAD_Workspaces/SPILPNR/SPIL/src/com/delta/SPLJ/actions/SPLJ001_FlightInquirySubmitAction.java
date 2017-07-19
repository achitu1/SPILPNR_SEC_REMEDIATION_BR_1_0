/*
 * Created on Dec 12, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.SPLJ.actions;

import java.util.ArrayList;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import org.apache.struts.action.Action;import org.apache.struts.action.ActionError;import org.apache.struts.action.ActionErrors;import org.apache.struts.action.ActionForm;import org.apache.struts.action.ActionForward;import org.apache.struts.action.ActionMapping;import com.delta.PNRJ.helper.PNRJUtil;import com.delta.PRA.SPLJ.EJB.SPLJ;import com.delta.SPLJ.forms.SPLJ001_FlightInquiryForm;import com.delta.SPLJ.helper.EJBLookup;import com.delta.SPLJ.helper.SPLJUtil;import com.nwa.PRA.logger.Logger;

/**
 * @author Ann Yamat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SPLJ001_FlightInquirySubmitAction extends Action {
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {


			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "-----------Flight Inquiry Submit Action-------");
		String link = "success";
		ActionErrors errors = new ActionErrors();
		SPLJ001_FlightInquiryForm frm = (SPLJ001_FlightInquiryForm) form;

		String airlineCode = frm.getAirlineCode().trim().toUpperCase();
		String flightNumber = frm.getFlightNumber().trim().toUpperCase();
		String localDepartureDate = SPLJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase());
		

		frm.setAirlineCode(airlineCode);
		frm.setFlightNumber(flightNumber);
		frm.setLocalDepartureDate(PNRJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()));
		
System.out.println("In Action class FlightInquirySubmitAction 3 :" + airlineCode);
System.out.println("In Action class FlightInquirySubmitAction 3 :" + flightNumber);
System.out.println("In Action class FlightInquirySubmitAction 3 :" + localDepartureDate);
		
		
		ArrayList selectList = new ArrayList();

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "airlineCode --> " + airlineCode);
		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "flightNumber --> " + flightNumber);
		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "localDepartureDate --> " + localDepartureDate);

		EJBLookup ejbLookup = new EJBLookup();
		SPLJ spljBean = null;

		try {
			spljBean = ejbLookup.lookupEjb();
			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());

			selectList = spljBean.call_flight_inquiry_lookup(airlineCode, flightNumber, localDepartureDate,frm.getDepartureAirport(),frm.getDestinationAirport());
			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "selectList size --> " + selectList.size());

			frm.setSelectList(selectList);
			frm.setPnrCount(new Integer (selectList.size()).toString());
			
			if("true".equals(frm.getDownload())){
				link="excel";
			}
			
			Logger.log(this.getClass(),Logger.LEVEL_DEBUG, "link--->"+ link);

		} catch (Exception e) {
			Logger.log(this.getClass(), Logger.LEVEL_ERROR, e.getMessage());
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("spl.general.exception", e.getMessage()));
			saveErrors(request, errors);
			e.printStackTrace();
		}

		return mapping.findForward(link);
	}
}
