package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Empresa;

public interface EmpresaService {
	
	List<Empresa> listaAllEmpresa();
	
	List<Empresa> listaEmpresaIdCategoria( int idCategoria );
	
	List<Empresa> listaEmpresaSortByBusquedaRating( int idCategoria);
	
	List<Empresa> listaEmpresaFindByIdSubCategoria( int idSubCategoria);
		
	Empresa InsertEmpresa(Empresa empresa);
	
	Empresa  findByIdEmpresaTotal(int idEmpresa);
	
	Empresa updateDisponibilidad(int idEmpresa,boolean disponible);
	
	Empresa updateTelefono(int idEmpresa,String numeroTelefono);
	
	Empresa updateCelular(int idEmpresa,String numeroCelular);
	
	Empresa updateHorarioAtencion(int idEmpresa,int inicio,int fin);
	
	Empresa updateTiempoEntrega(int idEmpresa ,String tiempoAproximado);
	
	Empresa updateDescripcion(Empresa empresa);
	
	List<Empresa> listaEmpresaFavorito( List<Integer> listaIds);

	
	
	
}


