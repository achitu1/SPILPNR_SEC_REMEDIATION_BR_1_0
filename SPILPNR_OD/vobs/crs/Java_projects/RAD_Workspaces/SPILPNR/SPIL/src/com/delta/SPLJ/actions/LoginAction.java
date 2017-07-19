package com.delta.SPLJ.actions;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import org.apache.struts.action.Action;

import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionForward;

import org.apache.struts.action.ActionMapping;



import com.nwa.PRA.logger.Logger;

import com.nwa.adsvmp.ADUtil;

import com.nwa.adsvmp.EmployeeInfo;



public class LoginAction extends Action {

	private HttpSession session;

	public ActionForward execute(ActionMapping mapping,ActionForm form,

		HttpServletRequest request, HttpServletResponse response)

		throws Exception {

		String empName = null;

			ActionErrors errors = new ActionErrors();

			EmployeeInfo empData = null;

			Logger.log(LoginAction.class, Logger.LEVEL_DEBUG, "In Login Action");

			

			session = request.getSession();

			try{	

				if(request.getAttribute("sessionExpired")!= null && request.getAttribute("sessionExpired")== "y"){

					throw new Exception("Session Expired");

				}

				

				String LDAPuser = request.getUserPrincipal().getName(); //to get the authenticated user.

								

				Logger.setUser(LDAPuser);

				Logger.log(LoginAction.class, Logger.LEVEL_DEBUG, "User ID is: "+LDAPuser);

				String userId = request.getUserPrincipal().getName();

				//Research AD information on current userId		

				ADUtil adHelper = new ADUtil();

				empData = adHelper.getEmployeeInfoFromAD(LDAPuser);



				empName = empData.getFirstName() + " "

						+ empData.getLastName();

			

				session.setAttribute("userName", userId);

				session.setAttribute("employeeName", empName);

				session.setAttribute("statusLogin","LOGGED");

				String userAuthorizedCC ;

				boolean userinADCredit = request.isUserInRole("querycc");
				
				boolean userinADCreditOD = request.isUserInRole("SppOnDemondUser");

				
				if(userinADCreditOD){
					 userAuthorizedCC = "TRUEOD";

				}

				else if(userinADCredit){				 

					 userAuthorizedCC = "TRUE";

				 }else{				 

					 userAuthorizedCC = "FALSE";

				 }	

				

				session.setAttribute("userAuthorizedCC", userAuthorizedCC);

			//	session.setAttribute("isSPLJUser",request.isUserInRole("authorizedUsers"));

			//	session.setAttribute("isPNRUser",(request.isUserInRole("queryonly")|| request.isUserInRole("querycc")));

			

			}catch(Exception e){

				if(e.getMessage() != null && e.getMessage().equals("Session Expired")){

					errors.add("session", new org.apache.struts.action.ActionError("spl.invalid.session"));

					saveErrors(request,errors);

					return mapping.findForward("invalidSession");

				}

				System.out.println("Exception "+e);

				errors.add("logon", new org.apache.struts.action.ActionError("error.login.invalid"));

			}	

			if(empData != null && session.getAttribute("userAuthorizedCC")=="TRUEOD"){

				Logger.log(LoginAction.class, Logger.LEVEL_DEBUG, "Success in Login Action On Demand");

				return mapping.findForward("successOD");

			}

			else if(empData != null){

				Logger.log(LoginAction.class, Logger.LEVEL_DEBUG, "Success in Login Action");

				return mapping.findForward("success");

			}else{

				saveErrors(request,errors);

				Logger.log(LoginAction.class, Logger.LEVEL_DEBUG, "Failed in Login Action");

				return mapping.findForward("failure");

				//return mapping.findForward("invalidlogin");

			}

		}

 }



