package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.signup_details.SignUpDetails_bean;


 
@WebServlet("/logout")
public class LogOutService extends HttpServlet { 
	private static final long serialVersionUID = 1L;
  
    public LogOutService() {} 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		SignUpDetails_bean bean; 
		HttpSession session = request.getSession();
		if(session.getAttribute("signup") != null) {
		bean = (SignUpDetails_bean)session.getAttribute("signup");
		session.removeAttribute("signup");
		 session.invalidate();
		 response.sendRedirect("./pages/home.jsp?type=1");
		}
		else if(session.getAttribute("user") != null) {
			bean = (SignUpDetails_bean)session.getAttribute("user");
			session.removeAttribute("user");
			 session.invalidate();
			 response.sendRedirect("./pages/home.jsp?type=1");
		}
		 
	}

}
