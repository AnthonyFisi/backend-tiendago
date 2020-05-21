package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddepartamento", updatable = false, nullable = false)
	private int iddepartamento;
	
	private String nombre_departamento;

	public int getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getNombre_departamento() {
		return nombre_departamento;
	}

	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iddepartamento;
		result = prime * result + ((nombre_departamento == null) ? 0 : nombre_departamento.hashCode());
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
		Departamento other = (Departamento) obj;
		if (iddepartamento != other.iddepartamento)
			return false;
		if (nombre_departamento == null) {
			if (other.nombre_departamento != null)
				return false;
		} else if (!nombre_departamento.equals(other.nombre_departamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [iddepartamento=" + iddepartamento + ", nombre_departamento=" + nombre_departamento + "]";
	}
	
	

}
