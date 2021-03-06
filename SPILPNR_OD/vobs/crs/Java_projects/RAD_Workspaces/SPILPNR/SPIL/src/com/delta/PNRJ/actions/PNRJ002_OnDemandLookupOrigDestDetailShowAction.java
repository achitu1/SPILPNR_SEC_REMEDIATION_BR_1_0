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



public class PNRJ002_OnDemandLookupOrigDestDetailShowAction extends Action{

	

	public ActionForward execute(ActionMapping mapping, 

								ActionForm form, 

								HttpServletRequest request, 

								HttpServletResponse response) 

			throws Exception{



			PNRJ002_OnDemandlookupOrigDestForm frm = (PNRJ002_OnDemandlookupOrigDestForm) form;

			Logger.log(PNRJ002_OnDemandLookupOrigDestDetailShowAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_OnDemandLookupOrigDestDetailShowAction");

			ActionErrors errorException = new ActionErrors();

			ActionErrors errors = new ActionErrors();

			String link = "success";

			/*  -------------EJB Portion----------------------

			*/	 

			EJBLookup ejbLookup = new EJBLookup();			

			PNRJ pnrjBean = null;   // Home interface

			

			try{

				pnrjBean = ejbLookup.lookupEjb();



				String pnrLoctr = frm.getSelPnrLoctrNum();

				String pnrCrtnDte = frm.getSelPnrCrtnDate();



				//get PNR text

				//String pnrTextList = pnrjBean.call_pnrText_lookup(pnrLoctr, pnrCrtnDte);

				String pnrTextString = pnrjBean.call_pnrText_lookup(pnrLoctr, pnrCrtnDte);

				ArrayList pnrTextList = new ArrayList();

				ArrayList pnrList = new ArrayList();

								

				//check if there was a result in the stored procedure called

				if (pnrTextString.length()==0 || pnrTextString==null) {

					errors.add("listEmpty", new ActionError("error.pnrText.empty"));

					pnrList = pnrjBean.call_origdest_lookup(frm.getOrigin().toUpperCase(), frm.getDestination().toUpperCase(), frm.getTravelDate(), frm.getPassengerName().toUpperCase(), frm.getAirlineCode().toUpperCase(), frm.getFlightNumber());

					frm.setPnrList(pnrList);

				} else {

					int pnrLines = pnrTextString.length()%133 == 0 ? pnrTextString.length()/133 : pnrTextString.length()/133 + 1;

					int posLoc = 0;

					pnrTextList.addAll(PNRJUtil.getPNRText2Display(pnrLines, pnrTextString));

					if (pnrTextList.size()> 0){

						String lineOne = (String) pnrTextList.get(0);

						if (lineOne.contains("***PNR HAS MORE THAN 1000 LINES, DISPLAYING FIRST 1000 LINES ONLY.")){

							frm.setOver1000Lines("<A HREF='/SPIL/LongPNRRetriever'>Email PNR</a>");

						}

					}


					frm.setShowRedisplay(frm.isShowRedisplay());			

				}

				

				frm.setPnrTextList(pnrTextList);

	

			} 

			 catch (Exception e) {

				Logger.log(PNRJ002_OnDemandLookupOrigDestDetailShowAction.class, Logger.LEVEL_ERROR, e.getMessage());

				errorException.add(ActionErrors.GLOBAL_ERROR, 

				new ActionError("string.message",e.getMessage()));

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

