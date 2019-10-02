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

import com.bmc.model.UserBuildingMgr;
import com.bmc.pojo.UserBuilding;
import com.google.gson.Gson;

@Path("/UserBuilding")
public class UserBuildingWs {
	
	/* DaUserBuildingase Connection */
	private Connection conn = null;
	private String conStatus = "";
	
	/**
	 * This method return User Building Information from Azure SQL DB - User_Building
	 * @param info (userID) - userID 
	 * @return Json String of User_Building
	 * @sampleHTTP http://127.0.0.1:8999/UserBuilding/Info/{userID}
	 * json format  
	 */
	@GET
	@Path("/Info/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("userID") String userID) {

		System.out.println("userID from webService: " + userID);	
		
		//Get UserBuilding information	
		List<UserBuilding> userBuilding = new UserBuildingMgr().getUserBuilding(conn, userID, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(userBuilding); 
		System.out.println(json);
		return json;
				
	}
	
	/**
	 * This method will create a new record in UserBuilding with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (UserBuilding) User_Building table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/UserBuilding/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(UserBuilding UserBuilding) {

		
		/* Add new record in UserBuilding */
		int result = new UserBuildingMgr().setUserBuilding(conn, UserBuilding);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in UserBuilding with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (UserBuilding) User_Building table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/UserBuilding/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(UserBuilding userBuild) {

		
		/* Update Status UserBuilding */
		int result = new UserBuildingMgr().setStatus(conn, userBuild.getStatus(),  
				userBuild.getUserID(), userBuild.getBuildingId(), userBuild.getModifiedBy(), userBuild.getModifiedDate());
		return Response.status(201).entity(result).build();
				
	}

}
