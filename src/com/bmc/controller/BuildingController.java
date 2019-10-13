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

import com.bmc.model.BuildingHeaderMgr;
import com.bmc.model.HardCodedData;
import com.bmc.model.UserMgr;
import com.bmc.model.UserTabMgr;
import com.bmc.pojo.AdminUserTab;
import com.bmc.pojo.BuildingHeader;
import com.bmc.pojo.UserAccount;

/**
 * Servlet implementation class BuildingController
 */
@WebServlet("/BuildingController")
public class BuildingController extends HttpServlet {
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
		String newPage = "/MainPage.jsp";
		String userID = "";
		UserAccount userAccount = new UserAccount();
		String conStatus="";
		String action = "";
		int buildingID = 0;
		int isCreated = 0;

		AdminUserTab genInfoTab = new AdminUserTab();
		ArrayList<String> yesNoList = new ArrayList<String>();
		ArrayList<String> fireHazCatList = new ArrayList<String>();
		BuildingHeader bHeaderInfo = new BuildingHeader();

		/* Get Today's date */
		Date todayUtil = Calendar.getInstance().getTime();
		System.out.println("today :" + todayUtil);
		java.sql.Date today = new java.sql.Date(todayUtil.getTime());
		System.out.println("sqlDate :" + today);

		/* Retrieve session values from BuildingHeader */
		HttpSession session=request.getSession();
		if(session != null) {
			userID = (String) session.getAttribute("userID");
		}

		/* Do this when submit button was clicked */
		action = request.getParameter("action");
		if (action != null) {

			System.out.println("Action: " + action);

			/* Do this for creation of new records in TAB */
			if (action.equalsIgnoreCase("crtBuildings")) {

				String buildingName = request.getParameter("buildingName");
				String address = request.getParameter("address");
				String responsibleOffice = request.getParameter("responsibleOffice");
				String client = request.getParameter("client");
				String projectNumber = request.getParameter("projectNumber");
				String buildingInformation = request.getParameter("buildingInformation");
				String csNumber = request.getParameter("csNumber");
				String legalDescription = request.getParameter("legalDescription");
				int maxOccupants = Integer.parseInt(request.getParameter("maxOccupants"));
				String fireHazardCategory = request.getParameter("fireHazardCategory");
				int yearBuilt = Integer.parseInt(request.getParameter("yearBuilt"));
				String intendedLife = request.getParameter("intendedLife");
				int bwofAnniversary = Integer.parseInt(request.getParameter("bwofAnniversary"));
				String asbestosPresent = request.getParameter("asbestosPresent");
				float nbsPercent = Float.parseFloat(request.getParameter("nbsPercent"));

				/* Save values in contacts POJO */
				bHeaderInfo = new BuildingHeader(buildingID, buildingName, address, bHeaderInfo.getLocation(),
						bHeaderInfo.getLevelOrUnitNumber(), bHeaderInfo.getCoordinates(), bHeaderInfo.getOwner(), 
						client, responsibleOffice, projectNumber, buildingInformation, csNumber, legalDescription, maxOccupants,
						fireHazardCategory, yearBuilt, intendedLife, bwofAnniversary, asbestosPresent,
						nbsPercent, userID, today, bHeaderInfo.getModifiedBy(), bHeaderInfo.getModifiedDate(),
						conStatus);

				/* Call Manager to created values from POJO */
				isCreated = new BuildingHeaderMgr().setBuildingHeader(conn, bHeaderInfo);

				if (isCreated > 0) {
					System.out.println("Record is successfully created.");
				} else {
					System.out.println("Record is not created");
				}
			}
		}


		/* Get Building Header by User ID */
		List<BuildingHeader> bHeaderArr = new ArrayList<>();
		bHeaderArr = new BuildingHeaderMgr().getBuildingHeaderByUserId(conn, userID, conStatus);
		userAccount = new UserMgr().getUserAccount(conn, userID, conStatus);

		/* Get Hardcoded values */
		fireHazCatList = new HardCodedData().getFireHazardCategory();
		yesNoList = new HardCodedData().getYesNo();

		/* Get Tabs Authorization */
		genInfoTab = new UserTabMgr().getAdminUserTab(conn, userID, "GenInfo");

		session.setAttribute("userID", userID);
		session.setAttribute("userAccount", userAccount);
		request.setAttribute("bHeaderArr", bHeaderArr);
		request.setAttribute("fireHazCatList", fireHazCatList);
		request.setAttribute("yesNoList", yesNoList);
		request.setAttribute("genInfoTab", genInfoTab);

		/* do redirection */ 
		ServletContext sContext = getServletContext();
		RequestDispatcher rDispatcher = sContext.getRequestDispatcher(newPage);
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding( "UTF-8" ); 
		doGet(request, response);
	}

}
