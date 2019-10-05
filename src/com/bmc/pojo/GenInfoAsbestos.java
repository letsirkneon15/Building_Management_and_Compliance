package com.bmc.pojo;

import java.io.Serializable;
import java.sql.Date;

public class GenInfoAsbestos implements Serializable {
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
	private String buildingDetailsType;
	private String name;
	private String attachment;
	private String type;
	private int titledYear;
	private String consentNumber;
	private String uploadedBy;
	private Date uploadedDate;
	private String lastUploadedBy; 
	private Date lastUploadedDate;
	
	public GenInfoAsbestos(int buildingID, String buildingName, String address, String location,
			String levelOrUnitNumber, String coordinates, String owner, String client, String responsibleOffice,
			String projectNumber, String buildingInformation, String csNumber, String legalDescription,
			int maxOccupants, String fireHazardCategory, int yearBuilt, String intendedLife, int bwofAnniversary,
			String asbestosPresent, float nbsPercentage, int recordID, String buildingDetailsType, String name,
			String attachment, String type, int titledYear, String consentNumber, String uploadedBy, Date uploadedDate,
			String lastUploadedBy, Date lastUploadedDate) {
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
		this.buildingDetailsType = buildingDetailsType;
		this.name = name;
		this.attachment = attachment;
		this.type = type;
		this.titledYear = titledYear;
		this.consentNumber = consentNumber;
		this.uploadedBy = uploadedBy;
		this.uploadedDate = uploadedDate;
		this.lastUploadedBy = lastUploadedBy;
		this.lastUploadedDate = lastUploadedDate;
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
	public String getBuildingDetailsType() {
		return buildingDetailsType;
	}
	public void setBuildingDetailsType(String buildingDetailsType) {
		this.buildingDetailsType = buildingDetailsType;
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
}
