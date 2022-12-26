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
<meta charset="ISO-8859-1">
<title>Login data store</title>
</head>
<body>

<jsp:useBean id="user" class="com.signup_details.SignUpDetails_bean" scope="session">
<jsp:setProperty name="user" param="userMail" property="userMail"/>
<jsp:setProperty name="user" param="userPass" property="userPass"/>
</jsp:useBean>

<%
response.sendRedirect("../showtdata");
%>
</body>
</html>