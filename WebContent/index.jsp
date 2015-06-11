<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% session.removeAttribute("admin"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Library Services</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div id="box">
		<div id="header">
			<h1 align="center">Library Services</h1>
		</div>
		<div id="menu" align="center">
			<div id="link"><a href='BookListerServlet'>List of books</a></div><div id="link"><a href='search.jsp'>Search</a></div><div id="link"><a href='login.jsp'>Login</a></div>
		</div>
		<div id="container">
			<br>
			<p align="Justify">This is a great library and this project is our Java a gyakorlatban examination work.</p>
		</div>
	</div>
</body>
</html>
