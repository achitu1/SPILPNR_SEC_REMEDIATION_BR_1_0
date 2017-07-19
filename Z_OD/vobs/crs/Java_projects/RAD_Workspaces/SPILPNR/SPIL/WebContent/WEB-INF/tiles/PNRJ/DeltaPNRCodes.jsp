<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!--
	PNR Code Prototype version 1.0 
	ICE 12-01-2004
	All data are mocked/static
	/images and /theme folders are needed by this file
	Delta PNR Codes have been updated on 03/15/2011
-->
<html>
<!--Header-->
<head>
<!--<title>PNR Codes</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->
<title>Delta PNR Codes</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/theme/PRAMaster.css" />
<LINK href="<html:rewrite page='<%=request.getContextPath()%>/theme/PRAMaster2.css'/>" rel="stylesheet" type="text/css">
<LINK href="<html:rewrite page='/theme/PRAMaster.css'/>" rel="stylesheet" type="text/css">
<STYLE>
.titleHelp {
	color: black;
	font-weight: bold;
	padding-top: 2px;
	padding-bottom:2px;
}
.subHelp {
	padding-top: 15px;
	padding-bottom:2px;
}
.returnToTop {
	padding-top:10px;
	padding-bottom:10px;
}
</STYLE>
<script type="text/javascript" language="JavaScript">
	function closeWin(){
		window.close();
		return true;
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" rightmargin="0" bgcolor="#ffffff">
<!--main table start-->
<table width="600">
<tr>
	<td>
		<!-- This is the start of the image header -->
		<table width="600" align="center">
			<tr>
				<td width="40%">
					<!-- tiles:logo -->
					<table align="left">
					<tr>
						<td>
							<img src="<%=request.getContextPath()%>/images/topnav_bg1.gif" width="100" border="0" />
						</td>
					</tr>
					</table>
					<!-- end of tiles:logo -->
				</td>
			</tr>
		</table>
		<!-- This is the end of the image header -->
	</td>
</tr>

<!-- This is the start of the header -->
<tr>
	<td>
		<table width="600" align="left">
			<tr>
				<td>
				<table width="100%">
					<tr>
						<td align="left"><span id="headermessages"><font color="red">PNR Codes Look-up</font></span></td>
						<td align="right"><a href="#" onClick="closeWin();" ><img src="<%=request.getContextPath()%>/images/btn_close_window.gif" border="0" width="89" height="15" alt="Close Window"></a></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td><hr width="600" size="1"/></td>
</tr>
<tr><td>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td align="left" colspan="3"><b>Legend: </b></td></tr>
	<tr><td width="100" align="left" valign="top">AAC</td>
		<td width="100" align="center" valign="top"> - </td>
		<td width="250" valign="top">ACTION ADVICE CODES</td>
	</tr>	
	<tr><td width="100" align="left">FLT</td>
		<td width="100" align="center"> - </td>
		<td width="250">FLIGHT INFO</td>
	</tr>
	<tr><td width="100" align="left">HIS</td>
		<td width="100" align="center"> - </td>
		<td width="250">HISTORY</td>
	</tr>
	<tr><td width="100" align="left">OTH</td>
		<td width="100" align="center"> - </td>
		<td width="250">OTHER</td>
	</tr>
	<tr><td width="100" align="left">SCH</td>
		<td width="100" align="center"> - </td>
		<td width="250">SCHEDULE CHANGE CODES</td>
	</tr>	
	<tr><td width="100" align="left">SSR</td>
		<td width="100" align="center"> - </td>
		<td width="250">SPECIAL SERVICE REQUEST</td>
	</tr>
	<tr><td width="100" align="left">BARTS</td>
		<td width="100" align="center"> - </td>
		<td width="250">BARTS TRANSACTION CODES</td>
	</tr>
	<tr><td width="100" align="left">TKT</td>
		<td width="100" align="center"> - </td>
		<td width="250">TICKETING CODES</td>
	</tr>
	<tr><td width="100" align="left">SEAT</td>
		<td width="100" align="center">  </td>
		<td width="250"></td>
	</tr></table>

	<logic:iterate name="pnrHelpCodeForm" property="helpCodes" id="helpCodes">
	
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<logic:match value=":" name="helpCodes" property="code">
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
					<tr><td align="left" colspan="3"><b><bean:write name="helpCodes" property="code"/></b></td></tr>
					<tr><td width="100" align="left" valign="top"><b>Code</b></td>
						<td width="100" align="center" valign="top"><b>Type</b> </td>
						<td width="250" valign="top"><b>Description</b></td>
					</tr>
				</logic:match>
				<logic:notMatch value=":" name="helpCodes" property="code">
				<tr><td width="100" align="left" valign="top"><bean:write name="helpCodes" property="code"/></td>
					<td width="100" align="center" valign="top"><bean:write name="helpCodes" property="type"/></td>
					<td width="250" valign="top"><bean:write name="helpCodes" property="definition"/></td>
				</tr>
				</logic:notMatch>
	</table>			
	</logic:iterate>
</td></tr>
<!-- This is the end of the header -->

</table>
</body>
</html>