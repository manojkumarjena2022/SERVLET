package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.bean.Student;
@WebServlet("/studenturl")
public class StudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Student student=new Student();
		student.setName("manoj");
		student.setClass_name("10th");
		student.setPercentage(73.0f);
		// Store the Java Bean in the ServletContext
		getServletContext().setAttribute("studentData", student);
		//get writer
		PrintWriter pw=res.getWriter();
		pw.println("Student data set");
		pw.println("<a href='getStudent'>Get Student Details</a>");
		pw.close();
	}
}
