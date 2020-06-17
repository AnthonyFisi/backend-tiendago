package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Orden;

public interface OrdenService {
	
	List<Orden> ordenDisponible(int idestado1,int idestado2,int idestado3,int idusuario);

}
