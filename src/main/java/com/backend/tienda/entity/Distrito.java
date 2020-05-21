package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="distrito")
public class Distrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddistrito", updatable = false, nullable = false)
	private int iddistrito;
	
	private String nombre_distrito;
	
	private int idprovincia;

	public int getIddistrito() {
		return iddistrito;
	}

	public void setIddistrito(int iddistrito) {
		this.iddistrito = iddistrito;
	}

	public String getNombre_distrito() {
		return nombre_distrito;
	}

	public void setNombre_distrito(String nombre_distrito) {
		this.nombre_distrito = nombre_distrito;
	}

	public int getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iddistrito;
		result = prime * result + idprovincia;
		result = prime * result + ((nombre_distrito == null) ? 0 : nombre_distrito.hashCode());
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
		Distrito other = (Distrito) obj;
		if (iddistrito != other.iddistrito)
			return false;
		if (idprovincia != other.idprovincia)
			return false;
		if (nombre_distrito == null) {
			if (other.nombre_distrito != null)
				return false;
		} else if (!nombre_distrito.equals(other.nombre_distrito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dsitrito [iddistrito=" + iddistrito + ", nombre_distrito=" + nombre_distrito + ", idprovincia="
				+ idprovincia + "]";
	}
	
	

}
