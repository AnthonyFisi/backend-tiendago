package com.backend.tienda.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/*ESTE MODELO SOLO SERA USADO PARA REBIR DATOS DE LOS PRODUCTOS REGSTRADOS EN LA APLICACION  , NO ESTA IMPLEMENTADO EN OTROS METODOS*/

public class MainPedido implements Serializable{
	
	private int idproducto;
	
	private int idusuario;
	
	private int idempresa;
	
	private float precio;
	
	private int cantidad;
	
	private String comentario;
	

	public int getidproducto() {
		return idproducto;
	}

	public void setidproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



		
}
