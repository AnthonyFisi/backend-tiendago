package com.backend.tienda.entity;

import java.io.Serializable;

public class HistorialProductos implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private int idproducto;
	private String producto_nombre;
	private String producto_marca;
	private String producto_envase;
	private String producto_detalle;
	private String producto_cantidad;
	private float producto_precio;
	private String producto_uri_imagen;
	private String pedido_fecha_registro;
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getProducto_nombre() {
		return producto_nombre;
	}
	public void setProducto_nombre(String producto_nombre) {
		this.producto_nombre = producto_nombre;
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
	public float getProducto_precio() {
		return producto_precio;
	}
	public void setProducto_precio(float producto_precio) {
		this.producto_precio = producto_precio;
	}
	public String getProducto_uri_imagen() {
		return producto_uri_imagen;
	}
	public void setProducto_uri_imagen(String producto_uri_imagen) {
		this.producto_uri_imagen = producto_uri_imagen;
	}
	public String getPedido_fecha_registro() {
		return pedido_fecha_registro;
	}
	public void setPedido_fecha_registro(String pedido_fecha_registro) {
		this.pedido_fecha_registro = pedido_fecha_registro;
	}
	
	
	

}
