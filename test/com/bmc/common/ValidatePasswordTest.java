package com.bmc.common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidatePasswordTest {

	ValidatePassword validatePasswordObj; 
	
	String password;
	boolean expected, actual;
	
	@Before
	public void setUp() throws Exception {
		password = "Dreams";
		expected = true;
		validatePasswordObj = new ValidatePassword();
		
		actual = validatePasswordObj.checkPassInput(password);
	}
	
	@Test
	public void testCheckPassInput() {
		
		assertEquals(expected, actual);
	}

	@After
	public void tearDown() throws Exception {
		validatePasswordObj = null;
	}

}
