<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-display.tld" prefix="display"  %>
<%java.lang.String contextPath = request.getContextPath();%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<H4>
<b>
</b>
</H4>

<%-- <% String contextpath=request.getContextPath(); %>
<% out.println(contextpath);%> --%>
<h4><PRE>Request Flight Information</PRE></h4>

<span style="display:inline-block">
<br>
<FORM ACTION="OnDemandRequestAction.do" METHOD="POST">
</span>
<span style="display:inline-block">
	 <PRE>Flight Number
<INPUT TYPE="TEXT" NAME="FlightNumOD">
</PRE>
<BR>
</span>
<span style="display:inline-block">
<PRE> Departure Date (DDMMM) 
<INPUT TYPE="TEXT" NAME="FlightDateOD">
</PRE>
<BR>
</span>
<span style="display:inline-block">
<PRE>  Origin
<INPUT TYPE="TEXT" NAME="FlightBoardingPointOD">
</PRE>
<BR>
</span>
<!-- <span style="display:inline-block">
Email :
<INPUT TYPE="TEXT" NAME="emailOD">
<BR>
</span> -->
<br>
<br>

<center>
<PRE>
<INPUT TYPE="SUBMIT" value="Submit">
</PRE>
</center>

<logic:notEmpty name="listMsgSOA">
	<logic:iterate name="listMsgSOA" id="listMsgId">
		<p>
	<pre>	<bean:write name="listMsgId"/> </pre>
		</p>
	</logic:iterate>

</logic:notEmpty>

</body>
</html>