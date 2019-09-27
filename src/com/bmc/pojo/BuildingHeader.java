package com.bmc.pojo;

import java.io.Serializable;
import java.sql.Date;

public class BuildingHeader implements Serializable {
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
	private String createdBy;
	private Date creationDate;
	private String modifiedBy; 
	private Date modifiedDate;
	private String status;
	
	@Override
	public String toString() {
		return "BuildingHeader [buildingID=" + buildingID + ", buildingName=" + buildingName + ", address=" + address
				+ ", location=" + location + ", levelOrUnitNumber=" + levelOrUnitNumber + ", coordinates=" + coordinates
				+ ", owner=" + owner + ", client=" + client + ", responsibleOffice=" + responsibleOffice
				+ ", projectNumber=" + projectNumber + ", buildingInformation=" + buildingInformation + ", csNumber="
				+ csNumber + ", legalDescription=" + legalDescription + ", maxOccupants=" + maxOccupants
				+ ", fireHazardCategory=" + fireHazardCategory + ", yearBuilt=" + yearBuilt + ", intendedLife="
				+ intendedLife + ", bwofAnniversary=" + bwofAnniversary + ", asbestosPresent=" + asbestosPresent
				+ ", nbsPercentage=" + nbsPercentage + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", status=" + status + "]";
	}

	public BuildingHeader(int buildingID, String buildingName, String address, String location,
			String levelOrUnitNumber, String coordinates, String owner, String client, String responsibleOffice,
			String projectNumber, String buildingInformation, String csNumber, String legalDescription, int maxOccupants,
			String fireHazardCategory, int yearBuilt, String intendedLife, int bwofAnniversary, String asbestosPresent,
			float nbsPercentage, String createdBy, Date creationDate, String modifiedBy, Date modifiedDate,
			String status) {
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
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public BuildingHeader() {
		
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

	public void setbuildingInformation(String buildingInformation) {
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
