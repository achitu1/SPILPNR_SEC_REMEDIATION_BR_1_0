package com.delta.PNRJ.actions;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PNRJ.forms.PNRJ002_OnDemandlookupOrigDestForm;
import com.delta.PNRJ.helper.EJBLookup;
import com.delta.PNRJ.helper.PNRJUtil;
import com.delta.PRA.PNRJ.EJB.PNRJ;
import com.nwa.PRA.logger.Logger;



public class PNRJ002_OnDemandLookupOrigDestSubmitAction extends Action{

	

	public ActionForward execute(ActionMapping mapping, 

								ActionForm form, 

								HttpServletRequest request, 

								HttpServletResponse response) 

			throws Exception{

			PNRJ002_OnDemandlookupOrigDestForm frm = (PNRJ002_OnDemandlookupOrigDestForm) form;

			// initializing the list and detail; so as to assure that the 

			// previous list and details are erased 

			frm.setPnrDetail(null);

			frm.setPnrList(null);

			Logger.log(PNRJ002_OnDemandLookupOrigDestSubmitAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_OnDemandLookupOrigDestSubmitAction");

			ActionErrors errorException = new ActionErrors();

			ActionErrors errors = new ActionErrors();

			String link = "success";

			Logger.log(PNRJ002_OnDemandLookupOrigDestSubmitAction.class, Logger.LEVEL_DEBUG, "In OriginDestSubmitAction");

			Logger.log(PNRJ002_OnDemandLookupOrigDestSubmitAction.class, Logger.LEVEL_DEBUG, "Origin is:" + frm.getOrigin());

			Logger.log(PNRJ002_OnDemandLookupOrigDestSubmitAction.class, Logger.LEVEL_DEBUG, "Travel Date is:" + frm.getTravelDate());



			// format Travel Date

			frm.setTravelDate(PNRJUtil.formatDate(frm.getTravelDate()));

			Logger.log(PNRJ002_OnDemandLookupOrigDestSubmitAction.class, Logger.LEVEL_DEBUG, "Formatted Travel Date = [" + frm.getTravelDate() + "]");

			

			/*  -------------EJB Portion----------------------

			*/	 

			EJBLookup ejbLookup = new EJBLookup();			

			PNRJ pnrjBean = null;   // Home interface

			

			try{

				// clear all form fields

				pnrjBean = ejbLookup.lookupEjb();

				ArrayList pnrList = new ArrayList();

				

				//searching by origin-destination so lets call the stored proc passing origin, dest and travel date

				pnrList = pnrjBean.call_origdest_lookup(frm.getOrigin().toUpperCase(), frm.getDestination().toUpperCase(), frm.getTravelDate(), frm.getPassengerName().toUpperCase(), frm.getAirlineCode().toUpperCase(), frm.getFlightNumber());

				

				//check if there was a result in the stored procedure called

				if (pnrList.isEmpty()) {

					//errors.add("listEmpty", new ActionError("error.pnrList.empty"));

					String parm = "Origin, Destination, Travel Date";

					if(!frm.getPassengerName().equals(null) && frm.getPassengerName().length() != 0)

						parm = parm + ", Passenger Name";

					if(!frm.getAirlineCode().equals(null) && frm.getAirlineCode().length() != 0)

						parm = parm + ", Airline Code";

					if(!frm.getFlightNumber().equals(null) && frm.getFlightNumber().length() != 0)

						parm = parm + ", Flight Number";

					errors.add("listEmpty", new ActionError("error.pnrList.empty", parm));

				}else{

					frm.setShowRedisplay(true);

				}

				frm.setPnrList(pnrList); 

				frm.setPnrCount(new Integer(pnrList.size()).toString());

				

			} 

			 catch (Exception e) {

				Logger.log(PNRJ002_OnDemandLookupOrigDestSubmitAction.class, Logger.LEVEL_ERROR, e.getMessage());

				errorException.add(ActionErrors.GLOBAL_ERROR, new ActionError("pnr.general.exception", e.getMessage()));

				saveErrors(request, errorException);

				link="failure";

			}



			if(!errorException.isEmpty() || !errors.isEmpty()){

				   if(link.equals("failure")){

						 saveErrors(request, errorException);

				   } else {

						 saveErrors(request, errors);

				   }

			 }

			 return mapping.findForward(link);



	   }

}

