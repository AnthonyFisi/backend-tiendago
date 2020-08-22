package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Orden_estado_empresaPK implements Serializable{

	
	@Column(name="idventa")
	private int idventa;
	
	@Column(name="idestado_empresa")
	private int idestado_empresa;

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public int getIdestado_empresa() {
		return idestado_empresa;
	}

	public void setIdestado_empresa(int idestado_empresa) {
		this.idestado_empresa = idestado_empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idestado_empresa;
		result = prime * result + idventa;
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
		Orden_estado_empresaPK other = (Orden_estado_empresaPK) obj;
		if (idestado_empresa != other.idestado_empresa)
			return false;
		if (idventa != other.idventa)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orden_estado_restaurantePK [idventa=" + idventa + ", idestado_empresa=" + idestado_empresa + "]";
	}


	
	
	
	
	
}
