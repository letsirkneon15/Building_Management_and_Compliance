package com.bmc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.bmc.model.HardCodedData;
import com.bmc.model.UserBuildingMgr;
import com.bmc.model.UserMgr;
import com.bmc.pojo.AdminUserBuilding;
import com.bmc.pojo.UserAccount;
import com.bmc.pojo.UserBuilding;
import com.bmc.pojo.UserTab;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Admin")
public class AdminController extends HttpServlet {
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
		String newPage = "/AdminTabContents.jsp";
		String action = "";
		String userID = "";
		String tabName = "";
	    int isUpdated = 0;
	    int isSetStatus = 0;
	    int isCreated = 0;
	    String conStatus="";
	    String name = "";
	    String conD="D";
	    int userIDCtr = 0;
		String userIDStr = "";
		String userMsg = "";
		String successMsg = "";
		String errorMsg = "";

	    UserAccount userAccnt = new UserAccount();
	    List<UserAccount> userArr = new ArrayList<>();
	    ArrayList<String[]> tabList = new HardCodedData().getTabList();
	    List<UserTab> userTabArr = new ArrayList<>();
	    List<UserBuilding> userBuildArr = new ArrayList<>();
	    List<AdminUserBuilding> aUserBuildArr = new ArrayList<>();
	    
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
			
			System.out.println("Action: " + action);

