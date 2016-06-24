package com.edu.Paola.controllers;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dropbox.core.DbxException;
import com.edu.Paola.DAO.CursoDAO;
import com.edu.Paola.DAO.UnidadesDAO;
import com.edu.Paola.model.Curso;
import com.edu.Paola.model.Presentaciones;
import com.edu.Paola.util.UploadDropBox;


@Controller
public class PresentacionController {
	
	 @Autowired
	    private HttpServletRequest request;
	 static Logger log = Logger.getLogger(PresentacionController.class.getName());
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String displayForm() {
		return "file_upload_form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(
			@ModelAttribute("fileUploadForm") Presentaciones uploadForm,
					Model map,  BindingResult result) {
		
		String ruta = null;
		String fileName = null;
		
	List<MultipartFile> files = uploadForm.getFiles();

		List<String> fileNames = new ArrayList<String>();
		
		if(null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

			 fileName = multipartFile.getOriginalFilename();
				
				 String uploadsDir = "/uploads/";
				 File target = new File("/PaolaWebContent/pdf/Seguro.pdf");
        		// OutputStream out = new FileOutputStream(target);


				 String realPathtoUploads = request.getSession().getServletContext().getRealPath("/");
						 
				 
				 if(! new File(realPathtoUploads).exists())
                 {
                     new File(realPathtoUploads).mkdir();
                 }

                 
                 fileNames.add(fileName);
				
		          String filePath = realPathtoUploads + fileName;
				ruta = filePath;
				 File dest = new File(filePath);
				try {
					multipartFile.transferTo(dest);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Handle file content - multipartFile.getInputStream()
				
				UploadDropBox uploadDropBox = new UploadDropBox();
				try {
					uploadDropBox.subir(filePath, fileName, request);
				} catch (DbxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		map.addAttribute("files", fileNames);
		
		
	
			AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
			 UnidadesDAO unidadesDAO= (UnidadesDAO)ctx.getBean("myJDBCdaoSupportUnidades");
			unidadesDAO.ActualizarPresentacion(fileName, Integer.parseInt(uploadForm.getUnidad()));
		
			ModelAndView modelAndView = new ModelAndView("inner-form-alta-exito");
				return modelAndView;
		
		
		
		//return "file_upload_success";
	}
}
