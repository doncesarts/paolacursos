package com.edu.Paola.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.Paola.model.Curso;
import com.edu.Paola.util.DownloadDropbox;

@Controller
public class DesplegarPresentacion {
	 @Autowired  private HttpServletRequest request;
	@RequestMapping("/MostrarPresentacion")
	
	public ModelAndView helloAnnotation(@RequestParam("fileName") String fileName){

		String a;
		a= "a";
		//System.out.println(filename);
		
		DownloadDropbox downloadDropbox = new DownloadDropbox();
		

		String realPathtoDownload = request.getSession().getServletContext().getRealPath("/") + fileName;
		File file = new File(realPathtoDownload);
		if (!file.exists())
		{
			
		
		System.out.println("NO EXISTIA");
		try {
			downloadDropbox.ObtenerArchivo(fileName, request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		}
		ModelAndView modelAndView = new ModelAndView("MostrarPresentacion");
		modelAndView.addObject("archivo",fileName);
			return modelAndView;
	}
}
