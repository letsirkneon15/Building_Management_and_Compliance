package com.bmc.resource;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bmc.model.UserTabMgr;
import com.bmc.pojo.UserTab;
import com.google.gson.Gson;

@Path("/UserTab")
public class UserTabWs {
	
	/* DaUserTabase Connection */
	private Connection conn = null;
	private String conStatus = "";
	
	/**
	 * This method return User Tab Information from Azure SQL DB - User_Tab
	 * @param info (userID) - userID 
	 * @return Json String of User_Tab
	 * @sampleHTTP http://127.0.0.1:8999/UserTab/Info/{userID}
	 * json format  
	 */
	@GET
	@Path("/Info/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("userID") String userID) {

		System.out.println("userID from webService: " + userID);	
		
		//Get UserTab information	
		List<UserTab> userTab = new UserTabMgr().getUserTab(conn, userID, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(userTab); 
		System.out.println(json);
		return json;
				
	}
	
	/**
	 * This method will create a new record in UserTab with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (UserTab) User_Tab table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/UserTab/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(UserTab userTab) {

		
		/* Add new record in UserTab */
		int result = new UserTabMgr().setUserTab(conn, userTab);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in UserTab with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (UserTab) User_Tab table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/UserTab/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(UserTab userTab) {

		
		/* Update Status UserTab */
		int result = new UserTabMgr().setStatus(conn, userTab.getStatus(),  
				userTab.getUserID(), userTab.getTabID(), userTab.getTabSegment(), userTab.getModifiedBy(), userTab.getModifiedDate());
		return Response.status(201).entity(result).build();
				
	}

}
