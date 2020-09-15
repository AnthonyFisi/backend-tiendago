package com.backend.tienda.service;


import java.util.List;

import com.backend.tienda.entity.Empresa_historial;


public interface Empresa_historialService {
	
	List<Empresa_historial>  findByEstado(int idestadoempresaofi,int idempresa);

}
