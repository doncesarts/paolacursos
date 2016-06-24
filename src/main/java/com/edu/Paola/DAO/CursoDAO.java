package com.edu.Paola.DAO;

import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.edu.Paola.model.Curso;
import com.edu.Paola.model.Usuario;

public class CursoDAO extends JdbcDaoSupport {

	public int altaCurso(Curso curso) {

		String sqlAltaUsuario = "INSERT INTO cursos(NOMBRE,DESCRIPCION) VALUES(?,?)";
		this.getJdbcTemplate().update(sqlAltaUsuario, new Object[] { curso.getNombre(), curso.getDescripcion() });

		return 1;

	}

	public void bajaCurso(Curso curso) {

		// define query arguments

		Object[] params = { curso.getCursos() };

		// define SQL types of the arguments

		int[] types = { Types.VARCHAR };

		String deleteSql = "DELETE FROM cursos WHERE nombre = ?";
		int rows = this.getJdbcTemplate().update(deleteSql, params, types);

		System.out.println(rows + " row(s) deleted.");

		// System.out.println(curso.getUsuarios());
	}

	public void ActualizarTemario(Curso curso) {
		// define query arguments

		Object[] params = { curso.getTemario(), curso.getCursos() };

		// define SQL types of the arguments

		int[] types = { Types.VARCHAR, Types.VARCHAR };

		String updateSql = "UPDATE cursos SET temario = ? WHERE nombre = ?";
		int rows = this.getJdbcTemplate().update(updateSql, params, types);

		System.out.println(rows + " row(s) actualizadas.");

/*		UnidadesDAO unidadesDAO = new UnidadesDAO();
		unidadesDAO.altaUnidades(curso);*/
	}

	public int ObtenerId(Curso curso){
		try {
			String updateSql = "SELECT ID FROM cursos where NOMBRE = " + "'" +curso.getCursos() + "'";

			Object[] params = {curso.getCursos() };
			int[] types = { Types.VARCHAR };
			
			int id = this.getJdbcTemplate().queryForObject(updateSql, Integer.class);
			JdbcTemplate jdbc = this.getJdbcTemplate();
		

			return id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
