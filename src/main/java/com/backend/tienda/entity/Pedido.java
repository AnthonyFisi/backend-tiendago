package com.backend.tienda.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pedido {

	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpedido", updatable = false, nullable = false)
	private int idpedido;
	
	private String pedido_estado;
	private float pedido_montototal;
	private int  pedido_cantidadtotal;
	private Date pedido_fecha_registro;
	private int ubicacion_idubicacion;
	private int usuario_idusuario;
	private String pedido_estadopago;
	private int tipopago_idtipopago;
	private int horario_idhorario;
	
	
	
	public Pedido() {};
	
	
	
	
	public Pedido(String pedido_estado, float pedido_montototal, int pedido_cantidadtotal,
			Date pedido_fecha_registro, int ubicacion_idubicacion, int usuario_idusuario, String pedido_estadopago,
			int tipopago_idtipopago, int horario_idhorario) {
		this.pedido_estado = pedido_estado;
		this.pedido_montototal = pedido_montototal;
		this.pedido_cantidadtotal = pedido_cantidadtotal;
		this.pedido_fecha_registro = pedido_fecha_registro;
		this.ubicacion_idubicacion = ubicacion_idubicacion;
		this.usuario_idusuario = usuario_idusuario;
		this.pedido_estadopago = pedido_estadopago;
		this.tipopago_idtipopago = tipopago_idtipopago;
		this.horario_idhorario = horario_idhorario;
	}
	public int getUsuario_idusuario() {
		return usuario_idusuario;
	}
	public void setUsuario_idusuario(int usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}
	
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public String getPedido_estado() {
		return pedido_estado;
	}
	public void setPedido_estado(String pedido_estado) {
		this.pedido_estado = pedido_estado;
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
	public Date getPedido_fecha_registro() {
		return pedido_fecha_registro;
	}
	public void setPedido_fecha_registro(Date pedido_fecha_registro) {
		this.pedido_fecha_registro = pedido_fecha_registro;
	}
	public int getUbicacion_idubicacion() {
		return ubicacion_idubicacion;
	}
	public void setUbicacion_idubicacion(int ubicacion_idubicacion) {
		this.ubicacion_idubicacion = ubicacion_idubicacion;
	}
	public String getPedido_estadopago() {
		return pedido_estadopago;
	}
	public void setPedido_estadopago(String pedido_estadopago) {
		this.pedido_estadopago = pedido_estadopago;
	}
	public int getTipopago_idtipopago() {
		return tipopago_idtipopago;
	}
	public void setTipopago_idtipopago(int tipopago_idtipopago) {
		this.tipopago_idtipopago = tipopago_idtipopago;
	}
	public int getHorario_idhorario() {
		return horario_idhorario;
	}
	public void setHorario_idhorario(int horario_idhorario) {
		this.horario_idhorario = horario_idhorario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	


}
