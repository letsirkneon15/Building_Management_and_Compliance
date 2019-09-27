package com.bmc.pojo;

import java.io.Serializable;
import java.sql.Date;

public class BuildingDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int recordID; 
	private String buildingDetailsType;
	private int buildingID; 
	private String name;
	private String attachment;
	private String type;
	private int titledYear;
	private String consentNumber;
	private String uploadedBy;
	private Date uploadedDate;
	private String lastUploadedBy; 
	private Date lastUploadedDate;
	private String status;
	
	public BuildingDetails(int recordID, String buildingDetailsType, int buildingID, String name, String attachment,
			String type, int titledYear, String consentNumber, String uploadedBy, Date uploadedDate,
			String lastUploadedBy, Date lastUploadedDate, String status) {
		super();
		this.recordID = recordID;
		this.buildingDetailsType = buildingDetailsType;
		this.buildingID = buildingID;
		this.name = name;
		this.attachment = attachment;
		this.type = type;
		this.titledYear = titledYear;
		this.consentNumber = consentNumber;
		this.uploadedBy = uploadedBy;
		this.uploadedDate = uploadedDate;
		this.lastUploadedBy = lastUploadedBy;
		this.lastUploadedDate = lastUploadedDate;
		this.status = status;
	}
	
	public BuildingDetails() {
		
	}

	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public String getBuildingDetailsType() {
		return buildingDetailsType;
	}
	public void setBuildingDetailsType(String buildingDetailsType) {
		this.buildingDetailsType = buildingDetailsType;
	}
	public int getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTitledYear() {
		return titledYear;
	}
	public void setTitledYear(int titledYear) {
		this.titledYear = titledYear;
	}
	public String getConsentNumber() {
		return consentNumber;
	}
	public void setConsentNumber(String consentNumber) {
		this.consentNumber = consentNumber;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	public String getLastUploadedBy() {
		return lastUploadedBy;
	}
	public void setLastUploadedBy(String lastUploadedBy) {
		this.lastUploadedBy = lastUploadedBy;
	}
	public Date getLastUploadedDate() {
		return lastUploadedDate;
	}
	public void setLastUploadedDate(Date lastUploadedDate) {
		this.lastUploadedDate = lastUploadedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
