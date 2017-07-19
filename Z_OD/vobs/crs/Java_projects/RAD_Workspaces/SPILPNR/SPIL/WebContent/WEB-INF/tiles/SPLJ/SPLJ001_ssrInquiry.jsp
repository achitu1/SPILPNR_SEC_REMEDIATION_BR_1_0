<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-display.tld" prefix="display" %>
<%java.lang.String contextPath = request.getContextPath();%>
<%java.lang.String contextpath = request.getContextPath();%>
<html>

<head>
<script src="/SPIL/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/theme/PRAMaster.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/theme/print.css" />
<% 	String path = contextpath+"/PNRJ/redirectApp.do";%>
<script>
var contextPath = '<%=request.getContextPath()%>';

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

function checkDateFormat(){
	dateval= document.forms[0].localDepartureDate.value;
	if (dateval.length == 10){
		if (dateval.search('/') != -1){
			if (dateval.charAt(2)=='/'){	
				dateval=dateval.replace(/\//,'-');
			}
			if (dateval.charAt(5)=='/'){	
				dateval=dateval.replace(/\//,'-');
			}
		}
	}else if(dateval.length == 8){		
		if ((dateval.search('/') == -1)&&(dateval.search('-') == -1)){
			var month=dateval.substr(0,2);
			var day=dateval.substr(2,2);
			var year=dateval.substr(4,4);
			dateval = month + "-" + day +"-" + year;
		}else if(dateval.search('/') == 2) {
			arDate = dateval.split('/');
			var month=arDate[0];
			var day=arDate[1];
			var year=arDate[2];
			if(year<70){
				year="20" + year;
			}else{
				year="19" + year;
			}
			dateval=month + "-" + day + "-" + year;
		}else if(dateval.search('-') == 2) {
			arDate = dateval.split('-');
			var month=arDate[0];
			var day=arDate[1];
			var year=arDate[2];
			if(year<70){
				year="20" + year;
			}else{
				year="19" + year;
			}
			dateval=month + "-" + day + "-" + year;
		}		
	}else if(dateval.length==7){
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
	document.forms[0].localDepartureDate.value=dateval;
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
	                

	                var apCode = this.getElementsByTagName("input")[0].value;
	                var seqNum = this.getElementsByTagName("input")[1].value;
					var passenger=this.getElementsByTagName("td")[4].innerText;
					var rowseat= this.getElementsByTagName("td")[8].innerText;
					var pnrnum=this.getElementsByTagName("td")[9].innerText;

					document.forms[0].selLegOrigApCode.value=apCode;
					document.forms[0].selSeqNum.value=seqNum;
					document.forms[0].selRowSeat.value=rowseat;
					document.forms[0].selPassenger.value=passenger;
					document.forms[0].selPnr.value=pnrnum;
					
					//alert("pnrNum captured is" + document.forms[0].selPnr.value);
					
					document.forms[0].rowSelected.value="true";	
					

					document.forms[0].action="<%=contextPath%>/SPLJ/SsrInquiryRowSelected.do"	               
	                document.forms[0].submit();
	          };

	    }
	  }
}

function downloadSubmit(){
	document.forms[0].download.value='true';
	document.forms[0].action="<%=contextPath%>/SPLJ/SsrInquiryList.do"	
	document.forms[0].submit();
}

function printList() {
   alert("For best results, please set the printer settings to landscape.");
   window.onbeforeprint = hideDivs2;
   window.onafterprint = showDivs2;
   window.print();

}

function printData() {
   alert("For best results, please set the printer settings to landscape.");
   window.onbeforeprint = hideDivs;
   window.onafterprint = showDivs;
   window.print();
}


function hideDivs () {
    tmp2 = document.getElementById('header');
    tmp2.style.display = 'none';

//    tmp3 = document.getElementById('logo');
//    tmp3.style.display = 'none';

    tmp4 = document.getElementById('filterArea');
    tmp4.style.display = 'none';	
    
//    tmp5 = document.getElementById('nav');
//    tmp5.style.display = 'none';

    tmp6 = document.getElementById('footer');
    tmp6.style.display = 'none';

    tmp7 = document.getElementById('tabTable');
    tmp7.style.display = 'none';	
    
    tmp8 = document.getElementById('buttonArea');
    tmp8.style.display = 'none';	

    tmp = document.getElementById('printArea');
    tmp.style.display = 'block';	
        
 }

