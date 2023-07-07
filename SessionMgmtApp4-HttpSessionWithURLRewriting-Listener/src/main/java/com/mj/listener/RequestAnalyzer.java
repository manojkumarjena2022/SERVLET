package com.mj.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
@WebListener
public class RequestAnalyzer implements ServletRequestListener {
	private long start,end;
	public RequestAnalyzer() {
		System.out.println("RequestAnalyzer:: 0-param constructor");
	}
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzer:: requestInitialized()");
		start=System.currentTimeMillis();
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzer:: requestDestroyed()");
		end=System.currentTimeMillis();
		//get servlet request object
		HttpServletRequest req=(HttpServletRequest) sre.getServletRequest();
		//get servlet context object
		ServletContext sc=req.getServletContext();
		sc.log(req.getRequestURI()+" has taken "+(end-start)+" ms time to process the request");
		System.out.println(req.getRequestURI()+" has taken "+(end-start)+" ms time to process the request");
	}
}
