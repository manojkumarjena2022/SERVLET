package com.mj.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DBServlet extends HttpServlet{
	static {
		System.out.println("DBServlet static block");
	}
	public DBServlet() {
		System.out.println("DBServlet 0-param constructor");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("DBServlet init method");
		//read init param values from ServletConfig object
		System.out.println("driver class name ::"+config.getInitParameter("driver_class"));
		System.out.println("jdbc url ::"+config.getInitParameter("jdbc_url"));
		System.out.println("db user name ::"+config.getInitParameter("uname"));
		System.out.println("db password ::"+config.getInitParameter("password"));
		//write jdbc code below
	}
	@Override
	public void destroy() {
		System.out.println("destroy method");
	}
}
