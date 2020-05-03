package com.backend.tienda.entity;

import java.io.Serializable;

public class ProductoJOINCategoriaJOINImagen implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idProducto;
	private String Producto_nombre;
	private float Producto_precio;
	private int idCategoria;
	private String Categoria_nombre;
	private String Categoria_descripcion;
	private String producto_uri_imagen;
	private String producto_marca;
	private String producto_envase;
	private String producto_detalle;
	private String producto_cantidad;
	private String nombresubcategoria;
	private int idSubcategoria;
	private String detalle; 
	
	
	
	
	public String getProducto_uri_imagen() {
		return producto_uri_imagen;
	}
	public void setProducto_uri_imagen(String producto_uri_imagen) {
		this.producto_uri_imagen = producto_uri_imagen;
	}
	public String getNombresubcategoria() {
		return nombresubcategoria;
	}
	public void setNombresubcategoria(String nombresubcategoria) {
		this.nombresubcategoria = nombresubcategoria;
	}
	public int getIdSubcategoria() {
		return idSubcategoria;
	}
	public void setIdSubcategoria(int idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
