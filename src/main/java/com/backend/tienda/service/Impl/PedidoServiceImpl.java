package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.PedidoDAO;
import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.Pedido2;
import com.backend.tienda.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	PedidoDAO pedidoDAO;
	
	@Override
	public void agregarPedido(Pedido pedido) {
		pedidoDAO.agregarPedido(pedido);
		
	}

	@Override
	public int actualizarEstadoPedido(int idPedido) {
		return pedidoDAO.actualizarEstadoPedido(idPedido);
		
	}

	@Override
	public Pedido mostrarPedido(int pedido) {
		
		return pedidoDAO.mostrarPedido(pedido);
	}

	@Override
	public void eliminarPedido(int pedido) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Pedido findByidUsuario(int idUsuario) {
		return pedidoDAO.findByidUsuario(idUsuario);
	}

	@Override
	public Pedido agregarPedidocarrito(Pedido pedido) {
		return pedidoDAO.agregarPedidocarrito(pedido);
	}

	@Override
	public int actualizarPrecioTotalPedido(float precioTotal,int cantidadTotal, int idPedido) {
		return pedidoDAO.actualizarPrecioTotalPedido(precioTotal, cantidadTotal, idPedido);
	}

	@Override
	public Pedido2 mostrar(int pedido) {
		return pedidoDAO.mostrar(pedido);
	}

	@Override
	public Pedido findByidUsuarioListaPedido(int idUsuario) {
		return pedidoDAO.findByidUsuarioListaPedido(idUsuario);
	}

	@Override
	public Pedido findByidUsuarioAutenticacion(int idUsuario) {
		return pedidoDAO.findByidUsuarioAutenticacion(idUsuario);
	}

}
