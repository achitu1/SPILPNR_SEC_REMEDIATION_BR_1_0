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

import com.delta.PNRJ.forms.PNRJ002_lookupFlightForm;
import com.delta.PNRJ.helper.EJBLookup;
import com.delta.PNRJ.helper.PNRJUtil;
import com.delta.PRA.PNRJ.EJB.PNRJ;
import com.nwa.PRA.logger.Logger;

////////////////////UPDATES & COMMENTS////////////////////
/*
 * 
 * @author id
 *
 * Program Description
 * 
 * Updates:
 * Date			Initials	Change
 * 20070116		AP			Changed System.out to Logger
 */

public class PNRJ002_LookupFlightSubmitAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, 
								ActionForm form, 
								HttpServletRequest request, 
								HttpServletResponse response) 
			throws Exception{
				
			PNRJ002_lookupFlightForm frm = (PNRJ002_lookupFlightForm) form;
			Logger.log(PNRJ002_LookupFlightSubmitAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_LookupFlightSubmitAction");
			// initializing the list and detail; so as to assure that the 
			// previous list and details are erased 
			frm.setPnrDetail(null);
			frm.setPnrList(null);			
			ActionErrors errorException = new ActionErrors();
			ActionErrors errors = new ActionErrors();			
			String link = "success";
			
			// format Travel Date
			frm.setTravelDate(PNRJUtil.formatDate(frm.getTravelDate()));
			Logger.log(PNRJ002_LookupFlightSubmitAction.class, Logger.LEVEL_DEBUG, "Formatted Travel Date = [" + frm.getTravelDate() + "]");
			
			try{

				Logger.log(PNRJ002_LookupFlightSubmitAction.class, Logger.LEVEL_DEBUG, "In LookupFlightSubmitAction");
				Logger.log(PNRJ002_LookupFlightSubmitAction.class, Logger.LEVEL_DEBUG, "Flight Number is:" + frm.getFlightNumber());
				Logger.log(PNRJ002_LookupFlightSubmitAction.class, Logger.LEVEL_DEBUG, "Travel Date is:" + frm.getTravelDate());
				Logger.log(PNRJ002_LookupFlightSubmitAction.class, Logger.LEVEL_DEBUG, "Airline Code is:" + frm.getAirlineCode());
				/*  -------------EJB Portion----------------------
				*/	 
				EJBLookup ejbLookup = new EJBLookup();			
				PNRJ pnrjBean = null;   // Home interface
			 	
				/* commented out for testing 12/02/2004*/
				pnrjBean = ejbLookup.lookupEjb();
				ArrayList pnrList = new ArrayList();
				
				//searching by flight num & airline code so lets call the stored proc passing flight and airline code and travel date
				pnrList = pnrjBean.call_airline_flightnum_lookup(frm.getAirlineCode().toUpperCase(), frm.getFlightNumber().toUpperCase(), frm.getTravelDate(), frm.getPassengerName().toUpperCase(), frm.getOrigin().toUpperCase(), frm.getDestination().toUpperCase());

				//check if there was a result in the stored procedure called
				if (pnrList.isEmpty()) {
					//errors.add("listEmpty", new ActionError("error.pnrList.empty"));
					String parm = "Airline Code, Flight Number, Travel Date";
					if(!frm.getPassengerName().equals(null) && frm.getPassengerName().length() != 0)
						parm = parm + ", Passenger Name";
					if(!frm.getOrigin().equals(null) && frm.getOrigin().length() != 0)
						parm = parm + ", Origin";
					if(!frm.getDestination().equals(null) && frm.getDestination().length() != 0)
						parm = parm + ", Destination";
					errors.add("listEmpty", new ActionError("error.pnrList.empty", parm));
				}else{
					frm.setShowRedisplay(true);
				}

				frm.setPnrList(pnrList);
				frm.setPnrCount(new Integer(pnrList.size()).toString()); 
				frm.setSelPassenger(frm.getSelPassenger());
				frm.setSelPnrCrtnDate(frm.getSelPnrCrtnDate());
				frm.setSelPnrLoctrNum(frm.getSelPnrLoctrNum());
			
			} 
			 catch (Exception e) {
				Logger.log(PNRJ002_LookupFlightSubmitAction.class, Logger.LEVEL_ERROR, e.getMessage());
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
