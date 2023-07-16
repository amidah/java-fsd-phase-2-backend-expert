package com.simplilearn.servlet.attributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAttribute2 extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException  
	{
		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();
		
		ServletContext context = getServletContext();
		String companyName = (String)context.getAttribute("CompanyName");
		
		pw.println("Welcome " + companyName + " to the Servlet Attribute 2");
		
		pw.close();
	}  
	
}
