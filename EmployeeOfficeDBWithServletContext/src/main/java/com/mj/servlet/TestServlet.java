package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//get access to servlet context object
		ServletContext sc=getServletContext();
		pw.println("<h1>Servlet Context Details</h1>");
		pw.println("<p>ServletContext Implemented Class Name : <b>"+sc.getClass()+"</b></p>");
		pw.println("<p>ServletContext Server Info : <b>"+sc.getServerInfo()+"</b></p>");
		pw.println("<a href='search.html'>Home</a>");
		pw.println("&nbsp;<a href='test_url'>Test</a>");
		//close stream
		pw.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
