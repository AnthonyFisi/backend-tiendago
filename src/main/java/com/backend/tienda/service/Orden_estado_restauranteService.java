package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.entity.Orden_estado_restaurantePK;

public interface Orden_estado_restauranteService {
	
	Orden_estado_restaurante registrarEstado(Orden_estado_restaurante ordenEstado);
	
	List<Orden_estado_restaurante> listaEstadosOrden(int idVenta);
	
	Orden_estado_restaurante OrdenDate(int idVenta,int idEstado_Venta);
	
	List<Orden_estado_restaurante> listaEstados(List<Orden_estado_restaurantePK> pk);
	
}
