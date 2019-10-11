package com.bmc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.bmc.pojo.AdminUserTab;
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
						resultSet.getString("tabID"),
						resultSet.getString("tabSegment"),
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

		return utArr;
	}

	public ArrayList<AdminUserTab> getUserTabList(Connection conn, String userID, String tabIDParm){

		ArrayList<AdminUserTab> utArr = new ArrayList<>();
		String tabID = "";
		String tabDsp = "";
		String tabCrt = "";
		String tabDlt = "";
		String tabUpd = "";
		String tabDescription = "";

		String qry = "SELECT * from dbo.User_Tab ut INNER JOIN dbo.Tab at on " + 
				"ut.tabID = at.tabID AND ut.tabSegment = at.tabSegment WHERE userID=? ";

		if(!tabIDParm.equals("")) {
			qry = qry + "AND ut.tabID=? ";
		}

		qry = qry + "ORDER BY ut.tabID";

		try{
			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID);

			if(!tabIDParm.equals("")) {
				pstatement.setString(2, tabIDParm);
			}

			resultSet = pstatement.executeQuery();
			while(resultSet.next()){

				if(!tabID.equals(resultSet.getString("tabID"))) {

					utArr.add(new AdminUserTab(userID, tabID, tabDescription, tabDsp, tabCrt, 
							tabUpd, tabDlt));

					tabDsp = "";
					tabCrt = "";
					tabUpd = "";
					tabDlt = "";
					
					tabDescription = resultSet.getString("tabDescription");
				}

				switch (resultSet.getString("tabSegment")) {

				case "CRT":
					if(resultSet.getString("status").trim().equals("")
							|| resultSet.getString("status") == null) {
						tabCrt = resultSet.getString("tabSegment");
					}
					break;
				case "DLT":
					if(resultSet.getString("status").trim().equals("")
							|| resultSet.getString("status") == null) {
						tabDlt = resultSet.getString("tabSegment");
					}
					
					break;
				case "UPD":
					if(resultSet.getString("status").trim().equals("")
							|| resultSet.getString("status") == null) {
						tabUpd = resultSet.getString("tabSegment");
					}
					break;
				case "DSP":
					if(resultSet.getString("status").trim().equals("")
							|| resultSet.getString("status") == null) {
						tabDsp = resultSet.getString("tabSegment");
					}
					break;
				}
				
				tabID = resultSet.getString("tabID");

			}	
			utArr.add(new AdminUserTab(userID, tabID, tabDescription, tabDsp, tabCrt, 
					tabUpd, tabDlt));
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
	
	public AdminUserTab getAdminUserTab(Connection conn, String userID, String tabIDParm){

		AdminUserTab ut = new AdminUserTab();
		String tabID = "";
		String tabDsp = "";
		String tabCrt = "";
		String tabDlt = "";
		String tabUpd = "";
		String tabDescription = "";

		String qry = "SELECT * from dbo.User_Tab ut INNER JOIN dbo.Tab at on " + 
				"ut.tabID = at.tabID AND ut.tabSegment = at.tabSegment WHERE userID=? AND ut.tabID=?";

		qry = qry + " ORDER BY ut.tabID";

		try{
			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID);
			pstatement.setString(2, tabIDParm);

			resultSet = pstatement.executeQuery();
			while(resultSet.next()){

				if(!tabID.equals(resultSet.getString("tabID"))) {

					ut = new AdminUserTab(userID, tabID, tabDescription, tabDsp, tabCrt, 
							tabUpd, tabDlt);

					tabDsp = "";
					tabCrt = "";
					tabUpd = "";
					tabDlt = "";
					
					tabDescription = resultSet.getString("tabDescription");
				}

				switch (resultSet.getString("tabSegment")) {

				case "CRT":
					if(resultSet.getString("status").trim().equals("")
							|| resultSet.getString("status") == null) {
						tabCrt = resultSet.getString("tabSegment");
					}
					break;
				case "DLT":
					if(resultSet.getString("status").trim().equals("")
							|| resultSet.getString("status") == null) {
						tabDlt = resultSet.getString("tabSegment");
					}
					
					break;
				case "UPD":
					if(resultSet.getString("status").trim().equals("")
							|| resultSet.getString("status") == null) {
						tabUpd = resultSet.getString("tabSegment");
					}
					break;
				case "DSP":
					if(resultSet.getString("status").trim().equals("")
							|| resultSet.getString("status") == null) {
						tabDsp = resultSet.getString("tabSegment");
					}
					break;
				}
				
				tabID = resultSet.getString("tabID");

			}	
			ut = new AdminUserTab(userID, tabID, tabDescription, tabDsp, tabCrt, 
					tabUpd, tabDlt);
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

		return ut;
	}

	public ArrayList<AdminUserTab> getUserTabNotRegistered(Connection conn, String userID, String tabIDParm){

		ArrayList<AdminUserTab> utArr = new ArrayList<>();
		String tabDsp = "";
		String tabCrt = "";
		String tabDlt = "";
		String tabUpd = "";

		String qry = "SELECT tabID, tabDescription from dbo.Tab at where not exists (Select * from dbo.User_Tab ut " + 
				"where at.tabID = ut.tabID and userID=?)";

		if(!tabIDParm.equals("")) {
			qry = qry + " AND at.tabID=?";
		}

		qry = qry + " GROUP by tabID, tabDescription";
				
		try{
			pstatement = conn.prepareStatement(qry);
			pstatement.setString(1, userID);

			if(!tabIDParm.equals("")) {
				pstatement.setString(2, tabIDParm);
			}
			resultSet = pstatement.executeQuery();
			while(resultSet.next()){
				
				utArr.add(new AdminUserTab(userID, resultSet.getString("tabID"), resultSet.getString("tabDescription"), 
						tabDsp, tabCrt,	tabUpd, tabDlt));
			
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

	public int editUserTab(Connection conn, List<UserTab> userTab){
		
		   int isCreated = 0;
		    
		   try{
			   
			   for(UserTab ut : userTab) {
				   int isRecordExists=0;
				   if(ut!=null) {
					   
					   System.out.println("status: " + ut.getStatus() + " userID: " + ut.getUserID() + 
							   " tabID: " + ut.getTabID() + " tabSegment: " + ut.getTabSegment() + 
							   " CreatedBy: " + ut.getCreatedBy() + " CreationDate: " + ut.getCreationDate());
					   
					   String qry = "SELECT count(*) FROM dbo.User_Tab WHERE userID=? AND tabID=? AND tabSegment=?";
					   
					   pstatement = conn.prepareStatement(qry);

					   pstatement.setString(1, ut.getUserID());
					   pstatement.setString(2, ut.getTabID());
					   pstatement.setString(3, ut.getTabSegment());
					   
					   resultSet = pstatement.executeQuery();
					   resultSet.next(); 
					   
					   isRecordExists = resultSet.getInt(1);
					   
					   if(isRecordExists > 0) {
						   isCreated += setStatus(conn, ut.getStatus(), ut.getUserID(), ut.getTabID(), 
								   ut.getTabSegment(), ut.getCreatedBy(), ut.getCreationDate());
					   }else {
						   isCreated += setUserTab(conn, ut);
					   }   
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
	
	public int setUserTab(Connection conn, UserTab uTab){

		int isCreated = 0;

		try{

			String qry = "INSERT INTO dbo.User_Tab "
					+ "(userID, tabID, tabSegment, "
					+ "createdBy, creationDate, modifiedBy, modifiedDate, status) "
					+ " VALUES" + "(?,?,?,?,?,?,?,?)";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, uTab.getUserID());
			pstatement.setString(2, uTab.getTabID());
			pstatement.setString(3, uTab.getTabSegment());
			pstatement.setString(4, uTab.getCreatedBy());
			pstatement.setDate(5, uTab.getCreationDate());
			pstatement.setString(6, uTab.getModifiedBy());
			pstatement.setDate(7, uTab.getModifiedDate());
			pstatement.setString(8, uTab.getStatus());

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


	public int setStatus(Connection conn, String status, String userID, String tabID, String tabSegment, 
			String modifiedBy, Date modifiedDate){

		int isSetStatus = 0;

		try {

			String qry = "UPDATE dbo.User_Tab set status=?, modifiedBy=?, "
					+ "modifiedDate=? WHERE userID =? and tabID=? and tabSegment=?";

			pstatement = conn.prepareStatement(qry);

			pstatement.setString(1, status);
			pstatement.setString(2, modifiedBy);
			pstatement.setDate(3, modifiedDate);
			pstatement.setString(4, userID);
			pstatement.setString(5, tabID);
			pstatement.setString(6, tabSegment);

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
	
	public String getTabSegmentAcronym(String status, String tabSegment) {
		
		String tabSegmentAcronym = "";
		
		switch (tabSegment) {

		case "CRT":
			if(status.trim().equals("")	|| status == null) {
				tabSegmentAcronym = tabSegment;
			}
			
			break;
		case "DLT":
			if(status.trim().equals("") || status == null) {
				tabSegmentAcronym = tabSegment;
			}
			
			break;
		case "UPD":
			if(status.trim().equals("") || status == null) {
				tabSegmentAcronym = tabSegment;
			}
			break;
		case "DSP":
			if(status.trim().equals("") || status == null) {
				tabSegmentAcronym = tabSegment;
			}
			break;
		}
		
		return tabSegmentAcronym;
		
	}
}
