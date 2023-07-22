package com.simplilearn.session.tracking.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCookie extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		
		res.setContentType("text/html");
		
		PrintWriter pw = res.getWriter();
		
		String username = req.getParameter("user");
		pw.print(username);
		
		Cookie ck = new Cookie("uname", username);
		res.addCookie(ck);
		
		pw.print("<form action='cookiedtl' method='post'>");
		pw.print("<input type='submit' value='go'>");
		pw.print("</form>");
		
		pw.close();
		
		
	}

}
