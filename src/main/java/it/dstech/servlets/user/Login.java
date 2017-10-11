package it.dstech.servlets.user;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.dao.HibernateDao;
import it.dstech.model.User;
import it.dstech.service.UserService;
import it.dstech.service.UserServiceImpl;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(Login.class.getName());

	UserService userService = new UserServiceImpl();

	@Override
	public void init() throws ServletException {
		HibernateDao.getSession();
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			User user = userService.getUserByUsernameAndPassword(username, password);
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
			logger.severe(e.getMessage());
			response.sendRedirect("login?error=true");
		}
	}

}
