package com.bmc.model;

import java.util.ArrayList;

public class HardCodedData {
	
public ArrayList<String> getTypeContacts(){
		
		ArrayList<String> typeArr = new ArrayList<String>();
		
		typeArr.add("Owner");
		typeArr.add("Property Manager");
		typeArr.add("Contractor");
		typeArr.add("Tenant");
		typeArr.add("Agent");
		
		return typeArr;
	}

public ArrayList<String> getTypeWof(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("BWOF");
	typeArr.add("12A");
	typeArr.add("Report in Lieu");
	typeArr.add("Compliance Schedule");
	typeArr.add("Compliance Schedule Statement");
	
	return typeArr;
}

public ArrayList<String> getTypeConsent(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Building Consent");
	typeArr.add("Application");
	typeArr.add("CCC");
	typeArr.add("Specifications");
	typeArr.add("Plans");
	typeArr.add("Producer Statements");
	typeArr.add("Warranty");
	
	return typeArr;
}

public ArrayList<String> getTypeAsbestos(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Management Plan");
	typeArr.add("Management Survey");
	typeArr.add("Clearance Certificate");
	typeArr.add("Asbestos Removal Control Plan");
	
	return typeArr;
}

public ArrayList<String> getTypeElectrical(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Certificate of Compliance");
	typeArr.add("Electrical Safety Certificate");
	typeArr.add("Record of Inspection");
	typeArr.add("Certificate of Verification");
	typeArr.add("Thermography Report");
	typeArr.add("Condition Assessment");
	
	return typeArr;
}

public ArrayList<String> getTypeGas(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Certificate of Compliance");
	typeArr.add("Energy Safety Certificate");
	typeArr.add("Condition Assessment");
	
	return typeArr;
}

public ArrayList<String> getAssessmentHazRegister(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Extreme");
	typeArr.add("High");
	typeArr.add("Medium");
	typeArr.add("Low");
	
	return typeArr;
}

public ArrayList<String> getTypeSeismic(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Detailed Seismic Assessment");
	typeArr.add("Summary");
	typeArr.add("Strengthening Close Out Report");
	typeArr.add("Initial Seismic Assessment");
	typeArr.add("Structural Drawings");
	typeArr.add("Specifications");
	
	return typeArr;
}

public ArrayList<String> getTypeResource(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Resource Consent");
	typeArr.add("Reports");
	typeArr.add("Plans");
	
	return typeArr;
}

}
