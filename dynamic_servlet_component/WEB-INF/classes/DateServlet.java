package com.mj.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

public class DateServlet extends GenericServlet {
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // set response content type
        res.setContentType("text/html");
        // get PrintWriter stream object from response object
        PrintWriter pw = res.getWriter();
        // write request processing logic
        Date dt = new Date();// holds system date and time
        // write generated output to response object using PrintWriter stream
        pw.println("<h1>Date and time is ::: " + dt + "</h1>");
        // close the stream
        pw.close();
    }
    //javac -d . DateServlet.java
    //http://localhost:8081/dynamic_servlet_component/first
}