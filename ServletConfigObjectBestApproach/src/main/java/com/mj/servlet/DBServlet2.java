package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet2 extends HttpServlet{
	static {
		System.out.println("DBServlet2 static block");
	}
	public DBServlet2() {
		System.out.println("DBServlet2 0-param constructor");
	}
	@Override
	public void init() throws ServletException {
		ServletConfig config=getServletConfig();
		System.out.println("DBServlet2 init method");
		//read init param values from ServletConfig object
		System.out.println("driver class name ::"+config.getInitParameter("driver_class"));
		System.out.println("jdbc url ::"+config.getInitParameter("jdbc_url"));
		System.out.println("db user name ::"+config.getInitParameter("uname"));
		System.out.println("db password ::"+config.getInitParameter("password"));
		//write jdbc code below
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get writer
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get ServletConfig object
		ServletConfig config=getServletConfig();
		//write response
		pw.println("Servlet Name ::"+config.getServletName());
		//close stream
		pw.close();
	}
	@Override
	public void destroy() {
		System.out.println("destroy method");
	}
}
