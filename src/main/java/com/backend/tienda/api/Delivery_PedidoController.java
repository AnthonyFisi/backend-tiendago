package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Delivery_Pedido;
import com.backend.tienda.service.Delivery_PedidoService;

@RestController
@RequestMapping(Delivery_PedidoController.DELIVERY_PEDIDO_CONTROLLER)
public class Delivery_PedidoController {
	
	
	public static final String DELIVERY_PEDIDO_CONTROLLER="/DeliveryPedido";

	public static final String REPARTIDOR_PEDIDO="/Repartidor/{idRepartidor}";
	
	
	@Autowired
	Delivery_PedidoService delivery_PedidoService;
	
	
	@RequestMapping(value=REPARTIDOR_PEDIDO,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Delivery_Pedido>  pedidoRepartidor(@PathVariable("idRepartidor") int idRepartidor){
		
		Delivery_Pedido pedido=null;
		
		pedido=delivery_PedidoService.pedido(idRepartidor);
		
		
		
		if(pedido==null) {
			
			return new ResponseEntity<Delivery_Pedido>( pedido,HttpStatus.INTERNAL_SERVER_ERROR);

		}else {
			
			return new ResponseEntity<Delivery_Pedido>( pedido,HttpStatus.OK);

		}
		
		
	}

}
