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
<title>Bandhu's Bank</title>
</head>
<body>

<h1 class="d-flex justify-content-center mt-4">Welcome to Home Page for Banking Application!!!!!</h1>
<div class="d-flex justify-content-center">
<a href="fc?type=login" class="mt-4 ml-1"> <button class="btn btn-success"> Login  </button> </a>
<a href="fc?type=signup" class="mt-4 ml-5"> <button class="btn btn-success"> SignUp  </button> </a>
</div>
</body>
</html>