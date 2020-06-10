package com.backend.tienda.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="registropedido")
public class RegistroPedido {
	
	
	@EmbeddedId
	RegistroPedidoPK id;
	
	private int registropedido_cantidadtotal;
	
	private float registropedido_preciototal;
	
	private Timestamp registro_fecha;
	
	private int idempresa;
	
	private String comentario;
	
	public RegistroPedido() {}
	

	public RegistroPedido(RegistroPedidoPK id, int registropedido_cantidadtotal, float registropedido_preciototal,
			Timestamp registro_fecha, int idempresa,String comentario) {
		super();
		this.id = id;
		this.registropedido_cantidadtotal = registropedido_cantidadtotal;
		this.registropedido_preciototal = registropedido_preciototal;
		this.registro_fecha = registro_fecha;
		this.idempresa = idempresa;
		this.comentario=comentario;
	}

	public RegistroPedidoPK getId() {
		return id;
	}

	public void setId(RegistroPedidoPK id) {
		this.id = id;
	}

	public int getRegistropedido_cantidadtotal() {
		return registropedido_cantidadtotal;
	}

	public void setRegistropedido_cantidadtotal(int registropedido_cantidadtotal) {
		this.registropedido_cantidadtotal = registropedido_cantidadtotal;
	}

	public float getRegistropedido_preciototal() {
		return registropedido_preciototal;
	}

	public void setRegistropedido_preciototal(float registropedido_preciototal) {
		this.registropedido_preciototal = registropedido_preciototal;
	}

	public Timestamp getRegistro_fecha() {
		return registro_fecha;
	}

	public void setRegistro_fecha(Timestamp registro_fecha) {
		this.registro_fecha = registro_fecha;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
	
	
	

}
