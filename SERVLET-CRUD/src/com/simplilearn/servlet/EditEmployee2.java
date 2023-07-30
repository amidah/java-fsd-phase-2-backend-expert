package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.Employee;

public class EditEmployee2 extends HttpServlet{
	
	public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException, ServletException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();
		
		int id = Integer.parseInt(httpServletRequest.getParameter("id"));
		
		String name = httpServletRequest.getParameter("name");
		String password = httpServletRequest.getParameter("password");
		String email = httpServletRequest.getParameter("email");
		String country = httpServletRequest.getParameter("country");
		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setCountry(country);
		
		int status = EmployeeDao.update(emp);
		if(status > 0) {
			pw.print("Record updated successfully.");
			httpServletResponse.sendRedirect("viewemployee");
		}
		else {
			pw.print("Sorry!unable to update record.");
		}
        
        pw.close();
	}

}
