<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><u>Scripting Elements:</u></h1>
<p>1. Scriptlet Tag</p>
<p>2. Expression Tag</p>
<p>3. Declaration Tag</p>

<h2><u>Scriptlet Tag</u></h2>
<% out.print("Welcome to scriptlet tag."); %>
	
<h2><u>Expression Tag</u></h2>
<%= "Welcome to expression tag." %>
Current Time: <%= java.util.Calendar.getInstance().getTime() %>

<br/>
<br/>

<form action="welcome.jsp">
	<input type="text" placeholder="Username" name="username">
	<input type="text" placeholder="Search" name="search">
	<input type="submit" value="Go">
</form>

<br/>

<h2><u>Declaration Tag</u></h2>
<%! 
public double divide(int d, int n){
	return d/n;
}

%>
<%= "Value of data after dividing by 2 is: " + divide(100, 2)%>

<br/>
<br/>

<form action="welcome">
	<input type="text" name="username" placeholder="username">
	<input type="text" name="password" placeholder="password">
	<input type="submit" value="submit">
</form>

</body>
</html>