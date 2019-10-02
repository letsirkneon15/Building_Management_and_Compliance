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

import com.bmc.model.TabMgr;
import com.bmc.pojo.Tab;
import com.google.gson.Gson;

@Path("/Tab")
public class TabWs {
	
	/* Database Connection */
	private Connection conn = null;
	private String conStatus = "";
	
	/**
	 * This method return Tab Information from Azure SQL DB - Tab
	 * @param info (tabID) - tabID 
	 * @param info (tabDescription) - tabDescription
	 * @return Json String of Tab table
	 * @sampleHTTP http://127.0.0.1:8999/Tab/Info/{tabID}/{tabDescription}
	 * json format  
	 */
	@GET
	@Path("/Info/{tabID}/{tabDescription}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("tabID") int tabID,
								  @PathParam("tabDescription") String tabDescription) {

		System.out.println("tabID and tab Description from webService: " + tabID + " "
				+ tabDescription);	
		
		//Get Tab information	
		List<Tab> tab = new TabMgr().getTab(conn, tabID, tabDescription, conStatus);
		Gson gson = new Gson();
		String json = gson.toJson(tab); 
		System.out.println(json);
		return json;
				
	}
	
	/**
	 * This method will create a new record in Tab with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (Tab) Tab table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/Tab/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(Tab tab) {

		
		/* Add new record in Tab */
		int result = new TabMgr().setTab(conn, tab);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will edit an existing record in Tab with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (Tab) Tab table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/Tab/Update
	 */
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInfo(Tab tab) {

		
		/* Update records in Tab */
		int result = new TabMgr().updateTab(conn, tab);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in Tab with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (Tab) Tab table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/Tab/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(Tab tab) {

		
		/* Update Status Tab */
		int result = new TabMgr().setStatus(conn, tab.getStatus(), 
				tab.getTabID(), tab.getTabSegment(), tab.getModifiedBy(), tab.getModifiedDate());
		return Response.status(201).entity(result).build();
				
	}

}
