package com.delta.SPLJ.onDemand.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.delta.PRA.SPLJ.EJB.SPLJ;
import com.delta.SPLJ.helper.EJBLookup;
import com.delta.SPLJ.onDemand.forms.OnDemandRequestForm;
import com.delta.common.SPILPropertyManager;
import com.delta.schemas.SpecialPassengerInfoListSI.SpecialPassengerInfoList_EPProxy;
import com.delta.schemas.SpecialPassengerInfoListSI.BusinessFault;
import com.delta.schemas.SpecialPassengerInfoListSI.OnDemandRequestInfoType;
import com.delta.schemas.SpecialPassengerInfoListSI.OnDemandRequestType;
import com.delta.schemas.SpecialPassengerInfoListSI.OnDemandResponseType;
import com.delta.schemas.SpecialPassengerInfoListSI.RequestInfoType;


/*import com.delta.schemas.SpecialPassengerInfoList.BusinessFault;
 import com.delta.schemas.SpecialPassengerInfoList.OnDemandRequestInfoType;
 import com.delta.schemas.SpecialPassengerInfoList.OnDemandRequestType;
 import com.delta.schemas.SpecialPassengerInfoList.OnDemandResponseType;
 import com.delta.schemas.SpecialPassengerInfoList.RequestInfoType;
 import com.delta.schemas.SpecialPassengerInfoList.SpecialPassengerInfoList;
 import com.delta.schemas.SpecialPassengerInfoList.SpecialPassengerInfoList_Service;
 import com.delta.soa.updated.PCiTokenManager.PciRequestInfo;*/
/*import com.delta.schemas.common.advisorymessage.v2.AdvisoryMessageType;
 import com.delta.schemas.common.requestinfo.v4.RequestInfoType;
 import com.delta.schemas.specialpassengerinfolisttypes.v1.OnDemandRequestInfoType;
 import com.delta.schemas.specialpassengerinfolisttypes.v1.OnDemandRequestType;
 import com.delta.schemas.specialpassengerinfolisttypes.v1.OnDemandResponseType;
 import com.delta.soa.specialpassengerinfolist.BusinessFault;
 import com.delta.soa.specialpassengerinfolist.SpecialPassengerInfoList;
 import com.delta.soa.specialpassengerinfolist.SpecialPassengerInfoList_Service;*/

import com.nwa.PRA.logger.Logger;


// import emailhashmap.AppContXMLMethods;
//import emailhashmap.SingletonListBean;

import genMethods.GenMethods;
import java.util.UUID;
/*extends Action*/
public class OnDemandRequestAction extends ActionSupport {

	public ActionForward execute(

	ActionMapping mapping,

	ActionForm form,

	HttpServletRequest request,

	HttpServletResponse response)

	{

		// ArrayList detailList = new ArrayList();

		Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
				"-----------in OnDemandRequestAction-------");
		String link = "success";

		ActionErrors errors = new ActionErrors();
		OnDemandRequestForm frm = (OnDemandRequestForm) form;

		EJBLookup ejbLookup = new EJBLookup();

		SPLJ spljBean = null;

