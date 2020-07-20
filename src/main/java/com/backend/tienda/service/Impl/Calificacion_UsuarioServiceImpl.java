package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Calificacion_Usuario;
import com.backend.tienda.repository.Calificacion_UsuarioRepository;
import com.backend.tienda.service.Calificacion_UsuarioService;


@Service
public class Calificacion_UsuarioServiceImpl implements Calificacion_UsuarioService{
	
	@Autowired
	Calificacion_UsuarioRepository calificacion_UsuarioRepository;

	@Override
	public Calificacion_Usuario agregarCalificacion(Calificacion_Usuario calificacion) {
		
		Calificacion_Usuario respuesta=null;
		
		
		try {
			respuesta=calificacion_UsuarioRepository.save(calificacion);
		}catch(Exception e) {
			return respuesta;
		} 
		
		return respuesta;
		
	}
	
	

}
