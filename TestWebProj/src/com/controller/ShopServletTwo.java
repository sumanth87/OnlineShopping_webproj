package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vo.ShoppingCart;

/**
 * Servlet implementation class ShopServletTwo
 */
public class ShopServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
System.out.println("********ShopServletTwo : doGet()*********");
		
		String item4 = request.getParameter("appleiphone");
		String item5 = request.getParameter("samsungnoteII");
		String item6 = request.getParameter("lumia");
		
		HttpSession session =  request.getSession();
	
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("cart");
		
		if(item4!=null){
			shoppingCart.getItems().add(item4);
		}
		
		if(item5!=null){
			shoppingCart.getItems().add(item5);
		}
		
		if(item6!=null){
			shoppingCart.getItems().add(item6);
		}
	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("onlineshoppage3.jsp");
		
		requestDispatcher.forward(request, response);
		

	}

}
