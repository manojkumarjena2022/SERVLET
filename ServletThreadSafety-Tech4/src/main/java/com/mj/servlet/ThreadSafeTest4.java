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
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//achieving thread safety by implementing SingleThreadModel
@WebServlet("/test4url")
public class ThreadSafeTest4 extends HttpServlet implements SingleThreadModel{
	private static final String EMP_QUERY="SELECT * FROM EMPLOYEES";
	Connection con;
	public ThreadSafeTest4() {
		System.out.println("ThreadSafeTest4 0-param const ::"+this.hashCode());
	}
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			System.out.println("Connection established");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		try(PreparedStatement ps=con.prepareStatement(EMP_QUERY)) {
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
