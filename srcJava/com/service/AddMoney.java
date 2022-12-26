package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.signup_cust.Transactions_User;
import com.signup_cust.UpdateMoney_Cust;
import com.signup_details.SignUpDetails_bean;

@WebServlet(description = "To deposit in bank account", urlPatterns = { "/addMoney" })
public class AddMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddMoney() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		out = response.getWriter();
		UpdateMoney_Cust mon = new UpdateMoney_Cust();
		Transactions_User tr = new Transactions_User();
		HttpSession session = request.getSession();
		SignUpDetails_bean user;
		user = (SignUpDetails_bean)session.getAttribute("user");
		int amount = Integer.parseInt( request.getParameter("amount"));
		
		
		int updatedBalance = user.getDeposit() + amount;
		try {
		boolean res = mon.updateBalance(updatedBalance, user.getAccNo());
		int result = tr.addTrans(user.getAccNo(), amount);
		
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

}
