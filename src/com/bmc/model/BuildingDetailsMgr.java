package com.bmc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bmc.pojo.BuildingDetails;

public class BuildingDetailsMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<BuildingDetails> getBuildingDetails(Connection conn, int buildingID, String buildingDetailsType, String status){

		ArrayList<BuildingDetails> bdArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.Building_Details WHERE buildingID=? AND buildingDetailsType=? ";
		
		if(!status.equals("D")) {
			qry = qry + " AND (status=? OR status IS NULL)";
		}
				
		try {

			pstatement = conn.prepareStatement(qry);
			pstatement.setInt(1, buildingID);
			pstatement.setString(2, buildingDetailsType.trim());

			if(!status.equals("D")) {
				pstatement.setString(3, status.trim());
			}
			
			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				bdArr.add(new BuildingDetails(resultSet.getInt("recordID"), resultSet.getString("buildingDetailsType"), 
						resultSet.getInt("buildingID"), resultSet.getString("name"), resultSet.getString("attachment"), 
						resultSet.getString("type"), resultSet.getInt("titledYear"), resultSet.getString("consentNumber"), 
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

	public int setBuildingDetails(Connection conn, BuildingDetails buildDetails) {

		int isCreated = 0;

		try {

			String qry = " INSERT INTO dbo.Building_Details "
					+ "(buildingDetailsType, buildingID, name, "
					+ "attachment, type, titledYear, consentNumber, "
					+ "uploadedBy, uploadedDate, lastUploadedBy, lastUploadedDate, "
					+ "status) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildDetails.getBuildingDetailsType());
			pstatement.setInt(2, buildDetails.getBuildingID());
			pstatement.setString(3, buildDetails.getName());
			pstatement.setString(4, buildDetails.getAttachment());
			pstatement.setString(5, buildDetails.getType());
			pstatement.setInt(6, buildDetails.getTitledYear());
			pstatement.setString(7, buildDetails.getConsentNumber());
			pstatement.setString(8, buildDetails.getUploadedBy());
			pstatement.setDate(9, buildDetails.getUploadedDate());
			pstatement.setString(10, buildDetails.getLastUploadedBy());
			pstatement.setDate(11, buildDetails.getLastUploadedDate());
			pstatement.setString(12, buildDetails.getStatus());

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

	public int updateBuildingDetails(Connection conn, BuildingDetails buildDetails) {

		int isUpdated = 0;

		try {

			String qry  = "UPDATE dbo.Building_Details set "
					+ "name=?, attachment=?,  type=?, "
					+ "titledYear=?, consentNumber=?, "
					+ "lastUploadedBy=?, lastUploadedDate=? WHERE buildingID=? "
					+ "and buildingDetailsType=? AND recordID=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildDetails.getName());
			pstatement.setString(2, buildDetails.getAttachment());
			pstatement.setString(3, buildDetails.getType());
			pstatement.setInt(4, buildDetails.getTitledYear());
			pstatement.setString(5, buildDetails.getConsentNumber());
			pstatement.setString(6, buildDetails.getLastUploadedBy());
			pstatement.setDate(7,  buildDetails.getLastUploadedDate());
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

	public int setStatus(Connection conn, String status, int recordID, int buildingID, String modifiedBy, Date modifiedDate) {


		int isSetStatus = 0;

		try {

			String qry = "UPDATE dbo.Building_Details set status=?, "
					+ "lastUploadedBy=?, lastUploadedDate=? WHERE buildingID =? AND recordID=?";

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
