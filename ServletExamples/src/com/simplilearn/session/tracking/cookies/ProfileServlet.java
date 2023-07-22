package com.simplilearn.session.tracking.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException, ServletException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();
		
		httpServletRequest.getRequestDispatcher("link.html").include(httpServletRequest, httpServletResponse);

		Cookie ck[] = httpServletRequest.getCookies();
		if(ck != null) {
			String username = ck[0].getValue();
			
			if(!username.equals("") || username != null) {
				pw.print("<br><br>Welcome to Profile, " + username);
			}	
			
		}
		else {
			pw.print("<br><br>Please login first...<br><br>");
			httpServletRequest.getRequestDispatcher("login.html").include(httpServletRequest, httpServletResponse);  
		}
		
		pw.close();
		
	}
}
