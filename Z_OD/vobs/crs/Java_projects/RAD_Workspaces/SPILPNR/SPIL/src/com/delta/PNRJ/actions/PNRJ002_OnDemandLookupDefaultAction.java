package com.delta.PNRJ.actions;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import org.apache.struts.action.Action;

import org.apache.struts.action.ActionError;

import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionForward;

import org.apache.struts.action.ActionMapping;



import com.delta.PNRJ.forms.PNRJ002_OnDemandlookupDefaultForm;

import com.delta.PNRJ.helper.CustomValidationRules;

import com.nwa.PRA.logger.Logger;

import com.nwa.adsvmp.ADUtil;

import com.nwa.adsvmp.EmployeeInfo;



////////////////////UPDATES & COMMENTS////////////////////

/*

 * 

 * @author id

 *

 * Program Description

 * 

 * Updates:

 * Date			Initials	Change

 * 12-15-2004   EDJG        Add session.removeAttribute function to remove existing form bean from the session

 * 10/24/2005	KNS			Made mods for using LDAP form based authentication vs PRA's AD web service calls

 * 04/03/2006	KNS			Read AD Info for employee name to display in header banner

 * 06/22/2010	Hari S		Migrating the code to JDK1.6 and Delta Specific logos

 */



public class PNRJ002_OnDemandLookupDefaultAction extends Action{

	

	private HttpSession session;


	public ActionForward execute(ActionMapping mapping, 

								ActionForm form, 

								HttpServletRequest request, 

								HttpServletResponse response) 

			throws Exception{

            

			session = request.getSession();

			session.setAttribute("module","default");

			session.removeAttribute("OnDemandlookupDefaultForm");

			session.removeAttribute("lookupFlightForm");

			session.removeAttribute("lookupOrigDestForm");

			session.removeAttribute("lookupPassengerForm");

			PNRJ002_OnDemandlookupDefaultForm frm = (PNRJ002_OnDemandlookupDefaultForm) form;

			Logger.log(PNRJ002_OnDemandLookupDefaultAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_OnDemandLookupDefaultAction");

			ActionErrors errorException = new ActionErrors();

			String link = "success";

						

			String userId = request.getUserPrincipal().getName(); //to get the authenticated user.

			boolean userinADCredit = request.isUserInRole("querycc"); //to see if this user is in a view-credit-field role

		//	boolean userinADNoCreditAccs = request.isUserInRole("queryonly"); //to see if this user is in a view-credit-field role

							

			//Research AD information on current userId		

			ADUtil adHelper = new ADUtil();

						

			EmployeeInfo empInfo=null;

			String empName = null;

			try {

				//Verify this userid is a Northwest/Delta Employee

				empInfo = adHelper.getEmployeeInfoFromAD(userId);

				empName = empInfo.getFirstName() + " " + empInfo.getLastName();

				Logger.log(PNRJ002_OnDemandLookupDefaultAction.class, Logger.LEVEL_DEBUG, " User MemberOf:" + empInfo.getMemberOf());

			} catch (Exception e) {

				//userInAD = false;

				errorException.add("logon", new org.apache.struts.action.ActionError("error.userID.invalid"));

				e.printStackTrace();

			}

			//PNRJ aud = pnrHome.create();  // remote Interface

			//boolean userAuthorizedCC = false;

			String empGroups = empInfo.getMemberOf();

			

			try{



				// clear all form fields

				frm.setCreditCardNumber("");

				frm.setEmployeeNumber("");

				frm.setFrequentFlyerNumber("");

				frm.setPnrList(null);

				frm.setPnrLocator("");

				frm.setTicketNumber("");

				

				String userAuthorizedCC = "";

				if(userinADCredit)

					userAuthorizedCC = "TRUE";

				else

					userAuthorizedCC = "FALSE";

						

				if(userAuthorizedCC == "TRUE"){

					frm.setUserAuthorizedCC("TRUE");

				}	

				else{

					frm.setUserAuthorizedCC("FALSE");

				}

				frm.setUserAuthorizedCC(userAuthorizedCC);

				

				frm.setIsAllowedOtherPnr(CustomValidationRules.isAllowedViewOtherPnr(empGroups));



			} 

			 catch (Exception e) {

				Logger.log(PNRJ002_OnDemandLookupDefaultAction.class, Logger.LEVEL_ERROR, e.getMessage());

				errorException.add(ActionErrors.GLOBAL_ERROR, 

				new ActionError("string.message"));

				saveErrors(request, errorException);

				link="failure";

				e.printStackTrace();

			}

			return mapping.findForward(link);

	}

}

