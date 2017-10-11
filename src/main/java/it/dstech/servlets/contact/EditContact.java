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

@WebServlet("/editContact")
public class EditContact extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(EditContact.class.getName());

	private int id;

	ContactDao contactDao = new ContactDaoImpl();

	Contact contactById = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			id = Integer.parseInt(request.getParameter("id"));
			contactById = contactDao.getContactById(id);
			request.setAttribute("contact", contactById);
			request.getRequestDispatcher("editContact.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			logger.severe(e.getMessage());
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			contactById.setNome(request.getParameter("nome"));
			contactById.setCognome(request.getParameter("cognome"));
			contactById.setTel(request.getParameter("telefono"));
			contactById.setMail(request.getParameter("mail"));
			contactById.setUser((User) request.getSession().getAttribute("user"));
			contactDao.updateContact(contactById);
			response.sendRedirect("listContacts");
		} catch (Exception e) {
			logger.severe(e.getMessage());
			response.sendRedirect("editContact?id=" + id + "&error=true");
		}
	}

}
