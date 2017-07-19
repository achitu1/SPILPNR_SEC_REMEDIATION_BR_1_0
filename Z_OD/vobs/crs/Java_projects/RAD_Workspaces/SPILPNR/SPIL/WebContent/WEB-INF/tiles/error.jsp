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
<%String contextpath = request.getContextPath();%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">

<!-- STYLE SHEETS -->
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="<html:rewrite page='/theme/PRAMaster.css'/>" rel="stylesheet" type="text/css">

<html:html>

<HEAD>
<html:base/>
<TITLE>
	Error
</TITLE>
</HEAD>

<BODY>


<!--Header-->
	<table width="950" align="center"  border="0" cellspacing="0" cellpadding="0">
		<tr>
				<td width="34%" background="<%=request.getContextPath()%>/images/topnav_bg.gif"><a
					href="http://www.delta.com"><img height=60
					src="<%=request.getContextPath()%>/images/topnav_bg1.gif" width=235 border=0></a></td>
				<td background="<%=request.getContextPath()%>/images/topnav_bg.gif" width="100%">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr align="right" height="30">
						<td width="70%"></td>
					</tr>
					<tr align="right" height="30">
						<td width="30%"></td>

					</tr>
				</table>
				</td>
				<td background="<%=request.getContextPath()%>/images/topnav_bg.gif" width="100%">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					
					<tr align="right" height="30">
						<td width="30%"><img src="<%=request.getContextPath()%>/images/pnrtitle.gif" border="0" /></td>

					</tr>
				</table>
				</td>
			</tr>
	</table>
	
<!--Main Window Content-->

	<table width="950" align="center">
		<tr>
			<td>
			<font color="red">
			 <center><b> Following errors have occured </b></center>
			</font>
			</td>
		</tr>
		<tr>
			<td>
			<font color="red"><html:errors/></font>
			</td>
		</tr>
	</table>
<br>

<TABLE width="950" border="0"class="normaltxt">
	<TR>
		<TD colspan="2">	
		</TD>
		<TD colspan="2" align="right"><a href="javascript: history.go(-1)">Return to previous page</a>
		
		</TD>
		<TD width="2%">	
		</TD>
		<TD colspan="2" align="left"><a href="<%=request.getContextPath()%>/Login.jsp">Go to Login Page</a>
		
		</TD>
		<TD colspan="2">	
		</TD>
	</TR>
</table>

<br>
<!--Footer-->
<hr width="950" style="color: red;" size="1"/>
<table width="950" cellpadding="0" cellspacing="0" border="0"
	align="center">
	<tr>
		<td align="left" width="5%"></td>
	</tr>
	<tr bgcolor=#f2f2f7>
		<td align=right background="<%=request.getContextPath()%>/images/footer_background_DL.gif" height=23></td>
	</tr>
</table>
</BODY>
</html:html>
