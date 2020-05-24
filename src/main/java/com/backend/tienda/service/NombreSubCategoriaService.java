package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.NombreSubcategoria;

public interface NombreSubCategoriaService {
	
	List<NombreSubcategoria> listaNombreSubCategoria();
	
	NombreSubcategoria insertarNombreSubCategoria(NombreSubcategoria nombreSubCategoria);

	List<NombreSubcategoria> listaNombreSubCategoriaByidEmpresa(int idempresa);


}
