<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#C6EAFF">
	<form action="LoginServlet" method="post">
		<h1 align="center">Login</h1>
		<table align='center' border='1' bgcolor='#9CCCE8'>
			<tr>
				<td><b>Name:</b></td>
				<td><input type='text' name='name' required /></td>
			</tr>
			<tr>
				<td><b>Password:</b></td>
				<td><input type='password' name='password' required /></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit'
					name='submit' value='Login' /></td>
			</tr>
		</table>
	</form>
	<p align='center'>
		<a href='index.jsp'>Return Home
	</p>
</body>
</html>