package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends GenericServlet implements Servlet {

	private HashMap<String,String> userDetails = new HashMap<>();
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		userDetails.put("kumar","kumar123");
		userDetails.put("raj","raj123");
		userDetails.put("anil","anil123");
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("*********LoginServlet*********");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(userDetails.containsKey(username)){
			
			if(userDetails.get(username).equals(password)){
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("accountServ");
				
				requestDispatcher.forward(request, response);
			}else{
				
				RequestDispatcher loginDispatcher = request.getRequestDispatcher("login.html");
				
				loginDispatcher.forward(request, response);
			}
			
		}else{
			
			RequestDispatcher loginDispatcher = request.getRequestDispatcher("login.html");
			
			loginDispatcher.forward(request, response);
		}
	}

}
