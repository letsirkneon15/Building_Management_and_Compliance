package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.User;

public class UserMgr {
	
	public ArrayList<User> getUser(Connection conn, String userId){
		
		   ArrayList<User> userArr = new ArrayList<>();
		   
		   return userArr;
	}
	

	public boolean setUser(Connection conn, User user){
		
		   boolean isCreated = false;
		   
		   return isCreated;
	}
	
	public boolean updateUser(Connection conn, User user){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, String userId){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}

}
