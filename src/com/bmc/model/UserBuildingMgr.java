package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.UserBuilding;

public class UserBuildingMgr {
	
	public ArrayList<UserBuilding> getUserBuilding(Connection conn, String userId){
		
		   ArrayList<UserBuilding> ubArr = new ArrayList<>();
		   
		   return ubArr;
	}
	

	public boolean setUserBuilding(Connection conn, UserBuilding userBuild){
		
		   boolean isCreated = false;
		   
		   return isCreated;
	}
	
	public boolean updateUserBuilding(Connection conn, UserBuilding userBuild){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, String userId, String buildingId){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}


}
