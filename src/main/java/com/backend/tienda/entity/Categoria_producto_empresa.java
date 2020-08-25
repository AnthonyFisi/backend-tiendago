package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria_producto_empresa")
public class Categoria_producto_empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategoriaproductoempresa", updatable = false, nullable = false)
	private int idcategoriaproductoempresa;
	
	private int idempresa ;
	
	private String nombre ;
	
	private String descripcion;

	public int getIdcategoriaproductoempresa() {
		return idcategoriaproductoempresa;
	}

	public void setIdcategoriaproductoempresa(int idcategoriaproductoempresa) {
		this.idcategoriaproductoempresa = idcategoriaproductoempresa;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
