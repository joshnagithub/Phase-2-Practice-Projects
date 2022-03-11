package com.simplilearn.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TempServlet implements Servlet{

	private ServletConfig config=null;
	@Override
	public void destroy() {
		config=null;
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return config.getServletName();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		out.print("This is my servlet");
	}

}
