<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Insert</h1>
	<form action="InsertServlet" method="post">
	<table border="1" align="center">
		<tr>
			<td>Author:</td>
			<td><input type="text" name="bookAuthor" required/></td>
		</tr>
		<tr>
			<td>Title:</td>
			<td><input type="text" name="bookTitle" required/></td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="bookIsbn" required/></td>
		</tr>
		<tr>
			<td>Loanable:</td>
			<td align="center">
				<select name="bookLoanable" required>
					<option value="yes">Yes</option>
					<option value="no">No</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Amount:</td>
			<td><input type="text" name="bookAmount" required/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Insert"/></td>
		</tr>
	</table>
	</form>
</body>
</html>