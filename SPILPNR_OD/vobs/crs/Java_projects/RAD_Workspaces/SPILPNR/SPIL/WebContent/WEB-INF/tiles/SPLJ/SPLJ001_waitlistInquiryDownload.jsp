
<head>
<meta http-equiv=Content-Type content="text/html; charset=us-ascii">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 11">
<link rel=File-List href="spl_files/filelist.xml">
<link rel=Edit-Time-Data href="spl_files/editdata.mso">
<link rel=OLE-Object-Data href="spl_files/oledata.mso">

<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:"\,";}
@page
	{margin:1.0in .75in 1.0in .75in;
	mso-header-margin:.5in;
	mso-footer-margin:.5in;}
tr
	{mso-height-source:auto;}
col
	{mso-width-source:auto;}
br
	{mso-data-placement:same-cell;}
.style0
	{mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	white-space:nowrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:Arial;
	mso-generic-font-family:auto;
	mso-font-charset:0;
	border:none;
	mso-protection:locked visible;
	mso-style-name:Normal;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:Arial;
	mso-generic-font-family:auto;
	mso-font-charset:0;
	mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	border:none;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl24
	{mso-style-parent:style0;
	text-align:center;
	white-space:normal;}
.xl25
	{mso-style-parent:style0;
	font-weight:700;
	text-align:center;}
.xl26
	{mso-style-parent:style0;
	font-weight:700;
	text-align:center;
	white-space:normal;}
.xl27
	{mso-style-parent:style0;
	text-align:center;}
.xl28
	{mso-style-parent:style0;
	font-size:12.0pt;
	font-weight:700;
	text-align:center;
	white-space:normal;}
.xl29
	{mso-style-parent:style0;
	white-space:normal;}
.xl30
	{mso-style-parent:style0;
	font-weight:700;
	text-align:center;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl31
	{mso-style-parent:style0;
	text-align:center;
	border:.5pt solid windowtext;
	white-space:normal;}
-->
</style>

<%
response.setHeader("content-disposition", "filename=spl.xls");
response.setContentType("application/ms-xls");
%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-datetime.tld" prefix="date" %>
<%@ taglib uri="/WEB-INF/struts-display.tld" prefix="display" %>

<table border=0 cellpadding=0 cellspacing=0 width=835 style='border-collapse:collapse;table-layout:fixed;width:628pt'>
	<tr>
	   <td colspan="17" align="center" class="xl28"><b><font size="3">Special Passenger Information List</font></b></td>
	</tr>
	<tr>
	   <td colspan="17">&nbsp;</td>
	</tr>
	<tr>
       <td colspan="17" align="center" class="xl24">Download Date: <date:format pattern="MMM dd, yyyy"><date:currentTime/></date:format></td>
	</tr>
	<tr>
	   <td colspan="17">&nbsp;</td>
	</tr>
	<tr style="font-weight:bold;text-align:center;">
	   <td class="xl30">Airline</td>
	   <td class="xl30">Flight Number</td>
	   <td class="xl30">Departure Date</td>
	   <td class="xl30">PNR Locator</td>
	   <td class="xl30">Waitlist Number</td>  
	   <td class="xl30">Passenger Name</td>
	   <td class="xl30">V</td>
	   <td class="xl30">B</td>
	   <td class="xl30">R</td>
	   <td class="xl30">Origin</td>
	   <td class="xl30">Dest</td>
	   <td class="xl30">Booked Class</td>	   	   
	   <td class="xl30">Flown Class</td>
	   <td class="xl30">Standby Code</td>	 
	   <td class="xl30">Cls</td>	 
	   <td class="xl30">Seniority</td>	 
	   <td class="xl30">Time</td>	 
	</tr>	
	<logic:iterate property="selectList" id="selectList" name="waitlistInquiryForm">
		<tr style="text-align:center;">
			<td class="xl31">="<bean:write property="airlineCode" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistFlightNumber" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistLocalDepartureDate" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistPNRLocator" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistSequence" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistName" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistV" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistB" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistR" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistOrigin" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistDestination" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistBookedClass" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistFlownClass" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistType" name="selectList"/>"</td>		
			<td class="xl31">="<bean:write property="waitlistCLS" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistSeniority" name="selectList"/>"</td>
			<td class="xl31">="<bean:write property="waitlistTime" name="selectList"/>"</td>
		</tr>
	</logic:iterate>  
</table>