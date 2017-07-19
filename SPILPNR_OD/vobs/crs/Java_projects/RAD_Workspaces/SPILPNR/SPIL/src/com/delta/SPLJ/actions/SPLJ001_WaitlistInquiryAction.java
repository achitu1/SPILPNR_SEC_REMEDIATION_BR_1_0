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
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PNRJ.helper.PNRJUtil;
import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.PRA.SPLJ.data.SPLData;
import com.delta.PRA.SPLJ.data.SPLSelectedData;
import com.delta.SPLJ.forms.SPLJ001_WaitlistInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.delta.SPLJ.helper.SPLJUtil;
import com.nwa.PRA.logger.Logger;

/**
 * @author Ann Yamat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SPLJ001_WaitlistInquiryAction extends Action {
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "Inside Waitlist Inquiry Action");		
			SPLJ001_WaitlistInquiryForm frm = (SPLJ001_WaitlistInquiryForm) form;
			EJBLookup ejbLookup = new EJBLookup();
			SPLJ spljBean = null;
			if (request.getParameter("alCde") != null){
				frm.setAirlineCode(request.getParameter("alCde"));
			}
			if (request.getParameter("fltNum") != null){
				frm.setFlightNumber(request.getParameter("fltNum"));
			}
			if (request.getParameter("lclDepDte") != null){
				frm.setLocalDepartureDate(request.getParameter("lclDepDte"));
			}
			if (request.getParameter("paxNme") != null){
				frm.setPassengerName(request.getParameter("paxNme"));
			}
			if (request.getParameter("pnrLoc") != null){
				frm.setPnrLocator(request.getParameter("pnrLoc"));
			}
			try {
				spljBean = ejbLookup.lookupEjb();
				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());
				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "ROWSELECTED --> " + frm.getRowSelected());

				ArrayList selectList = new ArrayList();
				ArrayList detailList = new ArrayList();
				frm.setSelRowSeat("");
				frm.setFlagList("false");
				if (frm.getLocalDepartureDate().trim().length() > 0){
					frm.setLocalDepartureDate(PNRJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()));
				}else {
					frm.setLocalDepartureDate(frm.getLocalDepartureDate().trim().toUpperCase());
				}
				
				try{
					
					if(frm.getRowSelected().equals("true")){
						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "sel pnr-->" + frm.getSelPnr());
																 
						detailList=spljBean.call_selected_record_lookup_waitlist(frm.getSelDepartureDate().trim(),frm.getSelAirlineCode().trim(),frm.getSelFlightNumber().trim(),frm.getSelPassenger().trim(),frm.getSelPnr().trim());
						if(detailList.size()<1){
							ArrayList passengerList = spljBean.call_passenger_lookup_waitlist(frm.getSelDepartureDate().trim(),frm.getSelAirlineCode().trim(),frm.getSelFlightNumber().trim(),frm.getSelPnr().trim()); 
							if(passengerList.size()<1){
								frm.setRowSelected("false");
								//set a variable for checking in jsp if there are no records from query i
								frm.setSelRowSeat("false");
								return mapping.findForward("success");
							}else{
								frm.setFlagLookup("true");
								Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "flag lookup = true");
								Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "selectList size-->"+selectList.size());
								frm.setSelAirlineCode(frm.getSelAirlineCode());
								frm.setSelDepartureDate(frm.getSelDepartureDate());
								frm.setSelFlightNumber(frm.getSelFlightNumber());
								frm.setSelPnr(frm.getSelPnr());		
								frm.setSelWaitlistNum(frm.getSelWaitlistNum());	
								frm.setRowSelected("false");				
							}
						}else{
							SPLSelectedData detData = (SPLSelectedData)detailList.get(0);
	
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
							
							//Business wanted to display FF id, FF desc, Tkt number and 
							//Hari somagatta	04/26/2011
							frm.setFrequentFlierId(detData.getFrequentFlierId());
							frm.setFrequentFlierAirline(detData.getFrequentFlierAirline());
							frm.setTicketNumber(detData.getTicketNumber());
							frm.setFrequentFlierTier(detData.getFrequentFlierTier());
							
							frm.setSelRowSeat(detData.getSelRowSeat());
							frm.setSelPassenger(detData.getSelPassenger());
							frm.setSelWaitlistNum(frm.getSelWaitlistNum());
							frm.setRowSelected("true");
							
							ArrayList remList = spljBean.call_selected_record_remarks_lookup(detData.getDepDate().trim(), frm.getSelAirlineCode().trim(), frm.getSelFlightNumber().trim(), detData.getSelLegOrigApCode().trim(),detData.getSelSeqNum().trim(),detData.getSelRowSeat().trim(),frm.getPnr().trim());
	
							try{
								detData = (SPLSelectedData)remList.get(0);
								frm.setRemList(remList);
							}catch(Exception e){
							}
							frm.setSsr(detData.getSsrCde());
							frm.setFlagList("true");
							frm.setSelectList(selectList);
						}							
					}else if(frm.getSelectList().size()==1){
						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "rowlist is equal to one");  							
						SPLData tempList = (SPLData) frm.getSelectList().get(0); 					 
						detailList=spljBean.call_selected_record_lookup_waitlist(tempList.getWaitlistLocalDepartureDate().trim(),tempList.getAirlineCode().trim(),tempList.getWaitlistFlightNumber().trim(),tempList.getWaitlistName().trim(),tempList.getWaitlistPNRLocator().trim());
						if(detailList.size()<1){
							frm.setRowSelected("false");
							frm.setSelectList(frm.getSelectList());
							return mapping.findForward("success");
						}else{
							
							SPLSelectedData detData = (SPLSelectedData)detailList.get(0);
		
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
							
							//Business wanted to display FF id, FF desc, Tkt number and 
							//Hari somagatta	04/26/2011
							frm.setFrequentFlierId(detData.getFrequentFlierId());
							frm.setFrequentFlierAirline(detData.getFrequentFlierAirline());
							frm.setTicketNumber(detData.getTicketNumber());
							frm.setFrequentFlierTier(detData.getFrequentFlierTier());
							
							
							frm.setSelRowSeat(detData.getSelRowSeat());
							frm.setSelPassenger(detData.getSelPassenger());
							frm.setSelWaitlistNum(frm.getSelWaitlistNum());
							ArrayList remList = spljBean.call_selected_record_remarks_lookup(detData.getDepDate().trim(), tempList.getAirlineCode().trim(), tempList.getWaitlistFlightNumber().trim(), detData.getSelLegOrigApCode().trim(),detData.getSelSeqNum().trim(),detData.getSelRowSeat().trim(),detData.getPnr().trim());
						
							frm.setSelRowSeat(detData.getSelRowSeat());
							frm.setSelPassenger(detData.getSelPassenger());
							
							try{
								detData = (SPLSelectedData)remList.get(0);
								frm.setRemList(remList);
							}catch(Exception e){
							}
							frm.setSsr(detData.getSsrCde());

							frm.setRowSelected("true");
							frm.setSelectList(new ArrayList());
							Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "set selectlist to empty-->" + frm.getSelectList().size());		
						}	
					 }
				}catch(NullPointerException npe){
					Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "caught null pointer");
				}	
			}catch(Exception e){
			}


		return mapping.findForward("success");
	}
}
