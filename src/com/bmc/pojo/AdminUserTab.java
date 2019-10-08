package com.bmc.pojo;

import java.io.Serializable;

public class AdminUserTab implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userID; 
	private int tabID; 
	private String tabCrt;
	private String tabDlt;
	private String tabUpd;
	
	public AdminUserTab() {
		
	}

	public AdminUserTab(String userID, int tabID, String tabCrt, String tabDlt, String tabUpd) {
		super();
		this.userID = userID;
		this.tabID = tabID;
		this.tabCrt = tabCrt;
		this.tabDlt = tabDlt;
		this.tabUpd = tabUpd;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getTabID() {
		return tabID;
	}
	public void setTabID(int tabID) {
		this.tabID = tabID;
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
