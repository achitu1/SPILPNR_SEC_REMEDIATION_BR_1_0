<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-display.tld" prefix="display" %>
<%java.lang.String contextPath = request.getContextPath();%>
<script>

</script>


<!-- list start -->
<tr><td align="right">
	<table width="100%" id="buttonArea" border="0"><tr>
		<td align="left" >
	    	<font color="red">DL SPILs from 03/09/2011 through current (Cancel SPILs from 09/23/2012) &nbsp;&nbsp;&nbsp; NW SPILs Thru 01/30/2010</font>
			</td>
		<td align="right">
		    <a href="javascript:printData();"><img src="<%=request.getContextPath()%>/images/print.gif" border="0">Print SPIL Detail</a>	
		</td>
		<td align="right" valign="bottom" width="9%">
			<html:image	page="/images/redisplay_list_btn.gif" border="0"	style="cursor:hand;" />
		</td>
	</tr>
	</table>

	<div id="printArea">
		<table border="0" width="100%" style="text-align:center;" cellpadding="0" cellspacing="0" class="sub_table">
			<tbody>
			<tr style="padding-top:10px;">
				<td colspan="13" align="center" style="font-size:9pt;">
				<b>	<bean:message key="spl.selected.field.SEAT" /> : <font color="#336699"><bean:write property="selRowSeat" name="ssrInquiryForm" /></font>&nbsp;&nbsp;&nbsp;&nbsp;
				<bean:message key="spl.selected.field.PASSENGER" /> : <font color="#336699"><bean:write property="selPassenger" name="ssrInquiryForm" /></font>&nbsp;&nbsp;&nbsp;&nbsp;
				<bean:message key="spl.selected.field.CUST_ID" /> : <font color="#336699"><bean:write property="customerID" name="ssrInquiryForm" /></font>&nbsp;&nbsp;&nbsp;&nbsp;
				<bean:message key="spl.selected.field.CNCLIND" /> : <font color="#336699"><bean:write property="cnclInd" name="ssrInquiryForm" /></font>
				</b></td>
			</tr>	
			
		<tr style="padding-top:10px;padding-left:16px;">
			<td colspan="11" >
				<table align="left" border="0" width="98%">
					<tr>
						<td width="10%"  align="left" style="padding-left:20px;"><bean:message key="spl.selected.field.FLIGHT" /><br/><bean:message key="spl.selected.field.FLIGHTNUMBER"/></td> 
						<td width="10%" align="left" style="padding-left:2px;padding-right:2px;"><bean:message key="spl.selected.field.LOCALDEPARTUER" /><br/><bean:message key="spl.selected.field.DATE" /></td>
						<td width="7%" align="left" style="padding-left:6px;padding-right:1px;"><bean:message key="spl.selected.field.BOARDPOINT" /><br/><bean:message key="spl.selected.field.POINT" /></td>
						<td width="7%" align="left" style="padding-left:6px;padding-right:1px;"><bean:message key="spl.selected.field.OFFPOINT" /><br/><bean:message key="spl.selected.field.POINT" /></td>
						<td width="6%" align="left" style="padding-left:8px;padding-left:6px;"><bean:message key="spl.selected.field.FARE" /><br/><bean:message key="spl.selected.field.CLASS" /></td>
						<td width="6%" align="left" style="padding-left:1px;padding-right:1px;"><bean:message key="spl.selected.field.BOOKED" /><br/><bean:message key="spl.selected.field.CMPT" /></td>
						<td width="6%" align="left" style="padding-left:1px;padding-right:6px;"><bean:message key="spl.selected.field.FLOWN" /><br/><bean:message key="spl.selected.field.CMPT" /></td>
						<td width="6%" align="left" style="padding-left:1px;padding-right:6px;"><bean:message key="spl.selected.field.PSGR" /><br/><bean:message key="spl.selected.field.TYPE" /></td>
						<td colspan="2" width="13%" align="center" style="padding-left:0px;padding-right:6px;"><br/><bean:message key="spl.selected.field.CONNECTINGFROM" /></td>
						<td colspan="2" width="13%" align="center" style="padding-left:0px;padding-right:6px;"><br/><bean:message key="spl.selected.field.CONNECTINGTO" /> &nbsp;</td>
					</tr>			
					<tr>
						<td align="left" style="padding-left:18px;"><html:text size="10" property="flightNum" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"/></td>
						<td align="left" style="padding-left:2px;padding-right:2px;"><html:text property="depDate" size="14" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"/></td>
						<td align="left" style="padding-left:6px;padding-right:1px;"><html:text property="boardPoint" size="6" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>
						<td align="left" style="padding-left:6px;padding-right:1px;"><html:text property="offPoint" size="6" name="ssrInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>
						<td align="left" style="padding-left:8px;padding-left:6px;"><html:text property="class1" size="6" name="ssrInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>
						<td align="left" ><html:text property="bookedClass" size="3" name="ssrInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>
						<td align="left" ><html:text property="flownClass" size="3" name="ssrInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>			
						<td align="left" ><html:text property="type" size="3" name="ssrInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>
						<td align="center"><html:text property="conFrom1" size="5" name="ssrInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>
						<td align="center"><html:text property="conFrom2" size="5" name="ssrInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>
						<td align="center"><html:text property="conTo1" size="5" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>
						<td align="center"><html:text property="conTo2" size="5" name="ssrInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr style="padding-top:10px;padding-left:16px;"><td colspan="11"><table align="left" border="0" width="98%">
			<tr>
				<td width="9%" align="left" style="padding-left:15px;padding-right:3px;"><bean:message key="spl.selected.field.PNR" />
				<td  colspan="2" style="padding-left:17px;" valign="bottom"><bean:message key="spl.selected.field.PNR_CREATE_DT" /></td>
				<td colspan="2" style="padding-left:8px;" valign="bottom"><bean:message key="spl.selected.field.TKT_NUMBER" /></td>
				<td colspan="2" style="padding-left:15px;" valign="bottom"><bean:message key="spl.selected.field.TICKET_ISSUE_DT" /></td>
				<td align="left" valign="bottom" style="padding-left:15px;"><bean:message key="spl.selected.field.CHECKIN_DT" /></td>
				<td align="left" valign="bottom" style="padding-left:15px;"><bean:message key="spl.selected.field.CHECKIN_TM" /></td>
				<td align="left" valign="bottom" style="padding-left:15px;"><bean:message key="spl.selected.field.ONBOARD_DT" /></td>
				<td align="left" valign="bottom" style="padding-left:15px;"><bean:message key="spl.selected.field.ONBOARD_TM" /></td>
				
			</tr>			
			<tr>
				<td align="left" valign="top" style="padding-left:15px;"><html:text property="pnr" size="10" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>
				<td colspan="2"  valign="top" style="padding-left:17px;"><html:text property="pnrCreateDate" size="14" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>
				<td colspan="2"  valign="top" style="padding-left:8px;"><html:text property="ticketNumber" size="14" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>
				<td colspan="2"  valign="top" style="padding-left:15px;"><html:text property="ticketIssueDate" size="14" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>
				<td valign="top" style="padding-left:15px;"><html:text property="checkinDate" size="12" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>
				<td valign="top" style="padding-left:15px;"><html:text property="checkinTime" size="12" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>
					<td valign="top" style="padding-left:15px;"><html:text property="onBoardDate" size="12" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>
				<td valign="top" style="padding-left:15px;"><html:text property="onBoardTime" size="12" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>
			</table></td></tr>
			
			
			<tr style="padding-top:10px;padding-left:17px;"><td colspan="11"><table align="left" border="0" width="98%">
			<tr>
				<td align="left" style="padding-left:15px;padding-right:10px;" valign="bottom"><bean:message key="spl.selected.field.FF_AIRLINE" /></td>
				<td align="left" valign="bottom" style="padding-left:18px;"><bean:message key="spl.selected.field.FF_ID" /></td>
				<td colspan="2" align="left" valign="bottom" style="padding-left:5px;"><bean:message key="spl.selected.field.FF_TIER" /></td>
				<td align="left" valign="bottom"><bean:message key="spl.selected.field.SSR" /></td>
				<td colspan="7" align="left" style="text-align:left;padding-left:6px;padding-right:4px;" valign="bottom"><bean:message key="spl.selected.field.REMARKS" /></td>
			</tr>			
			<tr>
				<td valign="top" style="padding-left:15px;"><html:text property="frequentFlierAirline" size="10" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>
				<td valign="top" style="padding-left:18px;padding-right:10px"><html:text property="frequentFlierId" size="14" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>
				<td valign="top" colspan="2" align="left" style="padding-left:5px;padding-right:10px"><html:text property="frequentFlierTier" size="30" name="ssrInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>
				<td align="left" valign="top" style="padding-right:5px;"><html:text property="ssr" size="8" style="font-family: arial, verdana, sans-serif; font-size: 11px; margin: 0px;" readonly="true" style="background-color:#DAD9D6; font-family: arial, verdana, sans-serif; font-size: 11px; margin: 0px;"/></td>
				<logic:present name="ssrInquiryForm" property="remList">
				<logic:notEmpty name="ssrInquiryForm" property="remList">		
				<td colspan="7" align="left" style="padding-left:5px;">
				<table class="filter"><logic:iterate name="ssrInquiryForm" property="remList" id="remList">
				<tr><td align="left" valign="top" style="padding-bottom:1px;"><input type="text" name="remarks1" size="75" value="<bean:write name='remList' property='remarks1'/>"  readonly  style="background-color:#DAD9D6;"/></td></tr>				
				</logic:iterate>
				</table>
				</td>
				<tr style="padding-top:10px;">	<td width="10%" align="center" colspan="11">&nbsp;</td>	</tr>
				</logic:notEmpty>
				</logic:present>
				<logic:notPresent name="ssrInquiryForm" property="remList">
				<td colspan="7" align="left" style="padding-left:5px;">
				<table class="filter">
					<tr><td align="left" valign="top" style="padding-bottom:1px;"><input type="text" name="remarks1" size="75" value=""  readonly  style="background-color:#DAD9D6;"/></td></tr>				
				</table>
				</td>
				</logic:notPresent>
			
			<tr><td colspan="11"> &nbsp;</td></tr>
			
			</table></td></tr>
						
			</tbody>							
		</table>
	</div>	
</td>	
</tr>
