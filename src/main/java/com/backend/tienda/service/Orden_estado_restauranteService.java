package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Orden_estado_restaurante;

public interface Orden_estado_restauranteService {
	
	Orden_estado_restaurante registrarEstado(Orden_estado_restaurante ordenEstado);
	
	List<Orden_estado_restaurante> listaEstadosOrden(int idVenta);

}
