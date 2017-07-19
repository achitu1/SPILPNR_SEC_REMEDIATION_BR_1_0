<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-datetime.tld" prefix="date" %>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<% String contextpath=request.getContextPath(); %>
<html:html>
<div id="footer">

<table width="872" cellpadding="0" cellspacing="0" border="0"
	align="center">
	<tr>
	<td colspan="3"><table width="100%"><tr>
	
	<td align="left" >
	    <font color="red">DL PNR's from 03/09/2011 to current (prior to 03/09/2011 PNRPUL) &nbsp;&nbsp;&nbsp; NW PNR's Thru 01/30/2010</font>
	</td>
		<td align="right">
		  <html:link href="http://www.prap7.nwa.com/SPLJWEB" target="blank">SPIL</html:link>&nbsp;|&nbsp;
 		  <html:link href="http://iviewer.delta-air.com/iviewer/iv" target="blank">Imaging</html:link>&nbsp;|
 		  <html:link href="http://www.delta.com/planning_reservations/plan_flight/aircraft_types_layout/index.jsp" target="blank">Seat Maps</html:link>&nbsp;|
          <a href="<%=request.getContextPath()%>/PNRJ/redirectApp.do" onclick="goLogOut();" style="cursor:hand;">Logout</a>
		</td></tr></table></td>	
	</tr>
	<tr bgcolor=#f2f2f7>
		<td align=right background="<%=contextpath%>/images/footer_background.gif" height=23 colspan="3"><small
			class=copyright>&nbsp; &nbsp;
		&nbsp;
		
		</small></td>
		
	</tr>
</table>


</div>

</html:html>

