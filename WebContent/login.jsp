<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
	<table align='center' border='1'>
		<tr>
			<td>Name:</td><td><input type='text' name='name'/></td>
		</tr>
		<tr>
			<td>Password:</td><td><input type='password' name='password'/></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><input type='submit' name='submit' value='Login'/></td>
		</tr>
	</table>
</form>
</body>
</html>