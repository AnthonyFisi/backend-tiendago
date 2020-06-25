package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idventa", updatable = false, nullable = false)
	private int idventa;
	
	private int idtipopago;
	
	private int idhorario;
	
	private int idubicacion;
	
	private int idpedido;
	
	private Timestamp venta_fecha;
	
	private Timestamp venta_fechaentrega;
	
	private float venta_costodelivery;
	
	private float venta_costototal;
	
	private String comentario;
	
	private int idestado_venta;
	
	private int idestado_pago;
	
	private int idtipo_envio;
	
	private String comentario_entrega;
	
	private float distancia_delivery;
	
	private float costo_delivery;
	
	private boolean orden_disponible;
	
	private String tiempo_espera;
	
	private int  idrepartidor;
	


	
	public Venta(int idventa, int idtipopago, int idhorario, int idubicacion, int idpedido, Timestamp venta_fecha,
			Timestamp venta_fechaentrega, float venta_costodelivery, float venta_costototal, String comentario,
			int idestado_venta, int idestado_pago, int idtipo_envio, String comentario_entrega,
			float distancia_delivery, float costo_delivery, boolean orden_disponible, String tiempo_espera,
			int idrepartidor) {
		super();
		this.idventa = idventa;
		this.idtipopago = idtipopago;
		this.idhorario = idhorario;
		this.idubicacion = idubicacion;
		this.idpedido = idpedido;
		this.venta_fecha = venta_fecha;
		this.venta_fechaentrega = venta_fechaentrega;
		this.venta_costodelivery = venta_costodelivery;
		this.venta_costototal = venta_costototal;
		this.comentario = comentario;
		this.idestado_venta = idestado_venta;
		this.idestado_pago = idestado_pago;
		this.idtipo_envio = idtipo_envio;
		this.comentario_entrega = comentario_entrega;
		this.distancia_delivery = distancia_delivery;
		this.costo_delivery = costo_delivery;
		this.orden_disponible = orden_disponible;
		this.tiempo_espera = tiempo_espera;
		this.idrepartidor = idrepartidor;
	}
	public float getDistancia_delivery() {
		return distancia_delivery;
	}
	public void setDistancia_delivery(float distancia_delivery) {
		this.distancia_delivery = distancia_delivery;
	}
	public float getCosto_delivery() {
		return costo_delivery;
	}
	public void setCosto_delivery(float costo_delivery) {
		this.costo_delivery = costo_delivery;
	}
	public boolean isOrden_disponible() {
		return orden_disponible;
	}
	public void setOrden_disponible(boolean orden_disponible) {
		this.orden_disponible = orden_disponible;
	}
	public String getTiempo_espera() {
		return tiempo_espera;
	}
	public void setTiempo_espera(String tiempo_espera) {
		this.tiempo_espera = tiempo_espera;
	}
	public int getIdrepartidor() {
		return idrepartidor;
	}
	public void setIdrepartidor(int idrepartidor) {
		this.idrepartidor = idrepartidor;
	}
	public Venta() {}
	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
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

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public Timestamp getVenta_fecha() {
		return venta_fecha;
	}

	public void setVenta_fecha(Timestamp venta_fecha) {
		this.venta_fecha = venta_fecha;
	}

	public Timestamp getVenta_fechaentrega() {
		return venta_fechaentrega;
	}

	public void setVenta_fechaentrega(Timestamp venta_fechaentrega) {
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

	public int getIdestado_venta() {
		return idestado_venta;
	}

	public void setIdestado_venta(int idestado_venta) {
		this.idestado_venta = idestado_venta;
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


	public String getComentario_entrega() {
		return comentario_entrega;
	}


	public void setComentario_entrega(String comentario_entrega) {
		this.comentario_entrega = comentario_entrega;
	}
	
	
	
	
	
	
	

}



