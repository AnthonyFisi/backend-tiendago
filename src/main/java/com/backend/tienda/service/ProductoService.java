package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Producto;

public interface ProductoService {
	
	void  ingresarProducto(Producto producto);
	
	boolean  eliminarProducto(int codigo);
	
	void  actualizarProducto(int codigo);
	
	List<Producto> listaProductos();
	
	List<Producto> listaProductosByCategoria(int idCategoria);

	

}
