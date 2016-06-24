package com.edu.Paola.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.edu.Paola.model.Unidades;

public class MapperUnidadesAlumno extends JdbcDaoSupport implements RowMapper<Unidades>{

	@Override
	public Unidades mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Unidades unidades = new Unidades();
		unidades.setUnidad(rs.getString("UNIDAD"));
		unidades.setId_curso(rs.getInt("ID_CURSO"));
		unidades.setRuta(rs.getString("RUTA"));
	
		
		return unidades;
		
	}
	
	public List<Unidades> getNombreMapper(int idCurso){
		
		String sqlGetUnidades = "SELECT UNIDADES.UNIDAD, UNIDADES.ID_CURSO, UNIDADES.RUTA FROM UNIDADES WHERE ID_CURSO = " +idCurso;
		try {
			
		

			
			 List<Unidades> unidades = getJdbcTemplate().query(sqlGetUnidades, new MapperUnidadesAlumno());
			return unidades;
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;// TODO: handle exception
		}
	
	}
	

}
