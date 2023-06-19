package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTest extends HttpServlet {
	static {
		System.out.println("LifeCycleTest static block : (servlet loading)");
	}
	public LifeCycleTest() {
		System.out.println("LifeCycleTest 0-param constructor : (Servlet instatiation)");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LifeCycleTest init method : (Servlet Initialization)");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleTest service method : request processing logic");
		//get printer
		PrintWriter pw=resp.getWriter();
		//set response content type
		resp.setContentType("text/html");
		//write message to response using printwriter
		pw.println("LifeCycleTest responsed");
		//close stream
		pw.close();
	}
	@Override
	public void destroy() {
		System.out.println("LifeCycleTest destry method : servlet uninitialization");
	}
}
