<%@page import="com.connection_utility.ConnectionUtilityForMySQL"%>
<%@page import="com.signup_cust.Transactions_User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.signup_details.SignUpDetails_bean , java.sql.ResultSet, java.sql.Connection, java.sql.PreparedStatement" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href = "<%=basePath%>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
response.setHeader("Cache-Control", "no-canche, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
SignUpDetails_bean user;
session = request.getSession();
user = (SignUpDetails_bean) session.getAttribute("user");
%>

<h1> Hello ${user.userName} </h1>
<table>
<tr>
<th> Account No </th>
<th> Transactions </th>
</tr>

<%
	Connection con = null;
	String qry = "select * from transactions where acc_no = ?";
	PreparedStatement prp;
	ResultSet rs;
	int acc_no = user.getAccNo();
	try {
		con = ConnectionUtilityForMySQL.getMySQLConnection();
		prp = con.prepareStatement(qry);
		prp.setInt(1, acc_no);
		rs = prp.executeQuery();
		while(rs.next()) {
%>
<tr> 
<td><%= rs.getInt("acc_no") %> </td>
<td><%= rs.getInt("transaction") %> </td>
</tr>

<%
		}
	} 
	 catch (Exception e) {
		e.printStackTrace();
	}	%>
</table>
</body>
</html>