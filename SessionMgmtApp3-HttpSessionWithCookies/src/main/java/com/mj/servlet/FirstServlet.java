package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		//create/access session object for current request
		HttpSession ses=req.getSession(true);
		//OR HttpSession ses=req.getSession();
		//keep form1 / req1 data in session object as session attribute values
		ses.setAttribute("name", name);
		ses.setAttribute("fname", father_name);
		ses.setAttribute("address", address);
		ses.setAttribute("ms", marital_status);

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
		//print session id
		pw.println("SessionId::"+ses.getId());
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
