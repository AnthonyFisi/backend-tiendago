package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pedido")
public class Pedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpedido", updatable = false, nullable = false)
	private int idpedido;
	
	private float pedido_montototal;
	
	private int pedido_cantidadtotal;
	
	private Timestamp pedido_fecha_registro;
	
	private boolean pedido_estado;
	
	private int idusuario;
	
	private int idempresa;
	
	
	public Pedido() {}

	public Pedido(int idpedido, float pedido_montototal, int pedido_cantidadtotal, Timestamp pedido_fecha_registro,
			boolean pedido_estado, int idusuario,int idempresa) {
		this.idpedido = idpedido;
		this.pedido_montototal = pedido_montototal;
		this.pedido_cantidadtotal = pedido_cantidadtotal;
		this.pedido_fecha_registro = pedido_fecha_registro;
		this.pedido_estado = pedido_estado;
		this.idusuario = idusuario;
		this.idempresa=idempresa;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public float getPedido_montototal() {
		return pedido_montototal;
	}

	public void setPedido_montototal(float pedido_montototal) {
		this.pedido_montototal = pedido_montototal;
	}

	public int getPedido_cantidadtotal() {
		return pedido_cantidadtotal;
	}

	public void setPedido_cantidadtotal(int pedido_cantidadtotal) {
		this.pedido_cantidadtotal = pedido_cantidadtotal;
	}

	public Timestamp getPedido_fecha_registro() {
		return pedido_fecha_registro;
	}

	public void setPedido_fecha_registro(Timestamp pedido_fecha_registro) {
		this.pedido_fecha_registro = pedido_fecha_registro;
	}

	public boolean isPedido_estado() {
		return pedido_estado;
	}

	public void setPedido_estado(boolean pedido_estado) {
		this.pedido_estado = pedido_estado;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	
	
	
	
	
	
}
