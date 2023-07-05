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
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//create cookies
		Cookie ck1=new Cookie("odisha", "Bhubaneswar");
		Cookie ck2=new Cookie("tamilnadu","Chennai");
		Cookie ck3=new Cookie("maharastra","Mumbai");
		Cookie ck4=new Cookie("karnatak","Bangalore");
		ck1.setMaxAge(2*60);
		ck2.setMaxAge(1*60);
		//add cookies to response
		resp.addCookie(ck1);//InMemory Cookie
		resp.addCookie(ck2);//InMemory Cookie
		resp.addCookie(ck3);//Persistence Cookie
		resp.addCookie(ck4);//Persistence Cookie
		//write response for browser
		pw.println("<h1 style='color:green'>Cookies added successfully</h1>");
		//close stream
		pw.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
