package com.simplilearn.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String name = req.getParameter("user");
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		pw.print("Welcome " + name + " !!!");
		
	}

}
