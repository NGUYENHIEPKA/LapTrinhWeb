package vn.HiepKa.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.HiepKa.services.impl.UserService;
@WebServlet(urlPatterns = { "/forgotpassword" })
public class ForgotPassController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserService service = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String newPassword = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		String email = req.getParameter("email");
		
		String alertMsg = "";
		
		// Gọi service để kiểm tra và đặt lại mật khẩu
		if (service.resetPassword(email, newPassword, confirmPassword)) {
			req.setAttribute("alert", "Đặt lại mật khẩu thành công!");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		} else {
			alertMsg = "Mật khẩu xác nhận không khớp!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
		}
	}
}
