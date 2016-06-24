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

@Controller
public class AltaUsuario {
	
	@RequestMapping(value="/AltaUsuario", method=RequestMethod.POST)
	
	public ModelAndView AltaUsuario(@ModelAttribute("usuario") Usuario usuario){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		 UsuarioDAO usuarioDAO= (UsuarioDAO)ctx.getBean("myJDBCdaoSupport");
		usuarioDAO.altaUsuario(usuario);
		ModelAndView modelAndView = new ModelAndView("inner-form-alta-exito");
			return modelAndView;
		
	}
	

}
