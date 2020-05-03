package com.backend.tienda.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venta implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idventa", updatable = false, nullable = false)
	private int idventa;
	private Timestamp  Venta_fecha  ;
	private String  Venta_estadoPago;
	private Timestamp  Venta_fechaEntrega ;
	private float  Venta_costodelivery ; 
	private float  Venta_costoTotal ;
	private int  idPedido  ;
	private int  idtipopago ; 
	private int  idubicacion ; 
	private int  idhorario  ;
	private String comentario;
	

	
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getIdventa() {
		return idventa;
	}
	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}
	
	public Timestamp getVenta_fecha() {
		return Venta_fecha;
	}
	public void setVenta_fecha(Timestamp venta_fecha) {
		Venta_fecha = venta_fecha;
	}
	public Timestamp getVenta_fechaEntrega() {
		return Venta_fechaEntrega;
	}
	public void setVenta_fechaEntrega(Timestamp venta_fechaEntrega) {
		Venta_fechaEntrega = venta_fechaEntrega;
	}
	public String getVenta_estadoPago() {
		return Venta_estadoPago;
	}
	public void setVenta_estadoPago(String venta_estadoPago) {
		Venta_estadoPago = venta_estadoPago;
	}
	public float getVenta_costodelivery() {
		return Venta_costodelivery;
	}
	public void setVenta_costodelivery(float venta_costodelivery) {
		Venta_costodelivery = venta_costodelivery;
	}
	public float getVenta_costoTotal() {
		return Venta_costoTotal;
	}
	public void setVenta_costoTotal(float venta_costoTotal) {
		Venta_costoTotal = venta_costoTotal;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdtipopago() {
		return idtipopago;
	}
	public void setIdtipopago(int idtipopago) {
		this.idtipopago = idtipopago;
	}
	public int getIdubicacion() {
		return idubicacion;
	}
	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}
	public int getIdhorario() {
		return idhorario;
	}
	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
