package com.bmc.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bmc.pojo.BMCProp;
import com.bmc.pojo.BuildingHeader;
import com.bmc.pojo.GenInfoAsbestos;
import com.bmc.pojo.GenInfoHazardSubstance;

public class DownloadToExcel {
	
	private static XSSFWorkbook workbook = new XSSFWorkbook();
	private static XSSFSheet sheet = workbook.createSheet("bmcs"); 
	
	public boolean createGenFile(String userID, String reportFormat, List<BuildingHeader> bGenInfo) throws IOException{
		
		Boolean isCreated = false;
		int ctr = 1;
	
		String excelFile = formatExcelFileName(userID, reportFormat);
		
		/* Create excel Data */
		for(BuildingHeader bh : bGenInfo) {
			
			/*create excel Column Name*/
			if(ctr == 1){	
				XSSFRow rowhead = sheet.createRow((short)0);
				rowhead.createCell(0).setCellValue("Name of Building");
				rowhead.createCell(1).setCellValue("Address");
				rowhead.createCell(2).setCellValue("Responsible Office");
				rowhead.createCell(3).setCellValue("Client");
				rowhead.createCell(4).setCellValue("Project Number");
				rowhead.createCell(5).setCellValue("Building Information");
				rowhead.createCell(6).setCellValue("CS Number");
				rowhead.createCell(7).setCellValue("Legal Description");	
				rowhead.createCell(8).setCellValue("Max Occupants");	
				rowhead.createCell(9).setCellValue("Year Built");	
				rowhead.createCell(10).setCellValue("Intended Life");	
				rowhead.createCell(11).setCellValue("BWOF Anniversary");	
				rowhead.createCell(12).setCellValue("Asbestos Present");	
				rowhead.createCell(13).setCellValue("NBS %");	
			}
			
			/* Create excel row */
			XSSFRow row = sheet.createRow((short)ctr);
			row.createCell(0).setCellValue(bh.getBuildingName());
			row.createCell(1).setCellValue(bh.getAddress());
			row.createCell(2).setCellValue(bh.getResponsibleOffice());
			row.createCell(3).setCellValue(bh.getClient());
			row.createCell(4).setCellValue(bh.getProjectNumber());
			row.createCell(5).setCellValue(bh.getBuildingInformation());
			row.createCell(6).setCellValue(bh.getCsNumber());
			row.createCell(7).setCellValue(bh.getLegalDescription());	
			row.createCell(8).setCellValue(bh.getMaxOccupants());	
			row.createCell(9).setCellValue(bh.getYearBuilt());	
			row.createCell(10).setCellValue(bh.getIntendedLife());	
			row.createCell(11).setCellValue(bh.getBwofAnniversary());	
			row.createCell(12).setCellValue(bh.getAsbestosPresent());	
			row.createCell(13).setCellValue(bh.getNbsPercentage());	
			
			ctr++;	
		}
		
		
		/*Create excel file in C directory */
		if(ctr > 1){
			FileOutputStream fileOut = new FileOutputStream(excelFile);
			workbook.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");
			isCreated = true;
		}
		
		return isCreated;
	}

