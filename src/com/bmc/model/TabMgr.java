package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.bmc.pojo.Tab;

public class TabMgr {
	
	private PreparedStatement pstatement;
	private ResultSet resultSet;
	
	public ArrayList<Tab> getTab(Connection conn, int tabID, String tabDescription){
		
		   ArrayList<Tab> tabArr = new ArrayList<>();
		   
		   String qry = "SELECT * from dbo.Tab WHERE tabID Like ? AND tabDescription Like ? ";
			
			try{
				pstatement = conn.prepareStatement(qry);
				
				pstatement.setInt(1, tabID);
				pstatement.setString(2, tabDescription);
				
				resultSet = pstatement.executeQuery();
				while(resultSet.next()){
					tabArr.add(new Tab(
							resultSet.getInt("tabID"),
							resultSet.getString("tabSegment"),
							resultSet.getString("TabDescription"),
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
		   
		   return tabArr;
	}
	

	public boolean setTab(Connection conn, Tab tab){
		
		   boolean isCreated = false;
		   
		   try{

				String qry = "INSERT INTO dbo.Tab "
						+ "(tabID, tabSegment, tabDescription "
						+ "createdBy, createdDate, modifiedBy, modifiedDate, status) "
						+ " VALUES" + "(?,?,?,?,?,?,?,?)";

				pstatement = conn.prepareStatement(qry);

				pstatement.setInt(1, tab.getTabID());
				pstatement.setString(2, tab.getTabSegment());
				pstatement.setString(3, tab.getDescription());
				pstatement.setDate(4, (java.sql.Date) tab.getCreationDate());
				pstatement.setString(5, tab.getModifiedBy());
				pstatement.setDate(6, (java.sql.Date) tab.getModifiedDate());
				pstatement.setString(7, tab.getStatus());

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
	
	public int updateTab(Connection conn, Tab tab){
		
		   int isUpdated = 0;
		   
		   try {
				String qry = "UPDATE dbo.Tab set "
						+ "tabSegment=?, tabDescription=?, status=?, modifiedBy=?, modifiedDate=? "
						+ "where tabID=? ";

				pstatement = conn.prepareStatement(qry);
				
				pstatement.setString(1, tab.getTabSegment());
				pstatement.setString(2, tab.getDescription());
				pstatement.setString(3, tab.getStatus());
				pstatement.setString(4, tab.getModifiedBy());
				pstatement.setDate(5, (java.sql.Date) tab.getModifiedDate());
				pstatement.setInt(6, tab.getTabID());
				

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
	
	public int setStatus(Connection conn, String status, int tabID, String tabSegment, String modifiedBy, Date modifiedDate){
		
		   int isSetStatus = 0;
		   
		   try {

			   String qry = "UPDATE dbo.Tab set status=?, modifiedBy=?, "
						+ "modifiedDate=? WHERE tabID =?";
			   
			   if(!tabSegment.equals("")) {
				   qry = qry + " and tabSegment=?";
			   }
				
				pstatement = conn.prepareStatement(qry);

				pstatement.setString(1, status);
				pstatement.setString(2, modifiedBy);
				pstatement.setDate(3, (java.sql.Date) modifiedDate);
				pstatement.setInt(4, tabID);
				
				if(!tabSegment.equals("")) {
					pstatement.setString(5, tabSegment);
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
