package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1url")
public class ThreadSafeTest1 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//achieving thread safety by making all comp as local data to service()/ doXXX()
		final String EMP_QUERY="SELECT * FROM EMPLOYEES";
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		
		try {
			//load oracle jdbc driver
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle jdbc driver class not found");
		}
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				PreparedStatement ps=con.prepareStatement(EMP_QUERY)) {
			if (ps!=null) {
				try(ResultSet rs=ps.executeQuery())
				{
					if (rs!=null) {
						int count=0;
						pw.println("Request Time "+new Date());
						pw.println("<br><h1>Employee Details</h1>");
						while(rs.next()) {
							count++;
							pw.println("<p>Employee ID :"+rs.getString(1)+"</p>");
							pw.println("<p>Employee Name :"+rs.getString(2)+" "+rs.getString(3)+"</p>");
							pw.println("<p>Employee Email :"+rs.getString(4)+"</p>");
							pw.println("<p>Employee DOJ :"+rs.getString(5)+"</p>");
							pw.println("<p>Employee Salary :"+rs.getString(6)+"</p>");
							pw.println("<p>=====================================</p>");
						}
						if(count==0)
						{
							pw.println("<h1>No Employee Details Found</h1>");
						}
						
						//close stream
						pw.close();
					}
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			System.out.println("interupted");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread sleep time finished");
		
	}
}
