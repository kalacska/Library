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
import org.pmmik.dao.Globals;
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
	private Book book;
	private PrintWriter writer;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("ISO-8859-2"); //$NON-NLS-1$
			response.setContentType("ISO-8859-2"); //$NON-NLS-1$

			this.factory = Persistence
					.createEntityManagerFactory(Globals.PERSISTENCE_UNIT_NAME);
			this.em = this.factory.createEntityManager();
			this.dao = new BookDao(this.em);

			String author, title, isbn, lable;
			boolean loanable;
			int amount;

			author = request.getParameter("bookAuthor"); //$NON-NLS-1$
			title = request.getParameter("bookTitle"); //$NON-NLS-1$
			isbn = request.getParameter("bookIsbn"); //$NON-NLS-1$
			amount = Integer.valueOf(request.getParameter("bookAmount")); //$NON-NLS-1$
			lable = request.getParameter("bookLoanable"); //$NON-NLS-1$

			if (lable.equals("no")) { //$NON-NLS-1$
				loanable = false;
			} else {
				loanable = true;
			}

			this.book = new Book();
			this.book.setAuthor(author);
			this.book.setTitle(title);
			this.book.setIsbn(isbn);
			this.book.setLoanable(loanable);
			this.book.setAmount(amount);

			this.dao.create(this.book);

			this.writer = response.getWriter();

			String htmlMessage = "<!DOCTYPE html>" + //$NON-NLS-1$
					"<html>" //$NON-NLS-1$
					+ "<head>" //$NON-NLS-1$
					+ "	<title>Insert</title>" //$NON-NLS-1$
					+ "	<meta charset='UTF-8'>" //$NON-NLS-1$
					+ "</head>" //$NON-NLS-1$
					+ "<body bgcolor='#C6EAFF'>" //$NON-NLS-1$
					+ "<h1 align='center'>Succesfull!</h1>" //$NON-NLS-1$
					+ "<p align='center'><a href='\\insert.jsp'>Insert Other One</p>" //$NON-NLS-1$
					+ "<p align='center'><a href='\\admin.jsp'>Return Home</p><br><br>" //$NON-NLS-1$
					+ "</body>" + "</html>"; //$NON-NLS-1$ //$NON-NLS-2$
			this.writer.print(htmlMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
