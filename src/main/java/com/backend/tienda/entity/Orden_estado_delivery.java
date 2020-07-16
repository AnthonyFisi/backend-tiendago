package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="orden_estado_delivery")
public class Orden_estado_delivery {
	
	@EmbeddedId
	Orden_estado_deliveryPK id;
	
	private int idrepartidor;
	
	private String detalle;
	
	private Timestamp fecha;

	


	public Orden_estado_deliveryPK getId() {
		return id;
	}

	public void setId(Orden_estado_deliveryPK id) {
		this.id = id;
	}

	
	
	public int getIdrepartidor() {
		return idrepartidor;
	}

	public void setIdrepartidor(int idrepartidor) {
		this.idrepartidor = idrepartidor;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
	

}
