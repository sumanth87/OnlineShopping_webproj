package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dao.ProductDAO;
import com.vo.Product;

/**
 * Servlet implementation class ProductSearchServlet
 */
public class ProductSearchServlet extends GenericServlet  {

	ProductDAO productDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	
		productDAO = new ProductDAO();
		
		String cls = config.getInitParameter("driverclass");
		
		ServletContext servletContext = config.getServletContext();
		
		String msg = servletContext.getInitParameter("message");
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		int productId = Integer.parseInt(request.getParameter("productId"));
	
		ServletContext context = request.getServletContext();
		
		Product product = productDAO.getProductById(productId);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2 align=center>Product Record</h2>");
		out.println("<table align=center border=2>");
		out.println("<tr><th>ProductId</th><th>ProductName</th><th>ProductPrice</th><th>ProductDescription</th></tr>");
		out.println("<tr>");
			out.println("<td>"+product.getId()+"</td>");
			out.println("<td>"+product.getName()+"</td>");
			out.println("<td>"+product.getPrice()+"</td>");
			out.println("<td>"+product.getDescription()+"</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body></html>");
		
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	
	}

}
