<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.simplilearn.dao.UserDao,com.simplilearn.bean.User,java.util.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VIEW USERS</title>
</head>
<body>
	<h1>USERS LIST</h1>

	<%
		List<User> list = UserDao.getAllUsers();
		request.setAttribute("list", list);
	%>

	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Country</th>
			
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getName()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getGender()}</td>
				<td>${u.getCountry()}</td>
				
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="adduserform.jsp">Add New User</a>



</body>
</html>