package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.SubCategoriaEmpresa;

public interface SubCategoriaEmpresaDAO {
	
	List<SubCategoriaEmpresa> listaSubCategoriaEmpresaByIdCategoria(int idCategoriaEmpresa);

}
