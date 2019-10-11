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
		String contactNum = "";
		String email = "";
		String password = "";
		int isUpdated = 0;
		String name = "";
		String conStatus = "";
		String successMsg = "";
		String errorMsg = "";
		String role = "";
		
		response.setContentType("text/html"); 
		request.getRequestDispatcher(newPage).include(request, response);  

		UserAccount userAccnt = new UserAccount();
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
		}
		

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
			role = request.getParameter("role");

			if(action.equalsIgnoreCase("edtAccount")) {
				
				/* Format name = lastName, firstName */ 
				name = lastName + ", " + firstName;
				
				/* Save values in contacts POJO */
				userAccnt = new UserAccount(userID, password, name, contactNum, email, companyName, companyAddress, 
						role, userID, today, userAccnt.getModifiedBy(), userAccnt.getModifiedDate(), "");

				/* Call Manager to create values from POJO */
				isUpdated = new UserMgr().updateUser(conn, userAccnt);
				System.out.println("isUpdate:" + isUpdated);

				session.setAttribute("userID", userID);
				
				/* Get User Account by User ID */
				userAccnt = new UserMgr().getUserAccount(conn, userID, conStatus);

				if (isUpdated > 0) {
					System.out.println("Record is successfully updated.");
					successMsg = "Your Account is successfully updated.";

				} else {
					System.out.println("Record is not updated");
					errorMsg = "Your Account is not updated. Please contact admin for more details.";
				}
				
			}
			
		}
		
		/* Get User Account by User ID */
		userAccnt = new UserMgr().getUserAccount(conn, userID, conStatus);
		userAccount = userAccnt;
		
		/* Send back the userID to session and User Account to request */
		session.setAttribute("userID", userID);
		session.setAttribute("userAccount", userAccount);
		request.setAttribute("userAccnt", userAccnt);
		request.setAttribute("successMsg", successMsg);
		request.setAttribute("errorMsg", errorMsg);
		
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
