package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.CarritoDAO;
import com.backend.tienda.entity.Carrito;
import com.backend.tienda.service.CarritoService;


@Service
public class CarritoServiceImpl implements CarritoService{

	@Autowired
	CarritoDAO carritoDAO;
	
	@Override
	public List<Carrito> listaCompras(int idUsuario, int idPedido) {
		return carritoDAO.listaCompras(idUsuario, idPedido);
	}

	@Override
	public List<Carrito> listaComprasRealizada(int idPedido) {
		return carritoDAO.listaComprasRealizada(idPedido);
	}

	@Override
	public int eliminarCarrito(int idPedido) {
		return carritoDAO.eliminarCarrito(idPedido);
	}

}
