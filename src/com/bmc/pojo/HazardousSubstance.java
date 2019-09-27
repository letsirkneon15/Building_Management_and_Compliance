package com.bmc.pojo;

import java.io.Serializable;
import java.sql.Date;

public class HazardousSubstance implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int recordID; 
	private int buildingID; 
	private String productName;
	private String unNumber;
	private String approvalNumber;
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
	private Date createdDate;
	private String modifiedBy; 
	private Date modifiedDate;
	private String status;
	
	public HazardousSubstance(int recordID, int buildingID, String productName, String unNumber, String approvalNumber,
			String groupStandard, String hazardClassification, String currentSDSAvailable, String specificStorage,
			String segregationRequirements, String containerSize, String openCloseContainer, String gasLiquidSolid,
			String location, int maximumLikelyAmount, String createdBy, Date createdDate, String modifiedBy,
			Date modifiedDate, String status) {
		super();
		this.recordID = recordID;
		this.buildingID = buildingID;
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
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public HazardousSubstance() {
		
	}

	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public int getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnNumber() {
		return unNumber;
	}

	public void setUnNumber(String unNumber) {
		this.unNumber = unNumber;
	}

	public String getApprovalNumber() {
		return approvalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
