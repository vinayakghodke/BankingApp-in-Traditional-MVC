package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.signup_cust.Transactions_User;
import com.signup_details.SignUpDetails_bean;

@WebServlet("/trans")
public class Transactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Transactions() {}
    
   Transactions_User tra = new Transactions_User();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = response.getWriter();
    	out.println("hellooo");
    	SignUpDetails_bean user;
    	HttpSession session = request.getSession();
    	user = (SignUpDetails_bean) session.getAttribute("user");
    /*	try {
			ResultSet rs = tra.getTrans(user.getAccNo());
			if(rs != null) {
				
				while(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getInt(2));
				}
				request.setAttribute("trans", rs);
				//response.sendRedirect("./pages/transactions.jsp");
			}
			else {
				out.println("Error Occured...");
			}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
	}	*/

}
}
