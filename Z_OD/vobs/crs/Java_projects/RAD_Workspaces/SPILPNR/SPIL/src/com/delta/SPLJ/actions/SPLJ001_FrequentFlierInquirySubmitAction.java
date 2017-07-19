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
import com.delta.PRA.SPLJ.data.SPLData;
import com.delta.PRA.SPLJ.data.SPLSelectedData;
import com.delta.SPLJ.forms.SPLJ001_FrequentFlierInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.nwa.PRA.logger.Logger;

/**
 * @author Ann Yamat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SPLJ001_FrequentFlierInquirySubmitAction extends Action {
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		String link = "success";
		ActionErrors errors = new ActionErrors();
		SPLJ001_FrequentFlierInquiryForm frm =
			(SPLJ001_FrequentFlierInquiryForm) form;

		String airlineCode = frm.getAirlineCode().trim().toUpperCase();
		String programId = frm.getProgramId().trim().toUpperCase();
		ArrayList selectList = new ArrayList();

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "airlineCode --> " + airlineCode);
		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "programId --> " + programId);

		EJBLookup ejbLookup = new EJBLookup();
		SPLJ spljBean = null;

		try {
			spljBean = ejbLookup.lookupEjb();
			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());

			selectList =
				spljBean.call_frequent_flier_inquiry_lookup(
					airlineCode,
					programId);
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
