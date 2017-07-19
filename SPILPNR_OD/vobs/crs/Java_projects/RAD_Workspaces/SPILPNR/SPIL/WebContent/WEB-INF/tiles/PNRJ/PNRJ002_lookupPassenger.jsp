<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%String contextPath = request.getContextPath();%>

<script language="javascript">
function printData() {
    window.onbeforeprint = hideDivs;
    window.onafterprint = showDivs;
    window.print();
  }

function checkBox() {
	var textDiv = document.getElementById("nameFormatTxt"); 
	//alert(document.forms[0].checkRange[0].checked);
	if(document.forms[0].checkRange[0].checked == true)
	{
		textDiv.style.visibility = 'visible';
	}else{
		textDiv.style.visibility =  'hidden';
	}
}

function changeToUpper(obj){
	var val= obj.value;
	obj.value=val.toUpperCase();

}

function hideDivs () {
    tmp = document.getElementById('printArea');
    tmp.style.display = 'list-item';	

    tmp2 = document.getElementById('header');
    tmp2.style.display = 'none';

//    tmp3 = document.getElementById('logo');
//    tmp3.style.display = 'none';

    tmp4 = document.getElementById('main');
    tmp4.style.display = 'none';	

//    tmp5 = document.getElementById('nav');
 //   tmp5.style.display = 'none';

    tmp6 = document.getElementById('footer');
    tmp6.style.display = 'none';
    
}
function showDivs () {
    tmp = document.getElementById('printArea');
    tmp.style.display = 'none';	

    tmp2 = document.getElementById('header');
    tmp2.style.display = 'block';

//    tmp3 = document.getElementById('logo');
//    tmp3.style.display = 'block';

    tmp4 = document.getElementById('main');
    tmp4.style.display = 'block';	

//    tmp5 = document.getElementById('nav');
//    tmp5.style.display = 'block';

    tmp6 = document.getElementById('footer');
    tmp6.style.display = 'block';
}
function prefillFlightNum(){
	flightNum = document.forms[0].flightNumber.value;
	flightNum = flightNum.replace(/^\s*|\s$/g,"");
	if(flightNum.length==3){
		document.forms[0].flightNumber.value = "0" + flightNum;
	}else if(flightNum.length==2){
		document.forms[0].flightNumber.value = "00" + flightNum;
	}else if(flightNum.length==1){
		document.forms[0].flightNumber.value = "000" + flightNum;
	} 
}

function checkDateFormat(){
	dateval= document.forms[0].travelDate.value;

	if(dateval.length==7){

		var month = dateval.substring(2,5);
		
		if((month=="jan")||(month=="JAN")){
			month="01";	
		}else if((month=="feb")||(month=="FEB")){
			month="02";	
		}else if((month=="mar")||(month=="MAR")){
			month="03";	
		}else if((month=="apr")||(month=="APR")){
			month="04";	
		}else if((month=="may")||(month=="MAY")){
			month="05";	
		}else if((month=="jun")||(month=="JUN")){
			month="06";	
		}else if((month=="jul")||(month=="JUL")){
			month="07";	
		}else if((month=="aug")||(month=="AUG")){
			month="08";	
		}else if((month=="sep")||(month=="SEP")){
			month="09";	
		}else if((month=="oct")||(month=="OCT")){
			month="10";	
		}else if((month=="nov")||(month=="NOV")){
			month="11";	
		}else if((month=="dec")||(month=="DEC")){
			month="12";	
		}
		
		year=dateval.substring(5,7);
		if(year < 70){
			year = "20" + year;
		}else{
			year = "19" + year;
		}
		dateval=month + "-" +  dateval.substring(0,2)+ "-" + year;
	}
	document.forms[0].travelDate.value=dateval;
}

