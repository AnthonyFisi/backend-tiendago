package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Orden_estado_general;

public interface Orden_estado_generalService {

	Orden_estado_general guardar_estado(Orden_estado_general estado);
	
	List<Orden_estado_general> listaOrdenByidVenta(int idVenta);
	
}
