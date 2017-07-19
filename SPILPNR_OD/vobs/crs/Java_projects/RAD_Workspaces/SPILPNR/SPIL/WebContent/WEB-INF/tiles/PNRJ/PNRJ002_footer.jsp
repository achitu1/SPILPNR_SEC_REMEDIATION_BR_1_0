<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-datetime.tld" prefix="date"%>
<%
	String contextpath = request.getContextPath();
	String path = contextpath + "/SPLJ/FlightInquiry.do";
%>

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

<div id="footer">
<hr width="950" style="color: red;" size="1" />
<table width="950" cellpadding="0" cellspacing="0" border="0"
	align="center">
	<tr>
		<td colspan="3">
		<table width="100%"  width="950" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td align="left"><font color="red">&nbsp;DL PNR's from
				03/09/2011 to current (prior to 03/09/2011 PNRPUL)
				&nbsp;&nbsp;&nbsp; NW PNR's Thru 01/30/2010</font></td>

				<td align="right">
				<logic:present role="authorizedUsers">
					<html:link href="<%=path%>" target="blank"> SPIL</html:link>&nbsp;|&nbsp; 
		</logic:present> <logic:notPresent role="authorizedUsers">		
				 SPIL&nbsp;|&nbsp; 
		</logic:notPresent> <html:link href="http://iviewer.delta-air.com/iviewer/iv"
					target="blank">Imaging</html:link>&nbsp;| <html:link
					href="http://www.delta.com/planning_reservations/plan_flight/aircraft_types_layout/index.jsp"
					target="blank">Seat Maps</html:link>&nbsp;| <a href="#"
					onclick="goLogOut();" style="cursor: hand;" >Logout</a>&nbsp;</td>
			</tr>
			<tr>
				<td colspan=2>
				<img align="left" border="0" src="<%=contextpath%>/images/footer_background_DL.gif">
				</td>
			</tr>
		</table>
		</td>
		</tr>
		</table>
		</div>