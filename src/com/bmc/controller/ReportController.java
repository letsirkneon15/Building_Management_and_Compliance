package com.bmc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.bmc.model.DownloadToExcel;
import com.bmc.model.HardCodedData;
import com.bmc.model.ReportsMgr;
import com.bmc.model.UserMgr;
import com.bmc.pojo.BuildingHeader;
import com.bmc.pojo.GenInfoAsbestos;
import com.bmc.pojo.GenInfoHazardSubstance;
import com.bmc.pojo.UserAccount;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Reports")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Context initContext;
	private Context envContext;
	private DataSource dataSource;
	private Connection conn;
	
	private List<BuildingHeader> bGenInfo = new ArrayList<BuildingHeader>();
	private List<GenInfoAsbestos> bGenInfoAsbestos = new ArrayList<GenInfoAsbestos>();
	private List<GenInfoHazardSubstance> bGenInfoHazardSubstance = new ArrayList<GenInfoHazardSubstance>();
	
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
		String newPage = "/Reports.jsp";
		String action = "";
		String userID = "";
		String buildingName="";
		String client = "";
		String asbestosPresent ="";
		String reportFormat = "";
		Boolean isDownloaded = false;
		String button = "";
		String conStatus = "";
		
		UserAccount userAccount = new UserAccount();
		ArrayList<String> yesNoList = new ArrayList<String>();
		ArrayList<String> reportFormatList = new ArrayList<String>();
		
		response.setContentType("text/html"); 
		request.getRequestDispatcher(newPage).include(request, response);  
		
		/* Retrieve session */
		HttpSession session=request.getSession();
		if(session != null) {
			userID = (String) session.getAttribute("userID");
		}
		
		yesNoList = new HardCodedData().getYesNo();
		reportFormatList = new HardCodedData().getReportFormat();
		
		/* Do this when submit button was clicked */
		action = request.getParameter("action");
		
		if(action != null){
			
			buildingName = request.getParameter("buildingName");
			client = request.getParameter("client");
			asbestosPresent = request.getParameter("asbestosPresent");
			reportFormat = request.getParameter("reportFormat");
			button = request.getParameter("button");
			
			System.out.println("buildingName: " + buildingName + "client: " + client + 
					" asbestosPresent: " + asbestosPresent + " reportFormat: " + reportFormat);
			
			if(action.equalsIgnoreCase("preview")) {
				
				getData(userID, buildingName, client, asbestosPresent, reportFormat);
				
			}else if(action.equalsIgnoreCase("download")) {
				
				getData(userID, buildingName, client, asbestosPresent, reportFormat);
			
				/* Call Java Class to Create Excel File */
				switch(reportFormat) {
				case "Building General Information":
					isDownloaded = new DownloadToExcel().createGenFile(userID, reportFormat, bGenInfo);
					break;
					
				case "BWOF Anniversary Current vs Expired":
					isDownloaded = new DownloadToExcel().createGenFile(userID, reportFormat, bGenInfo);
					break;
				
				case "Asbestos":
					isDownloaded = new DownloadToExcel().createGenFileAsbestos(userID, reportFormat, bGenInfoAsbestos);
					break;
					
				case "Hazardous Substance":
					isDownloaded = new DownloadToExcel().createGenFileHazardSubstance(userID, reportFormat, bGenInfoHazardSubstance);
					break;
				
				}
			}
		}
		
		getData(userID, buildingName, client, asbestosPresent, reportFormat);
		
		/* Get User Account by User ID */
		userAccount = new UserMgr().getUserAccount(conn, userID, conStatus);
		
		session.setAttribute("userID", userID);
		session.setAttribute("userAccount", userAccount);
		request.setAttribute("yesNoList", yesNoList);
		request.setAttribute("reportFormatList", reportFormatList);
		request.setAttribute("bGenInfo", bGenInfo);
		request.setAttribute("bGenInfoAsbestos", bGenInfoAsbestos);
		request.setAttribute("bGenInfoHazardSubstance", bGenInfoHazardSubstance);
		request.setAttribute("reportFormat", reportFormat);
		request.setAttribute("buildingName", buildingName);
		request.setAttribute("client", client);
		request.setAttribute("asbestosPresent", asbestosPresent);
		request.setAttribute("isDownloaded", isDownloaded);
		request.setAttribute("button", button);
		
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
	
	private void getData(String userID, String buildingName, String client, String asbestosPresent, String reportFormat) {
		String conStatus = "";
		int todayYear = Calendar.getInstance().get(Calendar.YEAR);
		
		switch(reportFormat) {
		case "Building General Information":
			bGenInfo = new ReportsMgr().getGeneralInformation(conn, userID, conStatus, buildingName, client, 
					asbestosPresent);
			break;
			
		case "BWOF Anniversary Current vs Expired":
			bGenInfo = new ReportsMgr().getBWOFAnniversary(conn, userID, conStatus, buildingName, client, 
					asbestosPresent, todayYear);
			break;
		
		case "Asbestos":
			bGenInfoAsbestos = new ReportsMgr().getGeneralInformationAsbestos(conn, userID, conStatus, buildingName, client, 
					asbestosPresent);
			break;
			
		case "Hazardous Substance":
			bGenInfoHazardSubstance = new ReportsMgr().getGeneralInformationHazardSubstance(conn, userID, conStatus, 
					buildingName, client, asbestosPresent);
		
		}
	}

}
