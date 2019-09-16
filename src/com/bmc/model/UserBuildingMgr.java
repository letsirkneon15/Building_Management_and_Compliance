package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bmc.pojo.UserBuilding;

public class UserBuildingMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;
	
	public List<UserBuilding> getUserBuilding(Connection conn, String userID){
		
		   int frRowNum=0, toRowNum=0;
		
		   List<UserBuilding> ubArr = new ArrayList<>();
		   
		   String qry = "SELECT outer.* FROM (SELECT rownum rn, inner.* from("
					+ "SELECT a.* from dbo.User_Building a WHERE userID = ?" +
					" ) inner) outer WHERE outer.rn >= ? and outer.rn <= ?";

			System.out.println("Qry: " + qry + " frRowNum:" + frRowNum + " toRowNum: " + toRowNum);	
			
			try{
				pstatement = conn.prepareStatement(qry);
				
				pstatement.setString(1, userID);
				pstatement.setInt(2, frRowNum);
				pstatement.setInt(3, toRowNum);
				
				resultSet = pstatement.executeQuery();
				while(resultSet.next()){
					ubArr.add(new UserBuilding(
							resultSet.getString("userID"),
							resultSet.getInt("buildingID"),
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

		   return ubArr;
	}
	

	public boolean setUserBuilding(Connection conn, UserBuilding userBuild){
		
		   boolean isCreated = false;
		   
		   try{

				String qry = "INSERT INTO dbo.User_Building "
						+ "(userID, buildingID, "
						+ "createdBy, createdDate, modifiedBy, modifiedDate, status) "
						+ " VALUES" + "(?,?,?,?,?,?,?)";

				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, userBuild.getUserID());
				pstatement.setInt(2, userBuild.getBuildingId());
				pstatement.setString(3, userBuild.getCreatedBy());
				pstatement.setDate(4, (java.sql.Date) userBuild.getCreationDate());
				pstatement.setString(5, userBuild.getModifiedBy());
				pstatement.setDate(6, (java.sql.Date) userBuild.getModifiedDate());
				pstatement.setString(7, userBuild.getStatus());

				isCreated = pstatement.execute();
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
				pstatement.setDate(3, (java.sql.Date) modifiedDate);
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
