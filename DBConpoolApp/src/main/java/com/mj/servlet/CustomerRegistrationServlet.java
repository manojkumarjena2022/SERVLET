package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet {
	public static final String CUST_INSERT_QUERY="INSERT INTO CUSTOMERS VALUES(CUST_NO.NEXTVAL,?,?,?,?,?)";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//get form data
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		Double billAmount=Double.parseDouble(req.getParameter("bill_amount"));
		Long mobileNo=Long.parseLong(req.getParameter("mobile_no"));
		//get connection pool object
		try(Connection con=getpooledConnection();) {
			PreparedStatement ps=con.prepareStatement(CUST_INSERT_QUERY);
			//set values to query param
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setLong(3, mobileNo);
			ps.setDouble(4, billAmount);
			ps.setString(5, address);
			//execute query
			int result=ps.executeUpdate();
			//process result
			if (result==1) {
				//print result
				pw.println("<h1 style='color:green'>Customer Registered</h1>");
				pw.println("<br><br><a href='customer_register.html'>Home</a>");
			}
		} catch (NamingException e) {
			pw.println("<h1 style='color:red'>Internal Problem-Try Again "+e.getMessage()+"</h1>");
			e.printStackTrace();
			pw.println("<br><br><a href='customer_register.html'>Home</a>");
		} catch (SQLException e1) {
			pw.println("<h1 style='color:red'>Internal Problem-Try Again "+e1.getMessage()+"</h1>");
			pw.println("<br><br><a href='customer_register.html'>Home</a>");
			e1.printStackTrace();
		}
		catch (Exception e2) {
			pw.println("<h1 style='color:red'>Internal Problem-Try Again "+e2.getMessage()+"</h1>");
			pw.println("<br><br><a href='customer_register.html'>Home</a>");
			e2.printStackTrace();
		}
	}
	private Connection getpooledConnection() throws NamingException, SQLException {
		//get initial context object
		InitialContext ic=new InitialContext();
		//get datasource object
		//DataSource ds=(DataSource) ic.lookup("DSJndi");
		String jndiName=getServletConfig().getInitParameter("jndi");
		DataSource ds=(DataSource) ic.lookup(jndiName);
		//get pooled jdbc connection object
		Connection con=ds.getConnection();
		return con;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
//write inside <Context></Context> context.xml present in Tomcat directory 
/*
 * <Resource name="DsJndi" auth="Container" type="javax.sql.DataSource"
 * driverClassName="oracle.jdbc.OracleDriver"
 * url="jdbc:oracle:thin:@localhost:1521:orcl" username="system"
 * password="tiger" maxTotal="20" maxIdle="10" maxWaitMillis="-1"/>
 */