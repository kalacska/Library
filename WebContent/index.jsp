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
			<p align="Justify">"Until then I had thought each book spoke of the things, human or divine, that lie outside books. 
			Now I realized that not infrequently books speak of books: it is as if they spoke among themselves. 
			In the light of this reflection, the library seemed all the more disturbing to me. 
			It was then the place of a long, centuries-old murmuring, an imperceptible dialogue between one parchment and another, 
			a living thing, a receptacle of powers not to be ruled by a human mind, a treasure of secrets emanated by many minds, 
			surviving the death of those who had produced them or had been their conveyors." <br>
			- Umberto Eco, <i>The Name of the Rose</i></p>
			<p><h3>Welcome!</h3></p>
			<p align="Justify">This is a page of an imaginary library. You can check the list of all books available, as well as search for a specific author and/or title.
			In case you know the proper username and password for the admin interface, you could also have the opportunity to add or delete any books.</p>
			<p>God bless you and have a fabulous day!</p>
		</div>
	</div>
</body>
</html>
