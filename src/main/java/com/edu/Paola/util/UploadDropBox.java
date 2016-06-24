package com.edu.Paola.util;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class UploadDropBox {
    private static final String ACCESS_TOKEN = "eS1aZa_6kQwAAAAAAAAAYxao47lpCmzPa4o-TsG3xO6mb1_Z49x_uEwyB3jkWQZj";

    public void subir(String filepath, String fileName, HttpServletRequest request) throws DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // Get current account info
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());

        
        String realPathtoUploads = request.getSession().getServletContext().getRealPath("/") + fileName;
        
        // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }

        // Upload "test.txt" to Dropbox
        
        //InputStream in = Main.class.getResourceAsStream("/main/resources/Seguro.pdf");
        java.io.File file = new java.io.File(realPathtoUploads);
      InputStream in2 = new FileInputStream(file);
      
      FileMetadata metadata = client.files().uploadBuilder("/main/resources/" + fileName)
              .uploadAndFinish(in2);
      

  /*      try ( InputStream in = UploadDropBox.class.getResourceAsStream(realPathtoUploads)) {
            FileMetadata metadata = client.files().uploadBuilder("/main/resources/" + fileName)
                .uploadAndFinish(in2);
        }*/
    }
}