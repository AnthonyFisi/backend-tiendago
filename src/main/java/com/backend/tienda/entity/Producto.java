package com.backend.tienda.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto", updatable = false, nullable = false)
	private int idProducto;
	private String Producto_nombre;
	private int Producto_precio;
	private int Producto_stock;
	private String Producto_codigo;
	private Date Producto_fechaCreacion;
	private int idImagenesProducto;
	private int idCategoria;
	private Date Producto_fechaVencimiento;
	private String producto_marca;
	private String producto_envase;
	private String producto_detalle;
	private String producto_cantidad;
	
	
	
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
	public int getProducto_precio() {
		return Producto_precio;
	}
	public void setProducto_precio(int producto_precio) {
		Producto_precio = producto_precio;
	}
	public int getProducto_stock() {
		return Producto_stock;
	}
	public void setProducto_stock(int producto_stock) {
		Producto_stock = producto_stock;
	}
	public String getProducto_codigo() {
		return Producto_codigo;
	}
	public void setProducto_codigo(String producto_codigo) {
		Producto_codigo = producto_codigo;
	}
	public Date getProducto_fechaCreacion() {
		return Producto_fechaCreacion;
	}
	public void setProducto_fechaCreacion(Date producto_fechaCreacion) {
		Producto_fechaCreacion = producto_fechaCreacion;
	}
	
	public int getIdImagenesProducto() {
		return idImagenesProducto;
	}
	public void setIdImagenesProducto(int idImagenesProducto) {
		this.idImagenesProducto = idImagenesProducto;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Date getProducto_fechaVencimiento() {
		return Producto_fechaVencimiento;
	}
	public void setProducto_fechaVencimiento(Date producto_fechaVencimiento) {
		Producto_fechaVencimiento = producto_fechaVencimiento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
