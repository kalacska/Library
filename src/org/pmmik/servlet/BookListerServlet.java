package org.pmmik.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.pmmik.comparator.ComparatorClass;
//import org.eclipse.jetty.server.session.JDBCSessionManager.Session;
import org.pmmik.dao.BookDao;
import org.pmmik.dao.Globals;
import org.pmmik.pojo.Book;
import org.pmmik.xml.XMLCreator;

/**
 * Servlet implementation class BookListerServlet
 */
@WebServlet("/BookListerServlet")
public class BookListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static EntityManagerFactory factory;
	private EntityManager em;
	
	private BookDao bookDao;
	private String page;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	action(request, response);
	}

	private void action(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			request.setCharacterEncoding("ISO-8859-2");
			response.setContentType("ISO-8859-2");

			factory = Persistence.createEntityManagerFactory(Globals.PERSISTENCE_UNIT_NAME);
			this.em = factory.createEntityManager();

			this.bookDao = new BookDao(this.em);

			List<Book> books;
			try {
				books = this.bookDao.listAllBooks();
				ComparatorClass c=new ComparatorClass();
				books.sort(c);
				request.getSession().setAttribute("books", books); //$NON-NLS-1$

				if(request.getSession().getAttribute("admin")==null){
					 page = "/listofbooks.jsp"; //$NON-NLS-1$
				}
				else{
					 page="/adminlistofbooks.jsp"; //$NON-NLS-1$
				}
				

				RequestDispatcher disp = request.getRequestDispatcher(page);
				disp.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			this.em.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
