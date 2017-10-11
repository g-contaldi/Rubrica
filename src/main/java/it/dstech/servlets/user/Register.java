package it.dstech.servlets.user;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.dao.UserDao;
import it.dstech.dao.UserDaoImpl;
import it.dstech.model.User;

@WebServlet("/register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(Register.class.getName());

	UserDao userDao = new UserDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			userDao.saveUser(user);
			response.sendRedirect("login");
		} catch (Exception e) {
			logger.severe(e.getMessage());
			response.sendRedirect("register?error=true");
		}
	}

}
