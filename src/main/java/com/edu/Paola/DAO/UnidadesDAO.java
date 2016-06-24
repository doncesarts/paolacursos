package com.edu.Paola.DAO;

import java.io.FileInputStream;
import java.io.StringReader;
import java.sql.Types;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.edu.Paola.jaxb.TEMARIO;
import com.edu.Paola.model.Curso;
import com.edu.Paola.model.Unidades;
import com.edu.Paola.util.MapperUnidadesAlumno;


public class UnidadesDAO extends JdbcDaoSupport{

	public int altaUnidades(Curso curso, int id){
		
	
		JAXBContext ctx;



		 try {
			   ctx = JAXBContext.newInstance(TEMARIO.class);
			   Unmarshaller u = ctx.createUnmarshaller();
			   StringBuffer xmlStr = new StringBuffer( curso.getTemario() );
			   TEMARIO root = (TEMARIO) u.unmarshal( new StreamSource( new StringReader( xmlStr.toString() ) ));
			  
			    for(TEMARIO.UNIDAD p:root.getUNIDAD()){
			    
			   
			    System.out.println("el nombre es:" +p.getNOMBRE() + "y el id es:" +id);
			    List<String> ls = p.getTEMA();
			  
			    if(ls !=null && ls.size() > 0)
			    {
			  
			    	for (String temp : p.getTEMA() ) {
					
						String sqlAltaUsuario = "INSERT INTO UNIDADES(ID_CURSO, UNIDAD,TEMA) VALUES(?,?,?)";
						this.getJdbcTemplate().update(sqlAltaUsuario, new Object[] { id, p.getNOMBRE(), temp });
					}   
			    
			    	   
			    }
			    else
			    {
				String sqlAltaUsuario = "INSERT INTO UNIDADES(ID_CURSO, UNIDAD) VALUES(?,?)";
				this.getJdbcTemplate().update(sqlAltaUsuario, new Object[] { id, p.getNOMBRE() });
			    }	
			   }
			    
			  } catch (Exception e) {
			   e.printStackTrace();
			  }
		
		
		return 1;

		
	}
	
	
	public int ActualizarPresentacion(String ruta,  int unidad){
	
		Object[] params = { ruta, unidad};

		// define SQL types of the arguments

		int[] types = { Types.VARCHAR,  Types.INTEGER };

		String updateSql = "UPDATE UNIDADES SET ruta = ? WHERE id = ?";
		int rows = this.getJdbcTemplate().update(updateSql, params, types);

		System.out.println(rows + " row(s) actualizadas.");
		

		return 0;
	}

	
	public List<Unidades> getUnidades(int id){
		
	MapperUnidadesAlumno mapperUnidadesAlumno = new MapperUnidadesAlumno();
	
	return mapperUnidadesAlumno.getNombreMapper(id);

	
		
	}
}
