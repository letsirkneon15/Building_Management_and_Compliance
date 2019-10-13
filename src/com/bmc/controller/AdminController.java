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

import com.bmc.common.GetUserAccountID;
import com.bmc.model.HardCodedData;
import com.bmc.model.TabMgr;
import com.bmc.model.UserBuildingMgr;
import com.bmc.model.UserMgr;
import com.bmc.model.UserTabMgr;
import com.bmc.pojo.AdminUserBuilding;
import com.bmc.pojo.AdminUserTab;
import com.bmc.pojo.Tab;
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
		String userMsg = "";
		String successMsg = "";
		String errorMsg = "";

	    UserAccount userAccnt = new UserAccount();
	    UserAccount userAccount = new UserAccount();
	    List<UserAccount> userArr = new ArrayList<>();
	    List<Tab> tabList = new ArrayList<>();
	    List<UserTab> userTabArr = new ArrayList<>();
	    List<AdminUserTab> aUserTabArr = new ArrayList<>();
	    List<UserBuilding> userBuildArr = new ArrayList<>();
	    List<AdminUserBuilding> aUserBuildArr = new ArrayList<>();
	    ArrayList<String> roleList = new ArrayList<String>();
	    
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
            			String role = request.getParameter("crtRole");
            			
            			/* Format name = lastName, firstName */ 
        				name = lastName + ", " + firstName;
        				
        				/* Check how many same userID exists and add 1 
        				 * User id should be: example: firstName.lastName001 */
        				String auserID = new GetUserAccountID().getUserID(conn, firstName, lastName);
        				
        				/* For Admin - password should be the same as in userid and user have to change upon login */
        				String password = auserID;
        				
        				/* Save values in contacts POJO */
        				userAccnt = new UserAccount(auserID, password, name, contactNum, email, companyName, companyAddress, role, 
        						userID, today, userAccnt.getModifiedBy(), userAccnt.getModifiedDate(), "");

        				/* Call Manager to create values from POJO */
        				isCreated = new UserMgr().setUser(conn, userAccnt);
        				System.out.println("isCreated:" + isCreated);
        				
        				if (isCreated > 0) {
        					userMsg = "User " + name + " is successfully registered with user ID=" 
        							+ auserID + " and password=" + password + "<br><p class='text-danger'>Please remember to " +
        							"set up User-Building and User-Tab.</p>";
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
                    	String role = request.getParameter("edtRole");
           			
                    	/* Format name = lastName, firstName */ 
                    	name = lastName + ", " + firstName;
       				
                    	/* Save values in contacts POJO */
                    	userAccnt = new UserAccount(auserID, password, name, contactNum, email, companyName, companyAddress, role,  
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
                        	 if(userBuildList != null) {
                        		 for(String ub : userBuildList) {
                            		 if(Integer.parseInt(ub) == aub.getBuildingID()) {
                            			 aubStatus="";
                            			 break;
                            		 }
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
                     	
                    case "UserTab":
                    	
                    	 auserID = request.getParameter("auserID");
                    	 String atabID = request.getParameter("atabID");
                    	 
                    	 String tabIDParm = atabID;
                     	 if(atabID.equals("ALL")) {
                     		tabIDParm = "";
                     	 }
                     	 System.out.println("tabIDParm: " + tabIDParm);
                     	
                     	 System.out.println("auserID: " + auserID);
                     	 /* Get all user-tabs with or without tab Segments */
                     	 aUserTabArr = new UserTabMgr().getUserTabList(conn, auserID, tabIDParm);
                     	
                     	 /* Get all tabs not registered to user */
                     	 aUserTabArr.addAll(new UserTabMgr().getUserTabNotRegistered(conn, auserID, tabIDParm));
                     	 
                     	for(AdminUserTab atb : aUserTabArr) {
                     		
                     		if(!atb.getTabID().equals("")) {
                     			
                     			System.out.println("tabID from userTabList: " + atb.getTabID());
                         		String[] userTabList = request.getParameterValues(atb.getTabID());
                         		String tabDsp = "";
                         		String tabCrt = "";
                         		String tabUpd = "";
                         		String tabDlt = "";

                         		if(userTabList != null) {
                         			for(String ut : userTabList) {
                         				System.out.println("userTabList: " + ut);
                             			if(!ut.equals("")) {
                             				switch(ut) {
                             					case "DSP":
                             						tabDsp = ut;
                             						break;
                             					case "CRT":
                             						tabCrt = ut;
                             						break;
                             					case "UPD":
                             						tabUpd = ut;
                             						break;
                             					case "DLT":
                             						tabDlt = ut;
                             						break;
                             				}
                             			}
                         			}
                            	 }
			
                             		String status= "D";
                             		System.out.println("tabDsp: " + tabDsp);
                             		if(!tabDsp.equals("")) {
                             			status = "";
                             		}
                             		userTabArr.add(new UserTab(atb.getUserID(), atb.getTabID(), "DSP", userID, today, status));
                             		
                             		status= "D";
                             		if(!tabCrt.equals("")) {
                             			status = "";
                             		}
                             		userTabArr.add(new UserTab(atb.getUserID(), atb.getTabID(), "CRT", userID, today, status));
                             		
                             		status= "D";
                             		if(!tabUpd.equals("")) {
                             			status = "";
                             		}
                             		userTabArr.add(new UserTab(atb.getUserID(), atb.getTabID(), "UPD", userID, today, status));
                             		
                             		status= "D";
                             		if(!tabDlt.equals("")) {
                             			status = "";
                             		}
                             		userTabArr.add(new UserTab(atb.getUserID(), atb.getTabID(), "DLT", userID, today, status));
                     		}
                        }
                     	
                     	 /* Call Manager to update values from POJO */
                     	isUpdated = new UserTabMgr().editUserTab(conn, userTabArr);
                     	System.out.println("isUpdated:" + isUpdated);
                     	
                     	if (isUpdated > 0) {
                     		System.out.println("Record is successfully updated.");
                     		successMsg = "Tab is successfully assigned to user.";
                     		
                     		/* Get all user-tabs with or without tab Segments */
                        	 aUserTabArr = new UserTabMgr().getUserTabList(conn, auserID, tabIDParm);
                        	
                        	 /* Get all tabs not registered to user */
                        	 aUserTabArr.addAll(new UserTabMgr().getUserTabNotRegistered(conn, auserID, tabIDParm));
                     	} else {
                     		System.out.println("Record is not updated");
                     		errorMsg = "Tab is not successfully assigned to user. Please contact admin for more details.";
                     	}
                     	
                     	request.setAttribute("auserID", auserID);
                     	request.setAttribute("atabID", atabID);
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

                switch (tabName) {

                    case "UserBuilding":
            	
                    	/* Get all user-building */
                    	aUserBuildArr = new UserBuildingMgr().getUserBuildingList(conn, auserID);
                
                    	/* Get all buildings not registered to user */
                    	aUserBuildArr.addAll(new UserBuildingMgr().getUserBuildingNotRegistered(conn, auserID));
                    	
                    	break;
                    
                    case "UserTab":
                    	
                    	String atabID = request.getParameter("atabID");
                    	
                    	request.setAttribute("atabID", atabID); 
                    	
                    	
                    	String tabIDParm = atabID;
                    	if(atabID.equals("ALL")) {
                    		tabIDParm = "";
                    	}
                    	System.out.println("tabIDParm: " + tabIDParm);
                    	
                    	/* Get all user-tabs with or without tab Segments */
                    	aUserTabArr = new UserTabMgr().getUserTabList(conn, auserID, tabIDParm);
                    	
                    	/* Get all tabs not registered to user */
                    	aUserTabArr.addAll(new UserTabMgr().getUserTabNotRegistered(conn, auserID, tabIDParm));
                    	
                    	break;
                }

            }
            
		}
            
            /* Query latest values and Display Tab Contents */
            
            /* Get all active users */
            userArr = new UserMgr().getUserAccountList(conn, conStatus);
            
            /* Get all active tabs */
            tabList = new TabMgr().getAllTabs(conn, conStatus);
            
            /* Get User Roles */
            roleList = new HardCodedData().getRoles();
            
            /* Get user account by userID */
            userAccount = new UserMgr().getUserAccount(conn, userID, conStatus);
            
            session.setAttribute("userID", userID);
            session.setAttribute("userAccount", userAccount);
            request.setAttribute("userArr", userArr);
            request.setAttribute("tabList", tabList);
            request.setAttribute("userMsg", userMsg);
            request.setAttribute("aUserBuildArr", aUserBuildArr);
            request.setAttribute("aUserTabArr", aUserTabArr);
            request.setAttribute("tabName", tabName);
            request.setAttribute("successMsg", successMsg);
            request.setAttribute("errorMsg", errorMsg);
            request.setAttribute("roleList", roleList);
            
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
