package com.backend.tienda.service;

import java.sql.Timestamp;
import java.util.List;

import com.backend.tienda.entity.Restaurante_Pedido;

public interface Restaurante_PedidoService {

	
	List<Restaurante_Pedido> listaRestaurantePedidosNuevos(int idEmpresa);
	
	Restaurante_Pedido recientePedido(int idEmpresa,int idPedido,int idVenta);
}
