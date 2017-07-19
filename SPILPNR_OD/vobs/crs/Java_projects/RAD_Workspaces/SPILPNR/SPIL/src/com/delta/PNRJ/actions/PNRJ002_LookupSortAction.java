package com.delta.PNRJ.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PNRJ.forms.PNRJ002_lookupDefaultForm;
import com.delta.PNRJ.forms.PNRJ002_lookupFlightForm;
import com.delta.PNRJ.forms.PNRJ002_lookupOrigDestForm;
import com.delta.PNRJ.forms.PNRJ002_lookupPassengerForm;
import com.delta.PNRJ.helper.CustomValidationRules;
import com.delta.PRA.PNRJ.data.PNRData;
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
 * 12-13-2004   EDJG        Revision of Sorting function, combining the diff. sorting function into one function.
 */

public class PNRJ002_LookupSortAction extends Action{
	

  public static int sortBy = 0;
  public ActionForward execute(ActionMapping mapping, 
							  ActionForm form, 
							  HttpServletRequest request, 
							  HttpServletResponse response) 
		  throws Exception{
	
		  String sessionStr = (String) request.getSession().getAttribute("module");
		  Logger.log(PNRJ002_LookupSortAction.class, Logger.LEVEL_DEBUG, "Start of execute in PNRJ002_LookupSortAction");
		  ActionErrors errorException = new ActionErrors();
		  String link = "success";
			
		  try{
				String sort = request.getParameter("sortBy");
				ArrayList pnrList = new ArrayList();

				//20080618 -  Issue 4885 - added to check if user currently logged in can view Employee No. field
				String userId =  request.getUserPrincipal().getName(); //to get the authenticated user.
				ADUtil adHelper = new ADUtil();
				EmployeeInfo empInfo=null;
				try {
					//Verify this userid is a Northwest Employee
					empInfo = adHelper.getEmployeeInfoFromAD(userId);
					Logger.log(PNRJ002_LookupDefaultAction.class, Logger.LEVEL_DEBUG, " User MemberOf:" + empInfo.getMemberOf());
				} catch (Exception e) {
					//userInAD = false;
					errorException.add("logon", new org.apache.struts.action.ActionError("error.userID.invalid"));
					e.printStackTrace();
				}
				String empGroups = empInfo.getMemberOf();
				
				
			    
				if (sessionStr.equals("default"))
				   {
						PNRJ002_lookupDefaultForm frm = (PNRJ002_lookupDefaultForm) form;
						
						if(sort.equals("pnrLoctrNum"))
						 {
							pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getLoctrNum());
							if (frm.getLoctrNum().equals("A"))
							  {
								frm.setLoctrNum("D");
							  }
							else
							 {
								frm.setLoctrNum("A"); 
							 }

						 }
					    
					    if(sort.equals("pnrCrtnDate"))
					     {
						    pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getCrtnDate());
						    if (frm.getCrtnDate().equals("A"))
						      {
							    frm.setCrtnDate("D");
						      }
						    else
						      {
							    frm.setCrtnDate("A"); 
						      }

					     }

					if(sort.equals("pnrTravelDate"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getTravelDateSort());
						if (frm.getTravelDateSort().equals("A"))
						  {
							frm.setTravelDateSort("D");
						  }
						else
						  {
							frm.setTravelDateSort("A"); 
						  }

					 }

					if(sort.equals("pnrMkAlCode"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getMkAlCode());
						if (frm.getMkAlCode().equals("A"))
						  {
							frm.setMkAlCode("D");
						  }
						else
						  {
							frm.setMkAlCode("A"); 
						  }

					 }

					if(sort.equals("pnrFltNum"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getFltNum());
						if (frm.getFltNum().equals("A"))
						  {
							frm.setFltNum("D");
						  }
						else
						  {
							frm.setFltNum("A"); 
						  }

					 }

					if(sort.equals("pnrSegOrigApCode"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegOrigApCode());
						if (frm.getSegOrigApCode().equals("A"))
						  {
							frm.setSegOrigApCode("D");
						  }
						else
						  {
							frm.setSegOrigApCode("A"); 
						  }

					 }

					if(sort.equals("pnrSegDestApCode"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegDestApCode());
						if (frm.getSegDestApCode().equals("A"))
						  {
							frm.setSegDestApCode("D");
						  }
						else
						  {
							frm.setSegDestApCode("A"); 
						  }

					 }

					if(sort.equals("pnrPsngrNme"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getPsngrNme());
						if (frm.getPsngrNme().equals("A"))
						  {
							frm.setPsngrNme("D");
						  }
						else
						  {
							frm.setPsngrNme("A"); 
						  }

					 }

					if(sort.equals("pnrInvClCode"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getInvClCode());
						if (frm.getInvClCode().equals("A"))
						  {
							frm.setInvClCode("D");
						  }
						else
						  {
							frm.setInvClCode("A"); 
						  }

					 }

					if(sort.equals("pnrSegStatusCode"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegStatusCode());
						if (frm.getSegStatusCode().equals("A"))
						  {
							frm.setSegStatusCode("D");
						  }
						else
						  {
							frm.setSegStatusCode("A"); 
						  }

					 }


						frm.setPnrList(pnrList);
						
						//20080618 -  Issue 4885 - added to check if user currently logged in can view Employee No. field
						frm.setIsAllowedOtherPnr(CustomValidationRules.isAllowedViewOtherPnr(empGroups));

				    } 
				if (sessionStr.equals("flight")){
					PNRJ002_lookupFlightForm frm = (PNRJ002_lookupFlightForm) form;
					if(sort.equals("pnrLoctrNum"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getLoctrNum());
						if (frm.getLoctrNum().equals("A"))
						  {
							frm.setLoctrNum("D");
						  }
						else
						 {
							frm.setLoctrNum("A"); 
						 }

					 }
					    
					if(sort.equals("pnrCrtnDate"))
					 {
						pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getCrtnDate());
						if (frm.getCrtnDate().equals("A"))
						  {
							frm.setCrtnDate("D");
						  }
						else
						  {
							frm.setCrtnDate("A"); 
						  }

					 }

