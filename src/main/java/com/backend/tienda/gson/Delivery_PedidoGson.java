package com.backend.tienda.gson;

import java.util.List;

import com.backend.tienda.entity.Delivery_Pedido;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;

public class Delivery_PedidoGson {
	
	
	private Delivery_Pedido delivery_information;
	
	private List<ProductoJOINregistroPedidoJOINpedido> productos;

	public Delivery_Pedido getDelivery_information() {
		return delivery_information;
	}

	public void setDelivery_information(Delivery_Pedido delivery_information) {
		this.delivery_information = delivery_information;
	}

	public List<ProductoJOINregistroPedidoJOINpedido> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoJOINregistroPedidoJOINpedido> productos) {
		this.productos = productos;
	}
	
	


}
