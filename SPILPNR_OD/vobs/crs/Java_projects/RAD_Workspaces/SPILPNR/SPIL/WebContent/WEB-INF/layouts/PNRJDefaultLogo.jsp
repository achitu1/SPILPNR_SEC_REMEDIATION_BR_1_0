
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">

<!-- STYLE SHEETS -->
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="<html:rewrite page='<%=request.getContextPath()%>/theme/PRAMaster.css'/>" rel="stylesheet" type="text/css">
<LINK href="<html:rewrite page='<%=request.getContextPath()%>/theme/PRAMaster2.css'/>" rel="stylesheet" type="text/css">
<html:html>
<body>
<!--Header-->
<tiles:insert attribute="header" >
</tiles:insert>
<!--Main Window Content-->
<br>
<center>
<tiles:insert attribute="mainwindow" />
</center>
<br>

<!--Footer-->
<tiles:insert attribute="footer" />
</body>
</html:html>
