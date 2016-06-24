package com.edu.Paola.DAO;

import java.sql.Types;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


import com.edu.Paola.model.Usuario;

public class UsuarioDAO extends JdbcDaoSupport {
	
	public int obtenerRol(Usuario usuario){
	//	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		String sqlGetUsuario = "SELECT rol FROM usuarios where usuario = ? and password = ?";
		
		try {
			return this.getJdbcTemplate().queryForObject(sqlGetUsuario, new Object[] {usuario.getUsuario(), usuario.getPassword()}, Integer.class);
			
		} catch (EmptyResultDataAccessException e) {
			return 0;// TODO: handle exception
		}
		
		

	}
	
	public int altaUsuario(Usuario usuario){
		
		String sqlAltaUsuario = "INSERT INTO usuarios VALUES(?,?,?)";
		this.getJdbcTemplate().update(sqlAltaUsuario, new Object[] {usuario.getUsuario(), usuario.getPassword(), 1});

		return 1;

		
	}
	
	public void  bajaUsuario(Usuario usuario)
	{
		
	
			
			   
		
			   // define query arguments
			
			         Object[] params = { usuario.getUsuarios() };
			
			         // define SQL types of the arguments
			
			         int[] types = {Types.VARCHAR};
			
			    
			    String deleteSql = "DELETE FROM usuarios WHERE usuario = ?";     
			   int rows = this.getJdbcTemplate().update(deleteSql, params, types);
			
			   System.out.println(rows + " row(s) deleted.");
		
			     

		System.out.println(usuario.getUsuarios());
	}

	public int obtenerCurso(Usuario usuario)
	{
	String sqlGetUsuario = "SELECT curso FROM usuarios where usuario = ? and password = ?";
		
		try {
			return this.getJdbcTemplate().queryForObject(sqlGetUsuario, new Object[] {usuario.getUsuario(), usuario.getPassword()}, Integer.class);
			
		} catch (EmptyResultDataAccessException e) {
			return 0;// TODO: handle exception
		}
		
		
	}
	
}
