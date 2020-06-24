package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Restaurante_Pedido;

public class Restaurante_PedidoGson implements Serializable {
	
	private List<Restaurante_Pedido> listaRestaurante_Pedido;

	public List<Restaurante_Pedido> getListaRestaurante_Pedido() {
		return listaRestaurante_Pedido;
	}

	public void setListaRestaurante_Pedido(List<Restaurante_Pedido> listaRestaurante_Pedido) {
		this.listaRestaurante_Pedido = listaRestaurante_Pedido;
	}
	
	

}
