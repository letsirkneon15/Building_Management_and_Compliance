package com.bmc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bmc.pojo.Contacts;

public class ContactsMgr {

	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<Contacts> getContacts(Connection conn, int buildingID, String status){

		ArrayList<Contacts> conArr = new ArrayList<>();

		String qry = "SELECT * FROM dbo.Contacts WHERE buildingID=? ";
		
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


	public int setContacts(Connection conn, Contacts contact){

		int isCreated = 0;

		try {

			String qry = "INSERT INTO dbo.Contacts "
					+ "(buildingID, name, type, company, phoneNumber, "
					+ "faxNumber, mobileNumber, emailAdd, createdBy, creationDate, "
					+ "modifiedBy, modifiedDate, status) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setInt(1, contact.getBuildingID());
			pstatement.setString(2, contact.getName());
			pstatement.setString(3, contact.getType());
			pstatement.setString(4, contact.getCompany());
			pstatement.setString(5, contact.getPhoneNumber());
			pstatement.setString(6, contact.getFaxNumber());
			pstatement.setString(7, contact.getMobileNumber());
			pstatement.setString(8, contact.getEmailAdd());
			pstatement.setString(9, contact.getCreatedBy());
			pstatement.setDate(10, contact.getCreationDate());
			pstatement.setString(11, contact.getModifiedBy());
			pstatement.setDate(12, contact.getModifiedDate());
			pstatement.setString(13, contact.getStatus());

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

	public int updateContacts(Connection conn, Contacts contact){

		int isUpdated = 0;

		try {

			String qry = "UPDATE dbo.Contacts set "
					+ "name=?, type=?, company=?, phoneNumber=?, faxNumber=?, "
					+ "mobileNumber=?, emailAdd=?, modifiedBy=?, "
					+ "modifiedDate=? where buildingID=? AND recordID=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, contact.getName());
			pstatement.setString(2, contact.getType());
			pstatement.setString(3, contact.getCompany());
			pstatement.setString(4, contact.getPhoneNumber());
			pstatement.setString(5, contact.getFaxNumber());
			pstatement.setString(6, contact.getMobileNumber());
			pstatement.setString(7, contact.getEmailAdd());
			pstatement.setString(8, contact.getModifiedBy());
			pstatement.setDate(9,  contact.getModifiedDate());
			pstatement.setInt(10, contact.getBuildingID());
			pstatement.setInt(11, contact.getRecordID());

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

			String qry = "UPDATE dbo.Contacts set status=?, "
					+ "modifiedBy=?, modifiedDate=? WHERE buildingID =? AND recordID=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, status);
			pstatement.setString(2, modifiedBy);
			pstatement.setDate(3,  modifiedDate);
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
