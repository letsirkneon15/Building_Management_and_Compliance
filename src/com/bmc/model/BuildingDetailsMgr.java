package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.bmc.pojo.BuildingDetails;

public class BuildingDetailsMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<BuildingDetails> getBuildingDetails(Connection conn, int buildingID, String buildingName){

		ArrayList<BuildingDetails> bdArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.Building_Details WHERE buildingID LIKE ? AND name LIKE ?";

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setInt(1, buildingID);
			pstatement.setString(2, buildingName.trim());

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				bdArr.add(new BuildingDetails(resultSet.getInt("recordID"), resultSet.getString("buildingDetailsType"), 
						resultSet.getInt("buildingID"), resultSet.getString("name"), resultSet.getString("attachment"), 
						resultSet.getString("type"), resultSet.getInt("titleYear"), resultSet.getString("consentNumber"), 
						resultSet.getString("uploadedBy"), resultSet.getDate("uploadedDate"), resultSet.getString("lastUploadedBy"), 
						resultSet.getDate("lastUploadedDate"), resultSet.getString("status")));
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
		return bdArr;
	}

	public boolean setBuildingDetails(Connection conn, BuildingDetails buildDetails) {

		boolean isCreated = false;

		try {

			String qry = " INSERT INTO dbo.Building_Details"
					+ "recordID, buildingDetailsType, buildingID, name, "
					+ "attachment, type, titledYear, consentNumber, "
					+ "uploadedBy, uploadedDate, lastUploadedBy, lastUploadedDate, "
					+ "status" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setInt(1, buildDetails.getRecordID());
			pstatement.setString(2, buildDetails.getBuildingDetailsType());
			pstatement.setInt(3, buildDetails.getBuildingID());
			pstatement.setString(4, buildDetails.getName());
			pstatement.setString(5, buildDetails.getAttachment());
			pstatement.setString(6, buildDetails.getType());
			pstatement.setInt(7, buildDetails.getTitledYear());
			pstatement.setString(8, buildDetails.getConsentNumber());
			pstatement.setString(9, buildDetails.getUploadedBy());
			pstatement.setDate(10, (java.sql.Date) buildDetails.getUploadedDate());
			pstatement.setString(11, buildDetails.getLastUploadedBy());
			pstatement.setDate(12, (java.sql.Date) buildDetails.getLastUploadedDate());
			pstatement.setString(13, buildDetails.getStatus());

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

	public int updateBuildingDetails(Connection conn, BuildingDetails buildDetails) {

		int isUpdated = 0;

		try {

			String qry  = "UPDATE dbo.Building_Details set "
					+ "name=?, attachment=?,  type=?, "
					+ "titledYear=?, consentNumber=?, "
					+ "lastUploadedBy=?, lastUploadedDate=? WHERE buildingID=? "
					+ "and buildingDetailsType=? and recordID=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildDetails.getName());
			pstatement.setString(2, buildDetails.getAttachment());
			pstatement.setString(3, buildDetails.getType());
			pstatement.setInt(4, buildDetails.getTitledYear());
			pstatement.setString(5, buildDetails.getConsentNumber());
			pstatement.setString(6, buildDetails.getLastUploadedBy());
			pstatement.setDate(7, (java.sql.Date) buildDetails.getLastUploadedDate());
			pstatement.setInt(8, buildDetails.getBuildingID());
			pstatement.setString(9, buildDetails.getBuildingDetailsType());
			pstatement.setInt(10, buildDetails.getRecordID());

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

			String qry = "UPDATE dbo.Building_Details set status=?, "
					+ "modifiedBy=?, modifiedDate=? WHERE buildingID =?";

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
