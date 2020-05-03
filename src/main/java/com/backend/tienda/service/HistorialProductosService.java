package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.HistorialProductos;

public interface HistorialProductosService {
	
	List<HistorialProductos> listaHistorialProductos(int idUsuario);

	
}
