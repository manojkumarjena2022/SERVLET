package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EligibilityCheckServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//gwt writer
		PrintWriter pw=resp.getWriter();
		//set MIME (Multipurpose Internet Mail Extensions) type
		resp.setContentType("text/html");
		//get request parameter values
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String age=req.getParameter("age");
		//write validation logic
		List<String> errorList=new ArrayList<String>();
		if (name.equalsIgnoreCase("") || name==null || name.length()==0) {
			errorList.add("Name is required");
		}
		if(address.equalsIgnoreCase("") || address==null || address.length()==0)
		{
			errorList.add("Address is required");
		}
		else if(address.length()<10)
		{
			errorList.add("Address must have min 10 characters");
		}
		int iage=0;
		if (age.equalsIgnoreCase("") || age==null || age.length()==0) {
			errorList.add("Age is required");
		}
		else
		{
			try {
				iage=Integer.parseInt(age);
				if(iage<0 || iage>125)
				{
					errorList.add("Age must be in the range 1 to 125");
				}
			}
			catch (NumberFormatException e) {
				errorList.add("Age must be a numeric value");
			}
		}
		if(errorList.size()>0)
		{
			pw.println("<ul style='color:red;'");
			for (String error : errorList) {
				pw.println("<li>"+error+"</li>");
			}
			pw.println("</ul>");
			return;
		}
		//write business logic or response processing logic
		if(iage<18)
		{
			pw.println("<h1 style='color:red;'>"+name+",you are not eligible for corona vaccine");
		}
		else
		{
			pw.println("<h1 style='color:green;'>"+name+",you are eligible for corona vaccine");
		}
		//add home hyperlink
		pw.println("<br><a href='corona_vaccine.html'>Home</a>");
		//close stream
		pw.close();

	}
}
