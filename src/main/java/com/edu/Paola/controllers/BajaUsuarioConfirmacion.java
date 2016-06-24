package com.edu.Paola.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.Paola.DAO.UsuarioDAO;
import com.edu.Paola.model.Usuario;
import com.edu.Paola.util.MapperUsuario;

@Controller
public class BajaUsuarioConfirmacion {
						  
	
	
	@RequestMapping(value="/BajaUsuarioConfirmacion", method=RequestMethod.GET)
	

	

	public String displayLogin(@ModelAttribute("usuario")Usuario usuario) { 
	   
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		 UsuarioDAO usuarioDAO= (UsuarioDAO)ctx.getBean("myJDBCdaoSupport");
		usuarioDAO.bajaUsuario(usuario);
	
			  
			   
		
		return "admin"; 
	}
	
	
}
