package com.backend.tienda.entity;

import java.io.Serializable;

public class MasBuscados implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private int idProducto;
	private String Producto_nombre;
	private float Producto_precio;
	private int idCategoria;
	private String Categoria_nombre;
	private String Categoria_descripcion;
	private int idImagenesProducto;
	private String ImagenesProducto_nombre ;
	private String ImagenesProducto_uri;
	private String producto_marca;
	private String producto_envase;
	private String producto_detalle;
	private String producto_cantidad;
	private float porcentaje;
	
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto_nombre() {
		return Producto_nombre;
	}
	public void setProducto_nombre(String producto_nombre) {
		Producto_nombre = producto_nombre;
	}
	public float getProducto_precio() {
		return Producto_precio;
	}
	public void setProducto_precio(float producto_precio) {
		Producto_precio = producto_precio;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getCategoria_nombre() {
		return Categoria_nombre;
	}
	public void setCategoria_nombre(String categoria_nombre) {
		Categoria_nombre = categoria_nombre;
	}
	public String getCategoria_descripcion() {
		return Categoria_descripcion;
	}
	public void setCategoria_descripcion(String categoria_descripcion) {
		Categoria_descripcion = categoria_descripcion;
	}
	public int getIdImagenesProducto() {
		return idImagenesProducto;
	}
	public void setIdImagenesProducto(int idImagenesProducto) {
		this.idImagenesProducto = idImagenesProducto;
	}
	public String getImagenesProducto_nombre() {
		return ImagenesProducto_nombre;
	}
	public void setImagenesProducto_nombre(String imagenesProducto_nombre) {
		ImagenesProducto_nombre = imagenesProducto_nombre;
	}
	public String getImagenesProducto_uri() {
		return ImagenesProducto_uri;
	}
	public void setImagenesProducto_uri(String imagenesProducto_uri) {
		ImagenesProducto_uri = imagenesProducto_uri;
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
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
