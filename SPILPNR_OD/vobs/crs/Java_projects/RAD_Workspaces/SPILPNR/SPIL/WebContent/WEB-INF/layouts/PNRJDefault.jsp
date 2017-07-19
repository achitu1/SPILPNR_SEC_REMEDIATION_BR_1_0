
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">

<!-- STYLE SHEETS -->
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="<html:rewrite page='<%=request.getContextPath()%>/theme/PRAMaster.css'/>" rel="stylesheet" type="text/css">

<html:html>
<body>
<!--Header-->
<tiles:importAttribute name="title" />
<tiles:insert attribute="header" >
	<tiles:put name="title" beanName="title" direct="true" />
</tiles:insert>

<!--Main Window Content-->
<br>
<tiles:insert attribute="mainwindow" />
<br>

<!--Footer-->
<tiles:insert attribute="footer" />

</body>
</html:html>
