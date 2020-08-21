package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Orden_estado_general;
import com.backend.tienda.repository.Orden_estado_generalRepository;
import com.backend.tienda.service.Orden_estado_generalService;


@Service
public class Orden_estado_generalServiceImpl  implements Orden_estado_generalService{
	
	@Autowired
	Orden_estado_generalRepository orden_estado_generalRepository;

	@Override
	public Orden_estado_general guardar_estado(Orden_estado_general estado) {
		return  orden_estado_generalRepository.save(estado);
	}

	@Override
	public List<Orden_estado_general> listaOrdenByidVenta(int idVenta) {
		return orden_estado_generalRepository.findByIdventa(idVenta);
	}

}
