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

import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionForward;

import org.apache.struts.action.ActionMapping;



import com.delta.PRA.SPLJ.EJB.SPLJ;

import com.delta.PRA.SPLJ.data.SPLData;

import com.delta.PRA.SPLJ.data.SPLSelectedData;

import com.delta.SPLJ.forms.SPLJ001_OnDemandFrequentFlierInquiryForm;

import com.delta.SPLJ.helper.EJBLookup;

import com.nwa.PRA.logger.Logger;

import genMethods.GenMethods;



/**

 * @author Ann Yamat

 *

 * To change the template for this generated type comment go to

 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments

 */

public class SPLJ001_OnDemandFrequentFlierInquiryAction extends Action {

	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {

			

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "-----OnDemandFrequentFlierInquiryAction-------");	

			SPLJ001_OnDemandFrequentFlierInquiryForm frm = (SPLJ001_OnDemandFrequentFlierInquiryForm) form;

			

			EJBLookup ejbLookup = new EJBLookup();

			SPLJ spljBean = null;

			ActionErrors errors = new ActionErrors();

			try {

				spljBean = ejbLookup.lookupEjb();

				

				if (request.getParameter("alCde") != null){

					frm.setAirlineCode(request.getParameter("alCde"));

				}

				

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "ROWSELECTED --> " + frm.getRowSelected());
				
			//	Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "TimeStamp on demand --> " + frm.getTimeStamp());


				String airlineCode = frm.getAirlineCode().trim().toUpperCase();

				String flightNumber = frm.getFlightNumber().trim().toUpperCase();

				String localDepartureDate = frm.getLocalDepartureDate().trim();

				ArrayList selectList = new ArrayList();

				ArrayList detailList = new ArrayList();

				frm.setFlagList("false");



				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "airlineCode --> " + airlineCode);

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "flightNumber --> " + flightNumber);

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "localDepartureDate --> " + localDepartureDate);



				try{

					Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "inside try");

					if(frm.getRowSelected().equals("true")){

							//Changed by Hari, to fix the issue with FF id and OP_AL_CDE 

							String opalCde = frm.getOpAlCode();

							String legOrigApCode = frm.getSelLegOrigApCode().trim();

							String seqNum = frm.getSelSeqNum().trim();

							String rowSeat = frm.getSelRowSeat().trim(); 

							String programId = frm.getProgramId().toUpperCase().trim();

							String pnrNum = frm.getSelPnr().trim();
							
					//		Timestamp timeStamp = frm.getTimeStamp();

							//detailList=spljBean.call_selected_record_lookup(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat );

							//02/11/2011 by Hari

							//On Demand changes begin

							String SeltimeStampString = frm.getSeltimeStampString();
							 java.sql.Timestamp timeStamp1 = GenMethods.convertStringToTimestamp(SeltimeStampString);//frm.getSeltimeStampString());

							detailList=spljBean.call_selected_record_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum, timeStamp1 );

							SPLSelectedData detData = (SPLSelectedData)detailList.get(0);
							frm.setTimeStampString(detData.getTimeStamp().toString());
							//On Demand changes end
							
//on demand changes begin
							frm.setTimeStamp(detData.getTimeStamp());
							frm.setTimeStampString(detData.getTimeStamp().toString());

							//on demand changes ends


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

							



							//ArrayList remList = spljBean.call_selected_record_remarks_lookup(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat );

							//02/11/2011 by Hari

							ArrayList remList = spljBean.call_selected_record_remarks_lookup_OD(localDepartureDate, opalCde, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum, timeStamp1 );



							try {

								detData = (SPLSelectedData)remList.get(0);

								frm.setRemList(remList);

							} catch (Exception e) {

							}

							frm.setSsr(detData.getSsrCde());

						frm.setFlagList("true");

						frm.setSelectList(selectList);



					}else if(frm.getSelectList().size()==1){

						    Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "rowlist is equal to one"); 

						    

							SPLData dataList = (SPLData)frm.getSelectList().get(0);

							localDepartureDate = dataList.getLocalDepartureDate().trim();

							flightNumber = dataList.getFlightNumber().trim(); 

							String legOrigApCode = dataList.getLegOrigApCode().trim();

							String seqNum = dataList.getSeqNum();

							String rowSeat = dataList.getSeatAssignment();

							String pnrNum=dataList.getPnrLocator().trim();
							
							//on demand changes begin
							Timestamp timeStamp = dataList.getTimeStamp();
							//on demand changes end

							

							//02/11/2011 by Hari

							String opalCde = frm.getOpAlCode();

							

							//detailList = spljBean.call_selected_record_lookup(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat );

							detailList = spljBean.call_selected_record_lookup_OD(localDepartureDate, opalCde, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum, timeStamp );

							SPLSelectedData detData= (SPLSelectedData)detailList.get(0);

							//on demand changes begin
							frm.setTimeStampString(dataList.getTimeStamp().toString());
							System.out.println("Timestamp String set!");
							//on demand changes end

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

					Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "selected seat and passenger-->" + frm.getSelRowSeat() + " --->" + frm.getSelPassenger());



							ArrayList remList = spljBean.call_selected_record_remarks_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum, timeStamp );

	

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

//					errors.add(

//							ActionErrors.GLOBAL_ERROR,

//							new ActionError("spl.general.exception", npe.getMessage()));

//						saveErrors(request, errors);

//						npe.printStackTrace();

				}	

			}catch(Exception e){

				Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "caught exception "+e.getMessage());

//				errors.add(

//						ActionErrors.GLOBAL_ERROR,

//						new ActionError("spl.general.exception", e.getMessage()));

//					saveErrors(request, errors);

//					e.printStackTrace();

			}



		return mapping.findForward("success");

	}

}

