package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//read cookies
		Cookie cookies[]=req.getCookies();
		if (cookies!=null) {
			//print cookies
			pw.println("<table><th>Cookie Name</th><th>Cookie Value</th>");
			for (Cookie cookie : cookies) {
				pw.println("<tr><td>"+cookie.getName()+"<td>"+cookie.getValue()+"</tr>");
			}
		}
		else
		{
			pw.println("<h1>No Cookies present</h1>");
		}
		//close stream
		pw.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
