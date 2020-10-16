package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Repartidor;

public interface RepartidorService {
	
	Repartidor findRepartidorById(int idRepartidor);
	
	Repartidor updateDisponibilidad(int idRepartidor,boolean state);
	
	Repartidor guardarRepartidor(Repartidor repartidor);
	
	List<Repartidor> findByIdEmpresa(int idempresa);

}
