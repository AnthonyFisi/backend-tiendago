package com.backend.tienda.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="repartidor")
public class Repartidor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrepartidor", updatable = false, nullable = false)
	private int idrepartidor;
	
	private String placa_vehiculo;
	
	private String imagen_vehiculo;
	
	private String tipo_brevete;
	
	private String detalles;
		
	private boolean disponible ;
	
	private int idusuariogeneral;
	

	public int getIdrepartidor() {
		return idrepartidor;
	}

	public void setIdrepartidor(int idrepartidor) {
		this.idrepartidor = idrepartidor;
	}

	public String getPlaca_vehiculo() {
		return placa_vehiculo;
	}

	public void setPlaca_vehiculo(String placa_vehiculo) {
		this.placa_vehiculo = placa_vehiculo;
	}

	public String getImagen_vehiculo() {
		return imagen_vehiculo;
	}

	public void setImagen_vehiculo(String imagen_vehiculo) {
		this.imagen_vehiculo = imagen_vehiculo;
	}

	public String getTipo_brevete() {
		return tipo_brevete;
	}

	public void setTipo_brevete(String tipo_brevete) {
		this.tipo_brevete = tipo_brevete;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getIdusuariogeneral() {
		return idusuariogeneral;
	}

	public void setIdusuariogeneral(int idusuariogeneral) {
		this.idusuariogeneral = idusuariogeneral;
	}

	
	

}
