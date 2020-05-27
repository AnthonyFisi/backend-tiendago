package com.backend.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.repository.PedidoRepository;
import com.backend.tienda.repository.ProductoJOINregistroPedidoJOINpedidoRepository;
import com.backend.tienda.service.ProductoJOINregistroPedidoJOINpedidoService;

@Service
public class ProductoJOINregistroPedidoJOINpedidoServiceImpl implements ProductoJOINregistroPedidoJOINpedidoService{
	
	
	@Autowired
	ProductoJOINregistroPedidoJOINpedidoRepository productoJOINregistroPedidoJOINpedidoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	
	

	@Override
	public List<ProductoJOINregistroPedidoJOINpedido> listaTotal(int idusuario) {
		
		Pedido respuesta = null;
		List<ProductoJOINregistroPedidoJOINpedido> list=null;
		try {
			respuesta=pedidoRepository.findByIdUsuario(idusuario);
	        list=productoJOINregistroPedidoJOINpedidoRepository.findByidpedido(respuesta.getIdpedido());

		}catch(Exception e) {
			list=new ArrayList<ProductoJOINregistroPedidoJOINpedido>();
			return list;
		}
		
		return list;
	}
	
	
	

}
