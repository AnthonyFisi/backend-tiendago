package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Repartidor_Bi;
import com.backend.tienda.repository.Repartidor_BiRepository;
import com.backend.tienda.service.Repartidor_BiService;

@Service
public class Repartidor_BiServiceImpl implements Repartidor_BiService {
	
	@Autowired
	Repartidor_BiRepository repartidor_BiRepository;

	@Override
	public Repartidor_Bi findByIdRepartidor(int idrepartidor) {
		Repartidor_Bi respuesta= null;
		
		try {
			
			respuesta= repartidor_BiRepository.findByIdrepartidor(idrepartidor);
			
		}catch(Exception e ) {
			
			return respuesta;
		}
		
		return respuesta;
		
	}

	@Override
	public Repartidor_Bi findByIdUsuarioGeneral(int idusuariogeneral) {
		
		Repartidor_Bi respuesta= null;
		
		try {
			
			respuesta= repartidor_BiRepository.findById(idusuariogeneral).get();
			
		}catch(Exception e ) {
			
			return respuesta;
		}
		
		return respuesta;
	}

}
