package com.bmc.pojo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BMCProp {
	
	private String webServiceURL;
	
	public void getProperties() throws IOException{
		Properties progProperties = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("BMCProp.properties");
		progProperties.load(in);
	    this.setWebServiceURL(progProperties.getProperty("webserviceURL"));
	}

	public String getWebServiceURL() {
		return webServiceURL;
	}

	public void setWebServiceURL(String webServiceURL) {
		this.webServiceURL = webServiceURL;
	}
}
