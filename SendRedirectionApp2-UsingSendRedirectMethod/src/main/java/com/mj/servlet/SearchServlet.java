package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//get form input
		String query=req.getParameter("query");
		String engine=req.getParameter("engine");
		String url="";
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+query;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+query;
		else
			url="https://in.search.yahoo.com/search?p="+query;
		//perform sendRedirection
		System.out.println("Before send sendRedirect()");
		pw.println("Hiii");
		resp.sendRedirect(url);
		System.out.println("After send sendRedirect()");
		pw.println("Hello");
		//close stream
		pw.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
