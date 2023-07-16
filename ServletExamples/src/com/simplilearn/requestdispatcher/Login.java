package com.simplilearn.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String name = req.getParameter("user");
		String password = req.getParameter("pass");
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		if(name.equals("admin") && password.equals("admin")) {
			RequestDispatcher rd = req.getRequestDispatcher("welcomeservlet");
			rd.forward(req, res);
		}
		else{
			pw.print("Username or Password Incorrect!!!");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);
		}
	}

}
