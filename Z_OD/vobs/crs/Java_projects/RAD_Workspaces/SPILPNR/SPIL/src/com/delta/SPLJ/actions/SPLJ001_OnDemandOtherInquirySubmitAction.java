/*

 * Created on Dec 12, 2005

 *

 * To change the template for this generated file go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

package com.delta.SPLJ.actions;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.SPLJ.forms.SPLJ001_OnDemandOtherInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.nwa.PRA.logger.Logger;



/**

 * @author Ann Yamat

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJ001_OnDemandOtherInquirySubmitAction extends Action {

	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {



		String link = "success";

		ActionErrors errors = new ActionErrors();

		SPLJ001_OnDemandOtherInquiryForm frm = (SPLJ001_OnDemandOtherInquiryForm) form;



		String ticketNumber = frm.getTicketNumber().trim().toUpperCase();

		String pnrLocator = frm.getPnrLocator().trim().toUpperCase();

		String governmentId = frm.getGovernmentId().trim().toUpperCase();

		ArrayList selectList = new ArrayList();

		

		

		



		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "ticketNumber --> " + ticketNumber);

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "pnrLocator --> " + pnrLocator);

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "governmentId --> " + governmentId);

		

		if ((ticketNumber.length()==0)&&(pnrLocator.length()==0)&&(governmentId.length()==0)){

			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.other.query.fields"));	

			saveErrors(request, errors);

			return mapping.findForward(link);

		}else if(ticketNumber.length()>0){

			if((pnrLocator.length()>0)||(governmentId.length()>0)){

				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.other.query.fields2"));	

				saveErrors(request, errors);

				return mapping.findForward(link);

			}

		}else if (pnrLocator.length()>0){

			if(governmentId.length()>0){

				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.other.query.fields2"));	

				saveErrors(request, errors);

				return mapping.findForward(link);

			}

		}

		

		EJBLookup ejbLookup = new EJBLookup();

		SPLJ spljBean = null;



		try {

			spljBean = ejbLookup.lookupEjb();

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());



			selectList =

				spljBean.call_other_inquiry_lookup_OD(

					ticketNumber,

					pnrLocator,

					governmentId);

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "selectList size --> " + selectList.size());



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

		

		if("true".equals(frm.getDownload())){

			link="excel";

		}

		

		return mapping.findForward(link);

	}

}

