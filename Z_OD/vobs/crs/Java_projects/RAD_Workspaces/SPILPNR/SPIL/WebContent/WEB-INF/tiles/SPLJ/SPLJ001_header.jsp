<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<HTML>
<HEAD>
<html:base/>
<TITLE>
	<tiles:getAsString name="title"/>
</TITLE>
</HEAD>

<BODY>
<div id="header">
<table width="100%">
<tr>
	<td>
		<table align="center">
			<tr>
				<td>
					<span id="headermessages">
						<tiles:getAsString name="title"/>
					</span>
				</td>
			</tr>
		</table>
	</td>
</tr>
</table>
<hr width="100%" style="color: black;" size="1"/>
</div>