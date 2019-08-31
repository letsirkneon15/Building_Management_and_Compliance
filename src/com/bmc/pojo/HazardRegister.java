package com.bmc.pojo;

import java.util.Date;

public class HazardRegister {

	private int recordId; 
	private String buildingId; 
	private String identifiedHazard;
	private String initialRiskAssessment;
	private String controls;
	private String levelOfControl;
	private String residualRiskAssessment;
	private String createdBy;
	private Date creationDate;
	private String modifiedBy; 
	private Date modifiedDate;
	private String status;
	
	public HazardRegister(int recordId, String buildingId, String identifiedHazard, String initialRiskAssessment,
			String controls, String levelOfControl, String residualRiskAssessment, String createdBy, Date creationDate,
			String modifiedBy, Date modifiedDate, String status) {
		super();
		this.recordId = recordId;
		this.buildingId = buildingId;
		this.identifiedHazard = identifiedHazard;
		this.initialRiskAssessment = initialRiskAssessment;
		this.controls = controls;
		this.levelOfControl = levelOfControl;
		this.residualRiskAssessment = residualRiskAssessment;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}
	
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getIdentifiedHazard() {
		return identifiedHazard;
	}
	public void setIdentifiedHazard(String identifiedHazard) {
		this.identifiedHazard = identifiedHazard;
	}
	public String getInitialRiskAssessment() {
		return initialRiskAssessment;
	}
	public void setInitialRiskAssessment(String initialRiskAssessment) {
		this.initialRiskAssessment = initialRiskAssessment;
	}
	public String getControls() {
		return controls;
	}
	public void setControls(String controls) {
		this.controls = controls;
	}
	public String getLevelOfControl() {
		return levelOfControl;
	}
	public void setLevelOfControl(String levelOfControl) {
		this.levelOfControl = levelOfControl;
	}
	public String getResidualRiskAssessment() {
		return residualRiskAssessment;
	}
	public void setResidualRiskAssessment(String residualRiskAssessment) {
		this.residualRiskAssessment = residualRiskAssessment;
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
