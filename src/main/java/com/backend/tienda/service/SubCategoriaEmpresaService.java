package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.SubCategoriaEmpresa;

public interface SubCategoriaEmpresaService {
	
	List<SubCategoriaEmpresa> listaSubCategoriaEmpresaByIdCategoria(int idCategoriaEmpresa);

}
