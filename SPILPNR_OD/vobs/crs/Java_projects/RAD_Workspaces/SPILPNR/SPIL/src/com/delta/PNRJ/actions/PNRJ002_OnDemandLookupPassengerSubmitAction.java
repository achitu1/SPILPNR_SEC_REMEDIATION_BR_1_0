package com.delta.PNRJ.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PNRJ.forms.PNRJ002_OnDemandlookupPassengerForm;
import com.delta.PNRJ.helper.EJBLookup;
import com.delta.PNRJ.helper.PNRJUtil;
import com.delta.PRA.PNRJ.EJB.PNRJ;
import com.nwa.PRA.logger.Logger;


public class PNRJ002_OnDemandLookupPassengerSubmitAction extends Action{

	

	public ActionForward execute(ActionMapping mapping, 

								ActionForm form, 

								HttpServletRequest request, 

								HttpServletResponse response) 

			throws Exception{

			PNRJ002_OnDemandlookupPassengerForm frm = (PNRJ002_OnDemandlookupPassengerForm) form;

			Logger.log(PNRJ002_LookupPassengerDetailShowAction.class, Logger.LEVEL_DEBUG, "Range is : " + frm.isCheckRange());

			// initializing the list and detail; so as to assure that the 

			// previous list and details are erased 

			frm.setPnrDetail(null);

			frm.setPnrList(null);

			Logger.log(PNRJ002_OnDemandLookupPassengerSubmitAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_OnDemandLookupPassengerSubmitAction");

			ActionErrors errorException = new ActionErrors();

			ActionErrors errors = new ActionErrors();

			String link = "success";

			Logger.log(PNRJ002_OnDemandLookupPassengerSubmitAction.class, Logger.LEVEL_DEBUG, "In OnDemandLookupPassengerSubmitAction");

			Logger.log(PNRJ002_OnDemandLookupPassengerSubmitAction.class, Logger.LEVEL_DEBUG, "Passenger Name is:" + frm.getPassengerName());

			Logger.log(PNRJ002_OnDemandLookupPassengerSubmitAction.class, Logger.LEVEL_DEBUG, "Travel Date is:" + frm.getTravelDate());

			

			// format Travel Date

			frm.setTravelDate(PNRJUtil.formatDate(frm.getTravelDate()));

			Logger.log(PNRJ002_OnDemandLookupPassengerSubmitAction.class, Logger.LEVEL_DEBUG, "Formatted Travel Date = [" + frm.getTravelDate() + "]");

			/*  -------------EJB Portion----------------------

			*/	 

			EJBLookup ejbLookup = new EJBLookup();			

			PNRJ pnrjBean = null;   // Home interface

			HttpSession session = request.getSession();



			try{

				pnrjBean = ejbLookup.lookupEjb();

				ArrayList pnrList = new ArrayList();

				



				if(session.getAttribute("passengerList") != null)

				 {

					session.removeAttribute("passengerList");

				 }



				Logger.log(PNRJ002_OnDemandLookupPassengerSubmitAction.class, Logger.LEVEL_DEBUG, "calling ejb for passenger");

				//searching by passenger name so lets call the stored proc passing name and travel date

				//String flightNum, String alCode, String origin, String dest

				if (frm.isCheckRange()){

					pnrList = pnrjBean.call_name_lookup_range(frm.getPassengerName().toUpperCase(), frm.getTravelDate(), frm.getFlightNumber(), frm.getAirlineCode().toUpperCase(), frm.getOrigin().toUpperCase(), frm.getDestination().toUpperCase());

				} else {

					pnrList = pnrjBean.call_name_lookup(frm.getPassengerName().toUpperCase(), frm.getTravelDate(), frm.getFlightNumber(), frm.getAirlineCode().toUpperCase(), frm.getOrigin().toUpperCase(), frm.getDestination().toUpperCase());

				}

				//check if there was a result in the stored procedure called

				if (pnrList.isEmpty()) {

					//errors.add("listEmpty", new ActionError("error.pnrList.empty", "passengerName"));

					String parm = "Passenger Name, Travel Date";

					if(!frm.getFlightNumber().equals(null) && frm.getFlightNumber().length() != 0)

						parm = parm + ", Flight Number";

					if(!frm.getAirlineCode().equals(null) && frm.getAirlineCode().length() != 0)

						parm = parm + ", Airline Code";

					if(!frm.getOrigin().equals(null) && frm.getOrigin().length() != 0)

						parm = parm + ", Origin";

					if(!frm.getDestination().equals(null) && frm.getDestination().length() != 0)

						parm = parm + ", Destination";

					errors.add("listEmpty", new ActionError("error.pnrList.empty", parm));

				}else{		

					frm.setPnrList(pnrList); 

					frm.setShowRedisplay(true);

					session.setAttribute("passengerList", pnrList);

				}

				frm.setPnrList(pnrList);

				frm.setPnrCount(new Integer(pnrList.size()).toString());

				// added ann

				frm.setSelPnrCrtnDate(frm.getSelPnrCrtnDate());

				frm.setSelPnrLoctrNum(frm.getSelPnrLoctrNum());

		

			} 

			catch (Exception e) {

				Logger.log(PNRJ002_OnDemandLookupPassengerSubmitAction.class, Logger.LEVEL_ERROR, e.getMessage());

				errorException.add(ActionErrors.GLOBAL_ERROR, new ActionError("pnr.general.exception", e.getMessage()));

				saveErrors(request, errorException);

				link="failure";

				e.printStackTrace();

			}



			if(!errorException.isEmpty() || !errors.isEmpty()){

				   if(link.equals("failure")){

						 saveErrors(request, errorException);

				   } else {

						 saveErrors(request, errors);

				   }

			 }

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "link["+ link +"]");

			return mapping.findForward(link);				

	}



	

}

