<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-display.tld" prefix="display" %>
<%java.lang.String contextPath = request.getContextPath();%>
<!-- list start -->
<table width="100%"><tr><td width="70%">
	<font color="red">DL SPILs from 03/09/2011 through current (Cancel SPILs from 09/23/2012) &nbsp;&nbsp;&nbsp; NW SPILs Thru 01/30/2010</font>
	</td><td>
<div id="scrollListArea" class="printstart">				
	<div style="width:100%;text-align:right;padding:2px;" id="printButton">
 	 <img src="<%=contextPath%>/images/excel.gif" border="0" style="cursor:hand;" onclick="downloadSubmit();"> Download to Excel &nbsp;&nbsp;
	 <a href="javascript:printList();"><img src="<%=contextPath%>/images/print.gif" border="0">Print List</a>			
	</div> </td></tr></table>
	<div align=left><bean:write property="pnrCount" name="ssrInquiryForm"/>&nbsp;rows returned.</div>
	<div id="tableContainer" style="overflow-y:auto;height:227px; width:100%;border:1px solid #B1B4C5;" class="printstart">
		<display:table name="ssrInquiryForm.selectList" class="listTable" requestURI="/SPLJ/SsrInquiryList.do" id="scrollTable" cellpadding="0" cellspacing="1" style="text-align:center; width:100%; background-color: #FFFFFF;" 
			decorator="com.delta.SPLJ.decorators.SPLdecorator"> 
	    <display:setProperty name="locale.provider" value="org.displaytag.localization.I18nStrutsAdapter"/> 
	        <display:column property="airlineCode" 			sortable="true" 	titleKey="spl.default.header.field.airline" 				style="text-align:center;width:6%;padding-right:2px;"/>  
	        <display:column property="flightNumber" 		sortable="true" 	titleKey="spl.default.header.field.flightNumber" 			style="text-align:center;width:4%;padding-right:2px;"/>  
	   	  	<display:column property="legOrigApCode" 		sortable="true" 	titleKey="spl.default.header.field.boardPoint"		 		style="text-align:center;width:4%;padding-right:2px;"/> 
			<display:column property="localDepartureDate" 	sortable="true" 	titleKey="spl.default.header.field.localDepartureDate" 		style="text-align:center;width:10%;padding-right:2px;"/>  
		  	<display:column property="passengerName" 		sortable="true" 	titleKey="spl.default.header.field.passengerName"			style="text-align:left;width:17%;padding-right:2px;"/> 
	   	  	<display:column property="ssrCde" 				sortable="true" 	titleKey="spl.default.header.field.ssrCde"			 		style="text-align:center;width:3%;padding-right:2px;"/>  
		  	<display:column property="remarks1" 			sortable="true"  	titleKey="spl.default.header.field.remarks" 				style="text-align:left;width:16%;padding-right:2px;"/> 
	   	  	<display:column property="class1" 				sortable="true" 	titleKey="spl.default.header.field.class"			 		style="text-align:center;width:3%;padding-right:2px;"/>  
		  	<display:column property="seatAssignment" 		sortable="true"  	titleKey="spl.default.header.field.seatAssignment" 			style="text-align:center;width:5%;padding-right:2px;"/> 
		  	<display:column property="pnrLocator"  			sortable="true"  	titleKey="spl.default.header.field.pnrLocator" 				style="text-align:left;width:5%;padding-right:2px;"/> 
    	</display:table>
	<script>paintMouseEvents('scrollTable');</script>
	</div>



<!--for printing of scroll List-->
<div id="printListArea" style="width:100%;display:none;">	
	<display:table name="ssrInquiryForm.selectList" requestURI="/SPLJ/SsrInquiryRowSelected.do" cellpadding="0" cellspacing="1" style="text-align:center; width:100%; background-color: #FFFFFF;font-size: 6pt;" decorator="com.delta.SPLJ.decorators.SPLdecorator"> 
    <display:setProperty name="locale.provider" value="org.displaytag.localization.I18nStrutsAdapter"/> 
	        <display:column property="airlineCode" 			sortable="true" 	titleKey="spl.default.header.field.airline" 				style="text-align:center;width:6%;padding-right:2px;"/>  
	        <display:column property="flightNumber" 		sortable="true" 	titleKey="spl.default.header.field.flightNumber" 			style="text-align:center;width:4%;padding-right:2px;"/>  
	   	  	<display:column property="legOrigApCode" 		sortable="true" 	titleKey="spl.default.header.field.boardPoint"		 		style="text-align:center;width:4%;padding-right:2px;"/> 
			<display:column property="localDepartureDate" 	sortable="true" 	titleKey="spl.default.header.field.localDepartureDate" 		style="text-align:center;width:10%;padding-right:2px;"/>  
		  	<display:column property="passengerName" 		sortable="true" 	titleKey="spl.default.header.field.passengerName"			style="text-align:left;width:17%;padding-right:2px;"/> 
	   	  	<display:column property="ssrCde" 				sortable="true" 	titleKey="spl.default.header.field.ssrCde"			 		style="text-align:center;width:3%;padding-right:2px;"/>  
		  	<display:column property="remarks1" 			sortable="true"  	titleKey="spl.default.header.field.remarks" 				style="text-align:left;width:16%;padding-right:2px;"/> 
	   	  	<display:column property="class1" 				sortable="true" 	titleKey="spl.default.header.field.class"			 		style="text-align:center;width:3%;padding-right:2px;"/>  
		  	<display:column property="seatAssignment" 		sortable="true"  	titleKey="spl.default.header.field.seatAssignment" 			style="text-align:center;width:5%;padding-right:2px;"/> 
		  	<display:column property="pnrLocator"  			sortable="true"  	titleKey="spl.default.header.field.pnrLocator" 				style="text-align:left;width:5%;padding-right:2px;"/> 
   	</display:table>
<script>paintMouseEvents('scrollTable');</script>
</div>	

<logic:notEqual property="selPassenger" value="" name="ssrInquiryForm">
<script>
scroll();
</script>
</logic:notEqual>