				if(sort.equals("pnrTravelDate"))
				 {
					pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getTravelDateSort());
					if (frm.getTravelDateSort().equals("A"))
					  {
						frm.setTravelDateSort("D");
					  }
					else
					  {
						frm.setTravelDateSort("A"); 
					  }

				 }

				if(sort.equals("pnrMkAlCode"))
				 {
					pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getMkAlCode());
					if (frm.getMkAlCode().equals("A"))
					  {
						frm.setMkAlCode("D");
					  }
					else
					  {
						frm.setMkAlCode("A"); 
					  }

				 }

				if(sort.equals("pnrFltNum"))
				 {
					pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getFltNum());
					if (frm.getFltNum().equals("A"))
					  {
						frm.setFltNum("D");
					  }
					else
					  {
						frm.setFltNum("A"); 
					  }

				 }

				if(sort.equals("pnrSegOrigApCode"))
				 {
					pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegOrigApCode());
					if (frm.getSegOrigApCode().equals("A"))
					  {
						frm.setSegOrigApCode("D");
					  }
					else
					  {
						frm.setSegOrigApCode("A"); 
					  }

				 }

				if(sort.equals("pnrSegDestApCode"))
				 {
					pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegDestApCode());
					if (frm.getSegDestApCode().equals("A"))
					  {
						frm.setSegDestApCode("D");
					  }
					else
					  {
						frm.setSegDestApCode("A"); 
					  }

				 }

				if(sort.equals("pnrPsngrNme"))
				 {
					pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getPsngrNme());
					if (frm.getPsngrNme().equals("A"))
					  {
						frm.setPsngrNme("D");
					  }
					else
					  {
						frm.setPsngrNme("A"); 
					  }

				 }

				if(sort.equals("pnrInvClCode"))
				 {
					pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getInvClCode());
					if (frm.getInvClCode().equals("A"))
					  {
						frm.setInvClCode("D");
					  }
					else
					  {
						frm.setInvClCode("A"); 
					  }

				 }

				if(sort.equals("pnrSegStatusCode"))
				 {
					pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegStatusCode());
					if (frm.getSegStatusCode().equals("A"))
					  {
						frm.setSegStatusCode("D");
					  }
					else
					  {
						frm.setSegStatusCode("A"); 
					  }

				 }



					frm.setPnrList(pnrList);
											  }
				if (sessionStr.equals("passenger")){
			
				   PNRJ002_lookupPassengerForm frm = (PNRJ002_lookupPassengerForm ) form;
				   if(sort.equals("pnrLoctrNum"))
					{
					   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getLoctrNum());
					   if (frm.getLoctrNum().equals("A"))
						 {
						   frm.setLoctrNum("D");
						 }
					   else
						{
						   frm.setLoctrNum("A"); 
						}

					}
					    
				   if(sort.equals("pnrCrtnDate"))
					{
					   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getCrtnDate());
					   if (frm.getCrtnDate().equals("A"))
						 {
						   frm.setCrtnDate("D");
						 }
					   else
						 {
						   frm.setCrtnDate("A"); 
						 }

					}

			   if(sort.equals("pnrTravelDate"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getTravelDateSort());
				   if (frm.getTravelDateSort().equals("A"))
					 {
					   frm.setTravelDateSort("D");
					 }
				   else
					 {
					   frm.setTravelDateSort("A"); 
					 }

				}

			   if(sort.equals("pnrMkAlCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getMkAlCode());
				   if (frm.getMkAlCode().equals("A"))
					 {
					   frm.setMkAlCode("D");
					 }
				   else
					 {
					   frm.setMkAlCode("A"); 
					 }

				}

			   if(sort.equals("pnrFltNum"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getFltNum());
				   if (frm.getFltNum().equals("A"))
					 {
					   frm.setFltNum("D");
					 }
				   else
					 {
					   frm.setFltNum("A"); 
					 }

				}

			   if(sort.equals("pnrSegOrigApCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegOrigApCode());
				   if (frm.getSegOrigApCode().equals("A"))
					 {
					   frm.setSegOrigApCode("D");
					 }
				   else
					 {
					   frm.setSegOrigApCode("A"); 
					 }

				}

			   if(sort.equals("pnrSegDestApCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegDestApCode());
				   if (frm.getSegDestApCode().equals("A"))
					 {
					   frm.setSegDestApCode("D");
					 }
				   else
					 {
					   frm.setSegDestApCode("A"); 
					 }

				}

			   if(sort.equals("pnrPsngrNme"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getPsngrNme());
				   if (frm.getPsngrNme().equals("A"))
					 {
					   frm.setPsngrNme("D");
					 }
				   else
					 {
					   frm.setPsngrNme("A"); 
					 }

				}

			   if(sort.equals("pnrInvClCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getInvClCode());
				   if (frm.getInvClCode().equals("A"))
					 {
					   frm.setInvClCode("D");
					 }
				   else
					 {
					   frm.setInvClCode("A"); 
					 }

				}

			   if(sort.equals("pnrSegStatusCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegStatusCode());
				   if (frm.getSegStatusCode().equals("A"))
					 {
					   frm.setSegStatusCode("D");
					 }
				   else
					 {
					   frm.setSegStatusCode("A"); 
					 }

				}



				   frm.setPnrList(pnrList);
				 }
				if (sessionStr.equals("origdest")){
				   PNRJ002_lookupOrigDestForm frm = (PNRJ002_lookupOrigDestForm) form;
				   if(sort.equals("pnrLoctrNum"))
					{
					   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getLoctrNum());
					   if (frm.getLoctrNum().equals("A"))
						 {
						   frm.setLoctrNum("D");
						 }
					   else
						{
						   frm.setLoctrNum("A"); 
						}

					}
					    
				   if(sort.equals("pnrCrtnDate"))
					{
					   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getCrtnDate());
					   if (frm.getCrtnDate().equals("A"))
						 {
						   frm.setCrtnDate("D");
						 }
					   else
						 {
						   frm.setCrtnDate("A"); 
						 }

					}

			   if(sort.equals("pnrTravelDate"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getTravelDateSort());
				   if (frm.getTravelDateSort().equals("A"))
					 {
					   frm.setTravelDateSort("D");
					 }
				   else
					 {
					   frm.setTravelDateSort("A"); 
					 }

				}

			   if(sort.equals("pnrMkAlCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getMkAlCode());
				   if (frm.getMkAlCode().equals("A"))
					 {
					   frm.setMkAlCode("D");
					 }
				   else
					 {
					   frm.setMkAlCode("A"); 
					 }

				}

			   if(sort.equals("pnrFltNum"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getFltNum());
				   if (frm.getFltNum().equals("A"))
					 {
					   frm.setFltNum("D");
					 }
				   else
					 {
					   frm.setFltNum("A"); 
					 }

				}

			   if(sort.equals("pnrSegOrigApCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegOrigApCode());
				   if (frm.getSegOrigApCode().equals("A"))
					 {
					   frm.setSegOrigApCode("D");
					 }
				   else
					 {
					   frm.setSegOrigApCode("A"); 
					 }

				}

			   if(sort.equals("pnrSegDestApCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegDestApCode());
				   if (frm.getSegDestApCode().equals("A"))
					 {
					   frm.setSegDestApCode("D");
					 }
				   else
					 {
					   frm.setSegDestApCode("A"); 
					 }

				}

			   if(sort.equals("pnrPsngrNme"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getPsngrNme());
				   if (frm.getPsngrNme().equals("A"))
					 {
					   frm.setPsngrNme("D");
					 }
				   else
					 {
					   frm.setPsngrNme("A"); 
					 }

				}

			   if(sort.equals("pnrInvClCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getInvClCode());
				   if (frm.getInvClCode().equals("A"))
					 {
					   frm.setInvClCode("D");
					 }
				   else
					 {
					   frm.setInvClCode("A"); 
					 }

				}

			   if(sort.equals("pnrSegStatusCode"))
				{
				   pnrList = newSortArrayList((ArrayList)frm.getPnrList(),request.getParameter("sortBy"), frm.getSegStatusCode());
				   if (frm.getSegStatusCode().equals("A"))
					 {
					   frm.setSegStatusCode("D");
					 }
				   else
					 {
					   frm.setSegStatusCode("A"); 
					 }

				}



				   frm.setPnrList(pnrList);
				 }
		  } 
		   catch (Exception e) {
			  Logger.log(PNRJ002_LookupSortAction.class, Logger.LEVEL_ERROR, e.getMessage());
			  errorException.add(ActionErrors.GLOBAL_ERROR, 
			  new ActionError("string.message",e.getMessage()));
			  saveErrors(request, errorException);
			  link="failure";
		  }
		  return mapping.findForward(link);			
  }

//  public class PNRComparator extends Object implements Comparator {
//		 private String methodName = "toString";
//		 private int descAscIndicator = 1;
//       
//				 public PNRComparator(String methodName, int descAscIndicator) {
//				   this.descAscIndicator = descAscIndicator;
//					 this.methodName = methodName;
//				 }
//					 public int compare(Object o1, Object o2) {
//						 Object comp1 = null;
//						 Object comp2 = null;
//
//							 try {
//							 Method o1_Method = o1.getClass().getMethod(methodName, null);
//							 Method o2_Method = o2.getClass().getMethod(methodName, null);
//							 comp1 = o1_Method.invoke(o1, null);
//							 comp2 = o2_Method.invoke(o2, null);
//                    		
//								 } catch (NoSuchMethodException e) {} 
//								   catch (IllegalAccessException e) {} 
//								   catch (InvocationTargetException e) {}
//									 Comparable c1 = (Comparable) comp1;
//									 Comparable c2 = (Comparable) comp2;
//						                    if (sortBy==0)
//											 { sortBy=1;
//												return c1.compareTo(c2) * descAscIndicator;
//											 }
//											 else{
//											   sortBy=0;	
//											   return c1.compareTo(c2) * -1;
//											 }
//									
//								 }
//									 public boolean equals(Object obj) {
//										 return this.equals(obj);
//									 }
//					  }
	public static Comparator pnrLoctrNumAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrLoctrNum().compareToIgnoreCase(vv2.getPnrLoctrNum());
		}
	};

	public static Comparator pnrLoctrNumDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrLoctrNum().compareToIgnoreCase(vv1.getPnrLoctrNum());
		}
	};

	public static Comparator pnrCrtnDateAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrCrtnDate().compareToIgnoreCase(vv2.getPnrCrtnDate());
		}
	};

	public static Comparator pnrCrtnDateDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrCrtnDate().compareToIgnoreCase(vv1.getPnrCrtnDate());
		}
	};


	public static Comparator pnrTravelDateAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrTravelDate().compareToIgnoreCase(vv2.getPnrTravelDate());
		}
	};

	public static Comparator pnrTravelDateDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrTravelDate().compareToIgnoreCase(vv1.getPnrTravelDate());
		}
	};


	public static Comparator pnrMkAlCodeAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrMkAlCode().compareToIgnoreCase(vv2.getPnrMkAlCode());
		}
	};

	public static Comparator pnrMkAlCodeDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrMkAlCode().compareToIgnoreCase(vv1.getPnrMkAlCode());
		}
	};

	
	public static Comparator pnrFltNumAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrFltNum().compareToIgnoreCase(vv2.getPnrFltNum());
		}
	};

	public static Comparator pnrFltNumDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrFltNum().compareToIgnoreCase(vv1.getPnrFltNum());
		}
	};

	
	public static Comparator pnrSegOrigApCodeAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrSegOrigApCode().compareToIgnoreCase(vv2.getPnrSegOrigApCode());
		}
	};

	public static Comparator pnrSegOrigApCodeDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrSegOrigApCode().compareToIgnoreCase(vv1.getPnrSegOrigApCode());
		}
	};

	public static Comparator pnrSegDestApCodeAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrSegDestApCode().compareToIgnoreCase(vv2.getPnrSegDestApCode());
		}
	};

	public static Comparator pnrSegDestApCodeDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrSegDestApCode().compareToIgnoreCase(vv1.getPnrSegDestApCode());
		}
	};
	

	public static Comparator pnrPsngrNmeAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrPsngrNme().compareToIgnoreCase(vv2.getPnrPsngrNme());
		}
	};

	public static Comparator pnrPsngrNmeDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrPsngrNme().compareToIgnoreCase(vv1.getPnrPsngrNme());
		}
	};
	
	
	public static Comparator pnrInvClCodeAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrInvClCode().compareToIgnoreCase(vv2.getPnrInvClCode());
		}
	};

	public static Comparator pnrInvClCodeDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrInvClCode().compareToIgnoreCase(vv1.getPnrInvClCode());
		}
	};


	public static Comparator pnrSegStatusCodeAsc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv1.getPnrSegStatusCode().compareToIgnoreCase(vv2.getPnrSegStatusCode());
		}
	};

	public static Comparator pnrSegStatusCodeDesc = new Comparator() {
		public int compare(Object o1, Object o2) {
			PNRData vv1 =  (PNRData)o1;
			PNRData vv2 =  (PNRData)o2;
			return vv2.getPnrSegStatusCode().compareToIgnoreCase(vv1.getPnrSegStatusCode());
		}
	};
	
	
	

  public ArrayList newSortArrayList(ArrayList pArrayList, String sortColumn, String sortBy)
  {
	
    

//	if(sortColumn.equals("pnrLoctrNum"))			
//	  Collections.sort(pArrayList, new PNRComparator("getPnrLoctrNum",1));
//	if(sortColumn.equals("pnrCrtnDate"))
//	  Collections.sort(pArrayList, new PNRComparator("getPnrCrtnDate",1));
//	if(sortColumn.equals("pnrTravelDate"))
//	  Collections.sort(pArrayList, new PNRComparator("getPnrTravelDate",1));
//	if(sortColumn.equals("pnrMkAlCode"))
//	   Collections.sort(pArrayList, new PNRComparator("getPnrMkAlCode",1));
//	if(sortColumn.equals("pnrFltNum"))
//	  Collections.sort(pArrayList, new PNRComparator("getPnrFltNum",1));
//	if(sortColumn.equals("pnrSegOrigApCode"))
//	  Collections.sort(pArrayList, new PNRComparator("getPnrSegOrigApCode",1));
//	if(sortColumn.equals("pnrSegDestApCode"))
//	  Collections.sort(pArrayList, new PNRComparator("getPnrSegDestApCode",1));
//	if(sortColumn.equals("pnrPsngrNme"))
//	  Collections.sort(pArrayList, new PNRComparator("getPnrPsngrNme",1));
//	if(sortColumn.equals("pnrInvClCode"))
//	  Collections.sort(pArrayList, new PNRComparator("getPnrInvClCode",1));
//	if(sortColumn.equals("pnrSegStatusCode"))
//	  Collections.sort(pArrayList, new PNRComparator("getPnrSegStatusCode",1));


    if(sortColumn.equals("pnrLoctrNum"))
      {
	    if(sortBy.equals("A"))
		  {
			Collections.sort(pArrayList, pnrLoctrNumAsc);
		  }
	    else
		  {
	        Collections.sort(pArrayList, pnrLoctrNumDesc);
	      }
      }

	if(sortColumn.equals("pnrCrtnDate"))
	  {
		if(sortBy.equals("A"))
		{
		  Collections.sort(pArrayList, pnrCrtnDateAsc);
		}
		else
		{
		  Collections.sort(pArrayList, pnrCrtnDateDesc);
		}
	  }

	if(sortColumn.equals("pnrTravelDate"))
	  {
		if(sortBy.equals("A"))
		{
		  Collections.sort(pArrayList, pnrTravelDateAsc);
		}
		else
		{
		  Collections.sort(pArrayList, pnrTravelDateDesc);
		}
	  }
	if(sortColumn.equals("pnrMkAlCode"))
	  {
		if(sortBy.equals("A"))
		{
		  Collections.sort(pArrayList, pnrMkAlCodeAsc);
		}
		else
		{
		  Collections.sort(pArrayList, pnrMkAlCodeDesc);
		}
	  }

	if(sortColumn.equals("pnrFltNum"))
	  {
		if(sortBy.equals("A"))
		{
		  Collections.sort(pArrayList, pnrFltNumAsc);
		}
		else
		{
		  Collections.sort(pArrayList, pnrFltNumDesc);
		}
	  }
	  
	if(sortColumn.equals("pnrSegOrigApCode"))
	  {
		if(sortBy.equals("A"))
		{
		  Collections.sort(pArrayList, pnrSegOrigApCodeAsc);
		}
		else
		{
		  Collections.sort(pArrayList, pnrSegOrigApCodeDesc);
		}
	  }
	  
	if(sortColumn.equals("pnrSegDestApCode"))
	  {
		if(sortBy.equals("A"))
		{
		  Collections.sort(pArrayList, pnrSegDestApCodeAsc);
		}
		else
		{
		  Collections.sort(pArrayList, pnrSegDestApCodeDesc);
		}
	  }
	  
	if(sortColumn.equals("pnrPsngrNme"))
	  {
		if(sortBy.equals("A"))
		{
		  Collections.sort(pArrayList, pnrPsngrNmeAsc);
		}
		else
		{
		  Collections.sort(pArrayList, pnrPsngrNmeDesc);
		}
	  }
	  
	if(sortColumn.equals("pnrInvClCode"))
	  {
		if(sortBy.equals("A"))
		{
		  Collections.sort(pArrayList, pnrInvClCodeAsc);
		}
		else
		{
		  Collections.sort(pArrayList, pnrInvClCodeDesc);
		}
	  }
	  
	if(sortColumn.equals("pnrSegStatusCode"))
	  {
		if(sortBy.equals("A"))
		{
		  Collections.sort(pArrayList, pnrSegStatusCodeAsc);
		}
		else
		{
		  Collections.sort(pArrayList, pnrSegStatusCodeDesc);
		}
	  }	  

    return pArrayList;
		
   }				
 };





