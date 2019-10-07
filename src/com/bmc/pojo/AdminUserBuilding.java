package com.bmc.pojo;

import java.io.Serializable;

public class AdminUserBuilding implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userID; 
	private int buildingID; 
	private String buildingName;
	private String status;

	public AdminUserBuilding(String userID, int buildingID, String buildingName, String status) {
		super();
		this.userID = userID;
		this.buildingID = buildingID;
		this.buildingName = buildingName;
		this.status = status;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
