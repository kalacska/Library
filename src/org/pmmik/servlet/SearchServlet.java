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
import org.pmmik.dao.Globals;
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
	private PrintWriter writer;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.factory=Persistence.createEntityManagerFactory(Globals.PERSISTENCE_UNIT_NAME);
		this.em=this.factory.createEntityManager();
		this.bDao=new BookDao(this.em);
		List<Book> books=new ArrayList<>();
		this.writer = response.getWriter();
		
		String rBtnValue=request.getParameter("rBtn"); //$NON-NLS-1$
		String text=request.getParameter("searchData"); //$NON-NLS-1$
		
		if(rBtnValue.equals("rbtnAuthor")){ //$NON-NLS-1$
			books=this.bDao.searchByAuthor(text);
		}
		if(rBtnValue.equals("rbtnTitle")){ //$NON-NLS-1$
			books=this.bDao.searchByTitle(text);
		}
		if(rBtnValue.equals("rbtnNamePlusTitle")){ //$NON-NLS-1$
			 books=this.bDao.searchByAuthorAndTitle(text);
		}
		
		String htmlMessage="<!DOCTYPE html>"+ //$NON-NLS-1$
					   "<html>"+ //$NON-NLS-1$
					   "<head>"+ //$NON-NLS-1$
					   "	<title>Search result</title>"+ //$NON-NLS-1$
					   "	<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">" + //$NON-NLS-1$
					   "</head>"+ //$NON-NLS-1$
					   "<body bgcolor='#C6EAFF'>"; //$NON-NLS-1$
		
		if(books.isEmpty()){
			htmlMessage += "<p align='center' style='font-weight:bold;'>No result!</p>"; //$NON-NLS-1$
		}
		else{
			
			htmlMessage +=
						"<h1 align='center'>Search Result</h1>"+ //$NON-NLS-1$
						"	<table align='center'"+ //$NON-NLS-1$
						"		<tr><th><b>Author</b></th><th><b>Title</b></th><th><b>ISBN</b></th><th><b>Loanable</b></th><th><b>Amount</b></th></tr>"; //$NON-NLS-1$
							   
				for (Book book : books) {
					htmlMessage+="<tr><td>"+book.getAuthor()+"</td><td>"+book.getTitle()+"</td><td>"+ //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				                 book.getIsbn()+"</td><td>"+book.isLoanable()+"</td><td>"+book.getAmount()+"</td>"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
			
			htmlMessage+="	</table>"; //$NON-NLS-1$
		}
		htmlMessage +=
					"<p align='center'><a href='\\search.jsp'>Back to Search</p>"+ //$NON-NLS-1$
					"<p align='center'><a href='\\index.jsp'>Return Home</p>"+ //$NON-NLS-1$
					"</body>"+ //$NON-NLS-1$
					"</html>"; //$NON-NLS-1$
		
		this.writer.print(htmlMessage);
	}

}
