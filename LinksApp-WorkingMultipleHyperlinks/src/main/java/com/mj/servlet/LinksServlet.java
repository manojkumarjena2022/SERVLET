package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get writer
		PrintWriter pw=resp.getWriter();
		//set response content type
		resp.setContentType("text/html");
		//get additional request parameter value
		String pval=req.getParameter("p1");
		//get all available Locales
		Locale locale[]=Locale.getAvailableLocales();
		//Differentiate logic for hyperlinks
		if (pval.equalsIgnoreCase("link1")) {
			pw.println("<h1>All Languages Are :</h1>");
			for(Locale loc : locale)
			{
				pw.println(loc.getLanguage()+", ");
			}
		}
		else if (pval.equalsIgnoreCase("link2")) {
			pw.println("<h1>All Countries Are :</h1>");
			for(Locale loc : locale)
			{
				pw.println(loc.getDisplayCountry()+", ");
			}
		}
		else
		{
			pw.println("<h1> System Date And Time :"+LocalDateTime.now()+"</h1>");
		}
		//add home hyperlink
		pw.println("<a href='links.html'>Home</a>");
		//close stream
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
