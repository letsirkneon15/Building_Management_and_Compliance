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

import com.bmc.model.BuildingDetailsMgr;
import com.bmc.pojo.BuildingDetails;
import com.google.gson.Gson;

@Path("/BuildingDetails")
public class BuildingDetailsWs {
	
	/* Database Connection */
	private Connection conn = null;
	private String conStatus = "";
	
	/**
	 * This method return Building Detail Information from Azure SQL DB - Building_Details
	 * @param info (buildingID) - buildingID 
	 * @param info (buildingName) - buildingName
	 * @return Json String of Building_Details table
	 * @sampleHTTP http://127.0.0.1:8999/BuildingDetails/Info/{buildingID}/{buildingName}
	 * json format  
	 */
	@GET
	@Path("/Info/{buildingID}/{buildingName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("buildingID") int buildingID,
						    @PathParam("buildingName") String buildingName) {

		System.out.println("buildingID and building Name from webService: " + buildingID + " "
				+ buildingName);	
		
		List<BuildingDetails> bDetail = new BuildingDetailsMgr().getBuildingDetails(conn, buildingID, buildingName, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(bDetail); 
		System.out.println(json);
		
		return json;
				
	}
	
	/**
	 * This method will create a new record in Building Details with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (BuildingDetails) Building_Details table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/BuildingDetails/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(BuildingDetails buildDetail) {
		
		/* Add new record in Building Details */
		int result = new BuildingDetailsMgr().setBuildingDetails(conn, buildDetail);
		
		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will edit an existing record in Building Details with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (BuildingDetails) Building_Details table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/BuildingDetails/Update
	 */
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInfo(BuildingDetails buildDetail) {
		
		/* Update records in Building Details */
		int result = new BuildingDetailsMgr().updateBuildingDetails(conn, buildDetail);
		
		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in Building Details with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (BuildingDetails) Building_Details table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/BuildingDetails/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(BuildingDetails buildDetail) {
		
		/* Update Status Building Details */
		int result = new BuildingDetailsMgr().setStatus(conn, buildDetail.getStatus(), 
				buildDetail.getRecordID(), buildDetail.getBuildingID(), buildDetail.getLastUploadedBy(), buildDetail.getLastUploadedDate());
		
		return Response.status(201).entity(result).build();
				
	}

}
