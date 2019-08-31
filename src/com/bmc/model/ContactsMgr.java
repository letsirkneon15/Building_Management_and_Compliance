package com.bmc.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.bmc.pojo.Contacts;

public class ContactsMgr {
	
	public ArrayList<Contacts> getContacts(Connection conn, String buildingId){
		
		   ArrayList<Contacts> conArr = new ArrayList<>();
		   
		   return conArr;
	}
	

	public boolean setContacts(Connection conn, Contacts contact){
		
		   boolean isCreated = false;
		   
		   return isCreated;
	}
	
	public boolean updateContacts(Connection conn, Contacts contact){
		
		   boolean isUpdated = false;
		   
		   return isUpdated;
	}
	
	public boolean setStatus(Connection conn, int recordId){
		
		   boolean isSetStatus = false;
		   
		   return isSetStatus;
	}

}
