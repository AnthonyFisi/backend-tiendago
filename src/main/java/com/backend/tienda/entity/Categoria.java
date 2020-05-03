package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategoria", updatable = false, nullable = false)
	private int idCategoria;
	
	private String Categoria_nombre;
	private String Categoria_descripcion;
	private String Categoria_imagen;
	private String Categoria_uri_post;


	
	public String getCategoria_uri_post() {
		return Categoria_uri_post;
	}
	public void setCategoria_uri_post(String categoria_uri_post) {
		Categoria_uri_post = categoria_uri_post;
	}
	public String getCategoria_imagen() {
		return Categoria_imagen;
	}
	public void setCategoria_imagen(String categoria_imagen) {
		Categoria_imagen = categoria_imagen;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", Categoria_nombre=" + Categoria_nombre
				+ ", Categoria_descripcion=" + Categoria_descripcion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Categoria_descripcion == null) ? 0 : Categoria_descripcion.hashCode());
		result = prime * result + ((Categoria_nombre == null) ? 0 : Categoria_nombre.hashCode());
		result = prime * result + idCategoria;
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
		Categoria other = (Categoria) obj;
		if (Categoria_descripcion == null) {
			if (other.Categoria_descripcion != null)
				return false;
		} else if (!Categoria_descripcion.equals(other.Categoria_descripcion))
			return false;
		if (Categoria_nombre == null) {
			if (other.Categoria_nombre != null)
				return false;
		} else if (!Categoria_nombre.equals(other.Categoria_nombre))
			return false;
		if (idCategoria != other.idCategoria)
			return false;
		return true;
	}
	
	

}
