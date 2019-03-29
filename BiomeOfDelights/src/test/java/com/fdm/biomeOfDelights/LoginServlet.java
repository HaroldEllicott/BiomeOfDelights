package com.fdm.biomeOfDelights;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.database.RecipeDAO;

public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
		String username = req.getParameter("username");
		HttpSession session = req.getSession();
		session.setAttribute("user", username);
		ServletContext context = getServletContext();
		RecipeDAO dao = (RecipeDAO) context.getAttribute("recipeDAO");
		req.setAttribute("recipe", dao.getAll());
		
		dispatcher.forward(req, res);
	}



}
