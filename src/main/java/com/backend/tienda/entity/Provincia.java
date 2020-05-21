package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="provincia")
public class Provincia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idprovincia", updatable = false, nullable = false)
	private int idprovincia;
	
	private String nombre_provincia;
	
	private int iddepartamento;

	public int getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getNombre_provincia() {
		return nombre_provincia;
	}

	public void setNombre_provincia(String nombre_provincia) {
		this.nombre_provincia = nombre_provincia;
	}

	public int getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iddepartamento;
		result = prime * result + idprovincia;
		result = prime * result + ((nombre_provincia == null) ? 0 : nombre_provincia.hashCode());
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
		Provincia other = (Provincia) obj;
		if (iddepartamento != other.iddepartamento)
			return false;
		if (idprovincia != other.idprovincia)
			return false;
		if (nombre_provincia == null) {
			if (other.nombre_provincia != null)
				return false;
		} else if (!nombre_provincia.equals(other.nombre_provincia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Provincia [idprovincia=" + idprovincia + ", nombre_provincia=" + nombre_provincia + ", iddepartamento="
				+ iddepartamento + "]";
	}
	
	

}
