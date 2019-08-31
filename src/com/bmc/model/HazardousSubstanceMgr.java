package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.HazardousSubstance;

public class HazardousSubstanceMgr {
	
	public ArrayList<HazardousSubstance> getHazardousSubstance(Connection conn, String buildingId){
		
		   ArrayList<HazardousSubstance> hsArr = new ArrayList<>();
		   
		   return hsArr;
	}
	

	public boolean setHazardousSubstance(Connection conn, HazardousSubstance hazardSub){
		
		   boolean isCreated = false;
		   
		   return isCreated;
	}
	
	public boolean updateHazardousSubstance(Connection conn, HazardousSubstance hazardSub){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, int recordId){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}

}
