package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.bmc.pojo.HazardRegister;

public class HazardRegisterMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;

	
	public ArrayList<HazardRegister> getHazardRegister(Connection conn, int buildingID){
		
		   ArrayList<HazardRegister> hrArr = new ArrayList<>();
		   
		   String qry = "SELECT * FROM dbo.Hazard_Register WHERE buildingID=?";

			try {

				pstatement = conn.prepareStatement(qry);
				pstatement.setInt(1, buildingID);

				resultSet = pstatement.executeQuery();
				while (resultSet.next()) {
					hrArr.add(new HazardRegister(resultSet.getInt("recordID"), resultSet.getInt("buildingID"), resultSet.getString("IDentifiedHazard"),
							resultSet.getString("initialRiskAssessment"), resultSet.getString("controls"),  resultSet.getString("levelOfControl"), 
							resultSet.getString("resIDualRiskAssessment"), resultSet.getString("createdBy"), resultSet.getDate("creationDate"), 
							resultSet.getString("modifiedBy"), resultSet.getDate("modifiedDate"), resultSet.getString("status")));
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
		   
		   return hrArr;
	}
	

	public boolean setHazardRegister(Connection conn, HazardRegister hazardReg){
		
		   boolean isCreated = false;

		   try {
			   
		  
		   String qry = " INSERT INTO dbo.Hazard_Register"
					+ "recordID, buildingID, identifiedHazard, initialRiskAssessment, controls, "
					+ "levelOfControl, residualRiskAssessment, createdBy, creationDate, modifiedBy, "
					+ "modifiedDate, status "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		   
			pstatement = conn.prepareStatement(qry);
			
			pstatement.setInt(1, hazardReg.getRecordID());
			pstatement.setInt(2, hazardReg.getBuildingID());
			pstatement.setString(3, hazardReg.getIdentifiedHazard());
			pstatement.setString(4, hazardReg.getInitialRiskAssessment());
			pstatement.setString(5, hazardReg.getControls());
			pstatement.setString(6, hazardReg.getLevelOfControl());
			pstatement.setString(7, hazardReg.getResidualRiskAssessment());
			pstatement.setString(8, hazardReg.getCreatedBy());
			pstatement.setDate(9, (java.sql.Date) hazardReg.getCreationDate());
			pstatement.setString(10, hazardReg.getModifiedBy());
			pstatement.setDate(11, (java.sql.Date) hazardReg.getModifiedDate());
			pstatement.setString(12, hazardReg.getStatus());
		   
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
	
	public int updateHazardRegister(Connection conn, HazardRegister hazardReg){
		
		int isUpdated = 0;
		   
		
		try {
			
			String qry  = "UPDATE dbo.Hazard_Register set "
					+ "identifiedHazard=?, initialRiskAssessment=?, controls=?,  levelOfControl=?, resIDualRiskAssessment=?, "
					+ "createdBy, creationDate, modifiedBy, modifiedDate "
					+ "WHERE buildingID=? AND recordID=?";
			
			pstatement = conn.prepareStatement(qry);
			
			pstatement.setString(1, hazardReg.getIdentifiedHazard());
			pstatement.setString(2, hazardReg.getInitialRiskAssessment());
			pstatement.setString(3, hazardReg.getControls());
			pstatement.setString(4, hazardReg.getLevelOfControl());
			pstatement.setString(5, hazardReg.getResidualRiskAssessment());
			pstatement.setString(6, hazardReg.getCreatedBy());
			pstatement.setDate(7, (java.sql.Date) hazardReg.getCreationDate());
			pstatement.setString(8, hazardReg.getModifiedBy());
			pstatement.setDate(9, (java.sql.Date) hazardReg.getModifiedDate());
			pstatement.setInt(10, hazardReg.getBuildingID());
			pstatement.setInt(11, hazardReg.getRecordID());

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

			String qry = "UPDATE dbo.Building_Details set status=? "
					+ "modifiedBy=?, modifiedDate=? WHERE buildingID =? AND recordID=?";

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