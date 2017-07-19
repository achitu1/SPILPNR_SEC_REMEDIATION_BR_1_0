<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="author" content="PTC">
<TITLE>SPIL Codes</TITLE>
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
<script>

function me(){
	alert();
}
function printList(){
   window.onbeforeprint = hideDivs;
   window.onafterprint = showDivs;
   window.print();
   
  }
  
  function hideDivs () {
	
    tmp2 = document.getElementById('button2');
    tmp2.style.display = 'none';
    
    tmp3 = document.getElementById('logo');
    tmp3.style.display = 'none';

    tmp4 = document.getElementById('button');
    tmp4.style.display = 'none';	

    
    tmp5 = document.getElementById('link1');
    tmp5.style.display = 'none';

    tmp6 = document.getElementById('link2');
    tmp6.style.display = 'none';

    tmp7 = document.getElementById('link3');
    tmp7.style.display = 'none';	
    
    tmp8 = document.getElementById('link4');
    tmp8.style.display = 'none';	

    tmp = document.getElementById('link5');
    tmp.style.display = 'none';	

    tmp = document.getElementById('link6');
    tmp.style.display = 'none';	
    
    tmp = document.getElementById('link7');
    tmp.style.display = 'none';	        
    
 }

function showDivs () {
	
    tmp2 = document.getElementById('button2');
    tmp2.style.display = 'block';

    tmp3 = document.getElementById('logo');
    tmp3.style.display = 'block';

    tmp4 = document.getElementById('button');
    tmp4.style.display = 'block';	
    
    tmp5 = document.getElementById('link1');
    tmp5.style.display = 'block';

    tmp6 = document.getElementById('link2');
    tmp6.style.display = 'block';

    tmp7 = document.getElementById('link3');
    tmp7.style.display = 'block';	
    
    tmp8 = document.getElementById('link4');
    tmp8.style.display = 'block';	

    tmp = document.getElementById('link5');
    tmp.style.display = 'block';	

    tmp = document.getElementById('link6');
    tmp.style.display = 'block';	
    
    tmp = document.getElementById('link7');
    tmp.style.display = 'block';	        
}  
</script>
</HEAD>

<BODY>
<center>

