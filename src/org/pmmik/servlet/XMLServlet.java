package org.pmmik.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pmmik.email.Mail;
import org.pmmik.xml.XMLCreator;

/**
 * Servlet implementation class XMLServlet
 */
@WebServlet("/XMLServlet")
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter writer;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XMLServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Email email=new Email();

		if (request.getParameter("submit") != null) { //$NON-NLS-1$
			XMLCreator c = new XMLCreator();
			c.start();

			/*
			 * email.setTo(request.getParameter("email"));
			 * email.sendMail("message", "Message from Library",
			 * request.getParameter("email"));
			 */

			Mail mail = new Mail();
			mail.setTo(request.getParameter("email")); //$NON-NLS-1$
			mail.main();

			String htmlMessage = "<html><head></head><body bgcolor='#C6EAFF'><h1 align='center'>Successfull!</h1><p align='center'><a href='index.jsp'>Return Home</a></p></body></html>"; //$NON-NLS-1$
			this.writer = response.getWriter();
			this.writer.print(htmlMessage);
		}
	}

}
