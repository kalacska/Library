<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="books" scope="session" class="java.util.Vector" />

<%@page import="org.pmmik.pojo.Book"%>
<%@page import="java.util.Vector"%>

<html>
<head>
<meta charset="ISO-8859-2">
<title>List of all books</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body bgcolor="#C6EAFF">
	<%!private String generateTable(Vector<Book> books) {
		StringBuffer buffer = new StringBuffer();
		for (Book book : books) {
			buffer.append("<tr>"); //$NON-NLS-1$
			buffer.append("<td align='center'><b>"); //$NON-NLS-1$
			buffer.append(book.getAuthor());
			buffer.append("</b></td>"); //$NON-NLS-1$
			buffer.append("<td align='center'><b>"); //$NON-NLS-1$
			buffer.append(book.getTitle());
			buffer.append("</b></td>"); //$NON-NLS-1$
			buffer.append("<td align='center'>"); //$NON-NLS-1$
			buffer.append(book.getIsbn());
			buffer.append("</td>"); //$NON-NLS-1$
			buffer.append("<td align='center'>"); //$NON-NLS-1$
			buffer.append(book.isLoanable());
			buffer.append("</td>"); //$NON-NLS-1$
			buffer.append("<td align='center'>"); //$NON-NLS-1$
			buffer.append(book.getAmount());
			buffer.append("</td>"); //$NON-NLS-1$
			buffer.append("</tr>"); //$NON-NLS-1$
		}
		return buffer.toString();
	}%>

	<form method="get" action="BookListerServlet"
		accept-charset="ISO-8859-2">

		<h1 align="center">Books</h1>
		<table cellSpacing=0 cellPadding=0 width="80%" align="center"
			bgcolor="#EDF2F4">
			<thead>
				<tr>
					<th align="center"><span
						style="font-weight: bold; font-size: 20px;">Author</span></th>
					<th align="center"><span
						style="font-weight: bold; font-size: 20px;">Title</span></th>
					<th align="center"><span
						style="font-weight: bold; font-size: 20px;">ISBN</span></th>
					<th align="center"><span
						style="font-weight: bold; font-size: 20px;">Loanable</span></th>
					<th align="center"><span
						style="font-weight: bold; font-size: 20px;">Amount</span></th>
				</tr>
			</thead>
			<tbody>
				<%=generateTable(books)%>
			</tbody>
		</table>
	</form>

	<form action="XMLServlet" method="post">
		<p align="center">
			<span><b>E-mail: </b></span><input type="text" name="email" required />
			<input type="submit" name="submit" value="Make XML Database" />
		</p>
	</form>

	<p align='center'>
		<a href='index.jsp'>Return Home</a>
	</p>

</body>
</html>