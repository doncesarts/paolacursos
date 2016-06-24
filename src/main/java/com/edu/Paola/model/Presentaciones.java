package com.edu.Paola.model;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;


public class Presentaciones {
	 static Logger log = Logger.getLogger(Presentaciones.class.getName());
	private List<MultipartFile> files;
	private String habilitado;
	private String unidades;
	private String unidad;
	private String curso;
	

	





	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}

	public String getUnidades() {
		return unidades;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
}
