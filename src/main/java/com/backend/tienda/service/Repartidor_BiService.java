package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Repartidor_Bi;

public interface Repartidor_BiService {
	
	Repartidor_Bi findByIdRepartidor(int idusuario);
	
	Repartidor_Bi findByIdUsuarioGeneral(int idusuariogeneral);

	List<Repartidor_Bi> findByIdempresa(int idempresa);

}
