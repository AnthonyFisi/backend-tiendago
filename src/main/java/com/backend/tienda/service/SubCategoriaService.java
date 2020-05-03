package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.SubCategoria;

public interface SubCategoriaService {
	
	List<SubCategoria> listaSubcategoria();
	List<SubCategoria> listaSubCategoriaByidCategoria(int idCategoria);

}
