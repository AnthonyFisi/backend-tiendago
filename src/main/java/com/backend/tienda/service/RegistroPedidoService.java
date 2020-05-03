package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.RegistroPedido;

public interface RegistroPedidoService {
	
	void guardarRegistroPedido(RegistroPedido registroPedido);
	
	void actualizarRegistroPedido(int idPedido, int idProducto,int cantidad,float precio);
	
	boolean eliminarRegistroPedido(int idPedido,int idProducto);
	
	List<RegistroPedido> listaRegistroPedido();
	
	RegistroPedido findByPedidoAndProducto(int idPedido,int idProducto);



}
