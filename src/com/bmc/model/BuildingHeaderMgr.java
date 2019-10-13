package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.bmc.pojo.BuildingHeader;
import com.bmc.pojo.UserBuilding;

public class BuildingHeaderMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<BuildingHeader> getBuildingHeader(Connection conn, int buildingID, String buildingName, String status) {

		
		ArrayList<BuildingHeader> bhArr = new ArrayList<>();

		
		String qry = "SELECT * FROM dbo.Building_Header WHERE buildingID=? AND buildingName LIKE ? "; 
			
		if(!status.equals("D")) {
			qry = qry + " AND (status=? OR status IS NULL)";
		}
		
		System.out.println("QRY: " + qry);

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setInt(1, buildingID);
			pstatement.setString(2, buildingName.trim());

			if(!status.equals("D")) {
				pstatement.setString(3, status.trim());
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

	public ArrayList<BuildingHeader> getBuildingHeaderByUserId(Connection conn, String userID, String status) {

		ArrayList<BuildingHeader> bhArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.User_Building ub INNER JOIN dbo.Building_Header bh on "
				+ "ub.BuildingID = bh.BuildingID where userID=? ";
		
		if(!status.equals("D")) {
			qry = qry + " AND (ub.status=? OR ub.status IS NULL) AND (bh.status=? OR bh.status IS NULL)";
		}
		
		System.out.println("QRY: " + qry);

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID);
			
			if(!status.equals("D")) {
				pstatement.setString(2, status.trim());
				pstatement.setString(3, status.trim());
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
	
	public BuildingHeader getBuildingHeaderByBuildingID(Connection conn, int buildingID, String status) {
		
		BuildingHeader bHeader = new BuildingHeader();

		String qry = "SELECT * FROM dbo.Building_Header where buildingID=? ";
		
		if(!status.equals("D")) {
			qry = qry + " AND (status=? OR status IS NULL)";
		}
	
		System.out.println("QRY: " + qry);

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setInt(1, buildingID);
			
			if(!status.equals("D")) {
				pstatement.setString(2, status.trim());
			}

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				bHeader = new BuildingHeader(resultSet.getInt("buildingID"), resultSet.getString("buildingName"),
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
						resultSet.getString("status"));
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

		return bHeader;
	}
	
	public int setBuildingHeader(Connection conn, BuildingHeader buildHeader) {

		int isCreated = 0;

		try {

			String qry = "INSERT INTO dbo.Building_Header "
					+ "(buildingName, address, location, levelOrUnitNumber, coordinates, owner,"
					+ "client, responsibleOffice, projectNumber, buildingInformation, csNumber, legalDescription, maxOccupants, "
					+ "fireHazardCategory, yearBuilt, intendedLife, bwofAnniversary, asbestosPresent, nbsPercentage, "
					+ "createdBy, creationDate, modifiedBy, modifiedDate, status)" + " VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildHeader.getBuildingName());
			pstatement.setString(2, buildHeader.getAddress());
			pstatement.setString(3, buildHeader.getLocation());
			pstatement.setString(4, buildHeader.getLevelOrUnitNumber());
			pstatement.setString(5, buildHeader.getCoordinates());
			pstatement.setString(6, buildHeader.getOwner());
			pstatement.setString(7, buildHeader.getClient());
			pstatement.setString(8, buildHeader.getResponsibleOffice());
			pstatement.setString(9, buildHeader.getProjectNumber());
			pstatement.setString(10, buildHeader.getBuildingInformation());
			pstatement.setString(11, buildHeader.getCsNumber());
			pstatement.setString(12, buildHeader.getLegalDescription());
			pstatement.setInt(13, buildHeader.getMaxOccupants());
			pstatement.setString(14, buildHeader.getFireHazardCategory());
			pstatement.setInt(15, buildHeader.getYearBuilt());
			pstatement.setString(16, buildHeader.getIntendedLife());
			pstatement.setInt(17, buildHeader.getBwofAnniversary());
			pstatement.setString(18, buildHeader.getAsbestosPresent());
			pstatement.setFloat(19, buildHeader.getNbsPercentage());
			pstatement.setString(20, buildHeader.getCreatedBy());
			pstatement.setDate(21, buildHeader.getCreationDate());
			pstatement.setString(22, buildHeader.getModifiedBy());
			pstatement.setDate(23, buildHeader.getModifiedDate());
			pstatement.setString(24, buildHeader.getStatus());

			isCreated = pstatement.executeUpdate();
			pstatement.close();
			
			/* Authorized the user to the newly created building */ 
			qry = "Select buildingID from dbo.Building_Header where createdBy=? ORDER by buildingID DESC";
			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildHeader.getCreatedBy());
			
			resultSet = pstatement.executeQuery();
			resultSet.next(); 
			   
			int buildingID = resultSet.getInt(1);
			UserBuilding ub = new UserBuilding(buildHeader.getCreatedBy(), buildingID, buildHeader.getCreatedBy(), 
					buildHeader.getCreationDate(), buildHeader.getModifiedBy(), buildHeader.getModifiedDate(), "");
			new UserBuildingMgr().setUserBuilding(conn, ub);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isCreated;
	}

	public int updateBuildingHeader(Connection conn, BuildingHeader buildHeader) {

		int isUpdated = 0;

		try {

			String qry = "UPDATE dbo.Building_Header set "
					+ "buildingName=?, address=?, location=?, levelOrUnitNumber=?, coordinates=?, owner=?,"
					+ "client=?, responsibleOffice=?, projectNumber=?, buildingInformation=?, csNumber=?, legalDescription=?, maxOccupants=?, "
					+ "fireHazardCategory=?, yearBuilt=?, intendedLife=?, bwofAnniversary=?, asbestosPresent=?, nbsPercentage=?, status=?, "
					+ "modifiedBy=?, modifiedDate=? WHERE buildingID = ?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildHeader.getBuildingName());
			pstatement.setString(2, buildHeader.getAddress());
			pstatement.setString(3, buildHeader.getLocation());
			pstatement.setString(4, buildHeader.getLevelOrUnitNumber());
			pstatement.setString(5, buildHeader.getCoordinates());
			pstatement.setString(6, buildHeader.getOwner());
			pstatement.setString(7, buildHeader.getClient());
			pstatement.setString(8, buildHeader.getResponsibleOffice());
			pstatement.setString(9, buildHeader.getProjectNumber());
			pstatement.setString(10, buildHeader.getBuildingInformation());
			pstatement.setString(11, buildHeader.getCsNumber());
			pstatement.setString(12, buildHeader.getLegalDescription());
			pstatement.setInt(13, buildHeader.getMaxOccupants());
			pstatement.setString(14, buildHeader.getFireHazardCategory());
			pstatement.setInt(15, buildHeader.getYearBuilt());
			pstatement.setString(16, buildHeader.getIntendedLife());
			pstatement.setInt(17, buildHeader.getBwofAnniversary());
			pstatement.setString(18, buildHeader.getAsbestosPresent());
			pstatement.setFloat(19, buildHeader.getNbsPercentage());
			pstatement.setString(20, buildHeader.getStatus());
			pstatement.setString(21, buildHeader.getModifiedBy());
			pstatement.setDate(22,  buildHeader.getModifiedDate());
			pstatement.setInt(23, buildHeader.getBuildingID());

			isUpdated = pstatement.executeUpdate();
			pstatement.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isUpdated;
	}

	public int setStatus(Connection conn, String status, int buildingID, String modifiedBy, Date modifiedDate) {

		int isSetStatus = 0;

		try {

			String qry = "UPDATE dbo.Building_Header set status=?, "
					+ "modifiedBy=?, modifiedDate=? WHERE buildingID =?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, status);
			pstatement.setString(2, modifiedBy);
			pstatement.setDate(3,  modifiedDate);
			pstatement.setInt(4, buildingID);

			isSetStatus = pstatement.executeUpdate();
			pstatement.close();	

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {

			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isSetStatus;
	}

}
