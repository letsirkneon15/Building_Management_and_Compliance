package com.bmc.common;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GetUserAccountIDTest {
	
	GetUserAccountID getUserIDObj;
	DBConnection dbConnectMockObj;
	String firstName, lastName;
	String expected, actual;
	Connection conn = null;

	@Before
	public void setUp() throws Exception {
		firstName="Kristel";
		lastName = "Kong";
		expected = firstName + "." + lastName + "001";
		getUserIDObj = new GetUserAccountID();
		dbConnectMockObj = new DBConnection();
		
		dbConnectMockObj = Mockito.mock(DBConnection.class);
		Mockito.when(dbConnectMockObj.openConnection()).thenReturn(conn);
		
		System.out.println("Connection: " + conn);
		
		actual = getUserIDObj.getUserID(conn, firstName, lastName);
	}

	@Test
	public void getUserIDTest() {
		assertEquals(expected, actual);
	}
	
	@After
	public void tearDown() throws Exception {
		getUserIDObj = null;
	}



}
