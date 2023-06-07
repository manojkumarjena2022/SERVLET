package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		//set MIME (Multipurpose Internet Mail Extensions)
		res.setContentType("text/html");
		//output content
		PrintWriter pw=res.getWriter();
		pw.println("<h1 style='color:red;'>Welcome to Servlet Welcome File</h1>");
		//close stream
		pw.close();
	}
}
