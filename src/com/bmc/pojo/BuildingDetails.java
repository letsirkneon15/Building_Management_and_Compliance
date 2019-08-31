package com.bmc.pojo;

import java.util.Date;

public class BuildingDetails {
	
	private int recordId; 
	private String buildingDetailsType;
	private String buildingId; 
	private String name;
	private String attachment;
	private String type;
	private int titledYear;
	private int consentNumber;
	private String uploadedBy;
	private Date uploadedDate;
	private String lastUploadedBy; 
	private Date lastUploadedDate;
	private String status;
	
	public BuildingDetails(int recordId, String buildingDetailsType, String buildingId, String name, String attachment,
			String type, int titledYear, int consentNumber, String uploadedBy, Date uploadedDate, String lastUploadedBy,
			Date lastUploadedDate, String status) {
		super();
		this.recordId = recordId;
		this.buildingDetailsType = buildingDetailsType;
		this.buildingId = buildingId;
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
	
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String getBuildingDetailsType() {
		return buildingDetailsType;
	}
	public void setBuildingDetailsType(String buildingDetailsType) {
		this.buildingDetailsType = buildingDetailsType;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
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
	public int getConsentNumber() {
		return consentNumber;
	}
	public void setConsentNumber(int consentNumber) {
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
