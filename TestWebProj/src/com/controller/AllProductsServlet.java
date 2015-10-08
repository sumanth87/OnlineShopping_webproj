package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dao.ProductDAO;
import com.vo.Product;

public class AllProductsServlet extends GenericServlet implements Servlet {

	
	private ProductDAO productDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		productDAO = new ProductDAO();
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("*******AllProducts*****");
		
	  try{	
		  
		  ArrayList<Product> products =   productDAO.getProducts();
		  
		  request.setAttribute("productsList",products);
		  
		  RequestDispatcher requestDispatcher = request.getRequestDispatcher("productsView.jsp");
		  
		  requestDispatcher.forward(request, response);
		  
		  
//		  response.setContentType("text/html");
//		  
//		  
//		  PrintWriter out = response.getWriter();
//		  
//		  //Presentation Logic
//		  out.println("<html><body>");
//		  out.println("<h2 align=center>Product Records</h2>");
//		  
//		  out.println("<table border=2 align=center>");
//		  
//		  out.println("<tr><th>ProductId</th><th>ProductName</th><th>ProductPrice</th><th>ProductDescription</th></tr>");
//		  
//		  for (Product product : products) {
//			  
//			  out.println("<tr>");
//			  	out.println("<td>"+product.getId()+"</td>");
//			  	out.println("<td>"+product.getName()+"</td>");
//			  	out.println("<td>"+product.getPrice()+"</td>");
//			  	out.println("<td>"+product.getDescription()+"</td>");
//			  	out.println("<td><a href='deleteProduct?productId="+product.getId()+"'>delete</a></td>");
//				out.println("<td><a href='updateProduct?productId="+product.getId()+"'>update</a></td>");
//			  out.println("</tr>");
//			  
//		  }
//		  
//		  out.println("</table></body></html>");
		  
	  }catch(Exception e){
		  e.printStackTrace();
	  }
		
	}

}
