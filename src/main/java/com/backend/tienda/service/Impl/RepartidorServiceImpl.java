package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Repartidor;
import com.backend.tienda.repository.RepartidorRepository;
import com.backend.tienda.service.RepartidorService;

@Service
public class RepartidorServiceImpl implements RepartidorService {
	
	@Autowired
	RepartidorRepository repartidorRepository;

	@Override
	public Repartidor findRepartidorById(int idRepartidor) {
		Repartidor repartidor =null;
		
		try {
			repartidor=repartidorRepository.findById(idRepartidor).get();
			
		}catch(Exception e) {
			return repartidor;
		}
		return repartidor;
	}
	
	
	

}
