package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ubicacion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idubicacion", updatable = false, nullable = false)
	private int idubicacion;
	
	private String ubicacion_nombre;
	private String ubicacion_comentarios;
	private int idusuario;
	private String ubicacion_estado;
	private boolean eliminado ;
	
	
	
	public String getUbicacion_estado() {
		return ubicacion_estado;
	}
	public void setUbicacion_estado(String ubicacion_estado) {
		this.ubicacion_estado = ubicacion_estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public int getIdubicacion() {
		return idubicacion;
	}
	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}
	public String getUbicacion_nombre() {
		return ubicacion_nombre;
	}
	public void setUbicacion_nombre(String ubicacion_nombre) {
		this.ubicacion_nombre = ubicacion_nombre;
	}
	public String getUbicacion_comentarios() {
		return ubicacion_comentarios;
	}
	public void setUbicacion_comentarios(String ubicacion_comentarios) {
		this.ubicacion_comentarios = ubicacion_comentarios;
	}
	public boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	

}
