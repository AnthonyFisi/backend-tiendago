package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.MasBuscados;

public interface MasBuscadosService {
	
	List<MasBuscados> listaMasBuscadosCategoria(int idCategoria);


}
