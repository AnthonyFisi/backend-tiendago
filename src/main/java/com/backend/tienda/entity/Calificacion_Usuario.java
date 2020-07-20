package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calificacion_usuario")
public class Calificacion_Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcalificacion_usuario", updatable = false, nullable = false)
	private int idcalificacion_usuario;
	
	private int idcliente;
	
	private int idventa;
	
	private int idtipo_usuario;
	
	private int idusuario;
	
	private float calificacion;

	
	
	public int getIdcalificacion_usuario() {
		return idcalificacion_usuario;
	}

	public void setIdcalificacion_usuario(int idcalificacion_usuario) {
		this.idcalificacion_usuario = idcalificacion_usuario;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public int getIdtipo_usuario() {
		return idtipo_usuario;
	}

	public void setIdtipo_usuario(int idtipo_usuario) {
		this.idtipo_usuario = idtipo_usuario;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	
	

}
