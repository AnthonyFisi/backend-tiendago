package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.UbicacionDAO;
import com.backend.tienda.entity.Ubicacion;
import com.backend.tienda.service.UbicacionService;

@Service
public class UbicacionServiceImpl implements UbicacionService{
	@Autowired
	UbicacionDAO ubicacionDAO;
	
	
	@Override
	public List<Ubicacion> listaUbicacion(int idUsuario) {
		return ubicacionDAO.listaUbicacion(idUsuario);
	}


	@Override
	public int registrarUbicacion(Ubicacion ubicacion) {
		return ubicacionDAO.registrarUbicacion(ubicacion);
	}


	@Override
	public Ubicacion findByIdUsuarioAndIdUbicacion(int idUsuario) {
		return ubicacionDAO.findByIdUsuarioAndIdUbicacion(idUsuario);
	}

	@Override
	public int actualizarEstadoUbicacionDesactivo(int idUsuario) {
		return ubicacionDAO.actualizarEstadoUbicacionDesactivo(idUsuario);
	}

	
	@Override
	public int actualizarEstadoUbicacionActivo(int idUbicacion) {
		return ubicacionDAO.actualizarEstadoUbicacionActivo(idUbicacion);
	}


	@Override
	public int eliminarUbicacion(int idUbicacion) {
		return ubicacionDAO.eliminarUbicacion(idUbicacion);
	}


	@Override
	public Ubicacion findByIdUbicacion(int idUbicacion) {
		return ubicacionDAO.findByIdUbicacion(idUbicacion);
	}

}
