package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.HazardRegister;

public class HazardRegisterMgr {
	
	public ArrayList<HazardRegister> getHazardRegister(Connection conn, String buildingId){
		
		   ArrayList<HazardRegister> hrArr = new ArrayList<>();
		   
		   return hrArr;
	}
	

	public boolean setHazardRegister(Connection conn, HazardRegister hazardReg){
		
		   boolean isCreated = false;
		   
		   return isCreated;
	}
	
	public boolean updateHazardRegister(Connection conn, HazardRegister hazardReg){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, int recordId){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}

}
