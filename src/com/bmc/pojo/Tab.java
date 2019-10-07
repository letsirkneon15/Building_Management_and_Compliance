package com.bmc.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Tab implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tabID; 
	private String tabSegment; 
	private String description;
	private String createdBy;
	private Date creationDate;
	private String modifiedBy; 
	private Date modifiedDate;
	private String status;
	
	public Tab(String tabID, String tabSegment, String description, String createdBy, Date creationDate, String modifiedBy,
			Date modifiedDate, String status) {
		super();
		this.tabID = tabID;
		this.tabSegment = tabSegment;
		this.description = description;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public String getTabID() {
		return tabID;
	}

	public void setTabID(String tabID) {
		this.tabID = tabID;
	}

	public String getTabSegment() {
		return tabSegment;
	}

	public void setTabSegment(String tabSegment) {
		this.tabSegment = tabSegment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
