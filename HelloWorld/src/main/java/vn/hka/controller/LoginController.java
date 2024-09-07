package vn.hka.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = -3354736672882940445L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String site = new String("views/login.jsp");

		RequestDispatcher rd = request.getRequestDispatcher(site);

		rd.include(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String pass = req.getParameter("psw");

		req.setAttribute("Username", name);
		req.setAttribute("Password", pass);

		RequestDispatcher rd = req.getRequestDispatcher("views/home.jsp");

		rd.forward(req, resp);
	}
}