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

@WebServlet("/deleteContact")
public class DeleteContact extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(DeleteContact.class.getName());

	ContactDao contactDao = new ContactDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			contactDao.deleteContact(contactDao.getContactById(id));
			response.sendRedirect("listContacts");
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
	}

}
