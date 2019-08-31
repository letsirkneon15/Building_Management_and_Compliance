package com.bmc.pojo;

import java.util.Date;

public class HazardousSubstance {
	
	private int recordId; 
	private String buildingId; 
	private String productName;
	private int unNumber;
	private int approvalNumber;
	private String groupStandard;
	private String hazardClassification;
	private String currentSDSAvailable;
	private String specificStorage;
	private String segregationRequirements;
	private String containerSize;
	private String openCloseContainer;
	private String gasLiquidSolid;
	private String location;
	private int maximumLikelyAmount;
	private String createdBy;
	private Date creationDate;
	private String modifiedBy; 
	private Date modifiedDate;
	private String status;
	
	public HazardousSubstance(int recordId, String buildingId, String productName, int unNumber, int approvalNumber,
			String groupStandard, String hazardClassification, String currentSDSAvailable, String specificStorage,
			String segregationRequirements, String containerSize, String openCloseContainer, String gasLiquidSolid,
			String location, int maximumLikelyAmount, String createdBy, Date creationDate, String modifiedBy,
			Date modifiedDate, String status) {
		super();
		this.recordId = recordId;
		this.buildingId = buildingId;
		this.productName = productName;
		this.unNumber = unNumber;
		this.approvalNumber = approvalNumber;
		this.groupStandard = groupStandard;
		this.hazardClassification = hazardClassification;
		this.currentSDSAvailable = currentSDSAvailable;
		this.specificStorage = specificStorage;
		this.segregationRequirements = segregationRequirements;
		this.containerSize = containerSize;
		this.openCloseContainer = openCloseContainer;
		this.gasLiquidSolid = gasLiquidSolid;
		this.location = location;
		this.maximumLikelyAmount = maximumLikelyAmount;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getUnNumber() {
		return unNumber;
	}
	public void setUnNumber(int unNumber) {
		this.unNumber = unNumber;
	}
	public int getApprovalNumber() {
		return approvalNumber;
	}
	public void setApprovalNumber(int approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
	public String getGroupStandard() {
		return groupStandard;
	}
	public void setGroupStandard(String groupStandard) {
		this.groupStandard = groupStandard;
	}
	public String getHazardClassification() {
		return hazardClassification;
	}
	public void setHazardClassification(String hazardClassification) {
		this.hazardClassification = hazardClassification;
	}
	public String getCurrentSDSAvailable() {
		return currentSDSAvailable;
	}
	public void setCurrentSDSAvailable(String currentSDSAvailable) {
		this.currentSDSAvailable = currentSDSAvailable;
	}
	public String getSpecificStorage() {
		return specificStorage;
	}
	public void setSpecificStorage(String specificStorage) {
		this.specificStorage = specificStorage;
	}
	public String getSegregationRequirements() {
		return segregationRequirements;
	}
	public void setSegregationRequirements(String segregationRequirements) {
		this.segregationRequirements = segregationRequirements;
	}
	public String getContainerSize() {
		return containerSize;
	}
	public void setContainerSize(String containerSize) {
		this.containerSize = containerSize;
	}
	public String getOpenCloseContainer() {
		return openCloseContainer;
	}
	public void setOpenCloseContainer(String openCloseContainer) {
		this.openCloseContainer = openCloseContainer;
	}
	public String getGasLiquidSolid() {
		return gasLiquidSolid;
	}
	public void setGasLiquidSolid(String gasLiquidSolid) {
		this.gasLiquidSolid = gasLiquidSolid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMaximumLikelyAmount() {
		return maximumLikelyAmount;
	}
	public void setMaximumLikelyAmount(int maximumLikelyAmount) {
		this.maximumLikelyAmount = maximumLikelyAmount;
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
