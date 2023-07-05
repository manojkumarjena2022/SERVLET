package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		//getv writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//read form1 /req2 cookies
		Cookie cookie[]=req.getCookies();
		String name=null,fname=null,address=null,ms=null;
		if (cookie!=null) {
			name=cookie[0].getValue();
			fname=cookie[1].getValue();
			address=cookie[2].getValue();
			ms=cookie[3].getValue();
		}
		//read form2 / request2 data
		String f2t1=req.getParameter("f2t1");
		String f2t2=req.getParameter("f2t2");
		//display form1/req1 and form2/req2 data
		pw.println("<h1>Form1/Req1 And Form2/Req2 Data</h1>");
		pw.println("<br><b>Form1 Data :</b>"+name+"-------"+fname+"---------"+address+"---------"+ms);
		pw.println("<br><b>Form2 Data :</b>"+f2t1+"-------"+f2t2);
		//add home hyperlink
		pw.println("<br><a href='index.html'>Home</a>");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
