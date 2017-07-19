/*

 * Created on Dec 12, 2005

 *

 * To change the template for this generated file go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

package com.delta.SPLJ.actions;



import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.PRA.SPLJ.data.SPLData;
import com.delta.PRA.SPLJ.data.SPLSelectedData;
import com.delta.SPLJ.forms.SPLJ001_OnDemandOtherInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;
import com.nwa.PRA.logger.Logger;

import genMethods.GenMethods;



/**

 * @author Ann Yamat

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJ001_OnDemandOtherInquiryAction extends Action {

	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {

			

			SPLJ001_OnDemandOtherInquiryForm frm = (SPLJ001_OnDemandOtherInquiryForm) form;

			EJBLookup ejbLookup = new EJBLookup();

			SPLJ spljBean = null;

			if (request.getParameter("pnrLoc") != null){

				frm.setPnrLocator(request.getParameter("pnrLoc"));

			}

			try {

				spljBean = ejbLookup.lookupEjb();

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "ROWSELECTED --> " + frm.getRowSelected());

				String flightNumber = frm.getFlightNumber().trim().toUpperCase();

				String localDepartureDate = "";

				localDepartureDate = frm.getLocalDepartureDate().trim().toUpperCase();

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

						//Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "depDate:" + );

						String SeltimeStampString = frm.getSeltimeStampString();
						 java.sql.Timestamp timeStamp1 = GenMethods.convertStringToTimestamp(SeltimeStampString);//frm.getSeltimeStampString());
						
						 detailList=spljBean.call_selected_record_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum, timeStamp1  );

						SPLSelectedData detData = (SPLSelectedData)detailList.get(0);
//on demand begin
						frm.setTimeStampString(detData.getTimeStamp().toString());

// on  demand end
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

						frm.setTktNumber(detData.getTicketNumber());

						frm.setFrequentFlierTier(detData.getFrequentFlierTier());
					
						frm.setTimeStamp(detData.getTimeStamp());
						
						//Timestamp timeStamp = frm.getTimeStamp();

						ArrayList remList = spljBean.call_selected_record_remarks_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum,timeStamp1 );



						try {

							detData = (SPLSelectedData)remList.get(0);

							frm.setRemList(remList);

						} catch (Exception e) {

						}

						frm.setSsr(detData.getSsrCde());

						

							

						// calling query for scroll list so that select list will be present in form.

						//selectList = spljBean.call_waitlist_inquiry_lookup(frm.getAirlineCode().trim(), frm.getFlightNumber(),SPLJUtil.formatDate(frm.getLocalDepartureDate().trim()),frm.getPassengerName().trim(),frm.getPnrLocator().trim());

						//Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "before setting to form select List .size= -->" + selectList.size());

						frm.setFlagList("true");

						frm.setSelectList(selectList);

							

					}else if(frm.getSelectList().size()==1){

						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "rowlist is equal to one");  

						SPLData dataList = (SPLData)frm.getSelectList().get(0);

						String airlineCode = dataList.getAirlineCode();

						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "airlineCode --> " + airlineCode);

						localDepartureDate = dataList.getLocalDepartureDate().trim();

						flightNumber = dataList.getFlightNumber().trim(); 

						String legOrigApCode = dataList.getLegOrigApCode().trim();

						String seqNum = dataList.getSeqNum();

						String rowSeat = dataList.getSeatAssignment();

						String pnrNum=dataList.getPnrLocator().trim();
////////on demand begin
						

						Timestamp timeStamp = dataList.getTimeStamp();
						
						
			//on demand end			
						detailList = spljBean.call_selected_record_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum, timeStamp );

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

						

						//Business wanted to display FF id, FF desc, Tkt number and 

						//Hari somagatta	04/26/2011

						frm.setFrequentFlierId(detData.getFrequentFlierId());

						frm.setFrequentFlierAirline(detData.getFrequentFlierAirline());

						frm.setTktNumber(detData.getTicketNumber());

						frm.setFrequentFlierTier(detData.getFrequentFlierTier());



						frm.setSelRowSeat(detData.getSelRowSeat());

						frm.setSelPassenger(detData.getSelPassenger());

						frm.setTimeStamp(detData.getTimeStamp());
						
						//Timestamp timeStamp = dataList.getTimeStamp();
						ArrayList remList = spljBean.call_selected_record_remarks_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat, pnrNum, timeStamp );



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

