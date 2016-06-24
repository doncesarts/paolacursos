package com.edu.Paola.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.edu.Paola.model.Curso;
import com.edu.Paola.model.Unidades;

public class MapperUnidades extends JdbcDaoSupport implements RowMapper<Unidades> {

	public Unidades mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Unidades unidades = new Unidades();
		unidades.setUnidad(rs.getString("UNIDAD"));
		unidades.setId(rs.getInt("ID"));
		
		return unidades;
		
	}
	
	
	public List<Unidades> getNombreMapper(String nombre){
		
		String sqlGetUnidades = "SELECT UNIDADES.ID,UNIDADES.UNIDAD FROM CURSOS INNER JOIN UNIDADES WHERE UNIDADES.ID_CURSO = CURSOS.ID AND CURSOS.NOMBRE =  "+ "'" + nombre + "'";
		try {
			 List<Unidades> unidades = getJdbcTemplate().query(sqlGetUnidades, new MapperUnidades());
			return unidades;
		
			
		} catch (Exception e) {
			return null;// TODO: handle exception
		}
	
	}

}
