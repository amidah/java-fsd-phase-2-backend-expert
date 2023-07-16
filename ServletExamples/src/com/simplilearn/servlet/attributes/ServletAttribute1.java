package com.simplilearn.servlet.attributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAttribute1 extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException  
	{
		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();
		
		ServletContext context = getServletContext();
		context.setAttribute("CompanyName", "AMAZON");
		
		pw.println("Welcome to the Servlet Attribute 1");
		pw.println("<br/><a href='servletattribute2'>visit to another servlet</a>");
		
		pw.close();
	}  

}
