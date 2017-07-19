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
		<TD class= "errmsg" colspan="3" align="center"><b>ERROR</b> - invalid login please try again.</TD>
	</TR>
	<TR>
		<TD colspan="3" align="center">Note - if your login fails 3 times, your account will become locked.<br>If this occurs, please contact the help desk to have your Active Directory account reset.</TD>
	</TR>
</table>
<TABLE border="0" align="center" class="normaltxt">
	<TR>
		<TD colspan="3" align="center"><a href="<%=request.getContextPath()%>/Login.jsp">Return to Login page.</a></TD>
	</TR>
</table>
</form>

	<div id="footer">
<hr width="950" style="color: red;" size="1" />
<table width="950" cellpadding="0" cellspacing="0" border="0"
	align="center">
	<tr>
		<td align="left" width="5%"></td>
	</tr>
<tr style="width: 950px;">
				<td >
				<img align="left" border="0" src="./images/footer_background_DL.gif">
				</td>
 		</tr>
</table>


</div>
</html>
