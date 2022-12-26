<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.signup_details.SignUpDetails_bean" %>
     <%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
response.setHeader("Cache-Control", "no-canche, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<base href = "<%=basePath%>">
<meta charset="ISO-8859-1">
<title>Withdrawal</title>
</head>
<body>

<% 
SignUpDetails_bean user;
user = (SignUpDetails_bean)session.getAttribute("user");
%>
<h1 class="d-flex justify-content-center"> Withdraw Money...</h1>
<h4 > Your current balance is ${user.deposit }</h4>

<form action ="withdraw">

<div class="form-group row justify-content-center">
<input type="number" name = "amount" class="col-4" placeholder="Enter Amount you Want to Withdraw" required/>  
</div>

<div class="form-group justify-content-center row">
<button type="submit" class="btn btn-success "> Withdraw </button>  
</div>

</form>
</body>
</html>