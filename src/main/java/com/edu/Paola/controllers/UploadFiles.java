package com.edu.Paola.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadFiles {
	


	    @RequestMapping(value = "/CursoUploadFile", method = RequestMethod.POST)

	    public String handleFormUpload(
	            @RequestParam("file") MultipartFile file) {
	/*    
	    String handleFormUpload(@RequestParam("names") String name,
	            @RequestParam("file") MultipartFile file) {
*/
	        if (!file.isEmpty()) {
	            try {
					byte[] bytes = file.getBytes();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            // store the bytes somewhere
	            return "redirect:uploadSuccess";
	        }

	        return "redirect:uploadFailure";
	    }

	
	/*@RequestMapping(method = RequestMethod.POST, value = "/CursoUploadFile2")
	public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name,
								   
								   RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView("inner-form-alta-exito");
	
		if (name.contains("/")) {
			redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
			return modelAndView;
		}
		if (name.contains("/")) {
			redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
			return modelAndView;
		}

		if (!file.isEmpty()) {
			try {
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("/" + name)));
				FileCopyUtils.copy(file.getInputStream(), stream);
				stream.close();
				redirectAttributes.addFlashAttribute("message",
						"You successfully uploaded " + name + "!");
			}
			catch (Exception e) {
				redirectAttributes.addFlashAttribute("message",
						"You failed to upload " + name + " => " + e.getMessage());
			}
		}
		else {
			redirectAttributes.addFlashAttribute("message",
					"You failed to upload " + name + " because the file was empty");
		}

		return modelAndView;
	}
*/
}
