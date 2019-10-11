package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.bmc.pojo.UserAccount;

public class UserMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;
	
	public ArrayList<UserAccount> getUserAccountList(Connection conn, String status){
		
		   ArrayList<UserAccount> userArr = new ArrayList<>();
		   
		   String qry = "SELECT * FROM dbo.[User] WHERE ";
		   
			if(!status.equals("D")) {
				qry = qry + " (status=? OR status IS NULL)";
			}
			
			try{
				pstatement = conn.prepareStatement(qry);
				
				if(!status.equals("D")) {
					pstatement.setString(1, status.trim());
				}
				
				resultSet = pstatement.executeQuery();
				while(resultSet.next()){
					userArr.add(new UserAccount(
							resultSet.getString("userID"),
							resultSet.getString("password"),
							resultSet.getString("name"),
							resultSet.getString("contactNum"),
							resultSet.getString("emailAdd"),
							resultSet.getString("companyName"),
							resultSet.getString("companyAddress"),
							resultSet.getString("role"),
							resultSet.getString("createdBy"), 
							resultSet.getDate("creationDate"),
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
		   
		   return userArr;
	}
	
	public UserAccount getUserAccount(Connection conn, String userID, String status){
		
		   UserAccount userAccnt = new UserAccount();
		   
		   String qry = "SELECT * FROM dbo.[User] WHERE userID = ?";
		   
			if(!status.equals("D")) {
				qry = qry + " AND (status=? OR status IS NULL)";
			}
			
			try{
				pstatement = conn.prepareStatement(qry);
				
				pstatement.setString(1, userID);
				
				if(!status.equals("D")) {
					pstatement.setString(2, status.trim());
				}
				
				resultSet = pstatement.executeQuery();
				while(resultSet.next()){
					userAccnt = new UserAccount(
							resultSet.getString("userID"),
							resultSet.getString("password"),
							resultSet.getString("name"),
							resultSet.getString("contactNum"),
							resultSet.getString("emailAdd"),
							resultSet.getString("companyName"),
							resultSet.getString("companyAddress"),
							resultSet.getString("role"),
							resultSet.getString("createdBy"), 
							resultSet.getDate("creationDate"),
							resultSet.getString("modifiedBy"),
							resultSet.getDate("modifiedDate"),
							resultSet.getString("status"));	
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
		   
		   return userAccnt;
	}
	
	public int countUserID(Connection conn, String userID) {
		
		int userIDCount = 0; 
		
		String qry = "SELECT count(*) FROM dbo.[User] WHERE userID Like ? ";
		System.out.println("Qry: " + qry);
		
		try{
			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID.trim() + '%');
			
			resultSet = pstatement.executeQuery();
			resultSet.next(); 
			
			userIDCount = resultSet.getInt(1);
			
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
		
		return userIDCount;
	}
	
	public boolean checkValidUser(Connection conn, String userID, String password) {
		
		boolean isValidUser = false;
		
		System.out.println("From UserMgr - userID: " + userID + " password: " + password);
		
		String qry = "SELECT * FROM dbo.[User] WHERE userID=? AND password=? ";
		System.out.println("Qry: " + qry);
		
		try{
			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID.trim());
			pstatement.setString(2, password.trim());
			
			resultSet = pstatement.executeQuery();
			isValidUser = resultSet.next(); 
			
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
		
		return isValidUser;
	}
	
public String getName(Connection conn, String userID) {
		
		String username = "";
		
		
		String qry = "SELECT * FROM dbo.[User] WHERE userID=? ";
		System.out.println("Qry: " + qry);
		
		try{
			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID.trim());
			
			resultSet = pstatement.executeQuery();
			
			while(resultSet.next()){
				username = resultSet.getString("name");
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
		
		return username;
	}

	public int setUser(Connection conn, UserAccount user){
		
		   int isCreated = 0;
		   
		   try{

				String qry = "INSERT INTO dbo.[User] "
						+ "(userID, password, name, contactNum, emailAdd, companyName, companyAddress, "
						+ "role, createdBy, creationDate, modifiedBy, modifiedDate, status) "
						+ " VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, user.getUserID());
				pstatement.setString(2, user.getPassword());
				pstatement.setString(3, user.getName());
				pstatement.setString(4, user.getContactNum());
				pstatement.setString(5, user.getEmailAdd());
				pstatement.setString(6, user.getCompanyName());
				pstatement.setString(7, user.getCompanyAddress());
				pstatement.setString(8, user.getRole());
				pstatement.setString(9, user.getCreatedBy());
				pstatement.setDate(10, user.getCreationDate());
				pstatement.setString(11, user.getModifiedBy());
				pstatement.setDate(12, user.getModifiedDate());
				pstatement.setString(13, user.getStatus());

				isCreated = pstatement.executeUpdate();
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
	
	public int updateUser(Connection conn, UserAccount user){
		
		   int isUpdated = 0;
		   
		   try {
				String qry = "UPDATE dbo.[User] set "
						+ "password=?, name=?, contactNum=?, emailAdd=?, companyName=?, "
						+ "companyAddress=?, role=?, modifiedBy=?, modifiedDate=?, status=? "
						+ "where userID=? ";

				pstatement = conn.prepareStatement(qry);
				
				pstatement.setString(1, user.getPassword());
				pstatement.setString(2, user.getName());
				pstatement.setString(3, user.getContactNum());
				pstatement.setString(4, user.getEmailAdd());
				pstatement.setString(5, user.getCompanyName());
				pstatement.setString(6, user.getCompanyAddress());
				pstatement.setString(7, user.getRole());
				pstatement.setString(8, user.getModifiedBy());
				pstatement.setDate(9, user.getModifiedDate());
				pstatement.setString(10, user.getStatus());
				pstatement.setString(11, user.getUserID());
				

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
	
	public int setStatus(Connection conn, String status, String userID, String modifiedBy, Date modifiedDate){
		
		   int isSetStatus = 0;
		   
		   try {

			   String qry = "UPDATE dbo.[User] set status=?, modifiedBy=?, "
						+ "modifiedDate=? WHERE userID =?";
				
				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, status);
				pstatement.setString(2, modifiedBy);
				pstatement.setDate(3, modifiedDate);
				pstatement.setString(4, userID);
				
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
	
	public int setPassword(Connection conn, String password, String userID, String modifiedBy, Date modifiedDate){
		
		   int isSetPassword = 0;
		   
		   try {

			   String qry = "UPDATE dbo.[User] set password=?, modifiedBy=?, "
						+ "modifiedDate=? WHERE userID =?";
				
				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, password);
				pstatement.setString(2, modifiedBy);
				pstatement.setDate(3,  modifiedDate);
				pstatement.setString(4, userID);
				
				isSetPassword = pstatement.executeUpdate();
				pstatement.close();	


			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {

				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		   
		   return isSetPassword;
	}


}
