<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<LINK href="<%=request.getContextPath()%>/theme/PRAMaster.css" rel="stylesheet" type="text/css">
<form method="POST" action="j_security_check">
<div id="logo">
<table width="950" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr>
		<td>

		<table border="0" cellspacing="0" cellpadding="0" width="100%">


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
						<td width="70%"><img src="<%=request.getContextPath()%>/images/spiltitle.gif" border="0" /></td>
					</tr>
					<tr align="center" height="30">
						<td width="30%"><img src="<%=request.getContextPath()%>/images/pnrtitle.gif" border="0" /></td>

					</tr>
				</table>
				</td>
			</tr>

		</table>
		</td>
	</tr>
</table>

</div>
<TABLE border="0" align="center">
	<TR>
		<TD class= "errmsg" colspan="3" align="center"><b>ERROR</b> - Not Authorized.</TD>
	</TR>
	<TR>
		<TD colspan="3" align="center">you are not authorized to view this page.</TD>
	</TR>
</table>
<TABLE border="0" align="center" class="normaltxt">
	<TR>
		<TD colspan="3" align="center"><a href="javascript: history.go(-1)">Return to previous page.</a>
		
		</TD>
	</TR>
</table>
</form>

	<div id="footer">
<hr width="950" style="color: red;" size="1" />
<table width="950" cellpadding="0" cellspacing="0" border="0"
	align="center">
	<tr>
		<td align="left" width="5%"><a
			href="mailto:revacctwebmaster@nwa.com"><img
			src="<%=request.getContextPath()%>/images/email1.gif" border="0"></a></td>
	</tr>
	<tr bgcolor=#f2f2f7>
		<td align=right background="<%=request.getContextPath()%>/images/footer_background.gif" height=23></td>
	</tr>
</table>


</div>
</html>
