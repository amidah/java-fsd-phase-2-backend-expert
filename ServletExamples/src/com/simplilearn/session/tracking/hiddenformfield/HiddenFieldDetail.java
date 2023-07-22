package com.simplilearn.session.tracking.hiddenformfield;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenFieldDetail extends HttpServlet{

	public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();
		
		String username = httpServletRequest.getParameter("uname");
		
		pw.print("Welcome to the Hidden Field Detail Servlet, " + username);

		
		pw.close();
	}
	
}
