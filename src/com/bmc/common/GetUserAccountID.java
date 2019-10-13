package com.bmc.common;

import java.sql.Connection;

import com.bmc.model.UserMgr;

public class GetUserAccountID {

	/* Check how many same userID exists and add 1 
	 * User id should be: example: firstName.lastName001 */
	public String getUserID(Connection conn, String firstName, String lastName) {
		
		String userID="";
		int userIDCtr = 0;
		String userIDStr = "";
		
		userID = firstName.trim() + "." + lastName.trim();
		
		userIDCtr = new UserMgr().countUserID(conn, userID) + 1;
		
		userIDStr = Integer.toString(userIDCtr);
		if(userIDStr.length()==1) {
			userID = userID + "00" + userIDStr;
		}else if(userIDStr.length()==2){
			userID = userID + "0" + userIDStr;
		}else {
			userID = userID + userIDStr;
		}
		
		return userID;
	}
}
