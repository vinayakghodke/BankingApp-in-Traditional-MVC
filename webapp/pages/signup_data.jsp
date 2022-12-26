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
<title>User Sign Up</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-canche, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
<%
if(request.getParameter("type").equals("0"))
	out.println("<h5 style='color:red '> Sign Up failed!! Please try again later or user might already present.... </h5>");
%>

<h1 class="d-flex justify-content-center"> Welcome to SignUp Page!!!!!!!</h1>

<div class="container d-flex justify-content-center mt-4 w-100">

<form action="insertdata" method="get"  >

<div class="form-group">
<input type="text" name = "userName" placeholder="Enter User Name" required/>  
</div>

<div class="form-group">
<input type="number" name = "userAge" placeholder="Enter Age" required/> 
</div>

<div class="form-group">
<input type="text" name = "mobNo" placeholder="Enter Mobile Number" required/> 
</div>
 
<div class="form-group">
<input type="email" name = "userMail" placeholder="Enter Email" required/> 
</div>

<div class="form-group">
<input type="password" name = "userPass" placeholder="Enter Password" required/> 
</div>

<div class="form-group">
<input type="number" name = "deposit" placeholder="Enter Deposit Amount" value='' required/> 
</div>

<div class="form-group">
<input class="btn btn-success" type="submit" value="SignUp" /> 
<input class="btn btn-danger" type="reset" value="Reset" /> 
</div>

</form>
</div>
</body>
</html>