package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.bmc.pojo.Contacts;

public class ContactsMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<Contacts> getContacts(Connection conn, String buildingID){

		ArrayList<Contacts> conArr = new ArrayList<>();


		String qry = "SELECT * FROM dbo.Contacts WHERE name LIKE ? AND company LIKE ?";

		try {

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, buildingID.trim());

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				conArr.add(new Contacts(resultSet.getInt("recordID"), resultSet.getInt("buildingID"), resultSet.getString("name"), 
						resultSet.getString("type"), resultSet.getString("company"), resultSet.getString("phoneNumber"), 
						resultSet.getString("faxNumber"), resultSet.getString("mobileNumber"), resultSet.getString("emailAdd"), 
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
					+ "recordID, buildingID, name, type, company, phoneNumber, "
					+ "faxNumber, mobileNumber, emailAdd, createdBy, creationDate, "
					+ "modifiedBy, modifiedDate, status"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setInt(1, contact.getRecordID());
			pstatement.setInt(2, contact.getBuildingID());
			pstatement.setString(3, contact.getName());
			pstatement.setString(4, contact.getType());
			pstatement.setString(5, contact.getCompany());
			pstatement.setString(6, contact.getPhoneNumber());
			pstatement.setString(7, contact.getFaxNumber());
			pstatement.setString(8, contact.getMobileNumber());
			pstatement.setString(9, contact.getEmailAdd());
			pstatement.setString(10, contact.getCreatedBy());
			pstatement.setDate(11, (java.sql.Date) contact.getCreationDate());
			pstatement.setString(12, contact.getModifiedBy());
			pstatement.setDate(13, (java.sql.Date) contact.getModifiedDate());
			pstatement.setString(14, contact.getStatus());

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
					+ "mobileNumber=?, emailAdd=?, modifiedBy=?, "
					+ "modifiedDate=? where buildingID=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, contact.getName());
			pstatement.setString(2, contact.getType());
			pstatement.setString(3, contact.getCompany());
			pstatement.setString(4, contact.getPhoneNumber());
			pstatement.setString(5, contact.getFaxNumber());
			pstatement.setString(6, contact.getMobileNumber());
			pstatement.setString(7, contact.getEmailAdd());
			pstatement.setString(8, contact.getModifiedBy());
			pstatement.setDate(9, (java.sql.Date) contact.getModifiedDate());
			pstatement.setInt(10, contact.getBuildingID());

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

			String qry = "UPDATE dbo.Building_Details set status=? "
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
