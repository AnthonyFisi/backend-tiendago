package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.ProductoJOINCategoriaJOINImagen;

public interface ProductoJOINCategoriaJOINImagenDAO {
	
	
	List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagen();
	List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagenByCategoria(int idCategoria);
	List<ProductoJOINCategoriaJOINImagen> listaBusquedaByTexto(String palabraClave);
	List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagenBySubCategoria(int idSubCategoria);


	
}
