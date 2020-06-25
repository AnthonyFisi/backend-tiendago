package com.backend.tienda.entity;

import java.sql.Timestamp;
import java.util.List;

public class Restaurante_PedidoModified {
	
	private int idpedido;

	private int idempresa;

	private int idventa;

	private int idubicacion;

	private Timestamp venta_fecha;

	private float venta_costototal;

	private int idusuario;

	private String usuario_nombre;

	private int idestado_venta;
	
	private String tiempo_espera;
	
	List<Restaurante_Pedido> listaProductos;
	

	
	public List<Restaurante_Pedido> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Restaurante_Pedido> listaProductos) {
		this.listaProductos = listaProductos;
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

	public Timestamp getVenta_fecha() {
		return venta_fecha;
	}

	public void setVenta_fecha(Timestamp venta_fecha) {
		this.venta_fecha = venta_fecha;
	}

	public float getVenta_costototal() {
		return venta_costototal;
	}

	public void setVenta_costototal(float venta_costototal) {
		this.venta_costototal = venta_costototal;
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

	public int getIdestado_venta() {
		return idestado_venta;
	}

	public void setIdestado_venta(int idestado_venta) {
		this.idestado_venta = idestado_venta;
	}

	public String getTiempo_espera() {
		return tiempo_espera;
	}

	public void setTiempo_espera(String tiempo_espera) {
		this.tiempo_espera = tiempo_espera;
	}


}
