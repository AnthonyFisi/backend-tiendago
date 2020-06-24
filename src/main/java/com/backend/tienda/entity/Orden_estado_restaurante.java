package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="orden_estado_restaurante")
public class Orden_estado_restaurante {
	
	
	@EmbeddedId
	Orden_estado_restaurantePK id;
	
	private String detalle;
	
	private Timestamp fecha;

	public Orden_estado_restaurantePK getId() {
		return id;
	}

	public void setId(Orden_estado_restaurantePK id) {
		this.id = id;
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
