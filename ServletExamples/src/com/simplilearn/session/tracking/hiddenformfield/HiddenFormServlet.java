package com.simplilearn.session.tracking.hiddenformfield;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenFormServlet extends HttpServlet{

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();
		
		String username = httpServletRequest.getParameter("name");
		
		pw.print("Welcome, " + username);
		
		pw.print("<br><br><form action='hiddenfielddetail' method='post'>");
		pw.print("<input type='hidden' name='uname' value='"+username+"'>");
		pw.print("<input type='submit' value='submit'>");
		pw.print("</form>");
		
		pw.close();
	}
}
