package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;

public interface ProductoJOINregistroPedidoJOINpedidoService {
	

	 List<ProductoJOINregistroPedidoJOINpedido> listaTotalByEmpresa(int idusuario,int idEmpresa);
	 
	 List<ProductoJOINregistroPedidoJOINpedido> listaCarritoTotal(int idusuario);
	 
	 List<ProductoJOINregistroPedidoJOINpedido> listaCarritoByIdUsuario(int idusuario);
	 
	 List<ProductoJOINregistroPedidoJOINpedido> listaProductoVenta(int idPedido);



}
