
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html"  %>
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean"  %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<script Language="JavaScript">
</script>
<table width="872" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tbody>
		<tr>
			<td>
			<div id="errortop"><html:errors /></div>
			</td>
		</tr>
	</tbody>
</table>
<html:form action="/PNRJ/PNRJ002_processClerk" focus="pnrLocator">
<logic:messagesPresent property="flightNum">
    <bean:define id="fltNumErrorStyle" value="error" />
</logic:messagesPresent>
<logic:messagesNotPresent property="flightNum">
	<bean:define id="fltNumErrorStyle" value="success" />
</logic:messagesNotPresent>

<logic:messagesPresent property="flightDte">
    <bean:define id="fltDteErrorStyle" value="error" />
</logic:messagesPresent>
<logic:messagesNotPresent property="flightDte">
	<bean:define id="fltDteErrorStyle" value="success" />
</logic:messagesNotPresent>

<div class="passengersearch">
	<table width="100%">
		<tr>
			<td width="25%"></td>
			<td width="25%" valign="middle">
				<table>
					<tr align="left" valign="middle">
						<td align="left" class="label" nowrap>
							PNR Lookup:
						</td>
						<td valign="middle">
							<html:text property="pnrLocator"/>
						</td>
					</tr>
					<tr align="left" valign="middle">
						<td align="left" class="label">
							Passenger Name:
						</td>
						<td valign="middle">
							<html:text property="pngrName"/>
						</td>	
					</tr>
				</table>
			</td>
			<td width="10%" ></td>
			<td width="25%" align="center">
				<table>
					<tr align="left" valign="middle">
						<td align="left" class="label">
							<span id="<bean:write name="fltNumErrorStyle"/>" >Flight Nbr:</span>
						</td>
						<td valign="middle">
							<html:text property="flightNbr"/>
						</td>
					</tr>
					<tr align="left" valign="middle">
						<td align="left" class="label">
							<span id="<bean:write name="fltDteErrorStyle"/>" >Flight Date (DDMMMYY):</span>
						</td>
						<td valign="middle">
							<html:text property="travelDte" maxlength="7"/>
						</td>
					</tr>
				</table>
			</td>		
			<td align="left" valign="middle">
				<table align="center" border="0">
					<tr align="left" valign="middle">
						<td>
							<html:image page="/images/goBtn5.gif" property="goBtn" accesskey="G" title="alt-g"></html:image>
						</td>	
					</tr>
					<tr valign="middle">	
						<td>
							<html:image page="/images/resetBtn.gif" property="resetBtn" accesskey="R" title="alt-r"></html:image>
						</td>	
					</tr>
				</table>
			</td>
		</tr>
	</table>
	
	<table width="100%">
		<tr align="left">
			<td width="20%">&nbsp;
			</td>
			<td width="50%">
				<span id="messages">
					<logic:notEmpty name="clerkBean" property="retrieve_message" scope="session">
						<html:img page="/images/rt_red_arrow.gif"></html:img>&nbsp;<bean:write name="clerkBean" property="retrieve_message" />
					</logic:notEmpty>
				</span>
			</td>
		</tr>
	</table>
	</div>	
	<P>
	<logic:notEmpty name="clerkBean" property="pnrMemo">
  <div class="memos">
	<table width="100%" class="memotable">
		<logic:iterate id="theLines" name="clerkBean" property="pnrLines">
		<tr align="left">
				<td valign="top">
					<small class="pnr"><pre><bean:write name="theLines"/></pre></small>
				</td>
		</tr>
		</logic:iterate>
	</table>		
  </div>
	</logic:notEmpty>
	
	<logic:notEmpty name="clerkBean" property="pnrList">
	<DIV style="LEFT:145px; OVERFLOW:auto; WIDTH:100%; TOP:130px; HEIGHT:107" class="sub_table">
	<table width="100%">
		<logic:iterate id="thePNRRecs" name="clerkBean" property="pnrList">
		<tr>
			<td  valign="top" align="left" width="12%">
			<html:link page="/PNRJ/PNRJ002_retrievePnr.do" paramId="clickedPnrLoc" paramName="thePNRRecs" paramProperty="pnrLoc">
	        	<b><bean:write name="thePNRRecs" property="pnrLoc"/></b>
            </html:link> 
            </td>
			<td valign="top" align="left" width="7%">
				<bean:write name="thePNRRecs" property="pnrPsngrNme"/>
			</td>
			<td valign="top" align="left" width="40%">
			</td>
		</tr>
		</logic:iterate>
	</table>
	</DIV>		
	</logic:notEmpty>
	
</html:form>		
	
	

