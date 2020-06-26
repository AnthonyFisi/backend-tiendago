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
	public List<ProductoJOINregistroPedidoJOINpedido> listaTotalByEmpresa(int idusuario,int idEmpresa) {
		
		Pedido respuesta = null;
		List<ProductoJOINregistroPedidoJOINpedido> list=null;
		try {
			respuesta=pedidoRepository.findByIdUsuario(idusuario,idEmpresa);
	        list=productoJOINregistroPedidoJOINpedidoRepository.GfindByidpedido(respuesta.getIdpedido());

		}catch(Exception e) {
			list=new ArrayList<ProductoJOINregistroPedidoJOINpedido>();
			return list;
		}
		
		return list;
	}




	@Override
	public List<ProductoJOINregistroPedidoJOINpedido> listaCarritoTotal(int idusuario) {
		
		List<ProductoJOINregistroPedidoJOINpedido> list=null;
		try {
	        list=productoJOINregistroPedidoJOINpedidoRepository.listaCarritos(idusuario);

		}catch(Exception e) {
			list=new ArrayList<ProductoJOINregistroPedidoJOINpedido>();
			return list;
		}
		
		return list;
	}




	@Override
	public List<ProductoJOINregistroPedidoJOINpedido> listaCarritoByIdUsuario(int idusuario) {
		return  productoJOINregistroPedidoJOINpedidoRepository.GfindByidusuario(idusuario);
	}




	@Override
	public List<ProductoJOINregistroPedidoJOINpedido> listaProductoVenta(int idPedido) {
		 List<ProductoJOINregistroPedidoJOINpedido> list=null;
			try {
				
		        list= productoJOINregistroPedidoJOINpedidoRepository.ventaFindByidPedido(idPedido);
				 

			}catch(Exception e) {
				list=new ArrayList<ProductoJOINregistroPedidoJOINpedido>();
				return list;
			}
			
			return list;
	}
	
	
	

}
