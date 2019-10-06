package com.bmc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/CreateAccountSuccessful")
public class CreateAccountSuccessful extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Context initContext;
	private Context envContext;
	private DataSource dataSource;
	private Connection conn;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try{
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/Project");
			conn = dataSource.getConnection();
			System.out.println("Connection: " + conn);
		}catch (NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding( "UTF-8" );
		String newPage = "/CreateAccountSuccess.jsp";
		String action = "";
		String userID = "";
		String button = "registered";
		String firstName = "";
		
		response.setContentType("text/html"); 
		request.getRequestDispatcher(newPage).include(request, response);  
		
		/* Retrieve session */
		HttpSession session=request.getSession();
		if (session !=null ){
			userID = (String) session.getAttribute("userID");
			firstName = (String) session.getAttribute("firstName");
		}

		/* Do this when submit button was clicked */
		action = request.getParameter("action");
		if(action != null){
			
			if(action.equalsIgnoreCase("registered")) {

				session.setAttribute("userID", userID);
				/* Open Dashboard */
				ServletContext sContext = getServletContext();
				RequestDispatcher rDispatcher = sContext.getRequestDispatcher("/BuildingController");
				rDispatcher.forward(request, response);
			}
		}

		session.setAttribute("userID", userID);
		session.setAttribute("firstName", firstName);
		request.setAttribute("button", button);
		System.out.println("button: " + button);
		
        /* do redirection */
        ServletContext sContext = getServletContext();
        RequestDispatcher rDispatcher = sContext.getRequestDispatcher(newPage);
        rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
