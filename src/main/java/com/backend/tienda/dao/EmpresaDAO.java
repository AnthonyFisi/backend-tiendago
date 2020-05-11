package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.Empresa;

public interface EmpresaDAO {
	
	//LISTA DE LAS CATEGORIAS DE LAS EMPRESAS
	
	//List<Empresa> listaSubCategoriaEmpresaFindByIdCategoria( int idCategoria);
	
	List<Empresa> listaEmpresaFindByIdCategoriaAndUbicacion( int idCategoria , String Ubicacion);
	
	List<Empresa> listaEmpresaSortByBusquedaRating( int idCategoria);
	
	List<Empresa> listaEmpresaFindByIdSubCategoriaAndUbicacion( int idSubCategoria,String Ubicacion);
	
	List<Empresa> listaEmpresaFindByIdSubCategoria( int idSubCategoria);





}
