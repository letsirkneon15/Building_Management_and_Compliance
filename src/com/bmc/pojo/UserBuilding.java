package com.bmc.pojo;

import java.io.Serializable;
import java.sql.Date;

public class UserBuilding implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userID; 
	private int buildingId; 
	private String createdBy;
	private Date creationDate;
	private String modifiedBy; 
	private Date modifiedDate;
	private String status;
	
	public UserBuilding(String userID, int buildingId, String createdBy, Date creationDate, String modifiedBy,
			Date modifiedDate, String status) {
		super();
		this.userID = userID;
		this.buildingId = buildingId;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public UserBuilding(String userID, int buildingId, String createdBy, Date creationDate, String status) {
		super();
		this.userID = userID;
		this.buildingId = buildingId;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.status = status;
	}

	public UserBuilding() {
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
