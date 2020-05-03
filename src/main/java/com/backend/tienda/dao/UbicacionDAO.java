package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.Ubicacion;

public interface UbicacionDAO {
	
	List<Ubicacion> listaUbicacion(int idUsuario);
	
	int registrarUbicacion(Ubicacion ubicacion);
	
	Ubicacion findByIdUsuarioAndIdUbicacion(int idUsuario);
	
	int actualizarEstadoUbicacionActivo(int idUbicacion);
	
	 int actualizarEstadoUbicacionDesactivo(int idUsuario);
	
	int eliminarUbicacion(int idUbicacion);
	
	Ubicacion findByIdUbicacion(int idUbicacion);
	
}
