package com.backend.tienda.service.Impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.repository.Restaurante_PedidoRepository;
import com.backend.tienda.service.Restaurante_PedidoService;

@Service
public class Restaurante_PedidoServiceImpl implements Restaurante_PedidoService{

	@Autowired
	Restaurante_PedidoRepository restaurante_PedidoRepository;
	
	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosNuevos(int idEmpresa) {
		return restaurante_PedidoRepository.listfindByIdEmpresaAndIdVenta_fechaEntrega(idEmpresa);
	}

	@Override
	public Restaurante_Pedido recientePedido(int idEmpresa, int idPedido, int idVenta) {
		return restaurante_PedidoRepository.findRecentOrden(idEmpresa, idPedido, idVenta);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosNuevosDistinct(int idEmpresa) {
		return restaurante_PedidoRepository.listfindByIdEmpresaAndIdVenta_fechaEntregaDistinct(idEmpresa);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosProceso(int idEmpresa) {
		return restaurante_PedidoRepository.findProcesOrden(idEmpresa);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosReady(int idEmpresa) {
		return restaurante_PedidoRepository.findReadyOrden(idEmpresa);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosHistorial(int idEmpresa) {
		return restaurante_PedidoRepository.findHistorialOrden(idEmpresa);
	}

}
