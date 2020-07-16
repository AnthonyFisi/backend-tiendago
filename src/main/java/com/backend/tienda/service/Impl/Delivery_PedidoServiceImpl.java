package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Delivery_Pedido;
import com.backend.tienda.repository.Delivery_PedidoRepository;
import com.backend.tienda.service.Delivery_PedidoService;

@Service
public class Delivery_PedidoServiceImpl implements Delivery_PedidoService{

	@Autowired
	Delivery_PedidoRepository delivery_PedidoRepository;

	@Override
	public Delivery_Pedido pedido(int idRepartidor) {
		
		Delivery_Pedido delivery=null;
		
		//delivery=delivery_PedidoRepository.findByidrepartidor(idRepartidor);

		
		try {
			delivery=delivery_PedidoRepository.findByidrepartidor(idRepartidor);
			
		}catch(Exception e ) {
			System.out.println(e.getMessage());
			
			return delivery;
		}
	
		return delivery;
	}
	
	


}
