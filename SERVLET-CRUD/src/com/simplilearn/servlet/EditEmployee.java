package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.Employee;

public class EditEmployee extends HttpServlet{
	
	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException, ServletException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();
		
		pw.println("<h1>Update Employee</h1>");
		
		int id = Integer.parseInt(httpServletRequest.getParameter("id"));
		
		Employee emp = EmployeeDao.getEmployeeById(id);
		
		pw.print("<form action='editservlet2' method='post'>");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+emp.getId()+"'/></td></tr>");
		pw.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+emp.getName()+"'/></td></tr>");
		pw.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+emp.getPassword()+"'/></td></tr>");
		pw.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+emp.getEmail()+"'/></td></tr>");
		pw.print("<tr><td>Country:</td><td>");
		pw.print("<select name='country' style='width:150px'>");  
        pw.print("<option>India</option>");  
        pw.print("<option>USA</option>");  
        pw.print("<option>UK</option>");  
        pw.print("<option>Other</option>");  
        pw.print("</select>");  
        pw.print("</td></tr>");  
        pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        pw.print("</table>");  
        pw.print("</form>");  
        
        pw.close();
	}

}
