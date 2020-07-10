package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Empresa;

public interface EmpresaService {
	
	List<Empresa> listaEmpresaFindByIdCategoriaAndUbicacion( int idCategoria , String Ubicacion);
	
	List<Empresa> listaEmpresaSortByBusquedaRating( int idCategoria);
	
	List<Empresa> listaEmpresaFindByIdSubCategoriaAndUbicacion( int idSubCategoria,String Ubicacion);
	
	List<Empresa> listaEmpresaFindByIdSubCategoria( int idSubCategoria);
	
	Empresa InsertEmpresa(Empresa empresa);
	
	Empresa  findByIdEmpresaTotal(int idEmpresa);
}
