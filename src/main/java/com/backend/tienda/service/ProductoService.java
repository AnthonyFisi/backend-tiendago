package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Producto;

public interface ProductoService {
	
	List<Producto> listaProducto();
	
	Producto insertarProducto(Producto producto);

}
