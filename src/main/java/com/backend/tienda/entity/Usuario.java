package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario", updatable = false, nullable = false)
	private int idusuario;
	
	private int idusuariogeneral;

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdusuariogeneral() {
		return idusuariogeneral;
	}

	public void setIdusuariogeneral(int idusuariogeneral) {
		this.idusuariogeneral = idusuariogeneral;
	}
	
	

}
