package com.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletA extends GenericServlet implements Servlet {

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("******ServletA*******");
				
//		Customer customer = new Customer(101,"Hary");
		
//		ServletContext servletContext = request.getServletContext();
		
	//	servletContext.setAttribute("customer",customer);
		
//		request.setAttribute("customer",customer);
//		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("servB");
//				
//		requestDispatcher.forward(request, response);
		
	}

}
