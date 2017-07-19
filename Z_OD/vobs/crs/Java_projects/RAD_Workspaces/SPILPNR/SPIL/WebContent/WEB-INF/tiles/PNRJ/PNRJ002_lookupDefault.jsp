<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%
	String contextPath = request.getContextPath();
%>

<script language="javascript">
function printData() {
    window.onbeforeprint = hideDivs;
    window.onafterprint = showDivs;
    window.print();
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
//    tmp5.style.display = 'none';

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
//     tmp5.style.display = 'block';

    tmp6 = document.getElementById('footer');
    tmp6.style.display = 'block';
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
				
				document.forms[0].action='<%=contextPath%>/PNRJ/LookupDefaultDetailShow.do';
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
function goFOP(){
	document.forms[0].selectFop.value = true;
	if ( document.forms[0].selPnrLoctrNum.value == ""){
		document.forms[0].action='<%=contextPath%>/PNRJ/LookupDefaultSubmit.do';
	}else{
		document.forms[0].action='<%=contextPath%>/PNRJ/LookupDefaultDetailShow.do';
	}
	document.forms[0].submit();
}
function goRedisplayList(){
	<logic:notEmpty name="lookupDefaultForm" property="fopList">
	history.go(-2);
	</logic:notEmpty>
	<logic:empty name="lookupDefaultForm" property="fopList">
	history.go(-1);
	</logic:empty>
}
function goSubmit(){
document.forms[0].action='<%=contextPath%>/PNRJ/LookupDefaultSubmit.do';
document.forms[0].submit();
}

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

function replaceWhiteSpaces(s)  
{ 
 
     reWhiteSpace = new RegExp(/^\s+$/); 
 
     // Check for white space 
     if (reWhiteSpace.test(s)) { 
          //alert("Please Check Your Fields For Spaces"); 
          document.write(s.replace(" ", '&nbsp;'));
          
     } 

}

</script>


<body onload="loadCSS();scroll();">

<logic:notEmpty name="lookupDefaultForm" property="pnrTextList">

	<div id="printArea"
		style="display: none; margin-right: -20px; margin-left: -20px">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<logic:iterate id="list" property="pnrTextList"
			name="lookupDefaultForm">
			<bean:define name="list" id="a" />
			<script language="javascript">
		 	var aa = '<%=a%>';
		 	document.write("<tr><td><small class='pnr'><pre>" + aa + "</pre></small></td></tr>");
 		  // document.write("<tr><td><pre>" + aa + "</pre></td></tr>");
		</script>
		</logic:iterate>
	</table>
	</div>

</logic:notEmpty>

<logic:notEmpty name="lookupDefaultForm" property="pnrList">

	<div id="printArea" style="display: none; margin: -10px">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">

		<tr>
			<!--list header start-->
			<td>
			<table width="950" border="0" cellpadding="0" cellspacing="0"
				style="margin-top: 1px; text-align: center; width: 100%;">
				<tr>
					<th width="70" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.pnrNumber" /></th>
					<th width="70" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.pnrCreationDate" /></th>
					<th width="70" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.travelDate" /></th>
					<th width="60" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.airline" /></th>
					<th width="70" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.flightNumber" /></th>
					<th width="60" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.origin" /></th>
					<th width="80" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.destination" /></th>
					<th width="250" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.passenger" /></th>
					<th width="60" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.classCode" /></th>
					<th width="60" align="center" valign="bottom"><bean:message
						key="pnr.default.header.field.segmentStatus" /></th>
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
					<td><!-- The row content start -->
					<table width="950" border="0">

						<bean:define id="P" name="lookupDefaultForm" property="pnrLocator"
							type="java.lang.String" />
						<bean:define id="T" name="lookupDefaultForm"
							property="ticketNumber" type="java.lang.String" />
						<bean:define id="E" name="lookupDefaultForm"
							property="employeeNumber" type="java.lang.String" />
						<bean:define id="F" name="lookupDefaultForm"
							property="frequentFlyerNumber" type="java.lang.String" />
						<bean:define id="C" name="lookupDefaultForm"
							property="creditCardNumber" type="java.lang.String" />

						<logic:iterate id="list" property="pnrList"
							name="lookupDefaultForm">
							<bean:define id="pnrLoctrNum" name="list" property="pnrLoctrNum"
								type="java.lang.String" />
							<bean:define id="pnrCrtnDate" name="list" property="pnrCrtnDate"
								type="java.lang.String" />
							<tr class="row1" style="cursor: pointer"
								onmouseover="javascript:this.className='row1hover';"
								onmouseout="javascript:this.className='row1';"
								onclick="location.href='LookupDefaultDetailShow.do?selPnrLoctrNum=<%=pnrLoctrNum%>&selPnrCrtnDate=<%=pnrCrtnDate%>&pnrLocator=<%=P%>&ticketNumber=<%=T%>&employeeNumber=<%=E%>&frequentFlyerNumber=<%=F%>&creditCardNumber=<%=C%>'">

								<td width="69" align="left" valign="bottom"><bean:write
									name="list" property="pnrLoctrNum" /></td>
								<td width="69" align="center" valign="bottom"><bean:write
									name="list" property="pnrCrtnDate" /></td>
								<td width="69" align="center" valign="bottom"><bean:write
									name="list" property="pnrTravelDate" /></td>
								<td width="59" align="center" valign="bottom"><bean:write
									name="list" property="pnrMkAlCode" /></td>
								<td width="69" align="center" valign="bottom"><bean:write
									name="list" property="pnrFltNum" /></td>
								<td width="59" align="center" valign="bottom"><bean:write
									name="list" property="pnrSegOrigApCode" /></td>
								<td width="79" align="center" valign="bottom"><bean:write
									name="list" property="pnrSegDestApCode" /></td>
								<td width="249" align="left" valign="bottom"><bean:write
									name="list" property="pnrPsngrNme" /></td>
								<td width="59" align="center" valign="bottom"><bean:write
									name="list" property="pnrInvClCode" /></td>
								<td width="59" align="center" valign="bottom"><bean:write
									name="list" property="pnrSegStatusCode" /></td>
							</tr>
						</logic:iterate>
					</table>

					<!-- The row content end --></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
</logic:notEmpty>
<div id="main">
<table width="950" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td>
		<div id="errortop"><html:errors /></div>
		</td>
	</tr>
</table>

<center>

<table width="950" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td align="right">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><html:img border="0" page="/images/tab_dlu_on.gif"
					style="cursor:hand;" onclick="location.href='LookupDefault.do'" /></td>
				<td><html:img border="0" page="/images/tab_plu_off.gif"
					style="cursor:hand;" onclick="location.href='LookupPassenger.do'" /></td>
				<td><html:img border="0" page="/images/tab_fnlu_off.gif"
					style="cursor:hand;" onclick="location.href='LookupFlight.do'" /></td>
				<td><html:img border="0" page="/images/tab_odlu_off.gif"
					style="cursor:hand;" onclick="location.href='LookupOrigDest.do'" /></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<div
			style="background-color: #E5E6EF; border-style: solid; border-color: #B1B4C5; border-width: 1px; width: 100%; height: 50px;">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<!-- graphic start -->
				<td width="200"><html:img border="0"
					page="/images/passengersearch2.jpg" /></td>
				<!-- graphic end -->

				<td width="672" align="center" valign="middle"><html:form
					action="/PNRJ/LookupDefaultSubmit.do" focus="pnrLocator"
					onsubmit="clearSelected;">
					<html:hidden name="lookupDefaultForm" property="loctrNum" />
					<html:hidden name="lookupDefaultForm" property="crtnDate" />
					<html:hidden name="lookupDefaultForm" property="travelDateSort" />
					<html:hidden name="lookupDefaultForm" property="mkAlCode" />
					<html:hidden name="lookupDefaultForm" property="fltNum" />
					<html:hidden name="lookupDefaultForm" property="segOrigApCode" />
					<html:hidden name="lookupDefaultForm" property="segDestApCode" />
					<html:hidden name="lookupDefaultForm" property="psngrNme" />
					<html:hidden name="lookupDefaultForm" property="invClCode" />
					<html:hidden name="lookupDefaultForm" property="segStatusCode" />
					<html:hidden name="lookupDefaultForm" property="showRedisplay" />
					<html:hidden name="lookupDefaultForm" property="selectFop"/>
					<html:hidden name="lookupDefaultForm" property="userAuthorizedCC"/>
					<html:hidden property="selPnrCrtnDate" name="lookupDefaultForm" />
					<html:hidden property="selPnrLoctrNum" name="lookupDefaultForm" />
					<html:hidden property="selPassenger" name="lookupDefaultForm" />
					<html:hidden property="selFlightNumber" name="lookupDefaultForm" />

					<table width="650" align="center" class="filter" border="0"
						cellpadding="0" cellspacing="0">
						<!-- default filter start -->
						<tr>
							<td>
							<div id="default">

							<table border="0">
								<tr>
									<td width="150" align="right"><bean:message
										key="pnr.defaultlookup.filter.field.PNRLOCATOR" /></td>
									<td width="2"></td>
									<td width="120" align="left"><html:text
										property="pnrLocator" maxlength="6" size="10" tabindex="1"
										onkeyup="javascript:changeToUpper(this);" /></td>
									<td width="100" align="right"><bean:message
										key="pnr.defaultlookup.filter.field.TICKETNO" /></td>
									<td width="2"></td>
									<td width="100" align="left"><html:text
										property="ticketNumber" maxlength="13" size="15" tabindex="3" />
									</td>
									<td width="100" align="right"></td>
									<td width="2"></td>
									<td align="left"> </td>
								</tr>
								<tr>
									<td width="150" align="right"><bean:message
										key="pnr.defaultlookup.filter.field.EMPLOYEENO" /></td>
									<td width="2"></td>
									<td align="left" colspan=7><html:text
										property="employeeNumber" maxlength="10" size="10"
										tabindex="4" onkeyup="javascript:changeToUpper(this);" /> &nbsp;DL PPRID (i.e. 012345600) or PMNW ID (i.e. 123456)</td>
								</tr>
								<tr>
									<td width="150" align="right"><span
										title="Frequent Flier: NW123423456"><bean:message
										key="pnr.defaultlookup.filter.field.FREQUENTFLYERNO" /></span></td>
									<td width="2"></td>
									<td width="120" align="left"><span title="<bean:message key="pnr.defaultlookup.filter.field.FREQUENTFLYEREXAMPLE"/>"><html:text
										property="frequentFlyerNumber" maxlength="18" size="20"
										tabindex="5" onkeyup="javascript:changeToUpper(this);" /></span></td>
									<logic:present role="querycc">
										<td width="202" colspan="3">(i.e. DL1234567890)</td>
										<td width="100" align="right"><span
											title="Credit Card: VI9999444455558888"><bean:message
											key="pnr.defaultlookup.filter.field.CREDITCARDNO" /></span></td>
										<td width="2"></td>
										<td width="52" align="left"><html:text
											property="creditCardNumber" maxlength="19" size="20"
											tabindex="6" onkeyup="javascript:changeToUpper(this);" /></td>
									</logic:present>
									<logic:notPresent role="querycc">
										<td width="202" colspan="3">(i.e. DL1234567890)</td>
										<td colspan="3"></td>
									</logic:notPresent>
								</tr>
							</table>
							</div>
							</td>
						</tr>
						<!-- default filter end -->

						<!-- button set start -->
						<tr>
							<td>
							<!--  <table width="650" align="center" class="filter">
								<tr>
									<td width="70"></td>
									<td width="250" align="right"><html:image
										page="/images/go_button.gif" border="0" style="cursor:hand;"
										tabindex="7" /></td>
									<td width="10"></td>
									<td width="250" align="left"><img
										src="<%=request.getContextPath()%>/images/clear_button.gif"
										border="0" style="cursor: hand;"
										onclick="location.href='LookupDefault.do'" tabindex="8">-->

							 <table width="100%" align="center" class="filter" border="0">
								<tr>
									<td width="70"></td>
									<td width="5%" align="right" style="padding-right: 5px"><img
										src="<%=request.getContextPath()%>/images/go_button.gif"
										border="0" style="cursor: hand;" onclick="goSubmit();"
										tabindex="7"></td>
									<logic:equal name="lookupDefaultForm"
										property="userAuthorizedCC" value="TRUE">
										<logic:empty name="lookupDefaultForm" property="pnrList">
											<td width="5%" align="center" style="padding-right: 5px">
											<img src="<%=request.getContextPath()%>/images/CC_FOP_On.gif"
												border="0" style="cursor: hand;"
												onclick="javascript:goFOP();" tabindex="8"></td>
										</logic:empty>
									</logic:equal>
									<td width="5%" align="left"><img
										src="<%=request.getContextPath()%>/images/clear_button.gif"
										border="0" style="cursor: hand;"
										onclick="location.href='LookupDefault.do'" tabindex="9">

									<%--html:img page="/images/clear_button.gif" border="0" style="cursor:hand;" onclick="location.href='LookupDefault.do'"/--%>
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
									<td align="left" valign="middle"><font color="red">*
									Please enter data in one field per search only</font></td>
									<td align="right" valign="middle"><html:link
										href="javascript:void( window.open( 'LookupDeltaPNRCodes.do', 'pnrCodes', 'scrollbars,width=680,height=400' ))"
										tabindex="10">
										<html:image page="/images/logo_help.gif" border="0"
											style="cursor:hand;" />
										DL PNR Codes</html:link></td>
									<td align="right" valign="middle"><html:link
										href="javascript:void( window.open( 'LookupPNRCodes.do', 'pnrCodes', 'scrollbars,width=680,height=400' ))"
										tabindex="11">
										<html:image page="/images/logo_help.gif" border="0"
											style="cursor:hand;" />
										NW PNR Codes</html:link></td>	
								</tr>
							</table>
							</td>
						</tr>
						<!-- PNR help end -->
					</table>
				</html:form></td>
			</tr>
		</table>
		</div>
		</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
	</tr>
	<!-- FOP List start -->
	<logic:equal name="lookupDefaultForm" property="userAuthorizedCC"
		value="TRUE">
		<logic:notEmpty name="lookupDefaultForm" property="fopList">
			<tr>
				<!--list header start-->
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="formTable">
					<tr class="subtable_header_bold">
						<th align="center">Credit Card Number</th>
					</tr>
				</table>
				</td>
				<!--list header end-->
			</tr>
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="1"
					class="formTable">
					<tr>
						<td>
						<div style="overflow-y: auto; height: 44px; width: 100%;">
						<!-- The row content start -->
						<table width="100%" border="0" id="scrollTable2" cellpadding="0"
							cellspacing="0">
							<logic:iterate id="list" property="fopList"
								name="lookupDefaultForm">
								<tr>
									<td align="center" valign="bottom"><bean:write name="list"
										property="pnrCreditCard" /></td>
								</tr>
							</logic:iterate>
						</table>
						</div>
						<!-- The row content end --></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</logic:notEmpty>
	</logic:equal>

	<!-- list start -->
	<logic:notEmpty name="lookupDefaultForm" property="pnrList">
	<tr>
		<td><table width="100%"><tr>
	<td align="left" >
	    <font color="red">DL PNR's from 03/09/2011 to current (prior to 03/09/2011 PNRPUL) &nbsp;&nbsp;&nbsp; NW PNR's Thru 01/30/2010</font>
	</td>
	<td align="right">
		<bean:write property="over1000Lines" name="lookupDefaultForm" filter="false"/>
	</td>
	<td align="right">
	    <a href="javascript:printData();"><img src="<%=request.getContextPath()%>/images/print.gif" border="0">Print PNR Data</a>
	</td>
	</tr></table></td>
	</tr>

		<tr>
			<!--list header start -->
			<td>
			 <bean:write property="pnrCount" name="lookupDefaultForm"/>&nbsp;rows returned.
			<table width="100%" border="0" cellpadding="1" cellspacing="1"
				class="formTable">
				<tr class="subtable_header_bold">
					<th width="70" align="left" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrLoctrNum">
						<bean:message key="pnr.default.header.field.pnrNumber" />
					</html:link></th>
					<th width="100" align="center" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrCrtnDate">
						<bean:message key="pnr.default.header.field.pnrCreationDate" />
					</html:link></th>
					<th width="100" align="center" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrTravelDate">
						<bean:message key="pnr.default.header.field.travelDate" />
					</html:link></th>
					<th width="70" align="center" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrMkAlCode">
						<bean:message key="pnr.default.header.field.airline" />
					</html:link></th>
					<th width="70" align="center" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrFltNum">
						<bean:message key="pnr.default.header.field.flightNumber" />
					</html:link></th>
					<th width="70" align="center" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrSegOrigApCode">
						<bean:message key="pnr.default.header.field.origin" />
					</html:link></th>
					<th width="70" align="center" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrSegDestApCode">
						<bean:message key="pnr.default.header.field.destination" />
					</html:link></th>
					<th width="280" align="center" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrPsngrNme">
						<bean:message key="pnr.default.header.field.passenger" />
					</html:link></th>
					<th width="70" align="center" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrInvClCode">
						<bean:message key="pnr.default.header.field.classCode" />
					</html:link></th>
					<th width="70" align="center" valign="bottom"><html:link
						page="/PNRJ/LookupSortByDefault.do?sortBy=pnrSegStatusCode">
						<bean:message key="pnr.default.header.field.segmentStatus" />
					</html:link></th>
					<th width="15"></th>
				</tr>
			</table>
			</td>
			<!--list header end -->
		</tr>

		<tr>
			<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="formTable">
				<tr class="row1_left_nopoint">
					<td colspan="8">
					<div name="list"
						style="overflow-y: auto; height: 200px; width: 940px;"><!-- The row content start -->
					<table width="940" border="0" id="scrollTable" cellpadding="0"
						cellspacing="0">
						<logic:iterate id="list" property="pnrList"
							name="lookupDefaultForm">
							<tr class="row1" style="cursor: pointer">
								<td width="58" align="left" valign="bottom"><bean:write
									name="list" property="pnrLoctrNum" /></td>
								<td width="79" align="center" valign="bottom"><bean:write
									name="list" property="pnrCrtnDate" /></td>
								<td width="78" align="center" valign="bottom"><bean:write
									name="list" property="pnrTravelDate" /></td>
								<td width="56" align="center" valign="bottom"><bean:write
									name="list" property="pnrMkAlCode" /></td>
								<td width="56" align="center" valign="bottom"><bean:write
									name="list" property="pnrFltNum" /></td>
								<td width="56" align="center" valign="bottom"><bean:write
									name="list" property="pnrSegOrigApCode" /></td>
								<td width="56" align="center" valign="bottom"><bean:write
									name="list" property="pnrSegDestApCode" /></td>
								<td width="215" align="left" valign="bottom"><bean:write
									name="list" property="pnrPsngrNme" /></td>
								<td width="56" align="center" valign="bottom"><bean:write
									name="list" property="pnrInvClCode" /></td>
								<td width="56" align="center" valign="bottom"><bean:write
									name="list" property="pnrSegStatusCode" /></td>

							</tr>
						</logic:iterate>
					</table>
					<script>paintMouseEvents('scrollTable');</script></div>
					<!--  The row content end --></td>
				</tr>
			</table>
			</td>
		</tr>
	</logic:notEmpty>
	<!-- list end -->

	<!--detail start -->
	<logic:notEmpty name="lookupDefaultForm" property="pnrTextList">
		<tr><td><table width="100%"><tr>
	
			<td align="left" >
			    <font color="red">DL PNR's from 03/09/2011 to current (prior to 03/09/2011 PNRPUL) &nbsp;&nbsp;&nbsp; NW PNR's Thru 01/30/2010</font>
			</td>
			<td align="right">
				<bean:write property="over1000Lines" name="lookupDefaultForm"  filter="false"/>
			</td>
			<td align="right"><a href="javascript:printData();"><img
				src="<%=request.getContextPath()%>/images/print.gif" border="0">Print
			PNR Detail</a> <logic:equal name="lookupDefaultForm"
				property="showRedisplay" value="true">
		    &nbsp;<html:image page="/images/redisplay_list_btn.gif" border="0"
					style="cursor:hand;" onclick="javascript:history.go(-1);" />
			</logic:equal></td></tr></table></td>
		</tr>
		<tr>
			<!--list header start-->
			<td>
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="formTable">
				<tr class="subtable_header_bold">
					<th width="100%" align="center" valign="bottom"><bean:message
						key="pnr.detail.header" /></th>
					<th width="22"></th>
				</tr>
			</table>
			</td>
			<!--list header end-->
		</tr>

		
		<tr>	 
			 <td> 
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="formTable">
				<tr class="row1_left_nopoint">
					<td colspan="8"><!-- <div class="memos" style="overflow-y:auto; height:124px; width:867px;" >-->
					<div class="memos"><!-- The row content start -->
									 											
				 	<table width="100%" border="0" cellpadding="0" cellspacing="0">
				 		
						<logic:iterate id="list" property="pnrTextList"
							name="lookupDefaultForm">
							<tr align="left" >
								<td valign="top" ><small class="pnr"> <pre><bean:write	name="list" /> </pre></small></td>
							</tr>
						</logic:iterate>
					</table>   
					</div>
					<!-- The row content end --></td>
				</tr>
			</table>
			</td>
		</tr>
	</logic:notEmpty>
	<!-- detail end -->

</table>

<!-- for scroll into view--> <logic:notEmpty name="lookupDefaultForm"
	property="pnrList">
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
				if ((pnr==selPnr)&&(pnrCrtnDate==selPnrCrtnDate)&&(passenger==selPassenger)&&(flight==selFlightNumber)){
					if(cnt>8){
						tr[cnt-2].scrollIntoView();
					}
					tr[cnt].style.backgroundColor = "#6495ED";
					break;
				}			
			}
		}	
		</script>
</logic:notEmpty></center>
</div>
</body>