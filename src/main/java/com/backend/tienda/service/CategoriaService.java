package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Categoria;


public interface CategoriaService {
	
	List<Categoria> listaCategoria();
	
	void añadirCategoria(Categoria categoria);
	
	void eliminarCategoria(int idCategoria);
	
	void actualizarCategoria(int idCategoria);
}
