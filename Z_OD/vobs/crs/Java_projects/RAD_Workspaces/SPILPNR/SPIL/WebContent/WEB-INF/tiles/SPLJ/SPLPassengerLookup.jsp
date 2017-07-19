<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%java.lang.String contextPath = request.getContextPath();%>

<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="author" content="PTC">
<TITLE>SPIL Codes</TITLE>
<LINK href="<html:rewrite page='/theme/PRAMaster.css'/>" rel="stylesheet" type="text/css">
<STYLE>
</STYLE>
<script>

function loadCSS() {
	head = document.getElementsByTagName('thead');
	for (i=0; i < head.length; i++ ) {
		if (head[i].parentElement.id == 'scrollTable') {
			head[i].className='fixedHeader';
		}
	}
	body = document.getElementsByTagName('tbody');
	for (i=0; i < body.length; i++ ) {
		if (body[i].parentElement.id == 'scrollTable') {
			body[i].className='scrollContent';
		}
	}
}

function paintMouseEvents(tableId) {
	  if (document.getElementById(tableId) != null){
	    var table = document.getElementById(tableId);
	    var tbody = table.getElementsByTagName("tbody")[0];
	    var rows  = tbody.getElementsByTagName("tr");

	    for (i=0; i < rows.length; i++) {
	        rows[i].onmouseover = function() { 
	                this.style.cursor="hand";
	                this.style.backgroundColor = "#FFFFCC";
	          };
	          
	        rows[i].onmouseout = function() {
	                this.style.cursor='';
	                this.style.backgroundColor = "#E5E6EF";
	          };

			rows[i].onclick = function(i) {
	                this.style.cursor="hand";
	                this.style.backgroundColor = "#FFFFCC";
	               passengerName=this.getElementsByTagName("td")[0].innerText;
	               window.returnValue=passengerName;
	               window.close();
	          };
	    }
	  }
}

</script>

</HEAD>
<BODY onload="loadCSS();">
<script>var passengerName="";</script>
<html:form action="/SPLJ/WaitlistInquirySubmit.do" method="post">
<table width="450px" border="0">
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>	
		<td align="center"><b><bean:message key='spl.passenger.lookup'/> <bean:write property="selPnr" name="waitlistInquiryForm"/></b></td>
	</tr>
	<tr>
		<td>
			<div id="tableContainer" style="overflow:auto; height:175px; width:100%;border:1px solid #B1B4C5;">	
				<table width="100%" id="scrollTable">
					<thead class="fixedHeader">
						<tr>
						<th><bean:message key='spl.waitlist.header.field.name'/></th>
						</tr>
					</thead>
					<tbody class="scrollContent">
					<logic:iterate property="passengerList" id="passengerList" name="waitlistInquiryForm">
						<tr>
						<td><bean:write name="passengerList" property="passengerName"/></td>
						</tr>	
					</logic:iterate>
					</tbody>
				</table>
			</div>
		</td>
	</tr>
	<tr>
		<td style="padding-top:7px" align="right" valign="middle"><img src="<%=request.getContextPath()%>/images/btn_close_window.gif" border="0" onclick="window.returnValue='';window.close()" style="cursor:hand;"></td>
	</tr>
</table>
<script>paintMouseEvents('scrollTable');</script>
</html:form>

</BODY>
</html:html>
