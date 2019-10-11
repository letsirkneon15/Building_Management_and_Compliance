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

public ArrayList<String> getTypeFire(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Certificate of Compliance");
	typeArr.add("Evacuation Scheme");
	typeArr.add("Emergency Evacuation Procedures");
	typeArr.add("Fire Report");
	typeArr.add("Trial Evacuation Report");
	typeArr.add("Surveys");
	typeArr.add("Producer Statements");
	typeArr.add("Site Report");
	typeArr.add("Condition Assessment");
	typeArr.add("Test Results");
	typeArr.add("Inspection Results");
	typeArr.add("Isolation Notifications");
	typeArr.add("Shutdown Notifications");
	typeArr.add("Plans");
	
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

public ArrayList<String> getLevelOfControls(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Elimination");
	typeArr.add("Substitution");
	typeArr.add("Engineering Controls");
	typeArr.add("Administrative Controls");
	typeArr.add("PPE");
	
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

public ArrayList<String> getYesNo(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Yes");
	typeArr.add("No");
	
	return typeArr;
}

public ArrayList<String> getFireHazardCategory(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("A");
	typeArr.add("B");
	typeArr.add("C");
	
	return typeArr;
}

public ArrayList<String> getReportFormat(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("Building General Information");
	typeArr.add("BWOF Anniversary Current vs Expired");
	typeArr.add("Asbestos");
	typeArr.add("Hazardous Substance");
	
	return typeArr;
}

public ArrayList<String[]> getTabList(){
	
	ArrayList<String[]> tabArr = new ArrayList<String[]>();
	
	tabArr.add(new String[]{"GenInfo", "General Information"});
	tabArr.add(new String[]{"Contacts", "Contacts"});
	tabArr.add(new String[]{"WOF", "Building WOF"});
	tabArr.add(new String[]{"Consent", "Building Consent"});
	tabArr.add(new String[]{"Asbestos", "Asbestos"});
	tabArr.add(new String[]{"Electrical", "Electrical"});
	tabArr.add(new String[]{"Gas", "Gas"});
	tabArr.add(new String[]{"Fire", "Fire"});
	tabArr.add(new String[]{"HazSubs", "Hazardous Substances"});
	tabArr.add(new String[]{"HazReg", "Hazard Register"});
	tabArr.add(new String[]{"Seismic", "Seismic Resilience"});
	tabArr.add(new String[]{"ResourceConsent", "Resource Consents"});
	tabArr.add(new String[]{"ComIns", "Compliance Inspection"});
	
	return tabArr;
}

public ArrayList<String> getRoles(){
	
	ArrayList<String> typeArr = new ArrayList<String>();
	
	typeArr.add("User");
	typeArr.add("Admin");
	
	return typeArr;
}

}
