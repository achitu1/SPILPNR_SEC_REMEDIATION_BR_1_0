<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-display.tld" prefix="display" %>

<%java.lang.String contextPath = request.getContextPath();%>



<html>

<LINK href="<html:rewrite page='/theme/PRAMaster.css'/>" rel="stylesheet" type="text/css">

<head>

<script src="/SPIL/js/common.js"></script>

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





function printData() {

   alert("For best results, please set the printer settings to landscape.");

   window.onbeforeprint = hideDivs;

   window.onafterprint = showDivs;

   window.print();

	

  }

  

function printList() {

   alert("For best results, please set the printer settings to landscape.");

   window.onbeforeprint = hideDivs2;

   window.onafterprint = showDivs2;

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

    

 //   tmp5 = document.getElementById('nav');

  //  tmp5.style.display = 'none';



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



 //   tmp5 = document.getElementById('nav');

 //   tmp5.style.display = 'block';



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

  function resetThis(){

  		document.forms[0].pnrLocator.value="";

		document.forms[0].flightNumber.value="";

		document.forms[0].airlineCode.value="";	

  		document.forms[0].passengerName.value="";

  		document.forms[0].localDepartureDate.value="";

  		document.forms[0].action="<%=contextPath%>/SPLJ/OnDemandWaitlistInquiry.do"	               

        document.forms[0].submit();

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

	                this.style.backgroundColor = "#6495ed";

	               

	                var flightNum= this.getElementsByTagName("td")[1].innerText;

	                var depDate= this.getElementsByTagName("td")[2].innerText;

					var pnr = this.getElementsByTagName("td")[3].innerText;

					var passenger= this.getElementsByTagName("td")[5].innerText;

	                var airlineCode = this.getElementsByTagName("td")[0].innerText;

	                var wnum = this.getElementsByTagName("td")[4].innerText;


					var tsstring=this.getElementsByTagName("td")[17].innerText;
		//			alert(tsstring);
					

					document.forms[0].selFlightNumber.value = this.getElementsByTagName("td")[1].innerText;

					//document.forms[0].selFlightNumber.value=flightNum;

					document.forms[0].selDepartureDate.value=depDate;

					document.forms[0].selPnr.value=pnr;

					document.forms[0].selPassenger.value=passenger;

					document.forms[0].selWaitlistNum.value=wnum;

					document.forms[0].selAirlineCode.value=airlineCode;

					document.forms[0].rowSelected.value="true";	

					
					//On Demand begin 1/24/17
 					document.forms[0].seltimeStampString.value=tsstring;
				//On-Demand end

					//alert("row selected= " + document.forms[0].rowSelected.value);				

					document.forms[0].action="<%=contextPath%>/SPLJ/OnDemandWaitlistInquiry.do"	               

	                document.forms[0].submit();

	          };

	    }

	  }

}



