<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<base href = "<%=basePath%>">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%
if(request.getParameter("type").equals("0"))
	out.println("<h4 style='color:red '> Login failed due to bad creditionals!! Please try again.... </h4>");
%>

<h1 class="d-flex justify-content-center"> Welcome to Login Page!!!!!!!</h1>
<div class="container d-flex justify-content-center">

<!-- <form action= "./pages/login_store.jsp" method="get">  -->
 <form action= "showdata" method="get"> 

<div class="form-group">
<input type="email" name = "userMail" placeholder="Enter User Mail" required/>  
</div>

<div class="form-group">
<input type="password" name = "userPass" placeholder="Enter User Password" required/>  
</div>

<div class="form-group">
<button type="submit" class="btn btn-success"> Login </button>  
</div>

</form>
</div>
</body>
</html>