package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bmc.pojo.BuildingHeader;

public class BuildingHeaderMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<BuildingHeader> getBuildingHeader(Connection conn, String buildingId, String buildingName,
			int frRowNum, int toRowNum) {

		ArrayList<BuildingHeader> bhArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.Building_Header WHERE buidlingID = ? AND buildingName = ?";

		System.out.println("");

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, buildingId.trim());
			pstatement.setString(2, buildingName.trim());
			pstatement.setInt(3, frRowNum);
			pstatement.setInt(4, toRowNum);

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				bhArr.add(new BuildingHeader(resultSet.getString("buildingID"), resultSet.getString("buildingName"),
						resultSet.getString("address"), resultSet.getString("location"),
						resultSet.getInt("levelOrUnitNumber"), resultSet.getInt("coordinates"),
						resultSet.getString("owner"), resultSet.getString("client"),
						resultSet.getString("responsibleOffice"), resultSet.getInt("projectNumber"),
						resultSet.getString("billingInformation"), resultSet.getInt("csNumber"),
						resultSet.getString("legalDescription"), resultSet.getInt("maxOccupants"),
						resultSet.getString("fireHazardCategory"), resultSet.getInt("yearBuilt"),
						resultSet.getString("intendedLife"), resultSet.getDate("bwofAnniversary"),
						resultSet.getString("asbestosPresent"), resultSet.getInt("nbsPercentage"),
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

	public boolean setBuildingHeader(Connection conn, BuildingHeader buildHeader) {

		boolean isCreated = false;

		try {

			String qry = "INSERT INTO dbo.Building_Header"
					+ "(buildingId, buildingName, buildingName, address, location, levelOrUnitNumber, coordinates, owner,"
					+ "client, responsibleOffice, projectNumber, billingInformation, csNumber, legalDescription, maxOccupants, "
					+ "fireHazardCategory, yearBuilt, intendedLife, bwofAnniversary, asbestosPresent, nbsPercentage, "
					+ "createdBy, creationDate, modifiedBy, modifiedDate, status )" + " VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildHeader.getBuildingId());
			pstatement.setString(2, buildHeader.getBuildingName());
			pstatement.setString(3, buildHeader.getAddress());
			pstatement.setString(4, buildHeader.getLocation());
			pstatement.setInt(5, buildHeader.getLevelOrUnitNumber());
			pstatement.setInt(6, buildHeader.getCoordinates());
			pstatement.setString(7, buildHeader.getOwner());
			pstatement.setString(8, buildHeader.getClient());
			pstatement.setString(9, buildHeader.getResponsibleOffice());
			pstatement.setInt(10, buildHeader.getProjectNumber());
			pstatement.setNString(11, buildHeader.getBillingInformation());
			pstatement.setInt(12, buildHeader.getCsNumber());
			pstatement.setString(13, buildHeader.getLegalDescription());
			pstatement.setInt(14, buildHeader.getMaxOccupants());
			pstatement.setString(15, buildHeader.getFireHazardCategory());
			pstatement.setInt(16, buildHeader.getYearBuilt());
			pstatement.setString(17, buildHeader.getIntendedLife());
			pstatement.setDate(18, new java.sql.Date(buildHeader.getBwofAnniversary()));
			pstatement.setString(19, buildHeader.getAsbestosPresent());
			pstatement.setInt(20, buildHeader.getNbsPercentage());
			pstatement.setString(21, buildHeader.getCreatedBy());
			pstatement.setDate(22, buildHeader.getCreationDate());
			pstatement.setString(23, buildHeader.getModifiedBy());
			pstatement.setDate(24, buildHeader.getModifiedDate());
			pstatement.setString(25, buildHeader.getStatus());

			isCreated = pstatement.execute();
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

		return isCreated;
	}

	public boolean updateBuildingHeader(Connection conn, BuildingHeader buildHeader) {

		boolean isUpdated = false;

		try {

			String qry = "UPDATE dbo.Building_Header "
					+ "buildingName=?, address=?, location=?, levelOrUnitNumber=?, coordinates=?, owner=?,"
					+ "client=?, responsibleOffice=?, projectNumber=?, billingInformation=?, csNumber=?, legalDescription=?, maxOccupants=?, "
					+ "fireHazardCategory=?, yearBuilt=?, intendedLife=?, bwofAnniversary=?, asbestosPresent=?, nbsPercentage=?, status=? ";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildHeader.getBuildingName());
			pstatement.setString(2, buildHeader.getAddress());
			pstatement.setString(3, buildHeader.getLocation());
			pstatement.setInt(4, buildHeader.getLevelOrUnitNumber());
			pstatement.setInt(5, buildHeader.getCoordinates());
			pstatement.setString(6, buildHeader.getOwner());
			pstatement.setString(7, buildHeader.getClient());
			pstatement.setString(8, buildHeader.getResponsibleOffice());
			pstatement.setInt(9, buildHeader.getProjectNumber());
			pstatement.setNString(10, buildHeader.getBillingInformation());
			pstatement.setInt(11, buildHeader.getCsNumber());
			pstatement.setString(12, buildHeader.getLegalDescription());
			pstatement.setInt(13, buildHeader.getMaxOccupants());
			pstatement.setString(14, buildHeader.getFireHazardCategory());
			pstatement.setInt(15, buildHeader.getYearBuilt());
			pstatement.setString(16, buildHeader.getIntendedLife());
			pstatement.setDate(17, new java.sql.Date(buildHeader.getBwofAnniversary()));
			pstatement.setString(18, buildHeader.getAsbestosPresent());
			pstatement.setInt(19, buildHeader.getNbsPercentage());
			pstatement.setString(20, buildHeader.getStatus());

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

	public boolean setStatus(Connection conn, String buildingId) {

		boolean isSetStatus = false;
		
		return isSetStatus;
	}

}
