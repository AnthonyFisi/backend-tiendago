package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente_bi")
public class Cliente_Bi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuariogeneral", updatable = false, nullable = false)
	private int idusuariogeneral;

	private int idusuario;
	
	
	private String nombre;
	
	private String correo;
	
	private String celular;
	
	private String foto;
		
	private int idcuentausuario;
	
	private boolean activa;
	
	private int idtipocuenta;
	
	private int idubicacion;
	
	private String ubicacion_nombre;
	
	private String ubicacion_comentarios;
	
	private String maps_distrito;
	
	private String maps_detalle;
	
	private String maps_coordenada_x;
	
	private String maps_coordenada_y;

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	

	public int getIdcuentausuario() {
		return idcuentausuario;
	}

	public void setIdcuentausuario(int idcuentausuario) {
		this.idcuentausuario = idcuentausuario;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public int getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(int idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
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

	public String getMaps_distrito() {
		return maps_distrito;
	}

	public void setMaps_distrito(String maps_distrito) {
		this.maps_distrito = maps_distrito;
	}

	public String getMaps_detalle() {
		return maps_detalle;
	}

	public void setMaps_detalle(String maps_detalle) {
		this.maps_detalle = maps_detalle;
	}

	public String getMaps_coordenada_x() {
		return maps_coordenada_x;
	}

	public void setMaps_coordenada_x(String maps_coordenada_x) {
		this.maps_coordenada_x = maps_coordenada_x;
	}

	public String getMaps_coordenada_y() {
		return maps_coordenada_y;
	}

	public void setMaps_coordenada_y(String maps_coordenada_y) {
		this.maps_coordenada_y = maps_coordenada_y;
	}

	public int getIdusuariogeneral() {
		return idusuariogeneral;
	}

	public void setIdusuariogeneral(int idusuariogeneral) {
		this.idusuariogeneral = idusuariogeneral;
	}
	
	

}
