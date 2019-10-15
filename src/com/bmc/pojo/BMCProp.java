package com.bmc.pojo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BMCProp {
	
	private String webServiceURL;
	private String fileUploadFolder;
	private String fileDownloadFolder;
	private String azureURL;
	private String azureUserId;
	private String azurePassword;
	
	public void getProperties() throws IOException{
		Properties progProperties = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("BMCProp.properties");
		progProperties.load(in);
	    this.setWebServiceURL(progProperties.getProperty("webserviceURL"));
	    this.setFileUploadFolder(progProperties.getProperty("fileUploadFolder"));
	    this.setFileDownloadFolder(progProperties.getProperty("fileDownloadFolder"));
	    this.setAzureURL(progProperties.getProperty("azureURL"));
	    this.setAzureUserId(progProperties.getProperty("azureUserId"));
	    this.setAzurePassword(progProperties.getProperty("azurePassword"));
	}

	public String getWebServiceURL() {
		return webServiceURL;
	}

	public void setWebServiceURL(String webServiceURL) {
		this.webServiceURL = webServiceURL;
	}

	public String getFileUploadFolder() {
		return fileUploadFolder;
	}

	public void setFileUploadFolder(String fileUploadFolder) {
		this.fileUploadFolder = fileUploadFolder;
	}

	public String getFileDownloadFolder() {
		return fileDownloadFolder;
	}

	public void setFileDownloadFolder(String fileDownloadFolder) {
		this.fileDownloadFolder = fileDownloadFolder;
	}

	public String getAzureURL() {
		return azureURL;
	}

	public void setAzureURL(String azureURL) {
		this.azureURL = azureURL;
	}

	public String getAzureUserId() {
		return azureUserId;
	}

	public void setAzureUserId(String azureUserId) {
		this.azureUserId = azureUserId;
	}

	public String getAzurePassword() {
		return azurePassword;
	}

	public void setAzurePassword(String azurePassword) {
		this.azurePassword = azurePassword;
	}
	
}
