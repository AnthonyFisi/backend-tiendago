package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_envio")
public class Tipo_Envio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipo_envio", updatable = false, nullable = false)
	private int idtipo_envio;
	
	private String nombre_tipo_envio;

	public int getIdtipo_envio() {
		return idtipo_envio;
	}

	public void setIdtipo_envio(int idtipo_envio) {
		this.idtipo_envio = idtipo_envio;
	}

	public String getNombre_tipo_envio() {
		return nombre_tipo_envio;
	}

	public void setNombre_tipo_envio(String nombre_tipo_envio) {
		this.nombre_tipo_envio = nombre_tipo_envio;
	}
	
	
	

}