function paintMouseEvents(tableId) {
	  if (document.getElementById(tableId) != null){
	    var table = document.getElementById(tableId);
	    var tbody = table.getElementsByTagName("tbody")[0];
	    var rows  = tbody.getElementsByTagName("tr");

	    for (i=0; i < rows.length; i++) {
	        rows[i].onmouseover = function() { 
	                this.style.cursor="hand";
	                if(this.style.backgroundColor == "#6495ed"){
						this.style.backgroundColor = "#6495ed";
	                }else{
	                	this.style.backgroundColor = "#FFFFCC";	                
	                }
	          };
	          
	        rows[i].onmouseout = function() {
	                this.style.cursor='';
	                if(this.style.backgroundColor == "#6495ed"){
						this.style.backgroundColor = "#6495ed";
	                }else{
		                this.style.backgroundColor = "#E5E6EF";
	                }
	                
	          };
			rows[i].onmousedown = function(){
				for (i=0; i < rows.length; i++) {
					rows[i].style.backgroundColor = "#E5E6EF";	
				}
			
			};

	        rows[i].onclick = function(i) {
	                this.style.cursor="hand";
	                this.style.backgroundColor = "#6495ED";
	                document.forms[0].selPnrLoctrNum.value = this.getElementsByTagName("td")[0].innerText;
    	            document.forms[0].selPnrCrtnDate.value = this.getElementsByTagName("td")[1].innerText;
    	            document.forms[0].selPassenger.value = this.getElementsByTagName("td")[7].innerText;
    	            document.forms[0].selFlightNumber.value = this.getElementsByTagName("td")[4].innerText;
				
				document.forms[0].action='<%=contextPath%>/PNRJ/LookupPassengerDetailShow.do';
				document.forms[0].submit();

	          };

	    }
	  }
}

function clearSelected(){
	form = document.forms[0];
	form.selPnrLoctrNum.value = "";
	form.selPnrCrtnDate.value = "";
	form.selPassenger.value = "";
	form.selFlightNumber.value = "";
}

function redisplay()
 {
	document.forms[0].action='<%=contextPath%>/PNRJ/LookupPassengerRedisplay.do';
	document.forms[0].submit();
 }

</script>
<body onload="scroll();">
<logic:notEmpty name="lookupPassengerForm" property="pnrTextList">

<div id="printArea" style="display: none; margin-right: -20px; margin-left: -40px">
 <table width="100%" border="0">
 	 <logic:iterate id="list" property="pnrTextList" name="lookupPassengerForm">				
 		<bean:define name="list" id="a"/>
		<script language="javascript">
		 	var aa = '<%=a%>';
 		   document.write("<tr><td><small class='pnr'><pre>" + aa + "</pre></small></td></tr>");
		</script>
 	 </logic:iterate>
    
 </table>
</div>

</logic:notEmpty>

<logic:notEmpty name="lookupPassengerForm" property="pnrList"> 

