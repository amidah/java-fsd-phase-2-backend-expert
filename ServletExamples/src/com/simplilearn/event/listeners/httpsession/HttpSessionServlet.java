package com.simplilearn.event.listeners.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();
		
		String name = req.getParameter("user");
		
		pw.print("<br><br>Welcome, " + name);
		
		HttpSession session = req.getSession();
		session.setAttribute("uname", name);
		
		ServletContext ctx = getServletContext();
		
		int totalUsers = (int) ctx.getAttribute("totalusers");
		int currentUsers = (int) ctx.getAttribute("currentusers");
		
		pw.print("<br><br>Total Users: " + totalUsers);
		pw.print("<br><br>Current Users: " + currentUsers);
		
		pw.print("<br><br><a href='httpsessionlistenerlogout'>LOGOUT</a>");
		
		
	}

}
