<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%String contextPath = request.getContextPath();

	String spilPath = contextPath+"/OnDemandFlightInquiry.do";

	String pnrPath = contextPath+"/OnDemandredirectApp.do";

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<html>

<head>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<META name="GENERATOR" content="IBM WebSphere Studio">

<META http-equiv="Content-Style-Type" content="text/css">

<META HTTP-EQUIV="Expires" CONTENT="0">

<META HTTP-EQUIV="Pragma" CONTENT="no-cache">

<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">

<LINK href="<%=contextPath%>/theme/PRAMaster.css" rel="stylesheet" type="text/css">



<script language="JavaScript"> 

<!-- 

function gotoSpil(){

	

	document.forms[0].action='<%=spilPath%>';

	document.forms[0].submit();



} 



function gotoPnr(){

	

	document.forms[0].action='<%=pnrPath%>';

	document.forms[0].submit();



} 

	function goLogOut(){

		tmp = confirm("You are about to log out of this application. \nProceed?");

		if (tmp){

			if (document.logout == null){
/// defect #3 code change begins
				open(location, '_self').close();
/// defect #3 code change ends
			    var logoutForm = document.createElement("<FORM METHOD='post' ACTION='ibm_security_logout?logoutExitPage=login.do' NAME='logout'></FORM>");

			    document.body.insertBefore(logoutForm);



				document.logout.submit();

				window.close();

			}

		}

	}

  

//-->

</script>





</head>

<body>

<form>

<div id="logo">

<table width="950" border="0" cellspacing="0" cellpadding="0"

	align="center">

	<tr>

		<td>



		<table border="0" cellspacing="0" cellpadding="0">





			<tr>

				<td width="34%" background="<%=contextPath%>/images/topnav_bg.gif"><a

					href="http://www.delta.com"><img height=60

					src="<%=contextPath%>/images/topnav_bg1.gif" width=235 border=0></a></td>

				<td background="<%=contextPath%>/images/topnav_bg.gif" width="100%">

				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr align="right" height="30">

						<td width="70%"></td>

					</tr>

					<tr align="right" height="30">

						<td width="30%"></td>



					</tr>

				</table>

				</td>

				<td background="<%=contextPath%>/images/topnav_bg.gif" width="100%">

				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr align="right" height="30">

						<td width="70%"><img src="<%=contextPath%>/images/spiltitleOnDemand.gif" border="0" /></td>

					</tr>
<%-- 
					<tr align="center" height="30">

						<td width="30%"><img src="<%=contextPath%>/images/pnrtitleOnDemand.gif" border="0" /></td>



					</tr>
 --%>
				</table>

				</td>

			</tr>

			

			<tr class="namehead">

          <td colspan="3" align="right">

			  <%String name = (String) session.getAttribute("employeeName");%>

			  <font color="#ffffff" face="arial"><strong>Welcome, <%=name%></strong></font>

		  </td>

        </tr>

		</table>

		</td>

	</tr>

</table>



</div>

<TABLE border="0" align="center" width="280">

		<TBODY>		

			<TR>

				<TH align="right" ></TH>

				<TD colspan="2"></TD>

			</TR>

			<TR>

				<logic:present role="authorizedUsers">		

				<td colspan="2"><html:link action="/SPLJ/FlightInquiry.do" style="color: blue;"><h3> SPIL</h3></html:link></td>

				</logic:present>

				<logic:notPresent role="authorizedUsers">		

				<td colspan="2"><h3> SPIL</h3></td>

				</logic:notPresent>

			</TR>
			
			<TR>

		<logic:present role="SppOnDemondUser">		
 
				<td colspan="2"><html:link action="/SPLJ/OnDemandFlightInquiry.do" style="color: blue;"><h3> SPIL On-Demand</h3></html:link></td>

				</logic:present>

				<logic:notPresent role="SppOnDemondUser">		

				</logic:notPresent> 

			</TR>



			<TR>

				

				<logic:present role="queryonly,querycc">	

				 <td colspan="2"><html:link action="/PNRJ/redirectApp.do" style="color: blue;"><h3> PNR</h3></html:link> </td>

				</logic:present> 

				<logic:notPresent role="queryonly,querycc">		

				<td colspan="2"><h3> PNR</h3></td>

				</logic:notPresent>

			</TR> 

				

			

		</TBODY>

</TABLE>

</form>

<div id="footer">

<hr width="950" style="color: red;" size="1" />

<table width="950" cellpadding="0" cellspacing="0" border="0"

	align="center">

	<tr>

		<td align="left" width="5%"></td>

		

		<td align="right"><a href="#" onclick="goLogOut();" style="cursor:hand;" >Logout </a>&nbsp;</td>	

	</tr>

	<tr style="width: 950px;">

				<td colspan=2>

				<img align="left" border="0" src="<%=contextPath%>/images/footer_background_DL.gif">

				</td>

 		</tr>

</table>





</div>



</body>

</html>