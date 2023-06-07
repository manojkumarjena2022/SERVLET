package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set content type
		resp.setContentType("text/html");
		//read form data
		int country_index=Integer.parseInt(req.getParameter("country"));
		//persistence logic
		String country[]= {"India","Pakistan","USA","China"};
		String capitals[]={"New Dehli","Islambad","Washington","Beijing"};
		//get writer
		PrintWriter pw=resp.getWriter();
		//write output
		pw.println("<h1>Capital Name of Country :"+country[country_index]+" is :"+capitals[country_index]+"</h1>");
		//add home hyperlink
		pw.println("<a href='page.html'>Home</a>");
		//close stream
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
