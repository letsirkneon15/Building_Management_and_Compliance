package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.bmc.pojo.HazardRegister;

public class HazardRegisterMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;

	
	public ArrayList<HazardRegister> getHazardRegister(Connection conn, int buildingID, String status){
		
		   ArrayList<HazardRegister> hrArr = new ArrayList<>();
		   
		   String qry = "SELECT * FROM dbo.Hazard_Register WHERE buildingID=? ";
		   
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
	

	public int setHazardRegister(Connection conn, HazardRegister hazardReg){
		
		   int isCreated = 0;

		   try {
			   
		  
		   String qry = " INSERT INTO dbo.Hazard_Register "
					+ "(buildingID, identifiedHazard, initialRiskAssessment, controls, "
					+ "levelOfControl, residualRiskAssessment, createdBy, creationDate, modifiedBy, "
					+ "modifiedDate, status) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		   
			pstatement = conn.prepareStatement(qry);
			
			pstatement.setInt(1, hazardReg.getBuildingID());
			pstatement.setString(2, hazardReg.getIdentifiedHazard());
			pstatement.setString(3, hazardReg.getInitialRiskAssessment());
			pstatement.setString(4, hazardReg.getControls());
			pstatement.setString(5, hazardReg.getLevelOfControl());
			pstatement.setString(6, hazardReg.getResidualRiskAssessment());
			pstatement.setString(7, hazardReg.getCreatedBy());
			pstatement.setDate(8,  hazardReg.getCreationDate());
			pstatement.setString(9, hazardReg.getModifiedBy());
			pstatement.setDate(10,  hazardReg.getModifiedDate());
			pstatement.setString(11, hazardReg.getStatus());
		   
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
	
	public int updateHazardRegister(Connection conn, HazardRegister hazardReg){
		
		int isUpdated = 0;
		   
		
		try {
			
			String qry  = "UPDATE dbo.Hazard_Register set "
					+ "identifiedHazard=?, initialRiskAssessment=?, controls=?,  levelOfControl=?, resIDualRiskAssessment=?, "
					+ "createdBy=?, creationDate=?, modifiedBy=?, modifiedDate=? "
					+ "WHERE buildingID=? AND recordID=?";
			
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

			String qry = "UPDATE dbo.Hazard_Register set status=?, "
					+ "modifiedBy=?, modifiedDate=? WHERE buildingID =? AND recordID=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, status);
			pstatement.setString(2, modifiedBy);
			pstatement.setDate(3, modifiedDate);
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