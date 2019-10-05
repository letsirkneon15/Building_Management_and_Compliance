package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bmc.pojo.BuildingHeader;
import com.bmc.pojo.GenInfoAsbestos;
import com.bmc.pojo.GenInfoHazardSubstance;

public class ReportsMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;
	
	public ArrayList<BuildingHeader> getGeneralInformation(Connection conn, String userID, String status, String buildingName, 
			String client, String asbestosPresent) {

		ArrayList<BuildingHeader> bhArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.User_Building ub INNER JOIN dbo.Building_Header bh on "
				+ "ub.BuildingID = bh.BuildingID where userID=? AND bh.buildingName Like ? AND "
				+ "bh.client Like ? AND bh.asbestosPresent=? ";
		
		if(!status.equals("D")) {
			qry = qry + " AND (ub.status=? OR ub.status=NULL) AND (bh.status=? OR bh.status=NULL)";
		}
		
		System.out.println("QRY: " + qry);

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID);
			pstatement.setString(2, buildingName.trim() + '%');
			pstatement.setString(3, client.trim() + '%');
			pstatement.setString(4, asbestosPresent.trim());
			
			if(!status.equals("D")) {
				pstatement.setString(5, status.trim());
				pstatement.setString(6, status.trim());
			}

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				bhArr.add(new BuildingHeader(resultSet.getInt("buildingID"), resultSet.getString("buildingName"),
						resultSet.getString("address"), resultSet.getString("location"),
						resultSet.getString("levelOrUnitNumber"), resultSet.getString("coordinates"),
						resultSet.getString("owner"), resultSet.getString("client"),
						resultSet.getString("responsibleOffice"), resultSet.getString("projectNumber"),
						resultSet.getString("buildingInformation"), resultSet.getString("csNumber"),
						resultSet.getString("legalDescription"), resultSet.getInt("maxOccupants"),
						resultSet.getString("fireHazardCategory"), resultSet.getInt("yearBuilt"),
						resultSet.getString("intendedLife"), resultSet.getInt("bwofAnniversary"),
						resultSet.getString("asbestosPresent"), resultSet.getFloat("nbsPercentage"),
						resultSet.getString("createdBy"), resultSet.getDate("creationDate"),
						resultSet.getString("modifiedBy"), resultSet.getDate("modifiedDate"),
						resultSet.getString("status")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pstatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return bhArr;
	}

	public ArrayList<BuildingHeader> getBWOFAnniversary(Connection conn, String userID, String status, String buildingName, 
			String client, String asbestosPresent, int todayYear) {

		ArrayList<BuildingHeader> bhArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.User_Building ub INNER JOIN dbo.Building_Header bh on "
				+ "ub.BuildingID = bh.BuildingID where userID=? AND bh.buildingName Like ? AND "
				+ "bh.client Like ? AND bh.asbestosPresent=? AND bh.bwofAnniversary < ? ";
		
		if(!status.equals("D")) {
			qry = qry + " AND (ub.status=? OR ub.status=NULL) AND (bh.status=? OR bh.status=NULL)";
		}
		
		System.out.println("QRY: " + qry);

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID);
			pstatement.setString(2, buildingName.trim() + '%');
			pstatement.setString(3, client.trim() + '%');
			pstatement.setString(4, asbestosPresent.trim());
			pstatement.setInt(5, todayYear);
			
			if(!status.equals("D")) {
				pstatement.setString(6, status.trim());
				pstatement.setString(7, status.trim());
			}

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				bhArr.add(new BuildingHeader(resultSet.getInt("buildingID"), resultSet.getString("buildingName"),
						resultSet.getString("address"), resultSet.getString("location"),
						resultSet.getString("levelOrUnitNumber"), resultSet.getString("coordinates"),
						resultSet.getString("owner"), resultSet.getString("client"),
						resultSet.getString("responsibleOffice"), resultSet.getString("projectNumber"),
						resultSet.getString("buildingInformation"), resultSet.getString("csNumber"),
						resultSet.getString("legalDescription"), resultSet.getInt("maxOccupants"),
						resultSet.getString("fireHazardCategory"), resultSet.getInt("yearBuilt"),
						resultSet.getString("intendedLife"), resultSet.getInt("bwofAnniversary"),
						resultSet.getString("asbestosPresent"), resultSet.getFloat("nbsPercentage"),
						resultSet.getString("createdBy"), resultSet.getDate("creationDate"),
						resultSet.getString("modifiedBy"), resultSet.getDate("modifiedDate"),
						resultSet.getString("status")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pstatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return bhArr;
	}
	
	public ArrayList<GenInfoAsbestos> getGeneralInformationAsbestos(Connection conn, String userID, String status, String buildingName, 
			String client, String asbestosPresent) {

		ArrayList<GenInfoAsbestos> bhArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.User_Building ub INNER JOIN dbo.Building_Header bh on "
				+ "ub.BuildingID = bh.BuildingID INNER JOIN dbo.Building_Details bd on "
				+ "bh.BuildingID = bd.BuildingID where bd.buildingDetailsType='Asbestos' "
				+ "AND userID=? AND bh.buildingName Like ? AND "
				+ "bh.client Like ? AND bh.asbestosPresent=? ";
		 
		if(!status.equals("D")) {
			qry = qry + " AND (ub.status=? OR ub.status=NULL) AND (bh.status=? OR bh.status=NULL)";
		}
		
		System.out.println("QRY: " + qry);

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID);
			pstatement.setString(2, buildingName.trim() + '%');
			pstatement.setString(3, client.trim() + '%');
			pstatement.setString(4, asbestosPresent.trim());
			
			if(!status.equals("D")) {
				pstatement.setString(5, status.trim());
				pstatement.setString(6, status.trim());
			}

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				bhArr.add(new GenInfoAsbestos(resultSet.getInt("buildingID"), resultSet.getString("buildingName"),
						resultSet.getString("address"), resultSet.getString("location"),
						resultSet.getString("levelOrUnitNumber"), resultSet.getString("coordinates"),
						resultSet.getString("owner"), resultSet.getString("client"),
						resultSet.getString("responsibleOffice"), resultSet.getString("projectNumber"),
						resultSet.getString("buildingInformation"), resultSet.getString("csNumber"),
						resultSet.getString("legalDescription"), resultSet.getInt("maxOccupants"),
						resultSet.getString("fireHazardCategory"), resultSet.getInt("yearBuilt"),
						resultSet.getString("intendedLife"), resultSet.getInt("bwofAnniversary"),
						resultSet.getString("asbestosPresent"), resultSet.getFloat("nbsPercentage"),
						resultSet.getInt("recordID"), resultSet.getString("buildingDetailsType"),
						resultSet.getString("name"), resultSet.getString("attachment"),
						resultSet.getString("type"), resultSet.getInt("titledYear"), 
						resultSet.getString("consentNumber"), resultSet.getString("uploadedBy"),
						resultSet.getDate("uploadedDate"), resultSet.getString("lastUploadedBy"), 
						resultSet.getDate("lastUploadedDate")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pstatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return bhArr;
	}
	
	public ArrayList<GenInfoHazardSubstance> getGeneralInformationHazardSubstance(Connection conn, String userID, String status, String buildingName, 
			String client, String asbestosPresent) {

		ArrayList<GenInfoHazardSubstance> bhArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.User_Building ub INNER JOIN dbo.Building_Header bh on "
				+ "ub.BuildingID = bh.BuildingID INNER JOIN dbo.Hazardous_Substance hs on "
				+ "bh.BuildingID = hs.BuildingID where "
				+ "userID=? AND bh.buildingName Like ? AND "
				+ "bh.client Like ? AND bh.asbestosPresent=? ";
		 
		if(!status.equals("D")) {
			qry = qry + " AND (ub.status=? OR ub.status=NULL) AND (bh.status=? OR bh.status=NULL)";
		}
		
		System.out.println("QRY: " + qry);

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID);
			pstatement.setString(2, buildingName.trim() + '%');
			pstatement.setString(3, client.trim() + '%');
			pstatement.setString(4, asbestosPresent.trim());
			
			if(!status.equals("D")) {
				pstatement.setString(5, status.trim());
				pstatement.setString(6, status.trim());
			}

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				bhArr.add(new GenInfoHazardSubstance(resultSet.getInt("buildingID"), resultSet.getString("buildingName"),
						resultSet.getString("address"), resultSet.getString("location"),
						resultSet.getString("levelOrUnitNumber"), resultSet.getString("coordinates"),
						resultSet.getString("owner"), resultSet.getString("client"),
						resultSet.getString("responsibleOffice"), resultSet.getString("projectNumber"),
						resultSet.getString("buildingInformation"), resultSet.getString("csNumber"),
						resultSet.getString("legalDescription"), resultSet.getInt("maxOccupants"),
						resultSet.getString("fireHazardCategory"), resultSet.getInt("yearBuilt"),
						resultSet.getString("intendedLife"), resultSet.getInt("bwofAnniversary"),
						resultSet.getString("asbestosPresent"), resultSet.getFloat("nbsPercentage"),
						resultSet.getInt("recordID"), resultSet.getString("productName"),
						resultSet.getString("unNumber"), resultSet.getString("approvalNumber"),
						resultSet.getString("groupStandard"), resultSet.getString("hazardClassification"), 
						resultSet.getString("currentSDSAvailable"), resultSet.getString("specificStorage"),
						resultSet.getString("segregationRequirements"), resultSet.getString("containerSize"), 
						resultSet.getString("openCloseContainer"), resultSet.getString("gasLiquidSolid"), 
						resultSet.getString("location"), resultSet.getInt("maximumLikelyAmount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pstatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return bhArr;
	}
}
