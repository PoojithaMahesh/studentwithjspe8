<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HII from HTML</h1>
<%!String message="HIi"; %>
<%if(message!=null){%>
<%=message %>

<%}else{ %>

<%="HII FROM ELSE BLOCK BECOZ MSG IS NULL" %>
<%} %>
<%request%>
</body>
</html>