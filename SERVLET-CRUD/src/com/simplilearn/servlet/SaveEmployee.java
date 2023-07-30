package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.Employee;

public class SaveEmployee extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String country = req.getParameter("country");

		Employee emp = null;
		if (name != null && password != null && !name.equals("") && !password.equals("")) {
			emp = new Employee();
			emp.setName(name);
			emp.setPassword(password);
			emp.setEmail(email);
			emp.setCountry(country);
		}

		int status = EmployeeDao.save(emp);
		
		if(status > 0) {
			pw.print("<br><br><b>Record Saved Successfully!<b><br><br>");
			req.getRequestDispatcher("index.html").include(req, res);
		}
		
		else {
			pw.print("<br><br><b>Sorry! unable to save the record!<b><br><br>");
		}

		pw.close();

	}

}