<table width="95%" cellpadding="0" cellspacing="0" border="0">
	<tr style="padding-top:10px;">
	<td width="269">
		<div id="logo">
		<img src="<%=request.getContextPath()%>/images/topnav_bg1.gif" border="0">
		</div>
	</td>
	<td width="412">&nbsp;</td>
	</tr>

	<tr valign="middle" style="padding-top:18px; padding-bottom:10px;">
	<td style="color:red; font-weight:bold; font-size: 10pt;" width="269">
		SPIL Codes Lookup
	</td>
	<td align="right"  style="cursor:hand;" width="412"  onclick="printList()">
		<div id="button" style="vertical-align:top;">
		<img src="<%=request.getContextPath()%>/images/print.gif" border="0">Print List
		</div>		
	</td>
	<td valign="bottom" align="right" style="padding-right:15px" width="129">
		<div id="button2">
    	<img src="<%=request.getContextPath()%>/images/btn_close_window.gif" border="0" onclick="window.close()" style="cursor:hand;">
    	</div>
	</td>
	</tr>
	<tr><td colspan="3"><hr width="95%" style="color: #6F8ACD" size="2"/></td></tr>

	<tr><td colspan="3">
		<a target="top"></a>
		<table width="95%" cellpadding="0" cellspacing="0" border="0" align="center">
			
			<!--
			<tr><td class="titleHelp" colspan="2">
					SPIL Codes
			</td></tr>
			<tr>
				<td colspan="2">
					<A HREF="">
					A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z 
					</A>
				</td>
			</tr>
			-->
		
			<tr><td class="subHelp" colspan="2">
					SPIL - SPIL Type Codes
			- <B>Type</B></td></tr>
			<tr><td colspan="2"><hr width="100%" style="color: #6F8ACD" size="2"/></td></tr>
			<tr><td style="font-weight:bold;width:20%;" width="214">Code</td>
				<td style="font-weight:bold;width:80%;">Description</td>
			</tr>
			
			<logic:iterate name="helpCodeForm" property="queryJ" id="queryj">
				<tr><td width="214"><bean:write name="queryj" property="code"/></td>
					<td><bean:write name="queryj" property="value"/></td>
				</tr>
			</logic:iterate>
			
			<tr><td class="returnToTop" width="214"><div id="link1"><a href="#top">Return to top</a></div></td></tr>
			
			<tr><td class="subHelp" colspan="2">
					SPIL - Special Service Request Type Codes
			- <B>SSR</B></td></tr>
			<tr><td colspan="2"><hr width="100%" style="color: #6F8ACD" size="2"/></td></tr>
			<tr><td style="font-weight:bold;width:20%;" width="214">Code</td>
				<td style="font-weight:bold;width:80%;">Description</td>
			</tr>
						
			<logic:iterate name="helpCodeForm" property="queryK" id="queryk">
				<tr>
					<td><bean:write name="queryk" property="code"/></td>
					<td><bean:write name="queryk" property="value"/></td>
				</tr>
			</logic:iterate>			

			<tr><td class="returnToTop" width="214"><div id="link2"><a href="#top">Return to top</a></div></td></tr>

			<tr><td class="subHelp" colspan="2">
					Waitlist - Verify Type Codes
			- <B>V</B></td></tr>
			<tr><td colspan="2"><hr width="100%" style="color: #6F8ACD" size="2"/></td></tr>
			<tr><td style="font-weight:bold;width:20%;" width="214">Code</td>
				<td style="font-weight:bold;width:80%;">Description</td>
			</tr>
						
			<logic:iterate name="helpCodeForm" property="queryM" id="querym">
				<tr>
					<td><bean:write name="querym" property="code"/></td>
					<td><bean:write name="querym" property="value"/></td>
				</tr>
			</logic:iterate>

			<tr><td class="returnToTop" width="214"><div id="link3"><div id="link4"><a href="#top">Return to top</a></div></div></td></tr>
									
			<tr><td class="subHelp" colspan="2">
					Waitlist - Board Type Codes
			- <B>B</B></td></tr>
			<tr><td colspan="2"><hr width="100%" style="color: #6F8ACD" size="2"/></td></tr>
			<tr><td style="font-weight:bold;width:20%;" width="214">Code</td>
				<td style="font-weight:bold;width:80%;">Description</td>
			</tr>
						
			<logic:iterate name="helpCodeForm" property="queryN" id="queryn">
				<tr>
					<td><bean:write name="queryn" property="code"/></td>
					<td><bean:write name="queryn" property="value"/></td>
				</tr>
			</logic:iterate>		

			<tr><td class="returnToTop" width="214"><div id="link4"><a href="#top">Return to top</a></div></td></tr>

			<tr><td class="subHelp" colspan="2">
					Waitlist - Reservation Type Codes
			- <B>R</B></td></tr>
			<tr><td colspan="2"><hr width="100%" style="color: #6F8ACD" size="2"/></td></tr>
			<tr><td style="font-weight:bold;width:20%;" width="214">Code</td>
				<td style="font-weight:bold;width:80%;">Description</td>
			</tr>
						
			<logic:iterate name="helpCodeForm" property="queryO" id="queryo">
				<tr>
					<td><bean:write name="queryo" property="code"/></td>
					<td><bean:write name="queryo" property="value"/></td>
				</tr>
			</logic:iterate>	

			<tr><td class="returnToTop" width="214"><div id="link5"><a href="#top">Return to top</a></div></td></tr>

			<tr><td class="subHelp" colspan="2">
					Waitlist - Service Type Codes
			- <B>Service</B></td></tr>
			<tr><td colspan="2"><hr width="100%" style="color: #6F8ACD" size="2"/></td></tr>
			<tr><td style="font-weight:bold;width:20%;" width="214">Code</td>
				<td style="font-weight:bold;width:80%;">Description</td>
			</tr>
						
			<logic:iterate name="helpCodeForm" property="queryP" id="queryp">
				<tr>
					<td><bean:write name="queryp" property="code"/></td>
					<td><bean:write name="queryp" property="value"/></td>
				</tr>
			</logic:iterate>	

			<tr><td class="returnToTop" width="214"><div id="link6"><a href="#top">Return to top</a></div></td></tr>

			<tr><td class="subHelp" colspan="2">
					Waitlist - Type Codes
			- <B>Type</B></td></tr>
			<tr><td colspan="2"><hr width="100%" style="color: #6F8ACD" size="2"/></td></tr>
			<tr><td style="font-weight:bold;width:20%;" width="214">Code</td>
				<td style="font-weight:bold;width:80%;">Description</td>
			</tr>
						
			<logic:iterate name="helpCodeForm" property="queryL" id="queryl">
				<tr>
					<td><bean:write name="queryl" property="code"/></td>
					<td><bean:write name="queryl" property="value"/></td>
				</tr>
			</logic:iterate>

			<tr><td class="returnToTop" width="214"><div id="link7"><a href="#top">Return to top</a></div></td></tr>

			<!-- ending margin -->
			<tr>
				<td style="padding-bottom:15px;" width="214">&nbsp;</td>
			</tr>

		</table>
	</td>
	</tr>
</table>

</center>
</BODY>
</html:html>
