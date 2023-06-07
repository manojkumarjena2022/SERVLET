package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineEligibilityCheckServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //set MIME content type
		resp.setContentType("text/html");
		//get request parameter values
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String sage=req.getParameter("age");
		int iage=Integer.parseInt(sage);
		//write business logic and output content
		PrintWriter pw=resp.getWriter();
		if(iage<18)
			pw.println("<h1 style='color:red;text-align:center;'>Mr./Mrs./Miss. "+name+", You are not eligible for corrona vaccine</h1>");
		else
			pw.println("<h1 style='color:green;text-align:center;'>Mr./Mrs./Miss. "+name+", You are eligible for corrona vaccine</h1>");
		//add home hyperlink
		pw.println("<a href='corona_vaccine.html'>Home</a>");
		//close stream
		pw.close();
	}
}
