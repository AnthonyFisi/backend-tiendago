package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.HistorialProductosDAO;
import com.backend.tienda.entity.HistorialProductos;
import com.backend.tienda.service.HistorialProductosService;


@Service
public class HistorialProductosServiceImpl  implements HistorialProductosService {

	@Autowired
	HistorialProductosDAO historialProductosDAO;
	
	@Override
	public List<HistorialProductos> listaHistorialProductos(int idUsuario) {
		return historialProductosDAO.listaHistorialProductos(idUsuario);
	}

}
