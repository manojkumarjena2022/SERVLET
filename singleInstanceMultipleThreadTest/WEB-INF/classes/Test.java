package com.mj.servlet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class Test extends GenericServlet{
    public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
        //set response content type
        res.setContentType("text/html;charset=utf-8");
        //write request logic
        Thread t=Thread.currentThread();
        //get response writer
        PrintWriter pw=res.getWriter();
        //write response
        pw.println("Servlet Component Instance Hashcode:<b>"+this.hashCode()+"</b><br>");
        pw.println("ServletRequest Instance Hashcode:<b>"+req.hashCode()+"</b><br>");
        pw.println("ServletResponse Instance Hashcode:<b>"+res.hashCode()+"</b><br>");
        pw.println("Current Thread Hashcode:<b>"+t.hashCode()+"</b><br>");
        pw.println("Current Thread Name:<b>"+t.getName()+"</b><br>");
        //close stream
        pw.close();
    }
    //javac -d . Test.java
    //http://localhost:8081/singleInstanceMultipleThreadTest/test
}