package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Repartidor_historial;

public interface Repartidor_historialService {
	
	List<Repartidor_historial> listaHistorial(int idrepartidor,int idestadodelivery);

}
