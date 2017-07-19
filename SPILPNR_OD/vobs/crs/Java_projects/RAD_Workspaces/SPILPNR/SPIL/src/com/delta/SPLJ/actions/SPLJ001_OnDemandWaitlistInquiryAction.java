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



import com.delta.PNRJ.helper.PNRJUtil;

import com.delta.PRA.SPLJ.EJB.SPLJ;

import com.delta.PRA.SPLJ.data.SPLData;

import com.delta.PRA.SPLJ.data.SPLSelectedData;

import com.delta.SPLJ.forms.SPLJ001_OnDemandWaitlistInquiryForm;
import com.delta.SPLJ.helper.EJBLookup;

import com.nwa.PRA.logger.Logger;

import genMethods.GenMethods;



/**

 * @author Ann Yamat

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJ001_OnDemandWaitlistInquiryAction extends Action {

	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {



			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "Inside Waitlist Inquiry Action OD");		

			SPLJ001_OnDemandWaitlistInquiryForm frm = (SPLJ001_OnDemandWaitlistInquiryForm) form;

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
			if (request.getParameter("seltimeStampString") != null){

				frm.setSeltimeStampString(request.getParameter("seltimeStampString"));

			}
			if (request.getParameter("seltimeStampString") == null){

				frm.setSeltimeStampString(null);

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
						String SeltimeStampString = frm.getSeltimeStampString();
						System.out.println("SeltimeStampString: " + SeltimeStampString);
						 java.sql.Timestamp timeStamp1 = GenMethods.convertStringToTimestamp(SeltimeStampString);//frm.getSeltimeStampString());						//on demand end

							detailList=spljBean.call_selected_record_lookup_waitlist_OD(frm.getSelDepartureDate().trim(),frm.getSelAirlineCode().trim(),frm.getSelFlightNumber().trim(),frm.getSelPassenger().trim(),frm.getSelPnr().trim(), timeStamp1);


						if(detailList.size()<1){
							System.out.println("detailList.size()<1");
							ArrayList passengerList = spljBean.call_passenger_lookup_waitlist_OD(frm.getSelDepartureDate().trim(),frm.getSelAirlineCode().trim(),frm.getSelFlightNumber().trim(),frm.getSelPnr().trim(), timeStamp1); 
							frm.setSeltimeStampString(SeltimeStampString);
							if(passengerList.size()<1){
								frm.setSeltimeStampString(SeltimeStampString);

								frm.setRowSelected("false");

								//set a variable for checking in jsp if there are no records from query i

								frm.setSelRowSeat("false");

								return mapping.findForward("success");

							}else{
								frm.setSeltimeStampString(SeltimeStampString);

								frm.setFlagLookup("true");

								Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "flag lookup = true");

								Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "selectList size-->"+selectList.size());

								//On Demand timestamp added
								frm.setSeltimeStampString(SeltimeStampString);
								//On Demand timestamp ends
								frm.setSelAirlineCode(frm.getSelAirlineCode());

								frm.setSelDepartureDate(frm.getSelDepartureDate());

								frm.setSelFlightNumber(frm.getSelFlightNumber());

								frm.setSelPnr(frm.getSelPnr());		

								frm.setSelWaitlistNum(frm.getSelWaitlistNum());	

								frm.setRowSelected("false");				

							}

						}else{
							frm.setSeltimeStampString(SeltimeStampString);

							SPLSelectedData detData = (SPLSelectedData)detailList.get(0);

	//on demand begin
							//on demand begin
			//				frm.setTimeStampString(detData.getTimeStamp().toString());

	// on  demand end
						//	frm.setTimeStamp(detData.getTimeStamp());
							//on demand end

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
// on demand changes begin						
							frm.setTimeStamp(detData.getTimeStamp());
							frm.setTimeStampString(detData.getTimeStamp().toString());

//on demand changes end
							System.out.println("<In On Demand Waitlist Inquiry Action-call_selected_record_remarks_lookup_OD>");
						//	Timestamp timeStamp = frm.getTimeStamp();
//on demand changes end		
							System.out.println("Timestamp1: "+timeStamp1);
							ArrayList remList = spljBean.call_selected_record_remarks_lookup_OD(detData.getDepDate().trim(), frm.getSelAirlineCode().trim(), frm.getSelFlightNumber().trim(), detData.getSelLegOrigApCode().trim(),detData.getSelSeqNum().trim(),detData.getSelRowSeat().trim(),frm.getPnr().trim(), timeStamp1);

	

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

						detailList=spljBean.call_selected_record_lookup_waitlist_OD(tempList.getWaitlistLocalDepartureDate().trim(),tempList.getAirlineCode().trim(),tempList.getWaitlistFlightNumber().trim(),tempList.getWaitlistName().trim(),tempList.getWaitlistPNRLocator().trim(), tempList.getTimeStamp());

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
							
							//on demand changes begin
							frm.setTimeStamp(detData.getTimeStamp());

							Timestamp timeStamp = frm.getTimeStamp();
							ArrayList remList = spljBean.call_selected_record_remarks_lookup_OD(detData.getDepDate().trim(), tempList.getAirlineCode().trim(), tempList.getWaitlistFlightNumber().trim(), detData.getSelLegOrigApCode().trim(),detData.getSelSeqNum().trim(),detData.getSelRowSeat().trim(),detData.getPnr().trim(), timeStamp);

						
							//on demand changes end

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

