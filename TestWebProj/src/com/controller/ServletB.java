package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.vo.Customer;

public class ServletB extends GenericServlet implements Servlet {

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		System.out.println("******ServletB*******");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2> This is ServletB </h2>");
		
		//Customer customer = (Customer)request.getAttribute("customer");
		
		ServletContext servletContext = request.getServletContext();
		
		Customer customer = (Customer)servletContext.getAttribute("customer");
		
		out.println("CustomerId   : "+customer.getId());
		out.println("<br>");
		out.println("CustomerName : "+customer.getName());
	}

}
