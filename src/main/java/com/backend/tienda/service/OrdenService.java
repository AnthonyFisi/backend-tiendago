package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Orden;

public interface OrdenService {
	
	List<Orden> ordenDisponible(int idusuario);

}
