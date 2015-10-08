package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;

/**
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("********DeleteProductServlet*******");
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		ProductDAO productDAO = new ProductDAO();
		
		productDAO.deleteProduct(productId);
		
		response.sendRedirect("allProducts");
		
	}

}
