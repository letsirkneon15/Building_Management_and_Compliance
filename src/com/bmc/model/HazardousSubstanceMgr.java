package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.bmc.pojo.HazardousSubstance;

public class HazardousSubstanceMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<HazardousSubstance> getHazardousSubstance(Connection conn, int buildingID){

		ArrayList<HazardousSubstance> hsArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.Hazardous_Substance WHERE buildingID=?";

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setInt(1, buildingID);

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


	public boolean setHazardousSubstance(Connection conn, HazardousSubstance hazardSub){

		boolean isCreated = false;

		try {

			String qry = " INSERT INTO dbo.Hazardous_Substance"
					+ "recordID, buildingID, productName, unNumber, approvalNumber, "
					+ "groupStandard, hazardClassification, currentSDSAvailable, specificStorage, segregationRequirements, "
					+ "containerSize, openCloseContainer, gasLiquIDSolID, location, maximumLikelyAmount, "
					+ "createdBy, createdDate, modifiedBy, modifiedDate, status"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setInt(1, hazardSub.getRecordID());
			pstatement.setInt(2, hazardSub.getBuildingID());
			pstatement.setString(3, hazardSub.getProductName());
			pstatement.setString(4, hazardSub.getUnNumber());
			pstatement.setString(5, hazardSub.getApprovalNumber());
			pstatement.setString(6, hazardSub.getGroupStandard());
			pstatement.setString(7, hazardSub.getHazardClassification());
			pstatement.setString(8, hazardSub.getCurrentSDSAvailable());
			pstatement.setString(9, hazardSub.getSpecificStorage());
			pstatement.setString(10, hazardSub.getSegregationRequirements());
			pstatement.setString(11, hazardSub.getContainerSize());
			pstatement.setString(12, hazardSub.getOpenCloseContainer());
			pstatement.setString(13, hazardSub.getGasLiquidSolid());
			pstatement.setString(14, hazardSub.getLocation());
			pstatement.setInt(15, hazardSub.getMaximumLikelyAmount());
			pstatement.setString(16, hazardSub.getCreatedBy());
			pstatement.setDate(17, (java.sql.Date) hazardSub.getCreatedDate());
			pstatement.setString(18, hazardSub.getModifiedBy());
			pstatement.setDate(19, (java.sql.Date) hazardSub.getModifiedDate());
			pstatement.setString(20, hazardSub.getStatus());

			isCreated =  pstatement.execute();
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

			String qry  = "UPDATE dbo.Hazardous_Substance set"
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
			pstatement.setString(14, hazardSub.getCreatedBy());
			pstatement.setDate(15, (java.sql.Date) hazardSub.getCreatedDate());
			pstatement.setString(16, hazardSub.getModifiedBy());
			pstatement.setDate(17, (java.sql.Date) hazardSub.getModifiedDate());
			pstatement.setInt(18, hazardSub.getBuildingID());
			pstatement.setInt(19, hazardSub.getRecordID());

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

	public int setStatus(Connection conn, String status, int buildingID, String modifiedBy, Date modifiedDate) {


		int isSetStatus = 0;

		try {

			String qry = "UPDATE dbo.Building_Details set status=? WHERE buildingID =?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, status);
			pstatement.setString(2, modifiedBy);
			pstatement.setDate(3, (java.sql.Date) modifiedDate);
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
