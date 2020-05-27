package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carrito")
public class ProductoJOINregistroPedidoJOINpedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto", updatable = false, nullable = false)
	private int idproducto;
	
	private int idempresa;
	
	private String producto_nombre;
	
	private float producto_precio;
	
	private String producto_uriimagen;
	
	private float producto_calificacion;
	
	private float producto_descuento;
	
	private float producto_precio_descuento;
	
	private int registropedido_cantidadtotal;
	
	private float registropedido_preciototal;
	
	private int idpedido;
	
	private int idusuario;

	
	public int getRegistropedido_cantidadtotal() {
		return registropedido_cantidadtotal;
	}

	public void setRegistropedido_cantidadtotal(int registropedido_cantidadtotal) {
		this.registropedido_cantidadtotal = registropedido_cantidadtotal;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
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

	public float getProducto_descuento() {
		return producto_descuento;
	}

	public void setProducto_descuento(float producto_descuento) {
		this.producto_descuento = producto_descuento;
	}

	public float getProducto_precio_descuento() {
		return producto_precio_descuento;
	}

	public void setProducto_precio_descuento(float producto_precio_descuento) {
		this.producto_precio_descuento = producto_precio_descuento;
	}

	

	public float getRegistropedido_preciototal() {
		return registropedido_preciototal;
	}

	public void setRegistropedido_preciototal(float registropedido_preciototal) {
		this.registropedido_preciototal = registropedido_preciototal;
	}
	
	
	
	
	
	/*
	 * p.idproducto,p.idempresa,p.producto_nombre,p.producto_precio,p.producto_uriimagen,p.producto_calificacion,p.producto_descuento,
	 * p.producto_precio_descuento,
	rp.registropedido_cantidadtotal,rp.registropedido_preciototal,
	pe.idpedido
	 * */

}
