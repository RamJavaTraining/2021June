<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.june.servlets.modal.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello from JSP</h1>

<%! 
public int add(int a, int b){
	return a+b;
}
%>

<% 
  out.println("Hello Request Mr." + ((User)request.getAttribute("user")).getUserName());
out.println("Hello Request UserID Mr." + ((User)request.getAttribute("user")).getUserId());
  out.println("Hello Session Mr." + ((User)session.getAttribute("user")).getUserName());
  out.println("Hello Application Mr." + ((User)application.getAttribute("user")).getUserName());
  
%>

<jsp:useBean id="user" class="com.june.servlets.modal.User" scope="request" ></jsp:useBean>

<%= "Hello From Use Bean -" +user.getUserName() %>

</body>
</html>