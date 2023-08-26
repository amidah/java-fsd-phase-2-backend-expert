<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<u><b>Scriptlet Tag</b></u>
	</p>
	<%
		String name = request.getParameter("username");
		String search = request.getParameter("search");
		out.print("Welcome " + name);
		if (search != null  && !search.isEmpty()) {
			response.sendRedirect("https://www.google.com/search?q=" + search);
		}
	%>

	<br />
	<br />
	<p>
		<u><b>Expression Tag</b></u>
	</p>
	<%="Welcome " + request.getParameter("username")%>
	
	<br/>
	<br/>
	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String databaseName = config.getInitParameter("datasource");
	
	out.println("Database Details::");
	out.println("DB Username: " + username);
	out.println("DB Password: " + password);
	out.println("DB Name: " + databaseName);
	
	%>

</body>
</html>