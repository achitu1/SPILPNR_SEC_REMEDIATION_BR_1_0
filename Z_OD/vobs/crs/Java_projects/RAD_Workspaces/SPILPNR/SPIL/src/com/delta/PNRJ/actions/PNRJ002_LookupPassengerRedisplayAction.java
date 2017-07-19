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

import com.delta.PNRJ.forms.PNRJ002_lookupPassengerForm;
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
 * 
 */

public class PNRJ002_LookupPassengerRedisplayAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, 
								ActionForm form, 
								HttpServletRequest request, 
								HttpServletResponse response) 
			throws Exception{
			PNRJ002_lookupPassengerForm frm = (PNRJ002_lookupPassengerForm) form;
			// initializing the list and detail; so as to assure that the 
			// previous list and details are erased 
			Logger.log(PNRJ002_LookupPassengerDetailShowAction.class, Logger.LEVEL_DEBUG, "Range is : " + frm.isCheckRange());
			frm.setPnrDetail(null);
			frm.setPnrList(null);
			Logger.log(PNRJ002_LookupPassengerRedisplayAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_LookupPassengerRedisplayAction");
			ActionErrors errorException = new ActionErrors();
			ActionErrors errors = new ActionErrors();
			String link = "success";

			
			// format Travel Date
			frm.setTravelDate(PNRJUtil.formatDate(frm.getTravelDate()));
			Logger.log(PNRJ002_LookupPassengerRedisplayAction.class, Logger.LEVEL_DEBUG, "Formatted Travel Date = [" + frm.getTravelDate() + "]");
			
			/*  -------------EJB Portion----------------------
			*/	 
			EJBLookup ejbLookup = new EJBLookup();			
			PNRJ pnrjBean = null;   // Home interface
			HttpSession session = request.getSession();
			 	
			try{
				pnrjBean = ejbLookup.lookupEjb();
				ArrayList pnrList = new ArrayList();
				
				Logger.log(PNRJ002_LookupPassengerRedisplayAction.class, Logger.LEVEL_DEBUG, "calling ejb for passenger");
				//searching by passenger name so lets call the stored proc passing name and travel date
				//String flightNum, String alCode, String origin, String dest

				if(session.getAttribute("passengerList") == null)
				 {
					if (frm.isCheckRange()){
						pnrList = pnrjBean.call_name_lookup_range(frm.getPassengerName().toUpperCase(), frm.getTravelDate(), frm.getFlightNumber(), frm.getAirlineCode().toUpperCase(), frm.getOrigin().toUpperCase(), frm.getDestination().toUpperCase());
					} else {
						pnrList = pnrjBean.call_name_lookup(frm.getPassengerName().toUpperCase(), frm.getTravelDate(), frm.getFlightNumber(), frm.getAirlineCode().toUpperCase(), frm.getOrigin().toUpperCase(), frm.getDestination().toUpperCase());
					}
				 }
				else
				 {
					 pnrList = (ArrayList) session.getAttribute("passengerList");
				 }


				frm.setPnrList(pnrList); 
				frm.setShowRedisplay(true);
				session.setAttribute("passengerList", pnrList);
				frm.setPnrList(pnrList);
				frm.setPnrCount(new Integer(pnrList.size()).toString());
				// added ann
				frm.setSelPnrCrtnDate(frm.getSelPnrCrtnDate());
				frm.setSelPnrLoctrNum(frm.getSelPnrLoctrNum());
		
			} 
			catch (Exception e) {
				Logger.log(PNRJ002_LookupPassengerRedisplayAction.class, Logger.LEVEL_ERROR, e.getMessage());
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
