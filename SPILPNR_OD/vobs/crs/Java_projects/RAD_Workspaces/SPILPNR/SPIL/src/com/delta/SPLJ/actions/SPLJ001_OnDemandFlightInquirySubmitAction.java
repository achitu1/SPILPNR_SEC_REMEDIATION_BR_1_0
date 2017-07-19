/*

 * Created on Dec 12, 2005

 *

 * To change the template for this generated file go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

package com.delta.SPLJ.actions;



import java.sql.Timestamp;
import java.util.ArrayList;

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
import com.delta.SPLJ.forms.SPLJ001_OnDemandFlightInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.delta.SPLJ.helper.SPLJUtil;
import com.nwa.PRA.logger.Logger;



/**

 * @author Ann Yamat

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJ001_OnDemandFlightInquirySubmitAction extends Action {

	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {





		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "-----------On Demand Flight Inquiry Submit Action-------");

		String link = "success";

		ActionErrors errors = new ActionErrors();

		SPLJ001_OnDemandFlightInquiryForm frm = (SPLJ001_OnDemandFlightInquiryForm) form;



		String airlineCode = frm.getAirlineCode().trim().toUpperCase();

		String flightNumber = frm.getFlightNumber().trim().toUpperCase();

		String localDepartureDate = SPLJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase());

		
		Timestamp timeStamp = frm.getTimeStamp();



		frm.setAirlineCode(airlineCode);

		frm.setFlightNumber(flightNumber);

		frm.setLocalDepartureDate(PNRJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()));
		//on demand begin
		// frm.setSelTimeStamp(frm.getTimeStamp());
		// System.out.println("In SPLJ001_OnDemandFlightInquirySubmitAction: timestamp: "+frm.getTimeStamp());
	//	  timeStamp = frm.getSelTimeStamp();
		//on demand end


		ArrayList selectList = new ArrayList();



		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "airlineCode --> " + airlineCode);

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "flightNumber --> " + flightNumber);

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "localDepartureDate --> " + localDepartureDate);

	//	Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "timeStamp --> " + timeStamp);


		EJBLookup ejbLookup = new EJBLookup();

		SPLJ spljBean = null;



		try {

			spljBean = ejbLookup.lookupEjb();

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());


//On Demand changes begin 7/21/16
			selectList = spljBean.call_flight_inquiry_lookup_OD(airlineCode, flightNumber, localDepartureDate,frm.getDepartureAirport(),frm.getDestinationAirport());

			//selectList = spljBean.call_flight_inquiry_lookup_OD(airlineCode, flightNumber, localDepartureDate,frm.getDepartureAirport(),frm.getDestinationAirport());
//On Demand changes end

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

