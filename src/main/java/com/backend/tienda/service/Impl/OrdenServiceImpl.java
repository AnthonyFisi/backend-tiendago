package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Orden;
import com.backend.tienda.repository.OrdenRepository;
import com.backend.tienda.service.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	OrdenRepository ordenRepository;
	
	@Override
	public List<Orden> ordenDisponible(int idestado1, int idestado2, int idestado3, int idusuario) {
		return ordenRepository.findByidestadoventaNotAndidestadoventaNotAndidestadoventaNotAndidusario(idestado1, idestado2, idestado3, idusuario);
	}

}
