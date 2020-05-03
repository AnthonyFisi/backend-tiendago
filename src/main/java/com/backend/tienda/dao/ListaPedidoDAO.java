package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.ListaPedido;

public interface ListaPedidoDAO {
	
	List<ListaPedido> mostrarListaPedidoByIdUsuario(int idUsuario,int idPedido);
	List<ListaPedido> mostrarListaByIdUsuario(int idUsuario);
	
	
	List<ListaPedido> mostrarListaByIdUsuarioHoy(int idUsuario);
	List<ListaPedido> mostrarListaByIdUsuarioPendiente(int idUsuario);
	List<ListaPedido> mostrarListaByIdUsuarioHistorial(int idUsuario);

}
