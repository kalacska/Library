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
				buffer.append("<td>"); //$NON-NLS-1$
				buffer.append(book.getAuthor());
				buffer.append("</td>"); //$NON-NLS-1$
				buffer.append("<td>"); //$NON-NLS-1$
				buffer.append(book.getTitle());
				buffer.append("</td>"); //$NON-NLS-1$
				buffer.append("</tr>");	//$NON-NLS-1$	
						
			}
		return buffer.toString();
		}
	%>

	<form method="get" action="BookListerServlet">
		<table cellSpacing=0 cellPadding=0 width="100%">
			<thead>
				<tr>
					<td noWrap align=left>Author</td>
				</tr>
				<tr>
					<td noWrap align=left>Title</td> 					
				</tr>
			</thead>
			<tbody>

				<tr><td>
					<table>
					<%=generateTable(books) %>
					 </table>
					 </td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>