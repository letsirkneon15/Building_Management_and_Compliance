package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.Tab;

public class TabMgr {
	
	public ArrayList<Tab> getTab(Connection conn, String tabId){
		
		   ArrayList<Tab> tabArr = new ArrayList<>();
		   
		   return tabArr;
	}
	

	public boolean setTab(Connection conn, Tab tab){
		
		   boolean isCreated = false;
		   
		   return isCreated;
	}
	
	public boolean updateTab(Connection conn, Tab tab){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, String tabId, String tabSegment){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}


}
