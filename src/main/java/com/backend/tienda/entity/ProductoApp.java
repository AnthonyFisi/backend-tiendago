package com.backend.tienda.entity;

import java.sql.Date;

public class ProductoApp {
	
	
private int idproducto;
	
	private int idcategoriaproducto;
	
	private int idempresa;
	
	private String producto_nombre;
	
	private float producto_precio;
	
	private int producto_stock;
		
	private String producto_uriimagen;
	
	private float producto_calificacion;
	
	private String producto_detalle;
	
	private float producto_descuento;
	
	private float producto_precio_descuento;
	
	private boolean disponible;

	private int entrada;
	
	private int segundo;
	
	
	
	public float getProducto_precio_descuento() {
		return producto_precio_descuento;
	}

	public void setProducto_precio_descuento(float producto_precio_descuento) {
		this.producto_precio_descuento = producto_precio_descuento;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getIdcategoriaproducto() {
		return idcategoriaproducto;
	}

	public void setIdcategoriaproducto(int idcategoriaproducto) {
		this.idcategoriaproducto = idcategoriaproducto;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public String getProducto_nombre() {
		return producto_nombre;
	}

	public void setProducto_nombre(String producto_nombre) {
		this.producto_nombre = producto_nombre;
	}

	public float getProducto_precio() {
		return producto_precio;
	}

	public void setProducto_precio(float producto_precio) {
		this.producto_precio = producto_precio;
	}

	public int getProducto_stock() {
		return producto_stock;
	}

	public void setProducto_stock(int producto_stock) {
		this.producto_stock = producto_stock;
	}



	public String getProducto_uriimagen() {
		return producto_uriimagen;
	}

	public void setProducto_uriimagen(String producto_uriimagen) {
		this.producto_uriimagen = producto_uriimagen;
	}

	public float getProducto_calificacion() {
		return producto_calificacion;
	}

	public void setProducto_calificacion(float producto_calificacion) {
		this.producto_calificacion = producto_calificacion;
	}

	public String getProducto_detalle() {
		return producto_detalle;
	}

	public void setProducto_detalle(String producto_detalle) {
		this.producto_detalle = producto_detalle;
	}

	public float getProducto_descuento() {
		return producto_descuento;
	}

	public void setProducto_descuento(float producto_descuento) {
		this.producto_descuento = producto_descuento;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getEntrada() {
		return entrada;
	}

	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	

}
