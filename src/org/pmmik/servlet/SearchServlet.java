package org.pmmik.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	private EntityManagerFactory factory;
	private BookDao bDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		factory=Persistence.createEntityManagerFactory(Book.TABLE_NAME);
		em=factory.createEntityManager();
		bDao=new BookDao(em);
		List<Book> books=new ArrayList<>();
		PrintWriter writer=response.getWriter();
		
		String rBtnValue=request.getParameter("rBtn");
		String text=request.getParameter("searchData");
		
		if(rBtnValue.equals("rbtnAuthor")){
			books=bDao.searchByAuthor(text);
		}
		if(rBtnValue.equals("rbtnTitle")){
			books=bDao.searchByTitle(text);
		}
		if(rBtnValue.equals("rbtnNamePlusTitle")){
			 books=bDao.searchByAuthorAndTitle(text);
		}
		
		
		if(books.isEmpty()){
			String htmlMessage="<!DOCTYPE html>"+
					   "<html>"+
					   "<head>"+
					   "	<title>Result</title>"+
					   "</head>"+
					   "<body>"+
					   "<p align='center'>No result!</p>"+
					   rBtnValue+
					   "<p align='center'><a href='\\index.html'>Return Home</p><br><br>"+
					   "</body>"+
					   "</html>";
			writer.print(htmlMessage);
		}
		else{
			
			String htmlMessage="<!DOCTYPE html>"+
							   "<html>"+
							   "<head>"+
							   "	<title>Result</title>"+
							   "</head>"+
							   "<body>"+
							   "<h1 align='center' style='color:red;'>Search Result</h1>"+
							   "	<table align='center' border='1'>"+
							   "		<tr><td><b>Author</b></td><td><b>Title</b></td><td><b>ISBN</b></td><td><b>Loanable</b></td><td><b>Amount</b></td></tr>";
							   
				for (Book book : books) {
					htmlMessage+="<tr><td>"+book.getAuthor()+"</td><td>"+book.getTitle()+"</td><td>"+
				                 book.getIsbn()+"</td><td>"+book.isLoanable()+"</td><td>"+book.getAmount()+"</td>";
				}
			
							   htmlMessage+="	</table>"+
							   "<p align='center'><a href='\\index.html'>Return Home</p><br><br>"+
							   "</body>"+
							   "</html>";
			
			writer.print(htmlMessage);
		}
	}

}
