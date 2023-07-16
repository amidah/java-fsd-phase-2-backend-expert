package com.simplilearn.servlet.config.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfiguration extends HttpServlet{
	
	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();
		
		ServletConfig config = getServletConfig();
		
		Enumeration<String> configs = config.getInitParameterNames();
		
		String s = "";
		while(configs.hasMoreElements()) {
			s = configs.nextElement();
			pw.println(s + " = ");
			pw.println(config.getInitParameter(s) + "<br>");
			
		}
		
		ServletContext context = getServletContext();
		Enumeration<String> contexts = context.getInitParameterNames();
		
		String st = "";
		while(contexts.hasMoreElements()) {
			st = contexts.nextElement();
			pw.println(st + " = ");
			pw.println(context.getInitParameter(st) + "<br>");
			
		}
		
		
	}

}
