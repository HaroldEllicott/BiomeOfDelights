package com.fdm.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.listeners.GenericDAO;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet init");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
		String username = req.getParameter("username");
		HttpSession session = req.getSession();
		session.setAttribute("user", username);
		ServletContext context = getServletContext();
		GenericDAO dao = (GenericDAO) context.getAttribute("productDAO");
		//Rather than getAllProducts should use the getAll method in the dao.
		req.setAttribute("products", dao.getAll());
		dispatcher.forward(req, resp);
	}
	
}
