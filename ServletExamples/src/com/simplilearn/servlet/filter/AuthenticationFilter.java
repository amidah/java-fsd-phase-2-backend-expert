package com.simplilearn.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sres, FilterChain fchain)
			throws IOException, ServletException {
		
		PrintWriter pw = sres.getWriter();
		
		String name = sreq.getParameter("user");
		
		System.out.println(name + " user entered in authentication filter...");
		
		String password = sreq.getParameter("pass");
		
		if(password.equals("admin")) {
			fchain.doFilter(sreq, sres); // here we are sending the req to the next resource in the chain
		}
		else {
			pw.print("<br><br>Incorrect Password Entered !!!<br><br>");
			sreq.getRequestDispatcher("index.html").include(sreq, sres);
		}
		
	}
	
	

}
