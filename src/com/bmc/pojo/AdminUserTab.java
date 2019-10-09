package com.bmc.pojo;

import java.io.Serializable;

public class AdminUserTab implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userID; 
	private String tabID; 
	private String tabDescription;
	private String tabDsp;
	private String tabCrt;
	private String tabUpd;
	private String tabDlt;
	
	
	public AdminUserTab() {
		
	}
	
	public AdminUserTab(String userID, String tabID, String tabDescription, String tabDsp, String tabCrt, String tabUpd, String tabDlt) {
		super();
		this.userID = userID;
		this.tabID = tabID;
		this.tabDescription = tabDescription;
		this.tabDsp = tabDsp;
		this.tabCrt = tabCrt;
		this.tabUpd = tabUpd;
		this.tabDlt = tabDlt;	
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTabID() {
		return tabID;
	}

	public void setTabID(String tabID) {
		this.tabID = tabID;
	}

	public String getTabDescription() {
		return tabDescription;
	}

	public void setTabDescription(String tabDescription) {
		this.tabDescription = tabDescription;
	}

	public String getTabDsp() {
		return tabDsp;
	}

	public void setTabDsp(String tabDsp) {
		this.tabDsp = tabDsp;
	}

	public String getTabCrt() {
		return tabCrt;
	}

	public void setTabCrt(String tabCrt) {
		this.tabCrt = tabCrt;
	}

	public String getTabDlt() {
		return tabDlt;
	}

	public void setTabDlt(String tabDlt) {
		this.tabDlt = tabDlt;
	}

	public String getTabUpd() {
		return tabUpd;
	}

	public void setTabUpd(String tabUpd) {
		this.tabUpd = tabUpd;
	}
}
