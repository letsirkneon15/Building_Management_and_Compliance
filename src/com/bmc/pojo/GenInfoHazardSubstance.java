package com.bmc.pojo;

import java.io.Serializable;

public class GenInfoHazardSubstance implements Serializable {
	private static final long serialVersionUID = 1L;
 
	private int buildingID; 
	private String buildingName;
	private String address;
	private String location;
	private String levelOrUnitNumber;
	private String coordinates;
	private String owner;
	private String client;
	private String responsibleOffice;
	private String projectNumber;
	private String buildingInformation;
	private String csNumber;
	private String legalDescription;
	private int maxOccupants;
	private String fireHazardCategory;
	private int yearBuilt;
	private String intendedLife;
	private int bwofAnniversary;
	private String asbestosPresent;
	private float nbsPercentage;
	private int recordID; 
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
	private String hazlocation;
	private int maximumLikelyAmount;
	
	public GenInfoHazardSubstance(int buildingID, String buildingName, String address, String location,
			String levelOrUnitNumber, String coordinates, String owner, String client, String responsibleOffice,
			String projectNumber, String buildingInformation, String csNumber, String legalDescription,
			int maxOccupants, String fireHazardCategory, int yearBuilt, String intendedLife, int bwofAnniversary,
			String asbestosPresent, float nbsPercentage, int recordID, String productName, String unNumber,
			String approvalNumber, String groupStandard, String hazardClassification, String currentSDSAvailable,
			String specificStorage, String segregationRequirements, String containerSize, String openCloseContainer,
			String gasLiquidSolid, String hazlocation, int maximumLikelyAmount) {
		super();
		this.buildingID = buildingID;
		this.buildingName = buildingName;
		this.address = address;
		this.location = location;
		this.levelOrUnitNumber = levelOrUnitNumber;
		this.coordinates = coordinates;
		this.owner = owner;
		this.client = client;
		this.responsibleOffice = responsibleOffice;
		this.projectNumber = projectNumber;
		this.buildingInformation = buildingInformation;
		this.csNumber = csNumber;
		this.legalDescription = legalDescription;
		this.maxOccupants = maxOccupants;
		this.fireHazardCategory = fireHazardCategory;
		this.yearBuilt = yearBuilt;
		this.intendedLife = intendedLife;
		this.bwofAnniversary = bwofAnniversary;
		this.asbestosPresent = asbestosPresent;
		this.nbsPercentage = nbsPercentage;
		this.recordID = recordID;
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
		this.hazlocation = hazlocation;
		this.maximumLikelyAmount = maximumLikelyAmount;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLevelOrUnitNumber() {
		return levelOrUnitNumber;
	}
	public void setLevelOrUnitNumber(String levelOrUnitNumber) {
		this.levelOrUnitNumber = levelOrUnitNumber;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getResponsibleOffice() {
		return responsibleOffice;
	}
	public void setResponsibleOffice(String responsibleOffice) {
		this.responsibleOffice = responsibleOffice;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getBuildingInformation() {
		return buildingInformation;
	}
	public void setBuildingInformation(String buildingInformation) {
		this.buildingInformation = buildingInformation;
	}
	public String getCsNumber() {
		return csNumber;
	}
	public void setCsNumber(String csNumber) {
		this.csNumber = csNumber;
	}
	public String getLegalDescription() {
		return legalDescription;
	}
	public void setLegalDescription(String legalDescription) {
		this.legalDescription = legalDescription;
	}
	public int getMaxOccupants() {
		return maxOccupants;
	}
	public void setMaxOccupants(int maxOccupants) {
		this.maxOccupants = maxOccupants;
	}
	public String getFireHazardCategory() {
		return fireHazardCategory;
	}
	public void setFireHazardCategory(String fireHazardCategory) {
		this.fireHazardCategory = fireHazardCategory;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	public String getIntendedLife() {
		return intendedLife;
	}
	public void setIntendedLife(String intendedLife) {
		this.intendedLife = intendedLife;
	}
	public int getBwofAnniversary() {
		return bwofAnniversary;
	}
	public void setBwofAnniversary(int bwofAnniversary) {
		this.bwofAnniversary = bwofAnniversary;
	}
	public String getAsbestosPresent() {
		return asbestosPresent;
	}
	public void setAsbestosPresent(String asbestosPresent) {
		this.asbestosPresent = asbestosPresent;
	}
	public float getNbsPercentage() {
		return nbsPercentage;
	}
	public void setNbsPercentage(float nbsPercentage) {
		this.nbsPercentage = nbsPercentage;
	}
	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
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
	public String getHazlocation() {
		return hazlocation;
	}
	public void setHazlocation(String hazlocation) {
		this.hazlocation = hazlocation;
	}
	public int getMaximumLikelyAmount() {
		return maximumLikelyAmount;
	}
	public void setMaximumLikelyAmount(int maximumLikelyAmount) {
		this.maximumLikelyAmount = maximumLikelyAmount;
	}
}
