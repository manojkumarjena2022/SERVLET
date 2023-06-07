package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		//set MIME (Multipurpose Internet Mail Extensions) Content type
		res.setContentType("text/html");
		//set response header for auto refresh
		res.setIntHeader("refresh", 10);
		//res.setHeader("refresh", "10");
		//request-response logic or business logic and write response
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		//get PrintWriter object
		PrintWriter pw=res.getWriter();
		pw.println("<h1 style='color:red;align:center;'>"+ldt.toString()+"</h1>");
		if(hour<12)
			pw.println("<h1 style='color:green;align:center;'>Good Morning</h1>");
		else if(hour<16)
			pw.println("<h1 style='color:orange;align:center;'>Good Afternoon</h1>");
		else if(hour<20)
			pw.println("<h1 style='color:pink;align:center;'>Good Evening</h1>");
		else
			pw.println("<h1 style='color:blue;align:center;'>Good Night</h1>");
		pw.println("<a href='http://localhost:8082/WishApp/page.html'>Home</a>");
		//close stream
		pw.close();

	}
}
