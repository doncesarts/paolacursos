package com.edu.Paola.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.Paola.DAO.CursoDAO;
import com.edu.Paola.model.Curso;


@Controller
public class AltaCurso {

	@RequestMapping(value="/AltaCurso", method=RequestMethod.POST)
	public ModelAndView AltaCurso(@ModelAttribute("curso") Curso curso){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		 CursoDAO cursoDAO= (CursoDAO)ctx.getBean("myJDBCdaoSupportCurso");
		cursoDAO.altaCurso(curso);
		ModelAndView modelAndView = new ModelAndView("inner-form-alta-exito");
			return modelAndView;
		
	}
}
