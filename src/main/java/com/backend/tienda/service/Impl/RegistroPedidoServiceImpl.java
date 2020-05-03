package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.RegistroPedidoDAO;
import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.service.RegistroPedidoService;

@Service
public class RegistroPedidoServiceImpl implements RegistroPedidoService {
	
	@Autowired
	RegistroPedidoDAO registroPedidoDAO;
	
	@Override
	public void guardarRegistroPedido(RegistroPedido registroPedido) {
		registroPedidoDAO.guardarRegistroPedido(registroPedido);
		
	}

	@Override
	public void actualizarRegistroPedido(int idPedido, int idProducto,int cantidad,float precio) {
		registroPedidoDAO.actualizarRegistroPedido(idPedido, idProducto, cantidad, precio);	
	}

	
	@Override
	public List<RegistroPedido> listaRegistroPedido() {
		return registroPedidoDAO.listaRegistroPedido();
	}

	@Override
	public RegistroPedido findByPedidoAndProducto(int idPedido, int idProducto) {
		
		return registroPedidoDAO.findByPedidoAndProducto(idPedido, idProducto);
	}

	@Override
	public boolean eliminarRegistroPedido(int idPedido, int idProducto) {
		return registroPedidoDAO.eliminarRegistroPedido(idPedido, idProducto);
	}

}
