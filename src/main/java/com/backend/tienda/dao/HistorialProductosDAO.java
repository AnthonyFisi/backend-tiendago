package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.HistorialProductos;

public interface HistorialProductosDAO {
	
	
	List<HistorialProductos> listaHistorialProductos(int idUsuario);

}
