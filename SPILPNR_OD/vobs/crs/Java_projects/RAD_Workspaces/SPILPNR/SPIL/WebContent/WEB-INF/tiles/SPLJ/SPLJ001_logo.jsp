<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<% String contextpath=request.getContextPath(); %>

   <table width="950" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr>
		<td width="100%">

		<table border="0" cellspacing="0" cellpadding="0">


			<tr>
				<td width="34%" background="<%=contextpath%>/images/topnav_bg.gif"><a
					href="http://www.delta.com"><img height=60
					src="<%=contextpath%>/images/topnav_bg1.gif" width=235 border=0></a></td>
				<td background="<%=contextpath%>/images/topnav_bg.gif" width="100%">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr align="right" height="30">
						<td width="70%"></td>
					</tr>
					<tr align="right" height="30">
						<td width="30%"></td>

					</tr>
				</table>
				</td>
				<td background="<%=contextpath%>/images/topnav_bg.gif" width="100%">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr align="right" height="30">
						<td width="30%"><img src="<%=contextpath%>/images/spiltitle.gif" border="0" /></td>

					</tr>
				</table>
				</td>
			</tr>
			
			<tr class="namehead">
          <td colspan="3" align="right">
			  <%String name = (String) session.getAttribute("employeeName");%>
			  <font color="#ffffff" face="arial"><strong>Welcome, <%=name%></strong></font>
		  </td>
        </tr>
		</table>
		</td>
	</tr>
</table>



