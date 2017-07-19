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

import com.delta.PNRJ.helper.PNRJUtil;
import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.SPLJ.forms.SPLJ001_OnDemandPassengerInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.delta.SPLJ.helper.SPLJUtil;
import com.nwa.PRA.logger.Logger;



/**

 * @author Ann Yamat

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJ001_OnDemandPassengerInquirySubmitAction extends Action {

	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {

		

		String link = "success";

		ActionErrors errors = new ActionErrors();

		SPLJ001_OnDemandPassengerInquiryForm frm = (SPLJ001_OnDemandPassengerInquiryForm) form;

		

		String passengerName = frm.getPassengerName().trim().toUpperCase();

		String localDepartureDate = SPLJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase());

		frm.setLocalDepartureDate(PNRJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()));

		ArrayList selectList = new ArrayList();

		

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "passengerName --> " + passengerName);

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "localDepartureDate --> " + localDepartureDate);

		

		EJBLookup ejbLookup = new EJBLookup();

		SPLJ spljBean = null;



		try {

			spljBean = ejbLookup.lookupEjb();

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());

			

			selectList = spljBean.call_passenger_inquiry_lookup_OD(passengerName, localDepartureDate);

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "selectList size x--> " + selectList.size());

			



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

