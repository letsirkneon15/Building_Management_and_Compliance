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

import com.bmc.model.UserMgr;
import com.bmc.pojo.User;
import com.google.gson.Gson;

@Path("/User")
public class UserWs {
	
	/* DaUserase Connection */
	private Connection conn = null;
	
	/**
	 * This method return User Information from Azure SQL DB - User
	 * @param info (userID) - userID 
	 * @param info (name) - user's name
	 * @return Json String of User
	 * @sampleHTTP http://127.0.0.1:8999/User/Info/{userID}/{name}
	 * json format  
	 */
	@GET
	@Path("/Info/{userID}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBHInfo(@PathParam("userID") String userID,
								  @PathParam("name") String name) {

		System.out.println("userID and name from webService: " + userID + " "
				+ name);	
		
		//Get User information	
		List<User> user = new UserMgr().getUser(conn, userID, name);
		Gson gson = new Gson();
		String json = gson.toJson(user); 
		System.out.println(json);
		return json;
				
	}
	
	/**
	 * This method will create a new record in User with boolean as return to indicate 
	 * if the record is successfully created or not
	 * @param info (User) User Table in JSON String 
	 * @return boolean - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/User/Add
	 */
	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewInfo(User user) {

		
		/* Add new record in User */
		boolean result = new UserMgr().setUser(conn, user);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will edit an existing record in User with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (User) User Table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/User/Update
	 */
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInfo(User user) {

		
		/* Update records in User */
		int result = new UserMgr().updateUser(conn, user);

		return Response.status(201).entity(result).build();
				
	}
	
	/**
	 * This method will update the status of existing record in User with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (User) User Table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/User/UpdStatus
	 */
	@POST
	@Path("/UpdStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(User user) {

		
		/* Update Status User */
		int result = new UserMgr().setStatus(conn, user.getStatus(), 
				user.getUserID(), user.getModifiedBy(), user.getModifiedDate());
		return Response.status(201).entity(result).build();
				
	}

	/**
	 * This method will update the password in User with int as return to indicate 
	 * if the record is successfully edited or not
	 * @param info (User) User Table in JSON String 
	 * @return int - indicator that the record is successfully created
	 * @sampleHTTP http://127.0.0.1:8999/User/UpdStatus
	 */
	@POST
	@Path("/UpdPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePassword(User user) {

		
		/* Update Password in table User */
		int result = new UserMgr().setPassword(conn, user.getPassword(), 
				user.getUserID(), user.getModifiedBy(), user.getModifiedDate());
		return Response.status(201).entity(result).build();
				
	}
}
