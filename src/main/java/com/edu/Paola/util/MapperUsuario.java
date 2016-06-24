package com.edu.Paola.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.edu.Paola.model.Usuario;

public final class MapperUsuario extends JdbcDaoSupport implements RowMapper<Usuario> {

	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

					Usuario usuario = new Usuario();
					usuario.setUsuario(rs.getString("usuario"));
					
					return usuario;

	}
	

	public List<Usuario> getNombreMapper(){
		String sqlGetUsuarios = "SELECT usuario FROM usuarios";
		try {
			 List<Usuario> usuario = getJdbcTemplate().query(sqlGetUsuarios, new MapperUsuario());
			return usuario;
		
			
		} catch (EmptyResultDataAccessException e) {
			return null;// TODO: handle exception
		}
	
	}

	

}
