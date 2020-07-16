package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="delivery_pedido")
@Entity
public class Delivery_Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idventa", updatable = false, nullable = false)
	private int idventa;
	
	private int idtipopago;
	
	private String tipopago_nombre;
	
	private String ubicacion_nombre;
	
	private String ubicacion_comentarios;
	
	private String usuario_coordenada_x;
	
	private String usuario_coordenada_y;
	
	private int idpedido;
	
	
	private float venta_costodelivery;
	
    private String distancia_delivery;

    private String tiempo;
    
	private float venta_costototal;
	
	private boolean cancelar;
	
	private String comentario_global;
	
	private float costo_delivery;
	
	private boolean orden_disponible;
	
	private int idrepartidor;
	
	private int idestado_pago;
	
	private String nombre_estadopago;
	
	private int idusuario;
	
	private String usuario_nombre;
	
	private String usuario_celular;
	
	private int idempresa;
	
	private String nombre_empresa;
	
	private String direccion_empresa;
	
	private String empresa_coordenada_x;
	
	private String empresa_coordenada_y;

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

	public String getTipopago_nombre() {
		return tipopago_nombre;
	}

	public void setTipopago_nombre(String tipopago_nombre) {
		this.tipopago_nombre = tipopago_nombre;
	}

	public String getUbicacion_nombre() {
		return ubicacion_nombre;
	}

	public void setUbicacion_nombre(String ubicacion_nombre) {
		this.ubicacion_nombre = ubicacion_nombre;
	}

	public String getUbicacion_comentarios() {
		return ubicacion_comentarios;
	}

	public void setUbicacion_comentarios(String ubicacion_comentarios) {
		this.ubicacion_comentarios = ubicacion_comentarios;
	}

	public String getUsuario_coordenada_x() {
		return usuario_coordenada_x;
	}

	public void setUsuario_coordenada_x(String usuario_coordenada_x) {
		this.usuario_coordenada_x = usuario_coordenada_x;
	}

	public String getUsuario_coordenada_y() {
		return usuario_coordenada_y;
	}

	public void setUsuario_coordenada_y(String usuario_coordenada_y) {
		this.usuario_coordenada_y = usuario_coordenada_y;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
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

	public boolean isCancelar() {
		return cancelar;
	}

	public void setCancelar(boolean cancelar) {
		this.cancelar = cancelar;
	}

	public String getComentario_global() {
		return comentario_global;
	}

	public void setComentario_global(String comentario_global) {
		this.comentario_global = comentario_global;
	}

	public float getCosto_delivery() {
		return costo_delivery;
	}

	public void setCosto_delivery(float costo_delivery) {
		this.costo_delivery = costo_delivery;
	}
	
	

	public String getDistancia_delivery() {
		return distancia_delivery;
	}

	public void setDistancia_delivery(String distancia_delivery) {
		this.distancia_delivery = distancia_delivery;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public boolean isOrden_disponible() {
		return orden_disponible;
	}

	public void setOrden_disponible(boolean orden_disponible) {
		this.orden_disponible = orden_disponible;
	}

	public int getIdestado_pago() {
		return idestado_pago;
	}

	public void setIdestado_pago(int idestado_pago) {
		this.idestado_pago = idestado_pago;
	}

	public String getNombre_estadopago() {
		return nombre_estadopago;
	}

	public void setNombre_estadopago(String nombre_estadopago) {
		this.nombre_estadopago = nombre_estadopago;
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

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getDireccion_empresa() {
		return direccion_empresa;
	}

	public void setDireccion_empresa(String direccion_empresa) {
		this.direccion_empresa = direccion_empresa;
	}

	public String getEmpresa_coordenada_x() {
		return empresa_coordenada_x;
	}

	public void setEmpresa_coordenada_x(String empresa_coordenada_x) {
		this.empresa_coordenada_x = empresa_coordenada_x;
	}

	public String getEmpresa_coordenada_y() {
		return empresa_coordenada_y;
	}

	public void setEmpresa_coordenada_y(String empresa_coordenada_y) {
		this.empresa_coordenada_y = empresa_coordenada_y;
	}

	public int getIdrepartidor() {
		return idrepartidor;
	}

	public void setIdrepartidor(int idrepartidor) {
		this.idrepartidor = idrepartidor;
	}
	
	
	

}
