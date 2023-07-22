package com.simplilearn.session.tracking.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException, ServletException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();
		
		httpServletRequest.getRequestDispatcher("link.html").include(httpServletRequest, httpServletResponse);

		Cookie ck = new Cookie("uname", "");
		ck.setMaxAge(0);
		httpServletResponse.addCookie(ck);
		
		pw.print("<br><br>you are successfully logged out!");
		
	}
}
