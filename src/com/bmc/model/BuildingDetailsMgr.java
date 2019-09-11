package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bmc.pojo.BuildingDetails;

public class BuildingDetailsMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<BuildingDetails> getBuildingDetails(Connection conn, String buildingId, String buildingName){

		ArrayList<BuildingDetails> bdArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.Building_Details WHERE buildingId LIKE ? AND name LIKE ?";

		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, buildingId.trim());
			pstatement.setString(2, buildingName.trim());

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				bdArr.add(new BuildingDetails(resultSet.getInt("recordId"), resultSet.getString("buildingDetailsType"), 
						resultSet.getString("buildingId"), resultSet.getString("name"), resultSet.getString("attachment"), 
						resultSet.getString("type"), resultSet.getInt("titleYear"), resultSet.getInt("consentNumber"), 
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
					+ "recordId, buildingDetailsType, buildingId, name, "
					+ "attachment, type, titledYear, consentNumber, "
					+ "uploadedBy, uploadedDate, lastUploadedBy, lastUploadedDate, "
					+ "status" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setInt(1, buildDetails.getRecordId());
			pstatement.setString(2, buildDetails.getBuildingDetailsType());
			pstatement.setString(3, buildDetails.getBuildingId());
			pstatement.setString(4, buildDetails.getName());
			pstatement.setString(5, buildDetails.getAttachment());
			pstatement.setString(6, buildDetails.getType());
			pstatement.setInt(7, buildDetails.getTitledYear());
			pstatement.setInt(8, buildDetails.getConsentNumber());
			pstatement.setString(9, buildDetails.getUploadedBy());
			pstatement.setDate(10, buildDetails.getUploadedDate());
			pstatement.setString(11, buildDetails.getLastUploadedBy());
			pstatement.setDate(12, buildDetails.getLastUploadedDate());
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

			String qry  = "UPDATE dbo.Building_Details set"
					+ "buildingDetatilsType=?, name=?, attachement=?,  type=?, "
					+ "titledYear=?, consentNumber=?, uploadedBy=?, uploadedDate=?, "
					+ "lastUploadedBy=?, lastUploadedDate=? WHERE buildingId=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildDetails.getBuildingDetailsType());
			pstatement.setString(2, buildDetails.getName());
			pstatement.setString(3, buildDetails.getAttachment());
			pstatement.setString(4, buildDetails.getType());
			pstatement.setInt(5, buildDetails.getTitledYear());
			pstatement.setInt(6, buildDetails.getConsentNumber());
			pstatement.setString(7, buildDetails.getUploadedBy());
			pstatement.setDate(8, buildDetails.getUploadedDate());
			pstatement.setString(9, buildDetails.getLastUploadedBy());
			pstatement.setDate(10, buildDetails.getLastUploadedDate());

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
