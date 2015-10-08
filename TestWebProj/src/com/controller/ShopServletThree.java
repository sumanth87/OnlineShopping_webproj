package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vo.ShoppingCart;

/**
 * Servlet implementation class ShopServletThree
 */
public class ShopServletThree extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
System.out.println("********ShopServletThree : doGet()*********");
		
		String item7 = request.getParameter("ultrabook");
		String item8 = request.getParameter("laptop");
		
		HttpSession httpSession = request.getSession();
		
		ShoppingCart shoppingCart = (ShoppingCart)httpSession.getAttribute("cart");
		
		List<String> itemsList = shoppingCart.getItems();
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2 align=center>Check Out </h2>");
		
		out.println("<h3 align=center>List of Items</h3>");
		
		out.println("Session Id : "+httpSession.getId());
		
		int i = 1;
		for (String str : itemsList) {
			
			out.println(i+". "+str);
			out.println("<br>");
			i++;
		}
		if(item7!=null){
			out.println(i+". "+item7);
			i++;
		}
		if(item8!=null){
			out.println(i+". "+item8);
		}
		
		//destroy()
		httpSession.invalidate();
		
	}

}