		try {

			spljBean = ejbLookup.lookupEjb();

			if (request.getParameter("FlightNumOD") != null
					&& !request.getParameter("FlightNumOD").equals("")) {
				boolean test1 = GenMethods.flightNumStringTester(request
						.getParameter("FlightNumOD"));
				System.out.println("Test 1: " + test1 + "FlightNumOD: "
						+ request.getParameter("FlightNumOD"));

				if (test1) {
					frm.setFlightNumber(request.getParameter("FlightNumOD"));
				} else {

					errors.add("notAllowed", new ActionError(
							"error.notAllowed.onDemandFlightNum"));

					saveErrors(request, errors);
					frm.setFlightNumber("");

					return mapping.findForward(link);

				}
			} else {
				errors.add("notAllowed", new ActionError(
						"error.notAllowed.nullonDemandFlightNum"));

				saveErrors(request, errors);
				frm.setFlightNumber("");

				return mapping.findForward(link);
			}

			if (request.getParameter("FlightDateOD") != null
					&& !request.getParameter("FlightDateOD").equals("")) {
				boolean test2 = GenMethods.dateStringTester(request
						.getParameter("FlightDateOD"));
				System.out.println("dateStringTester: " + test2);
				if (test2) {
					frm.setLocalDepartureDate(request
							.getParameter("FlightDateOD"));
				} else {

					errors.add("notAllowed", new ActionError(
							"error.notAllowed.onDemandDate"));

					saveErrors(request, errors);
					frm.setLocalDepartureDate("");

					return mapping.findForward(link);

				}
			} else {

				errors.add("null", new ActionError(
						"error.notAllowed.nullonDemandDate"));

				saveErrors(request, errors);
				frm.setLocalDepartureDate("");

				return mapping.findForward(link);

			}

			if (request.getParameter("FlightBoardingPointOD") != null
					&& !request.getParameter("FlightBoardingPointOD")
							.equals("")) {
				boolean test3 = GenMethods.isLocAlpha(request
						.getParameter("FlightBoardingPointOD"));
				if (test3) {
					frm.setLegOrigApCode(request
							.getParameter("FlightBoardingPointOD"));
				} else {

					errors.add("notAllowed", new ActionError(
							"error.notAllowed.onDemandDepApt"));

					saveErrors(request, errors);
					frm.setLegOrigApCode("");

					return mapping.findForward(link);

				}
			} else {

				errors.add("notAllowed", new ActionError(
						"error.notAllowed.nullonDemandDepApt"));

				saveErrors(request, errors);
				frm.setLocalDepartureDate("");

				return mapping.findForward(link);

			}

			String flightNumber = frm.getFlightNumber().trim().toUpperCase();
			String localDepartureDate = frm.getLocalDepartureDate().trim()
					.toUpperCase();

			String legOrigApCode = frm.getLegOrigApCode().trim().toUpperCase();

			Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
					"OD Request flightNumber --> " + flightNumber);
			Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
					"OD Request localDepartureDate --> " + localDepartureDate);
			Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
					"OD Request legOrigApCode --> " + legOrigApCode);

			// /////////////////
			if (!flightNumber.equals("") && !localDepartureDate.equals("")
					&& !legOrigApCode.equals("")) {
				try {
					OnDemandRequestType onDemandRequestType = new OnDemandRequestType();
					OnDemandRequestInfoType onDemandRequestInfoType = new OnDemandRequestInfoType();
					System.out.println("legOrigApCode: " + legOrigApCode
							+ " localDepartureDate: " + localDepartureDate
							+ " flightNumber: " + flightNumber);
					onDemandRequestInfoType.setBoardPoint(legOrigApCode);
					onDemandRequestInfoType.setDate(localDepartureDate);
					onDemandRequestInfoType.setFlightNumber(flightNumber);

					onDemandRequestType
							.setOnDemandRequestInfo(onDemandRequestInfoType);

					RequestInfoType requestInfoType = new RequestInfoType();

					requestInfoType.setAppChannelName("SPL");
					requestInfoType.setTestLab("RES"); //TSAE
					requestInfoType.setApplicationId("CU");
					requestInfoType.setDebugOptions("Y");
					UUID idOne = UUID.randomUUID();
					String st = idOne.toString();
				//	System.out.println("UID : :::::: " + st);
					requestInfoType.setTransactionId(st);
					onDemandRequestType.setRequestInfo(requestInfoType);
					
					SpecialPassengerInfoList_EPProxy proxys = new SpecialPassengerInfoList_EPProxy();
					/*String Url = SPILPropertyManager
							.getProperty("SPECIALPASSENGERINFOLISTURL");
					proxys._getDescriptor().setEndpoint(Url);*/
					// ///////////////////new
					// proxys._getDescriptor().setEndpoint("https://webservices-si.delta.com:32045/specialpassengerinfolist");
					proxys._getDescriptor().setEndpoint("https://webservices.delta.com:32045/specialpassengerinfolist");
					/*System.out.println("Calling On Demand WS --> "
							+ proxys._getDescriptor().getEndpoint());*/
					
					OnDemandResponseType onDemandResponseType = null;

					onDemandResponseType = proxys.onDemand(onDemandRequestType); // .onDemand(onDemandRequestType);

					frm.setSOAResponse(onDemandResponseType.getDebugInfo()
							.getDataSourceResponse());
					// ////////////////////////////
					/* try { */
					String s = null;
					if (onDemandResponseType.getDebugInfo()
							.getDataSourceResponse() != null) {
						s = onDemandResponseType.getDebugInfo()
								.getDataSourceResponse().toString();
						System.out.println("getDebugInfo: " + s);

						ArrayList<String> list = new ArrayList<String>(
								Arrays.asList(s.split("\\|")));

						List<String> listMsgSOA = new ArrayList<String>();
						s = list.get(1);

						s = s.substring(0, s.length() - 1); // gets rid of ']'
						// / added per Kasey request
						s = "On Demand Flight request has been submitted";
						listMsgSOA.add(s);
						request.setAttribute("listMsgSOA", listMsgSOA);

						// //////////
					  /*  ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");  
					    A a=(A) context.getBean("a",A.class);  
					    a.display();  */
						/*try {
							ApplicationContext context = new ClassPathXmlApplicationContext(
									"applicationContext.xml");
							SingletonListBean SL = (SingletonListBean) context
									.getBean("SingletonListBean");
							SL.setDepAirport(legOrigApCode);
							SL.setDepDate(localDepartureDate);
							SL.setFlightNumber(flightNumber);
							SL.setEmail("email");
							 SL.updateSpringBean();

							SL.printBean();
						} catch (Throwable e) {
							String s1 = e.toString();
							Logger.log(this.getClass(), Logger.LEVEL_DEBUG,
									"OD Request StackTrace --> " + s1);

						}*/


						return mapping.findForward("success");

					}

					/*
					 * } catch (Throwable e) { System.err.println(e); }
					 */
				} catch (BusinessFault e) {
					String s = null;

					s = e.getFaultInfo().getFaultDetailedInfo()
							.getStackTraceInfo();

					/*System.out
							.println("e.getFaultInfo().getFaultDetailedInfo().getStackTraceInfo(): "
									+ s);*/
					// //////

					ArrayList<String> list = new ArrayList<String>(
							Arrays.asList(s.split("\\|")));

					frm.setSOAResponse(s);
					List<String> listMsgSOA = new ArrayList<String>();
					s = list.get(0);
					listMsgSOA.add(s);
					request.setAttribute("listMsgSOA", listMsgSOA);

					return mapping.findForward("success");

				}

			}
		} catch (Throwable e) {
			System.err.println(e);
		}

		return mapping.findForward(link);
	}

}
