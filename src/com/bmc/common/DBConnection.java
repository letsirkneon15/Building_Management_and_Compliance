package com.bmc.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.bmc.pojo.BMCProp;

public class DBConnection {
	
	BMCProp bmc = new BMCProp();
	
	public void setAzureDriver(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void getPropertiesFile() {
		
		/* Retrieve values from Properties File */
		try {
			bmc.getProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection openConnection(){
		Connection conn=null;
		this.setAzureDriver();
		this.getPropertiesFile();
		try{
			System.out.println("Azure URL: " + "jdbc:sqlserver://bmcs.database.windows.net:1433;database"
					+ "=BMnC;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*."
					+ "database.windows.net;loginTimeout=30" + " " + "bmcs_admin" + " " +
					"Weltec2019");
			conn = DriverManager.getConnection(bmc.getAzureURL(), 
					bmc.getAzureUserId(), 
					bmc.getAzurePassword());
		} catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(Connection conn){
		if (conn!=null){
			try{
				conn.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public Connection getConnection() throws SQLException {
		
		Context initContext;
		Context envContext;
		DataSource dataSource;
		Connection conn = null;
		
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/Project");
			conn = dataSource.getConnection();
			System.out.println("Connection: " + conn);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return conn;

	}
}
