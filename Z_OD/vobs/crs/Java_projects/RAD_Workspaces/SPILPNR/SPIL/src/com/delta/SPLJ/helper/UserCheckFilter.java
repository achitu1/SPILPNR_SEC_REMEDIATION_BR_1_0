package com.delta.SPLJ.helper;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.nwa.adsvmp.ADUtil;
import com.nwa.adsvmp.EmployeeInfo;



public class UserCheckFilter implements Filter {



	private FilterConfig fc = null;



	/*

	 * (non-Java-doc)

	 * 

	 * @see java.lang.Object#Object()

	 */

	public UserCheckFilter() {

		super();

	}



	/*

	 * (non-Java-doc)

	 * 

	 * @see javax.servlet.Filter#init(FilterConfig arg0)

	 */

	public void init(FilterConfig config) throws ServletException {



		this.fc = config;

	}



	/*

	 * (non-Java-doc)

	 * 

	 * @see javax.servlet.Filter#doFilter(ServletRequest arg0, ServletResponse

	 * arg1, FilterChain arg2)

	 */

	public void doFilter(ServletRequest req, ServletResponse res,

			FilterChain chain) throws IOException, ServletException {



		ServletContext sc = fc.getServletContext();

		String auth = "";

		String statusLogin = null;

		String employeeName = null;



		if (req instanceof HttpServletRequest) {

			HttpServletRequest request = ((HttpServletRequest) req);



			HttpSession session = request.getSession(false);



			if (session != null) {

				statusLogin = (String) session.getAttribute("statusLogin");

				employeeName = (String) session.getAttribute("employeeName");

				

				auth = "TRUE";

			}

			if ((statusLogin == null) || (statusLogin.length() == 0)

					|| (!statusLogin.equals("LOGGED"))) {



				String URI = request.getRequestURI().toString();

								

				if ((URI.endsWith("login.do")) && (auth.equals("TRUE"))) {

					

					chain.doFilter(req, res);

				} else {

					

					/*Websphere session settign by default is 30 mins and the session will become null and employee

					name will also be null, but LTPA token is still valid so the application continues with employee name as null...

					to avoid such thing, looking for employee info again.If LTPA token also expires...the application will be

					challenged for user credentials. 

					*/

					if (session == null || employeeName == null) {

						String userId = request.getUserPrincipal().getName();

						//String userId =null;

						if (userId != null) {

							EmployeeInfo empData = null;

							String empName = null;

							

							// Research AD information on current userId

							ADUtil adHelper = new ADUtil();



							try {

								

								empData = adHelper

										.getEmployeeInfoFromAD(userId);

								empName = empData.getFirstName() + " "

										+ empData.getLastName();

								session = request.getSession();

								session.setAttribute("userName", userId);

								session.setAttribute("employeeName", empName);

								session.setAttribute("statusLogin", "LOGGED");

								//throw new ADLookupException("User Not found");//testing purpose only

							} catch (Exception e) {

								e.printStackTrace();

								String errMsg = null;

								if(e.getMessage() != null){

									errMsg = e.getMessage();

								}else{

									errMsg = "Errors have occured while looking for the employee details from ADHelper Class."; 

								}

								sc.getRequestDispatcher("error.jsp?errMsg="+errMsg).forward(req,

										res);

							}



							chain.doFilter(req, res);

						} else {

							request.setAttribute("sessionExpired", "y");

							sc.getRequestDispatcher("login.do").forward(req,

									res);

						}

					} else {

						chain.doFilter(req, res);

					}

					// chain.doFilter(req, res);

					// sc.getRequestDispatcher("login.do").forward(req, res);

					// sc.getRequestDispatcher(

					// "ibm_security_logout?logoutExitPage=login.do"

					// ).forward(req, res);

					// ((HttpServletResponse) res).sendRedirect("login.do");

				}

			} else {

				/*

				 * Hari somagatta 06/30/2010 - modifying the 2 projects into one

				 * ear file.

				 * 

				 * User is logged in and trying to get the urls having SPLJ/ or

				 * PNRJ/ then we are again checking here whether the user is in

				 * the specified role because the user might get the specific

				 * restricted URl and paste it in browser.

				 * 

				 * I tried configuring the same in web.xml for secured resources

				 * access, but for some reason i can not be able to successfully

				 * get the access to the specified roles on specific

				 * resources.So thought of handling this way.

				 */



				String URI = ((HttpServletRequest) req).getRequestURI()

						.toString();

				if (URI.contains("PNRJ") || URI.contains("redirectApp")) {

					if (((HttpServletRequest) req).isUserInRole("querycc")

							|| ((HttpServletRequest) req)

									.isUserInRole("queryonly")) {

						



					} else {

						

						sc.getRequestDispatcher("notAuthorised.jsp").forward(

								req, res);

					}



				} else if (URI.contains("SPL")) {

					if (!((HttpServletRequest) req)

							.isUserInRole("authorizedUsers")) {

						

						sc.getRequestDispatcher("notAuthorised.jsp").forward(

								req, res);

					}

				}



				

				chain.doFilter(req, res);

			}

		}



	}



	/*

	 * (non-Java-doc)

	 * 

	 * @see javax.servlet.Filter#destroy()

	 */

	public void destroy() {



	}



}