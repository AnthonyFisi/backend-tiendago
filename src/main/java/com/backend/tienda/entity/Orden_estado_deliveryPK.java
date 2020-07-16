package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Orden_estado_deliveryPK implements Serializable {
	
	
	@Column(name="idventa")
	private int idventa;
	
	@Column(name="idestado_delivery")
	private int idestado_delivery;

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public int getIdestado_delivery() {
		return idestado_delivery;
	}

	public void setIdestado_delivery(int idestado_delivery) {
		this.idestado_delivery = idestado_delivery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idestado_delivery;
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
		Orden_estado_deliveryPK other = (Orden_estado_deliveryPK) obj;
		if (idestado_delivery != other.idestado_delivery)
			return false;
		if (idventa != other.idventa)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orden_estado_deliveryPK [idventa=" + idventa + ", idestado_delivery=" + idestado_delivery + "]";
	}


	
}
