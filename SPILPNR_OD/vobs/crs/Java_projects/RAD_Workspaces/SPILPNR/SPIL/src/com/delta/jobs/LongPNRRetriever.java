package com.delta.jobs;



import java.io.BufferedWriter;

import java.io.File;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Date;

import java.util.Properties;



import javax.activation.DataHandler;

import javax.activation.FileDataSource;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.Multipart;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

import javax.naming.Context;

import javax.naming.InitialContext;

import javax.servlet.ServletConfig;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;



/**

 * @author f77219

 * 

 */

public class LongPNRRetriever extends HttpServlet {

	/**

	 * 

	 */

	private static final long serialVersionUID = 1L;

	private final static String DATA_SOURCE = "jdbc/ds2";



	public void init(ServletConfig config) throws ServletException {

		super.init(config);

	}



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse

	 *      response)

	 */

	protected void doGet(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse

	 *      response)

	 */

	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {

		/*

		 * Set the content type(MIME Type) of the response.

		 */

		response.setContentType("text/html");

		String responseMessage = "";



		String pnr = "";

		String pnrDate = "";

		String email = "";

		try {

			pnr = request.getParameter("pnr");

			pnrDate = request.getParameter("pnrDate");

			email = request.getParameter("email");

			String pnrYrmo = pnrDate != null && pnrDate.length() == 10 ? pnrDate

					.substring(6, 10)

					+ pnrDate.substring(0, 2)

					: "";

			String action = request.getParameter("action");



			if (action != null && action.equals("start") && pnr != null && pnr != ""

					&& pnrDate != null && email != null && pnrDate != "" && email != "") {

				if (!email.endsWith("@DELTA.COM")){

					responseMessage = "Invalid email address, must be sent to Delta email address.";

				} else {

					String pnrText = call_pnrText_lookup(pnr.toUpperCase(), pnrDate, pnrYrmo);

					if (pnrText != null && pnrText.trim().length() > 0) {

						writeText(pnr, pnrText, email, "callcenter@delta.com");

					} else {

						pnrText = "No record found for PNR " + pnr

							+ " with creation date " + pnrDate;

						writeText(pnr, pnrText, email, "callcenter@delta.com");

					}



					responseMessage = "Email sent to " + email + " to for PNR " + pnr + ".";

					pnr = "";

					pnrDate = "";

					email = "";

					destroy();

				}

			} else if (action != null && action.equals("start")){

				responseMessage = "Nothing processed, please try again.";

			} else {

				pnr = "";

				pnrDate = "";

				email = "";

			}

		} catch (Exception e) {

			System.err.println(e.toString());

			e.printStackTrace();

			destroy();

			responseMessage = "Exception processing the email request, please validate PNR, Create Date and Email Address.";

		}



		PrintWriter out = response.getWriter();

		/*

		 * Write the HTML to the response

		 */

//		out.println("<html>");

//		out.println("<head>");

//		out.println("<title> LongPNRRetriever Servlet</title>");

//		out.println("</head>");

//		out.println("<body>");

//

//		out

//				.println("<form method='POST' action='LongPNRRetriever?action=start'>");

//		out.println("<table border='1'>");

//		out.println("<tbody>");

//

//		out.println("<tr>");

//		out.println("<td><label for='name'>Enter PNR :</label></td>");

//

//		out.println("<td><input type='text' name='pnr'></td></tr>");

//

//		out.println("<tr>");

//		out.println("<td><label for='name'>Enter PNR Crtn Date :</label></td>");

//

//		out

//				.println("<td><input type='text' name='pnrDate'>(mm/dd/yyyy)</td></tr>");

//		out.println("<tr>");

//		out.println("<td><label for='name'>Enter Email address :</label></td>");

//

//		out

//				.println("<td><input type='text' name='email'>(abc@delta.com)</td></tr>");

//		out.println("<tr>");

//		out.println("<td><label for='name'>&nbsp;</label></td>");

//

//		out.println("<td><input type='submit' value='Submit'></td></tr>");

//

//		out.println("</body>");

//		out.println("</html>");

//		

		

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");

				out.println("<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");

				out.println("<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">");

				out.println("<!-- STYLE SHEETS -->");

				out.println("<META http-equiv=\"Content-Style-Type\" content=\"text/css\">");

				out.println("<LINK href=\"/SPIL/theme/PRAMaster.css\" rel=\"stylesheet\" type=\"text/css\">");

				out.println("<LINK href=\"/SPIL%=request.getContextPath()%/theme/PRAMaster2.css\" rel=\"stylesheet\" type=\"text/css\">");

				out.println("<html>");

				out.println("<!--Header-->");

				out.println("<head>");

				out.println("<title> LongPNRRetriever Servlet</title>");

				out.println("</head>");

				out.println("<Body>");

				out.println("<div id=\"header\">");	

				out.println("	<table width=\"950\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"");

				out.println("	align=\"center\">");

				out.println("	<tr>");

				out.println("		<td>");

				out.println("		<table width=\"950\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");

				out.println("			<tr>");

				out.println("				<td width=\"34%\" background=\"/SPIL/images/topnav_bg.gif\"><a");

				out.println("					href=\"http://www.delta.com\"><img height=60");

				out.println("					src=\"/SPIL/images/topnav_bg1.gif\" width=235 border=0></a></td>");

//				out.println("				<td background=\"/SPIL/images/topnav_bg.gif\" width=\"100%\">");

//				out.println("					<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");

//				out.println("					<tr align=\"right\" height=\"30\">");

//				out.println("						<td width=\"70%\"></td>");

//				out.println("					</tr>");

//				out.println("					<tr align=\"right\" height=\"30\">");

//				out.println("						<td width=\"30%\"></td>");

//				out.println("					</tr>");

//				out.println("					</table>");

//				out.println("				</td>");

				out.println("				<td background=\"/SPIL/images/topnav_bg.gif\" width=\"100%\">");

				out.println("				<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");

				out.println("					<tr>");

				out.println("						<td align=\"right\">");

				out.println("								<a href=\"/SPIL/SPLJ/FlightInquiry.do\" target=\"blank\">SPIL</a>&nbsp;|&nbsp;"); 

				out.println("					 		  <a href=\"http://iviewer.delta-air.com/iviewer/iv\" target=\"blank\">Imaging</a>&nbsp;|");

				out.println("		 		 			 <a href=\"http://www.delta.com/planning_reservations/plan_flight/aircraft_types_layout/index.jsp\" target=\"blank\">Seat Maps</a>&nbsp;|");

				out.println("					          <a href=\"#\" onclick=\"goLogOut();\" style=\"cursor:hand;\"/>Logout</a>");

				out.println("						</td>");

				out.println("			</tr>");

				out.println("					<tr align=\"right\" height=\"30\">");

				out.println("						<td width=\"30%\"><img src=\"/SPIL/images/pnrtitle.gif\" border=\"0\" /></td>");

				out.println("					</tr>");

				out.println("				</table>");

				out.println("				</td>");

				out.println("			</tr>");

				out.println("			<tr class=\"namehead\">");

				out.println("          <td colspan=\"3\" align=\"right\">");

				out.println("			  <font color=\"#ffffff\" face=\"arial\"></font>");

				out.println("		  </td>");

				out.println("        </tr>");

				out.println("		</table>");

				out.println("		</td>");

				out.println("	</tr>");

				out.println("</table>");

				out.println("</div>	");

				out.println("<!--Main Window Content-->");

				out.println("<br>");

				out.println("<center>");

				out.println("<script language=\"javascript\">");

				out.println("function printData() {");

				out.println("    window.onbeforeprint = hideDivs;");

				out.println("    window.onafterprint = showDivs;");

				out.println("    window.print();");

				out.println("  }");

				out.println("function changeToUpper(obj){");

				out.println("	var val= obj.value;");

				out.println("	obj.value=val.toUpperCase();");

				out.println("}");

				out.println("function hideDivs () {");

				out.println("    tmp = document.getElementById('printArea');");

				out.println("    tmp.style.display = 'list-item';	");

				out.println("    tmp2 = document.getElementById('header');");

				out.println("    tmp2.style.display = 'none';");

				out.println("    tmp4 = document.getElementById('main');");

				out.println("    tmp4.style.display = 'none';	");

				out.println("    tmp6 = document.getElementById('footer');");

				out.println("    tmp6.style.display = 'none';");

				out.println("}");

				out.println("function showDivs () {");

				out.println("    tmp = document.getElementById('printArea');");

				out.println("    tmp.style.display = 'none';	");

				out.println("    tmp2 = document.getElementById('header');");

				out.println("    tmp2.style.display = 'block';");

				out.println("    tmp4 = document.getElementById('main');");

				out.println("    tmp4.style.display = 'block';	");

				out.println("    tmp6 = document.getElementById('footer');");

				out.println("    tmp6.style.display = 'block';");

				out.println("}");

				out.println("function paintMouseEvents(tableId) {");

				out.println("	  if (document.getElementById(tableId) != null){");

				out.println("	    var table = document.getElementById(tableId);");

				out.println("	    var tbody = table.getElementsByTagName(\"tbody\")[0];");

				out.println("	    var rows  = tbody.getElementsByTagName(\"tr\");");

				out.println("	    for (i=0; i < rows.length; i++) {");

				out.println("	        rows[i].onmouseover = function() { ");

				out.println("	                this.style.cursor=\"hand\";");

				out.println("	                if(this.style.backgroundColor == \"#6495ed\"){");

				out.println("						this.style.backgroundColor = \"#6495ed\";");

				out.println("	                }else{");

				out.println("	                	this.style.backgroundColor = \"#FFFFCC\";	   ");             

				out.println("	                }");

				out.println("	          };");

				out.println("	        rows[i].onmouseout = function() {");

				out.println("	                this.style.cursor='';");

				out.println("	                if(this.style.backgroundColor == \"#6495ed\"){");

				out.println("						this.style.backgroundColor = \"#6495ed\";");

				out.println("	                }else{");

				out.println("		                this.style.backgroundColor = \"#E5E6EF\";");

				out.println("	                }");

				out.println("	          };");

				out.println("			rows[i].onmousedown = function(){");

				out.println("				for (i=0; i < rows.length; i++) {");

				out.println("					rows[i].style.backgroundColor = \"#E5E6EF\";	");

				out.println("				}");

				out.println("			};");

				out.println("	        rows[i].onclick = function(i) {");

				out.println("	                this.style.cursor=\"hand\";");

				out.println("	                this.style.backgroundColor = \"#6495ED\";");

				out.println("	                document.forms[0].selPnrLoctrNum.value = this.getElementsByTagName(\"td\")[0].innerText;");

				out.println("    	            document.forms[0].selPnrCrtnDate.value = this.getElementsByTagName(\"td\")[1].innerText;");

				out.println("    	            document.forms[0].selPassenger.value = this.getElementsByTagName(\"td\")[7].innerText;");

				out.println("    	            document.forms[0].selFlightNumber.value = this.getElementsByTagName(\"td\")[4].innerText;");

				out.println("				document.forms[0].action='/SPIL/PNRJ/LookupDefaultDetailShow.do';");

				out.println("				document.forms[0].submit();");

				out.println("	          };");

				out.println("	    }");

				out.println("	  }");

				out.println("}");

				out.println("function clearSelected(){");

				out.println("	form = document.forms[0];");

				out.println("	form.selPnrLoctrNum.value = \"\";");

				out.println("	form.selPnrCrtnDate.value = \"\";");

				out.println("	form.selPassenger.value = \"\";");

				out.println("	form.selFlightNumber.value = \"\";");

				out.println("}");

				out.println("function goFOP(){");

				out.println("	document.forms[0].selectFop.value = true;");

				out.println("	if ( document.forms[0].selPnrLoctrNum.value == \"\"){");

				out.println("		document.forms[0].action='/SPIL/PNRJ/LookupDefaultSubmit.do';");

				out.println("	}else{");

				out.println("		document.forms[0].action='/SPIL/PNRJ/LookupDefaultDetailShow.do';");

				out.println("	}");

				out.println("	document.forms[0].submit();");

				out.println("}");

				out.println("function goRedisplayList(){");

				out.println("	history.go(-1);");

				out.println("}");

				out.println("function goSubmit(){");

				out.println("if (document.forms[0].email.value.length == 0){");

				out.println("alert('You must provide email.');");

				out.println("return;");

				out.println("}");

				out.println("if (document.forms[0].pnr.value.length != 6){");

				out.println("alert('You must provide a valid PNR.');");

				out.println("return;");

				out.println("}");

				out.println("if (document.forms[0].pnrDate.value.length != 10){");

				out.println("alert('You must provide a valid PNR Date');");

				out.println("return;");

				out.println("}");

				out.println("document.forms[0].submit();");

				out.println("}");

				out.println("function loadCSS() {");

				out.println("	head = document.getElementsByTagName('thead');");

				out.println("	for (i=0; i < head.length; i++ ) {");

				out.println("		if (head[i].parentElement.id == 'scrollTable') {");

				out.println("			head[i].className='fixedHeader';");

				out.println("		}");

				out.println("	}");

				out.println("	body = document.getElementsByTagName('tbody');");

				out.println("	for (i=0; i < body.length; i++ ) {");

				out.println("		if (body[i].parentElement.id == 'scrollTable') {");

				out.println("			body[i].className='scrollContent';");

				out.println("		}");

				out.println("	}");

				out.println("}");

				out.println("function replaceWhiteSpaces(s)  ");

				out.println("{ ");

				out.println("     reWhiteSpace = new RegExp(/^\\s+$/); ");

				out.println("     // Check for white space ");

				out.println("     if (reWhiteSpace.test(s)) { ");

				out.println("          //alert(\"Please Check Your Fields For Spaces\"); ");

				out.println("          document.write(s.replace(\" \", '&nbsp;'));");

				out.println("     } ");

				out.println("}");

				out.println("</script>");

				out.println("<body onload=\"loadCSS();scroll();\">");

				out.println("<div id=\"main\">");

				out.println("<table width=\"950\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"");

				out.println("	align=\"center\">");

				out.println("	<tr>");

				out.println("		<td>");

				out.println("		<div id=\"errortop\">" + responseMessage + "</div>");

				out.println("		</td>");

				out.println("	</tr>");

				out.println("</table>");

				out.println("<center>");

				out.println("<table width=\"950\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">");

				out.println("	<tr>");

				out.println("				<td align=\"right\">");

				out.println("				<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");

				out.println("					<tr>");

				out.println("						<td><img border=\"0\" src=\"/SPIL/images/tab_dlu_off.gif\" style=\"cursor:hand;\" onclick=\"location.href='/SPIL/PNRJ/LookupDefault.do'\" /></td>");

				out.println("						<td><img border=\"0\" src=\"/SPIL/images/tab_plu_off.gif\" style=\"cursor:hand;\" onclick=\"location.href='/SPIL/PNRJ/LookupPassenger.do'\" /></td>");

				out.println("						<td><img border=\"0\" src=\"/SPIL/images/tab_fnlu_off.gif\" style=\"cursor:hand;\" onclick=\"location.href='/SPIL/PNRJ/LookupFlight.do'\" /></td>");

				out.println("						<td><img border=\"0\" src=\"/SPIL/images/tab_odlu_off.gif\" style=\"cursor:hand;\" onclick=\"location.href='/SPIL/PNRJ/LookupOrigDest.do'\" /></td>");

				out.println("					</tr>");

				out.println("				</table>");

				out.println("				</td>");

				out.println("	</tr>");

				out.println("	<tr>");

				out.println("		<td>");

				out.println("		<div");

				out.println("			style=\"background-color: #E5E6EF; border-style: solid; border-color: #B1B4C5; border-width: 1px; width: 100%; height: 50px;\">");

				out.println("		<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");

				out.println("			<tr valign=\"top\">");

				out.println("				<!-- graphic start -->");

				out.println("				<td width=\"200\"><img src=\"/SPIL/images/passengersearch2.jpg\" border=\"0\"></td>");

				out.println("				<!-- graphic end -->");

				out.println("				<td width=\"672\" align=\"center\" valign=\"middle\"><form method='POST' action='LongPNRRetriever?action=start'>");

				out.println("					<table width=\"650\" align=\"center\" class=\"filter\" border=\"0\"");

				out.println("						cellpadding=\"0\" cellspacing=\"0\">");

				out.println("						<!-- default filter start -->");

				out.println("						<tr>");

				out.println("							<td>");

				out.println("							<div id=\"default\">");

				out.println("							<table border=\"0\">");

				out.println("								<tr>");

				out.println("									<td width=\"150\" align=\"right\">PNR Locator</td>");

				out.println("									<td width=\"2\"><font color=\"red\">*</font></td>");

				out.println("									<td width=\"80\" align=\"left\"><input type=\"text\" name=\"pnr\" maxlength=\"6\" size=\"10\" tabindex=\"1\" value=\"" + pnr + "\" onkeyup=\"javascript:changeToUpper(this);\"></td>");

				out.println("									<td width=\"150\" align=\"right\">PNR Crtn Date</td>");

				out.println("									<td width=\"2\"><font color=\"red\">*</font></td>");

				out.println("									<td width=\"400\" align=\"left\"><input type=\"text\" name=\"pnrDate\" maxlength=\"10\" size=\"10\" tabindex=\"2\" value=\"" + pnrDate + "\" onkeyup=\"javascript:changeToUpper(this);\">(MM/DD/YYYY)</td>");

				out.println("								</tr>");

				out.println("								<tr>");

				out.println("									<td width=\"150\" align=\"right\"></td>");

				out.println("									<td width=\"2\"><font color=\"red\"></font></td>");

				out.println("									<td width=\"80\" align=\"left\"></td>");

				out.println("									<td width=\"150\" align=\"right\">Email address</td>");

				out.println("									<td width=\"2\"><font color=\"red\">*</font></td>");

				out.println("									<td width=\"400\" align=\"left\"><input type=\"text\" name=\"email\" tabindex=\"3\" value=\"" + email + "\" size=\"30\" onkeyup=\"javascript:changeToUpper(this);\">(abc@delta.com)</td>");

				out.println("								</tr>");

				out.println("								</tr>");

				out.println("							</table>");

				out.println("							</div>");

				out.println("							</td>");

				out.println("						</tr>");

				out.println("						<!-- default filter end -->");

				out.println("						<!-- button set start -->");

				out.println("						<tr>");

				out.println("							<td>");

				out.println("							 <table width=\"100%\" align=\"center\" class=\"filter\" border=\"0\">");

				out.println("								<tr>");

				out.println("									<td width=\"70\"></td>");

				out.println("									<td width=\"5%\" align=\"right\" style=\"padding-right: 5px\"><img");

				out.println("										src=\"/SPIL/images/go_button.gif\"");

				out.println("										border=\"0\" style=\"cursor: hand;\" onclick=\"goSubmit();\"");

				out.println("										tabindex=\"7\"></td>");

				out.println("									<td width=\"70\"></td>");

				out.println("								</tr>");

				out.println("							</table>");

				out.println("							</td>");

				out.println("						</tr>");

				out.println("						<!-- button set end -->");

				out.println("						<!-- PNR help start -->");

				out.println("						<tr>");

				out.println("							<td>");

				out.println("							<table width=\"650\" align=\"center\" class=\"filter\" border=\"0\">");

				out.println("								<tr>");

				out.println("									<td align=\"left\" valign=\"middle\"><font color=\"red\">*Please note: fields with a * are required</font></td>");

				out.println("									<td align=\"right\" valign=\"middle\"><a href=\"javascript:void( window.open( 'LookupDeltaPNRCodes.do', 'pnrCodes', 'scrollbars,width=680,height=400' ))\" tabindex=\"10\"><input type=\"image\" name=\"\" src=\"/SPIL/images/logo_help.gif\" border=\"0\" style=\"cursor:hand;\">");

				out.println("										DL PNR Codes</a></td>");

				out.println("									<td align=\"right\" valign=\"middle\"><a href=\"javascript:void( window.open( 'LookupPNRCodes.do', 'pnrCodes', 'scrollbars,width=680,height=400' ))\" tabindex=\"11\"><input type=\"image\" name=\"\" src=\"/SPIL/images/logo_help.gif\" border=\"0\" style=\"cursor:hand;\">");

				out.println("										NW PNR Codes</a></td>	");

				out.println("								</tr>");

				out.println("							</table>");

				out.println("							</td>");

				out.println("						</tr>");

				out.println("						<!-- PNR help end -->");

				out.println("					</table>");

				out.println("				</form>");

				out.println("</td>");

				out.println("			</tr>");

				out.println("		</table>");

				out.println("		</div>");

				out.println("		</td>");

				out.println("	</tr>");

				out.println("	<tr>");

				out.println("		<td>&nbsp;</td>");

				out.println("	</tr>");

				out.println("</table>");

				out.println("<!-- for scroll into view--> </center>");

				out.println("</div>");

				out.println("</body>");

				out.println("</center>");

				out.println("<br>");

				out.println("<!--Footer-->");

				out.println("<script language=\"JavaScript\"> ");

				out.println("</script>");

				out.println("<div id=\"footer\">");

				out.println("<hr width=\"950\" style=\"color: red;\" size=\"1\"/>");

				out.println("<table width=\"950\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"");

				out.println("	align=\"center\">");

				out.println("	<tr>");

				out.println("		<td colspan=\"3\">" +

						"				<table width=\"100%\">" +

						"					<tr>");

				out.println("					<td align=\"left\" >");

				out.println("	    				<font color=\"red\">&nbsp;DL PNR's from 03/09/2011 to current (prior to 03/09/2011 PNRPUL) &nbsp;&nbsp;&nbsp; NW PNR's Thru 01/30/2010</font>");

				out.println("					</td>");

				out.println("					<td align=\"right\">");

//				out.println("                               <a href=\"/SPIL/LongPNRRetriever\" target=\"blank\">Email PNR</a>&nbsp;|");

				out.println("							<a href=\"/SPIL/SPLJ/FlightInquiry.do\" target=\"blank\">SPIL</a>&nbsp;|&nbsp; ");

				out.println(" 			  				<a href=\"http://iviewer.delta-air.com/iviewer/iv\" target=\"blank\">Imaging</a>&nbsp;|");

				out.println("		 		 			 <a href=\"http://www.delta.com/planning_reservations/plan_flight/aircraft_types_layout/index.jsp\" target=\"blank\">Seat Maps</a>&nbsp;|");

				out.println("   	       				<a href=\"#\" onclick=\"goLogOut();\" style=\"cursor:hand;\"/>Logout&nbsp;</a>");

				out.println("					</td>");

				out.println("				</tr>");

				out.println("				<tr style=\"width: 950px;\">");

				out.println("					<td colspan=2>");

				out.println("						<img align=\"left\" border=\"0\" src=\"./images/footer_background_DL.gif\">");

				out.println("					</td>");

				out.println("				</tr>");

				out.println("			</table>");

				out.println("    	</td>");

				out.println("    </tr>");

				out.println("</table>");

				out.println("</div>");

				out.println("</BODY>");

				out.println("</html>");

		

		

		out.close();



	}



	public static void writeText(String pnr, String pnrTextString,

			String email, String from) {



		String file = System.getProperty("NWA_DATA") + "/PNRTXT/FullPnrTxt_"

				+ pnr + ".txt";

		try {

			int pnrLines = pnrTextString.length() % 133 == 0 ? pnrTextString

					.length() / 133 : pnrTextString.length() / 133 + 1;

			int posLoc = 0;

			int noOfCharsPerline = 133;

			String NL = "\r\n";

			// FileWriter fstream = new FileWriter("C:/FullPnrTxt.txt");



			FileWriter fstream = new FileWriter(file);

			BufferedWriter out = new BufferedWriter(fstream);

			for (int lineNum = 0; lineNum < pnrLines; lineNum++) {

				if (lineNum == pnrLines - 1) {

					out.write(pnrTextString.substring(posLoc));



				} else {

					if (pnrTextString.length() >= posLoc + noOfCharsPerline) {

						out.write(pnrTextString.substring(posLoc, posLoc

								+ noOfCharsPerline)

								+ NL);

						posLoc = posLoc + noOfCharsPerline;

					}

				}

			}

			out.close();

		} catch (Exception e) {// Catch exception if any

			System.err.println("Error: " + e.getMessage());

		}

		System.out.println("Done ");



		sendfile(email, file, from);

	}



	public static String call_pnrText_lookup(String pnrLoctr,

			String pnrCrtnDte, String creationYearMo) throws Exception {



		String text = "";

		StringBuffer sqlBuffer = new StringBuffer();



		Connection conn = null;

		Statement stmt = null;

		try {

			conn = getConnection(DATA_SOURCE);

		} catch (SQLException e1) {

			e1.printStackTrace();

			throw new Exception(

					"In PNRJBean - method: call_pnrText_lookup failed.", e1);

		}



		if (conn == null) {

			throw new Exception("Connection is null");

		}



		ResultSet rs = null;



		try {



			sqlBuffer.append("select PNR_TXT from DB2CRS.T_PNRHST_TXT where  "

					+ "PNR_CRTN_YR_MO='" + creationYearMo

					+ "' and PNR_LOCTR_NUM='" + pnrLoctr

					+ "' and PNR_CRTN_DTE='" + pnrCrtnDte

					+ "' order by pnr_txt_seq_num OPTIMIZE FOR 1 ROW");



			String sql = sqlBuffer.toString();

			System.out.println("sql: " + sql);

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			long i = 0;

			while (rs.next()) {

				i = i + 1;

				text = text + rs.getString("PNR_TXT");



			}

		} catch (SQLException e) {

			System.err.println("call_pnrText_lookup failed.");

			e.printStackTrace();

			throw new Exception(" call_pnrText_lookup failed.", e);

		} finally {



			closeResources(rs, stmt, conn);

		}



		return text;



	}



	private static Connection getConnection(String dataSource)

			throws SQLException, Exception {



		DataSource ds = null;

		Connection conn = null;

		try {

			Context ctx = new InitialContext();

			ds = (DataSource) ctx.lookup(DATA_SOURCE);

			if (ds == null) {

				throw new Exception("No DB2 Datasource Found for JNDI name :"

						+ DATA_SOURCE);

			}

			conn = ds.getConnection();

			if (conn == null) {

				throw new Exception("No DB2 connection found for JNDI name :"

						+ DATA_SOURCE);

			}

		} catch (Exception e) {



			throw new Exception("No DB2 connection found for JNDI name :"

					+ DATA_SOURCE);



		}



		return conn;

	}



	private static void closeResources(ResultSet rs, Statement s, Connection c) {



		try {

			if (rs != null) {

				rs.close();

				rs = null;

			}



			if (s != null) {

				s.close();

				s = null;

			}



			if (c != null && !c.isClosed()) {

				c.close();

				c = null;

			}

		} catch (SQLException e) {

			System.err.println("error in closing resources " + e.getMessage());

		}

	}



	public static void sendfile(String email, String filename, String from) {



		String to = email;
		//String host = "smtp.nwa.com";
		String host = "smtp.delta.com";
		String msgText1 = "PNR full blob attached with this email. If you are having trouble with PNR, contact support at callcenter@delta.com.\n";

		String subject = "Requested PNR Attached";



		// create some properties and get the default Session

		Properties props = System.getProperties();

		props.put("mail.smtp.host", host);



		Session session = Session.getInstance(props, null);



		try {

			// create a message

			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(from));

			InternetAddress[] address = { new InternetAddress(to) };

			msg.setRecipients(Message.RecipientType.TO, address);

			msg.setSubject(subject);



			// create and fill the first message part

			MimeBodyPart mbp1 = new MimeBodyPart();

			mbp1.setText(msgText1);



			// create the second message part

			MimeBodyPart mbp2 = new MimeBodyPart();



			// attach the file to the message

			FileDataSource fds = new FileDataSource(filename);

			mbp2.setDataHandler(new DataHandler(fds));

			mbp2.setFileName(fds.getName());



			// create the Multipart and add its parts to it

			Multipart mp = new MimeMultipart();

			mp.addBodyPart(mbp1);

			mp.addBodyPart(mbp2);



			// add the Multipart to the message

			msg.setContent(mp);



			// set the Date: header

			msg.setSentDate(new Date());



			// send the message

			Transport.send(msg);



			// delete the file



			File f = new File(filename);

			if (!f.exists()) {

				System.out.println(filename + "- no such file or directoryto delete ");

			}

			if (!f.canWrite()) {

				System.out.println(filename + "- file write protected ");

			}

			boolean success = f.delete();



			if (success) {

				System.out.println("PNR File sent to email- "+ email +" and deleted the file from "+filename );

			}else{

				System.out.println(filename + "- File Deletion failed. ");

			}



		} catch (MessagingException mex) {

			mex.printStackTrace();

			Exception ex = null;

			if ((ex = mex.getNextException()) != null) {

				ex.printStackTrace();

			}

		}

	}



}

