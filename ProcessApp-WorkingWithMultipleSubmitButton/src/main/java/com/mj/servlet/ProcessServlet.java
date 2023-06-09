package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get writer
		PrintWriter pw=resp.getWriter();
		//set response content type
		resp.setContentType("text/html");
		//get form input data
		int num1=0;
		int num2=0;
		String pval=req.getParameter("s1");
		if (!pval.equalsIgnoreCase("link1") && !pval.equalsIgnoreCase("link2")) {
			num1=Integer.parseInt(req.getParameter("t1"));
			num2=Integer.parseInt(req.getParameter("t2"));
		}
		//write business logic or response logic and response content
		if (pval.equalsIgnoreCase("add")) {
			pw.println("<h1>Sum of "+num1+" and "+num2+" is :"+(num1+num2)+"</h1>");
		}
		else if (pval.equalsIgnoreCase("sub")) {
			pw.println("<h1>Subtract of "+num1+" and "+num2+" is :"+(num1-num2)+"</h1>");
		}
		else if (pval.equalsIgnoreCase("mul")) {
			pw.println("<h1>Multiplication of "+num1+" and "+num2+" is :"+(num1*num2)+"</h1>");
		}
		else if (pval.equalsIgnoreCase("div")) {
			pw.println("<h1>Division of "+num1+" and "+num2+" is :"+(num1/num2)+"</h1>");
		}
		else if (pval.equalsIgnoreCase("link1")) {
			pw.println("<b>System properties are : "+System.getProperties()+"</b>");
		}
		else
		{
			pw.println("<h1>Date Time : "+LocalDateTime.now()+"</h1>");
		}
		//add home hyperlink
		pw.println("<a href='form.html'>Home</a>");
		//close stream
		pw.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
