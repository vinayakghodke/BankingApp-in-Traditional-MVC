<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
// String path1= "/insertdata";
%>
<!DOCTYPE html>
<html>
<head>
<base href = "<%=basePath%>">
<meta charset="ISO-8859-1">
<title>SignUp Data Store</title>
</head>
<body>
<jsp:useBean id="signup"  class="com.signup_details.SignUpDetails_bean" scope="session">
<jsp:setProperty name="signup" param="userName" property="userName"/>
<jsp:setProperty name="signup" param="userAge" property="userAge"/>
<jsp:setProperty name="signup" param="userPass" property="userPass"/>
<jsp:setProperty name="signup" param="userMail" property="userMail"/>
<jsp:setProperty name="signup" param="mobNo" property="mobNo"/>
<jsp:setProperty name="signup" param="deposit" property="deposit"/>
</jsp:useBean>

<%
RequestDispatcher rd ;
rd = request.getRequestDispatcher("../insertdata");
rd.forward(request, response);
request.setAttribute("user", signup);
// response.sendRedirect("http://localhost:8081/Banking_App/insertdata");
%>
</body>
</html>