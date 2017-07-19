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



import com.delta.PNRJ.helper.PNRJUtil;

import com.delta.PRA.SPLJ.EJB.SPLJ;

import com.delta.PRA.SPLJ.data.SPLSelectedData;

import com.delta.SPLJ.forms.SPLJ001_OnDemandSsrInquiryForm;
import com.delta.SPLJ.forms.SPLJ001_SsrInquiryForm;

import com.delta.SPLJ.helper.EJBLookup;

import com.delta.SPLJ.helper.SPLJUtil;

import com.nwa.PRA.logger.Logger;

import genMethods.GenMethods;



/**

 * @author Ann Yamat

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJ001_OnDemandSsrInquiryRowSelectedAction extends Action {

	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {



		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "-----------SSR Inquiry Submit Action-------");

		String link = "success";

		ActionErrors errors = new ActionErrors();

		SPLJ001_OnDemandSsrInquiryForm frm = (SPLJ001_OnDemandSsrInquiryForm) form;



		

		EJBLookup ejbLookup = new EJBLookup();

		SPLJ spljBean = null;

		

		ArrayList detailList = new ArrayList();



		try {

			spljBean = ejbLookup.lookupEjb();



			String airlineCode = frm.getAirlineCode().trim().toUpperCase();

			String flightNumber = frm.getFlightNumber().trim().toUpperCase();

			String localDepartureDate = SPLJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase());

			frm.setLocalDepartureDate(PNRJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()));

			String legOrigApCode = frm.getSelLegOrigApCode().trim();

			String seqNum = frm.getSelSeqNum().trim();

			String rowSeat = frm.getSelRowSeat().trim(); 

			String pnrNum = frm.getSelPnr().trim();
			//On Demand changes begin

			String SeltimeStampString = frm.getSeltimeStampString();
			 java.sql.Timestamp timeStamp1 = GenMethods.convertStringToTimestamp(SeltimeStampString);//frm.getSeltimeStampString());

			detailList=spljBean.call_selected_record_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum, timeStamp1 );

			SPLSelectedData detData = (SPLSelectedData)detailList.get(0);
			frm.setTimeStampString(detData.getTimeStamp().toString());
			frm.setTimeStamp(detData.getTimeStamp());

			//On Demand changes end
			


			frm.setFlightNum(detData.getFlightNum());

			frm.setDepDate(detData.getDepDate());

			frm.setBoardPoint(detData.getBoardPoint());

			frm.setOffPoint(detData.getOffPoint());

			frm.setPnr(detData.getPnr());

			frm.setClass1(detData.getClass1());

			frm.setBookedClass(detData.getBookedClass());

			frm.setFlownClass(detData.getFlownClass());

			frm.setType(detData.getType());

			frm.setConFrom1(detData.getConFrom1());

			frm.setConFrom2(detData.getConFrom2());

			frm.setConTo1(detData.getConTo1());

			frm.setConTo2(detData.getConTo2());

			

			frm.setCustomerID(detData.getCustomerID());

			frm.setPnrCreateDate(detData.getPnrCreateDate());

			frm.setTicketIssueDate(detData.getTicketIssueDate());

			frm.setCheckinDate(detData.getCheckinDate());

			frm.setCheckinTime(detData.getCheckinTime());

			frm.setOnBoardDate(detData.getOnBoardDate());

			frm.setOnBoardTime(detData.getOnBoardTime());

			frm.setCnclInd(detData.getCnclInd());

			

			frm.setTicketNumber(detData.getTicketNumber());

			frm.setFrequentFlierAirline(detData.getFrequentFlierAirline());

			frm.setFrequentFlierId(detData.getFrequentFlierId());

			frm.setFrequentFlierTier(detData.getFrequentFlierTier());

			

			//Added by Hari Somagatta - 04-27-2011	

			ArrayList remList = spljBean.call_selected_record_remarks_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum, timeStamp1 );

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "remList size-->"+ remList.size());

			try{

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "inside try setting remList");

				detData = (SPLSelectedData)remList.get(0);

				frm.setRemList(remList);

				frm.setSsr(detData.getSsrCde());

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "remList form size-->"+ frm.getRemList().size());

			}catch(Exception e){

				Logger.log(this.getClass(), Logger.LEVEL_ERROR, e.getMessage());

				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("spl.general.exception", e.getMessage()));

				saveErrors(request, errors);

			}

			//END



		} catch (Exception e) {

			Logger.log(this.getClass(), Logger.LEVEL_ERROR, e.getMessage());

			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("spl.general.exception", e.getMessage()));

			saveErrors(request, errors);

			//e.printStackTrace();

		}



		return mapping.findForward(link);

	}

}

