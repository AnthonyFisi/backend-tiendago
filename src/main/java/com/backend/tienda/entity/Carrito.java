package com.backend.tienda.entity;

import java.io.Serializable;

public class Carrito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idProducto;
	private String producto_nombre;
	private String producto_marca;
	private String producto_envase;
	private String producto_detalle;
	private String producto_cantidad;
	private float Producto_precio;
	private int registropedido_cantidad;
	private float registropedido_preciototal;
	private String producto_uri_imagen;
	
	
	
	public String getProducto_uri_imagen() {
		return producto_uri_imagen;
	}
	public void setProducto_uri_imagen(String producto_uri_imagen) {
		this.producto_uri_imagen = producto_uri_imagen;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public float getProducto_precio() {
		return Producto_precio;
	}
	public void setProducto_precio(float producto_precio) {
		Producto_precio = producto_precio;
	}
	public String getProducto_marca() {
		return producto_marca;
	}
	public void setProducto_marca(String producto_marca) {
		this.producto_marca = producto_marca;
	}
	public String getProducto_envase() {
		return producto_envase;
	}
	public void setProducto_envase(String producto_envase) {
		this.producto_envase = producto_envase;
	}
	public String getProducto_detalle() {
		return producto_detalle;
	}
	public void setProducto_detalle(String producto_detalle) {
		this.producto_detalle = producto_detalle;
	}
	public String getProducto_cantidad() {
		return producto_cantidad;
	}
	public void setProducto_cantidad(String producto_cantidad) {
		this.producto_cantidad = producto_cantidad;
	}
	
	public String getProducto_nombre() {
		return producto_nombre;
	}
	public void setProducto_nombre(String producto_nombre) {
		this.producto_nombre = producto_nombre;
	}
	public int getRegistropedido_cantidad() {
		return registropedido_cantidad;
	}
	public void setRegistropedido_cantidad(int registropedido_cantidad) {
		this.registropedido_cantidad = registropedido_cantidad;
	}
	public float getregistropedido_preciototal() {
		return registropedido_preciototal;
	}
	public void setregistropedido_preciototal(float registropedido_preciototal) {
		this.registropedido_preciototal = registropedido_preciototal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
