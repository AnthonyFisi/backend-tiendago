package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Orden_estado_restaurantePK implements Serializable{

	
	@Column(name="idventa")
	private int idventa;
	
	@Column(name="idestado_venta")
	private int idestado_venta;

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public int getIdestado_venta() {
		return idestado_venta;
	}

	public void setIdestado_venta(int idestado_venta) {
		this.idestado_venta = idestado_venta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idestado_venta;
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
		Orden_estado_restaurantePK other = (Orden_estado_restaurantePK) obj;
		if (idestado_venta != other.idestado_venta)
			return false;
		if (idventa != other.idventa)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orden_estado_restaurantePK [idventa=" + idventa + ", idestado_venta=" + idestado_venta + "]";
	}
	
	
	
	
	
}
