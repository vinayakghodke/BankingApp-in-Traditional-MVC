package com.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.signup_cust.AddCustomer_DAO;
import com.signup_details.SignUpDetails_bean;


@WebServlet("/insertdata")
public class SignUpService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignUpService() {}
    
    AddCustomer_DAO add;
    

	public void init(ServletConfig config) throws ServletException {
		add = new AddCustomer_DAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SignUpDetails_bean signup = new SignUpDetails_bean();
		
		signup.setUserName(request.getParameter("userName"));
		signup.setUserAge(Integer.parseInt(request.getParameter("userAge")));
		signup.setUserPass(request.getParameter("userPass"));
		signup.setMobNo(request.getParameter("mobNo"));
		signup.setUserMail(request.getParameter("userMail"));
		signup.setDeposit(Integer.parseInt(request.getParameter("deposit")));
		
		try {
			int res = add.insertData(signup);
			if(res>0) { 
				request.setAttribute("user", signup);
				RequestDispatcher rd = request.getRequestDispatcher("./accNo");
				rd.forward(request, response);
				// response.sendRedirect("./pages/user_page.jsp");
			}
			else {
				response.sendRedirect("/pages/signup_data.jsp?type=0");
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	/*	request.getAttribute("user");
		SignUpDetails_bean user = (SignUpDetails_bean) request.getAttribute("user");
		user.getUserName();
		 HttpSession session = request.getSession();
		signup = (SignUpDetails_bean)session.getAttribute("signup");
		try {
			int res = add.insertData(signup);
			if(res>0) { 
				response.sendRedirect("./pages/user_page.jsp");
			}
			else {
				response.sendRedirect("/pages/signup_data.jsp?type=0");
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	} */

}
}
