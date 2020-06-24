package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurante_pedido")
public class Restaurante_Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpedido", updatable = false, nullable = false)
	private int idpedido;
	
	private int idempresa;
	
	private int idventa;
	
	private int idubicacion;
	
	private Timestamp venta_fecha;
	
	private Timestamp venta_fechaentrega;
	
	private float venta_costodelivery;
	
	private float venta_costototal;
	
	private String comentario_global;
	
	private int idestado_pago;
	
	private String nombre_estado;

	private String producto_nombre;
	
	private float producto_precio;
	
	private String producto_uriimagen;
	
	private String comentario_pedido;
	
	private int idusuario;
	
	private String usuario_nombre;
	
	private String usuario_celular;
	
	private boolean orden_disponible;
	
	private int idrepartidor;
	
	private int idtipopago;
	
	private String tipopago_nombre;
	
	private int idestado_venta;
	
	private String tipo_estado;
	
	private int idtipo_envio;
	
	private String nombre_tipo_envio;

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

	public String getComentario_global() {
		return comentario_global;
	}

	public void setComentario_global(String comentario_global) {
		this.comentario_global = comentario_global;
	}

	public int getIdestado_pago() {
		return idestado_pago;
	}

	public void setIdestado_pago(int idestado_pago) {
		this.idestado_pago = idestado_pago;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

	public String getProducto_nombre() {
		return producto_nombre;
	}

	public void setProducto_nombre(String producto_nombre) {
		this.producto_nombre = producto_nombre;
	}

	public float getProducto_precio() {
		return producto_precio;
	}

	public void setProducto_precio(float producto_precio) {
		this.producto_precio = producto_precio;
	}

	public String getProducto_uriimagen() {
		return producto_uriimagen;
	}

	public void setProducto_uriimagen(String producto_uriimagen) {
		this.producto_uriimagen = producto_uriimagen;
	}

	public String getComentario_pedido() {
		return comentario_pedido;
	}

	public void setComentario_pedido(String comentario_pedido) {
		this.comentario_pedido = comentario_pedido;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsuario_nombre() {
		return usuario_nombre;
	}

	public void setUsuario_nombre(String usuario_nombre) {
		this.usuario_nombre = usuario_nombre;
	}

	public String getUsuario_celular() {
		return usuario_celular;
	}

	public void setUsuario_celular(String usuario_celular) {
		this.usuario_celular = usuario_celular;
	}

	public boolean isOrden_disponible() {
		return orden_disponible;
	}

	public void setOrden_disponible(boolean orden_disponible) {
		this.orden_disponible = orden_disponible;
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

	public int getIdestado_venta() {
		return idestado_venta;
	}

	public void setIdestado_venta(int idestado_venta) {
		this.idestado_venta = idestado_venta;
	}

	public String getTipo_estado() {
		return tipo_estado;
	}

	public void setTipo_estado(String tipo_estado) {
		this.tipo_estado = tipo_estado;
	}

	public int getIdtipo_envio() {
		return idtipo_envio;
	}

	public void setIdtipo_envio(int idtipo_envio) {
		this.idtipo_envio = idtipo_envio;
	}

	public String getNombre_tipo_envio() {
		return nombre_tipo_envio;
	}

	public void setNombre_tipo_envio(String nombre_tipo_envio) {
		this.nombre_tipo_envio = nombre_tipo_envio;
	}
	
	
	
}