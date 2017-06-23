package it.dstech.servlets.user;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.dao.ServicesCrud;
import it.dstech.dao.UserDao;
import it.dstech.dao.UserDaoImpl;
import it.dstech.model.User;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(Login.class.getName());

	UserDao userDao = new UserDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServicesCrud.createEntityManager();
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			User user = userDao.getUserByUsernameAndPassword(username, password);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("logged", true);
				session.setAttribute("user", user);
				response.sendRedirect("listContacts");
				logger.info("logged user: " + user.getUsername());
			} else {
				response.sendRedirect("login?error=true");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login?error=true");
		}
	}

}