function prefillFlightNum(){

	flightNum=document.forms[0].flightNumber.value;

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

function downloadSubmit(){

document.forms[0].download.value='true';

document.forms[0].action="<%=contextPath%>/SPLJ/OnDemandWaitlistInquirySubmit.do"	

document.forms[0].submit();

}

</script>

</head>

<body onload="loadCSS();scroll();">



<html:form		action="/SPLJ/OnDemandWaitlistInquirySubmit.do" method="post">



<div id="main">

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





<table width="950" cellpadding="0" cellspacing="0" border="0">

	<tbody>

		<tr>

			<td align="right">

			<table border="0" cellpadding="0" cellspacing="0" id="tabTable">

				<tbody>

					<tr>

						<td><html:img border="0" page="/images/flight_inquiry_off.gif"

							style="cursor:hand;" onclick="openURLSPIL('OnDemandFlightInquiry.do');" /></td>

						<td><html:img border="0" page="/images/passenger_inquiry_off.gif"

							style="cursor:hand;"

							onclick="openURLSPIL('OnDemandPassengerInquiry.do');" /></td>

						<td><html:img border="0" page="/images/frequent_inquiry_off.gif"

							style="cursor:hand;"

							onclick="openURLSPIL('OnDemandFrequentFlierInquiry.do');" /></td>

						<td><html:img border="0" page="/images/other_inquiry_off.gif"

							style="cursor:hand;" onclick="openURLSPIL('OnDemandOtherInquiry.do');" /></td>

						<td><html:img border="0" page="/images/waitlist_inquiry_on.gif"

							style="cursor:hand;" onclick="openURLSPIL('OnDemandWaitlistInquiry.do');" /></td>

						<td><html:img border="0" page="/images/tab_ssr_inquiry_off.gif"

							style="cursor:hand;" onclick="openURLSPIL('OnDemandSsrInquiry.do');" /></td>

					</tr>

				</tbody>

			</table>

			</td>

		</tr>



		<tr>

			<td>

			<div

				style="background-color: #E5E6EF; border-style: solid; border-color: #B1B4C5; border-width: 1px; width: 100%; height: 50px" id="filterArea">

			<table width="100%" border="0" cellpadding="0" cellspacing="0">

				<tbody>

					<tr>

						<!-- graphic start -->

						<td width="15%" valign="top"><html:img border="0"

							page="/images/spl_airseats.gif" /></td>

						<!-- graphic end -->



						<td width="85%" align="center">

							<table width="90%" align="center" class="filter" border="0"

								cellpadding="0" cellspacing="0">

								<!-- default filter start -->



								<tbody>

									<tr>

										<td>

										<div id="default">

										<table border="0" width="100%">

											<tbody>

												<tr>

													<td align="right">

													<logic:messagesNotPresent property="airlineCode"><bean:message key="spl.waitlist.filter.field.AIRLINECODE" /></logic:messagesNotPresent>

													<logic:messagesPresent property="airlineCode"><font color="red"><bean:message key="spl.waitlist.filter.field.AIRLINECODE" /></font></logic:messagesPresent>

													</td>



													<td width="5"></td>

													<td align="left" width="188"><html:text tabindex="1"

														maxlength="2" size="3" property="airlineCode" onblur="javascript:changeToUpper(this);"/></td>

													<td align="right" width="185">

													<logic:messagesNotPresent property="flightNumber"><bean:message key="spl.waitlist.filter.field.FLIGHTNUMBER" /></logic:messagesNotPresent>

													<logic:messagesPresent property="flightNumber"><font color="red"><bean:message key="spl.waitlist.filter.field.FLIGHTNUMBER" /></font></logic:messagesPresent>													

													</td>

													<td width="3"></td>

													<td align="left" width="42"><html:text tabindex="3"

														maxlength="4" size="4" property="flightNumber" onblur="javascript:changeToUpper(this);" onblur="prefillFlightNum();"/></td>

													<td align="right" width="127">

													<logic:messagesNotPresent property="localDepartureDate"><span><bean:message key="spl.waitlist.filter.field.LOCALDEPARTUREDATE"/></span></logic:messagesNotPresent>

													<logic:messagesPresent property="localDepartureDate"><font color="red"><span><bean:message key="spl.waitlist.filter.field.LOCALDEPARTUREDATE"/></span></font></logic:messagesPresent>																									

													</td>

													

													<td width="3"></td>



													<td align="left" width="350"><html:text tabindex="4"

														maxlength="10" size="8" property="localDepartureDate" /> (MM/DD/YYYY)</td>

												</tr>

												<tr>

													<td align="right" width="96">

													<logic:messagesNotPresent property="passengerName"><bean:message key="spl.waitlist.filter.field.PASSENGERNAME" /></logic:messagesNotPresent>

													<logic:messagesPresent property="passengerName"><font color="red"><bean:message key="spl.waitlist.filter.field.PASSENGERNAME" /></font></logic:messagesPresent>															

													</td>

													<td width="5"></td>

													<td align="left" width="188"><span

														title="<bean:message key="spl.general.label.passengerName"/>"><html:text tabindex="5"

														maxlength="30" size="30" property="passengerName" onblur="javascript:changeToUpper(this);"/></span></td>

													<td align="right" width="81">

													<logic:messagesNotPresent property="pnrLocator"><bean:message key="spl.waitlist.filter.field.PNRLOCATOR" /></logic:messagesNotPresent>

													<logic:messagesPresent property="pnrLocator"><font color="red"><bean:message key="spl.waitlist.filter.field.PNRLOCATOR" /></font></logic:messagesPresent>													

													</td>

													<td width="3"></td>



													<td align="left" width="42"><html:text tabindex="6"

														maxlength="7" size="7" property="pnrLocator" onblur="javascript:changeToUpper(this);" /></td>

													<td colspan="2" align="right"><font color="red" style="font-size:7pt;"></font></td>

												</tr>

											</tbody>

											<tbody></tbody>

										</table>

										</div>

										</td>

									</tr>



									<!-- default filter end -->

									<!-- button set start -->

									<tr>

										<td>

										<table width="100%" align="center" class="filter">

											<tbody>

												<tr>

													<td width="34%"></td>

													<td width="19%" align="right"><html:image

														page="/images/go_button.gif" border="0"

														style="cursor:hand;" tabindex="7" onclick="javascript:checkDateFormat();prefillFlightNum();"/></td>

													<td width="2%"></td>

													<td width="30%" align="left"><html:image

														page="/images/clear_button.gif"

														border="0" style="cursor: hand"

														onclick="resetThis();" tabindex="8"/>

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

													<td align="left" height="25px" valign="bottom" class="requiredText" width="52%"">&nbsp;</td>

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

									<!-- PNR help end -->

								</tbody>

							</table>

							<!-- Ajeet html form -->

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

	<logic:equal property="rowSelected" value="true" name="OnDemandWaitlistInquiryForm">

	<tr><td align="right">

		<table width="100%" id="buttonArea"><tr>

		<td align="left" >

	    	<font color="red">DL SPILs from 03/09/2011 through current (Cancel SPILs from 09/23/2012) &nbsp;&nbsp;&nbsp; NW SPILs Thru 01/30/2010</font>

			</td>

		<td align="right">

		    <a href="javascript:printData();"><img src="<%=request.getContextPath()%>/images/print.gif" border="0">Print SPIL Detail</a>	

		</td>

		<logic:equal name="OnDemandWaitlistInquiryForm" property="flagList" value="true">	

			<td align="right" valign="bottom" width="9%">

				<html:image	page="/images/redisplay_list_btn.gif" border="0"	style="cursor:hand;"/>

			</td>

		</logic:equal>

		</tr></table>

	</td>	

	</tr>

	</logic:equal>

		<!--list header start-->		

		<tr>

				<td>

<div id="scrollListArea">

<logic:present name="OnDemandWaitlistInquiryForm" property="selectList">

<logic:empty name="OnDemandWaitlistInquiryForm" property="selectList">

<font color="red">DL SPILs from 03/09/2011 through current (Cancel SPILs from 09/23/2012) &nbsp;&nbsp;&nbsp; NW SPILs Thru 01/30/2010</font>				

<div id="tableContainer" style="overflow:auto; height:216px; width:100%;border:1px solid #B1B4C5;">	

<table style="margin-top:1px;text-align:center; width:100%;" cellspacing="1" >

		<thead class="fixedHeader">

		<tr>

		<th style="text-align:center;width:8%"><bean:message key="spl.default.header.field.airline"/></th>

		<th style="text-align:center;width:8%"><bean:message key="spl.waitlist.header.field.flightNumber"/>	</th>

		<th style="text-align:center;width:8%"><bean:message key="spl.waitlist.header.field.localDepartureDate"/></th>

		<th style="text-align:center;width:10%"><bean:message key="spl.waitlist.header.field.pnrLocator"/></th>

		<th style="text-align:center;width:10%"><bean:message key="spl.waitlist.header.field.sequence"/></th>

		<th style="text-align:center;width:15%"><bean:message key="spl.waitlist.header.field.name"/></th>

		<th style="text-align:center;width:5%"><bean:message key="spl.waitlist.header.field.v"/></th>

		<th style="text-align:center;width:5%"><bean:message key="spl.waitlist.header.field.b"/></th>

		<th style="text-align:center;width:5%"><bean:message key="spl.waitlist.header.field.r"/></th>

		<th style="text-align:center;width:10%"><bean:message key="spl.waitlist.header.field.origin"/></th>

		<th style="text-align:center;width:10%"><bean:message key="spl.waitlist.header.field.destination"/></th>

		<th style="text-align:center;width:3%"><bean:message key="spl.waitlist.header.field.bookedClass"/></th>

		<th style="text-align:center;width:3%"><bean:message key="spl.waitlist.header.field.flownClass"/></th>

		<th style="text-align:center;width:13%"><bean:message key="spl.waitlist.header.field.type"/></th>

		<th style="text-align:center;width:13%"><bean:message key="spl.waitlist.header.field.cls"/></th>

		<th style="text-align:center;width:13%"><bean:message key="spl.waitlist.header.field.seniority"/></th>

		<th style="text-align:center;width:13%"><bean:message key="spl.waitlist.header.field.time"/></th>

		</tr>

		</thead>

		<tbody class="scrollContent">

		<tr><td width="100%" align="center" colspan="16"><bean:message key="error.no.record"/></td></tr>							

		</tbody>

</table>

</div>

</logic:empty>



<logic:notEmpty name="OnDemandWaitlistInquiryForm" property="selectList">

	<table width="100%"><tr><td width="70%">

	<font color="red">DL SPILs from 03/09/2011 through current (Cancel SPILs from 09/23/2012) &nbsp;&nbsp;&nbsp; NW SPILs Thru 01/30/2010</font>

	</td><td>			

	<div style="width:100%;text-align:right;padding:2px;" id="printButton">

	 <html:img page="/images/excel.gif" border="0" style="cursor:hand;" onclick="downloadSubmit();" /> Download to Excel &nbsp;&nbsp;

	 <a href="javascript:printList();"><img src="<%=request.getContextPath()%>/images/print.gif" border="0">Print List</a>			

	</div></td></tr></table> 			

	<bean:write property="pnrCount" name="OnDemandWaitlistInquiryForm"/>&nbsp;rows returned.

<div id="tableContainer" style="overflow:auto; height:230px; width:100%;border:1px solid #B1B4C5;">	



		<display:table name="OnDemandWaitlistInquiryForm.selectList" class="listTable" requestURI="/SPLJ/OnDemandWaitlistInquirySubmit.do" id="scrollTable" cellpadding="0" cellspacing="1" style="text-align:center; width:100%; background-color: #FFFFFF;" decorator="com.delta.SPLJ.decorators.SPLdecoratorWaitlist"> 

	    <display:setProperty name="locale.provider" value="org.displaytag.localization.I18nStrutsAdapter"/> 

		    <display:column property="airlineCode"			 		sortable="true" 	titleKey="spl.default.header.field.airline" 			style="text-align:center;padding-right:5px;"/>  

	   	  	<display:column property="waitlistFlightNumber" 		sortable="true" 	titleKey="spl.waitlist.header.field.flightNumber" 		style="text-align:center;width:8%;padding-right:5px;"/>  

			<display:column property="waitlistLocalDepartureDate" 	sortable="true" 	titleKey="spl.waitlist.header.field.localDepartureDate" style="text-align:center;width:10%;padding-right:5px;"/>  

		  	<display:column property="waitlistPNRLocator" 			sortable="true" 	titleKey="spl.waitlist.header.field.pnrLocator"			style="text-align:left;width:8%;padding-right:5px;"/> 

		  	<display:column property="waitlistSequence" 			sortable="true"  	titleKey="spl.waitlist.header.field.sequence" 			style="text-align:center;width:8%;padding-right:5px;"/> 

		  	<display:column property="waitlistName"  				sortable="true"  	titleKey="spl.waitlist.header.field.name" 				style="text-align:left;width:11%;padding-right:5px;"/> 

		  	<display:column property="waitlistV" 					sortable="true"  	titleKey="spl.waitlist.header.field.v" 					style="text-align:center;width:3%;padding-right:5px;"/> 

		  	<display:column property="waitlistB" 					sortable="true"  	titleKey="spl.waitlist.header.field.b"					style="text-align:center;width:3%;padding-right:5px;"/>  

	      	<display:column property="waitlistR" 					sortable="true" 	titleKey="spl.waitlist.header.field.r" 					style="text-align:center;width:3%;padding-right:5px;"/>  

	   	  	<display:column property="waitlistOrigin" 				sortable="true" 	titleKey="spl.waitlist.header.field.origin" 			style="text-align:center;width:5%;padding-right:5px;"/>  

	   	  	<display:column property="waitlistDestination" 			sortable="true" 	titleKey="spl.waitlist.header.field.destination" 		style="text-align:center;width:5%;padding-right:5px;"/>  

	   	  	<display:column property="waitlistBookedClass" 			sortable="true" 	titleKey="spl.waitlist.header.field.bookedClass" 		style="text-align:center;width:3%;padding-right:5px;"/>-->

	   	  	<display:column property="waitlistFlownClass" 			sortable="true" 	titleKey="spl.waitlist.header.field.flownClass" 		style="text-align:center;width:3%;padding-right:5px;"/>-->

	   	  	<display:column property="waitlistType" 				sortable="true" 	titleKey="spl.waitlist.header.field.type" 				style="text-align:center;width:7%;padding-right:5px;"/>  

	   	  	<display:column property="waitlistCLS" 					sortable="true" 	titleKey="spl.waitlist.header.field.cls" 				style="text-align:center;width:5%;padding-right:5px;"/>  

	   	  	<display:column property="waitlistSeniority" 			sortable="true" 	titleKey="spl.waitlist.header.field.seniority" 			style="text-align:center;width:8%;padding-right:5px;"/>  

	   	  	<display:column property="waitlistTime" 				sortable="true" 	titleKey="spl.waitlist.header.field.time" 				style="text-align:center;width:7%;padding-right:5px;"/>  
 <!-- on demand begin -->
	    	 <display:column property="timeStampString" 				sortable="true" 	titleKey="spl.default.header.field.TimeStamp" 				style="text-align:center;width:3%;padding-right:2px;"/>
 	    	    <!-- on demand end -->
    	</display:table>

		<script>paintMouseEvents('scrollTable');</script>

</div>

</logic:notEmpty>

</logic:present>

</div>

<logic:equal property="rowSelected" value="true" name="OnDemandWaitlistInquiryForm">

<script>

    document.getElementById("scrollListArea").style.display = "none";   

</script>

<div id="printArea">

<table border="0" width="100%" style="text-align:center;" cellpadding="0" cellspacing="0" class="sub_table">

			<tbody>

			<tr style="padding-top:10px;">

				<td colspan="13" align="center" style="font-size:9pt;">

				<b>	<bean:message key="spl.selected.field.SEAT" /> : <font color="#336699"><bean:write property="selRowSeat" name="OnDemandWaitlistInquiryForm" /></font>&nbsp;&nbsp;&nbsp;&nbsp;

				<bean:message key="spl.selected.field.PASSENGER" /> : <font color="#336699"><bean:write property="selPassenger" name="OnDemandWaitlistInquiryForm" /></font>&nbsp;&nbsp;&nbsp;&nbsp;

				<bean:message key="spl.selected.field.CUST_ID" /> : <font color="#336699"><bean:write property="customerID" name="OnDemandWaitlistInquiryForm" /></font>&nbsp;&nbsp;&nbsp;&nbsp;

				<bean:message key="spl.selected.field.CNCLIND" /> : <font color="#336699"><bean:write property="cnclInd" name="OnDemandWaitlistInquiryForm" /></font>

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
<!-- On Demand Changes Begin -->
						<td colspan="2" width="13%" align="center" style="padding-left:0px;padding-right:6px;"><br/><bean:message key="spl.selected.field.TIMESTAMP" /> &nbsp;</td>
									<!-- On Demand Changes end -->
					</tr>			

					<tr>

						<td align="left" style="padding-left:18px;"><html:text size="10" property="flightNum" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"/></td>

						<td align="left" style="padding-left:2px;padding-right:2px;"><html:text property="depDate" size="14" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"/></td>

						<td align="left" style="padding-left:6px;padding-right:1px;"><html:text property="boardPoint" size="6" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>

						<td align="left" style="padding-left:6px;padding-right:1px;"><html:text property="offPoint" size="6" name="OnDemandWaitlistInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>

						<td align="left" style="padding-left:8px;padding-left:6px;"><html:text property="class1" size="6" name="OnDemandWaitlistInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>

						<td align="left" ><html:text property="bookedClass" size="3" name="OnDemandWaitlistInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>

						<td align="left" ><html:text property="flownClass" size="3" name="OnDemandWaitlistInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>			

						<td align="left" ><html:text property="type" size="3" name="OnDemandWaitlistInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>

						<td align="center"><html:text property="conFrom1" size="5" name="OnDemandWaitlistInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>

						<td align="center"><html:text property="conFrom2" size="5" name="OnDemandWaitlistInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>

						<td align="center"><html:text property="conTo1" size="5" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>

						<td align="center"><html:text property="conTo2" size="5" name="OnDemandWaitlistInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>
		<!-- 	On Demand changes begin -->
						<td align="center"><html:text property="timeStamp" size="22" name="OnDemandWaitlistInquiryForm" readonly="true"  style="background-color:#DAD9D6;" /></td>
							<!-- 	On Demand changes ends -->

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

				<td align="left" valign="top" style="padding-left:15px;"><html:text property="pnr" size="10" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>

				<td colspan="2"  valign="top" style="padding-left:17px;"><html:text property="pnrCreateDate" size="14" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>

				<td colspan="2"  valign="top" style="padding-left:8px;"><html:text property="ticketNumber" size="14" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;" /></td>

				<td colspan="2"  valign="top" style="padding-left:15px;"><html:text property="ticketIssueDate" size="14" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>

				<td valign="top" style="padding-left:15px;"><html:text property="checkinDate" size="12" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>

				<td valign="top" style="padding-left:15px;"><html:text property="checkinTime" size="12" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>

					<td valign="top" style="padding-left:15px;"><html:text property="onBoardDate" size="12" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>

				<td valign="top" style="padding-left:15px;"><html:text property="onBoardTime" size="12" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>

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

				<td valign="top" style="padding-left:15px;"><html:text property="frequentFlierAirline" size="10" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>

				<td valign="top" style="padding-left:18px;padding-right:10px"><html:text property="frequentFlierId" size="14" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>

				<td valign="top" colspan="2" align="left" style="padding-left:5px;padding-right:10px"><html:text property="frequentFlierTier" size="30" name="OnDemandWaitlistInquiryForm" readonly="true" style="background-color:#DAD9D6;"  /></td>

				<td align="left" valign="top" style="padding-right:5px;"><html:text property="ssr" size="8" style="font-family: arial, verdana, sans-serif; font-size: 11px; margin: 0px;" readonly="true" style="background-color:#DAD9D6; font-family: arial, verdana, sans-serif; font-size: 11px; margin: 0px;"/></td>

				<logic:present name="OnDemandWaitlistInquiryForm" property="remList">

				<logic:notEmpty name="OnDemandWaitlistInquiryForm" property="remList">		

				<td colspan="7" align="left" style="padding-left:5px;">

				<table class="filter"><logic:iterate name="OnDemandWaitlistInquiryForm" property="remList" id="remList">

				<tr><td align="left" valign="top" style="padding-bottom:1px;"><input type="text" name="remarks1" size="75" value="<bean:write name='remList' property='remarks1'/>"  readonly  style="background-color:#DAD9D6;"/></td></tr>				

				</logic:iterate>

				</table>

				</td>

				<tr style="padding-top:10px;">	<td width="10%" align="center" colspan="11">&nbsp;</td>	</tr>

				</logic:notEmpty>

				</logic:present>

				<logic:notPresent name="OnDemandWaitlistInquiryForm" property="remList">

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

</logic:equal>

	

				</td>

			</tr>

	</tbody>

</table>

</center>

<html:hidden property="selPnr" name="OnDemandWaitlistInquiryForm"/>

<html:hidden property="rowSelected" name="OnDemandWaitlistInquiryForm" value="false" />

<html:hidden property="selPassenger" name="OnDemandWaitlistInquiryForm"/>

<html:hidden property="selAirlineCode" name="OnDemandWaitlistInquiryForm"/>

<html:hidden property="selDepartureDate" name="OnDemandWaitlistInquiryForm"/>

<html:hidden property="selFlightNumber" name="OnDemandWaitlistInquiryForm"/>

<html:hidden property="selWaitlistNum" name="OnDemandWaitlistInquiryForm"/>

<html:hidden property="flagLookup" name="OnDemandWaitlistInquiryForm" value="false" />

<!-- on demand changes begin -->
<html:hidden property="seltimeStampString" name="OnDemandWaitlistInquiryForm" /> 
<!-- on demand changes ends -->
<html:hidden property="download" name="OnDemandWaitlistInquiryForm" value="false" />

</div>

	



	<script>document.forms[0].airlineCode.focus();</script>

	<logic:messagesPresent property="localDepartureDate"><script>document.forms[0].localDepartureDate.focus();</script></logic:messagesPresent>

	

<html:hidden property="selRowSeat" name="OnDemandWaitlistInquiryForm" value="" />

<logic:equal property="selRowSeat" value="false" name="OnDemandWaitlistInquiryForm">

	<script> 

		alert("Passenger <bean:write property='selPassenger' name='OnDemandWaitlistInquiryForm'/> was not located on the selected flight.");

		document.forms[0].selRowSeat.value="";

		document.forms[0].action="<%=contextPath%>/SPLJ/OnDemandWaitlistInquirySubmit.do"

		document.forms[0].submit();

	</script>

</logic:equal>	



<!-- for scroll List printing -->	

	<div id="printListArea" style="width:100%;display:none;">	

		<display:table name="OnDemandWaitlistInquiryForm.selectList" requestURI="/SPLJ/OnDemandWaitlistInquirySubmit.do" cellpadding="0" cellspacing="1" style="text-align:center; width:100%; background-color: #FFFFFF;font-size: 6pt;" decorator="com.delta.SPLJ.decorators.SPLdecorator"> 

	    <display:setProperty name="locale.provider" value="org.displaytag.localization.I18nStrutsAdapter"/> 

		    <display:column property="airlineCode"			 		sortable="true" 	titleKey="spl.default.header.field.airline" 			style="text-align:center;padding-right:5px;"/>  

	   	  	<display:column property="waitlistFlightNumber" 		sortable="true" 	titleKey="spl.waitlist.header.field.flightNumber" 		style="text-align:center;width:6%;padding-right:5px;font-size: 8pt;"/>  

			<display:column property="waitlistLocalDepartureDate" 	sortable="true" 	titleKey="spl.waitlist.header.field.localDepartureDate" style="text-align:center;width:12%;padding-right:5px;font-size: 8pt;"/>  

		  	<display:column property="waitlistPNRLocator" 			sortable="true" 	titleKey="spl.waitlist.header.field.pnrLocator"			style="text-align:left;width:8%;padding-right:5px;font-size: 8pt;"/> 

		  	<display:column property="waitlistSequence" 			sortable="true"  	titleKey="spl.waitlist.header.field.sequence" 			style="text-align:center;width:8%;padding-right:5px;font-size: 8pt;"/> 

		  	<display:column property="waitlistName"  				sortable="true"  	titleKey="spl.waitlist.header.field.name" 				style="text-align:left;width:13%;padding-right:5px;font-size: 8pt;"/> 

		  	<display:column property="waitlistV" 					sortable="true"  	titleKey="spl.waitlist.header.field.v" 					style="text-align:center;width:3%;padding-right:5px;font-size: 8pt;"/> 

		  	<display:column property="waitlistB" 					sortable="true"  	titleKey="spl.waitlist.header.field.b"					style="text-align:center;width:3%;padding-right:5px;font-size: 8pt;"/>  

	      	<display:column property="waitlistR" 					sortable="true" 	titleKey="spl.waitlist.header.field.r" 					style="text-align:center;width:3%;padding-right:5px;font-size: 8pt;"/>  

	   	  	<display:column property="waitlistOrigin" 				sortable="true" 	titleKey="spl.waitlist.header.field.origin" 			style="text-align:center;width:5%;padding-right:5px;font-size: 8pt;"/>  

	   	  	<display:column property="waitlistDestination" 			sortable="true" 	titleKey="spl.waitlist.header.field.destination" 		style="text-align:center;width:5%;padding-right:5px;font-size: 8pt;"/>  

	   	  	<display:column property="waitlistBookedClass" 			sortable="true" 	titleKey="spl.waitlist.header.field.bookedClass" 		style="text-align:center;width:3%;padding-right:5px;font-size: 8pt;"/>

	   	  	<display:column property="waitlistFlownClass" 			sortable="true" 	titleKey="spl.waitlist.header.field.flownClass" 		style="text-align:center;width:3%;padding-right:5px;font-size: 8pt;"/>

	   	  	<display:column property="waitlistType" 				sortable="true" 	titleKey="spl.waitlist.header.field.type" 				style="text-align:center;width:4%;padding-right:5px;font-size: 8pt;"/>  

	   	  	<display:column property="waitlistCLS" 					sortable="true" 	titleKey="spl.waitlist.header.field.cls" 				style="text-align:center;width:4%;padding-right:5px;font-size: 8pt;"/>  

	   	  	<display:column property="waitlistSeniority" 			sortable="true" 	titleKey="spl.waitlist.header.field.seniority" 			style="text-align:center;width:12%;padding-right:5px;font-size: 8pt;"/>  

	   	  	<display:column property="waitlistTime" 				sortable="true" 	titleKey="spl.waitlist.header.field.time" 				style="text-align:center;width:9%;padding-right:5px;font-size: 8pt;"/> 
 <!-- on demand begin -->
	    	 <display:column property="timeStamp" 				sortable="true" 	titleKey="spl.default.header.field.TimeStamp" 				style="text-align:center;width:3%;padding-right:2px;"/>
	    	    <!-- on demand end -->
    	</display:table>

		<script>paintMouseEvents('scrollTable');</script>

	</div>

<logic:equal name="OnDemandWaitlistInquiryForm" property="flagLookup" value="true">

<script>

var url = "/SPLJ/OnDemandPassengerList.do"

	url+= "?selDepartureDate=" 	+ document.forms[0].selDepartureDate.value;

	url+= "&selAirlineCode=" 	+ document.forms[0].selAirlineCode.value;

	url+= "&selFlightNumber=" 	+ document.forms[0].selFlightNumber.value;

	url+= "&selPnr=" 			+ document.forms[0].selPnr.value;

var passenger=window.showModalDialog( contextPath + url, 'allPassengers', 'scrollbars,width=450,height=250' );

if ((passenger !="")&&(passenger!= null)){

document.forms[0].selPassenger.value= passenger;

document.forms[0].rowSelected.value="true";

document.forms[0].submit();

}else{

	document.forms[0].action='<%=contextPath%>/SPLJ/OnDemandWaitlistInquirySubmit.do';

	document.forms[0].submit();

}

</script>

</logic:equal>	



</html:form>

</body>

</html>



	<!-- for scroll into view-->

	<logic:present name="OnDemandWaitlistInquiryForm" property="selectList">

	<logic:notEmpty name="OnDemandWaitlistInquiryForm" property="selectList">		

	<logic:notEqual property="selPassenger" value="" name="OnDemandWaitlistInquiryForm">

		<script>

		function scroll(){



			var table = document.getElementById("scrollTable");

			var tr = table.getElementsByTagName("tr");

			for(cnt=1;cnt<tr.length;cnt++){

				//var passenger = tr[cnt].getElementsByTagName("td")[5].innerText;

				var selPnr = tr[cnt].getElementsByTagName("td")[3].innerText;

				var flight = tr[cnt].getElementsByTagName("td")[1].innerText;

				var wnum =tr[cnt].getElementsByTagName("td")[4].innerText;

				

				if ((selPnr==document.forms[0].selPnr.value)&&(flight==document.forms[0].selFlightNumber.value)&&(wnum==document.forms[0].selWaitlistNum.value)){

					if(cnt>8){

						tr[cnt-2].scrollIntoView();

					}

					tr[cnt].style.backgroundColor = "#6495ED";

				}			

			}

		}	

		</script>

	</logic:notEqual>

	</logic:notEmpty>

	</logic:present>	

