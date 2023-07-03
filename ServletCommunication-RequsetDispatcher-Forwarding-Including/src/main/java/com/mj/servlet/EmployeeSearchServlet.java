package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {
	private static final String EMP_QUERY="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//include header content
		RequestDispatcher rd=req.getRequestDispatcher("/headurl");
		rd.include(req, resp);
		//get access to servlet config object
		ServletConfig sc=getServletConfig();
		//get servlet config param values
		String driverClass=sc.getInitParameter("dbDriverClass");
		String dbUrl=sc.getInitParameter("dburl");
		String dbUser=sc.getInitParameter("dbuser");
		String dbPassword=sc.getInitParameter("dbpassword");
		//get form input param value
		int empid=Integer.parseInt(req.getParameter("empno"));
		try {
			//load oracle jdbc driver
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle jdbc driver class not found");
		}
		try(Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
				PreparedStatement ps=con.prepareStatement(EMP_QUERY)) {
			if (ps!=null) {
				ps.setInt(1,empid);
				try(ResultSet rs=ps.executeQuery())
				{
					if (rs!=null) {
						if (rs.next()) {
							pw.println("<h1>Servlet Config Details</h1>");
							pw.println("<p>ServletConfig Implemented Class Name : <b>"+sc.getClass()+"</b></p>");
							pw.println("<p>ServletConfig Servlet Name : <b>"+sc.getServletName()+"</b></p>");
							pw.println("<h1>Employee Details</h1>");
							pw.println("<p>Employee ID :"+rs.getString(1)+"</p>");
							pw.println("<p>Employee Name :"+rs.getString(2)+" "+rs.getString(3)+"</p>");
							pw.println("<p>Employee Email :"+rs.getString(4)+"</p>");
							pw.println("<p>Employee DOJ :"+rs.getString(5)+"</p>");
							pw.println("<p>Employee Salary :"+rs.getString(6)+"</p>");
						}
						else
						{
							pw.println("<h1>No Employee Details Found</h1>");
						}
						
					}
					RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
					rd2.include(req, resp);
					//close stream
					pw.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			pw.println("<b>before rd.forward()</b>");
			System.out.println("Main servlet before rd.forward()");
			RequestDispatcher rd3=req.getRequestDispatcher("error_url");
			rd3.forward(req, resp);
			pw.println("<b>After rd.forward()</b>");
			System.out.println("Main servlet after rd.forward()");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
