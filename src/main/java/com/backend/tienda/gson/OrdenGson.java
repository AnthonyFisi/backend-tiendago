package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.api.ProductoJOINregistroPedidoJOINpedidoController;
import com.backend.tienda.entity.Orden;
import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.entity.Usuario;

public class OrdenGson implements Serializable{

	private Orden detalle_orden;
	
	private Usuario usuario;
	
	private List<ProductoJOINregistroPedidoJOINpedido> lista_productos;
	
	private List<Orden_estado_restaurante> lista_orden_estado;

	public Orden getDetalle_orden() {
		return detalle_orden;
	}

	public void setDetalle_orden(Orden detalle_orden) {
		this.detalle_orden = detalle_orden;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProductoJOINregistroPedidoJOINpedido> getLista_productos() {
		return lista_productos;
	}

	public void setLista_productos(List<ProductoJOINregistroPedidoJOINpedido> lista_productos) {
		this.lista_productos = lista_productos;
	}

	public List<Orden_estado_restaurante> getLista_orden_estado() {
		return lista_orden_estado;
	}

	public void setLista_orden_estado(List<Orden_estado_restaurante> lista_orden_estado) {
		this.lista_orden_estado = lista_orden_estado;
	}
	
	

	
	
	
}
