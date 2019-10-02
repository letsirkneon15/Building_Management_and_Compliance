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

import com.bmc.model.BuildingHeaderMgr;
import com.bmc.pojo.BuildingHeader;
import com.google.gson.Gson;

@Path("/BuildingHeader")
public class BuildingHeaderWs {
	
	/* Database Connection */
	private Connection conn;
	private String conStatus = "";
	
	/**
	 * This method return Building Header Information from Azure SQL DB - Building_Header
	 * @param info (buildingID) - buildingID 
	 * @param info (buildingName) - buildingName
	 * @return Json String of Building_Header table
	 * @sampleHTTP http://127.0.0.1:8999/BuildingHeader/Info/{buildingID}/{buildingName}
	 * json format  
	 */
	@GET
	@Path("/Info/{buildingID}/{buildingName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("buildingID") int buildingID,
								  @PathParam("buildingName") String buildingName) {

		System.out.println("buildingID and building Name from webService: " + buildingID + " "
				+ buildingName);	
		
		//Get BuildingHeader information	
		List<BuildingHeader> bHeader = new BuildingHeaderMgr().getBuildingHeader(conn, buildingID, buildingName, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(bHeader); 
		System.out.println(json);
		
		return json;
				
	}
	
	/**
	 * This method return Building Header Information from Azure SQL DB - Building_Header by
	 * userID found in User_Building
	 * @param info (userID) - userID 
	 * @return Json String of Building_Header table
	 * @sampleHTTP http://127.0.0.1:8999/BuildingHeader/Info/ByUserID/{userID}
	 * json format  
	 */
	@GET
	@Path("/Info/ByUserID/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfoByUserID(@PathParam("userID") String userID) {

		System.out.println("userID from webService: " + userID);	
		
		//Get BuildingHeader information	
		List<BuildingHeader> bHeader = new BuildingHeaderMgr().getBuildingHeaderByUserId(conn, userID, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(bHeader); 
		System.out.println(json);
		
		return json;
				
	}
	
	/**
	 * This method will create a new record in Building Header with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (BuildingHeader) Building_Header table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/BuildingHeader/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(BuildingHeader buildHeader) {
		
		/* Add new record in Building Header */
		int result = new BuildingHeaderMgr().setBuildingHeader(conn, buildHeader);
		
		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will edit an existing record in Building Header with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (BuildingHeader) Building_Header table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/BuildingHeader/Update
	 */
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInfo(BuildingHeader buildHeader) {
		
		/* Update records in Building Header */
		int result = new BuildingHeaderMgr().updateBuildingHeader(conn, buildHeader);
		
		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in Building Header with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (BuildingHeader) Building_Header table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/BuildingHeader/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(BuildingHeader buildHeader) {
		
		/* Update Status Building Header */
		int result = new BuildingHeaderMgr().setStatus(conn, buildHeader.getStatus(), 
				buildHeader.getBuildingID(), buildHeader.getModifiedBy(), buildHeader.getModifiedDate());
		
		return Response.status(201).entity(result).build();
				
	}

}
