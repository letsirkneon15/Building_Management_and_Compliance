package com.bmc.pojo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BMCProp {
	
	private String webServiceURL;
	private String fileUploadFolder;
	
	public void getProperties() throws IOException{
		Properties progProperties = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("BMCProp.properties");
		progProperties.load(in);
	    this.setWebServiceURL(progProperties.getProperty("webserviceURL"));
	    this.setFileUploadFolder(progProperties.getProperty("fileUploadFolder"));
	    
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
}
