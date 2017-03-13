package fr.aoufi.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.aoufi.servlet.dao.UserDAO;
import fr.aoufi.servlet.dao.UserDAOImpl;
import fr.aoufi.servlet.model.User;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String error;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setEmail(email); user.setPassword(password);
		
		HttpSession session = request.getSession();
		UserDAO userDAO = new UserDAOImpl();

		User userDB = userDAO.loginUser(user);

		if (userDB.getName() == null) {
			error = "Email ou mot de passe non-valide! Veuillez réessayer.";
			session.setAttribute("error", error);		
			request.getSession().setAttribute("errorLog", error);
			response.sendRedirect("index.jsp#login");
		} else {
			session.setAttribute("user", userDB.getName());
			session.removeAttribute("error");
			response.sendRedirect("welcome.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ("logout".equalsIgnoreCase(request.getParameter("param"))) {
			HttpSession session = request.getSession();
			if(session != null){
			session.invalidate();
			}
			response.sendRedirect("index.jsp");
		}
	}
}