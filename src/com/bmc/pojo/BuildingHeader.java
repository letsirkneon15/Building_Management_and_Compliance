package com.bmc.pojo;

import java.util.Date;

public class BuildingHeader {
 
	private String buildingId; 
	private String buildingName;
	private String address;
	private String location;
	private int levelOrUnitNumber;
	private int coordinates;
	private String owner;
	private String client;
	private String responsibleOffice;
	private int projectNumber;
	private String billingInformation;
	private int csNumber;
	private String legalDescription;
	private int maxOccupants;
	private String fireHazardCategory;
	private int yearBuilt;
	private String intendedLife;
	private Date bwofAnniversary;
	private String asbestosPresent;
	private int nbsPercentage;
	private String createdBy;
	private Date creationDate;
	private String modifiedBy; 
	private Date modifiedDate;
	private String status;
	
	public BuildingHeader(String buildingId, String buildingName, String address, String location,
			int levelOrUnitNumber, int coordinates, String owner, String client, String responsibleOffice,
			int projectNumber, String billingInformation, int csNumber, String legalDescription, int maxOccupants,
			String fireHazardCategory, int yearBuilt, String intendedLife, Date bwofAnniversary, String asbestosPresent,
			int nbsPercentage, String createdBy, Date creationDate, String modifiedBy, Date modifiedDate,
			String status) {
		super();
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.address = address;
		this.location = location;
		this.levelOrUnitNumber = levelOrUnitNumber;
		this.coordinates = coordinates;
		this.owner = owner;
		this.client = client;
		this.responsibleOffice = responsibleOffice;
		this.projectNumber = projectNumber;
		this.billingInformation = billingInformation;
		this.csNumber = csNumber;
		this.legalDescription = legalDescription;
		this.maxOccupants = maxOccupants;
		this.fireHazardCategory = fireHazardCategory;
		this.yearBuilt = yearBuilt;
		this.intendedLife = intendedLife;
		this.bwofAnniversary = bwofAnniversary;
		this.asbestosPresent = asbestosPresent;
		this.nbsPercentage = nbsPercentage;
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
	public int getLevelOrUnitNumber() {
		return levelOrUnitNumber;
	}
	public void setLevelOrUnitNumber(int levelOrUnitNumber) {
		this.levelOrUnitNumber = levelOrUnitNumber;
	}
	public int getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(int coordinates) {
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
	public int getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getBillingInformation() {
		return billingInformation;
	}
	public void setBillingInformation(String billingInformation) {
		this.billingInformation = billingInformation;
	}
	public int getCsNumber() {
		return csNumber;
	}
	public void setCsNumber(int csNumber) {
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
	public Date getBwofAnniversary() {
		return bwofAnniversary;
	}
	public void setBwofAnniversary(Date bwofAnniversary) {
		this.bwofAnniversary = bwofAnniversary;
	}
	public String getAsbestosPresent() {
		return asbestosPresent;
	}
	public void setAsbestosPresent(String asbestosPresent) {
		this.asbestosPresent = asbestosPresent;
	}
	public int getNbsPercentage() {
		return nbsPercentage;
	}
	public void setNbsPercentage(int nbsPercentage) {
		this.nbsPercentage = nbsPercentage;
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
