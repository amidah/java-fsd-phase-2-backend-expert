package com.simplilearn.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDetail extends HttpServlet{

public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		
		res.setContentType("text/html");
		
		PrintWriter pw = res.getWriter();
		
		Cookie ck[] = req.getCookies();
		
		pw.print("Hello " + ck[0].getValue());
		
		pw.close();
		
		
	}

}
