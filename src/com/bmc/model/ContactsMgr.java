package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bmc.pojo.BuildingDetails;
import com.bmc.pojo.BuildingHeader;
import com.bmc.pojo.Contacts;

public class ContactsMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<Contacts> getContacts(Connection conn, String buildingId){

		ArrayList<Contacts> conArr = new ArrayList<>();


		String qry = "SELECT * FROM dbo.Contacts WHERE name LIKE ? AND company LIKE ?";

		try {

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildingId.trim());

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				conArr.add(new Contacts(resultSet.getString("buildingId"), resultSet.getString("name"), 
						resultSet.getString("type"), resultSet.getString("company"), resultSet.getInt("company"), 
						resultSet.getInt("faxNumber"), resultSet.getInt("mobileNumber"), resultSet.getString("emailAdd"), 
						resultSet.getString("createdBy"), resultSet.getDate("creationDate"), resultSet.getString("modifiedBy"), 
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

		return conArr;
	}


	public boolean setContacts(Connection conn, Contacts contact){

		boolean isCreated = false;

		try {

			String qry = "INSERT INTO dbo.Contacts"
					+ "buildingId, name, type, company, phoneNumber, "
					+ "faxNumber, mobileNumber, emailAdd, createdBy, creationDate, "
					+ "modifiedBy, modifiedDate, status"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, contact.getBuildingId());
			pstatement.setString(2, contact.getName());
			pstatement.setString(3, contact.getType());
			pstatement.setString(4, contact.getCompany());
			pstatement.setInt(5, contact.getPhoneNumber());
			pstatement.setInt(6, contact.getFaxNumber());
			pstatement.setInt(7, contact.getMobileNumber());
			pstatement.setString(8, contact.getEmailAdd());
			pstatement.setString(9, contact.getCreatedBy());
			pstatement.setDate(10, contact.getCreationDate());
			pstatement.setString(11, contact.getModifiedBy());
			pstatement.setDate(12, contact.getModifiedDate());
			pstatement.setString(13, contact.getStatus());

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

	public int updateContacts(Connection conn, Contacts contact){

		int isUpdated = 0;

		try {

			String qry = "UPDATE dbo.Contacts set"
					+ "name=?, type=?, company=? phoneNumber=?, faxNumber=?, "
					+ "mobileNumber=?, emailAdd=?, createdBy=?, creationDate=?, modifiedBy=?, "
					+ "modifiedDate=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, contact.getName());
			pstatement.setString(2, contact.getType());
			pstatement.setString(3, contact.getCompany());
			pstatement.setInt(4, contact.getPhoneNumber());
			pstatement.setInt(5, contact.getFaxNumber());
			pstatement.setInt(6, contact.getMobileNumber());
			pstatement.setString(7, contact.getEmailAdd());
			pstatement.setString(8, contact.getCreatedBy());
			pstatement.setDate(9, contact.getCreationDate());
			pstatement.setString(10, contact.getModifiedBy());
			pstatement.setDate(11, contact.getModifiedDate());

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
