package com.backend.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Orden_estado_empresa;
import com.backend.tienda.entity.Orden_estado_empresaPK;
import com.backend.tienda.repository.Orden_estado_restauranteRepository;
import com.backend.tienda.service.Orden_estado_restauranteService;

@Service
public class Orden_estado_restauranteServiceImpl implements Orden_estado_restauranteService{

	@Autowired
	Orden_estado_restauranteRepository ordenRepository;
	
	@Override
	public Orden_estado_empresa registrarEstado(Orden_estado_empresa ordenEstado) {
		
		
		
		return ordenRepository.save(ordenEstado);
	}

	@Override
	public List<Orden_estado_empresa> listaEstadosOrden(int idVenta) {
		
		
	List<Orden_estado_empresa> lista=null;
		
		try {
			
			lista=ordenRepository.listFindByidVenta(idVenta);
		}catch(Exception e) {
			
			lista=new ArrayList<>();
		}
		
		return lista; 
	}
	

	@Override
	public Orden_estado_empresa OrdenDate(int idVenta, int idEstado_Venta) {
		
		Orden_estado_empresa orden= null;
		
		try {

			Orden_estado_empresaPK pk = new Orden_estado_empresaPK();
			pk.setIdventa(idVenta);
			pk.setIdestado_empresa(idEstado_Venta);
			orden=ordenRepository.findById(pk).get();
		}catch(Exception e) {
			return orden;
		}
		
		
		
		return orden;
	}

	@Override
	public List<Orden_estado_empresa> listaEstados(List<Orden_estado_empresaPK> pk) {

		List<Orden_estado_empresa> lista=null;
		
		try {
			
			lista=ordenRepository.findAllById(pk);
		}catch(Exception e) {
			
			lista=new ArrayList<>();
		}
		
		return lista; 
	}

}
