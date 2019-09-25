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
		String tabName="";
		String userID = "";
		int isUpdated = 0;
		int setStatus = 0;
		boolean isCreated = false;
		String conContacts = "Contacts";
		String conWOF = "WOF";
		String conConsent = "Consent";
		String conAsbestos = "Asbestos";
		String conElectrical = "Electrical";
		String conGas = "Gas";
		String conHazardSubstance = "HazSubs";
		String conHazardRegister = "HazReg";
		String conSeismic = "Seismic";
		String conResourceConsent = "Resource Consent";
		String conComplianceInspection = "ComIns";
		
		
		
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
		
		BuildingDetails buildDetails = new BuildingDetails();
		Contacts contacts = new Contacts();
		ComplianceInspection comInspection = new ComplianceInspection();
		HazardousSubstance hazardSub = new HazardousSubstance();
		HazardRegister hazardReg = new HazardRegister();

		/* Get Today's date */
		Date today = Calendar.getInstance().getTime();
		
		
		/* Retrieve session values from BuildingHeader */
		HttpSession session=request.getSession();
		if(session != null){	
			//buildingID = (int) request.getAttribute("buildingID");
		}
		
		/* Do this when submit button was clicked */
		action = request.getParameter("action");
		if(action != null){
			
			System.out.println("Action: " + action);
			
			/* Display Tab Contents */
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
				buildingWOFArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conWOF);
				
				/*Get Building Consent from Building_Details table */
				buildingConsentArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conConsent);
				
				/*Get Asbestos from Building_Details table */
				asbestosArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conAsbestos);
				
				/*Get Electrical from Building_Details table */
				electricalArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conElectrical);
				
				/*Get Gas from Building_Details table */
				gasArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conGas);
				
				/*Get Seismic Resilience from Building_Details table */
				seismicArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conSeismic);
				
				/*Get Resource Consent from Building_Details table */
				resourceConsentArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conResourceConsent);
			
			/* Do this for updating of TAB records */
			}else if(action.equalsIgnoreCase("editTabs")){
				
				tabName = request.getParameter("tab");
				
				switch(tabName){
				
					case "Contacts":
						int edtCRecordID = Integer.parseInt(request.getParameter("edtCRecordID"));
					    int edtCBuildingID = Integer.parseInt(request.getParameter("edtCBuildingID"));
					    String edtCName = request.getParameter("edtCName");
					    String edtCType = request.getParameter("edtCType");
					    String edtCCompany = request.getParameter("edtCCompany");
					    String edtCPhoneNumber = request.getParameter("edtCPhoneNumber");
					    String edtCFaxNumber = request.getParameter("edtCFaxNumber");
					    String edtCMobileNumber = request.getParameter("edtCMobileNumber");
					    String edtCEmailAdd = request.getParameter("edtCEmailAdd");
					    
					    /* Save values in contacts POJO */
					    contacts = new Contacts(edtCRecordID, edtCBuildingID, edtCName, edtCType, edtCCompany, 
					    		edtCPhoneNumber, edtCFaxNumber, edtCMobileNumber, edtCEmailAdd, contacts.getCreatedBy(), 
					    		contacts.getCreationDate(), userID, today, contacts.getStatus());
					    
					    /* Call Manager to edit values from POJO */
					    isUpdated = new ContactsMgr().updateContacts(conn, contacts);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;
					    
					case "WOF":
						int edtWRecordID = Integer.parseInt(request.getParameter("edtWRecordID"));
					    int edtWBuildingID = Integer.parseInt(request.getParameter("edtWBuildingID"));
						String edtWName = request.getParameter("edtWName");
						int edtWTitledYear = Integer.parseInt(request.getParameter("edtWTitledYear"));
						String edtWAttachment = request.getParameter("edtWAttachment");
						String edtWType = request.getParameter("edtWType");
						
						/* Save values in BuildingDetails POJO */
						buildDetails = new BuildingDetails(edtWRecordID, conWOF, edtWBuildingID, edtWName, 
								edtWAttachment, edtWType, edtWTitledYear, buildDetails.getConsentNumber(), 
								buildDetails.getUploadedBy(), buildDetails.getUploadedDate(), userID, 
								today, buildDetails.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;
					    
					case "Consent":
						int edtCSRecordID = Integer.parseInt(request.getParameter("edtCSRecordID"));
					    int edtCSBuildingID = Integer.parseInt(request.getParameter("edtCSBuildingID"));
						String edtCSName = request.getParameter("edtCSName");
						String edtCSConsentNumber = request.getParameter("edtCSConsentNumber");
						String edtCSAttachment = request.getParameter("edtCSAttachment");
						String edtCSType = request.getParameter("edtCSType");
						String edtCSLastUploadedBy = userID;
						
						/* Save values in BuildingDetails POJO */
						buildDetails = new BuildingDetails(edtCSRecordID, conConsent, edtCSBuildingID, edtCSName, 
								edtCSAttachment, edtCSType, buildDetails.getTitledYear(), 
								edtCSConsentNumber, buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
								edtCSLastUploadedBy, today, buildDetails.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;
				
					case "Asbestos":
						int edtARecordID = Integer.parseInt(request.getParameter("edtARecordID"));
					    int edtABuildingID = Integer.parseInt(request.getParameter("edtABuildingID"));
						String edtAName = request.getParameter("edtAName");
						String edtAAttachment = request.getParameter("edtAAttachment");
						String edtAType = request.getParameter("edtAType");
						
						/* Save values in BuildingDetails POJO */
						buildDetails = new BuildingDetails(edtARecordID, conAsbestos, edtABuildingID, edtAName, 
								edtAAttachment, edtAType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(), 
								buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
								userID, today, buildDetails.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;
					    
					case "Electrical":
						int edtERecordID = Integer.parseInt(request.getParameter("edtERecordID"));
					    int edtEBuildingID = Integer.parseInt(request.getParameter("edtEBuildingID"));
						String edtEName = request.getParameter("edtEName");
						String edtEAttachment = request.getParameter("edtEAttachment");
						String edtEType = request.getParameter("edtEType");
						String edtELastUploadedBy = userID;
						
						/* Save values in BuildingDetails POJO */
						buildDetails = new BuildingDetails(edtERecordID, conElectrical, edtEBuildingID, edtEName, 
								edtEAttachment, edtEType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(), 
								buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
								edtELastUploadedBy, today, buildDetails.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;	    
					    
					case "Gas":
						int edtGRecordID = Integer.parseInt(request.getParameter("edtGRecordID"));
					    int edtGBuildingID = Integer.parseInt(request.getParameter("edtGBuildingID"));
						String edtGName = request.getParameter("edtGName");
						String edtGAttachment = request.getParameter("edtGAttachment");
						String edtGType = request.getParameter("edtGType");
						
						/* Save values in BuildingDetails POJO */
						buildDetails = new BuildingDetails(edtGRecordID, conGas, edtGBuildingID, edtGName, 
								edtGAttachment, edtGType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(), 
								buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
								userID, today, buildDetails.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;	
					    
					case "HazSubs":
						  int edtHSRecordID = Integer.parseInt(request.getParameter("edtHSRecordID"));
						  int edtHSBuildingID = Integer.parseInt(request.getParameter("edtHSBuildingID"));
						  String edtHSProductName = request.getParameter("edtHSProductName");
						  String edtHSUnNumber = request.getParameter("edtHSUnNumber");
						  String edtHSApprovalNumber = request.getParameter("edtHSApprovalNumber");
						  String edtHSGroupStandard = request.getParameter("edtHSGroupStandard");
						  String edtHSHazardClassification = request.getParameter("edtHSHazardClassification");
						  String edtHSCurrentSDSAvailable = request.getParameter("edtHSCurrentSDSAvailable");
						  String edtHSSpecificStorage = request.getParameter("edtHSSpecificStorage");
						  String edtHSSegregationRequirements = request.getParameter("edtHSSegregationRequirements");
						  String edtHSContainerSize = request.getParameter("edtHSContainerSize");
						  String edtHSOpenCloseContainer = request.getParameter("edtHSOpenCloseContainer");
						  String edtHSGasLiquidSolid = request.getParameter("edtHSGasLiquidSolid");
						  String edtHSLocation = request.getParameter("edtHSLocation");
						  int edtHSMaximumLikelyAmount = Integer.parseInt(request.getParameter("edtHSMaximumLikelyAmount"));
						
						/* Save values in HazardousSubstance POJO */
						  hazardSub = new HazardousSubstance(edtHSRecordID, edtHSBuildingID, edtHSProductName, edtHSUnNumber, 
								edtHSApprovalNumber, edtHSGroupStandard, edtHSHazardClassification, edtHSCurrentSDSAvailable, 
								edtHSSpecificStorage, edtHSSegregationRequirements, edtHSContainerSize, edtHSOpenCloseContainer, 
								edtHSGasLiquidSolid, edtHSLocation, edtHSMaximumLikelyAmount, hazardSub.getCreatedBy(), 
								hazardSub.getCreatedDate(), userID, today, hazardSub.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new HazardousSubstanceMgr().updateHazardousSubstance(conn, hazardSub);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;
					    
					case "HazReg":
						int edtHRRecordID = Integer.parseInt(request.getParameter("edtHRRecordID"));
					    int edtHRBuildingID = Integer.parseInt(request.getParameter("edtHRBuildingID"));
					    String edtHRIdentifiedHazard = request.getParameter("edtHRIdentifiedHazard");
					    String edtHRInitialRiskAssessment = request.getParameter("edtHRInitialRiskAssessment");
					    String edtHRControls = request.getParameter("edtHRControls");
					    String edtHRLevelOfControl = request.getParameter("edtHRLevelOfControl");
					    String edtHRResidualRiskAssessment = request.getParameter("edtHRResidualRiskAssessment");
					    
						/* Save values in HazardRegister POJO */
						hazardReg = new HazardRegister(edtHRRecordID, edtHRBuildingID, edtHRIdentifiedHazard, 
								edtHRInitialRiskAssessment, edtHRControls, edtHRLevelOfControl, edtHRResidualRiskAssessment, 
								hazardReg.getCreatedBy(), hazardReg.getCreationDate(),
								userID, today, hazardReg.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new HazardRegisterMgr().updateHazardRegister(conn, hazardReg);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;	    
					    
					case "Seismic":
						int edtSRRecordID = Integer.parseInt(request.getParameter("edtSRRecordID"));
					    int edtSRBuildingID = Integer.parseInt(request.getParameter("edtSRBuildingID"));
						String edtSRName = request.getParameter("edtSRName");
						String edtSRAttachment = request.getParameter("edtSRAttachment");
						String edtSRType = request.getParameter("edtSRType");
						
						/* Save values in BuildingDetails POJO */
						buildDetails = new BuildingDetails(edtSRRecordID, conSeismic, edtSRBuildingID, edtSRName, 
								edtSRAttachment, edtSRType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(), 
								buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
								userID, today, buildDetails.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;	    
					    
					case "ResourceConsent":
						int edtRCRecordID = Integer.parseInt(request.getParameter("edtRCRecordID"));
					    int edtRCBuildingID = Integer.parseInt(request.getParameter("edtRCBuildingID"));
						String edtRCName = request.getParameter("edtRCName");
						String edtRCAttachment = request.getParameter("edtRCAttachment");
						String edtRCType = request.getParameter("edtRCType");
						
						/* Save values in BuildingDetails POJO */
						buildDetails = new BuildingDetails(edtRCRecordID, conResourceConsent, edtRCBuildingID, edtRCName, 
								edtRCAttachment, edtRCType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(), 
								buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
								userID, today, buildDetails.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;	
					    
					case "ComIns":
						
						int edtCIRecordID = Integer.parseInt(request.getParameter("edtCIRecordID"));
					    int edtCIBuildingID = Integer.parseInt(request.getParameter("edtCIBuildingID"));
						//Date edtCIInspectionDate = (java.sql.Date)(request.getParameter("edtCIInspectionDate"));
					    Date edtCIInspectionDate=null;
						String edtCIFinding = request.getParameter("edtCIFinding");
						String edtCIDescription = request.getParameter("edtCIDescription");
						String edtCIInspectionStat = request.getParameter("edtCIInspectionStat");
						String edtCIImage = request.getParameter("edtCIImage");
						
						/* Save values in Compliance Inspection POJO */
						comInspection = new ComplianceInspection(edtCIRecordID, edtCIBuildingID, edtCIInspectionDate, 
								edtCIFinding, edtCIDescription, edtCIInspectionStat, edtCIImage, 
								comInspection.getCreatedBy(), comInspection.getCreationDate(),
								userID, today, comInspection.getStatus());
						
						/* Call Manager to edit values from POJO */
					    isUpdated = new ComplianceInspectionMgr().updateComplianceInspection(conn, comInspection);
					    
					    if(isUpdated > 0) {
					    	System.out.println("Record is successfully updated.");
					    }else {
					    	System.out.println("Record is not updated");
					    }
					    break;	
				}
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
