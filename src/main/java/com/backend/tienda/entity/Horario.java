package com.backend.tienda.entity;

import java.io.Serializable;

public class Horario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int idHorario;
	private String horario_nombre;

	
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public String getHorario_nombre() {
		return horario_nombre;
	}
	public void setHorario_nombre(String horario_nombre) {
		this.horario_nombre = horario_nombre;
	}
	
	
	

}
