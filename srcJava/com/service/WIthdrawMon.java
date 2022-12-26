package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.signup_cust.UpdateMoney_Cust;
import com.signup_details.SignUpDetails_bean;

@WebServlet("/withdraw")
public class WIthdrawMon extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public WIthdrawMon() {}

	UpdateMoney_Cust mon = new UpdateMoney_Cust();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("Helloo....");
		HttpSession session = request.getSession();
		SignUpDetails_bean user;
		user = (SignUpDetails_bean)session.getAttribute("user");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		if(user.getDeposit() > amount ) {
		int updatedBalance = user.getDeposit() - amount;
		try {
		boolean res = mon.updateBalance(updatedBalance, user.getAccNo());
		// out.println(res);
		if(res == false) {
			// out.println("SuccesFully Added money..");
			user.setDeposit(updatedBalance);
			response.sendRedirect("./pages/logged_userpage.jsp");
		}
		else
			out.println("Error Occured during Transaction... <br> Please Try again... Press back button...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		
		else {
				out.println("<h3> Seems like you have insufficient funds... Try Again... </h3>");
			}


	}

}
