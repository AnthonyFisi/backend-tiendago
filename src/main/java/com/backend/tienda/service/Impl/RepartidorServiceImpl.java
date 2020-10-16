package com.backend.tienda.service.Impl;

import java.util.List;

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
			return repartidor;

		}catch(Exception e) {
			return repartidor;
		}
	}

	@Override
	public Repartidor updateDisponibilidad(int idRepartidor, boolean state) {

        Repartidor repartidor =null;
		
		try {
			
			repartidor=repartidorRepository.findById(idRepartidor).get();
			
			repartidor.setDisponible(state);
			
			 return repartidorRepository.save(repartidor);
			
			
		}catch(Exception e) {
			
			return repartidor;
		}
		
	}

	@Override
	public Repartidor guardarRepartidor(Repartidor repartidor) {
		return repartidorRepository.save(repartidor);
	}

	@Override
	public List<Repartidor> findByIdEmpresa(int idempresa) {
		return repartidorRepository.findByIdempresa(idempresa);
	}
	
	
	

}