<div id="printArea" style="display: none; margin: -10px"> 
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
	
	<tr>
		<!--list header start-->
		<td>
			<table width="950" border="0" cellpadding="0" cellspacing="0">
			<tr class="subtable_header_bold">
				<th width="70" align="center" valign="bottom"><bean:message key="pnr.default.header.field.pnrNumber"/></th>
				<th width="70" align="center" valign="bottom"><bean:message key="pnr.default.header.field.pnrCreationDate"/></th>
				<th width="70" align="center" valign="bottom"><bean:message key="pnr.default.header.field.travelDate"/></th>
				<th width="60" align="center" valign="bottom"><bean:message key="pnr.default.header.field.airline"/></th>
				<th width="70" align="center" valign="bottom"><bean:message key="pnr.default.header.field.flightNumber"/></th>
				<th width="60" align="center" valign="bottom"><bean:message key="pnr.default.header.field.origin"/></th>
				<th width="80" align="center" valign="bottom"><bean:message key="pnr.default.header.field.destination"/></th>
				<th width="250" align="center" valign="bottom"><bean:message key="pnr.default.header.field.passenger"/></th>
				<th width="60" align="center" valign="bottom"><bean:message key="pnr.default.header.field.classCode"/></th>
				<th width="60" align="center" valign="bottom"><bean:message key="pnr.default.header.field.segmentStatus"/></th>
				<th width="20"></th>
			</tr>
			</table>
		</td>
		<!--list header end-->
	</tr>

	<tr>
		<td>
			<table width="950" border="0" cellpadding="0" cellspacing="1">
			<tr class="row1_left_nopoint">
			  <td colspan="8">
				<!-- The row content start -->
				<table width="950" border="0">
		          <bean:define id="A" name="lookupPassengerForm" property="airlineCode" type="java.lang.String"/>
		          <bean:define id="F" name="lookupPassengerForm" property="flightNumber" type="java.lang.String"/>
		          <bean:define id="T" name="lookupPassengerForm" property="travelDate" type="java.lang.String"/>
		          <bean:define id="P" name="lookupPassengerForm" property="passengerName" type="java.lang.String"/>
		          <bean:define id="O" name="lookupPassengerForm" property="origin" type="java.lang.String"/>
		          <bean:define id="D" name="lookupPassengerForm" property="destination" type="java.lang.String"/>
		 		  <logic:iterate id="list" property="pnrList" name="lookupPassengerForm">
		 		  <bean:define id="pnrLoctrNum" name="list" property="pnrLoctrNum" type="java.lang.String"/>
		          <bean:define id="pnrCrtnDate" name="list" property="pnrCrtnDate" type="java.lang.String"/>
	  			  <tr class="row1" style="cursor:pointer" onmouseover="javascript:this.className='row1hover';" onmouseout="javascript:this.className='row1';">
					<td width="69" align="left" valign="bottom"><bean:write name="list" property="pnrLoctrNum"/></td>
					<td width="69" align="center" valign="bottom"><bean:write name="list" property="pnrCrtnDate"/></td>
					<td width="69" align="center" valign="bottom"><bean:write name="list" property="pnrTravelDate"/></td>
					<td width="59" align="center" valign="bottom"><bean:write name="list" property="pnrMkAlCode"/></td>
					<td width="69" align="center" valign="bottom"><bean:write name="list" property="pnrFltNum"/></td>
					<td width="59" align="center" valign="bottom"><bean:write name="list" property="pnrSegOrigApCode"/></td>
					<td width="79" align="center" valign="bottom"><bean:write name="list" property="pnrSegDestApCode"/></td>
					<td width="249" align="left" valign="bottom"><bean:write name="list" property="pnrPsngrNme"/></td>
					<td width="59" align="center" valign="bottom"><bean:write name="list" property="pnrInvClCode"/></td>
					<td width="59" align="center" valign="bottom"><bean:write name="list" property="pnrSegStatusCode"/></td>
					<td width="20"></td>
				  </tr>
				  </logic:iterate>
				</table>
				<!-- The row content end -->
			  </td>
			</tr>
			</table>
		</td>
	</tr>
	</table>
 </div>
</logic:notEmpty> 

<div id="main">
<table width="950" border="0" cellpadding="0" cellspacing="0" align="center">
<tr><td>
<div id="errortop">
	<html:errors/> 
</div>
</td></tr>
</table>

