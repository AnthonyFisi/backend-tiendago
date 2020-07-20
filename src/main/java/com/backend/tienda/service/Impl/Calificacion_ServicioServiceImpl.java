package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Calificacion_Servicio;
import com.backend.tienda.repository.Calificacion_ServicioRepository;
import com.backend.tienda.service.Calificacion_ServicioService;

@Service
public class Calificacion_ServicioServiceImpl implements Calificacion_ServicioService{

	@Autowired
	Calificacion_ServicioRepository  calificacion_ServicioRepository ;
	
	@Override
	public Calificacion_Servicio agregarCalificacion(Calificacion_Servicio calificacion) {
		
		Calificacion_Servicio respuesta=null;
		
		
		try {
			respuesta=calificacion_ServicioRepository.save(calificacion);
		}catch(Exception e) {
			return respuesta;
		} 
		
		return respuesta;
		
	}
	
	

}
