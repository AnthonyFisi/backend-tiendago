package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.MasBuscados;

public interface MasBuscadosDAO {
	
	List<MasBuscados> listaMasBuscadosCategoria(int idCategoria);

}
