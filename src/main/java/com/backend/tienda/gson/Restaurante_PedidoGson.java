package com.backend.tienda.gson;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.entity.Restaurante_PedidoModified;

public class Restaurante_PedidoGson implements Serializable {


	
	private List<Restaurante_PedidoModified> listaRestaurante_Pedido;

	public List<Restaurante_PedidoModified> getListaRestaurante_Pedido() {
		return listaRestaurante_Pedido;
	}

	public void setListaRestaurante_Pedido(List<Restaurante_PedidoModified> listaRestaurante_Pedido) {
		this.listaRestaurante_Pedido = listaRestaurante_Pedido;
	}

	
	


}
