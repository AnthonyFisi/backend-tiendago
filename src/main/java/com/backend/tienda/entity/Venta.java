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
	
	private int idestado_empresa;
	
	private int idestado_pago;
	
	private int idtipo_envio;
	
	private String comentario_entrega;
	
	private String distancia_delivery;
	
	private float costo_delivery;
	
	private boolean orden_disponible;
	
	private String tiempo_espera;
	
	private String tiempo_aprox_delivery;
	
	private int  idrepartidor;
	
	private boolean cancelar;
	
	private String comentario_cancelar;
	
	private int idestado_delivery;
	
	private int idestado_general;
	
	private int numeromesa;

	private boolean mesa;
	
	private float descuento_mesa;
	
	private float venta_costopedido;
	
	private String venta_distancia_delivery_total;
	
	private float venta_ganancia_delivery;
	
	private float ganancia_yegoo;
	

	
	public String getComentario_cancelar() {
		return comentario_cancelar;
	}

	public void setComentario_cancelar(String comentario_cancelar) {
		this.comentario_cancelar = comentario_cancelar;
	}


	
	
	public String getDistancia_delivery() {
		return distancia_delivery;
	}

	public void setDistancia_delivery(String distancia_delivery) {
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

	

	public int getIdestado_empresa() {
		return idestado_empresa;
	}

	public void setIdestado_empresa(int idestado_empresa) {
		this.idestado_empresa = idestado_empresa;
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
	public boolean isCancelar() {
		return cancelar;
	}
	public void setCancelar(boolean cancelar) {
		this.cancelar = cancelar;
	}


	public int getIdestado_delivery() {
		return idestado_delivery;
	}


	public void setIdestado_delivery(int idestado_delivery) {
		this.idestado_delivery = idestado_delivery;
	}

	public int getIdestado_general() {
		return idestado_general;
	}

	public void setIdestado_general(int idestado_general) {
		this.idestado_general = idestado_general;
	}

	public String getTiempo_aprox_delivery() {
		return tiempo_aprox_delivery;
	}

	public void setTiempo_aprox_delivery(String tiempo_aprox_delivery) {
		this.tiempo_aprox_delivery = tiempo_aprox_delivery;
	}

	public int getNumeromesa() {
		return numeromesa;
	}

	public void setNumeromesa(int numeromesa) {
		this.numeromesa = numeromesa;
	}

	public boolean isMesa() {
		return mesa;
	}

	public void setMesa(boolean mesa) {
		this.mesa = mesa;
	}

	public float getDescuento_mesa() {
		return descuento_mesa;
	}

	public void setDescuento_mesa(float descuento_mesa) {
		this.descuento_mesa = descuento_mesa;
	}

	public float getVenta_costopedido() {
		return venta_costopedido;
	}

	public void setVenta_costopedido(float venta_costopedido) {
		this.venta_costopedido = venta_costopedido;
	}

	public String getVenta_distancia_delivery_total() {
		return venta_distancia_delivery_total;
	}

	public void setVenta_distancia_delivery_total(String venta_distancia_delivery_total) {
		this.venta_distancia_delivery_total = venta_distancia_delivery_total;
	}

	public float getVenta_ganancia_delivery() {
		return venta_ganancia_delivery;
	}

	public void setVenta_ganancia_delivery(float venta_ganancia_delivery) {
		this.venta_ganancia_delivery = venta_ganancia_delivery;
	}

	public float getGanancia_yegoo() {
		return ganancia_yegoo;
	}

	public void setGanancia_yegoo(float ganancia_yegoo) {
		this.ganancia_yegoo = ganancia_yegoo;
	}

	
	
	

	

}



