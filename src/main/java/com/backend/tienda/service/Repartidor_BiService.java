package com.backend.tienda.service;

import com.backend.tienda.entity.Repartidor_Bi;

public interface Repartidor_BiService {
	
	Repartidor_Bi findByIdRepartidor(int idusuario);
	
	Repartidor_Bi findByIdUsuarioGeneral(int idusuariogeneral);

}
