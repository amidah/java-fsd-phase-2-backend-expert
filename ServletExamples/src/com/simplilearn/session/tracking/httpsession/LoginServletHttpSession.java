package com.simplilearn.session.tracking.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServletHttpSession extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		req.getRequestDispatcher("link.html").include(req, res);

		String username = req.getParameter("name");
		String password = req.getParameter("password");

		if (password.equals("admin@1234")) {
			pw.print("<br><br>You are successfully logged in!");
			pw.print("<br><br>Welcome, " + username);

			HttpSession session = req.getSession();
			session.setAttribute("name", username);

		}

		else {
			pw.print("<br><br>sorry, your password is incorrect!");
			req.getRequestDispatcher("login.html").include(req, res);
		}

		pw.close();

	}

}
