<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.signup_details.SignUpDetails_bean"%>
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
<title>User Page</title>
</head>
<body>
<% 
response.setHeader("Cache-Control", "no-canche, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

SignUpDetails_bean user;
user = (SignUpDetails_bean)session.getAttribute("user");

if(user== null){
	response.sendRedirect("./home.jsp");
}
%>
<h1 class="d-flex justify-content-center"> Hello ${user.userName } & Your Balance is ${user.deposit}  </h1>

<div class="d-flex justify-content-center mt-3">  <a href="./pages/add_money.jsp"> Add Money</a> </div>
<div class="d-flex justify-content-center mt-3"> <a href="./pages/withdraw.jsp"> Withdraw </a> </div>
<div class="d-flex justify-content-center mt-3"> <a href="./pages/transactions.jsp"> Show Transactions </a> </div>

<form action="logout" class="d-flex justify-content-center mt-4">
<button type="submit" class="btn btn-danger"> Log Out </button>
</form>
</body>
</html>