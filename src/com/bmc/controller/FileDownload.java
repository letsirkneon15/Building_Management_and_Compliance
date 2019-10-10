package com.bmc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmc.pojo.BMCProp;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    	String errorMsg = "";
    	
        String fileName = request.getParameter("fileName");
        System.out.println("fileName: " + fileName);
        
        /* Retrieve values from Properties File */
    	BMCProp bmc = new BMCProp();
		try {
			bmc.getProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        String filePath = bmc.getFileUploadFolder();

        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        String mimeType = mimeTypesMap.getContentType(fileName);
        System.out.println("MimeType: " + mimeType);

        response.setContentType(mimeType);
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);

        filePath = filePath + fileName;
        System.out.println("filePath: " + filePath);
        OutputStream out = response.getOutputStream();
        FileInputStream in = null;
        
        try {
        	in = new FileInputStream(filePath);
            System.out.println("in: " + in);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
        }catch(FileNotFoundException e) {
        	errorMsg = "The system cannot find the file specified";
        }
        
        request.setAttribute("errorMsg", errorMsg);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
