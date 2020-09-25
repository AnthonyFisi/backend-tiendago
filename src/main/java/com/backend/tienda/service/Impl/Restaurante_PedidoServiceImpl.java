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

		return restaurante_PedidoRepository.findByIdestadoempresaAndOrdendisponibleAndIdempresaAndVentafechaentregaBetween(1,true,idEmpresa,date1,date2);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosProceso(int idEmpresa) {
		return restaurante_PedidoRepository.findByIdestadoempresaAndOrdendisponibleAndIdempresaAndCancelarOrderByVentafechaentregaDesc(2,true,idEmpresa,false);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosReady(int idEmpresa) {
		return restaurante_PedidoRepository.findByIdestadoempresaAndOrdendisponibleAndIdempresaAndCancelarOrderByVentafechaentregaDesc(3,true,idEmpresa,false);
	}

	@Override
	public List<Restaurante_Pedido> listaRestaurantePedidosHistorial(int idEmpresa) {
		return restaurante_PedidoRepository.findByIdestadoempresaAndIdempresa(4,idEmpresa);
	}

}
