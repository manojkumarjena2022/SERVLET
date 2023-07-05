package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//getv writer
	PrintWriter pw=resp.getWriter();
	//set content type
	resp.setContentType("text/html");
	//get form inputs
	String name=req.getParameter("name");
	String father_name=req.getParameter("fname");
	String address=req.getParameter("address");
	String marital_status=req.getParameter("ms");
	//create cookies
	Cookie ck1=new Cookie("name",name);
	Cookie ck2=new Cookie("fname",father_name);
	Cookie ck3=new Cookie("address",address);
	Cookie ck4=new Cookie("marital_status",marital_status);
	//add cookies
	resp.addCookie(ck1);
	resp.addCookie(ck2);
	resp.addCookie(ck3);
	resp.addCookie(ck4);
	//generate form 2 based on marital status
	if (marital_status.equalsIgnoreCase("married")) {
		pw.println("<form action='secondurl' method='post'>");
		pw.println("<table><tr><td>Spouse Name :</td><td><input type='text' name='f2t1'></td></tr>");
		pw.println("<tr><td>No. Of kids :</td><td><input type='number' name='f2t2'></td></tr>");
		pw.println("<tr><td><input type='submit' value='Register'></td><td><input type='reset' value='Cancel'></td></tr></table>");
	}
	else {
		pw.println("<form action='secondurl' method='post'>");
		pw.println("<table><tr><td>Why do you want to marry ?</td><td><input type='text' name='f2t1'></td></tr>");
		pw.println("<tr><td>When do you want to marry ?</td><td><input type='text' name='f2t2'></td></tr>");
		pw.println("<tr><td><input type='submit' value='Register'></td><td><input type='reset' value='Cancel'></td></tr></table>");
	}
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
