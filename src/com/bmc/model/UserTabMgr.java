package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.bmc.pojo.UserTab;

public class UserTabMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;
	
	public ArrayList<UserTab> getUserTab(Connection conn, String userID){
		   
		   ArrayList<UserTab> utArr = new ArrayList<>();
		   
		   String qry = "SELECT a.* from dbo.User_Tab a WHERE userID=?";
			
			try{
				pstatement = conn.prepareStatement(qry);
				
				pstatement.setString(1, userID);
				
				resultSet = pstatement.executeQuery();
				while(resultSet.next()){
					utArr.add(new UserTab(
							resultSet.getString("userID"),
							resultSet.getInt("tabID"),
							resultSet.getString("tabSegment"),
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
		   
		   return utArr;
	}
	

	public boolean setUserTab(Connection conn, UserTab uTab){
		
		   boolean isCreated = false;
		   
		   try{

				String qry = "INSERT INTO dbo.User_Tab "
						+ "(userID, tabID, tabSegment "
						+ "createdBy, createdDate, modifiedBy, modifiedDate, status) "
						+ " VALUES" + "(?,?,?,?,?,?,?,?)";

				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, uTab.getUserID());
				pstatement.setInt(2, uTab.getTabID());
				pstatement.setString(3, uTab.getTabSegment());
				pstatement.setDate(4, (java.sql.Date) uTab.getCreationDate());
				pstatement.setString(5, uTab.getModifiedBy());
				pstatement.setDate(6, (java.sql.Date) uTab.getModifiedDate());
				pstatement.setString(7, uTab.getStatus());

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

	
	public int setStatus(Connection conn, String status, String userID, int tabID, String tabSegment, 
			String modifiedBy, Date modifiedDate){
		
		   int isSetStatus = 0;
		   
		   try {

			   String qry = "UPDATE dbo.User_Tab set status=?, modifiedBy=?, "
						+ "modifiedDate=? WHERE userID =?";
			   
			   if(tabID != 0) {
				   qry = qry + " and tabID=?";
			   }
			   
			   if(!tabSegment.equals("")) {
				   qry = qry + " and tabSegment=?";
			   }
				
				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, status);
				pstatement.setString(2, modifiedBy);
				pstatement.setDate(3, (java.sql.Date) modifiedDate);
				pstatement.setString(4, userID);
				
				if(tabID != 0) {
					pstatement.setInt(5, tabID);
				}
				   
				if(!tabSegment.equals("")) {
					pstatement.setString(6, tabSegment);
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