            /* Do this for creation of new records in TAB */
            if (action.equalsIgnoreCase("crtTabs")) {
            	
            	 tabName = request.getParameter("tab");

                 switch (tabName) {

                     case "UserAccount":
             			String firstName = request.getParameter("crtFirstName");
            			String lastName = request.getParameter("crtLastName");
            			String companyName = request.getParameter("crtCompanyName");
            			String companyAddress = request.getParameter("crtCompanyAddress");
            			String contactNum = request.getParameter("crtContactNum");
            			String email = request.getParameter("crtEmail");
            			
            			/* Format name = lastName, firstName */ 
        				name = lastName + ", " + firstName;
        				
        				/* Check how many same userID exists and add 1 
        				 * User id should be: example: firstName.lastName001 */
        				String auserID = firstName + "." + lastName;
        				userIDCtr = new UserMgr().countUserID(conn, auserID) + 1;
        				
        				userIDStr = Integer.toString(userIDCtr);
        				if(userIDStr.length()==1) {
        					auserID = auserID + "00" + userIDStr;
        				}else if(userIDStr.length()==2){
        					auserID = auserID + "0" + userIDStr;
        				}else {
        					auserID = auserID + userIDStr;
        				}
        				
        				/* For Admin - password should be the same as in userid and user have to change upon login */
        				String password = auserID;
        				
        				/* Save values in contacts POJO */
        				userAccnt = new UserAccount(auserID, password, name, contactNum, email, companyName, companyAddress, 
        						userID, today, userAccnt.getModifiedBy(), userAccnt.getModifiedDate(), "");

        				/* Call Manager to create values from POJO */
        				isCreated = new UserMgr().setUser(conn, userAccnt);
        				System.out.println("isCreated:" + isCreated);
        				
        				if (isCreated > 0) {
        					userMsg = "User " + name + " is successfully registered with user ID=" 
        							+ auserID + " and password=" + password;
        					System.out.println("Record is successfully created.");
        				} else {
        					System.out.println("Record is not created");
        				}
        				break;
                 }	
            }else if(action.equalsIgnoreCase("editTabs")) {
            	
            	tabName = request.getParameter("tab");

                switch (tabName) {

                    case "UserAccount":
                    	String firstName = request.getParameter("edtFirstName");
                    	String lastName = request.getParameter("edtLastName");
                    	String auserID = request.getParameter("edtUserID");
                    	String companyName = request.getParameter("edtCompanyName");
                    	String companyAddress = request.getParameter("edtCompanyAddress");
                    	String contactNum = request.getParameter("edtContactNum");
                    	String email = request.getParameter("edtEmail");
                    	String password = request.getParameter("edtPassword");
           			
                    	/* Format name = lastName, firstName */ 
                    	name = lastName + ", " + firstName;
       				
                    	/* Save values in contacts POJO */
                    	userAccnt = new UserAccount(auserID, password, name, contactNum, email, companyName, companyAddress, 
       						userAccnt.getCreatedBy(), userAccnt.getCreationDate(), userID, today, "");

                    	/* Call Manager to update values from POJO */
                    	isUpdated = new UserMgr().updateUser(conn, userAccnt);
                    	System.out.println("isUpdated:" + isUpdated);
       				
                    	if (isUpdated > 0) {
                    		System.out.println("Record is successfully updated.");
                    	} else {
                    		System.out.println("Record is not updated");
                    	}
                    	break;
                    	
                    case "UserBuilding":

                    	 auserID = request.getParameter("auserID");
                    	 String[] userBuildList = request.getParameterValues("userBuildList");

                    	 /* Get all user-building */
                         aUserBuildArr = new UserBuildingMgr().getUserBuildingList(conn, auserID);
                         
                         /* Get all buildings not registered to user */
                         aUserBuildArr.addAll(new UserBuildingMgr().getUserBuildingNotRegistered(conn, auserID));
                    	 
                         for(AdminUserBuilding aub : aUserBuildArr) {
                        	 String aubStatus = "D";
                        	 for(String ub : userBuildList) {
                        		 if(Integer.parseInt(ub) == aub.getBuildingID()) {
                        			 aubStatus="";
                        			 break;
                        		 }
                        	 }
                        	 
                        	 userBuildArr.add(new UserBuilding(auserID, aub.getBuildingID(), userID, today,  
                        			 aubStatus));
                         }
	 
                         /* Call Manager to update values from POJO */
                     	isUpdated = new UserBuildingMgr().editUserBuilding(conn, userBuildArr);
                     	System.out.println("isUpdated:" + isUpdated);
        				
                     	if (isUpdated > 0) {
                     		System.out.println("Record is successfully updated.");
                     		successMsg = "Building is successfully assigned to user.";
                     		
                     		/* Get all user-building */
                            aUserBuildArr = new UserBuildingMgr().getUserBuildingList(conn, auserID);
                            
                            /* Get all buildings not registered to user */
                            aUserBuildArr.addAll(new UserBuildingMgr().getUserBuildingNotRegistered(conn, auserID));
                     	} else {
                     		System.out.println("Record is not updated");
                     		errorMsg = "Building is not successfully assigned to user. Please contact admin for more details.";
                     	}
                     	
                     	request.setAttribute("auserID", auserID);
                     	
                     	break;  	 
                }
            }else if(action.equalsIgnoreCase("dltTabs")) {
            	
            	tabName = request.getParameter("tab");

                switch (tabName) {

                    case "UserAccount":
                    	String auserID = request.getParameter("auserID");
                    	
                    	/* Call Manager to edit status=D */
                        isSetStatus = new UserMgr().setStatus(conn, conD, auserID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;
                    	
                }
            	
            }else if(action.equalsIgnoreCase("showTabs")) {
            	
            	tabName = request.getParameter("tab");
            	String auserID = request.getParameter("auserID");
            	
            	request.setAttribute("auserID", auserID);
            	
            	/* Get all user-building */
                aUserBuildArr = new UserBuildingMgr().getUserBuildingList(conn, auserID);
                
                /* Get all buildings not registered to user */
                aUserBuildArr.addAll(new UserBuildingMgr().getUserBuildingNotRegistered(conn, auserID));

            }
            
		}
            
            /* Query latest values and Display Tab Contents */
            
            /* Get all active users */
            userArr = new UserMgr().getUserAccountList(conn, conStatus);
            
            session.setAttribute("userID", userID);
            request.setAttribute("userArr", userArr);
            request.setAttribute("userMsg", userMsg);
            request.setAttribute("aUserBuildArr", aUserBuildArr);
            request.setAttribute("tabName", tabName);
            request.setAttribute("successMsg", successMsg);
            request.setAttribute("errorMsg", errorMsg);
            
            /* do redirection */
            ServletContext sContext = getServletContext();
            RequestDispatcher rDispatcher = sContext.getRequestDispatcher(newPage);
            rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
