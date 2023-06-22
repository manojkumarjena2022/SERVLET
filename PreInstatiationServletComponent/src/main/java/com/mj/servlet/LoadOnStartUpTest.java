package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadOnStartUpTest extends HttpServlet {
	static {
		System.out.println("Static block : Servlet Class loaded.");
	}
	public LoadOnStartUpTest() {
		System.out.println("Servlet class instatiated");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet class init method : Initialization");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get writer
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//write response
		pw.println("<h1>Welcome to Servlet</h1>");
	}
}
