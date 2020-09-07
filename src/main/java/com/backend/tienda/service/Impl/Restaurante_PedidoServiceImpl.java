package com.backend.tienda.service.Impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
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
		//return restaurante_PedidoRepository.findRecentOrden(idEmpresa, idPedido, idVenta);
		return restaurante_PedidoRepository.findByIdestadoempresaAndOrdendisponibleAndIdempresaAndIdpedidoAndIdventa(1,true,idEmpresa,idPedido,idVenta);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosNuevosDistinct(int idEmpresa) {
		
		String fecha1=
		    	LocalDate                       // Represents an entire day, without time-of-day and without time zone.
		    	.now(                           // Capture the current date.
		    	    ZoneId.of( "America/Lima" )   // Returns a `ZoneId` object.
		    	).toString();
		    	
		Timestamp date1=Timestamp.valueOf(fecha1+" 00:00:00.000");

		String fecha2=
		    	LocalDate                       // Represents an entire day, without time-of-day and without time zone.
		    	.now(                           // Capture the current date.
		    	    ZoneId.of( "America/Lima" )   // Returns a `ZoneId` object.
		    	).plusDays(1).toString();
		
		Timestamp date2=Timestamp.valueOf(fecha2+" 00:00:00.000");

		//.findByIdestadoempresaAndOrdendisponibleAndIdempresaAndVentafechaentregaBetween(1,true,idEmpresa,date1,date2);
		
		//return restaurante_PedidoRepository.listfindByIdEmpresaAndIdVenta_fechaEntregaDistinct(idEmpresa,date1,date2);
		return restaurante_PedidoRepository.findByIdestadoempresaAndOrdendisponibleAndIdempresaAndVentafechaentregaBetween(1,true,idEmpresa,date1,date2);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosProceso(int idEmpresa) {
		
		
	//	return restaurante_PedidoRepository.findProcesOrden(idEmpresa);
		return restaurante_PedidoRepository.findByIdestadoempresaAndOrdendisponibleAndIdempresaAndCancelar(2,true,idEmpresa,false);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosReady(int idEmpresa) {
		//return restaurante_PedidoRepository.findReadyOrden(idEmpresa);
		return restaurante_PedidoRepository.findByIdestadoempresaAndOrdendisponibleAndIdempresaAndCancelar(3,true,idEmpresa,false);

	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosHistorial(int idEmpresa) {
		return restaurante_PedidoRepository.findByIdestadoempresaAndOrdendisponibleAndIdempresa(4,false,idEmpresa);
	}

}
