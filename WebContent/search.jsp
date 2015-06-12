<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body bgcolor="#C6EAFF">
	<h1 align="center">Search</h1>
	
	<form action="SearchServlet" name="searchForm" method="post">
		<p align="center"><input type="text" name="searchData"/></p>
		<p align="center"><input type="radio" name="rBtn" value="rbtnAuthor" /> 
			by author<input type="radio" name="rBtn" value="rbtnTitle" /> 
			by title<input type="radio" name="rBtn" checked="checked" value="rbtnNamePlusTitle" /> by author & title</p>
		<p align="center"><input type="submit" name="submit" value="Search"></p>
	</form>
	<p align='center'><a href='index.jsp'>Return Home</p>
</body>
</html>