/*

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
import com.delta.SPLJ.forms.SPLJ001_OnDemandFlightInquiryForm;
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

public class SPLJ001_OnDemandFlightInquiryAction extends Action {






	public ActionForward execute(

		ActionMapping mapping,

		ActionForm form,

		HttpServletRequest request,

		HttpServletResponse response)

		throws Exception {

		

			

		SPLJ001_OnDemandFlightInquiryForm frm = (SPLJ001_OnDemandFlightInquiryForm) form;

					

					EJBLookup ejbLookup = new EJBLookup();

					SPLJ spljBean = null;

							

					try {


						spljBean = ejbLookup.lookupEjb();

						if (request.getParameter("alCde") != null){

							frm.setAirlineCode(request.getParameter("alCde"));

						}

						if (request.getParameter("fltNum") != null){

							frm.setFlightNumber(request.getParameter("fltNum"));

						}

						if (request.getParameter("lclDepDte") != null){

							frm.setLocalDepartureDate(request.getParameter("lclDepDte"));

						}

						if (request.getParameter("depAirport") != null){

							frm.setLocalDepartureDate(request.getParameter("depAirport"));

						}

					
						

					//	Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "testing --> " + spljBean.getTestMessage());

			//			Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "ROWSELECTED --> " + frm.getRowSelected());

						String airlineCode = frm.getAirlineCode()!=null?frm.getAirlineCode().trim().toUpperCase():"";

						String flightNumber = frm.getFlightNumber()!=null?frm.getFlightNumber().trim().toUpperCase():"";

						String localDepartureDate = frm.getLocalDepartureDate()!=null?SPLJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()):"";

						frm.setLocalDepartureDate(frm.getLocalDepartureDate()!=null?PNRJUtil.formatDate(frm.getLocalDepartureDate().trim().toUpperCase()):"");
						
						String departureAirport = frm.getDepartureAirport()!=null?frm.getDepartureAirport().trim().toUpperCase():"";
						/////////////// On Demand begin
				//		String seltimeStampString = frm.getSeltimeStampString();
						// on demand changes begin
					//	Timestamp timeStamp = frm.getTimeStamp();
						java.sql.Timestamp timeStamp = null; //frm.getTimeStamp();
						// on demand changes end


						//ArrayList selectList = new ArrayList();

						ArrayList detailList = new ArrayList();

						frm.setFlagList("false");						

						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "airlineCode --> " + airlineCode);

						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "flightNumber --> " + flightNumber);

						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "localDepartureDate --> " + localDepartureDate);
						
						Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "departureAirport --> " + departureAirport);
						
				//		Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "Timestamp --> " + timeStamp);

						
				//		SimpleDateFormat  dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss.fff");
						
				//		Date spilDate = new Date();
						
			//			String onDemandDate = dateFormat.format(spilDate);
						
				//		frm.setDisplayMessage("DL SPILs on demand for " + onDemandDate );

						try{

							if(frm.getRowSelected().equals("true")){

								String legOrigApCode = frm.getSelLegOrigApCode().trim();

								String seqNum = frm.getSelSeqNum().trim();

								String rowSeat = frm.getSelRowSeat().trim(); 

								String pnrNum = frm.getSelPnr().trim();

								//on demand added
						//	String	 timeStampString = frm.getSelTimeStamp();
								///////////on demand
								String SeltimeStampString = frm.getSeltimeStampString();

								
								/////////on demand
							//	 java.sql.Timestamp timeStamp1 = GenMethods.convertStringToTimestamp("2017-01-17 12:32:36.686");//frm.getSeltimeStampString());
								 java.sql.Timestamp timeStamp1 = GenMethods.convertStringToTimestamp(SeltimeStampString);//frm.getSeltimeStampString());

								 // On Demand change begins
									System.out.println("OnDemandFlightInquiryAction timeStamp = frm.getSelTimeStamp() >>>>>>>>>> "+SeltimeStampString);
									
								//on demand end

								System.out.println("In Action class FlightInquiryAction timeStamp :" + timeStamp1);


								detailList=spljBean.call_selected_record_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat, pnrNum, timeStamp1);

								SPLSelectedData detData = (SPLSelectedData)detailList.get(0);

								//On Demand changes begin 8/20/16
																
								frm.setTimeStamp(detData.getTimeStamp());
								///////
								frm.setTimeStampString(detData.getTimeStamp().toString());
								///////

								//On Demand changes ends 8/20/16

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



								ArrayList remList = spljBean.call_selected_record_remarks_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat,pnrNum, timeStamp1 );

								Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "remList size-->"+ remList.size());
								

								try{

									Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "inside try setting remList");

									detData = (SPLSelectedData)remList.get(0);

									frm.setRemList(remList);

									Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "remList form size-->"+ frm.getRemList().size());

								}catch(Exception e){

								}

								

								frm.setSsr(detData.getSsrCde());

								frm.setFlagList("true");

								frm.setSelectList(new ArrayList());
								

							}else if(frm.getSelectList().size()==1){

								Logger.log(this.getClass(), Logger.LEVEL_DEBUG, "rowlist is equal to one");  

								SPLData dataList = (SPLData)frm.getSelectList().get(0);
								
								// On Demand change begins
								timeStamp = dataList.getTimeStamp();
								// On Demand change ends
								localDepartureDate = dataList.getLocalDepartureDate().trim();

								flightNumber = dataList.getFlightNumber().trim(); 

								String legOrigApCode = dataList.getLegOrigApCode().trim();

								String seqNum = dataList.getSeqNum();

								String rowSeat = dataList.getSeatAssignment();

								String pnrNum=dataList.getPnrLocator().trim();


								//System.out.println("In Action class FlightInquiryAction PNRNUM 2 :" + pnrNum);

								//On Demand changes begin 7/21/16

								detailList = spljBean.call_selected_record_lookup_OD(localDepartureDate, airlineCode, flightNumber, legOrigApCode, seqNum, rowSeat, pnrNum, timeStamp );

								//On Demand changes begin 7/21/16

								SPLSelectedData detData= (SPLSelectedData)detailList.get(0);

								//on demand changes begin
								frm.setTimeStamp(detData.getTimeStamp());
								System.out.println("Timestamp " +timeStamp);
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

							//on demand changes added
								frm.setSelTimeStamp(detData.getSelTimeStamp());
								//on demand changes end
	

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

						e.printStackTrace();

					}

								

		return mapping.findForward("success");

	}

}

