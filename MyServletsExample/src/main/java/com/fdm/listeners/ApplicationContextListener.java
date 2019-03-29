package com.fdm.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("App started");
		ServletContext context = sce.getServletContext();
		context.setAttribute("productDAO", new GenericDAO());
		
	}

}
