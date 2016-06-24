package com.edu.Paola.controllers;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.Paola.DAO.UnidadesDAO;
import com.edu.Paola.DAO.UsuarioDAO;
import com.edu.Paola.model.Unidades;
import com.edu.Paola.model.Usuario;
import com.edu.Paola.util.MapperUnidades;
import com.edu.Paola.util.MapperUnidadesAlumno;

@Controller
public class login {
	@RequestMapping(value="/procesaFormulario.do", method=RequestMethod.GET)
	public ModelAndView logueo(@ModelAttribute("usuario") Usuario usuario ){
		
		int curso;
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		 UsuarioDAO cursoDAO= (UsuarioDAO)ctx.getBean("myJDBCdaoSupport");
		int rol = cursoDAO.obtenerRol(usuario);
		ModelAndView modelAndView;
		if (rol == 1) {
			modelAndView = new ModelAndView("admin");
		} else if (rol > 1) 
			
		 {
			
			curso = cursoDAO.obtenerCurso(usuario);
			 MapperUnidadesAlumno mapperUnidadesAlumno= (MapperUnidadesAlumno)ctx.getBean("myJDBCdaoSupportUnidadesMapperAlumno");
			//UnidadesDAO unidadesDAO = new UnidadesDAO();
			List<Unidades> unidades =mapperUnidadesAlumno.getNombreMapper(curso);
		
			
			
			modelAndView = new ModelAndView("EstudianteMio");
			modelAndView.addObject("unidades", unidades);
			
			
		}
		
		else
		{
			modelAndView = new ModelAndView("login");
		}

		modelAndView.addObject(" " + usuario.getUsuario() + "y el rol " + rol);
		return modelAndView;
	}

}
