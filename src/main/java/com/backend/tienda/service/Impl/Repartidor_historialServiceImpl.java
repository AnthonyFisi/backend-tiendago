package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Repartidor_historial;
import com.backend.tienda.repository.Repartidor_historialRepository;
import com.backend.tienda.service.Repartidor_historialService;

@Service
public class Repartidor_historialServiceImpl implements Repartidor_historialService{
	
	@Autowired
	Repartidor_historialRepository repartidor_historialRepository;
	

	@Override
	public List<Repartidor_historial> listaHistorial(int idrepartidor, int idestadodelivery) {
		return repartidor_historialRepository.findByIdrepartidorAndIdestadodeliveryOrderByFechahistorialDesc(idrepartidor, idestadodelivery);
	}

}
