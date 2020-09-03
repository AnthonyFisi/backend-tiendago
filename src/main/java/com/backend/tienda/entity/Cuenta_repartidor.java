package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cuenta_repartidor")
public class Cuenta_repartidor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcuentarepartidor", updatable = false, nullable = false)
	private int idcuentarepartidor;
	
	private boolean activa;
	
	private Timestamp fecharegistro;
	
	private Timestamp fechavencimiento;
	
	private int idtarifa;
	
	private int idtipocuenta;
	
	private int idrepartidor;
	
	private float montoabonado;

	public int getIdcuentarepartidor() {
		return idcuentarepartidor;
	}

	public void setIdcuentarepartidor(int idcuentarepartidor) {
		this.idcuentarepartidor = idcuentarepartidor;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Timestamp getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Timestamp getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Timestamp fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public int getIdtarifa() {
		return idtarifa;
	}

	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}

	public int getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(int idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
	}

	public int getIdrepartidor() {
		return idrepartidor;
	}

	public void setIdrepartidor(int idrepartidor) {
		this.idrepartidor = idrepartidor;
	}

	public float getMontoabonado() {
		return montoabonado;
	}

	public void setMontoabonado(float montoabonado) {
		this.montoabonado = montoabonado;
	}
	
	

}
