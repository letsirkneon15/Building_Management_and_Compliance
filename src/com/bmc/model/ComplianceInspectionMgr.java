package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.bmc.pojo.ComplianceInspection;

public class ComplianceInspectionMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<ComplianceInspection> getComplianceInspection(Connection conn, int buildingID){

		ArrayList<ComplianceInspection> ciArr = new ArrayList<>();

		String qry = "SELECT * from dbo.Compliance_Inspection WHERE buildingID = ? ";

		try{
			pstatement = conn.prepareStatement(qry);
			pstatement.setInt(1, buildingID);

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


	public boolean setComplianceInspection(Connection conn, ComplianceInspection comInspection){

		boolean isCreated = false;

		try{

			String qry = "INSERT INTO dbo.Compliance_Inspection "
					+ "(recordID, buildingID, inspectionDate, finding, description, inspectionStatus, image, "
					+ "createdBy, createdDate, modifiedBy, modifiedDate, status) "
					+ " VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setInt(1, comInspection.getRecordID());
			pstatement.setInt(2, comInspection.getBuildingID());
			pstatement.setDate(3, (java.sql.Date) comInspection.getInspectionDate());
			pstatement.setString(4, comInspection.getFinding());
			pstatement.setString(5, comInspection.getDescription());
			pstatement.setString(6, comInspection.getInspectionStatus());
			pstatement.setString(7, comInspection.getImage());
			pstatement.setString(8, comInspection.getCreatedBy());
			pstatement.setDate(9, (java.sql.Date) comInspection.getCreationDate());
			pstatement.setString(10, comInspection.getModifiedBy());
			pstatement.setDate(11, (java.sql.Date) comInspection.getModifiedDate());
			pstatement.setString(12, comInspection.getStatus());

			isCreated = pstatement.execute();
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
			
			pstatement.setDate(1, (java.sql.Date) comInspection.getInspectionDate());
			pstatement.setString(2, comInspection.getFinding());
			pstatement.setString(3, comInspection.getDescription());
			pstatement.setString(4, comInspection.getInspectionStatus());
			pstatement.setString(5, comInspection.getImage());
			pstatement.setString(6, comInspection.getModifiedBy());
			pstatement.setDate(7, (java.sql.Date) comInspection.getModifiedDate());
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
			pstatement.setDate(3, (java.sql.Date) modifiedDate);
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
