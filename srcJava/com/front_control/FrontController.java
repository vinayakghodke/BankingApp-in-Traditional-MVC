package com.front_control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public FrontController() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		RequestDispatcher rd;
		if(request.getParameter("type").equals("signup")) {
			rd = request.getRequestDispatcher("/pages/signup_data.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("type").equals("login")) {
		rd = request.getRequestDispatcher("/pages/login_data.jsp");
		rd.forward(request, response);
		}
			
	}

}
