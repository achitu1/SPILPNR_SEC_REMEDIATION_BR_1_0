<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-datetime.tld" prefix="date"%>

<%
	String contextpath = request.getContextPath();
	String path = contextpath + "/PNRJ/redirectApp.do";
	String pathOD = contextpath+"/SPLJ/OnDemandFlightInquiry.do";
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
<form>
<div id="footer">
<hr width="950" style="color: red;" size="1" />
<table width="950" cellpadding="0" cellspacing="0" border="0"
	align="center">
	<tr>
		<!--<td align="left" width="5%"></td>
		  <td align="left" width="5%"><a
			href="mailto:revacctwebmaster@nwa.com"><img
			src="<%=contextpath%>/images/email1.gif" border="0"></a></td>
		<td align="left" width="55%">&nbsp;</td>
		<td colspan="3"><table width="100%"><tr>-->
		<td align="left" >
	    <font color="red">&nbsp;DL SPILs from 03/09/2011 through current (Cancel SPILs from 09/23/2012) &nbsp;&nbsp;&nbsp; NW SPILs Thru 01/30/2010</font>
		</td>
		<td align="right"><logic:present role="queryonly,querycc">
			<html:link href="<%=path%>" target="blank"> PNR</html:link>&nbsp;|&nbsp; 
				</logic:present> <logic:notPresent role="queryonly,querycc">		
				 PNR&nbsp;|&nbsp; 
				</logic:notPresent>
				<!-- On Demand addition -->
				<logic:present role="SppOnDemondUser">
			<html:link href="<%=pathOD%>" target="blank">On Demand</html:link>&nbsp;|&nbsp; 
				</logic:present> <logic:notPresent role="SppOnDemondUser">		
				 PNR&nbsp;|&nbsp; 
				</logic:notPresent>
				<!-- end -->
		<html:link href="http://iviewer.delta-air.com/iviewer/iv"
			target="blank">Imaging</html:link>&nbsp;| 
			<html:link href="http://www.delta.com/planning_reservations/plan_flight/aircraft_types_layout/index.jsp" target="blank">Seat Maps</html:link>&nbsp;|
			<a href="#"
			onclick="goLogOut();" style="cursor: hand;" >Logout </a> &nbsp;</td></tr>	
		<tr style="width: 950px;">
				<td colspan=2>
				<img align="left" border="0" src="<%=contextpath%>/images/footer_background_DL.gif">
				</td>
 		</tr>	
</table>
</div>

<table width="950" align="center" cellpadding="0" cellspacing="0" border="0" style="margin: 0px">

</table>
</form>
