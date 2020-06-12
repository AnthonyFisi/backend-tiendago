package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ubicacion")
public class Ubicacion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idubicacion", updatable = false, nullable = false)
	private int idubicacion;
	
	private String ubicacion_nombre;
	
	private String ubicacion_comentarios;
	
	private int idusuario;
	
	private boolean ubicacion_estado;
	
	private boolean eliminado ;
	
	private String maps_distrito;
	
	private String maps_detalle;
	
	private float maps_coordenada_x;
	
	private float maps_coordenada_y;

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

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}



	public boolean isUbicacion_estado() {
		return ubicacion_estado;
	}

	public void setUbicacion_estado(boolean ubicacion_estado) {
		this.ubicacion_estado = ubicacion_estado;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public String getMaps_distrito() {
		return maps_distrito;
	}

	public void setMaps_distrito(String maps_distrito) {
		this.maps_distrito = maps_distrito;
	}


	public float getMaps_coordenada_x() {
		return maps_coordenada_x;
	}

	public void setMaps_coordenada_x(float maps_coordenada_x) {
		this.maps_coordenada_x = maps_coordenada_x;
	}

	public String getMaps_detalle() {
		return maps_detalle;
	}

	public void setMaps_detalle(String maps_detalle) {
		this.maps_detalle = maps_detalle;
	}

	public float getMaps_coordenada_y() {
		return maps_coordenada_y;
	}

	public void setMaps_coordenada_y(float maps_coordenada_y) {
		this.maps_coordenada_y = maps_coordenada_y;
	}

	
	
	
	
	
	
}
