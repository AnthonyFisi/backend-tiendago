package com.backend.tienda.dao;

import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.Pedido2;

public interface PedidoDAO {
	
	void agregarPedido(Pedido pedido);
	
	Pedido agregarPedidocarrito(Pedido pedido);
	
	int actualizarEstadoPedido(int idPedido);
	
	Pedido mostrarPedido(int pedido);
	
	void eliminarPedido(int pedido);
	
	int actualizarPrecioTotalPedido(float precioTotal,int cantidadTotal,int idPedido);
	
	Pedido findByidUsuario(int idUsuario);
	
	
	Pedido findByidUsuarioAutenticacion(int idUsuario);
	
	
	Pedido2 mostrar(int pedido);
	
	
	Pedido findByidUsuarioListaPedido(int idUsuario);
	
}
