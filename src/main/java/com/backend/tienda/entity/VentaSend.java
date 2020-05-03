package com.backend.tienda.entity;

public class VentaSend {

	private String  Venta_fecha  ;
	private String  Venta_estadoPago;
	private String  Venta_fechaEntrega ;
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
	
	
	public String getVenta_fecha() {
		return Venta_fecha;
	}
	public void setVenta_fecha(String venta_fecha) {
		Venta_fecha = venta_fecha;
	}
	public String getVenta_fechaEntrega() {
		return Venta_fechaEntrega;
	}
	public void setVenta_fechaEntrega(String venta_fechaEntrega) {
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

	
	
	
	
}
