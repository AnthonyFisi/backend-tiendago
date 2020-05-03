package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.Producto;

public interface ProductoDAO {
	
	void  ingresarProducto(Producto producto);
	
	boolean  eliminarProducto(int codigo);
	
	void  actualizarProducto(int codigo);
	
	List<Producto> listaProductos();
	
	List<Producto> listaProductosByCategoria(int idCategoria);
	
	
	
}
