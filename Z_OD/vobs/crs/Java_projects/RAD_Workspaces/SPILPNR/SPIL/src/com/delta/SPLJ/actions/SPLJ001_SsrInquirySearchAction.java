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
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PNRJ.helper.PNRJUtil;
import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.SPLJ.forms.SPLJ001_SsrInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.delta.SPLJ.helper.SPLJUtil;
import com.nwa.PRA.logger.Logger;

/**
 * @author 
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SPLJ001_SsrInquirySearchAction extends Action {

	private HttpSession session;

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, " ---Start of SPLJ001_SsrInquirySearchAction--- ");

			String link = "success";
			ActionErrors errors = new ActionErrors();

			SPLJ001_SsrInquiryForm frm = (SPLJ001_SsrInquiryForm) form;

			EJBLookup ejbLookup = new EJBLookup();
			SPLJ spljBean = null;
			
			int listSize = 0;
			
			try {
				spljBean = ejbLookup.lookupEjb();
				
				ArrayList selectList = new ArrayList();
				
				String airlineCode = frm.getAirlineCode().trim().toUpperCase();
				String flightNumber = frm.getFlightNumber().trim().toUpperCase();
				String localDepartureDate = SPLJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase());
				String ssrCode = frm.getSsrCode();
				frm.setLocalDepartureDate(PNRJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()));
				selectList = spljBean.call_ssr_inquiry_lookup(localDepartureDate, airlineCode, flightNumber, ssrCode);
				listSize = selectList.size();
				
				if(listSize > 0){
					frm.setSelectList(selectList);
					frm.setPnrCount(new Integer (selectList.size()).toString());
					if(frm.getDownload() != null && frm.getDownload().equals("true")){
						link = "excel";
					}
				}else{
					link = "noRecords";
				}
				
				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "selectList size: "+listSize);
				
			} catch (Exception e) {
				Logger.log(this.getClass(), Logger.LEVEL_ERROR, e.getMessage());
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("spl.general.exception", e.getMessage()));
				saveErrors(request, errors);
				//e.printStackTrace();
			}

			return mapping.findForward(link);
	}
}
