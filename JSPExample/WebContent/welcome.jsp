<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><u><b>Scriptlet Tag</b></u></p><%
String name = request.getParameter("username"); 
out.print("Welcome " + name);
%>
<br/>
<br/>
<p><u><b>Expression Tag</b></u></p>
<%=  "Welcome " + request.getParameter("username")%>

</body>
</html>