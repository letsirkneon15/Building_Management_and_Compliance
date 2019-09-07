package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.BuildingDetails;

public class BuildingDetailsMgr {
	
	public ArrayList<BuildingDetails> getBuildingDetails(Connection conn, String buildingId, String buildingName){
		
		   ArrayList<BuildingDetails> bdArr = new ArrayList<>();
		   
		   return bdArr;
	}
	

	public boolean setBuildingDetails(Connection conn, BuildingDetails buildDetails){
		
		   boolean isCreated = false;
		   
		   
		   
		   return isCreated;	
	}
	
	public boolean updateBuildingDetails(Connection conn, BuildingDetails buildDetails){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, int recordId){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}
	
}
