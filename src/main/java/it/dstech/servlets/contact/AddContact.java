package it.dstech.servlets.contact;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.dao.ContactDao;
import it.dstech.dao.ContactDaoImpl;
import it.dstech.model.Contact;
import it.dstech.model.User;

@WebServlet("/addContact")
public class AddContact extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(AddContact.class.getName());

	ContactDao contactDao = new ContactDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("addContact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Contact contact = new Contact();
			contact.setNome(request.getParameter("nome"));
			contact.setCognome(request.getParameter("cognome"));
			contact.setTel(request.getParameter("tel"));
			contact.setMail(request.getParameter("mail"));
			contact.setUser((User) request.getSession().getAttribute("user"));
			contactDao.saveContact(contact);
			response.sendRedirect("listContacts");
		} catch (Exception e) {
			logger.severe(e.getMessage());
			response.sendRedirect("addContact?error=true");
		}
	}

}
