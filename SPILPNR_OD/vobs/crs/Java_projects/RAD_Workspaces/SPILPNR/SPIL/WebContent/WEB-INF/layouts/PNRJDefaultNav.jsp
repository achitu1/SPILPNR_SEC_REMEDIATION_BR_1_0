
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">

<!-- STYLE SHEETS -->
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="<html:rewrite page='/theme/PRAMaster.css'/>" rel="stylesheet" type="text/css">
<LINK href="<html:rewrite page='<%=request.getContextPath()%>/theme/PRAMaster2.css'/>" rel="stylesheet" type="text/css">

<% String contextpath=request.getContextPath(); 
	String path = contextpath+"/SPLJ/FlightInquiry.do";%>

<script language="JavaScript"> 
<!-- 	
	function goLogOut(){
		tmp = confirm("You are about to log out of this application. \nProceed?");
		if (tmp){
			if (document.logout == null){/// defect #3 code change begins				open(location, '_self').close();/// defect #3 code change ends
			    var logoutForm = document.createElement("<FORM METHOD='post' ACTION='ibm_security_logout?logoutExitPage=/index.jsp' NAME='logout'></FORM>");
			    document.body.insertBefore(logoutForm);

				document.logout.submit();
				window.close();
			}
		}
	}
  
//-->
</script>

<html:html>
<!--Header-->
<tiles:importAttribute name="title" />
<Body>
<div id="header">	

	<table width="950" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr>
		<td>

		<table border="0" cellspacing="0" cellpadding="0" width="950">
			<tr>
				<td width="34%" background="<%=contextpath%>/images/topnav_bg.gif"><a
					href="http://www.delta.com"><img height=60
					src="<%=contextpath%>/images/topnav_bg1.gif" width=235 border=0></a></td>
				<td background="<%=contextpath%>/images/topnav_bg.gif" width="100%">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="right">
							<logic:present role="authorizedUsers">
								<html:link href="<%=path%>" target="blank"> SPIL</html:link>&nbsp;|&nbsp; 
									</logic:present> <logic:notPresent role="authorizedUsers">		
									 SPIL&nbsp;|&nbsp; 
									</logic:notPresent>
					 		  <html:link href="http://iviewer.delta-air.com/iviewer/iv" target="blank">Imaging</html:link>&nbsp;|
					 		  <html:link href="http://www.delta.com/planning_reservations/plan_flight/aircraft_types_layout/index.jsp" target="blank">Seat Maps</html:link>&nbsp;|
					          <a href="#" onclick="goLogOut();" style="cursor:hand;">Logout</a>
						</td>
					</tr>
					<tr align="right" height="30">
						<td width="30%"><img src="<%=contextpath%>/images/pnrtitle.gif" border="0" /></td>

					</tr>
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

<!--Main Window Content-->
<br>
<center>
<tiles:insert attribute="mainwindow" />
</center>
<br>

<!--Footer-->
<tiles:insert attribute="footer" />

</BODY>
</html:html>
