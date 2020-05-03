package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.Categoria;

public interface CategoriaDAO {
	
	List<Categoria> listaCategoria();
	void añadirCategoria(Categoria categoria);
	void eliminarCategoria(int idCategoria);
	void actualizarCategoria(int idCategoria);

}
