package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class AccountServlet
 */
public class AccountServlet extends GenericServlet implements Servlet {

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		System.out.println("*********AccountServlet*********");

		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h2 align=center> Home Page</h2>");

		out.println("<h3 align=center> Customer Details </h3>");

		out.println("</body></html>");
	}

}
