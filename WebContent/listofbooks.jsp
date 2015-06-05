<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="books" scope="session" class="java.util.Vector" />

<%@page import="org.pmmik.pojo.Book"%>
<%@page import="java.util.Vector"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of all books</title>
</head>
<body>
	<%!	private String generateTable(Vector<Book> books){
			StringBuffer buffer = new StringBuffer();
			for(Book book : books){
				buffer.append("<tr>"); //$NON-NLS-1$
				buffer.append("<td align='center'>"); //$NON-NLS-1$
				buffer.append(book.getAuthor());
				buffer.append("</td>"); //$NON-NLS-1$
				buffer.append("<td align='center'>"); //$NON-NLS-1$
				buffer.append(book.getTitle());
				buffer.append("</td>"); //$NON-NLS-1$
				buffer.append("<td align='center'>"); //$NON-NLS-1$
				buffer.append(book.getIsbn());
				buffer.append("</td>"); //$NON-NLS-1$
				buffer.append("<td align='center'>"); //$NON-NLS-1$
				buffer.append(book.isLoanable());
				buffer.append("</td>"); //$NON-NLS-1$
				buffer.append("<td align='center'>"); //$NON-NLS-1$
				buffer.append(book.getAmount());
				buffer.append("</td>"); //$NON-NLS-1$
				buffer.append("</tr>");	//$NON-NLS-1$
			}
		return buffer.toString();
		}
	%>

	<form method="get" action="BookListerServlet">
	
	<h1 align="center">Books</h1>
		<table cellSpacing=0 cellPadding=0 width="100%" border="1" align="center">
			<thead>
				<tr>
					<td align="center" style="background-color:#D1D1D1;"><span style="font-weight:bold; font-size:20px;">Author</span></td>
					<td align="center" style="background-color:#D1D1D1;"><span style="font-weight:bold; font-size:20px;">Title</span></td> 			
					<td align="center" style="background-color:#D1D1D1;"><span style="font-weight:bold; font-size:20px;">ISBN</span></td> 		
					<td align="center" style="background-color:#D1D1D1;"><span style="font-weight:bold; font-size:20px;">Loanable</span></td> 
					<td align="center" style="background-color:#D1D1D1;"><span style="font-weight:bold; font-size:20px;">Amount</span></td> 						
				</tr>
			</thead>
			<tbody>
							<%=generateTable(books) %>
			</tbody>
		</table>
	</form>

</body>
</html>