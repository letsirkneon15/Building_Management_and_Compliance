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


import com.bmc.model.ComplianceInspectionMgr;
import com.bmc.pojo.ComplianceInspection;
import com.google.gson.Gson;

@Path("/ComplianceInspection")
public class ComplianceInspectionWs {
	
	/* Database Connection */
	private Connection conn = null;
	private String conStatus = "";
	
	/**
	 * This method return Compliance Inspection Information from Azure SQL DB - Compliance_Inspection
	 * @param info (buildingID) - buildingID 
	 * @return Json String of Compliance_Inspection table
	 * @sampleHTTP http://127.0.0.1:8999/ComplianceInspection/Info/{buildingID}
	 * json format  
	 */
	@GET
	@Path("/Info/{buildingID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("buildingID") int buildingID) {

		System.out.println("buildingID from webService: " + buildingID);	
		
		//Get ComplianceInspection information	
		List<ComplianceInspection> comIns = new ComplianceInspectionMgr().getComplianceInspection(conn, buildingID, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(comIns); 
		System.out.println(json);
		return json;
				
	}
	
	/**
	 * This method will create a new record in Compliance Inspection with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (ComplianceInspection) Compliance_Inspection table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/ComplianceInspection/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(ComplianceInspection comInspection) {

		
		/* Add new record in Compliance Inspection */
		int result = new ComplianceInspectionMgr().setComplianceInspection(conn, comInspection);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will edit an existing record in Compliance Inspection with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (ComplianceInspection) Compliance_Inspection table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/ComplianceInspection/Update
	 */
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInfo(ComplianceInspection comInspection) {

		
		/* Update records in Compliance Inspection */
		int result = new ComplianceInspectionMgr().updateComplianceInspection(conn, comInspection);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in Compliance Inspection with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (ComplianceInspection) Compliance_Inspection table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/ComplianceInspection/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(ComplianceInspection comInspection) {

		
		/* Update Status Compliance Inspection */
		int result = new ComplianceInspectionMgr().setStatus(conn, comInspection.getStatus(), 
				comInspection.getRecordID(), comInspection.getBuildingID(),comInspection.getModifiedBy(), comInspection.getModifiedDate());
		return Response.status(201).entity(result).build();
				
	}

}
