package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Empresa;

public interface EmpresaService {

	
	List<Empresa> listaEmpresaFindByIdSubCategoria( int idSubCategoria);
}