function showDivs () {
    tmp = document.getElementById('printArea');
    tmp.style.display = 'block';	

    tmp2 = document.getElementById('header');
    tmp2.style.display = 'block';

//    tmp3 = document.getElementById('logo');
//    tmp3.style.display = 'block';

    tmp4 = document.getElementById('filterArea');
    tmp4.style.display = 'block';	

//    tmp5 = document.getElementById('nav');
//    tmp5.style.display = 'block';

    tmp6 = document.getElementById('footer');
    tmp6.style.display = 'block';
    
    tmp7 = document.getElementById('tabTable');
    tmp7.style.display = 'block';	
    
    tmp8 = document.getElementById('buttonArea');
    tmp8.style.display = 'block';	
}  

function hideDivs2 () {
    tmp2 = document.getElementById('header');
    tmp2.style.display = 'none';

//    tmp3 = document.getElementById('logo');
//    tmp3.style.display = 'none';

    tmp4 = document.getElementById('filterArea');
    tmp4.style.display = 'none';	
    
//    tmp5 = document.getElementById('nav');
//    tmp5.style.display = 'none';

    tmp6 = document.getElementById('footer');
    tmp6.style.display = 'none';

    tmp7 = document.getElementById('tabTable');
    tmp7.style.display = 'none';	
        
    tmp8 = document.getElementById('printButton');
    tmp8.style.display = 'none';	

    tmp10 = document.getElementById('scrollListArea');
    tmp10.style.display = 'none';	
    
    tmp9 = document.getElementById('printListArea');
    tmp9.style.display = 'block';	
}

function showDivs2 () {
    tmp2 = document.getElementById('header');
    tmp2.style.display = 'block';

//    tmp3 = document.getElementById('logo');
//    tmp3.style.display = 'block';

    tmp4 = document.getElementById('filterArea');
    tmp4.style.display = 'block';	

//    tmp5 = document.getElementById('nav');
//    tmp5.style.display = 'block';

    tmp6 = document.getElementById('footer');
    tmp6.style.display = 'block';
    
    tmp7 = document.getElementById('tabTable');
    tmp7.style.display = 'block';	

    tmp8 = document.getElementById('printButton');
    tmp8.style.display = 'block';
    
    tmp9 = document.getElementById('printListArea');
    tmp9.style.display = 'none';	

    tmp10 = document.getElementById('scrollListArea');
    tmp10.style.display = 'block';

}  

