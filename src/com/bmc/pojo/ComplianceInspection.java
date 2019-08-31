package com.bmc.pojo;

import java.sql.Blob;
import java.util.Date;

public class ComplianceInspection {
	
	private String buildingId; 
	private Date inspectionDate;
	private String finding;
	private String description;
	private String inspectionStatus;
	private Blob image; 
	private String createdBy;
	private Date creationDate;
	private String modifiedBy; 
	private Date modifiedDate;
	private String status;
	
	public ComplianceInspection(String buildingId, Date inspectionDate, String finding, String description,
			String inspectionStatus, Blob image, String createdBy, Date creationDate, String modifiedBy,
			Date modifiedDate, String status) {
		super();
		this.buildingId = buildingId;
		this.inspectionDate = inspectionDate;
		this.finding = finding;
		this.description = description;
		this.inspectionStatus = inspectionStatus;
		this.image = image;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}
	
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public Date getInspectionDate() {
		return inspectionDate;
	}
	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}
	public String getFinding() {
		return finding;
	}
	public void setFinding(String finding) {
		this.finding = finding;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInspectionStatus() {
		return inspectionStatus;
	}
	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
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
