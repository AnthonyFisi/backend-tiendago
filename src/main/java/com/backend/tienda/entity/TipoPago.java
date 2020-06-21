package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipopago")
public class TipoPago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipopago", updatable = false, nullable = false)
	private int idtipopago;
	
	private String tipopago_nombre;
	
	private boolean tipopago_estado;
	
	private String tipopago_url;
	
	

	public boolean isTipopago_estado() {
		return tipopago_estado;
	}

	public void setTipopago_estado(boolean tipopago_estado) {
		this.tipopago_estado = tipopago_estado;
	}

	public String getTipopago_url() {
		return tipopago_url;
	}

	public void setTipopago_url(String tipopago_url) {
		this.tipopago_url = tipopago_url;
	}

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
