package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.Employee;

public class ViewEmployee extends HttpServlet {

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException, ServletException {

		httpServletResponse.setContentType("text/html");

		PrintWriter pw = httpServletResponse.getWriter();

		List<Employee> empList = EmployeeDao.getAllEmployees();

		pw.print("<a href='index.html'>Add New Employee</a><br><br>");
		
		pw.print("<br><br>Employee details fetched successfully.<br><br>");
		pw.print("<table border='1' width='100%'>");
		pw.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit Details</th></tr>");

		for (Employee emp : empList) {

			pw.print("<tr><td>" + emp.getId() + "</td><td>" + emp.getName() + "</td><td>" + emp.getPassword() + "</td><td>" + emp.getEmail()
					+ "</td><td>" + emp.getCountry() + "</td><td><a href='editservlet?id="+emp.getId()+"'>Edit</a></td></tr>");
		}
		pw.print("</table>");

		pw.close();

	}
}
