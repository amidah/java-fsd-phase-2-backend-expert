package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.model.Employee;

public class ViewEmployee extends HttpServlet {

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException, ServletException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();

		ServletContext ctx = getServletContext();
		Employee emp = (Employee) ctx.getAttribute("employee");
pw.print("<br><br>Employee details fetched successfully.<br><br>");
		pw.print("<table border='1' width='100%'>");
		pw.print("<tr><th>Name</th><th>Password</th><th>Email</th><th>Country</th></tr>");
		pw.print("<tr><td>" + emp.getName() + "</td><td>" + emp.getPassword() + "</td><td>" + emp.getEmail()
				+ "</td><td>" + emp.getCountry() + "</td></tr>");
		pw.print("</table>");
		
		httpServletRequest.getRequestDispatcher("index.html").include(httpServletRequest, httpServletResponse);
		

	}
}
