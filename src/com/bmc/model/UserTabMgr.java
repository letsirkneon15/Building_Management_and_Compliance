package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.UserTab;

public class UserTabMgr {
	
	public ArrayList<UserTab> getUserTab(Connection conn, String userId){
		
		   ArrayList<UserTab> utArr = new ArrayList<>();
		   
		   return utArr;
	}
	

	public boolean setUserTab(Connection conn, UserTab uTab){
		
		   boolean isCreated = false;
		   
		   return isCreated;
	}
	
	public boolean updateUserTab(Connection conn, UserTab uTab){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, String userId, String tabId, String tabSegment){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}

}
