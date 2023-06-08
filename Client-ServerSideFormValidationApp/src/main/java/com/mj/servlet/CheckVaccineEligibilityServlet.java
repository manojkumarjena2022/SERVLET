package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckVaccineEligibilityServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get Writer
		PrintWriter pw=resp.getWriter();
		//set MIME(Multipurpose Internet Mail Extensions) type
		resp.setContentType("text/html");
		//get form input data
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String tage=req.getParameter("age");
		String vflag=req.getParameter("vflag");
		int age=0;
		//write server side validation for input form data
		if(vflag.equalsIgnoreCase("no"))
		{
			System.out.println("Checking server side validation");
			List<String> errList=new ArrayList<String>();
			if(name.equalsIgnoreCase("") || name==null || name.length()==0)
				errList.add("Name is required field");
			if(address.equalsIgnoreCase("")|| address==null || address.length()==0) {
				errList.add("Address id required field");
			}
			else if(address.length()<10) {
				errList.add("Address must have minimum 10 characters");
			}
			if(tage.equalsIgnoreCase("") || tage==null || tage.length()==0) {
				errList.add("Age is required field");
			}
			else {
				try {
					age=Integer.parseInt(tage);
					if(age<0 || age>125)
					{
						errList.add("Age must be in range between 1 to 125");
					}
				} catch (NumberFormatException e) {
					errList.add("Age must be numeric value");
				}
			}
			//check validation error list and return to browser
			if (errList.size()>0) {
				pw.println("<ul style='color:red;'>");
				for (String errMessage : errList) {
					pw.println("<li>"+errMessage+"</li>");
				}
				pw.println("<ul>");
				//add home hyperlink
				pw.println("<br><a href='corona_vaccine.html'>Home</a>");
				//close stream
				pw.close();
				//return to browser or caller
				return;
			}
		}
		else
		{
			age=Integer.parseInt(tage);
		}
		//write business logic or response logic
		if (age<18) {
			pw.println("<h1 style='color:red;'>Mr./Ms./Mss. "+name+", you are not eligible for vaccine.");
		}
		else {
			pw.println("<h1 style='color:green;'>Mr./Ms./Mss. "+name+", you are not eligible for vaccine.Make it happen.");
		}
		//add home hyperlink
		pw.println("<br><a href='corona_vaccine.html'>Home</a>");
		//close stream
		pw.close();
	}
}
