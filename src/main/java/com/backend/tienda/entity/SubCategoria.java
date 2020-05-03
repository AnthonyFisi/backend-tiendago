package com.backend.tienda.entity;

import java.io.Serializable;

public class SubCategoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int idsubcategoria;
	private int idcategoria;
	private String nombresubcategoria;
	private String urisubcategoria;
	private String detalle;
	public int getIdsubcategoria() {
		return idsubcategoria;
	}
	public void setIdsubcategoria(int idsubcategoria) {
		this.idsubcategoria = idsubcategoria;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getNombresubcategoria() {
		return nombresubcategoria;
	}
	public void setNombresubcategoria(String nombresubcategoria) {
		this.nombresubcategoria = nombresubcategoria;
	}
	public String getUrisubcategoria() {
		return urisubcategoria;
	}
	public void setUrisubcategoria(String urisubcategoria) {
		this.urisubcategoria = urisubcategoria;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
