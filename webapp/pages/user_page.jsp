<%@page import="com.signup_details.SignUpDetails_bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

SignUpDetails_bean signup = (SignUpDetails_bean)request.getAttribute("user");
   // SignUpDetails_bean signup;
  //  signup = (SignUpDetails_bean)session.getAttribute("signup");

if(signup == null){
	response.sendRedirect("./home.jsp");
}

%>
<h1 class="d-flex justify-content-center"> Hello ${signup.userName }  </h1> 

<div>  <a href="./pages/add_money.jsp"> Add Money</a> </div>
<div> <a href="withd"> Withdraw </a> </div>

<form action="logout">
<button type="submit" class="btn btn-danger"> Log Out </button>
</form>

</body>
</html>