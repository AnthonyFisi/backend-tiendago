package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.repository.Orden_estado_restauranteRepository;
import com.backend.tienda.service.Orden_estado_restauranteService;

@Service
public class Orden_estado_restauranteServiceImpl implements Orden_estado_restauranteService{

	@Autowired
	Orden_estado_restauranteRepository ordenRepository;
	
	@Override
	public Orden_estado_restaurante registrarEstado(Orden_estado_restaurante ordenEstado) {
		return ordenRepository.save(ordenEstado);
	}

	@Override
	public List<Orden_estado_restaurante> listaEstadosOrden(int idVenta) {
		return ordenRepository.listFindByidVenta(idVenta);
	}

}
