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
import javax.servlet.http.HttpSession;

import org.pmmik.dao.Globals;
import org.pmmik.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		this.factory = Persistence.createEntityManagerFactory(Globals.PERSISTENCE_UNIT_NAME);
		this.em = this.factory.createEntityManager();
		this.userDao = new UserDao(this.em);
		
		if (this.userDao.login(request.getParameter("name"), request.getParameter("password"))) { //$NON-NLS-1$ //$NON-NLS-2$
			HttpSession session=request.getSession();
			session.setAttribute("admin", true);
			response.sendRedirect("admin.jsp"); //$NON-NLS-1$
		}
		else {
			response.sendRedirect("loginerror.html"); //$NON-NLS-1$
		}
	}

}
