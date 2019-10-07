package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.bmc.pojo.UserTab;

public class UserTabMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;
	
	public ArrayList<UserTab> getUserTab(Connection conn, String userID, String status){
		   
		   ArrayList<UserTab> utArr = new ArrayList<>();
		   
		   String qry = "SELECT a.* from dbo.User_Tab a WHERE userID=? ";
		   
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
	
	public ArrayList<UserTab> getUserTabList(Connection conn, String status){
		   
		   ArrayList<UserTab> utArr = new ArrayList<>();
		   
		   String qry = "SELECT * from dbo.User_Tab WHERE ";
		   
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

	public int setUserTab(Connection conn, UserTab uTab){
		
		   int isCreated = 0;
		   
		   try{

				String qry = "INSERT INTO dbo.User_Tab "
						+ "(userID, tabID, tabSegment "
						+ "createdBy, createdDate, modifiedBy, modifiedDate, status) "
						+ " VALUES" + "(?,?,?,?,?,?,?,?)";

				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, uTab.getUserID());
				pstatement.setInt(2, uTab.getTabID());
				pstatement.setString(3, uTab.getTabSegment());
				pstatement.setDate(4, uTab.getCreationDate());
				pstatement.setString(5, uTab.getModifiedBy());
				pstatement.setDate(6, uTab.getModifiedDate());
				pstatement.setString(7, uTab.getStatus());

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
				pstatement.setDate(3, modifiedDate);
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
