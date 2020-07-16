package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Orden_estado_delivery;

public interface Orden_estado_deliveryService {
	
	Orden_estado_delivery saveState(Orden_estado_delivery estado);
	
	List<Orden_estado_delivery> listaEstadosByIdVenta(int idVenta);

}
