package fr.aoufi.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.aoufi.servlet.dao.UserDAO;
import fr.aoufi.servlet.dao.UserDAOImpl;
import fr.aoufi.servlet.model.User;

public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");

		if ((name == null || "".equals(name))
				|| (email == null || "".equals(email))
				|| (password == null || "".equals(password))
				|| (address == null || "".equals(address))) {
			String error = "Champs obligatoires manquants!";
			request.getSession().setAttribute("errorReg", error);
			response.sendRedirect("index.jsp#register");
		} else {
			User user = new User(name, email, password, address);

			UserDAO userDAO = new UserDAOImpl();

			int result = userDAO.createUser(user);
			if (result == 1) {
				request.getSession().removeAttribute("errorReg");
				response.sendRedirect("success.jsp");
			}else{
				request.getSession().setAttribute("errorReg", "Erreur interne du serveur, veuillez réessayer plus tard !");
				response.sendRedirect("index.jsp#register");
			}
		}
	}
}