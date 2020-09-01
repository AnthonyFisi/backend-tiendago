package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="envio_empresa")
public class Envio_empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtee", updatable = false, nullable = false)
	private int idtee;
	
	private int idempresa;
	
	private int idtipoenvio;
	
	private String nombre_tipo_envio;

	private String url_foto;
	
	
	public int getIdtee() {
		return idtee;
	}

	public void setIdtee(int idtee) {
		this.idtee = idtee;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}



	public String getNombre_tipo_envio() {
		return nombre_tipo_envio;
	}

	public void setNombre_tipo_envio(String nombre_tipo_envio) {
		this.nombre_tipo_envio = nombre_tipo_envio;
	}

	public int getIdtipoenvio() {
		return idtipoenvio;
	}

	public void setIdtipoenvio(int idtipoenvio) {
		this.idtipoenvio = idtipoenvio;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}
	
	
	

}
