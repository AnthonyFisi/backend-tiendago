package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.Carrito;

public interface CarritoDAO {
	
	List<Carrito> listaCompras(int idUsuario,int idPedido);
	List<Carrito> listaComprasRealizada(int idPedido);
	int eliminarCarrito(int idPedido);

}
