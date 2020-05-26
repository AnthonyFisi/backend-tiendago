package com.backend.tienda.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto", updatable = false, nullable = false)
	private int idproducto;
	
	private int idcategoriaproducto;
	
	private int idempresa;
	
	private String producto_nombre;
	
	private float producto_precio;
	
	private int producto_stock;
	
	private Date producto_fechacreacion;
	
	private String producto_uriimagen;
	
	private float producto_calificacion;
	
	private String producto_detalle;
	
	private float producto_descuento;

	
	
	
	
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

	public Date getProducto_fechacreacion() {
		return producto_fechacreacion;
	}

	public void setProducto_fechacreacion(Date producto_fechacreacion) {
		this.producto_fechacreacion = producto_fechacreacion;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idcategoriaproducto;
		result = prime * result + idempresa;
		result = prime * result + idproducto;
		result = prime * result + Float.floatToIntBits(producto_calificacion);
		result = prime * result + Float.floatToIntBits(producto_descuento);
		result = prime * result + ((producto_detalle == null) ? 0 : producto_detalle.hashCode());
		result = prime * result + ((producto_fechacreacion == null) ? 0 : producto_fechacreacion.hashCode());
		result = prime * result + ((producto_nombre == null) ? 0 : producto_nombre.hashCode());
		result = prime * result + Float.floatToIntBits(producto_precio);
		result = prime * result + producto_stock;
		result = prime * result + ((producto_uriimagen == null) ? 0 : producto_uriimagen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (idcategoriaproducto != other.idcategoriaproducto)
			return false;
		if (idempresa != other.idempresa)
			return false;
		if (idproducto != other.idproducto)
			return false;
		if (Float.floatToIntBits(producto_calificacion) != Float.floatToIntBits(other.producto_calificacion))
			return false;
		if (Float.floatToIntBits(producto_descuento) != Float.floatToIntBits(other.producto_descuento))
			return false;
		if (producto_detalle == null) {
			if (other.producto_detalle != null)
				return false;
		} else if (!producto_detalle.equals(other.producto_detalle))
			return false;
		if (producto_fechacreacion == null) {
			if (other.producto_fechacreacion != null)
				return false;
		} else if (!producto_fechacreacion.equals(other.producto_fechacreacion))
			return false;
		if (producto_nombre == null) {
			if (other.producto_nombre != null)
				return false;
		} else if (!producto_nombre.equals(other.producto_nombre))
			return false;
		if (Float.floatToIntBits(producto_precio) != Float.floatToIntBits(other.producto_precio))
			return false;
		if (producto_stock != other.producto_stock)
			return false;
		if (producto_uriimagen == null) {
			if (other.producto_uriimagen != null)
				return false;
		} else if (!producto_uriimagen.equals(other.producto_uriimagen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [idproducto=" + idproducto + ", idcategoriaproducto=" + idcategoriaproducto + ", idempresa="
				+ idempresa + ", producto_nombre=" + producto_nombre + ", producto_precio=" + producto_precio
				+ ", producto_stock=" + producto_stock + ", producto_fechacreacion=" + producto_fechacreacion
				+ ", producto_uriimagen=" + producto_uriimagen + ", producto_calificacion=" + producto_calificacion
				+ ", producto_detalle=" + producto_detalle + ", producto_descuento=" + producto_descuento + "]";
	}

	
	
	
}
