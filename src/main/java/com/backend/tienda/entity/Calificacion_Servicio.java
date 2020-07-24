package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calificacion_servicio")
public class Calificacion_Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcalificacion_servicio", updatable = false, nullable = false)
	private int idcalificacion_servicio;
	
	private int idventa;
	
	
	private int idusuario;
	
	private float calificacion;

	
	
	public int getIdcalificacion_servicio() {
		return idcalificacion_servicio;
	}

	public void setIdcalificacion_servicio(int idcalificacion_servicio) {
		this.idcalificacion_servicio = idcalificacion_servicio;
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
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
