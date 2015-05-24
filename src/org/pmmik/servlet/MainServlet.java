package org.pmmik.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer=response.getWriter();
		String htmlMessage="<!DOCTYPE html>"+
						   "<html>"+
						   "<head>"+
						   "	<title>Library cím</title>"+
						   "</head>"+
						   "<body>"+
						   "<h1 align='center' style='color:red;'>Library Services</h1>"+
						   "	<table align='center' border='1'>"+
						   "	<tr>"+
						   "	<td>Name:</td><td><input type='text' name='name'/></td>"+
						   "	</tr>"+
						   "	<tr>"+
						   "	<td>Password:</td><td><input type='password' name='password'/></td>"+
						   "	</tr>"+
						   "	<tr>"+
						   "	<td colspan='2' align='center'><input type='submit' name='submit' value='Login'/></td>"+
						   "	</tr>"+
						   "	</table>"+
						   "<p align='center'><a href='\\signup.jsp'>Signup</p><br><br>"+
						   "<a href='\\listofbooks.jsp'>List of books</a>    <a href='\\search.jsp'>Search</a>"+
						   "</body>"+
						   "</html>";
		
		writer.print(htmlMessage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
