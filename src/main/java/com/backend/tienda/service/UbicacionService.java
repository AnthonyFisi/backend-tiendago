package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Ubicacion;

public interface UbicacionService {
	
	List<Ubicacion> findByidusuario(int idusuario);

	Ubicacion findByidubicacion(int idubicacion);

	Ubicacion saveUbicacion(Ubicacion ubicacion,int idOldUbicacion);
	
	Ubicacion findByidusuario1(int idusuario);
	
	boolean updateEstadoUbicacion(int idUbicacion,boolean estado);
	
	boolean deleteUbicacion(int idubicacion);


}
