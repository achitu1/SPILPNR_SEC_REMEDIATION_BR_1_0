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
import com.delta.SPLJ.forms.SPLJ001_PassengerInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.delta.SPLJ.helper.SPLJUtil;
import com.nwa.PRA.logger.Logger;

/**
 * @author Ann Yamat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SPLJ001_PassengerInquiryAction extends Action {
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
			SPLJ001_PassengerInquiryForm frm = (SPLJ001_PassengerInquiryForm) form;

			EJBLookup ejbLookup = new EJBLookup();
			SPLJ spljBean = null;
			if (request.getParameter("paxNme") != null){
				frm.setPassengerName(request.getParameter("paxNme"));
			}
			if (request.getParameter("lclDepDte") != null){
				frm.setLocalDepartureDate(request.getParameter("lclDepDte"));
			}
			try {
				spljBean = ejbLookup.lookupEjb();
				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());
				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "ROWSELECTED --> " + frm.getRowSelected());
				
				String flightNumber = frm.getFlightNumber().trim().toUpperCase();
				String localDepartureDate = SPLJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase());
				frm.setLocalDepartureDate(PNRJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()));
				ArrayList selectList = new ArrayList();
				ArrayList detailList = new ArrayList();
				
				
				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "flightNumber --> " + flightNumber);
				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "localDepartureDate --> " + localDepartureDate);
				frm.setFlagList("false");

				try{
					if(frm.getRowSelected().equals("true")){
						String airlineCode = frm.getSelAirlineCode().trim().toUpperCase();
						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "airlineCode --> " + airlineCode);
						String legOrigApCode = frm.getSelLegOrigApCode().trim();
						String seqNum = frm.getSelSeqNum().trim();
						String rowSeat = frm.getSelRowSeat().trim();
						String pnrNum = frm.getSelPnr().trim();
						detailList=spljBean.call_selected_record_lookup(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum );
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
						//System.out.println("In Action class PassengerInquiry CancelInd 1:" + detData.getCnclInd());
						
						//Business wanted to display FF id, FF desc, Tkt number and 
						//Hari somagatta	04/26/2011
						frm.setFrequentFlierId(detData.getFrequentFlierId());
						frm.setFrequentFlierAirline(detData.getFrequentFlierAirline());
						frm.setTicketNumber(detData.getTicketNumber());
						frm.setFrequentFlierTier(detData.getFrequentFlierTier());

						ArrayList remList = spljBean.call_selected_record_remarks_lookup(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum );

						try {
							detData = (SPLSelectedData)remList.get(0);
							frm.setRemList(remList);
						} catch (Exception e) {
						}
						frm.setSsr(detData.getSsrCde());
						frm.setFlagList("true");
						frm.setSelectList(new ArrayList());
						
					}else if(frm.getSelectList().size()==1){
						
						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "rowlist is equal to one");  
						SPLData dataList = (SPLData)frm.getSelectList().get(0);
						localDepartureDate = dataList.getLocalDepartureDate().trim();
						flightNumber = dataList.getFlightNumber().trim(); 
						String airlineCode = dataList.getAirlineCode().trim();
						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "airlineCode --> " + airlineCode);
						String legOrigApCode = dataList.getLegOrigApCode().trim();
						String seqNum = dataList.getSeqNum();
						String rowSeat = dataList.getSeatAssignment();
						String pnrNum=dataList.getPnrLocator().trim();
						detailList = spljBean.call_selected_record_lookup(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum );
						SPLSelectedData detData= (SPLSelectedData)detailList.get(0);

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
						//System.out.println("In Action class PassengerInquiry CancelInd 2:" + detData.getCnclInd());
						
						//Business wanted to display FF id, FF desc, Tkt number and 
						//Hari somagatta	04/26/2011
						frm.setFrequentFlierId(detData.getFrequentFlierId());
						frm.setFrequentFlierAirline(detData.getFrequentFlierAirline());
						frm.setTicketNumber(detData.getTicketNumber());
						frm.setFrequentFlierTier(detData.getFrequentFlierTier());

						frm.setSelRowSeat(detData.getSelRowSeat());
						frm.setSelPassenger(detData.getSelPassenger());

						ArrayList remList = spljBean.call_selected_record_remarks_lookup(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum );

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
				}catch(NullPointerException npe){
					Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "caught null pointer");
				}	
			}catch(Exception e){
			}
		return mapping.findForward("success");
	}
}
