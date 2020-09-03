package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Cuenta_repartidor;
import com.backend.tienda.repository.Cuenta_repartidorRepository;
import com.backend.tienda.service.Cuenta_repartidorService;

@Service
public class Cuenta_repartidorServiceImpl implements Cuenta_repartidorService{

	@Autowired
	Cuenta_repartidorRepository cuenta_repartidorRepository;
		
	@Override
	public Cuenta_repartidor guardarCuenta_repartidor(Cuenta_repartidor cuenta) {
		
		return cuenta_repartidorRepository.save(cuenta);
	}

}