<center>
<table width="950" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td align="right">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><html:img border="0" onclick="location.href='LookupDefault.do'" style="cursor:hand;" page="/images/tab_dlu_off.gif"/></td>
					<td><html:img border="0" onclick="location.href='LookupPassenger.do'" style="cursor:hand;" page="/images/tab_plu_on.gif"/></td>
					<td><html:img border="0" onclick="location.href='LookupFlight.do'" style="cursor:hand;" page="/images/tab_fnlu_off.gif"/></td>
					<td><html:img border="0" onclick="location.href='LookupOrigDest.do'" style="cursor:hand;" page="/images/tab_odlu_off.gif"/></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<div style="background-color: #E5E6EF; border-style: solid; border-color: #B1B4C5; border-width: 1px; width:100%;  height:50px;">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr valign="top">
				<!-- graphic start -->
				<td width="200">
					<html:img border="0" page="/images/passengersearch2.jpg"/>
				</td>
				<!-- graphic end -->

                <td width="672" align="center" valign="middle">
					<html:form action="/PNRJ/LookupPassengerSubmit.do" focus="passengerName" onsubmit="checkDateFormat();prefillFlightNum();clearSelected();" method="post" >
					<html:hidden name="lookupPassengerForm" property="loctrNum"/>
					<html:hidden name="lookupPassengerForm" property="crtnDate"/>
					<html:hidden name="lookupPassengerForm" property="travelDateSort"/>
					<html:hidden name="lookupPassengerForm" property="mkAlCode"/>
					<html:hidden name="lookupPassengerForm" property="fltNum"/>
					<html:hidden name="lookupPassengerForm" property="segOrigApCode"/>
					<html:hidden name="lookupPassengerForm" property="segDestApCode"/>
					<html:hidden name="lookupPassengerForm" property="psngrNme"/>
					<html:hidden name="lookupPassengerForm" property="invClCode"/>
					<html:hidden name="lookupPassengerForm" property="segStatusCode"/>
					<html:hidden name="lookupPassengerForm" property="showRedisplay"/>
					<html:hidden property="selPnrCrtnDate" name="lookupPassengerForm"/>
					<html:hidden property="selPnrLoctrNum" name="lookupPassengerForm"/>
					<html:hidden property="selPassenger" name="lookupPassengerForm"/>
					<html:hidden property="selFlightNumber" name="lookupPassengerForm"/>
					
					<table width="650" align="center" class="filter" border="0">
						<!-- passenger filter start -->
						<tr>
							<td>
								<div id="passenger" >
								<table>
									<tr>
										<td align="right">
											<logic:messagesPresent property="passengerName">
												<font color="red"><bean:message key="pnr.passengerlookup.filter.field.PASSENGERNAME"/></font>
											</logic:messagesPresent>
											<logic:messagesNotPresent property="passengerName">
												<bean:message key="pnr.passengerlookup.filter.field.PASSENGERNAME"/>
											</logic:messagesNotPresent>										
										</td>
										<td><font color="red">*</font></td>
										<td colspan="4" align="left" ><span	title="<bean:message key="pnr.general.label.passengerName"/>"><html:text property="passengerName" maxlength="35" size="35" tabindex="1" onkeyup="javascript:changeToUpper(this);" /></span></td>
										<td colspan="6" align="left"><font color="red">
										<logic:equal name="lookupPassengerForm" property="checkRange" value="false">
											<div id="nameFormatTxt" style="visibility:hidden">MINIMUM REQUIRED: LASTNAME/F(first initial)</div>
										</logic:equal>
										<logic:equal name="lookupPassengerForm" property="checkRange" value="true">
											<div id="nameFormatTxt" style="visibility:visible">MINIMUM REQUIRED: LASTNAME/F(first initial)</div>
										</logic:equal>
										</font>
										</td>
									</tr>
									<tr>
										<td align="right"><span>
											<logic:messagesPresent property="travelDate">
												<font color="red"><bean:message key="pnr.passengerlookup.filter.field.TRAVELDATE"/></font>
											</logic:messagesPresent>
											<logic:messagesNotPresent property="travelDate">
												<bean:message key="pnr.passengerlookup.filter.field.TRAVELDATE"/>
											</logic:messagesNotPresent>
											</span>									
										</td>
										<td><font color="red">*</font></td>
										<td colspan="4" align="left" ><html:text property="travelDate" maxlength="10" size="10" tabindex="2" onblur="checkDateFormat();"/>
										  (MM/DD/YYYY)</td>
										<td align="right"><html:checkbox property="checkRange" onclick="javascript:checkBox();"></html:checkbox><html:hidden property="checkRange" value="false"></html:hidden>
										</td>
										<td  align="left">
										  <td align="right">Include +/- 1 day</td>
										  <td colspan="2"><td>
									</tr>
									<tr>
										<td align="right"><bean:message key="pnr.passengerlookup.filter.field.FLIGHTNUMBER"/></td>
										<td ></td>
										<td align="left"><html:text property="flightNumber" maxlength="4" size="5" tabindex="3" onblur="prefillFlightNum()"/></td>
										<td align="right"><bean:message key="pnr.passengerlookup.filter.field.AIRLINECODE"/></td>
										<td></td>
										<td align="left"><html:text property="airlineCode" maxlength="2" size="5" tabindex="4" onkeyup="javascript:changeToUpper(this);" /></td>
										<td align="right"><bean:message key="pnr.passengerlookup.filter.field.ORIGIN"/></td>
										<td></td>
										<td align="left"><html:text property="origin" maxlength="3" size="5" tabindex="5" onkeyup="javascript:changeToUpper(this);" /></td>
										<td></td>
										<td align="right"><bean:message key="pnr.passengerlookup.filter.field.DESTINATION"/></td>
										<td align="left"><html:text property="destination" maxlength="3" size="5" tabindex="6" onkeyup="javascript:changeToUpper(this);" /></td>
									</tr>
								</table>
								</div>
							</td>
						</tr>
						<!-- passenger filter end -->

						<!-- button set start -->
						<tr>
							<td>
								<table width="650" align="center" class="filter" >
								  <tr>
									<td width="70"></td>
									<td width="250" align="right">
										<html:image page="/images/go_button.gif" border="0" style="cursor:hand;" tabindex="7"/>
									</td>
									<td width="10"></td>
									<td width="250" align="left">
										<img src="<%=request.getContextPath()%>/images/clear_button.gif" border="0" style="cursor:hand;" onclick="location.href='LookupPassenger.do'" tabindex="8">
										<%--html:img border="0" page="/images/clear_button.gif" style="cursor:hand;" onclick="location.href='LookupPassenger.do'"/--%>
									</td>
									<td width="70"></td>
								  </tr>
								</table>
							</td>
						</tr>
			  			<!-- button set end -->
						<!-- PNR help start -->
						<tr>
							<td>
								<table width="650" align="center" class="filter" border="0">
								  <tr>
								    <td align="left" valign="middle">
										<font color="red">*Please note: fields with a * are required</font>
									</td>
									<td align="right" valign="middle"><html:link
										href="javascript:void( window.open( 'LookupDeltaPNRCodes.do', 'pnrCodes', 'scrollbars,width=680,height=400' ))"
										tabindex="9">
										<html:image page="/images/logo_help.gif" border="0"
											style="cursor:hand;" />
										DL PNR Codes</html:link></td>
									<td align="right" valign="middle"><html:link
										href="javascript:void( window.open( 'LookupPNRCodes.do', 'pnrCodes', 'scrollbars,width=680,height=400' ))"
										tabindex="10">
										<html:image page="/images/logo_help.gif" border="0"
											style="cursor:hand;" />
										NW PNR Codes</html:link></td>
								  </tr>
								</table>
							</td>
						</tr>
			  			<!-- PNR help end -->			  			
					</table>
					</html:form>
                </td>
              </tr>
		    </table>
			</div>
		</td>
	</tr>

	<tr><td>&nbsp;</td></tr>

