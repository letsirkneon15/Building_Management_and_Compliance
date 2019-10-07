package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.bmc.pojo.AdminUserBuilding;
import com.bmc.pojo.UserBuilding;

public class UserBuildingMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;
	
	public ArrayList<UserBuilding> getUserBuilding(Connection conn, String userID, String status){
		
		   ArrayList<UserBuilding> ubArr = new ArrayList<>();
		   
		   String qry = "SELECT a.* from dbo.User_Building a WHERE userID = ? ";
		   
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
					ubArr.add(new UserBuilding(
							resultSet.getString("userID"),
							resultSet.getInt("buildingID"),
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

		   return ubArr;
	}
	
	public ArrayList<AdminUserBuilding> getUserBuildingList(Connection conn, String userID){
		
		   ArrayList<AdminUserBuilding> ubArr = new ArrayList<>();
		   
		   String qry = "SELECT * from dbo.User_Building ub INNER JOIN dbo.Building_Header bh on " + 
		   			"ub.BuildingID = bh.BuildingID where userID=? ";
			
			try{
				pstatement = conn.prepareStatement(qry);
				pstatement.setString(1, userID);
				
				resultSet = pstatement.executeQuery();
				while(resultSet.next()){
					ubArr.add(new AdminUserBuilding(
							resultSet.getString("userID"),
							resultSet.getInt("buildingID"),
							resultSet.getString("buildingName"), 
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

		   return ubArr;
	}
	
	public ArrayList<AdminUserBuilding> getUserBuildingNotRegistered(Connection conn, String userID){
		
		   ArrayList<AdminUserBuilding> ubArr = new ArrayList<>();
		   
		   String qry = "SELECT * from dbo.Building_Header bh where not exists (Select * from dbo.User_Building ub " +
					"where bh.buildingID = ub.buildingID and userID=?)";
			
			try{
				pstatement = conn.prepareStatement(qry);
				pstatement.setString(1, userID);
				
				resultSet = pstatement.executeQuery();
				while(resultSet.next()){
					ubArr.add(new AdminUserBuilding(
							userID,
							resultSet.getInt("buildingID"),
							resultSet.getString("buildingName"), 
							"D"));	
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

		   return ubArr;
	}

	public int editUserBuilding(Connection conn, List<UserBuilding> userBuild){
		
		   int isCreated = 0;
		    
		   try{
			   
			   for(UserBuilding ub : userBuild) {
				   int isRecordExists=0;
				   String qry = "SELECT count(*) FROM dbo.User_Building WHERE userID=? and buildingID=?";
				   
				   pstatement = conn.prepareStatement(qry);

				   pstatement.setString(1, ub.getUserID());
				   pstatement.setInt(2, ub.getBuildingId());
				   
				   resultSet = pstatement.executeQuery();
				   resultSet.next(); 
				   
				   isRecordExists = resultSet.getInt(1);
				   
				   if(isRecordExists > 0) {
					   isCreated += setStatus(conn, ub.getStatus(), ub.getUserID(), ub.getBuildingId(), 
							   ub.getCreatedBy(), ub.getCreationDate());
				   }else {
					   isCreated += setUserBuilding(conn, ub);
				   }   
			   }
			      
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
	
	public int setUserBuilding(Connection conn, UserBuilding userBuild){
		
		   int isCreated = 0;
		   
		   try{

				String qry = "INSERT INTO dbo.User_Building "
						+ "(userID, buildingID, "
						+ "createdBy, creationDate, modifiedBy, modifiedDate, status) "
						+ " VALUES" + "(?,?,?,?,?,?,?)";

				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, userBuild.getUserID());
				pstatement.setInt(2, userBuild.getBuildingId());
				pstatement.setString(3, userBuild.getCreatedBy());
				pstatement.setDate(4, userBuild.getCreationDate());
				pstatement.setString(5, userBuild.getModifiedBy());
				pstatement.setDate(6, userBuild.getModifiedDate());
				pstatement.setString(7, userBuild.getStatus());

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
	
	public int setStatus(Connection conn, String status, String userID, int buildingID, 
			String modifiedBy, Date modifiedDate){
		
		   int isSetStatus = 0;
		   
		   try {

			   String qry = "UPDATE dbo.User_Building set status=?, modifiedBy=?, "
						+ "modifiedDate=? WHERE userID =?";
			   
			   if(buildingID != 0) {
				   qry = qry + " and buildingID=?";
			   }
				
				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, status);
				pstatement.setString(2, modifiedBy);
				pstatement.setDate(3, modifiedDate);
				pstatement.setString(4, userID);
				
				if(buildingID != 0) {
					pstatement.setInt(5, buildingID);
				}
				
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
