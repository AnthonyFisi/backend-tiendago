package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Pedido;
import com.backend.tienda.repository.PedidoRepository;
import com.backend.tienda.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	

	@Override
	public Pedido registrarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido findByIdUsuario(int idUsuario) {
		return pedidoRepository.findByIdUsuario(idUsuario);
	}

	@Override
	public void updatePedido(int cantidad_total, float precio_total, int idpedido) {
		 pedidoRepository.updatePedido(cantidad_total, precio_total, idpedido);
	}

	@Override
	public void updatePedido2(int cantidad_total, float precio_total, int idpedido) {
		
		Pedido pedido=pedidoRepository.findById(idpedido).get();
		
		pedido.setPedido_cantidadtotal(cantidad_total);
		pedido.setPedido_montototal(precio_total);
		
		pedidoRepository.save(pedido);
		
	}

	@Override
	public void eliminarPedido(int idPedido) {
		try {
			pedidoRepository.deleteById(idPedido);
			
		}catch(Exception e) {
			
		}
		
	}

}
