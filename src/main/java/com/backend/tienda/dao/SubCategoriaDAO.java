package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.SubCategoria;

public interface SubCategoriaDAO {
	
	List<SubCategoria> listaSubcategoria();
	List<SubCategoria> listaSubCategoriaByidCategoria(int idCategoria);

}
