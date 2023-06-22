package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletComp3 extends HttpServlet {
	static {
		System.out.println("Static block : ServletComp3 Class loaded.");
	}
	public ServletComp3() {
		System.out.println("ServletComp3 class instatiated");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("ServletComp3 class init method : Initialization");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get writer
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//write response
		pw.println("<h1>Welcome to Servlet Comp3</h1>");
	}
}
