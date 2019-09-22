package com.bmc.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * This class is to parse Json String
 * @author Kristel
 * @version 1.0
 * @since 2019.05.29
 */

public class JsonParserUtil {
      
	@SuppressWarnings("deprecation")
	public static JsonArray getWebServiceData(String uriLink) throws IOException, ParseException{
		
		JsonArray results = null;
		String jsonString = "";	
		String nullCheck = "null";
		ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
		WebResource webResource = client.resource(UriBuilder.fromUri(uriLink).build());
		ClientResponse  response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		 
		  System.out.println(response.getEntityInputStream());
		  System.out.println(response);
		  System.out.println("Response " + response.getClientResponseStatus());         		   
		
	    if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		String output  = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntityInputStream()));
        while((output = br.readLine()) != null) {
        	
              if (output!=null){
            	  jsonString = jsonString + output; 
              }
        }
        br.close();  
        
		System.out.println(jsonString);
        if (!jsonString.equals(nullCheck))
        {     
          JsonElement Element = new JsonParser().parse(jsonString);
          JsonElement  jObject = Element.getAsJsonArray();
		results = jObject.getAsJsonArray();
        }
        return results;	
	}
	
	@SuppressWarnings("deprecation")
	public static String getWebServiceDataString(String uriLink) throws IOException{
		
		String result = "";	
		ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
		WebResource webResource = client.resource(UriBuilder.fromUri(uriLink).build());
		ClientResponse  response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		 
		  System.out.println(response.getEntityInputStream());
		  System.out.println(response);
		  System.out.println("Response " + response.getClientResponseStatus());         		   
		
	    if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		String output  = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntityInputStream()));
        while((output = br.readLine()) != null) {
        	
              if (output!=null) {	  
            	  result = output; 	  
              }
        }
        br.close();  
       
        return result;  
	}
}
	
