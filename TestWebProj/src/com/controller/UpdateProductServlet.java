package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.vo.Product;

public class UpdateProductServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("********UpdateProduct : doGet()*****");
		
		int id = Integer.parseInt(request.getParameter("productId"));
		
		ProductDAO productDAO = new ProductDAO();
		
		Product product = productDAO.getProductById(id);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2 align=center>Update Product</h2>");
		out.println("<center><form action='updateProduct' method='post'>");
		out.println("<table>");
		out.println("<tr>");
			out.println("<td>ProductId</td><td><input type='text' name='id' readonly value='"+product.getId()+"'/></td>");
		out.println("</tr>");
		out.println("<tr>");
			out.println("<td>ProductName</td><td><input type='text' name='name' value='"+product.getName()+"'/></td>");
		out.println("<tr>");
		out.println("<tr>");
			out.println("<td>ProductPrice</td><td><input type='text' name='price' value='"+product.getPrice()+"'/></td>");
		out.println("</tr>");
		out.println("<tr>");
			out.println("<td>ProductDescription</td><td><input type='text' name='description' value='"+product.getDescription()+"'/></td>");
		out.println("</tr>");
		out.println("<tr>");
			out.println("<td><input type='submit' value='Update Product' /></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form></center>");
		out.println("</body></html>");
							
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("********UpdateProduct : doPost()*****");
		
		Product product = new Product();
		product.setId(Integer.parseInt(request.getParameter("id")));
		product.setName(request.getParameter("name"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setDescription(request.getParameter("description"));
		
		ProductDAO productDAO = new ProductDAO();
		
		productDAO.updateProduct(product);
		
		response.sendRedirect("allProducts");
	}

}
