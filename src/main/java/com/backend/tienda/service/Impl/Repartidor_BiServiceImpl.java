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
	public Repartidor_Bi findByIdRepartidor(int idusuario) {
		Repartidor_Bi respuesta= null;
		
		try {
			
			respuesta= repartidor_BiRepository.findById(idusuario).get();
			
		}catch(Exception e ) {
			
			return respuesta;
		}
		
		return respuesta;
		
	}

}