<!-- list start -->
	<logic:notEmpty name="lookupPassengerForm" property="pnrList"> 
	<tr><td><table width="100%"><tr>
	
	<td align="left" >
	    <font color="red">DL PNR's from 03/09/2011 to current (prior to 03/09/2011 PNRPUL) &nbsp;&nbsp;&nbsp; NW PNR's Thru 01/30/2010</font>
	</td>
			<td align="right">
				<bean:write property="over1000Lines" name="lookupPassengerForm"  filter="false"/>
			</td>
		<td align="right">
		    <a href="javascript:printData();"><img src="<%=request.getContextPath()%>/images/print.gif" border="0">Print PNR Data</a>
		</td></tr></table></td>
	</tr>
	<tr>
		<!--list header start-->
		<td>
		<bean:write property="pnrCount" name="lookupPassengerForm"/>&nbsp;rows returned.
			<table width="100%" border="0" cellpadding="1" cellspacing="1" class="formTable">
			<tr class="subtable_header_bold">
				<th width="70" align="left" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrLoctrNum" ><bean:message key="pnr.default.header.field.pnrNumber"/></html:link></th>
				<th width="90" align="center" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrCrtnDate" ><bean:message key="pnr.default.header.field.pnrCreationDate"/></html:link></th>
				<th width="80" align="center" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrTravelDate" ><bean:message key="pnr.default.header.field.travelDate"/></html:link></th>
				<th width="70" align="center" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrMkAlCode" ><bean:message key="pnr.default.header.field.airline"/></html:link></th>
				<th width="70" align="center" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrFltNum" ><bean:message key="pnr.default.header.field.flightNumber"/></html:link></th>
				<th width="70" align="center" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrSegOrigApCode" ><bean:message key="pnr.default.header.field.origin"/></html:link></th>
				<th width="70" align="center" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrSegDestApCode" ><bean:message key="pnr.default.header.field.destination"/></html:link></th>
				<th width="240" align="center" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrPsngrNme" ><bean:message key="pnr.default.header.field.passenger"/></html:link></th>
				<th width="70" align="center" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrInvClCode" ><bean:message key="pnr.default.header.field.classCode"/></html:link></th>
				<th width="70" align="center" valign="bottom"><html:link page="/PNRJ/LookupSortByPassenger.do?sortBy=pnrSegStatusCode" ><bean:message key="pnr.default.header.field.segmentStatus"/></html:link></th>
				<th width="15"></th>
			</tr>
			<tr class="row1_left_nopoint">
			  <td colspan="11">
				<div name="divTicket" style="overflow-y:auto; height:200px; width:100%;" >
				<!-- The row content start -->
				<table width="100%" border="0" id="scrollTable" cellpadding="1" cellspacing="0"  class="formTable">
		 		  <logic:iterate id="list" property="pnrList" name="lookupPassengerForm">
	  			  <tr style="cursor:pointer">
	  			  	<td width="70" align="left" valign="bottom"><bean:write name="list" property="pnrLoctrNum"/></td>
					<td width="90" align="center" valign="bottom"><bean:write name="list" property="pnrCrtnDate"/></td>
					<td width="80" align="center" valign="bottom"><bean:write name="list" property="pnrTravelDate"/></td>
					<td width="70" align="center" valign="bottom"><bean:write name="list" property="pnrMkAlCode"/></td>
					<td width="70" align="center" valign="bottom"><bean:write name="list" property="pnrFltNum"/></td>
					<td width="70" align="center" valign="bottom"><bean:write name="list" property="pnrSegOrigApCode"/></td>
					<td width="72" align="center" valign="bottom"><bean:write name="list" property="pnrSegDestApCode"/></td>
					<td width="240" align="left" valign="bottom"><bean:write name="list" property="pnrPsngrNme"/></td>
					<td width="70" align="center" valign="bottom"><bean:write name="list" property="pnrInvClCode"/></td>
					<td width="70" align="center" valign="bottom"><bean:write name="list" property="pnrSegStatusCode"/></td>
				  </tr>
				  </logic:iterate>
				</table>
				<script>paintMouseEvents('scrollTable');</script>				
				</div>
				<!-- The row content end -->
			  </td>
			</tr>
			</table>
		</td>
		<!--list header end
	</tr>

	<tr>
		<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"  class="formTable">
			<tr class="row1_left_nopoint">
			  <td colspan="8">
				<div name="divTicket" style="overflow-y:auto; height:200px; width:940px;" >
				<!-- The row content start 
				<table width="940" border="0" id="scrollTable" cellpadding="0" cellspacing="0">
		 		  <logic:iterate id="list" property="pnrList" name="lookupPassengerForm">
	  			  <tr class="row1" style="cursor:pointer">
					<td width="58" align="left" valign="bottom"><bean:write name="list" property="pnrLoctrNum"/></td>
					<td width="79" align="center" valign="bottom"><bean:write name="list" property="pnrCrtnDate"/></td>
					<td width="78" align="center" valign="bottom"><bean:write name="list" property="pnrTravelDate"/></td>
					<td width="56" align="center" valign="bottom"><bean:write name="list" property="pnrMkAlCode"/></td>
					<td width="56" align="center" valign="bottom"><bean:write name="list" property="pnrFltNum"/></td>
					<td width="56" align="center" valign="bottom"><bean:write name="list" property="pnrSegOrigApCode"/></td>
					<td width="56" align="center" valign="bottom"><bean:write name="list" property="pnrSegDestApCode"/></td>
					<td width="215" align="left" valign="bottom"><bean:write name="list" property="pnrPsngrNme"/></td>
					<td width="56" align="center" valign="bottom"><bean:write name="list" property="pnrInvClCode"/></td>
					<td width="56" align="center" valign="bottom"><bean:write name="list" property="pnrSegStatusCode"/></td>
				  </tr>
				  </logic:iterate>
				</table>
				<script>paintMouseEvents('scrollTable');</script>
				</div>
				<!-- The row content end 
			  </td>
			</tr>
			</table>
		</td>-->
	</tr>
	</logic:notEmpty> 
