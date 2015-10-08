package com.listener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
public class TestListener implements ServletContextListener {

	
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // TODO Auto-generated method stub
    	System.out.println("******TestListener contextInitialized()******");
    	
    	try{
    		
    		Class.forName("org.gjt.mm.mysql.Driver");
    		
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
    		
    		ServletContext servletContext = servletContextEvent.getServletContext();
    		
    		servletContext.setAttribute("connection", connection);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

	
  	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	
}
