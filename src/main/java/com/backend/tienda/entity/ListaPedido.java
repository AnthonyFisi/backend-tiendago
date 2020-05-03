package com.backend.tienda.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ListaPedido  implements Serializable{
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	private int idpedido;
    private String venta_estadopago;
	private String venta_fechaentrega;
	private String venta_costodelivery;
	private float venta_costototal;
	private String tipopago_nombre;
	private String ubicacion_nombre;
	private String horario_nombre;

	

	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public String getUbicacion_nombre() {
		return ubicacion_nombre;
	}
	public void setUbicacion_nombre(String ubicacion_nombre) {
		this.ubicacion_nombre = ubicacion_nombre;
	}
	public String getHorario_nombre() {
		return horario_nombre;
	}
	public void setHorario_nombre(String horario_nombre) {
		this.horario_nombre = horario_nombre;
	}
	public String getVenta_estadopago() {
		return venta_estadopago;
	}
	public void setVenta_estadopago(String venta_estadopago) {
		this.venta_estadopago = venta_estadopago;
	}

	public String getVenta_costodelivery() {
		return venta_costodelivery;
	}
	public void setVenta_costodelivery(String venta_costodelivery) {
		this.venta_costodelivery = venta_costodelivery;
	}
	public float getVenta_costototal() {
		return venta_costototal;
	}
	public void setVenta_costototal(float venta_costototal) {
		this.venta_costototal = venta_costototal;
	}
	public String getTipopago_nombre() {
		return tipopago_nombre;
	}
	public void setTipopago_nombre(String tipopago_nombre) {
		this.tipopago_nombre = tipopago_nombre;
	}
	public String getVenta_fechaentrega() {
		return venta_fechaentrega;
	}
	public void setVenta_fechaentrega(String venta_fechaentrega) {
		this.venta_fechaentrega = venta_fechaentrega;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
