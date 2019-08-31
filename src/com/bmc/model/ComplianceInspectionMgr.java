package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.ComplianceInspection;

public class ComplianceInspectionMgr {
	
	public ArrayList<ComplianceInspection> getComplianceInspection(Connection conn, String buildingId){
		
		   ArrayList<ComplianceInspection> ciArr = new ArrayList<>();
		   
		   return ciArr;
	}
	

	public boolean setComplianceInspection(Connection conn, ComplianceInspection comInspection){
		
		   boolean isCreated = false;
		   
		   return isCreated;
	}
	
	public boolean updateComplianceInspection(Connection conn, ComplianceInspection comInspection){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, int recordId){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}

}
