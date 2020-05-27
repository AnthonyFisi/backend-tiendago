package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;

public class ProductoJOINregistroPedidoJOINpedidoGson implements Serializable{
	
	List<ProductoJOINregistroPedidoJOINpedido> listaProductoJOINregistroPedidoJOINpedido;

	public List<ProductoJOINregistroPedidoJOINpedido> getListaProductoJOINregistroPedidoJOINpedido() {
		return listaProductoJOINregistroPedidoJOINpedido;
	}

	public void setListaProductoJOINregistroPedidoJOINpedido(
			List<ProductoJOINregistroPedidoJOINpedido> listaProductoJOINregistroPedidoJOINpedido) {
		this.listaProductoJOINregistroPedidoJOINpedido = listaProductoJOINregistroPedidoJOINpedido;
	}
	
	
}
