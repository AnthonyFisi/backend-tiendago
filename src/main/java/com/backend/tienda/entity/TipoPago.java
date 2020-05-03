package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPago implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipopago", updatable = false, nullable = false)
	private int idtipopago;
	private String tipopago_nombre;
	
	public int getIdtipopago() {
		return idtipopago;
	}
	public void setIdtipopago(int idtipopago) {
		this.idtipopago = idtipopago;
	}
	public String getTipopago_nombre() {
		return tipopago_nombre;
	}
	public void setTipopago_nombre(String tipopago_nombre) {
		this.tipopago_nombre = tipopago_nombre;
	}
	
}
