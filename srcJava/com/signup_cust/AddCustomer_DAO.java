package com.signup_cust;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.connection_utility.ConnectionUtilityForMySQL;
import com.signup_details.SignUpDetails_bean;

public class AddCustomer_DAO {
Connection con  = null;
PreparedStatement prp;
ResultSet rs;
String qry = "insert into bank (custname, custage, custpass, mobno, custmail, balance) values (?,?,?,?,?,?)";
String dataQuery = "select * from bank where custmail = ? AND custpass = ?";

public int insertData(SignUpDetails_bean signup) throws SQLException {
	int result=0;
	try {
		con = ConnectionUtilityForMySQL.getMySQLConnection();
		prp = con.prepareStatement(qry);
		prp.setString(1, signup.getUserName());
		prp.setInt(2, signup.getUserAge());
		prp.setString(3, signup.getUserPass());
		prp.setString(4, signup.getMobNo());
		prp.setString(5, signup.getUserMail());
		prp.setInt(6, signup.getDeposit());
		
		result = prp.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		con.close();
	}
	return result;	
}

public SignUpDetails_bean getData(String id, String pass) throws SQLException {
	SignUpDetails_bean user = new SignUpDetails_bean() ;
	try {
	con = ConnectionUtilityForMySQL.getMySQLConnection();
	prp = con.prepareStatement(dataQuery);
	prp.setString(1, id);
	prp.setString(2, pass);
	
	rs = prp.executeQuery();
	if(rs.next()) {
		int id1 = rs.getInt(1);
		String name = rs.getString(2);
		int age = rs.getInt(3);
		String pas = rs.getString(4);
		String no = rs.getString(5);
		String mail = rs.getString(6);
		int bal = rs.getInt(7);
	  
		user.setAccNo(id1);
		user.setUserName(name);
		user.setUserAge(age);
		user.setUserPass(pas);
		user.setMobNo(no);
		user.setUserMail(mail);
		user.setDeposit(bal);
	}
}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		con.close();
	}
	
	return user;
}
}
