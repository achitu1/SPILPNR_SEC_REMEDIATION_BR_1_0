<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<html>

<head>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<META name="GENERATOR" content="IBM WebSphere Studio">

<META http-equiv="Content-Style-Type" content="text/css">

<META HTTP-EQUIV="Expires" CONTENT="0">

<META HTTP-EQUIV="Pragma" CONTENT="no-cache">

<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">

<LINK href="./theme/PRAMaster.css" rel="stylesheet" type="text/css">

<script type="text/javascript" language="JavaScript">

function resetFields(){

	document.loginForm.j_username.value = ''

	document.loginForm.j_password.value = ''

}

</script>

</head>

<body>

<form method="POST" action="j_security_check" name="loginForm">

<div id="logo">

<table width="950" border="0" cellspacing="0" cellpadding="0"

	align="center">

	<tr>

		<td>



		<table border="0" cellspacing="0" cellpadding="0">





			<tr>

				<td width="34%" background="./images/topnav_bg.gif"><a

					href="http://www.delta.com"><img height=60

					src="./images/topnav_bg1.gif" width=235 border=0></a></td>

				<td background="./images/topnav_bg.gif" width="100%">

				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr align="right" height="30">

						<td width="70%"></td>

					</tr>

					<tr align="right" height="30">

						<td width="30%"></td>



					</tr>

				</table>

				</td>

				<td background="./images/topnav_bg.gif" width="100%">

				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr align="right" height="30">

						<td width="70%"><img src="./images/spiltitle.gif" border="0" /></td>

					</tr>

					<tr align="center" height="30">

						<td width="30%"><img src="./images/pnrtitle.gif" border="0" /></td>



					</tr>

				</table>

				</td>

			</tr>



		</table>

		</td>

	</tr>

</table>



</div>



<br>

<br>



<TABLE border="0" align="center" bgcolor="#b1b4c5" width="280">

	<TR>

		<TD colspan="3" align="center"><span id="boldfont">Please

		login with your 6 digit - Delta Id and password</span></TD>

	</TR>

</table>

<TABLE border="0" align="center">

	<TR>

		<TD colspan="3" align="center"></TD>

	</TR>

</table>

<TABLE border="0" align="center" bgcolor="#e5e6ef" width="280">

	<TBODY>

		<TR>

			<TH align="right"></TH>

			<TD colspan="2"></TD>

		</TR>

		<TR>

			<TH align="right">User Id</TH>

			<TD colspan="2"><input type="text" name="j_username"

				maxlength="12" value=""></TD>

		</TR>



		<TR>

			<TH align="right">Password</TH>

			<TD colspan="2"><input type="password" name="j_password"

				value=""></TD>

		</TR>

		<TR>

			<td></td>

			<TD colspan="2"><input type="image" name="goBtn"

				src="./images/go_button.gif"> <a href=""

				onClick="document.loginForm.reset(); return false;"

				onMouseOver="window.status='Reset'; return true;"

				onMouseOut="window.status=''; return true;"><img

				src="./images/reset_button.gif" border="0" alt="Reset"></a> <!-- <input type="image" name="resetBtn" src="/PNRJWEB/images/reset_button.gif" onClick="resetFields()"> -->

			</TD>

		</TR>

	</TBODY>

</TABLE>

<script language="javascript">document.forms[0].j_username.focus();</script>

</form>



<div id="footer">

<hr width="950" style="color: red;" size="1" />

<table width="950" cellpadding="0" cellspacing="0" border="0"

	align="center">

	<tr>

		<td align="left" width="5%"></td>

		 

	</tr>

<tr style="width: 950px;">

				<td colspan=2>

				<img align="left" border="0" src="./images/footer_background_DL.gif">

				</td>

 		</tr>

</table>





</div>

</body>

</html>