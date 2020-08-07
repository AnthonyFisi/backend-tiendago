package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cuenta_usuario")
public class Cuenta_Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcuentausuario", updatable = false, nullable = false)
	private int idcuentausuario;
	
	private boolean activa;
	
	private Timestamp fecharegistro;
	
	private int idtipocuenta;
	
	private int idusuario;

	public int getIdcuentausuario() {
		return idcuentausuario;
	}

	public void setIdcuentausuario(int idcuentausuario) {
		this.idcuentausuario = idcuentausuario;
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

	public int getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(int idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	
	

}
