package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bmc.pojo.HazardRegister;
import com.bmc.pojo.HazardousSubstance;

public class HazardRegisterMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;

	
	public ArrayList<HazardRegister> getHazardRegister(Connection conn, String buildingId){
		
		   ArrayList<HazardRegister> hrArr = new ArrayList<>();
		   
		   String qry = "SELECT * FROM dbo.Hazard_Register WHERE buildingId LIKE ?";

			try {

				pstatement = conn.prepareStatement(qry);
				pstatement.setString(1, buildingId.trim());

				resultSet = pstatement.executeQuery();
				while (resultSet.next()) {
					hrArr.add(new HazardRegister(resultSet.getInt("recordId"), resultSet.getString("buildingId"), resultSet.getString("identifiedHazard"),
							resultSet.getString("initialRiskAssessment"), resultSet.getString("controls"),  resultSet.getString("levelOfControl"), 
							resultSet.getString("residualRiskAssessment"), resultSet.getString("createdBy"), resultSet.getDate("creationDate"), 
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
					+ "recordId, buildingId, Hazard_Register, initialRiskAssessment, controls, "
					+ "levelOfControl, residualRiskAssessment, createdBy, creationDate, modifiedBy, "
					+ "modifiedDate, status "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		   
			pstatement = conn.prepareStatement(qry);
			
			pstatement.setInt(1, hazardReg.getRecordId());
			pstatement.setString(2, hazardReg.getBuildingId());
			pstatement.setString(3, hazardReg.getIdentifiedHazard());
			pstatement.setString(4, hazardReg.getInitialRiskAssessment());
			pstatement.setString(5, hazardReg.getControls());
			pstatement.setString(6, hazardReg.getLevelOfControl());
			pstatement.setString(7, hazardReg.getResidualRiskAssessment());
			pstatement.setString(8, hazardReg.getCreatedBy());
			pstatement.setDate(9, hazardReg.getCreationDate());
			pstatement.setString(10, hazardReg.getModifiedBy());
			pstatement.setDate(11, hazardReg.getModifiedDate());
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
			
			String qry  = "UPDATE dbo.Hazard_Register set"
					+ "identifiedHazard=?, initialRiskAssessment=?, controls=?,  levelOfControl=?, residualRiskAssessment=?,"
					+ "createdBy, creationDate, modifiedBy, modifiedDate "
					+ "WHERE buildingId=?";
			
			pstatement = conn.prepareStatement(qry);
			
			pstatement.setString(1, hazardReg.getIdentifiedHazard());
			pstatement.setString(2, hazardReg.getInitialRiskAssessment());
			pstatement.setString(3, hazardReg.getControls());
			pstatement.setString(4, hazardReg.getLevelOfControl());
			pstatement.setString(5, hazardReg.getResidualRiskAssessment());
			pstatement.setString(6, hazardReg.getCreatedBy());
			pstatement.setDate(7, hazardReg.getCreationDate());
			pstatement.setString(8, hazardReg.getModifiedBy());
			pstatement.setDate(9, hazardReg.getModifiedDate());

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
	
	public int setStatus(Connection conn, String status, int recordId) {


		int isSetStatus = 0;

		try {

			String qry = "UPDATE dbo.Building_Details set status=? WHERE recordId =?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, status);
			pstatement.setInt(2, recordId);
			
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