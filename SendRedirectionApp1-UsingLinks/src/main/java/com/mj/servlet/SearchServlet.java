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
		if(engine.equalsIgnoreCase("google"))
			pw.println("<h1 style='color:green'><a href='https://www.google.com/search?q="+query+"'>Click</a></h1>");
		else if(engine.equalsIgnoreCase("bing"))
			pw.println("<h1 style='color:green'><a href='https://www.bing.com/search?q="+query+"'>Click</a></h1>");
		else
			pw.println("<h1 style='color:green'><a href='https://in.search.yahoo.com/search?p="+query+"'>Click</a></h1>");
		//close stream
		pw.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
