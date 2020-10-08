package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="repartidor_historial")
public class Repartidor_historial {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idventa", updatable = false, nullable = false)
	private int idventa;

	private int idtipopago;
	
	private String tipopago_nombre;
	
	private int idubicacion;
	
	private int idpedido;
	
	private int idempresa;
	
	private int pedido_cantidadtotal;

	private int idusuario;
	
	private int idusuariogeneral;
	
	private float venta_costodelivery;
	
	private float venta_costototal;
	
	private int idestado_pago;
	
	private String nombre_estadopago;
	
	private boolean ordendisponible;

	private String tiempo_espera;
	
	private int idrepartidor;

	private boolean cancelar;

	private String comentario_cancelar;
			
	private String distancia_delivery;
	
	private String tiempo_aprox_delivery;
	
	private Timestamp fechahistorial;
	
	private int  idestadodelivery;
	
	private String venta_distancia_delivery_total;
	
	private float ganancia_delivery;
	
	public boolean isCancelar() {
		return cancelar;
	}

	public void setCancelar(boolean cancelar) {
		this.cancelar = cancelar;
	}

	
	public int getPedido_cantidadtotal() {
		return pedido_cantidadtotal;
	}

	public void setPedido_cantidadtotal(int pedido_cantidadtotal) {
		this.pedido_cantidadtotal = pedido_cantidadtotal;
	}

	public String getTiempo_espera() {
		return tiempo_espera;
	}

	public void setTiempo_espera(String tiempo_espera) {
		this.tiempo_espera = tiempo_espera;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public int getIdubicacion() {
		return idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
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

	public int getIdestado_pago() {
		return idestado_pago;
	}

	public void setIdestado_pago(int idestado_pago) {
		this.idestado_pago = idestado_pago;
	}



	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}



	public int getIdrepartidor() {
		return idrepartidor;
	}

	public void setIdrepartidor(int idrepartidor) {
		this.idrepartidor = idrepartidor;
	}

	public int getIdtipopago() {
		return idtipopago;
	}

	public void setIdtipopago(int idtipopago) {
		this.idtipopago = idtipopago;
	}

	public String getTipopago_nombre() {
		return tipopago_nombre;
	}

	public void setTipopago_nombre(String tipopago_nombre) {
		this.tipopago_nombre = tipopago_nombre;
	}




	public int getIdestadodelivery() {
		return idestadodelivery;
	}

	public void setIdestadodelivery(int idestadodelivery) {
		this.idestadodelivery = idestadodelivery;
	}


	public int getIdusuariogeneral() {
		return idusuariogeneral;
	}

	public void setIdusuariogeneral(int idusuariogeneral) {
		this.idusuariogeneral = idusuariogeneral;
	}

	
	public boolean isOrdendisponible() {
		return ordendisponible;
	}

	public void setOrdendisponible(boolean ordendisponible) {
		this.ordendisponible = ordendisponible;
	}


	public String getNombre_estadopago() {
		return nombre_estadopago;
	}

	public void setNombre_estadopago(String nombre_estadopago) {
		this.nombre_estadopago = nombre_estadopago;
	}

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

	public String getTiempo_aprox_delivery() {
		return tiempo_aprox_delivery;
	}

	public void setTiempo_aprox_delivery(String tiempo_aprox_delivery) {
		this.tiempo_aprox_delivery = tiempo_aprox_delivery;
	}


	public Timestamp getFechahistorial() {
		return fechahistorial;
	}

	public void setFechahistorial(Timestamp fechahistorial) {
		this.fechahistorial = fechahistorial;
	}

	public String getVenta_distancia_delivery_total() {
		return venta_distancia_delivery_total;
	}

	public void setVenta_distancia_delivery_total(String venta_distancia_delivery_total) {
		this.venta_distancia_delivery_total = venta_distancia_delivery_total;
	}

	public float getGanancia_delivery() {
		return ganancia_delivery;
	}

	public void setGanancia_delivery(float ganancia_delivery) {
		this.ganancia_delivery = ganancia_delivery;
	}
	
	

}
