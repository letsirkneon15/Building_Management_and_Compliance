package com.bmc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.bmc.model.BuildingDetailsMgr;
import com.bmc.model.BuildingHeaderMgr;
import com.bmc.model.ComplianceInspectionMgr;
import com.bmc.model.ContactsMgr;
import com.bmc.model.HazardRegisterMgr;
import com.bmc.model.HazardousSubstanceMgr;
import com.bmc.pojo.BuildingDetails;
import com.bmc.pojo.BuildingHeader;
import com.bmc.pojo.ComplianceInspection;
import com.bmc.pojo.Contacts;
import com.bmc.pojo.HazardRegister;
import com.bmc.pojo.HazardousSubstance;

/**
 * Servlet implementation class TabController
 */
@WebServlet("/Tabs")
public class TabController extends HttpServlet {
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
		String newPage = "/TabContents.jsp";
		int buildingID = 0;
		String action = "";
		BuildingHeader bHeader = new BuildingHeader();
		List<BuildingDetails> bDetails = new ArrayList<BuildingDetails>();
		List<Contacts> contactsArr = new ArrayList<Contacts>();
		List<ComplianceInspection> complianceInspectionArr = new ArrayList<ComplianceInspection>();
		List<HazardousSubstance> hazSubstancesArr = new ArrayList<HazardousSubstance>();
		List<HazardRegister> hazRegisterArr = new ArrayList<HazardRegister>();
		List<BuildingDetails> buildingWOFArr = new ArrayList<BuildingDetails>();
		List<BuildingDetails> buildingConsentArr = new ArrayList<BuildingDetails>();
		List<BuildingDetails> asbestosArr = new ArrayList<BuildingDetails>();
		List<BuildingDetails> electricalArr = new ArrayList<BuildingDetails>();
		List<BuildingDetails> gasArr = new ArrayList<BuildingDetails>();
		List<BuildingDetails> seismicArr = new ArrayList<BuildingDetails>();
		List<BuildingDetails> resourceConsentArr = new ArrayList<BuildingDetails>();
		
		/* Retrieve session values from BuildingHeader */
		HttpSession session=request.getSession();
		if(session != null){	
			//buildingID = (int) request.getAttribute("buildingID");
		}
		
		/* Do this when submit button was clicked */
		action = request.getParameter("action");
		if(action != null){
			
			System.out.println("Action: " + action);
			if(action.equalsIgnoreCase("tabContents")){
				buildingID = Integer.parseInt(request.getParameter("buildingID"));
				
				/* Get Building Header by buildingID */
				bHeader = new BuildingHeaderMgr().getBuildingHeaderByBuildingID(conn, buildingID);
				
				/* Get Contacts by buildingID */
				contactsArr = new ContactsMgr().getContacts(conn, buildingID);
				
				/*Get Building Details */
				bDetails = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, "");
				
				/*Get Compliance Inspection */
				complianceInspectionArr = new ComplianceInspectionMgr().getComplianceInspection(conn, buildingID);
				
				/*Get Hazardous Substances */
				hazSubstancesArr = new HazardousSubstanceMgr().getHazardousSubstance(conn, buildingID);
				
				/*Get Hazard Register */
				hazRegisterArr = new HazardRegisterMgr().getHazardRegister(conn, buildingID);
				
				/*Get Building WOF from Building_Details table */
				buildingWOFArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, "WOF");
				
				/*Get Building Consent from Building_Details table */
				buildingConsentArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, "Consent");
				
				/*Get Asbestos from Building_Details table */
				asbestosArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, "Asbestos");
				
				/*Get Electrical from Building_Details table */
				electricalArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, "Electrical");
				
				/*Get Gas from Building_Details table */
				gasArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, "Gas");
				
				/*Get Seismic Resilience from Building_Details table */
				seismicArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, "Seismic");
				
				/*Get Resource Consent from Building_Details table */
				resourceConsentArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, "Resource Consent");
				
			}
		}
		
		session.setAttribute("bHeader", bHeader);
		session.setAttribute("contactsArr", contactsArr);
		session.setAttribute("bDetails", bDetails);
		session.setAttribute("complianceInspectionArr", complianceInspectionArr);
		session.setAttribute("hazSubstancesArr", hazSubstancesArr);
		session.setAttribute("hazRegisterArr", hazRegisterArr);
		session.setAttribute("buildingWOFArr", buildingWOFArr);
		session.setAttribute("buildingConsentArr", buildingConsentArr);
		session.setAttribute("asbestosArr", asbestosArr);
		session.setAttribute("electricalArr", electricalArr);
		session.setAttribute("gasArr", gasArr);
		session.setAttribute("seismicArr", seismicArr);
		session.setAttribute("resourceConsentArr", resourceConsentArr);
		
		
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
