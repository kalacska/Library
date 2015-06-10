package org.pmmik.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pmmik.dao.UserDao;
import org.pmmik.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PERSISTENCE_UNIT_NAME = User.TABLE_NAME;
	private EntityManager em;
	private EntityManagerFactory factory;
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em = this.factory.createEntityManager();
		this.userDao = new UserDao(this.em);
		
		if (this.userDao.login(request.getParameter("name"), request.getParameter("password"))) { //$NON-NLS-1$ //$NON-NLS-2$
			response.sendRedirect("admin.html"); //$NON-NLS-1$
		}
		else {
			response.sendRedirect("loginerror.html"); //$NON-NLS-1$
		}
	}

}
