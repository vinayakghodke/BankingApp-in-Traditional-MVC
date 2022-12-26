package com.signup_cust;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection_utility.ConnectionUtilityForMySQL;

public class UpdateMoney_Cust {

	Connection con  = null;
	PreparedStatement prp;
	String qry = "update bank set balance = ? where custid = ?";

	public boolean updateBalance(int amount , int accNo) throws SQLException {
		boolean res = true;
		try {
		con = ConnectionUtilityForMySQL.getMySQLConnection();
		prp = con.prepareStatement(qry);
		prp.setInt(1, amount);
		prp.setInt(2, accNo);
		res = prp.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		con.close();
		}
		return res;	
	}
	
}
