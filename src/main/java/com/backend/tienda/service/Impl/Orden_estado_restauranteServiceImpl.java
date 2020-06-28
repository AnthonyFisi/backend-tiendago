package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.entity.Orden_estado_restaurantePK;
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

	@Override
	public Orden_estado_restaurante OrdenDate(int idVenta, int idEstado_Venta) {
		
		Orden_estado_restaurante orden= null;
		
		try {

			Orden_estado_restaurantePK pk = new Orden_estado_restaurantePK();
			pk.setIdventa(idVenta);
			pk.setIdestado_venta(idEstado_Venta);
			orden=ordenRepository.findById(pk).get();
		}catch(Exception e) {
			return orden;
		}
		
		
		
		return orden;
	}

}
