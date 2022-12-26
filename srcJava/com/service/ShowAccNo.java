package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.signup_cust.ShowAccNo_Cust;
import com.signup_details.SignUpDetails_bean;

@WebServlet("/accNo")
public class ShowAccNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public ShowAccNo() {}
	
	ShowAccNo_Cust details = new ShowAccNo_Cust();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		SignUpDetails_bean user = new SignUpDetails_bean();
		user = (SignUpDetails_bean) request.getAttribute("user");
		
		PrintWriter out = response.getWriter();
		
		// out.println(user.getUserName());
		
		String mail = user.getUserMail();
		String pass = user.getUserPass();
		try {
			int rs =  details.showDetails(mail, pass);
			
			if(rs != 0) {
				out.println("<h4> Hello " +user.getUserName() + "  Your Account Number is: " +rs + " Your Balance is  " +user.getDeposit());
				out.println("<br> <a href='./pages/home.jsp'> Click Here  for Home Page </a>");
			}
			else
				response.sendRedirect("./pages/home.jsp"); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("hellooo");
	}

}