function changeToUpper(obj){
	var val= obj.value;
	obj.value=val.toUpperCase();
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

function resetThis(){
	document.forms[0].airlineCode.value="";
	document.forms[0].flightNumber.value="";
  	document.forms[0].localDepartureDate.value="";
  	document.forms[0].ssrCode.value="";
  	document.forms[0].action="<%=contextPath%>/SPLJ/SsrInquiry.do";
    document.forms[0].submit();
}

function goSearchSsr(){
  	document.forms[0].action="<%=contextPath%>/SPLJ/SsrInquiryList.do";
  	document.forms[0].submit();
}

function focusElement(){
	document.forms[0].airlineCode.focus();
}

function scroll(){
	var table = document.getElementById("scrollTable");
	if(table != null){
		var tr = table.getElementsByTagName("tr");
		for(cnt=1;cnt<tr.length;cnt++){
			var passenger = tr[cnt].getElementsByTagName("td")[4].innerText;
			var seat = tr[cnt].getElementsByTagName("td")[8].innerText;
			if ((passenger== document.forms[0].selPassenger.value)&&(seat==document.forms[0].selRowSeat.value)){
				if(cnt>8){
					tr[cnt-2].scrollIntoView();
				}
				tr[cnt].style.backgroundColor = "#6495ED";
			}			
		}
	}
}

function toUpperCase(){
	code = window.event.keyCode;
	var character = String.fromCharCode(code);
	var char2 = character.toUpperCase();	
	window.event.keyCode=char2.charCodeAt(0);	
}

	function goLogOut(){
		tmp = confirm("You are about to log out of this application. \nProceed?");
		if (tmp){
			if (document.logout == null){/// defect #3 code change begins				open(location, '_self').close();/// defect #3 code change ends
			    var logoutForm = document.createElement("<FORM METHOD='post' ACTION='ibm_security_logout?logoutExitPage=/index.jsp' NAME='logout'></FORM>");
			    document.body.insertBefore(logoutForm);

				document.logout.submit();
				window.close();
			}
		}
	}
 
</script>
</head>
<body onload="loadCSS();scroll();focusElement();">
<!--Header-->
<tiles:importAttribute name="title" />
<div id="header">	
	<table width="950" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr>
		<td>

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
					<tr>
						<td align="right" width="70%">
							<logic:present role="queryonly,querycc">
								<html:link href="<%=path%>" target="blank"> PNR</html:link>&nbsp;|&nbsp; 
									</logic:present> <logic:notPresent role="queryonly,querycc">		
									 PNR&nbsp;|&nbsp; 
							</logic:notPresent>
					 		  <html:link href="http://iviewer.delta-air.com/iviewer/iv" target="blank">Imaging</html:link>&nbsp;|
					 		  <html:link href="http://www.delta.com/planning_reservations/plan_flight/aircraft_types_layout/index.jsp" target="blank">Seat Maps</html:link>&nbsp;|
					          <a href="#" onclick="goLogOut();" style="cursor:hand;">Logout</a>
						</td>
					</tr>
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
</div>	
<html:form action="/SPLJ/SsrInquiryList.do" method="post">
<html:hidden property="rowSelected" name="ssrInquiryForm" value="false" />
<html:hidden property="selPassenger" name="ssrInquiryForm"/>
<html:hidden property="selRowSeat" name="ssrInquiryForm"/>
<html:hidden property="selPnr" name="ssrInquiryForm"/>
<html:hidden property="selLegOrigApCode" name="ssrInquiryForm"/>
<html:hidden property="selSeqNum" name="ssrInquiryForm"/>
<html:hidden property="download" name="ssrInquiryForm" value="false" />	
	<table width="950" border="0" cellpadding="0" cellspacing="0"
		align="center">
		<tbody>
			<tr>
				<td>
				<div id="errortop"><html:errors /></div>
				</td>
			</tr>
		</tbody>
	</table>
<center>
<div id="main">
	<table width="950" cellpadding="0" cellspacing="0" border="0">
	  <tbody>
		<tr>
			<td align="right">
			<table border="0" cellpadding="0" cellspacing="0" id="tabTable">
				<tbody>
					<tr>
						<td><html:img border="0" page="/images/flight_inquiry_off.gif"
							style="cursor:hand;" onclick="openURLSPIL('FlightInquiry.do');" /></td>
						<td><html:img border="0" page="/images/passenger_inquiry_off.gif"
							style="cursor:hand;"
							onclick="openURLSPIL('PassengerInquiry.do');" /></td>
						<td><html:img border="0" page="/images/frequent_inquiry_off.gif"
							style="cursor:hand;"
							onclick="openURLSPIL('FrequentFlierInquiry.do');" /></td>
						<td><html:img border="0" page="/images/other_inquiry_off.gif"
							style="cursor:hand;" onclick="openURLSPIL('OtherInquiry.do');" /></td>
						<td><html:img border="0" page="/images/waitlist_inquiry_off.gif"
							style="cursor:hand;" onclick="openURLSPIL('WaitlistInquiry.do');" /></td>
						<td><html:img border="0" page="/images/tab_ssr_inquiry_on.gif"
							style="cursor:hand;" onclick="openURLSPIL('SsrInquiry.do');" /></td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
		
		<tr>
			<td>
				<div style="background-color: #E5E6EF; border-style: solid; border-color: #B1B4C5; border-width: 1px; width: 100%; height: 50px" id="filterArea">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" >
						<tbody>
							<tr>
							<!-- graphic start -->
							<td width="15%"><html:img border="0" page="/images/spl_airseats.gif" /></td>
							<!-- graphic end -->
							<td width="85%" align="center">
								<table width="90%" align="center" class="filter" border="0" cellpadding="0" cellspacing="0">
									<!-- default filter start -->
									<tbody>
										<tr>
											<td>
											<div id="default">
											<table border="0" width="100%">
											<tbody>
											    <tr><td width="155">&nbsp;</td></tr>	
												<tr>
													<td align="right" width="155">
														<logic:messagesNotPresent property="airlineCode"><bean:message key="spl.flight.filter.field.AIRLINECODE" /></logic:messagesNotPresent>
														<logic:messagesPresent property="airlineCode"><font color="red"><bean:message key="spl.flight.filter.field.AIRLINECODE" /></font></logic:messagesPresent>&nbsp;
														<font color="red" style="font-size:7pt;">*</font>
													</td>
													<td width="3"></td>
													<td align="left" width="36"><html:text tabindex="1" 
														maxlength="2" size="3" property="airlineCode"   onkeypress="toUpperCase();"></html:text>
													</td>
													<td align="right" width="134">
														<logic:messagesNotPresent property="flightNumber"><bean:message key="spl.flight.filter.field.FLIGHTNUMBER" /></logic:messagesNotPresent>
														<logic:messagesPresent property="flightNumber"><font color="red"><bean:message key="spl.flight.filter.field.FLIGHTNUMBER" /></font></logic:messagesPresent>&nbsp;<font color="red" style="font-size:7pt;">*</font>
													</td>
													<td width="4"></td>
													<td align="left" width="30"><html:text tabindex="2"
														maxlength="4" size="4" property="flightNumber" onblur="prefillFlightNum();"/>
													</td>
													<td align="right" width="160"><span >
														<logic:messagesNotPresent property="localDepartureDate"><span><bean:message key="spl.flight.filter.field.LOCALDEPARTUREDATE"/></span></logic:messagesNotPresent>
														<logic:messagesPresent property="localDepartureDate"><font color="red"><span><bean:message key="spl.flight.filter.field.LOCALDEPARTUREDATE"/></span></font></logic:messagesPresent></span>&nbsp;
													<font color="red" style="font-size:7pt;">*</font>
													</td>
													<td width="8"></td>
													<td align="left" width="250"><html:text tabindex="3"
														maxlength="10" size="8" property="localDepartureDate" /> (MM/DD/YYYY)
													</td>
												</tr>
												<tr>
													<td align="right" width="155">
														SSR Code
													</td>
													<td width="3"></td>
													<td align="left" width="36">
														<html:text tabindex="4" maxlength="4" size="3" property="ssrCode"  onkeypress="toUpperCase();" />
													</td>
													<td align="right" width="134">
													</td>
													<td width="4"></td>
													<td align="left" width="30">
													</td>
													<td align="right" width="160">
													</td>
													<td width="8"></td>
													<td align="left" width="121">
													</td>
													
												</tr>
											</tbody>
											</table>
											</div>
											</td>
										</tr>
										<tr>
											<td>
											<table width=100%" align="center" class="filter">
												<tbody>
													<tr>
														<td width="34%"></td>
														<td align="right" width="19%"><html:image
															page="/images/go_button.gif" border="0"
															style="cursor:hand;" tabindex="4" onclick="javascript:checkDateFormat();prefillFlightNum();goSearchSsr();"/></td>
														<td width="2%"></td>
														<td align="left" width="30%"><html:image
															page="/images/clear_button.gif"
															border="0" style="cursor: hand"
															onclick="javascript:resetThis();" tabindex="5"/>
														</td>
														<td></td>
													</tr>
												</tbody>
											</table>
											</td>
										</tr>
										<!-- button set end -->
										<!-- PNR help start -->
										<tr>
											<td>
											<table width="100%" align="center" class="filter" border="0" height="20px" cellpadding="0" cellspacing="0">
												<tbody>						
													<tr>
														<td align="left" height="25px" valign="bottom" class="requiredText">Please note: fields with * are required</td>
														<td align="right" valign="bottom"><font color="red" size="1">
														<html:link href="javascript:void( window.showModalDialog( contextPath + '/SPLJ/LookupDeltaSPLJCodes.do', 'allCodes', 'scrollbars,width=680,height=400' ))" tabindex="-1">
														<html:img page="/images/logo_help.gif" border="0" style="cursor:hand;"/>&nbsp;<bean:message key="spl.general.label.dlHelpCode"/>
														</html:link>
													</font></td>

													</tr>
												</tbody>
											</table>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
							</tr>
						</tbody>
					</table>
				</div>			
			</td>
		</tr>	
		<tr>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td>
				<!--START Sub Main Window Content - Search Result List -->
				<center>				
				<!-- list start -->
					<tiles:insert name="ssrSubBody" />				
				</center>
				
				<!--END Sub Main Window Content - Search Result List -->
			</td>
		</tr>
	</tbody>
	</table>
</div>
</center>

</html:form>	
<!--Footer-->
<tiles:insert attribute="footer" />

</body>
</html>

