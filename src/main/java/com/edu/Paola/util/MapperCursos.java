package com.edu.Paola.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.edu.Paola.model.Curso;



public class MapperCursos extends JdbcDaoSupport implements RowMapper<Curso> {
	public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

					Curso curso = new Curso();
					curso.setNombre(rs.getString("nombre"));
					
					return curso;

	}
	

	public List<Curso> getNombreMapper(){
		String sqlGetCurso = "SELECT nombre FROM cursos";
		try {
			 List<Curso> curso = getJdbcTemplate().query(sqlGetCurso, new MapperCursos());
			return curso;
		
			
		} catch (EmptyResultDataAccessException e) {
			return null;// TODO: handle exception
		}
	
	}
	
	
	
}
