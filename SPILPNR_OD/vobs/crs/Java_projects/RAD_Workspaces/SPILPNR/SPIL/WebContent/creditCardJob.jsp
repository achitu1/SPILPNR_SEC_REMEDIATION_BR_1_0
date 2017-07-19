<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" language="JavaScript">
function submitForm(obj){
	
	if(obj == 'start'){
	
		document.forms[0].action="<%=request.getContextPath()%>/CreditCardEncryptorServlet?action=start";
		document.forms[0].submit();
	}
	
	if(obj=='stop'){
	
		document.forms[0].action="<%=request.getContextPath()%>/CreditCardEncryptorServlet?action=stop";
		document.forms[0].submit();
	}
}
</script>
</head>
<body>

<h1>Credit Card Encryption Job</h1>
<form method="POST">

<table border="1">
	<tbody>
		<tr>
			<td><label for="name">Click Submit Button to start the
			job </label></td>
			<td><input type="button" value="Start Job" onclick="submitForm('start')"/></td>
		</tr>
		<tr>
			<td><label for="name">Click Stop Button to stop the job
			</label></td>
			<td><input type="button" value="Stop Job" onclick="submitForm('stop')"/></td>
		</tr>
	</tbody>
</table>
</form>


</body>
</html>