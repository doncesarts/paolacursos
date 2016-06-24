package com.edu.Paola.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v1.DbxEntry;

public class DownloadDropbox {

	   private static final String ACCESS_TOKEN = "eS1aZa_6kQwAAAAAAAAAYxao47lpCmzPa4o-TsG3xO6mb1_Z49x_uEwyB3jkWQZj";

	   public void ObtenerArchivo(String fileName, HttpServletRequest request) throws IOException {
	        // Create Dropbox client
	        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
	        DbxClientV1 client = new DbxClientV1(config, ACCESS_TOKEN);
	
	        		 DbxEntry.File md;
	        		 
	        	     String realPathtoDownload = request.getSession().getServletContext().getRealPath("/") + fileName;
	        		 File target = new File(realPathtoDownload);
	        		 OutputStream out = null;
					try {
						out = new FileOutputStream(target);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        	
	        				 
	        				 
	        		 String uploadsDir = "/uploads/";
	                // String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
					
	                 if(! new File(uploadsDir).exists())
	                 {
	                     new File(uploadsDir).mkdir();
	                 }
        		 try {
	        		     md = client.getFile("/main/resources/" +fileName, null, out);
	        		     System.out.println("entre");
	        		 }
	        		 catch(Exception e)
	        		 {
	        			 System.out.println(e.getMessage());
	        		 }
	        		 finally {
	        			
	        		     out.close();
	        		 }
	   }
	
}
