<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("admin") == null) //$NON-NLS-1$
	{
		response.sendRedirect("loginerror.html"); //$NON-NLS-1$
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Library Services Admin Interface</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div id="box">
		<div id="header">
			<h1 align="center">Library Services</h1>
		</div>
		<div id="menu" align="center">
			<div id="link">
				<a href='BookListerServlet'>List of books</a>
			</div>
			<div id="link">
				<a href='search.jsp'>Search</a>
			</div>
			<div id="link">
				<a href='insert.jsp'>Add new book</a>
			</div>
		</div>
		<div id="container">
			<br>
			<h2 align="center">Welcome in Administrator interface!</h2>
			<p align="center">Library Services v1.0 &reg;&trade;</p>
			<p align="center">
				<a href="index.jsp">Log out</a>
			</p>
		</div>
	</div>
</body>
</html>