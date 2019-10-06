package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.bmc.pojo.HazardousSubstance;

public class HazardousSubstanceMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<HazardousSubstance> getHazardousSubstance(Connection conn, int buildingID, String status){

		ArrayList<HazardousSubstance> hsArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.Hazardous_Substance WHERE buildingID=? ";
		
		if(!status.equals("D")) {
			qry = qry + " AND (status=? OR status IS NULL)";
		}

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setInt(1, buildingID);

			if(!status.equals("D")) {
				pstatement.setString(2, status.trim());
			}

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				hsArr.add(new HazardousSubstance(resultSet.getInt("recordID"), resultSet.getInt("buildingID"), resultSet.getString("productName"),
						resultSet.getString("unNumber"), resultSet.getString("approvalNumber"), resultSet.getString("groupStandard"), 
						resultSet.getString("hazardClassification"), resultSet.getString("currentSDSAvailable"), resultSet.getString("specificStorage"), 
						resultSet.getString("segregationRequirements"), resultSet.getString("containerSize"), resultSet.getString("openCloseContainer"), 
						resultSet.getString("gasLiquIDSolID"), resultSet.getString("location"), resultSet.getInt("maximumLikelyAmount"), 
						resultSet.getString("createdBy"), resultSet.getDate("createdDate"), resultSet.getString("modifiedBy"), 
						resultSet.getDate("modifiedDate"), resultSet.getString("status")));
			} 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				pstatement.close();
			}catch (Exception e) {
				e.printStackTrace();
			}			
		}		
		return hsArr;
	}


	public int setHazardousSubstance(Connection conn, HazardousSubstance hazardSub){

		int isCreated = 0;

		try {

			String qry = " INSERT INTO dbo.Hazardous_Substance "
					+ "(buildingID, productName, unNumber, approvalNumber, "
					+ "groupStandard, hazardClassification, currentSDSAvailable, specificStorage, segregationRequirements, "
					+ "containerSize, openCloseContainer, gasLiquidSolid, location, maximumLikelyAmount, "
					+ "createdBy, createdDate, modifiedBy, modifiedDate, status)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setInt(1, hazardSub.getBuildingID());
			pstatement.setString(2, hazardSub.getProductName());
			pstatement.setString(3, hazardSub.getUnNumber());
			pstatement.setString(4, hazardSub.getApprovalNumber());
			pstatement.setString(5, hazardSub.getGroupStandard());
			pstatement.setString(6, hazardSub.getHazardClassification());
			pstatement.setString(7, hazardSub.getCurrentSDSAvailable());
			pstatement.setString(8, hazardSub.getSpecificStorage());
			pstatement.setString(9, hazardSub.getSegregationRequirements());
			pstatement.setString(10, hazardSub.getContainerSize());
			pstatement.setString(11, hazardSub.getOpenCloseContainer());
			pstatement.setString(12, hazardSub.getGasLiquidSolid());
			pstatement.setString(13, hazardSub.getLocation());
			pstatement.setInt(14, hazardSub.getMaximumLikelyAmount());
			pstatement.setString(15, hazardSub.getCreatedBy());
			pstatement.setDate(16, hazardSub.getCreatedDate());
			pstatement.setString(17, hazardSub.getModifiedBy());
			pstatement.setDate(18, hazardSub.getModifiedDate());
			pstatement.setString(19, hazardSub.getStatus());

			isCreated =  pstatement.executeUpdate();
			pstatement.close();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {

			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isCreated;
	}

	public int updateHazardousSubstance(Connection conn, HazardousSubstance hazardSub){

		int isUpdated = 0;

		try {

			String qry  = "UPDATE dbo.Hazardous_Substance set "
					+ "productName=?, unNumber=?, approvalNumber=?,  groupStandard=?, hazardClassification=?,"
					+ "currentSDSAvailable=?, specificStorage=?, segregationRequirements=?, containerSize=?, openCloseContainer=?,"
					+ "gasLiquIDSolID=?, location=?, maximumLikelyAmount=?, modifiedBy=?, modifiedDate=? "
					+ "WHERE buildingID=? AND recordID=?";

			pstatement = conn.prepareStatement(qry);


			pstatement.setString(1, hazardSub.getProductName());
			pstatement.setString(2, hazardSub.getUnNumber());
			pstatement.setString(3, hazardSub.getApprovalNumber());
			pstatement.setString(4, hazardSub.getGroupStandard());
			pstatement.setString(5, hazardSub.getHazardClassification());
			pstatement.setString(6, hazardSub.getCurrentSDSAvailable());
			pstatement.setString(7, hazardSub.getSpecificStorage());
			pstatement.setString(8, hazardSub.getSegregationRequirements());
			pstatement.setString(9, hazardSub.getContainerSize());
			pstatement.setString(10, hazardSub.getOpenCloseContainer());
			pstatement.setString(11, hazardSub.getGasLiquidSolid());
			pstatement.setString(12, hazardSub.getLocation());
			pstatement.setInt(13, hazardSub.getMaximumLikelyAmount());
			pstatement.setString(14, hazardSub.getModifiedBy());
			pstatement.setDate(15,  hazardSub.getModifiedDate());
			pstatement.setInt(16, hazardSub.getBuildingID());
			pstatement.setInt(17, hazardSub.getRecordID());

			isUpdated = pstatement.executeUpdate();
			pstatement.close();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {

			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isUpdated;
	}

	public int setStatus(Connection conn, String status, int recordID, int buildingID, String modifiedBy, Date modifiedDate) {


		int isSetStatus = 0;

		try {

			String qry = "UPDATE dbo.Hazardous_Substance set status=?, modifiedBy=?, "
					+ "modifiedDate=? WHERE buildingID =? AND recordID=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, status);
			pstatement.setString(2, modifiedBy);
			pstatement.setDate(3,  modifiedDate);
			pstatement.setInt(4, buildingID);
			pstatement.setInt(5, recordID);

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
