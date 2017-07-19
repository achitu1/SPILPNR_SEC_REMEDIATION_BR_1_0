<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ page 

language="java"

contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"

%>



<script type="text/javascript">

	function goLogOut(){

		tmp = confirm("You are about to log out of this application. \nProceed?");

		if (tmp){

			if (document.logout == null){
			
				/// defect #3 code change begins
				open(location, '_self').close();
				/// defect #3 code change ends

			    var logoutForm = document.createElement("<FORM METHOD='post' ACTION='ibm_security_logout' NAME='logout'></FORM>");

			    document.body.insertBefore(logoutForm);



				document.logout.submit();

				window.close();

			}

		}

	}

   

</script>





<table border="0">

		<tr>

			<td>	

				<html:link href="http://www.prap7.nwa.com/SPLJWEB" target="blank">SPIL</html:link>&nbsp;|

			</td>		

			<td>	

				<html:link href="http://iviewer.delta-air.com/iviewer/iv" target="blank">Imaging</html:link>&nbsp;|

				

			</td>

			<td>	

				

				<html:link href="http://www.delta.com/planning_reservations/plan_flight/aircraft_types_layout/index.jsp" target="blank">Seat Maps</html:link>&nbsp;|

			</td>

	        <td>

    	        <a href="<%=request.getContextPath()%>/PNRJ/redirectApp.do" onclick="goLogOut();" style="cursor:hand;">Logout</a>

        	</td>

		</tr>

</table>





