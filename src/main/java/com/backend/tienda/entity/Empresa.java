package com.backend.tienda.entity;

import java.io.Serializable;

public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (boletas ? 1231 : 1237);
		result = prime * result + ((celular_empresa == null) ? 0 : celular_empresa.hashCode());
		result = prime * result + ((descripcion_empresa == null) ? 0 : descripcion_empresa.hashCode());
		result = prime * result + idempresa;
		result = prime * result + idsubcategoriaempresa;
		result = prime * result + ((nombre_empresa == null) ? 0 : nombre_empresa.hashCode());
		result = prime * result + ((nombredueno_empresa == null) ? 0 : nombredueno_empresa.hashCode());
		result = prime * result + numerolocales;
		result = prime * result + ((ruc_empresa == null) ? 0 : ruc_empresa.hashCode());
		result = prime * result + ((telefono_empresa == null) ? 0 : telefono_empresa.hashCode());
		result = prime * result + ((ubicacion_empresa == null) ? 0 : ubicacion_empresa.hashCode());
		result = prime * result + ((urlfoto_empresa == null) ? 0 : urlfoto_empresa.hashCode());
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
		Empresa other = (Empresa) obj;
		if (boletas != other.boletas)
			return false;
		if (celular_empresa == null) {
			if (other.celular_empresa != null)
				return false;
		} else if (!celular_empresa.equals(other.celular_empresa))
			return false;
		if (descripcion_empresa == null) {
			if (other.descripcion_empresa != null)
				return false;
		} else if (!descripcion_empresa.equals(other.descripcion_empresa))
			return false;
		if (idempresa != other.idempresa)
			return false;
		if (idsubcategoriaempresa != other.idsubcategoriaempresa)
			return false;
		if (nombre_empresa == null) {
			if (other.nombre_empresa != null)
				return false;
		} else if (!nombre_empresa.equals(other.nombre_empresa))
			return false;
		if (nombredueno_empresa == null) {
			if (other.nombredueno_empresa != null)
				return false;
		} else if (!nombredueno_empresa.equals(other.nombredueno_empresa))
			return false;
		if (numerolocales != other.numerolocales)
			return false;
		if (ruc_empresa == null) {
			if (other.ruc_empresa != null)
				return false;
		} else if (!ruc_empresa.equals(other.ruc_empresa))
			return false;
		if (telefono_empresa == null) {
			if (other.telefono_empresa != null)
				return false;
		} else if (!telefono_empresa.equals(other.telefono_empresa))
			return false;
		if (ubicacion_empresa == null) {
			if (other.ubicacion_empresa != null)
				return false;
		} else if (!ubicacion_empresa.equals(other.ubicacion_empresa))
			return false;
		if (urlfoto_empresa == null) {
			if (other.urlfoto_empresa != null)
				return false;
		} else if (!urlfoto_empresa.equals(other.urlfoto_empresa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [idempresa=" + idempresa + ", idsubcategoriaempresa=" + idsubcategoriaempresa
				+ ", nombre_empresa=" + nombre_empresa + ", ubicacion_empresa=" + ubicacion_empresa + ", ruc_empresa="
				+ ruc_empresa + ", telefono_empresa=" + telefono_empresa + ", celular_empresa=" + celular_empresa
				+ ", boletas=" + boletas + ", descripcion_empresa=" + descripcion_empresa + ", urlfoto_empresa="
				+ urlfoto_empresa + ", nombredueno_empresa=" + nombredueno_empresa + ", numerolocales=" + numerolocales
				+ "]";
	}
	
	
	
	

}
