package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/comp_url")
public class FormComponentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get writer
		PrintWriter pw=resp.getWriter();
		//set response content type
		resp.setContentType("text/html");
		//get for data
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String address=req.getParameter("paddress");
		String gender=req.getParameter("gender");
		String maritalStatus=req.getParameter("maritalStatus");
		maritalStatus=(maritalStatus==null)?"Single":maritalStatus;
		String qualification=req.getParameter("qualification");
		String language[]=req.getParameterValues("language");
		if(language==null)
			language=new String[] {"no language selected"};
		String hobbies[]=req.getParameterValues("hobbies");
		if(hobbies==null)
			hobbies=new String[] {"no hobby selected"};
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String mob=req.getParameter("mob");
		String wob=req.getParameter("wob");
		int fav_no=Integer.parseInt(req.getParameter("fav_no"));
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String color=req.getParameter("color");
		double income=Double.parseDouble(req.getParameter("income"));
		String fb_url=req.getParameter("fb_url");
		String favSearch=req.getParameter("favSearch");
		if(gender.equalsIgnoreCase("Male"))
		{
			if(age<5)
			{
				pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a baby boy.</h1>");
			}
			else if(age<13)
			{
				pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a small boy.</h1>");
			}
			else if(age<19)
			{
				pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a teenage boy.</h1>");
			}
			else if(age<35)
			{
				pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a young boy.</h1>");
			}
			else if(age<50)
			{
				pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a middle age man.</h1>");
			}
			else
			{
				pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a budda.</h1>");
			}
		}
		else
		{
			if(age<5)
			{
				pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a baby girl.</h1>");
			}
			else if(age<13)
			{
				pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a small girl.</h1>");
			}
			else if(age<19)
			{
				pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a teenage girl.</h1>");
			}
			else if(age<35)
			{
				if(maritalStatus.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a young married girl.</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a young girl.</h1>");
			}
			else if(age<50)
			{
				if(maritalStatus.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a middle age married woman.</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are a middle age woman.</h1>");
			}
			else
			{
				if(maritalStatus.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are an married old woman.</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center;'>Mr. "+name+" you are an old woman.</h1>");
			}
		}
		//write b.logic or response logic
		pw.println("<br><br>Form Data<br><br>");
		pw.println("<br><b>Name: <b>"+name+"<br>");
		pw.println("<br><b>Age: <b>"+age+"<br>");
		pw.println("<br><b>Address: <b>"+address+"<br>");
		pw.println("<br><b>Gender: <b>"+gender+"<br>");
		pw.println("<br><b>Marital Status: <b>"+maritalStatus+"<br>");
		pw.println("<br><b>Qualification: <b>"+qualification+"<br>");
		pw.println("<br><b>Languages: <b>"+Arrays.toString(language)+"<br>");
		pw.println("<br><b>Hobbies: <b>"+Arrays.toString(hobbies)+"<br>");
		pw.println("<br><b>DOB: <b>"+dob+"<br>");
		pw.println("<br><b>TOB: <b>"+tob+"<br>");
		pw.println("<br><b>MOB: <b>"+mob+"<br>");
		pw.println("<br><b>WOB: <b>"+wob+"<br>");
		pw.println("<br><b>Fav No: <b>"+fav_no+"<br>");
		pw.println("<br><b>Phone: <b>"+phone+"<br>");
		pw.println("<br><b>Email: <b>"+email+"<br>");
		pw.println("<br><b>Color: <b>"+color+"<br>");
		pw.println("<br><b>Income: <b>"+income+"<br>");
		pw.println("<br><b>Fav URL: <b>"+fb_url+"<br>");
		pw.println("<br><b>Fav Search: <b>"+favSearch+"<br>");
		//add home hyper link
		pw.println("<a href='form_components.html'>Home</a>");
		//close stream
		pw.close();

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
