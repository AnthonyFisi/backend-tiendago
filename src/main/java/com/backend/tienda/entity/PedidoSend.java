package com.backend.tienda.entity;

import java.io.Serializable;

public class PedidoSend  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private int idProducto;
	private int cantidad;
	private float precio;
	private int idUsuario;
	
	
	
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
