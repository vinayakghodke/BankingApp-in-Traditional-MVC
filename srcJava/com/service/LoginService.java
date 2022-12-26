package com.service;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.signup_cust.AddCustomer_DAO;
import com.signup_details.SignUpDetails_bean;

@WebServlet("/showdata")
public class LoginService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public LoginService() {}
    
	AddCustomer_DAO log;
	public void init(ServletConfig config) throws ServletException {
	log = new AddCustomer_DAO();
	}
    
    SignUpDetails_bean user;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userMail");
		String pass = request.getParameter("userPass");
		try {
			user = log.getData(id, pass);
			
			if(user.getUserName()== null) {
				response.sendRedirect("./pages/login_data.jsp?type=0");
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("./pages/logged_userpage.jsp");
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
