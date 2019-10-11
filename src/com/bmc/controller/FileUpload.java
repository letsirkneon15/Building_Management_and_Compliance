package com.bmc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bmc.pojo.BMCProp;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String uploadFolder;
    
    /* fix max file size 500 Mb */
    //private int maxFileSize = 500000 * 1024;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 /* Retrieve values from Properties File */
    	BMCProp bmc = new BMCProp();
		try {
			bmc.getProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		uploadFolder = bmc.getFileUploadFolder();
		
		System.out.println("FileUpload servlet is called from JSP");
    	
    	if(ServletFileUpload.isMultipartContent(request)){
            try {
            	System.out.println("MultipartContent");
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
               
                for(FileItem item : multiparts){
                	System.out.println("item: " + item);
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        System.out.println("FileName:" + name);
                        item.write( new File(uploadFolder + File.separator + name));
                    }
                }
            
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }

    }
}
