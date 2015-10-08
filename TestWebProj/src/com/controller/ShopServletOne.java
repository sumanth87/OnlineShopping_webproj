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
 * Servlet implementation class ShopServletOne
 */
public class ShopServletOne extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("********ShopServletOne : doGet()*********");
		
		ShoppingCart shoppingCart = new ShoppingCart();
		
		String item1 = request.getParameter("shampoo");
		String item2 = request.getParameter("dove");
		String item3 = request.getParameter("inhaler");
		
		if(item1!=null){
			shoppingCart.getItems().add(item1);
		}
		
		if(item2!=null){
			shoppingCart.getItems().add(item2);
		}
		
		if(item3!=null){
			shoppingCart.getItems().add(item3);
		}
		
		HttpSession httpSession = request.getSession();
		
		httpSession.setAttribute("cart",shoppingCart);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("onlineshoppage2.jsp");
		
		requestDispatcher.forward(request, response);
	}

}
