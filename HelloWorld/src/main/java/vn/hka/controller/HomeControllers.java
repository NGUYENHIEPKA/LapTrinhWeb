package vn.hka.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns= {"/hello","/xin-chao"})
public class HomeControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HomeControllers() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse
    		resp) throws ServletException, IOException {
    		resp.setContentType("text/html");
    		PrintWriter printW = resp.getWriter();
    		printW.println("<p>HelloWorld</p>");
    		printW.close();
    		}
    


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
