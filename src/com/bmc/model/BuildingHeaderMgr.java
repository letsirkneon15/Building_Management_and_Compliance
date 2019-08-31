package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.BuildingHeader;

public class BuildingHeaderMgr {
	
	public ArrayList<BuildingHeader> getBuildingHeader(Connection conn, String buildingId, String buildingName){
		
		   ArrayList<BuildingHeader> bhArr = new ArrayList<>();
		   
		   return bhArr;
	}
	

	public boolean setBuildingHeader(Connection conn, BuildingHeader buildHeader){
		
		   boolean isCreated = false;
		   
		   return isCreated;
	}
	
	public boolean updateBuildingHeader(Connection conn, BuildingHeader buildHeader){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, String buildingId){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}

}
