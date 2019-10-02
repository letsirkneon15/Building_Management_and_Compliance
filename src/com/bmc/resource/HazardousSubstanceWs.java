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

import com.bmc.model.HazardousSubstanceMgr;
import com.bmc.pojo.HazardousSubstance;
import com.google.gson.Gson;

@Path("/HazardousSubstance")
public class HazardousSubstanceWs {
	
	/* Database Connection */
	private Connection conn = null;
	private String conStatus = "";
	
	/**
	 * This method return Hazardous Substance Information from Azure SQL DB - Hazardous_Substance
	 * @param info (buildingID) - buildingID 
	 * @return Json String of Hazardous_Substance table
	 * @sampleHTTP http://127.0.0.1:8999/HazardousSubstance/Info/{buildingID}
	 * json format  
	 */
	@GET
	@Path("/Info/{buildingID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("buildingID") int buildingID) {

		System.out.println("buildingID from webService: " + buildingID);	
		
		//Get HazardousSubstance information	
		List<HazardousSubstance> hazSubs = new HazardousSubstanceMgr().getHazardousSubstance(conn, buildingID, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(hazSubs); 
		System.out.println(json);
		return json;
				
	}
	
	/**
	 * This method will create a new record in Hazardous Substance with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (HazardousSubstance) Hazardous_Substance table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/HazardousSubstance/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(HazardousSubstance hazardSub) {

		
		/* Add new record in Hazardous Substance */
		int result = new HazardousSubstanceMgr().setHazardousSubstance(conn, hazardSub);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will edit an existing record in Hazardous Substance with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (HazardousSubstance) Hazardous_Substance table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/HazardousSubstance/Update
	 */
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInfo(HazardousSubstance hazardSub) {

		
		/* Update records in Hazardous Substance */
		int result = new HazardousSubstanceMgr().updateHazardousSubstance(conn, hazardSub);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in Hazardous Substance with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (HazardousSubstance) Hazardous_Substance table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/HazardousSubstance/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(HazardousSubstance hazardSub) {

		
		/* Update Status Hazardous Substance */
		int result = new HazardousSubstanceMgr().setStatus(conn, hazardSub.getStatus(), 
				hazardSub.getRecordID(), hazardSub.getBuildingID(), hazardSub.getModifiedBy(), hazardSub.getModifiedDate());
		return Response.status(201).entity(result).build();
				
	}

}
