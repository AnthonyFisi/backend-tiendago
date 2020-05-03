package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.ListaPedidoDAO;
import com.backend.tienda.entity.ListaPedido;
import com.backend.tienda.service.ListaPedidoService;


@Service
public class ListaPedidoServiceImpl implements ListaPedidoService{
	@Autowired
	ListaPedidoDAO listaPedidoDAO;
	
	@Override
	public List<ListaPedido> mostrarListaPedidoByIdUsuario(int idUsuario, int idPedido) {
		
		//return listaPedidoDAO.mostrarListaPedidoByIdUsuario(idUsuario, idPedido);
		return null;
	}

	@Override
	public List<ListaPedido> mostrarListaByIdUsuario(int idUsuario) {
		return listaPedidoDAO.mostrarListaByIdUsuario(idUsuario);
		}

	@Override
	public List<ListaPedido> mostrarListaByIdUsuarioHoy(int idUsuario) {
		return listaPedidoDAO.mostrarListaByIdUsuarioHoy(idUsuario);
	}

	@Override
	public List<ListaPedido> mostrarListaByIdUsuarioPendiente(int idUsuario) {
		return listaPedidoDAO.mostrarListaByIdUsuarioPendiente(idUsuario);
	}

	@Override
	public List<ListaPedido> mostrarListaByIdUsuarioHistorial(int idUsuario) {
		return listaPedidoDAO.mostrarListaByIdUsuarioHistorial(idUsuario);
	}
	
	
	

}
