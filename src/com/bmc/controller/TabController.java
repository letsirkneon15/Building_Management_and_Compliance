package com.bmc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import com.bmc.model.HardCodedData;
import com.bmc.model.HazardRegisterMgr;
import com.bmc.model.HazardousSubstanceMgr;
import com.bmc.model.UserMgr;
import com.bmc.model.UserTabMgr;
import com.bmc.pojo.AdminUserTab;
import com.bmc.pojo.BuildingDetails;
import com.bmc.pojo.BuildingHeader;
import com.bmc.pojo.ComplianceInspection;
import com.bmc.pojo.Contacts;
import com.bmc.pojo.HazardRegister;
import com.bmc.pojo.HazardousSubstance;
import com.bmc.pojo.UserAccount;

/**
 * Servlet implementation class TabController
 */
@WebServlet("/Tabs")
@MultipartConfig
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
        try {
            initContext = new InitialContext();
            envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/Project");
            conn = dataSource.getConnection();
            System.out.println("Connection: " + conn);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String newPage = "/TabContents.jsp";
        int buildingID = 0;
        String action = "";
        String tabName = "";
        String userID = "";
        int isUpdated = 0;
        int isSetStatus = 0;
        int isCreated = 0;
        String conWOF = "WOF";
        String conConsent = "Consent";
        String conAsbestos = "Asbestos";
        String conElectrical = "Electrical";
        String conGas = "Gas";
        String conSeismic = "Seismic";
        String conResourceConsent = "Resource Consent";
        String conD = "D";
        String conFire = "Fire";
        String conStatus="";
        String attachment = "";

        UserAccount userAccount = new UserAccount();
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
        List<BuildingDetails> fireArr = new ArrayList<BuildingDetails>();
        
		ArrayList<String> cTypeList = new ArrayList<String>(); 
		ArrayList<String> wTypeList = new ArrayList<String>();
		ArrayList<String> csTypeList = new ArrayList<String>();
		ArrayList<String> aTypeList = new ArrayList<String>();
		ArrayList<String> eTypeList = new ArrayList<String>();
		ArrayList<String> gTypeList = new ArrayList<String>();
		ArrayList<String> hrRiskAssessList = new ArrayList<String>();
		ArrayList<String> sTypeList = new ArrayList<String>();
		ArrayList<String> rcTypeList = new ArrayList<String>();
		ArrayList<String> yesNoList = new ArrayList<String>();
		ArrayList<String> fTypeList = new ArrayList<String>();
		ArrayList<String> levelOfControlsList = new ArrayList<String>();
		ArrayList<String> fireHazCatList = new ArrayList<String>();
		
		BuildingHeader bHeaderInfo = new BuildingHeader();
        BuildingDetails buildDetails = new BuildingDetails();
        Contacts contacts = new Contacts();
        ComplianceInspection comInspection = new ComplianceInspection();
        HazardousSubstance hazardSub = new HazardousSubstance();
        HazardRegister hazardReg = new HazardRegister();
        AdminUserTab genInfoTab = new AdminUserTab();
        AdminUserTab contactsTab = new AdminUserTab();
        AdminUserTab wofTab = new AdminUserTab();
        AdminUserTab consentTab = new AdminUserTab();
        AdminUserTab asbestosTab = new AdminUserTab();
        AdminUserTab electricalTab = new AdminUserTab();
        AdminUserTab gasTab = new AdminUserTab();
        AdminUserTab fireTab = new AdminUserTab();
        AdminUserTab hazSubsTab = new AdminUserTab();
        AdminUserTab hazRegTab = new AdminUserTab();
        AdminUserTab seismicTab = new AdminUserTab();
        AdminUserTab resourceConsentTab = new AdminUserTab();
        AdminUserTab comInsTab = new AdminUserTab();
        

        /* Get Today's date */
        Date todayUtil = Calendar.getInstance().getTime();
        System.out.println("today :" + todayUtil);
        java.sql.Date today = new java.sql.Date(todayUtil.getTime());
        System.out.println("sqlDate :" + today);

        /* Retrieve session values from BuildingHeader */
        HttpSession session = request.getSession();
        if (session != null) {
            userID = (String) session.getAttribute("userID");
        }
        
		/* Get Type/Assessment - Item List */
		cTypeList = new HardCodedData().getTypeContacts();
		wTypeList = new HardCodedData().getTypeWof();
		csTypeList = new HardCodedData().getTypeConsent();
		aTypeList = new HardCodedData().getTypeAsbestos();
		eTypeList = new HardCodedData().getTypeElectrical();
		gTypeList = new HardCodedData().getTypeGas();
		hrRiskAssessList = new HardCodedData().getAssessmentHazRegister();
		sTypeList = new HardCodedData().getTypeSeismic();
		rcTypeList = new HardCodedData().getTypeResource();
		yesNoList = new HardCodedData().getYesNo();
		fTypeList = new HardCodedData().getTypeFire();
		levelOfControlsList = new HardCodedData().getLevelOfControls();
		fireHazCatList = new HardCodedData().getFireHazardCategory();
		
        /* Do this when submit button was clicked */
        action = request.getParameter("action");
        if (action != null) {

        	buildingID = Integer.parseInt(request.getParameter("buildingID"));
      
            System.out.println("Action: " + action);

            /* Do this for creation of new records in TAB */
            if (action.equalsIgnoreCase("crtTabs")) {

                tabName = request.getParameter("tab");

                switch (tabName) {

                    case "Contacts":
                        String crtCName = request.getParameter("crtCName");
                        String crtCType = request.getParameter("crtCType");
                        String crtCCompany = request.getParameter("crtCCompany");
                        String crtCPhoneNumber = request.getParameter("crtCPhoneNumber");
                        String crtCFaxNumber = request.getParameter("crtCFaxNumber");
                        String crtCMobileNumber = request.getParameter("crtCMobileNumber");
                        String crtCEmailAdd = request.getParameter("crtCEmailAdd");

                        /* Save values in contacts POJO */
                        contacts = new Contacts(contacts.getRecordID(), buildingID, crtCName, crtCType, crtCCompany,
                                crtCPhoneNumber, crtCFaxNumber, crtCMobileNumber, crtCEmailAdd, userID,
                                today, contacts.getModifiedBy(), contacts.getModifiedDate(), "");

                        /* Call Manager to create values from POJO */
                        isCreated = new ContactsMgr().setContacts(conn, contacts);
                        System.out.println("isCreated:" + isCreated);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "WOF":
                        String crtWName = request.getParameter("crtWName");
                        int crtWTitledYear = Integer.parseInt(request.getParameter("crtWTitledYear"));
                        String crtWAttachment = request.getParameter("crtWAttachment");
                        String crtWType = request.getParameter("crtWType");

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(buildDetails.getRecordID(), conWOF, buildingID, crtWName,
                                crtWAttachment, crtWType, crtWTitledYear, buildDetails.getConsentNumber(),
                                userID, today, buildDetails.getLastUploadedBy(), buildDetails.getLastUploadedDate(),
                                "");

                        /* Call Manager to created values from POJO */
                        isCreated = new BuildingDetailsMgr().setBuildingDetails(conn, buildDetails);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "Consent":
                        String crtCSName = request.getParameter("crtCSName");
                        String crtCSConsentNumber = request.getParameter("crtCSConsentNumber");
                        String crtCSAttachment = request.getParameter("crtCSAttachment");
                        String crtCSType = request.getParameter("crtCSType");

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(buildDetails.getRecordID(), conConsent, buildingID, crtCSName,
                                crtCSAttachment, crtCSType, buildDetails.getTitledYear(),
                                crtCSConsentNumber, userID, today, buildDetails.getLastUploadedBy(),
                                buildDetails.getLastUploadedDate(), "");

                        /* Call Manager to create values from POJO */
                        isCreated = new BuildingDetailsMgr().setBuildingDetails(conn, buildDetails);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "Asbestos":
                        String crtAName = request.getParameter("crtAName");
                        String crtAAttachment = request.getParameter("crtAAttachment");
                        String crtAType = request.getParameter("crtAType");

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(buildDetails.getRecordID(), conAsbestos, buildingID, crtAName,
                                crtAAttachment, crtAType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                userID, today, buildDetails.getLastUploadedBy(), buildDetails.getLastUploadedDate(),
                                "");

                        /* Call Manager to created values from POJO */
                        isCreated = new BuildingDetailsMgr().setBuildingDetails(conn, buildDetails);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "Electrical":
                        String crtEName = request.getParameter("crtEName");
                        String crtEAttachment = request.getParameter("crtEAttachment");
                        String crtEType = request.getParameter("crtEType");

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(buildDetails.getRecordID(), conElectrical, buildingID, crtEName,
                                crtEAttachment, crtEType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                userID, today, buildDetails.getLastUploadedBy(), buildDetails.getLastUploadedDate(),
                                "");

                        /* Call Manager to create values from POJO */
                        isCreated = new BuildingDetailsMgr().setBuildingDetails(conn, buildDetails);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "Gas":
                        String crtGName = request.getParameter("crtGName");
                        String crtGAttachment = request.getParameter("crtGAttachment");
                        String crtGType = request.getParameter("crtGType");

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(buildDetails.getRecordID(), conGas, buildingID, crtGName,
                                crtGAttachment, crtGType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                userID, today, buildDetails.getLastUploadedBy(), buildDetails.getLastUploadedDate(),
                                "");

                        /* Call Manager to create values from POJO */
                        isCreated = new BuildingDetailsMgr().setBuildingDetails(conn, buildDetails);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "Fire":
                        String crtFName = request.getParameter("crtFName");
                        String crtFAttachment = request.getParameter("crtFAttachment");
                        String crtFType = request.getParameter("crtFType");

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(buildDetails.getRecordID(), conFire, buildingID, crtFName,
                                crtFAttachment, crtFType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                userID, today, buildDetails.getLastUploadedBy(), buildDetails.getLastUploadedDate(),
                                "");

                        /* Call Manager to create values from POJO */
                        isCreated = new BuildingDetailsMgr().setBuildingDetails(conn, buildDetails);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "HazSubs":
                        String crtHSProductName = request.getParameter("crtHSProductName");
                        String crtHSUnNumber = request.getParameter("crtHSUnNumber");
                        String crtHSApprovalNumber = request.getParameter("crtHSApprovalNumber");
                        String crtHSGroupStandard = request.getParameter("crtHSGroupStandard");
                        String crtHSHazardClassification = request.getParameter("crtHSHazardClassification");
                        String crtHSCurrentSDSAvailable = request.getParameter("crtHSCurrentSDSAvailable");
                        String crtHSSpecificStorage = request.getParameter("crtHSSpecificStorage");
                        String crtHSSegregationRequirements = request.getParameter("crtHSSegregationRequirements");
                        String crtHSContainerSize = request.getParameter("crtHSContainerSize");
                        String crtHSOpenCloseContainer = request.getParameter("crtHSOpenCloseContainer");
                        String crtHSGasLiquidSolid = request.getParameter("crtHSGasLiquidSolid");
                        String crtHSLocation = request.getParameter("crtHSLocation");
                        int crtHSMaximumLikelyAmount = Integer.parseInt(request.getParameter("crtHSMaximumLikelyAmount"));

                        /* Save values in HazardousSubstance POJO */
                        hazardSub = new HazardousSubstance(hazardSub.getRecordID(), buildingID, crtHSProductName, crtHSUnNumber,
                                crtHSApprovalNumber, crtHSGroupStandard, crtHSHazardClassification, crtHSCurrentSDSAvailable,
                                crtHSSpecificStorage, crtHSSegregationRequirements, crtHSContainerSize, crtHSOpenCloseContainer,
                                crtHSGasLiquidSolid, crtHSLocation, crtHSMaximumLikelyAmount, userID,
                                today, hazardSub.getModifiedBy(), hazardSub.getModifiedDate(), "");

                        /* Call Manager to create values from POJO */
                        isCreated = new HazardousSubstanceMgr().setHazardousSubstance(conn, hazardSub);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "HazReg":
                        String crtHRIdentifiedHazard = request.getParameter("crtHRIdentifiedHazard");
                        String crtHRInitialRiskAssessment = request.getParameter("crtHRInitialRiskAssessment");
                        String crtHRControls = request.getParameter("crtHRControls");
                        String crtHRLevelOfControl = request.getParameter("crtHRLevelOfControl");
                        String crtHRResidualRiskAssessment = request.getParameter("crtHRResidualRiskAssessment");

                        /* Save values in HazardRegister POJO */
                        hazardReg = new HazardRegister(hazardReg.getRecordID(), buildingID, crtHRIdentifiedHazard,
                                crtHRInitialRiskAssessment, crtHRControls, crtHRLevelOfControl, crtHRResidualRiskAssessment,
                                userID, today, hazardReg.getModifiedBy(), hazardReg.getModifiedDate(), "");

                        /* Call Manager to create values from POJO */
                        isCreated = new HazardRegisterMgr().setHazardRegister(conn, hazardReg);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "Seismic":
                        String crtSRName = request.getParameter("crtSRName");
                        String crtSRAttachment = request.getParameter("crtSRAttachment");
                        String crtSRType = request.getParameter("crtSRType");

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(buildDetails.getRecordID(), conSeismic, buildingID, crtSRName,
                                crtSRAttachment, crtSRType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                userID, today, buildDetails.getLastUploadedBy(), buildDetails.getLastUploadedDate(),
                                "");

                        /* Call Manager to create values from POJO */
                        isCreated = new BuildingDetailsMgr().setBuildingDetails(conn, buildDetails);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "ResourceConsent":
                        String crtRCName = request.getParameter("crtRCName");
                        String crtRCAttachment = request.getParameter("crtRCAttachment");
                        String crtRCType = request.getParameter("crtRCType");

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(buildDetails.getRecordID(), conResourceConsent, buildingID, crtRCName,
                                crtRCAttachment, crtRCType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                userID, today, buildDetails.getLastUploadedBy(), buildDetails.getLastUploadedDate(),
                                "");

                        /* Call Manager to create values from POJO */
                        isCreated = new BuildingDetailsMgr().setBuildingDetails(conn, buildDetails);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;

                    case "ComIns":

                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
                        String inspectionDateStr = request.getParameter("crtCIInspectionDate").replaceAll("-", "");
                        System.out.println("inspectionDateStr: " + inspectionDateStr);
                        Date inspectionDate = null;
                        try {
                            inspectionDate = sdf1.parse(inspectionDateStr);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("inspectionDate:" + inspectionDate);
                        java.sql.Date crtCIInspectionDate = new java.sql.Date(inspectionDate.getTime());
                        System.out.println("edtCIInspectionDate: " + crtCIInspectionDate);

                        String crtCIFinding = request.getParameter("crtCIFinding");
                        String crtCIDescription = request.getParameter("crtCIDescription");
                        String crtCIInspectionStat = request.getParameter("crtCIInspectionStat");
                        String crtCIImage = request.getParameter("crtCIImage");

                        /* Save values in Compliance Inspection POJO */
                        comInspection = new ComplianceInspection(comInspection.getRecordID(), buildingID, crtCIInspectionDate,
                                crtCIFinding, crtCIDescription, crtCIInspectionStat, crtCIImage,
                                userID, today, comInspection.getModifiedBy(), comInspection.getModifiedDate(),
                                "");

                        /* Call Manager to create values from POJO */
                        isCreated = new ComplianceInspectionMgr().setComplianceInspection(conn, comInspection);

                        if (isCreated > 0) {
                            System.out.println("Record is successfully created.");
                        } else {
                            System.out.println("Record is not created");
                        }
                        break;
                }

                /* Do this for updating of TAB records */
            } else if (action.equalsIgnoreCase("editTabs")) {

                tabName = request.getParameter("tab");

                switch (tabName) {
                
                	case "GenInfo":
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
                				bHeaderInfo.getLevelOrUnitNumber(), bHeader.getCoordinates(), bHeaderInfo.getOwner(), 
                				client, responsibleOffice, projectNumber, buildingInformation, csNumber, legalDescription, maxOccupants,
                				fireHazardCategory, yearBuilt, intendedLife, bwofAnniversary, asbestosPresent,
                				nbsPercent, bHeaderInfo.getCreatedBy(), bHeaderInfo.getCreationDate(), userID, today,
                				conStatus);
                		
                		/* Call Manager to edit values from POJO */
                        isUpdated = new BuildingHeaderMgr().updateBuildingHeader(conn, bHeaderInfo);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                		
                		break;

                    case "Contacts":
                        int edtCRecordID = Integer.parseInt(request.getParameter("edtCRecordID"));
                        String edtCName = request.getParameter("edtCName");
                        String edtCType = request.getParameter("edtCType");
                        String edtCCompany = request.getParameter("edtCCompany");
                        String edtCPhoneNumber = request.getParameter("edtCPhoneNumber");
                        String edtCFaxNumber = request.getParameter("edtCFaxNumber");
                        String edtCMobileNumber = request.getParameter("edtCMobileNumber");
                        String edtCEmailAdd = request.getParameter("edtCEmailAdd");

                        /* Save values in contacts POJO */
                        contacts = new Contacts(edtCRecordID, buildingID, edtCName, edtCType, edtCCompany,
                                edtCPhoneNumber, edtCFaxNumber, edtCMobileNumber, edtCEmailAdd, contacts.getCreatedBy(),
                                contacts.getCreationDate(), userID, today, contacts.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new ContactsMgr().updateContacts(conn, contacts);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;

                    case "WOF":
                        int edtWRecordID = Integer.parseInt(request.getParameter("edtWRecordID"));
                        String edtWName = request.getParameter("edtWName");
                        int edtWTitledYear = Integer.parseInt(request.getParameter("edtWTitledYear"));
                        String edtWAttachment = request.getParameter("edtWAttachment");
                        String edtWType = request.getParameter("edtWType");
                        
                        attachment = request.getParameter("oldAttachment");
                        if((!attachment.equals(edtWAttachment)) && (!edtWAttachment.trim().equals(""))) {
                        	attachment = edtWAttachment;
                        }

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(edtWRecordID, conWOF, buildingID, edtWName,
                                attachment, edtWType, edtWTitledYear, buildDetails.getConsentNumber(),
                                buildDetails.getUploadedBy(), buildDetails.getUploadedDate(), userID,
                                today, buildDetails.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;

                    case "Consent":
                        int edtCSRecordID = Integer.parseInt(request.getParameter("edtCSRecordID"));
                        String edtCSName = request.getParameter("edtCSName");
                        String edtCSConsentNumber = request.getParameter("edtCSConsentNumber");
                        String edtCSAttachment = request.getParameter("edtCSAttachment");
                        String edtCSType = request.getParameter("edtCSType");

                        attachment = request.getParameter("oldAttachment");
                        if((!attachment.equals(edtCSAttachment)) && (!edtCSAttachment.trim().equals(""))) {
                        	attachment = edtCSAttachment;
                        }
                        
                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(edtCSRecordID, conConsent, buildingID, edtCSName,
                                attachment, edtCSType, buildDetails.getTitledYear(),
                                edtCSConsentNumber, buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
                                userID, today, buildDetails.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;

                    case "Asbestos":
                        int edtARecordID = Integer.parseInt(request.getParameter("edtARecordID"));
                        String edtAName = request.getParameter("edtAName");
                        String edtAAttachment = request.getParameter("edtAAttachment");
                        String edtAType = request.getParameter("edtAType");
                        
                        attachment = request.getParameter("oldAttachment");
                        if((!attachment.equals(edtAAttachment)) && (!edtAAttachment.trim().equals(""))) {
                        	attachment = edtAAttachment;
                        }

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(edtARecordID, conAsbestos, buildingID, edtAName,
                                attachment, edtAType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
                                userID, today, buildDetails.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;

                    case "Electrical":
                        int edtERecordID = Integer.parseInt(request.getParameter("edtERecordID"));
                        String edtEName = request.getParameter("edtEName");
                        String edtEAttachment = request.getParameter("edtEAttachment");
                        String edtEType = request.getParameter("edtEType");

                        attachment = request.getParameter("oldAttachment");
                        if((!attachment.equals(edtEAttachment)) && (!edtEAttachment.trim().equals(""))) {
                        	attachment = edtEAttachment;
                        }
                        
                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(edtERecordID, conElectrical, buildingID, edtEName,
                                attachment, edtEType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
                                userID, today, buildDetails.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;

                    case "Gas":
                        int edtGRecordID = Integer.parseInt(request.getParameter("edtGRecordID"));
                        String edtGName = request.getParameter("edtGName");
                        String edtGAttachment = request.getParameter("edtGAttachment");
                        String edtGType = request.getParameter("edtGType");

                        attachment = request.getParameter("oldAttachment");
                        if((!attachment.equals(edtGAttachment)) && (!edtGAttachment.trim().equals(""))) {
                        	attachment = edtGAttachment;
                        }
                        
                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(edtGRecordID, conGas, buildingID, edtGName,
                                attachment, edtGType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
                                userID, today, buildDetails.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;


                    case "Fire":
                        int edtFRecordID = Integer.parseInt(request.getParameter("edtFRecordID"));
                        String edtFName = request.getParameter("edtFName");
                        String edtFAttachment = request.getParameter("edtFAttachment");
                        String edtFType = request.getParameter("edtFType");
                        
                        attachment = request.getParameter("oldAttachment");
                        if((!attachment.equals(edtFAttachment)) && (!edtFAttachment.trim().equals(""))) {
                        	attachment = edtFAttachment;
                        }

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(edtFRecordID, conFire, buildingID, edtFName,
                                attachment, edtFType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
                                userID, today, buildDetails.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;
                    case "HazSubs":
                        int edtHSRecordID = Integer.parseInt(request.getParameter("edtHSRecordID"));
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
                        hazardSub = new HazardousSubstance(edtHSRecordID, buildingID, edtHSProductName, edtHSUnNumber,
                                edtHSApprovalNumber, edtHSGroupStandard, edtHSHazardClassification, edtHSCurrentSDSAvailable,
                                edtHSSpecificStorage, edtHSSegregationRequirements, edtHSContainerSize, edtHSOpenCloseContainer,
                                edtHSGasLiquidSolid, edtHSLocation, edtHSMaximumLikelyAmount, hazardSub.getCreatedBy(),
                                hazardSub.getCreatedDate(), userID, today, hazardSub.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new HazardousSubstanceMgr().updateHazardousSubstance(conn, hazardSub);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;

                    case "HazReg":
                        int edtHRRecordID = Integer.parseInt(request.getParameter("edtHRRecordID"));
                        String edtHRIdentifiedHazard = request.getParameter("edtHRIdentifiedHazard");
                        String edtHRInitialRiskAssessment = request.getParameter("edtHRInitialRiskAssessment");
                        String edtHRControls = request.getParameter("edtHRControls");
                        String edtHRLevelOfControl = request.getParameter("edtHRLevelOfControl");
                        String edtHRResidualRiskAssessment = request.getParameter("edtHRResidualRiskAssessment");

                        /* Save values in HazardRegister POJO */
                        hazardReg = new HazardRegister(edtHRRecordID, buildingID, edtHRIdentifiedHazard,
                                edtHRInitialRiskAssessment, edtHRControls, edtHRLevelOfControl, edtHRResidualRiskAssessment,
                                hazardReg.getCreatedBy(), hazardReg.getCreationDate(),
                                userID, today, hazardReg.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new HazardRegisterMgr().updateHazardRegister(conn, hazardReg);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;

                    case "Seismic":
                        int edtSRRecordID = Integer.parseInt(request.getParameter("edtSRRecordID"));
                        String edtSRName = request.getParameter("edtSRName");
                        String edtSRAttachment = request.getParameter("edtSRAttachment");
                        String edtSRType = request.getParameter("edtSRType");
                        
                        attachment = request.getParameter("oldAttachment");
                        if((!attachment.equals(edtSRAttachment)) && (!edtSRAttachment.trim().equals(""))) {
                        	attachment = edtSRAttachment;
                        }

                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(edtSRRecordID, conSeismic, buildingID, edtSRName,
                        		attachment, edtSRType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
                                userID, today, buildDetails.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;

                    case "ResourceConsent":
                        int edtRCRecordID = Integer.parseInt(request.getParameter("edtRCRecordID"));
                        String edtRCName = request.getParameter("edtRCName");
                        String edtRCAttachment = request.getParameter("edtRCAttachment");
                        String edtRCType = request.getParameter("edtRCType");

                        attachment = request.getParameter("oldAttachment");
                        if((!attachment.equals(edtRCAttachment)) && (!edtRCAttachment.trim().equals(""))) {
                        	attachment = edtRCAttachment;
                        }
                        
                        /* Save values in BuildingDetails POJO */
                        buildDetails = new BuildingDetails(edtRCRecordID, conResourceConsent, buildingID, edtRCName,
                                attachment, edtRCType, buildDetails.getTitledYear(), buildDetails.getConsentNumber(),
                                buildDetails.getUploadedBy(), buildDetails.getUploadedDate(),
                                userID, today, buildDetails.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetails);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;

                    case "ComIns":

                        int edtCIRecordID = Integer.parseInt(request.getParameter("edtCIRecordID"));

                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
                        String inspectionDateStr = request.getParameter("edtCIInspectionDate").replaceAll("-", "");
                        System.out.println("inspectionDateStr: " + inspectionDateStr);
                        Date inspectionDate = null;
                        try {
                            inspectionDate = sdf1.parse(inspectionDateStr);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("inspectionDate:" + inspectionDate);
                        java.sql.Date edtCIInspectionDate = new java.sql.Date(inspectionDate.getTime());
                        System.out.println("edtCIInspectionDate: " + edtCIInspectionDate);

                        String edtCIFinding = request.getParameter("edtCIFinding");
                        String edtCIDescription = request.getParameter("edtCIDescription");
                        String edtCIInspectionStat = request.getParameter("edtCIInspectionStat");
                        String edtCIImage = request.getParameter("edtCIImage");
                        
                        String image = request.getParameter("oldImage");
                        if((!image.equals(edtCIImage)) && (!edtCIImage.trim().equals(""))) {
                        	image = edtCIImage;
                        }

                        /* Save values in Compliance Inspection POJO */
                        comInspection = new ComplianceInspection(edtCIRecordID, buildingID, edtCIInspectionDate,
                                edtCIFinding, edtCIDescription, edtCIInspectionStat, image,
                                comInspection.getCreatedBy(), comInspection.getCreationDate(),
                                userID, today, comInspection.getStatus());

                        /* Call Manager to edit values from POJO */
                        isUpdated = new ComplianceInspectionMgr().updateComplianceInspection(conn, comInspection);

                        if (isUpdated > 0) {
                            System.out.println("Record is successfully updated.");
                        } else {
                            System.out.println("Record is not updated");
                        }
                        break;
                }

                /* Do this for setting STATUS=D (means deleted) of TAB records */
            } else if (action.equalsIgnoreCase("dltTabs")) {

                tabName = request.getParameter("tab");

                switch (tabName) {
                
                	case "GenInfo":

                		/* Call Manager to edit status=D */
                		isSetStatus = new BuildingHeaderMgr().setStatus(conn, conD, buildingID, userID, today);

                    	if (isSetStatus > 0) {
                    		System.out.println("Record is successfully deleted.");
                    	} else {
                    		System.out.println("Record is not deleted");
                    	}
                    	break;

                    case "Contacts":
                        int dltCRecordID = Integer.parseInt(request.getParameter("dltCRecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new ContactsMgr().setStatus(conn, conD, dltCRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;

                    case "WOF":
                        int dltWRecordID = Integer.parseInt(request.getParameter("dltWRecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new BuildingDetailsMgr().setStatus(conn, conD, dltWRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;

                    case "Consent":
                        int dltCSRecordID = Integer.parseInt(request.getParameter("dltCSRecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new BuildingDetailsMgr().setStatus(conn, conD, dltCSRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;

                    case "Asbestos":
                        int dltARecordID = Integer.parseInt(request.getParameter("dltARecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new BuildingDetailsMgr().setStatus(conn, conD, dltARecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;

                    case "Electrical":
                        int dltERecordID = Integer.parseInt(request.getParameter("dltERecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new BuildingDetailsMgr().setStatus(conn, conD, dltERecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;

                    case "Gas":
                        int dltGRecordID = Integer.parseInt(request.getParameter("dltGRecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new BuildingDetailsMgr().setStatus(conn, conD, dltGRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;

                    case "Fire":
                        int dltFRecordID = Integer.parseInt(request.getParameter("dltFRecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new BuildingDetailsMgr().setStatus(conn, conD, dltFRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;
                    case "HazSubs":
                        int dltHSRecordID = Integer.parseInt(request.getParameter("dltHSRecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new HazardousSubstanceMgr().setStatus(conn, conD, dltHSRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;

                    case "HazReg":
                        int dltHRRecordID = Integer.parseInt(request.getParameter("dltHRRecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new HazardRegisterMgr().setStatus(conn, conD, dltHRRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;

                    case "Seismic":
                        int dltSRRecordID = Integer.parseInt(request.getParameter("dltSRRecordID"));

                        /* Call Manager to edit values from POJO */
                        isSetStatus = new BuildingDetailsMgr().setStatus(conn, conD, dltSRRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;

                    case "ResourceConsent":
                        int dltRCRecordID = Integer.parseInt(request.getParameter("dltRCRecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new BuildingDetailsMgr().setStatus(conn, conD, dltRCRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted.");
                        }
                        break;

                    case "ComIns":

                        int dltCIRecordID = Integer.parseInt(request.getParameter("dltCIRecordID"));

                        /* Call Manager to edit status=D */
                        isSetStatus = new ComplianceInspectionMgr().setStatus(conn, conD, dltCIRecordID, buildingID, userID, today);

                        if (isSetStatus > 0) {
                            System.out.println("Record is successfully deleted.");
                        } else {
                            System.out.println("Record is not deleted");
                        }
                        break;
                }
            }

        }


        /* Query latest values and Display Tab Contents */

        /* Get Building Header by buildingID */
        bHeader = new BuildingHeaderMgr().getBuildingHeaderByBuildingID(conn, buildingID, conStatus);

        /* Get Contacts by buildingID */
        contactsArr = new ContactsMgr().getContacts(conn, buildingID, conStatus);

        /*Get Building Details */
        bDetails = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, "", conStatus);

        /*Get Compliance Inspection */
        complianceInspectionArr = new ComplianceInspectionMgr().getComplianceInspection(conn, buildingID, conStatus);

        /*Get Hazardous Substances */
        hazSubstancesArr = new HazardousSubstanceMgr().getHazardousSubstance(conn, buildingID, conStatus);

        /*Get Hazard Register */
        hazRegisterArr = new HazardRegisterMgr().getHazardRegister(conn, buildingID, conStatus);

        /*Get Building WOF from Building_Details table */
        buildingWOFArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conWOF, conStatus);

        /*Get Building Consent from Building_Details table */
        buildingConsentArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conConsent, conStatus);

        /*Get Asbestos from Building_Details table */
        asbestosArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conAsbestos, conStatus);

        /*Get Electrical from Building_Details table */
        electricalArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conElectrical, conStatus);

        /*Get Gas from Building_Details table */
        gasArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conGas, conStatus);

        /*Get Fire from Building_Details table */
        fireArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conFire, conStatus);

        /*Get Seismic Resilience from Building_Details table */
        seismicArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conSeismic, conStatus);

        /*Get Resource Consent from Building_Details table */
        resourceConsentArr = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, conResourceConsent, conStatus);
		
        /*Get all tabs registered to user */
        genInfoTab = new UserTabMgr().getAdminUserTab(conn, userID, "GenInfo");
        contactsTab = new UserTabMgr().getAdminUserTab(conn, userID, "Contacts");
        wofTab = new UserTabMgr().getAdminUserTab(conn, userID, "WOF");
        consentTab = new UserTabMgr().getAdminUserTab(conn, userID, "Consent");
        asbestosTab = new UserTabMgr().getAdminUserTab(conn, userID, "Asbestos");
        electricalTab = new UserTabMgr().getAdminUserTab(conn, userID, "Electrical");
        gasTab = new UserTabMgr().getAdminUserTab(conn, userID, "Gas");
        fireTab = new UserTabMgr().getAdminUserTab(conn, userID, "Fire");
        hazSubsTab = new UserTabMgr().getAdminUserTab(conn, userID, "HazSubs");
        hazRegTab = new UserTabMgr().getAdminUserTab(conn, userID, "HazReg");
        seismicTab = new UserTabMgr().getAdminUserTab(conn, userID, "Seismic");
        resourceConsentTab = new UserTabMgr().getAdminUserTab(conn, userID, "ResourceConsent");
        comInsTab = new UserTabMgr().getAdminUserTab(conn, userID, "ComIns");
        
        /* Get User Account profile */
        userAccount = new UserMgr().getUserAccount(conn, userID, conStatus);
        
        session.setAttribute("userAccount", userAccount);
		request.setAttribute("buildingID", buildingID);
		request.setAttribute("tabName", tabName);
		request.setAttribute("bHeader", bHeader);
		request.setAttribute("contactsArr", contactsArr);
		request.setAttribute("bDetails", bDetails);
		request.setAttribute("complianceInspectionArr", complianceInspectionArr);
		request.setAttribute("hazSubstancesArr", hazSubstancesArr);
		request.setAttribute("hazRegisterArr", hazRegisterArr);
		request.setAttribute("buildingWOFArr", buildingWOFArr);
		request.setAttribute("buildingConsentArr", buildingConsentArr);
		request.setAttribute("asbestosArr", asbestosArr);
		request.setAttribute("electricalArr", electricalArr);
		request.setAttribute("gasArr", gasArr);
		request.setAttribute("fireArr", fireArr);
		request.setAttribute("seismicArr", seismicArr);
		request.setAttribute("resourceConsentArr", resourceConsentArr);
		request.setAttribute("cTypeList", cTypeList);
		request.setAttribute("wTypeList", wTypeList);
		request.setAttribute("csTypeList", csTypeList);
		request.setAttribute("aTypeList", aTypeList);
		request.setAttribute("eTypeList", eTypeList);
		request.setAttribute("gTypeList", gTypeList);
		request.setAttribute("hrRiskAssessList", hrRiskAssessList);
		request.setAttribute("sTypeList", sTypeList);
		request.setAttribute("rcTypeList", rcTypeList);
		request.setAttribute("yesNoList", yesNoList);
		request.setAttribute("fTypeList", fTypeList);
		request.setAttribute("levelOfControlsList", levelOfControlsList);
		request.setAttribute("fireHazCatList", fireHazCatList);
		request.setAttribute("genInfoTab", genInfoTab);
		request.setAttribute("contactsTab", contactsTab);
		request.setAttribute("wofTab", wofTab);
		request.setAttribute("consentTab", consentTab);
		request.setAttribute("asbestosTab", asbestosTab);
		request.setAttribute("electricalTab", electricalTab);
		request.setAttribute("gasTab", gasTab);
		request.setAttribute("fireTab", fireTab);
		request.setAttribute("hazSubsTab", hazSubsTab);
		request.setAttribute("hazRegTab", hazRegTab);
		request.setAttribute("seismicTab", seismicTab);
		request.setAttribute("resourceConsentTab", resourceConsentTab);
		request.setAttribute("comInsTab", comInsTab);

        /* do redirection */
        ServletContext sContext = getServletContext();
        RequestDispatcher rDispatcher = sContext.getRequestDispatcher(newPage);
        rDispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        
        doGet(request, response);
    }
}
