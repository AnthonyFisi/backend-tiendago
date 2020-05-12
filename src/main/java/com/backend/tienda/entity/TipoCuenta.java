package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipocuenta")
public class TipoCuenta implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipocuenta", updatable = false, nullable = false)
	private int idtipocuenta;
	
	private String nombrecuenta;

	public int getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(int idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
	}

	public String getNombrecuenta() {
		return nombrecuenta;
	}

	public void setNombrecuenta(String nombrecuenta) {
		this.nombrecuenta = nombrecuenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idtipocuenta;
		result = prime * result + ((nombrecuenta == null) ? 0 : nombrecuenta.hashCode());
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
		TipoCuenta other = (TipoCuenta) obj;
		if (idtipocuenta != other.idtipocuenta)
			return false;
		if (nombrecuenta == null) {
			if (other.nombrecuenta != null)
				return false;
		} else if (!nombrecuenta.equals(other.nombrecuenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoCuenta [idtipocuenta=" + idtipocuenta + ", nombrecuenta=" + nombrecuenta + "]";
	}
	
	
	
	

}
