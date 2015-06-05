package org.pmmik.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pmmik.dao.BookDao;
import org.pmmik.pojo.Book;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	private EntityManagerFactory factory;
	private BookDao dao;
	private static final String PERSISTENCE_UNIT_NAME = "books";
	private Book book;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em=factory.createEntityManager();
			dao=new BookDao(em);
			
			String author,title,isbn,lable;
			boolean loanable;
			int amount;
			
			author=request.getParameter("bookAuthor");
			title=request.getParameter("bookTitle");
			isbn=request.getParameter("bookIsbn");
			amount=Integer.valueOf(request.getParameter("bookAmount"));
			lable=request.getParameter("bookLoanable");
			
			if (lable.equals("no")) {
				loanable=false;
			}
			else{
				loanable=true;
			}
			
			book=new Book();
			book.setAuthor(author);
			book.setTitle(title);
			book.setIsbn(isbn);
			book.setLoanable(loanable);
			book.setAmount(amount);
			
			dao.create(book);
			
			PrintWriter writer=response.getWriter();
			
			String htmlMessage="<!DOCTYPE html>"+
					   "<html>"+
					   "<head>"+
					   "	<title>Insert</title>"+
					   "</head>"+
					   "<body>"+
					   "<p align='center'>Succesfull!</p>"+
					   "<p align='center'><a href='\\index.html'>Return Home</p><br><br>"+
					   "</body>"+
					   "</html>";
			writer.print(htmlMessage);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

}