<!-- list end -->
	
<!--detail start -->
	<logic:notEmpty name="lookupPassengerForm" property="pnrTextList">
	<tr><td><table width="100%"><tr>
	
		<td align="left" >
	    <font color="red">DL PNR's from 03/09/2011 to current (prior to 03/09/2011 PNRPUL) &nbsp;&nbsp;&nbsp; NW PNR's Thru 01/30/2010</font>
		</td>
			<td align="right">
				<bean:write property="over1000Lines" name="lookupPassengerForm"  filter="false"/>
			</td>
		<td align="right">
		    <a href="javascript:printData();"><img src="<%=request.getContextPath()%>/images/print.gif" border="0">Print PNR Detail</a>
			<logic:equal name="lookupPassengerForm" property="showRedisplay" value="true">
			    &nbsp;<html:image	page="/images/redisplay_list_btn.gif" border="0" style="cursor:hand;" onclick="redisplay()"/>
			</logic:equal>
		</td></tr></table></td>
	</tr>
	<tr>
		<!--list header start-->
		<td>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="formTable">
			<tr class="subtable_header_bold">
				<th width="100%" align="center" valign="bottom"><bean:message key="pnr.detail.header"/></th>
				<th width="22"></th>
			</tr>
			</table>
		</td>
		<!--list header end-->
	</tr>

	<tr>
		<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="1"  class="formTable">
			<tr class="row1_left_nopoint">
			  <td colspan="8">
				<!-- <div class="memos" style="overflow-y:auto; height:124px; width:867px;" >-->
				<div class="memos">
				<!-- The row content start -->
				<table width="100%">
				  <logic:iterate id="list" property="pnrTextList" name="lookupPassengerForm">
				  <tr align="left">
				    <td valign="top">
				    	<small class="pnr">
				    	<pre><bean:write name="list" /></pre>
				    	</small>
				    </td>
				  </tr>
				  </logic:iterate>
				</table>
				</div>
				<!-- The row content end -->
			  </td>
			</tr>
			</table>
		</td>
	</tr>	
	</logic:notEmpty>
