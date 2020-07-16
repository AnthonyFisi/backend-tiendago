package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Orden_estado_delivery;
import com.backend.tienda.repository.Orden_estado_deliveryRepository;
import com.backend.tienda.service.Orden_estado_deliveryService;

@Service
public class Orden_estado_deliveryServiceImpl implements Orden_estado_deliveryService{
	
	@Autowired
	Orden_estado_deliveryRepository orden_estado_deliveryRepository;

	@Override
	public Orden_estado_delivery saveState(Orden_estado_delivery estado) {
		Orden_estado_delivery orden_estado=null;
		
		try {
			
			orden_estado=orden_estado_deliveryRepository.save(estado);
			
		}catch(Exception e) {
			return orden_estado;
		}
		return orden_estado;
	}

	@Override
	public List<Orden_estado_delivery> listaEstadosByIdVenta(int idVenta) {
		
		List<Orden_estado_delivery> lista=null;
		
		try {
			lista=orden_estado_deliveryRepository.listaEstadosByIdVenta(idVenta);
			
		}catch(Exception e) {
			
			return lista;
		}
		
		return lista;
		
	}

}
