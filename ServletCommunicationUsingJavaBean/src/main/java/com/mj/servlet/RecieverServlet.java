package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.bean.Student;
@WebServlet("/getStudent")
public class RecieverServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Student student=(Student)getServletContext().getAttribute("studentData");
		PrintWriter pw=res.getWriter();
		if(student!=null)
		{
			pw.println("Name :"+student.getName()+", Class :"+student.getClass_name()+", Percentage :"+student.getPercentage());
		}
		else
		{
			pw.println("No student data found");
		}
		
		pw.close();
	}
}
