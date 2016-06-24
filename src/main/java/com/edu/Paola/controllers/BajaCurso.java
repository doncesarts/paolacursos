package com.edu.Paola.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.Paola.model.Curso;
import com.edu.Paola.model.Usuario;
import com.edu.Paola.util.MapperCursos;
import com.edu.Paola.util.MapperUsuario;

@Controller
public class BajaCurso {
	@RequestMapping(value="/BajaCurso", method=RequestMethod.GET)
	
	public ModelAndView bajaUsuario(){
		
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		 MapperCursos mapperCurso= (MapperCursos)ctx.getBean("myJDBCdaoSupportCursoMapper");
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("inner-form-baja-curso");
		modelAndView.addObject("cursos",mapperCurso.getNombreMapper());
		modelAndView.addObject("curso",new Curso());
		//model.addAttribute("mypizza", new Pizza());
		return modelAndView;
		

	}
	
}