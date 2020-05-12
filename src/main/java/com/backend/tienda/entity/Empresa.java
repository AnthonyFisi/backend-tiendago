package com.backend.tienda.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresa")

public class Empresa{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempresa", updatable = false, nullable = false)
	private int idempresa;
	
	private int idsubcategoriaempresa;
	
	private String nombre_empresa;
	
	private String ubicacion_empresa;
	
	private String ruc_empresa;
	
	private String telefono_empresa;
	
	private String celular_empresa;
	
	private boolean boletas;
	
	private String descripcion_empresa;
	
	private String urlfoto_empresa;
	
	private String nombredueno_empresa;
	
	private int numerolocales;
	
	private int idcuentaempresa;
	
	private double porcentaje_popularidad;

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public int getIdsubcategoriaempresa() {
		return idsubcategoriaempresa;
	}

	public void setIdsubcategoriaempresa(int idsubcategoriaempresa) {
		this.idsubcategoriaempresa = idsubcategoriaempresa;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getUbicacion_empresa() {
		return ubicacion_empresa;
	}

	public void setUbicacion_empresa(String ubicacion_empresa) {
		this.ubicacion_empresa = ubicacion_empresa;
	}

	public String getRuc_empresa() {
		return ruc_empresa;
	}

	public void setRuc_empresa(String ruc_empresa) {
		this.ruc_empresa = ruc_empresa;
	}

	public String getTelefono_empresa() {
		return telefono_empresa;
	}

	public void setTelefono_empresa(String telefono_empresa) {
		this.telefono_empresa = telefono_empresa;
	}

	public String getCelular_empresa() {
		return celular_empresa;
	}

	public void setCelular_empresa(String celular_empresa) {
		this.celular_empresa = celular_empresa;
	}

	public boolean isBoletas() {
		return boletas;
	}

	public void setBoletas(boolean boletas) {
		this.boletas = boletas;
	}

	public String getDescripcion_empresa() {
		return descripcion_empresa;
	}

	public void setDescripcion_empresa(String descripcion_empresa) {
		this.descripcion_empresa = descripcion_empresa;
	}

	public String getUrlfoto_empresa() {
		return urlfoto_empresa;
	}

	public void setUrlfoto_empresa(String urlfoto_empresa) {
		this.urlfoto_empresa = urlfoto_empresa;
	}

	public String getNombredueno_empresa() {
		return nombredueno_empresa;
	}

	public void setNombredueno_empresa(String nombredueno_empresa) {
		this.nombredueno_empresa = nombredueno_empresa;
	}

	public int getNumerolocales() {
		return numerolocales;
	}

	public void setNumerolocales(int numerolocales) {
		this.numerolocales = numerolocales;
	}

	public int getIdcuentaempresa() {
		return idcuentaempresa;
	}

	public void setIdcuentaempresa(int idcuentaempresa) {
		this.idcuentaempresa = idcuentaempresa;
	}

	public double getPorcentaje_popularidad() {
		return porcentaje_popularidad;
	}

	public void setPorcentaje_popularidad(double porcentaje_popularidad) {
		this.porcentaje_popularidad = porcentaje_popularidad;
	}
	

}
