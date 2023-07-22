package com.simplilearn.session.tracking.urlrewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlRewriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();
		
		String name = httpServletRequest.getParameter("name");
		
		pw.print("Welcome, " + name);
		
		pw.print("<br><br><a href='userdetail?uname="+name+"'>User Detail</a>");
		
		pw.close();
	}

}
