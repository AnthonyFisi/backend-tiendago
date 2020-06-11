package com.backend.tienda.service;

import com.backend.tienda.entity.Pedido;

public interface PedidoService {
	
	Pedido registrarPedido(Pedido pedido);
	
	Pedido findByIdUsuario(int idUsuario);
	
	void updatePedido(int cantidad_total,float precio_total,int idpedido);
	
	void updatePedido2(int cantidad_total,float precio_total,int idpedido);
	
	void eliminarPedido(int idPedido);

}
