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

import com.bmc.model.UserMgr;
import com.bmc.pojo.UserAccount;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/User")
public class UserController extends HttpServlet {
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
		String newPage = "/UserRegistration.jsp";
		String action = "";
		String userID = "";
		String firstName = "";
		String lastName = "";
		String companyName = "";
		String companyAddress= "";
		String contactNumber = "";
		String emailAdd = "";
		String password = "";
		int isCreated = 0;
		String name = "";
		int userIDCtr = 0;
		String userIDStr = "";
		
		response.setContentType("text/html"); 
		request.getRequestDispatcher(newPage).include(request, response);  

		UserAccount userAcct = new UserAccount();

		/* Get Today's date */
        Date todayUtil = Calendar.getInstance().getTime();
        System.out.println("today :" + todayUtil);
        java.sql.Date today = new java.sql.Date(todayUtil.getTime());
        System.out.println("sqlDate :" + today);
		
		/* Retrieve session */
		HttpSession session=request.getSession();

		/* Do this when submit button was clicked */
		action = request.getParameter("action");
		if(action != null){

			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			companyName = request.getParameter("companyName");
			companyAddress = request.getParameter("companyAddress");
			contactNumber = request.getParameter("contactNumber");
			emailAdd = request.getParameter("emailAdd");
			password = request.getParameter("password");

			if(action.equalsIgnoreCase("edtAccount")) {
				
				/* Save values in contacts POJO */
				userAcct = new UserAccount(userID, password, name, contactNumber, emailAdd, companyName, companyAddress, 
						userID, today, userAcct.getModifiedBy(), userAcct.getModifiedDate(), "");

				/* Call Manager to create values from POJO */
				isCreated = new UserMgr().setUser(conn, userAcct);
				System.out.println("isCreated:" + isCreated);

				session.setAttribute("userID", userID);

				if (isCreated > 0) {

					System.out.println("Record is successfully created.");
					/* Open Dashboard */
					ServletContext sContext = getServletContext();
					RequestDispatcher rDispatcher = sContext.getRequestDispatcher("/BuildingController");
					rDispatcher.forward(request, response);

				} else {
					System.out.println("Record is not created");
					/* Login Page */ 
					ServletContext sContext = getServletContext();
					RequestDispatcher rDispatcher = sContext.getRequestDispatcher(newPage);
					rDispatcher.forward(request, response);
				}
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
