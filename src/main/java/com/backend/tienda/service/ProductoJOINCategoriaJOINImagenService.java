package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.ProductoJOINCategoriaJOINImagen;

public interface ProductoJOINCategoriaJOINImagenService {
	

	
	List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagen();
	List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagenByCategoria(int idCategoria);
	List<ProductoJOINCategoriaJOINImagen> listaBusquedaByTexto(String palabraClave);
	List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagenBySubCategoria(int idSubCategoria);



}
