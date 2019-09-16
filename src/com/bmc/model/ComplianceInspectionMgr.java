package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bmc.pojo.ComplianceInspection;

public class ComplianceInspectionMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public List<ComplianceInspection> getComplianceInspection(Connection conn, int buildingID){
		
		int frRowNum=0, toRowNum=0;

		List<ComplianceInspection> ciArr = new ArrayList<>();


		String qry = "SELECT outer.* FROM (SELECT rownum rn, inner.* from("
				+ "SELECT a.* from dbo.Compliance_Inspection a WHERE buildingID = ? " +
				" ) inner) outer WHERE outer.rn >= ? and outer.rn <= ?";

		System.out.println("Qry: " + qry + " frRowNum:" + frRowNum + " toRowNum: " + toRowNum);	

		try{
			pstatement = conn.prepareStatement(qry);
			
			pstatement.setInt(1, buildingID);
			pstatement.setInt(2, frRowNum);
			pstatement.setInt(3, toRowNum);

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
						resultSet.getDate("createdDate"),
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
					+ "where buildingID=?";

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

	public int setStatus(Connection conn, String status, int buildingID, String modifiedBy, Date modifiedDate){

		int isSetStatus = 0;
		
		try {

			String qry = "UPDATE dbo.Compliance_Inspection set status=?, modifiedBy=?, "
					+ "modifiedDate=? WHERE buildingID =?";

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
