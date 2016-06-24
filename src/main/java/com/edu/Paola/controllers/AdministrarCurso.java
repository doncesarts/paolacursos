package com.edu.Paola.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.Paola.DAO.CursoDAO;
import com.edu.Paola.DAO.UnidadesDAO;
import com.edu.Paola.model.Curso;
import com.edu.Paola.model.Usuario;
import com.edu.Paola.util.MapperCursos;
import com.edu.Paola.util.MapperUnidades;
import com.edu.Paola.util.MapperUsuario;

@Controller
public class AdministrarCurso {
	@RequestMapping(value="/AdministrarCurso", method=RequestMethod.GET)
	
	public ModelAndView administrarCurso(){
		
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		 MapperCursos mapperCurso= (MapperCursos)ctx.getBean("myJDBCdaoSupportCursoMapper");
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("inner-form-administrar-curso");
		modelAndView.addObject("cursos",mapperCurso.getNombreMapper());
		modelAndView.addObject("curso",new Curso());
		return modelAndView;
		

	}
	
	
	@RequestMapping(value="/CursoAltaContenido", method=RequestMethod.POST)
	
	public ModelAndView altaContenido(@ModelAttribute("curso") Curso curso){
		
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");

		ModelAndView modelAndView;
		modelAndView = new ModelAndView("AltaContenido");
		 MapperUnidades mapperUnidades= (MapperUnidades)ctx.getBean("myJDBCdaoSupportUnidadesMapper");
		int i;
		 modelAndView.addObject("unidades",mapperUnidades.getNombreMapper(curso.getCursos()));
		//modelAndView.addObject("curso",new Curso());
		modelAndView.addObject("nomcurso",curso.getCursos());
		
		return modelAndView;
		

	}
	
	@RequestMapping(value="/CursoAltaTemario", method=RequestMethod.POST)

	public ModelAndView CursoAltaTemario(@ModelAttribute("curso") Curso curso){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		 CursoDAO cursoDAO= (CursoDAO)ctx.getBean("myJDBCdaoSupportCurso");
		cursoDAO.ActualizarTemario(curso);
		int id = cursoDAO.ObtenerId(curso);
		UnidadesDAO unidadesDao = (UnidadesDAO)ctx.getBean("myJDBCdaoSupportUnidades");
		unidadesDao.altaUnidades(curso,id);
		ModelAndView modelAndView = new ModelAndView("inner-form-alta-exito");
			return modelAndView;
		
	}
	
	

	
}