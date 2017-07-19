<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>

	<% String contextpath=request.getContextPath(); 

	String path = contextpath+"/SPLJ/FlightInquiry.do";%>



<script type="text/javascript">

	function goLogOut(){

		tmp = confirm("You are about to log out of this application. \nProceed?");

		if (tmp){

			if (document.logout == null){
/// defect #3 code change begins
				open(location, '_self').close();
/// defect #3 code change ends
			    var logoutForm = document.createElement("<FORM METHOD='post' ACTION='ibm_security_logout' NAME='logout'></FORM>");

			    document.body.insertBefore(logoutForm);



				document.logout.submit();

				window.close();

			}

		}

	}

   

</script>



<div id="nav">

<table width="100%" cellpadding="0" cellspacing="0" border="0"

	align="center">

	<tr>

		<td align="left" width="5%">&nbsp;</td>

		<td align="right" width="10%"><logic:present role="queryonly,querycc">

			<html:link href="<%=path%>" target="blank"> PNR</html:link>&nbsp;|&nbsp; 

				</logic:present> <logic:notPresent role="queryonly,querycc">		

				 PNR&nbsp;|&nbsp; 

				</logic:notPresent> <html:link href="http://iviewer.delta-air.com/iviewer/iv" target="blank">Imaging</html:link>&nbsp;|

				<html:link href="http://www.delta.com/planning_reservations/plan_flight/aircraft_types_layout/index.jsp" target="blank">Seat Maps</html:link>&nbsp;|

		<a href="" onclick="goLogOut();" style="cursor: hand;" >Logout </a></td>

	</tr>

</table>



</div>