	public boolean createGenFileAsbestos(String userID, String reportFormat, List<GenInfoAsbestos> genInfoAsbestos) throws IOException{
		
		Boolean isCreated = false;
		int ctr = 1;
	
		String excelFile = formatExcelFileName(userID, reportFormat);
		
		/* Create excel Data */
		for(GenInfoAsbestos ga : genInfoAsbestos) {
			
			/*create excel Column Name*/
			if(ctr == 1){	
				XSSFRow rowhead = sheet.createRow((short)0);
				rowhead.createCell(0).setCellValue("Name of Building");
				rowhead.createCell(1).setCellValue("Address");
				rowhead.createCell(2).setCellValue("Responsible Office");
				rowhead.createCell(3).setCellValue("Client");
				rowhead.createCell(4).setCellValue("Project Number");
				rowhead.createCell(5).setCellValue("Building Information");
				rowhead.createCell(6).setCellValue("CS Number");
				rowhead.createCell(7).setCellValue("Legal Description");	
				rowhead.createCell(8).setCellValue("Max Occupants");	
				rowhead.createCell(9).setCellValue("Year Built");	
				rowhead.createCell(10).setCellValue("Intended Life");	
				rowhead.createCell(11).setCellValue("BWOF Anniversary");	
				rowhead.createCell(12).setCellValue("Asbestos Present");
				rowhead.createCell(13).setCellValue("NBS %");
				rowhead.createCell(14).setCellValue("Asbestos Name");	
				rowhead.createCell(15).setCellValue("Attachment");	
				rowhead.createCell(16).setCellValue("Type");	
				rowhead.createCell(17).setCellValue("Uploaded By");	
				rowhead.createCell(18).setCellValue("Last Uploaded");	
			}
			
			/* Create excel row */
			XSSFRow row = sheet.createRow((short)ctr);
			row.createCell(0).setCellValue(ga.getBuildingName());
			row.createCell(1).setCellValue(ga.getAddress());
			row.createCell(2).setCellValue(ga.getResponsibleOffice());
			row.createCell(3).setCellValue(ga.getClient());
			row.createCell(4).setCellValue(ga.getProjectNumber());
			row.createCell(5).setCellValue(ga.getBuildingInformation());
			row.createCell(6).setCellValue(ga.getCsNumber());
			row.createCell(7).setCellValue(ga.getLegalDescription());	
			row.createCell(8).setCellValue(ga.getMaxOccupants());	
			row.createCell(9).setCellValue(ga.getYearBuilt());	
			row.createCell(10).setCellValue(ga.getIntendedLife());	
			row.createCell(11).setCellValue(ga.getBwofAnniversary());	
			row.createCell(12).setCellValue(ga.getAsbestosPresent());	
			row.createCell(13).setCellValue(ga.getNbsPercentage());	
			row.createCell(14).setCellValue(ga.getName());	
			row.createCell(15).setCellValue(ga.getAttachment());	
			row.createCell(16).setCellValue(ga.getType());	
			row.createCell(17).setCellValue(ga.getUploadedBy());	
			row.createCell(18).setCellValue(ga.getLastUploadedBy());
			
			ctr++;	
		}
		
		
		/*Create excel file in C directory */
		if(ctr > 1){
			FileOutputStream fileOut = new FileOutputStream(excelFile);
			workbook.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");
			isCreated = true;
		}
		
		return isCreated;
	}

public boolean createGenFileHazardSubstance(String userID, String reportFormat, List<GenInfoHazardSubstance> genInfoHazardSubstance) throws IOException{
		
		Boolean isCreated = false;
		int ctr = 1;
	
		String excelFile = formatExcelFileName(userID, reportFormat);
		
		/* Create excel Data */
		for(GenInfoHazardSubstance hs : genInfoHazardSubstance) {
			
			/*create excel Column Name*/
			if(ctr == 1){	
				XSSFRow rowhead = sheet.createRow((short)0);
				rowhead.createCell(0).setCellValue("Name of Building");
				rowhead.createCell(1).setCellValue("Address");
				rowhead.createCell(2).setCellValue("Responsible Office");
				rowhead.createCell(3).setCellValue("Client");
				rowhead.createCell(4).setCellValue("Project Number");
				rowhead.createCell(5).setCellValue("Building Information");
				rowhead.createCell(6).setCellValue("CS Number");
				rowhead.createCell(7).setCellValue("Legal Description");	
				rowhead.createCell(8).setCellValue("Max Occupants");	
				rowhead.createCell(9).setCellValue("Year Built");	
				rowhead.createCell(10).setCellValue("Intended Life");	
				rowhead.createCell(11).setCellValue("BWOF Anniversary");	
				rowhead.createCell(12).setCellValue("Asbestos Present");
				rowhead.createCell(13).setCellValue("NBS %");
				rowhead.createCell(14).setCellValue("Product Name");	
				rowhead.createCell(15).setCellValue("UN Number");	
				rowhead.createCell(16).setCellValue("Approval Number");	
				rowhead.createCell(17).setCellValue("Group Standard");	
				rowhead.createCell(18).setCellValue("Hazard Classification");	
				rowhead.createCell(19).setCellValue("Current SDS Available");
				rowhead.createCell(20).setCellValue("Specific Storage");
				rowhead.createCell(21).setCellValue("Segregation Requirements");
				rowhead.createCell(22).setCellValue("Container Size");
				rowhead.createCell(23).setCellValue("Open/Close Container");
				rowhead.createCell(24).setCellValue("Gas/Liquid/Solid");
				rowhead.createCell(25).setCellValue("Hazard Location");
				rowhead.createCell(26).setCellValue("Maximum Likely Amount");
			}
			
			/* Create excel row */
			XSSFRow row = sheet.createRow((short)ctr);
			row.createCell(0).setCellValue(hs.getBuildingName());
			row.createCell(1).setCellValue(hs.getAddress());
			row.createCell(2).setCellValue(hs.getResponsibleOffice());
			row.createCell(3).setCellValue(hs.getClient());
			row.createCell(4).setCellValue(hs.getProjectNumber());
			row.createCell(5).setCellValue(hs.getBuildingInformation());
			row.createCell(6).setCellValue(hs.getCsNumber());
			row.createCell(7).setCellValue(hs.getLegalDescription());	
			row.createCell(8).setCellValue(hs.getMaxOccupants());	
			row.createCell(9).setCellValue(hs.getYearBuilt());	
			row.createCell(10).setCellValue(hs.getIntendedLife());	
			row.createCell(11).setCellValue(hs.getBwofAnniversary());	
			row.createCell(12).setCellValue(hs.getAsbestosPresent());	
			row.createCell(13).setCellValue(hs.getNbsPercentage());	
			row.createCell(14).setCellValue(hs.getProductName());	
			row.createCell(15).setCellValue(hs.getUnNumber());	
			row.createCell(16).setCellValue(hs.getApprovalNumber());	
			row.createCell(17).setCellValue(hs.getGroupStandard());	
			row.createCell(18).setCellValue(hs.getHazardClassification());	
			row.createCell(19).setCellValue(hs.getCurrentSDSAvailable());
			row.createCell(20).setCellValue(hs.getSpecificStorage());
			row.createCell(21).setCellValue(hs.getSegregationRequirements());
			row.createCell(22).setCellValue(hs.getContainerSize());
			row.createCell(23).setCellValue(hs.getOpenCloseContainer());
			row.createCell(24).setCellValue(hs.getGasLiquidSolid());
			row.createCell(25).setCellValue(hs.getHazlocation());
			row.createCell(26).setCellValue(hs.getMaximumLikelyAmount());
			
			ctr++;	
		}
		
		
		/*Create excel file in C directory */
		if(ctr > 1){
			FileOutputStream fileOut = new FileOutputStream(excelFile);
			workbook.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");
			isCreated = true;
		}
		
		return isCreated;
	}

	private String formatExcelFileName(String userID, String reportFormat) {
		
		/* Retrieve values from Properties File */
		BMCProp bmc = new BMCProp();
		try {
			bmc.getProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String downloadDirectory = bmc.getFileDownloadFolder();
		
		/* Get today's date and time */
		SimpleDateFormat dtFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");  
	    Date date = new Date();  
		
		/*Create excel file in C directory */
		/* String excelFile = "C:/bmcs/downloads/userID_ReportFormat_timestamp.xlsx"; */
		String excelFile =  downloadDirectory + userID + "_" + reportFormat + "_" + dtFormat.format(date) + ".xlsx";
		
		return excelFile;
		
	}
}
