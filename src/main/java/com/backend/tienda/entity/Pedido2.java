package com.backend.tienda.entity;


import java.io.Serializable;
import java.sql.Date;

public class Pedido2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idpedido;
	private String pedido_estado;
	private float pedido_montototal;
	private int  pedido_cantidadtotal;
	private int ubicacion_idubicacion;
	private int usuario_idusuario;
	private String pedido_estadopago;
	private int tipopago_idtipopago;
	private int horario_idhorario;
	
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
	public int getUbicacion_idubicacion() {
		return ubicacion_idubicacion;
	}
	public void setUbicacion_idubicacion(int ubicacion_idubicacion) {
		this.ubicacion_idubicacion = ubicacion_idubicacion;
	}
	public int getUsuario_idusuario() {
		return usuario_idusuario;
	}
	public void setUsuario_idusuario(int usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
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
	
	


}
