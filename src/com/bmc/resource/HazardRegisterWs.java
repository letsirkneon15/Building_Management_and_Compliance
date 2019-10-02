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

import com.bmc.model.HazardRegisterMgr;
import com.bmc.pojo.HazardRegister;
import com.google.gson.Gson;

@Path("/HazardRegister")
public class HazardRegisterWs {
	
	/* Database Connection */
	private Connection conn = null;
	private String conStatus = "";
	
	/**
	 * This method return Hazard Register Information from Azure SQL DB - Hazard_Register
	 * @param info (buildingID) - buildingID 
	 * @return Json String of Hazard_Register table
	 * @sampleHTTP http://127.0.0.1:8999/HazardRegister/Info/{buildingID}
	 * json format  
	 */
	@GET
	@Path("/Info/{buildingID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("buildingID") int buildingID) {

		System.out.println("buildingID from webService: " + buildingID);	
		
		//Get HazardRegister information	
		List<HazardRegister> hazReg = new HazardRegisterMgr().getHazardRegister(conn, buildingID, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(hazReg); 
		System.out.println(json);
		return json;
				
	}
	
	/**
	 * This method will create a new record in Hazard Register with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (HazardRegister) Hazard_Register table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/HazardRegister/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(HazardRegister hazardReg) {
		
		
		/* Add new record in Hazard Register */
		int result = new HazardRegisterMgr().setHazardRegister(conn, hazardReg);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will edit an existing record in Hazard Register with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (HazardRegister) Hazard_Register table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/HazardRegister/Update
	 */
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInfo(HazardRegister hazardReg) {

		
		/* Update records in Hazard Register */
		int result = new HazardRegisterMgr().updateHazardRegister(conn, hazardReg);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in Hazard Register with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (HazardRegister) Hazard_Register table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/HazardRegister/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(HazardRegister hazardReg) {

		
		/* Update Status Hazard Register */
		int result = new HazardRegisterMgr().setStatus(conn, hazardReg.getStatus(), 
				hazardReg.getRecordID(), hazardReg.getBuildingID(), hazardReg.getModifiedBy(), hazardReg.getModifiedDate());
		return Response.status(201).entity(result).build();
				
	}

}
