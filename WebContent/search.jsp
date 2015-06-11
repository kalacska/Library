<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#C6EAFF">
	<h1 align="center">Search</h1>
	
	<form action="SearchServlet" name="searchForm" method="post">
		<table border="1" align="center" bgcolor="#EDF2F4">
			<tr>
				<td><b>By Author</b> <input type="radio" name="rBtn" value="rbtnAuthor" /><br><b>By Title</b> <input type="radio" name="rBtn" value="rbtnTitle" /><br><b>By Author+Title</b> <input type="radio" name="rBtn" checked="checked" value="rbtnNamePlusTitle" /></td>
				<td align="left"><b>Search text:</b> <br> <input type="text" name="searchData" /></td>
			</tr>
		    <tr>
				<td colspan="3" align="center"><input type="submit" name="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	<p align='center'><a href='index.jsp'>Return Home</p>
</body>
</html>