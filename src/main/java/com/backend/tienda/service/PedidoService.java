package com.backend.tienda.service;

import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.Pedido2;

public interface PedidoService {

	void agregarPedido(Pedido pedido);
	Pedido agregarPedidocarrito(Pedido pedido);
	int actualizarEstadoPedido(int idPedido);
	Pedido mostrarPedido(int idpedido);
	void eliminarPedido(int idpedido);
	int actualizarPrecioTotalPedido(float precioTotal,int cantidadTotal,int idPedido);
	Pedido findByidUsuario(int idUsuario);

	Pedido2 mostrar(int pedido);
	
	Pedido findByidUsuarioListaPedido(int idUsuario);
	
	Pedido findByidUsuarioAutenticacion(int idUsuario);



}
