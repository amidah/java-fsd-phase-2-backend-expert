package com.simplilearn.session.tracking.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServletHttpSession extends HttpServlet {

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException, ServletException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();
		
		httpServletRequest.getRequestDispatcher("link.html").include(httpServletRequest, httpServletResponse);

		HttpSession session = httpServletRequest.getSession();
		session.invalidate();
		
		pw.print("<br><br>you are successfully logged out!");
		
	}
}
