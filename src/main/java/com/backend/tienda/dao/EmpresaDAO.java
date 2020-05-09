package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.Empresa;

public interface EmpresaDAO {
	
	List<Empresa> listaEmpresaFindByIdSubCategoria( int idSubCategoria);

}
