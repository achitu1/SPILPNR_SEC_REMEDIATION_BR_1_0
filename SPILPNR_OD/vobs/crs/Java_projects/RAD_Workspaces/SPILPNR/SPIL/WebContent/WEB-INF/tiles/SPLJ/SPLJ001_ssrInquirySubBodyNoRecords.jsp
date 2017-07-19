<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-display.tld" prefix="display" %>

<!-- list start -->
<table width="100%" cellpadding="0" cellspacing="0"><tr><td>
<font color="red" style="text-align: right;">DL SPILs from 03/09/2011 through current (Cancel SPILs from 09/23/2012) &nbsp;&nbsp;&nbsp; NW SPILs Thru 01/30/2010</font>
</td></tr></table>
<div id="tableContainer" style="overflow-y:auto;height:227px; width:100%;border:1px solid #B1B4C5;">			
<table style="margin-top:1px;text-align:center; width:100%;;" cellspacing="1">
	<thead class="fixedHeader">
	<tr>
		<th style="text-align:center;width:5%"><bean:message key="spl.default.header.field.airline"/></th>
		<th style="text-align:center;width:7%"><bean:message key="spl.default.header.field.flightNumber"/></th>
		<th style="text-align:center;width:7%"><bean:message key="spl.default.header.field.boardPoint"/></th>
		<th style="text-align:center;width:8%"><bean:message key="spl.default.header.field.localDepartureDate"/></th>
		<th style="text-align:center;width:12%"><bean:message key="spl.default.header.field.passengerName"/></th>
		<th style="text-align:center;width:10%"><bean:message key="spl.default.header.field.ssrCde"/></th>
		<th style="text-align:center;width:12%"><bean:message key="spl.default.header.field.remarks"/></th>
		<th style="text-align:center;width:10%"><bean:message key="spl.default.header.field.class"/></th>
		<th style="text-align:center;width:6%"><bean:message key="spl.default.header.field.seatAssignment"/></th>
		<th style="text-align:center;width:10%"><bean:message key="spl.default.header.field.pnrLocator"/></th>
	</tr>
	</thead>
	<tbody class="scrollContent">
		<tr><td width="100%" align="center" colspan="10"><bean:message key="error.no.record"/></td></tr>
	</tbody>
</table>
</div>
