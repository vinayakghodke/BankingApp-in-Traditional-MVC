package com.signup_cust;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection_utility.ConnectionUtilityForMySQL;

public class ShowAccNo_Cust {
	Connection con  = null;
	PreparedStatement prp;
	ResultSet rs;
	String qry = "select custid from bank where custmail= ? and custpass= ?";

	public int showDetails(String mail , String pass) throws SQLException {
		int res = 0;
		
		try {
		con = ConnectionUtilityForMySQL.getMySQLConnection();
		prp = con.prepareStatement(qry);
		prp.setString(1, mail);
		prp.setString(2, pass);
		rs = prp.executeQuery();
		
		if(rs.next()) {
			res = rs.getInt(1);
		}
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
