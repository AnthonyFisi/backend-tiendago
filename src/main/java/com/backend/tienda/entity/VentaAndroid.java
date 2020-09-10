package com.backend.tienda.entity;

import java.util.List;

public class VentaAndroid {

	
	private int idEmpresa;
	
	private int idtipopago;
	
	private int idhorario;
	
	private int idubicacion;
	
	//private int idpedido;
	
	//private String venta_fecha;
	
	private String venta_fechaentrega;
	
	private float venta_costodelivery;
	
	private float venta_costototal;
	
	private String comentario;
	
	//private int idestado_venta;
	
	private int idestado_pago;
	
	private int idtipo_envio;
	
	private int idUsuario;

	private boolean repsuesta_registro_venta;	
	
	private int numeromesa;

	private float descuento_mesa;
	
	private boolean mesa;
	
	private float venta_costopedido;

	private List<Double> empresa_posistion;
	
	private List<Double> usuario_position;
	

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdtipopago() {
		return idtipopago;
	}

	public void setIdtipopago(int idtipopago) {
		this.idtipopago = idtipopago;
	}

	public int getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}

	public int getIdubicacion() {
		return idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}


	public String getVenta_fechaentrega() {
		return venta_fechaentrega;
	}

	public void setVenta_fechaentrega(String venta_fechaentrega) {
		this.venta_fechaentrega = venta_fechaentrega;
	}

	public float getVenta_costodelivery() {
		return venta_costodelivery;
	}

	public void setVenta_costodelivery(float venta_costodelivery) {
		this.venta_costodelivery = venta_costodelivery;
	}

	public float getVenta_costototal() {
		return venta_costototal;
	}

	public void setVenta_costototal(float venta_costototal) {
		this.venta_costototal = venta_costototal;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	

	public int getIdestado_pago() {
		return idestado_pago;
	}

	public void setIdestado_pago(int idestado_pago) {
		this.idestado_pago = idestado_pago;
	}

	public int getIdtipo_envio() {
		return idtipo_envio;
	}

	public void setIdtipo_envio(int idtipo_envio) {
		this.idtipo_envio = idtipo_envio;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	public boolean isRepsuesta_registro_venta() {
		return repsuesta_registro_venta;
	}

	public void setRepsuesta_registro_venta(boolean repsuesta_registro_venta) {
		this.repsuesta_registro_venta = repsuesta_registro_venta;
	}

	public int getNumeromesa() {
		return numeromesa;
	}

	public void setNumeromesa(int numeromesa) {
		this.numeromesa = numeromesa;
	}

	
	public float getDescuento_mesa() {
		return descuento_mesa;
	}

	public void setDescuento_mesa(float descuento_mesa) {
		this.descuento_mesa = descuento_mesa;
	}

	public boolean isMesa() {
		return mesa;
	}

	public void setMesa(boolean mesa) {
		this.mesa = mesa;
	}

	public float getVenta_costopedido() {
		return venta_costopedido;
	}

	public void setVenta_costopedido(float venta_costopedido) {
		this.venta_costopedido = venta_costopedido;
	}

	public List<Double> getEmpresa_posistion() {
		return empresa_posistion;
	}

	public void setEmpresa_posistion(List<Double> empresa_posistion) {
		this.empresa_posistion = empresa_posistion;
	}

	public List<Double> getUsuario_position() {
		return usuario_position;
	}

	public void setUsuario_position(List<Double> usuario_position) {
		this.usuario_position = usuario_position;
	}

	

	
	
	
}
