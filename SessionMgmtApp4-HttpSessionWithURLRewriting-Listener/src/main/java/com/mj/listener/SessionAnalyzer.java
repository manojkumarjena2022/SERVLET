package com.mj.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionAnalyzer implements HttpSessionListener {
	private long start,end;
	public SessionAnalyzer() {
		System.out.println("SessionAnalyzer:: 0-param constructor");
	}
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionAnalyzer:: sessionCreated()");
		start=System.currentTimeMillis();
		System.out.println("Session started at ::"+new Date());
		//get servlet context object
		ServletContext sc=se.getSession().getServletContext();
		sc.log("Session started at::"+new Date());
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionAnalyzer:: sessionDestroyed()");
		end=System.currentTimeMillis();
		//get servlet context object
		ServletContext sc=se.getSession().getServletContext();
		sc.log("Session ended at::"+new Date());
		sc.log("Session duration :: "+(end-start)+" ms");
		System.out.println("Session duration :: "+(end-start)+" ms");
		System.out.println("Session ended at ::"+new Date());
		
	}
}
