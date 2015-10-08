package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	
	
	private ArrayList<String> usernamesList = new ArrayList<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		usernamesList.add("Hary");
		usernamesList.add("Raj");
		usernamesList.add("Kumar");
	}
                       //http request                      //http response                  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("*******ValidateUserServlet*******");
		
		String username = request.getParameter("username");
		
		PrintWriter out = response.getWriter();
		
		if(usernamesList.contains(username)){
			out.println("<font color='red'>Username is already taken</font>");
		}else{
			out.println("<font color='green'>Username is available</font>");
		}
		
	}
	

}
