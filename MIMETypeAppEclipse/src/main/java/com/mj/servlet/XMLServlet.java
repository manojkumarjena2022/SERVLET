package com.mj.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class XMLServlet extends HttpServlet{
  protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
//set MIME(Multipurpose Internet Mail Extensions) type
res.setContentType("text/xml");
//write output content to browser
PrintWriter pw=res.getWriter();
pw.println("<table border='1' algn='center'>");
pw.println("<tr><th>Name</th><th>Designation</th><th>Salary</th></tr>");
pw.println("<tr><td>Manoj</td><td>Team Lead</td><td>27000</td></tr>");
pw.println("<tr><td>Sanjeeb</td><td>Developer</td><td>7000</td></tr>");
pw.println("<tr><td>MJ</td><td>Tester</td><td>9000</td></tr>");
pw.println("<tr><td>Kumar</td><td>Frontend eveloper</td><td>20000</td></tr>");
pw.println("</table>");
//close stream
pw.close();
}
}
//javac -d . XMLServlet.java
//http://localhost:8081/MIMETypeApp/xmlurl
