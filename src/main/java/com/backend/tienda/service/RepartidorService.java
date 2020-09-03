package com.backend.tienda.service;

import com.backend.tienda.entity.Repartidor;

public interface RepartidorService {
	
	Repartidor findRepartidorById(int idRepartidor);
	
	Repartidor updateDisponibilidad(int idRepartidor,boolean state);
	
	Repartidor guardarRepartidor(Repartidor repartidor);

}
