package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.bmc.pojo.ComplianceInspection;

public class ComplianceInspectionMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<ComplianceInspection> getComplianceInspection(Connection conn, int buildingID, String status){

		ArrayList<ComplianceInspection> ciArr = new ArrayList<>();

		String qry = "SELECT * from dbo.Compliance_Inspection WHERE buildingID = ? ";
		
		if(!status.equals("D")) {
			qry = qry + " AND (status=? OR status IS NULL)";
		}

		try{
			pstatement = conn.prepareStatement(qry);
			pstatement.setInt(1, buildingID);
			
			if(!status.equals("D")) {
				pstatement.setString(2, status.trim());
			}

			resultSet = pstatement.executeQuery();
			while(resultSet.next()){
				ciArr.add(new ComplianceInspection(
						resultSet.getInt("recordID"),
						resultSet.getInt("buildingID"),
						resultSet.getDate("inspectionDate"),
						resultSet.getString("finding"),
						resultSet.getString("description"),
						resultSet.getString("inspectionStatus"),
						resultSet.getString("image"),
						resultSet.getString("createdBy"), 
						resultSet.getDate("creationDate"),
						resultSet.getString("modifiedBy"),
						resultSet.getDate("modifiedDate"),
						resultSet.getString("status")));		  
			}  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				resultSet.close();
				pstatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return ciArr;
	}


	public int setComplianceInspection(Connection conn, ComplianceInspection comInspection){

		int isCreated = 0;

		try{

			String qry = "INSERT INTO dbo.Compliance_Inspection "
					+ "(buildingID, inspectionDate, finding, description, inspectionStatus, image, "
					+ "createdBy, creationDate, modifiedBy, modifiedDate, status) "
					+ " VALUES" + "(?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setInt(1, comInspection.getBuildingID());
			pstatement.setDate(2,  comInspection.getInspectionDate());
			pstatement.setString(3, comInspection.getFinding());
			pstatement.setString(4, comInspection.getDescription());
			pstatement.setString(5, comInspection.getInspectionStatus());
			pstatement.setString(6, comInspection.getImage());
			pstatement.setString(7, comInspection.getCreatedBy());
			pstatement.setDate(8, comInspection.getCreationDate());
			pstatement.setString(9, comInspection.getModifiedBy());
			pstatement.setDate(10, comInspection.getModifiedDate());
			pstatement.setString(11, comInspection.getStatus());

			isCreated = pstatement.executeUpdate();
			pstatement.close();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return isCreated;
	}

	public int updateComplianceInspection(Connection conn, ComplianceInspection comInspection){

		int isUpdated = 0;

		try {
			String qry = "UPDATE dbo.Compliance_Inspection set "
					+ "inspectionDate=?, finding=?, description=?, inspectionStatus=?, image=?, "
					+ "modifiedBy=?, modifiedDate=?, status=? "
					+ "where buildingID=? AND recordID=?";

			pstatement = conn.prepareStatement(qry);
			
			pstatement.setDate(1,  comInspection.getInspectionDate());
			pstatement.setString(2, comInspection.getFinding());
			pstatement.setString(3, comInspection.getDescription());
			pstatement.setString(4, comInspection.getInspectionStatus());
			pstatement.setString(5, comInspection.getImage());
			pstatement.setString(6, comInspection.getModifiedBy());
			pstatement.setDate(7,  comInspection.getModifiedDate());
			pstatement.setString(8, comInspection.getStatus());
			pstatement.setInt(9, comInspection.getBuildingID());
			pstatement.setInt(10, comInspection.getRecordID());

			isUpdated = pstatement.executeUpdate();
			pstatement.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return isUpdated;
	}

	public int setStatus(Connection conn, String status, int recordID, int buildingID, String modifiedBy, Date modifiedDate){

		int isSetStatus = 0;
		
		try {

			String qry = "UPDATE dbo.Compliance_Inspection set status=?, modifiedBy=?, "
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
