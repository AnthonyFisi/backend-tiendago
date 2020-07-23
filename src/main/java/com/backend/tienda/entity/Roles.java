package com.backend.tienda.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.backend.tienda.models.ERole;

@Entity
@Table(name = "roles")
public class Roles {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idrole;

	@Enumerated(EnumType.STRING)
	private ERole nombre;
	
	

	public Roles() {

	}

	public Roles(ERole nombre) {
		this.nombre=nombre;
	}


	public Integer getIdrole() {
		return idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
	}

	public ERole getNombre() {
		return nombre;
	}

	public void setNombre(ERole nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
