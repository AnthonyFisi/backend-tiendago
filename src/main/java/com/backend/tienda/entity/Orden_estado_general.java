package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="orden_estado_general")
public class Orden_estado_general {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idoeg", updatable = false, nullable = false)
	private int idoeg;
	
	private int idventa;
	
	private int idestadogeneral;
	
	private String tiempo_aproximado;
	
	private Timestamp fecha;
	
	private int idusuario;

	public int getIdoeg() {
		return idoeg;
	}

	public void setIdoeg(int idoeg) {
		this.idoeg = idoeg;
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public int getIdestadogeneral() {
		return idestadogeneral;
	}

	public void setIdestadogeneral(int idestadogeneral) {
		this.idestadogeneral = idestadogeneral;
	}

	
	public String getTiempo_aproximado() {
		return tiempo_aproximado;
	}

	public void setTiempo_aproximado(String tiempo_aproximado) {
		this.tiempo_aproximado = tiempo_aproximado;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	
	
	
}
