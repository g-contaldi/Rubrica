package it.dstech.servlets.contact;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/listContacts")
public class ListContacts extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ListContacts.class.getName());

	ContactDao contactDao = new ContactDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Contact> listContactsByUser = contactDao
					.getListContactsByUser((User) request.getSession().getAttribute("user"));
			request.setAttribute("list", listContactsByUser);
			request.getRequestDispatcher("listContacts.jsp").forward(request, response);
		} catch (Exception e) {
			logger.warning(e.getMessage());
		}
	}

}
