package com.bmc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

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

import com.bmc.common.GetUserAccountID;
import com.bmc.model.UserMgr;
import com.bmc.pojo.UserAccount;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/CreateAccount")
public class CreateAccountController extends HttpServlet {
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
		String newPage = "/CreateAccount.jsp";
		String action = "";
		String userID = "";
		String firstName = "";
		String lastName = "";
		String companyName = "";
		String companyAddress= "";
		String contactNum = "";
		String email = "";
		String password = "";
		int isCreated = 0;
		String name = "";
		String errorMsg = "";
		String button ="";
		String role = "User";
		
		UserAccount userAcct = new UserAccount();
		UserAccount userAccount = new UserAccount();

		/* Get Today's date */
        Date todayUtil = Calendar.getInstance().getTime();
        System.out.println("today :" + todayUtil);
        java.sql.Date today = new java.sql.Date(todayUtil.getTime());
        System.out.println("sqlDate :" + today);
		
		/* Retrieve session */
		HttpSession session=request.getSession(); 
		if(session != null) {
			userID = (String) session.getAttribute("userID");
			firstName = (String) session.getAttribute("firstName");
			button = (String) session.getAttribute("button");
			
		}
		
		response.setContentType("text/html"); 
		request.getRequestDispatcher(newPage).include(request, response);  
		
		/* Do this when submit button was clicked */
		action = request.getParameter("action");
		if(action != null){

			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			companyName = request.getParameter("companyName");
			companyAddress = request.getParameter("companyAddress");
			contactNum = request.getParameter("contactNum");
			email = request.getParameter("email");
			password = request.getParameter("password");
			button = request.getParameter("button");

			if(action.equalsIgnoreCase("signup")) {

				/* Format name = lastName, firstName */ 
				name = lastName + ", " + firstName;
				
				/* Check how many same userID exists and add 1 
				 * User id should be: example: firstName.lastName001 */
				userID = new GetUserAccountID().getUserID(conn, firstName, lastName);

				/* Save values in contacts POJO */
				userAcct = new UserAccount(userID, password, name, contactNum, email, companyName, companyAddress, 
						role, userID, today, userAcct.getModifiedBy(), userAcct.getModifiedDate(), "");
				userAccount = userAcct;

				/* Call Manager to create values from POJO */
				isCreated = new UserMgr().setUser(conn, userAcct);
				System.out.println("isCreated:" + isCreated);
				
				session.setAttribute("userID", userID);
				session.setAttribute("userAccount", userAccount);
				request.setAttribute("firstName", firstName);
				request.setAttribute("lastName", lastName);
				request.setAttribute("companyName", companyName);
				request.setAttribute("companyAddress", companyAddress);
				request.setAttribute("contactNum", contactNum);
				request.setAttribute("email", email);
				request.setAttribute("isCreated", isCreated);
				request.setAttribute("button", button);

				if (isCreated > 0) {

					errorMsg = "";
					System.out.println("Record is successfully created.");
					
			        /* do redirection */
			        ServletContext sContext = getServletContext();
			        RequestDispatcher rDispatcher = sContext.getRequestDispatcher(newPage);
			        rDispatcher.forward(request, response);

				} else {
					System.out.println("Record is not created");
					/* User Account Creation Page */ 
					errorMsg = "User Account is not created.";
					request.setAttribute("errorMsg", errorMsg);
				}
			}else if(action.equalsIgnoreCase("registered")) {

				session.setAttribute("userID", userID);
				/* Open Dashboard */
				ServletContext sContext = getServletContext();
				RequestDispatcher rDispatcher = sContext.getRequestDispatcher("/BuildingController");
				rDispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
