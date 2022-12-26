package com.signup_cust;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection_utility.ConnectionUtilityForMySQL;

public class Transactions_User {

	Connection con;
	String qry = "insert into transactions values (?,?)";
	PreparedStatement prp;
	int res;	
	
	public int addTrans(int accNo, int amount) throws SQLException {
		
		con = ConnectionUtilityForMySQL.getMySQLConnection();
		 try {
			prp = con.prepareStatement(qry);
			prp.setInt(1, accNo);
			prp.setInt(1, amount);
			res = prp.executeUpdate();
		} 
		 catch (Exception e) {
			e.printStackTrace();
		}
		 finally {
			 con.close();
		 }
		return res;
	}
	
}
