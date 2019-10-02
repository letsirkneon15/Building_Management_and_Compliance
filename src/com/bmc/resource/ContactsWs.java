package com.bmc.resource;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.bmc.model.ContactsMgr;
import com.bmc.pojo.Contacts;
import com.google.gson.Gson;

@Path("/Contacts")
public class ContactsWs {
	
	/* Database Connection */
	private Connection conn = null;
	private String conStatus = "";
	
	/**
	 * This method return Contacts Information from Azure SQL DB - Contacts
	 * @param info (buildingID) - buildingID 
	 * @return Json String of Contacts table
	 * @sampleHTTP http://127.0.0.1:8999/Contacts/Info/{buildingID}
	 * json format  
	 */
	@GET
	@Path("/Info/{buildingID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("buildingID") int buildingID) {

		System.out.println("buildingID from webService: " + buildingID);	
		
		//Get Contacts information	
		List<Contacts> comIns = new ContactsMgr().getContacts(conn, buildingID, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(comIns); 
		System.out.println(json);
		return json;
				
	}
	
	/**
	 * This method will create a new record in Compliance Inspection with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (Contacts) Contacts table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/Contacts/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(Contacts contact) {

		
		/* Add new record in Compliance Inspection */
		int result = new ContactsMgr().setContacts(conn, contact);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will edit an existing record in Compliance Inspection with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (Contacts) Contacts table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/Contacts/Update
	 */
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInfo(Contacts contact) {

		
		/* Update records in Compliance Inspection */
		int result = new ContactsMgr().updateContacts(conn, contact);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in Compliance Inspection with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (Contacts) Contacts table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/Contacts/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(Contacts contact) {

		
		/* Update Status Compliance Inspection */
		int result = new ContactsMgr().setStatus(conn, contact.getStatus(), 
				contact.getRecordID(), contact.getBuildingID(),contact.getModifiedBy(), (Date) contact.getModifiedDate());
		return Response.status(201).entity(result).build();
				
	}

}
