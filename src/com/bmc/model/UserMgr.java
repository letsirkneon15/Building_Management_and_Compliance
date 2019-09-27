package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.bmc.pojo.User;

public class UserMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;
	
	public ArrayList<User> getUser(Connection conn, String userID, String name){
		
		   ArrayList<User> userArr = new ArrayList<>();
		   
		   String qry = "SELECT * from dbo.User WHERE userID Like ? AND name Like ? ";
			
			try{
				pstatement = conn.prepareStatement(qry);
				
				pstatement.setString(1, userID);
				pstatement.setString(2, name);
				
				resultSet = pstatement.executeQuery();
				while(resultSet.next()){
					userArr.add(new User(
							resultSet.getString("userID"),
							resultSet.getString("password"),
							resultSet.getString("name"),
							resultSet.getString("contactNum"),
							resultSet.getString("emailAdd"),
							resultSet.getString("companyName"),
							resultSet.getString("companyAddress"),
							resultSet.getString("createdBy"), 
							resultSet.getDate("createdDate"),
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
	

	public int setUser(Connection conn, User user){
		
		   int isCreated = 0;
		   
		   try{

				String qry = "INSERT INTO dbo.User "
						+ "(userID, password, name, contactNum, emailAdd, companyName, companyAddress, "
						+ "createdBy, createdDate, modifiedBy, modifiedDate, status) "
						+ " VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?)";

				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, user.getUserID());
				pstatement.setString(2, user.getPassword());
				pstatement.setString(3, user.getName());
				pstatement.setString(4, user.getContactNum());
				pstatement.setString(5, user.getEmailAdd());
				pstatement.setString(6, user.getCompanyName());
				pstatement.setString(7, user.getCompanyAddress());
				pstatement.setString(8, user.getCreatedBy());
				pstatement.setDate(9, user.getCreationDate());
				pstatement.setString(10, user.getModifiedBy());
				pstatement.setDate(11, user.getModifiedDate());
				pstatement.setString(12, user.getStatus());

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
	
	public int updateUser(Connection conn, User user){
		
		   int isUpdated = 0;
		   
		   try {
				String qry = "UPDATE dbo.User set "
						+ "password=?, name=?, contactNum=?, emailAdd=?, ccompanyName=?, "
						+ "conpanyAddress=?, modifiedBy=?, modifiedDate=?, status=? "
						+ "where userID=? ";

				pstatement = conn.prepareStatement(qry);
				
				pstatement.setString(1, user.getPassword());
				pstatement.setString(2, user.getName());
				pstatement.setString(3, user.getContactNum());
				pstatement.setString(4, user.getEmailAdd());
				pstatement.setString(5, user.getCompanyName());
				pstatement.setString(6, user.getCompanyAddress());
				pstatement.setString(7, user.getModifiedBy());
				pstatement.setDate(8, user.getModifiedDate());
				pstatement.setString(9, user.getStatus());
				pstatement.setString(10, user.getUserID());
				

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

			   String qry = "UPDATE dbo.User set status=?, modifiedBy=?, "
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

			   String qry = "UPDATE dbo.User set password=?, modifiedBy=?, "
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
