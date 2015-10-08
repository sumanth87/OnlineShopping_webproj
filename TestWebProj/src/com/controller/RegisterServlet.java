package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegisterServlet extends GenericServlet{
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("**********RegisterServlet: service()**********");
		
		String username = request.getParameter("uname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		
		System.out.println("Username : "+username);
		System.out.println("Email    : "+email);
		System.out.println("Phone    : "+phone);
		System.out.println("City     : "+city);
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2 align=center>You are registered successfully</h2>");
		
		
	}

}