<!-- detail end -->	

</table>
<logic:messagesPresent property="travelDate">
	<script language="javascript">document.forms[0].travelDate.focus();</script>
</logic:messagesPresent>

<logic:messagesPresent property="passengerName">
	<script language="javascript">document.forms[0].passengerName.focus();</script>
</logic:messagesPresent>

	<!-- for scroll into view-->
	<logic:notEmpty name="lookupPassengerForm" property="pnrList"> 	
		<script>
		
		 function scroll(){
			
			var table = document.getElementById("scrollTable");
			
			var tr = table.getElementsByTagName("tr");
			
			var selPnrCrtnDate=document.forms[0].selPnrCrtnDate.value;
			var selPnr=document.forms[0].selPnrLoctrNum.value;
			var selPassenger=document.forms[0].selPassenger.value;
			var selFlightNumber=document.forms[0].selFlightNumber.value;
					
			for(cnt=0;cnt<tr.length;cnt++){
				var pnr = tr[cnt].getElementsByTagName("td")[0].innerText;
				var pnrCrtnDate = tr[cnt].getElementsByTagName("td")[1].innerText;
				var flight = tr[cnt].getElementsByTagName("td")[4].innerText;
				var passenger = tr[cnt].getElementsByTagName("td")[7].innerText;
				if (pnr==selPnr){
					if(pnrCrtnDate==selPnrCrtnDate){
						if(passenger==selPassenger){
							if(flight==selFlightNumber){
								if(cnt>8){
									tr[cnt-2].scrollIntoView();
								}
								tr[cnt].style.backgroundColor = "#6495ED";
								break;
							}
						}				
					}
				}		
			}
		}	
		</script>
	</logic:notEmpty>

</center>
</div>
</body>
