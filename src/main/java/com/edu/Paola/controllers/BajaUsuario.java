package com.edu.Paola.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.Paola.DAO.UsuarioDAO;
import com.edu.Paola.model.Usuario;
import com.edu.Paola.util.MapperUsuario;

@Controller
public class BajaUsuario {
	@RequestMapping(value="/BajaUsuario", method=RequestMethod.GET)
	
	public ModelAndView bajaUsuario(){
		
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		 MapperUsuario mapperUsuario= (MapperUsuario)ctx.getBean("myJDBCdaoSupportUsuario");
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("inner-form-baja");
		modelAndView.addObject("usuarios",mapperUsuario.getNombreMapper());
		modelAndView.addObject("usuario",new Usuario());
		//model.addAttribute("mypizza", new Pizza());
		return modelAndView;
		

	}
	
}
