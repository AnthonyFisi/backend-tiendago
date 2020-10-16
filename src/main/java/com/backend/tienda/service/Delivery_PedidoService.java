package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Delivery_Pedido;

public interface Delivery_PedidoService {
	
	Delivery_Pedido pedido(int idRepartidor);
	
	Delivery_Pedido  findByIdventa(int idventa);

	List<Delivery_Pedido> findByidRepartidor(int idrepartidor);

}
