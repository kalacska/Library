<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("loginerror.html");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-2">
<title>Insert title here</title>
</head>
<body bgcolor="#C6EAFF">
	<h1 align="center">Insert</h1>
	<form action="InsertServlet" method="post" accept-charset="ISO-8859-2">
		<table border="1" align="center" bgcolor='#9CCCE8'>
			<tr>
				<td><b>Author:</b></td>
				<td><input type="text" name="bookAuthor" required /></td>
			</tr>
			<tr>
				<td><b>Title:</b></td>
				<td><input type="text" name="bookTitle" required /></td>
			</tr>
			<tr>
				<td><b>ISBN:</b></td>
				<td><input type="text" name="bookIsbn" required /></td>
			</tr>
			<tr>
				<td><b>Loanable:</b></td>
				<td align="center"><select name="bookLoanable" required>
						<option value="yes">Yes</option>
						<option value="no">No</option>
				</select></td>
			</tr>
			<tr>
				<td><b>Amount:</b></td>
				<td><input type="text" name="bookAmount" required /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Insert" /></td>
			</tr>
		</table>
		<p align="center">
			<a href="admin.jsp">Return Home</a>
		</p>
	</form>
</body>
</html>