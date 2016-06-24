package com.edu.Paola.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.Paola.DAO.CursoDAO;
import com.edu.Paola.DAO.UsuarioDAO;
import com.edu.Paola.model.Curso;
import com.edu.Paola.model.Usuario;

@Controller
public class BajaCursoConfirmacion {


	
	@RequestMapping(value="/BajaCursoConfirmacion", method=RequestMethod.GET)
	

	

	public String displayLogin(@ModelAttribute("curso")Curso curso) { 
	   
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		 CursoDAO cursoDAO= (CursoDAO)ctx.getBean("myJDBCdaoSupportCurso");
		cursoDAO.bajaCurso(curso);
	
			  
			   
		
		return "admin"; 
	}
	
}
