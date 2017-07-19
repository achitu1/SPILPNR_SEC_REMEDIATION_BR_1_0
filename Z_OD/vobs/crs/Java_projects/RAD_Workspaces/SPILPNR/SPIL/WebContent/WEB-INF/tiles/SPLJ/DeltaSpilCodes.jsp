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

<table width="100%" cellpadding="0" cellspacing="0" border="0">
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
	<tr><td colspan="3"><hr width="100%" style="color: #6F8ACD" size="2"/></td></tr>

	<tr><td colspan="3">
		<a target="top"></a>
		<table width="100%" cellpadding="0" cellspacing="0" border="0" align="center">
			
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
		
			<tr><td colspan="2"> </td></tr>
			<tr>
				<td style="font-weight:bold;font-size:9pt;" width="60">Column/Field </td>
				<td style="font-weight:bold;font-size:9pt;" width="60"> Definition </td>
			</tr>
			
			<tr><td colspan="2"><hr width="100%" style="color: #6F8ACD" size="2"/></td></tr>

		
			<tr><td colspan="2"> </td></tr>
			<tr>
				<td style="font-weight:bold;" >B</td>
				<td>B = Passenger boarded the flight</td>
			</tr>
			<tr>
				<td> </td>
				<td>X = Passenger cancelled from standby list</td>
			</tr>

			<tr><td colspan="2"> </td></tr>
			
			<tr>
				<td style="font-weight:bold;" >Boarded Date</td>
				<td>Date passenger boarded the flight(YYYY-MM-DD)
				</td>
			</tr>
			
			
			<tr><td colspan="2"> </td></tr>
			<tr>
				<td style="font-weight:bold;" >Boarded Time</td>
				<td>Time passenger boarded the flight (HH:MM:SS)
				</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>				
			
			<tr>
				<td style="font-weight:bold;">Booked Class</td>
				<td>Booked Class of Service</td>
			</tr>
			<tr>
				<td> </td>
				<td>C = Booked in Delta One &trade; /Business Class</td>
			</tr>
			<tr>
				<td> </td>
				<td>F = Booked in First Class</td>
			</tr>
			<tr>
				<td> </td>
				<td>Y = Booked in Main Cabin</td>
			</tr>

			<tr><td colspan="2"> </td></tr>
			<tr>
				<td style="font-weight:bold;" >Cancel Flight</td>
				<td>Y = Cancelled Flight</td>
			</tr>
			<tr>
				<td> </td>
				<td>N = Not Cancelled Flight</td>
			</tr>
						
			<tr><td colspan="2"> </td></tr>
			<tr>
				<td style="font-weight:bold;" >Check-In Date</td>
				<td>Date of the first check-in occurrence for the flight (YYYY-MM-DD)</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>
			<tr>
				<td style="font-weight:bold;" >Check-In Time</td>
				<td>Time of the first check-in occurrence for the flight (HH:MM:SS)</td>
			</tr>
				
			<tr><td colspan="2"> </td></tr>
			
			<tr>
				<td style="font-weight:bold;">CLS</td>
				<td>Not Used</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>												
			<tr>
				<td style="font-weight:bold;" width="60">Fare Class</td>
				<td>
				<a href="http://dlnet.delta.com/portal/KM+Details?docname=agentkms/Formats/agentkms_0002660.html"><b style="color:blue;underline;font-weight:bold; font-size: 8pt;">Fare Class at Delta KM Portal</b></a>
				</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>
			
			<tr>
				<td style="font-weight:bold;">Flown Class</td>
				<td>Passenger Flown/Seated Cabin Class</td>
			</tr>
			<tr>
				<td> </td>
				<td>C = Seated in Delta One &trade; /Business Class</td>
			</tr>
			<tr>
				<td> </td>
				<td>F = Seated in First Class</td>
			</tr>
			<tr>
				<td> </td>
				<td>Y = Seated in Main Cabin</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>
			
			<tr>
				<td style="font-weight:bold;" >Passenger Type</td>
				<td>Passenger Type Code</td>
			</tr>
			<tr>
				<td> </td>
				<td>SA = Non-Rev Standby Passenger</td>
			</tr>
			<tr>
				<td> </td>
				<td>JS = Jumpseat Passenger</td>
			</tr>
			<tr>
				<td> </td>
				<td>PS = Positive Space Passenger</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>
			
			<tr>
				<td style="font-weight:bold;">R</td>
				<td> I  = Passenger with inbound connection</td>
			</tr>
			<tr>
				<td> </td>
				<td>A = Passenger moved <b>to</b> another flight</td>
			</tr>
			<tr>
				<td> </td>
				<td>M = Passenger moved <b>from</b> another flight</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>
			<tr>
				<td style="font-weight:bold;" >Seat</td>
				<td>Passenger Seat Number</td>
			</tr>
			<tr>
				<td> </td>
				<td>P = Cockpit Jumpseat </td>
			</tr>
			<tr>
				<td> </td>
				<td>R = Cabin Jumpseat</td>
			</tr>
			<tr>
				<td> </td>
				<td>X = Unknown seat number </td>
			</tr>
			
			
			<tr><td colspan="2"> </td></tr>
			
			<tr>
				<td style="font-weight:bold;">Seniority</td>
				<td>Employee hire date (YYYY-MM-DD) or 000000</td>
			</tr>
			<tr>	
				<td> </td>
				<td> for confirmed passenger</td>
			</tr>								
			
			<tr><td colspan="2"> </td></tr>
						
			<tr>
				<td style="font-weight:bold;" >SSR Codes</td>
				<td>
				<a href="http://dlnet.delta.com/portal/KM+Details?docname=agentkms/Formats/agentkms_0004198.html"><b style="color:blue;underline;font-weight:bold; font-size: 8pt;">SSR Codes at Delta KM Portal</b></a>
				</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>
						
			<tr>
				<td style="font-weight:bold;" >Standby Codes</td>
				<td>
				<a href="http://opsdata.delta.com/scripts/stndbycde.asp"><b style="color:blue;underline;font-weight:bold; font-size: 8pt;">Standby Codes at Delta KM Portal</b></a>
				</td>
			</tr>
	
			<tr><td colspan="2"> </td></tr>
			
			<tr>
				<td style="font-weight:bold;">Time</td>
				<td>Time added to the Standby List (HH:MM:SS)</td>
			</tr>
	
			<tr><td colspan="2"> </td></tr>
			
			<tr>
				<td style="font-weight:bold;">V</td>
				<td>T = Passenger cleared upline and is a "thru"</td>
			</tr>
			
			<tr>
				<td> </td>
				<td>       passenger on downline flight</td>
			</tr>
			
			<tr>
				<td> </td>
				<td>V = Passenger "verified" and added to standby list</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>
			
			<tr>
				<td style="font-weight:bold;" >WaitList Number</td>
				<td>Standby order on the waitlist and the</td>
			</tr>
			<tr>
				<td> </td>
				<td>number of passengers in the party.</td>
			</tr>
			
			<tr>
				 <td> </td>
				 <td>  201=Passenger is number 2 on waitlist,party of 1</td>
			</tr>
			<tr>
				 <td> </td>
				 <td>4902=Passenger is number 49 on waitlist,party of 2</td>
			</tr>
			
			<tr><td colspan="2"> </td></tr>

			<tr>
				<td class="returnToTop" width="214">
				<div id="link7"><a href="#top">Return to top</a></div>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
				<hr width="100%" style="color: #6F8ACD" size="2" />
				</td>
			</tr>

			<!-- ending margin -->
		

		</table>
		</td>
	</tr>
</table>

</center>
</BODY>
</html:html>
