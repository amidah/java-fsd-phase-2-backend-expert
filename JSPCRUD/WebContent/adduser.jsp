<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.simplilearn.dao.UserDao"%>
    
<jsp:useBean id="u" class="com.simplilearn.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD USER JSP</title>
</head>
<body>


<%
int i = UserDao.save(u);
if(i > 0){
	response.sendRedirect("adduser-success.jsp");
}
%>

</body>
</html>