package com.bmc.pojo;

import java.util.Date;

public class Tab {
	
	private String tabId; 
	private String tabSegment; 
	private String description;
	private String createdBy;
	private Date creationDate;
	private String modifiedBy; 
	private Date modifiedDate;
	private String status;
	
	public Tab(String tabId, String tabSegment, String description, String createdBy, Date creationDate,
			String modifiedBy, Date modifiedDate, String status) {
		super();
		this.tabId = tabId;
		this.tabSegment = tabSegment;
		this.description = description;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}
	
	public String getTabId() {
		return tabId;
	}
	public void setTabId(String tabId) {
		this.tabId = tabId;
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
