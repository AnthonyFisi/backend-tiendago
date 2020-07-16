package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Delivery_Pedido;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.gson.Delivery_PedidoGson;
import com.backend.tienda.service.Delivery_PedidoService;
import com.backend.tienda.service.ProductoJOINregistroPedidoJOINpedidoService;

@RestController
@RequestMapping(Delivery_PedidoController.DELIVERY_PEDIDO_CONTROLLER)
public class Delivery_PedidoController {
	
	
	public static final String DELIVERY_PEDIDO_CONTROLLER="/DeliveryPedido";

	public static final String REPARTIDOR_PEDIDO="/Repartidor/{idRepartidor}";
	
	
	@Autowired
	Delivery_PedidoService delivery_PedidoService;
	

	@Autowired
	ProductoJOINregistroPedidoJOINpedidoService productoJOINregistroPedidoJOINpedidoService;

	
	
	@RequestMapping(value=REPARTIDOR_PEDIDO,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Delivery_PedidoGson>  pedidoRepartidor(@PathVariable("idRepartidor") int idRepartidor){
		
		Delivery_Pedido delivery_information=null;
		
		List<ProductoJOINregistroPedidoJOINpedido> productos=null;
		
		Delivery_PedidoGson delivery_PedidoGson=null;

		try {
			
			delivery_information=delivery_PedidoService.pedido(idRepartidor);
			
			productos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(delivery_information.getIdpedido());
			
			delivery_PedidoGson = new Delivery_PedidoGson();
			
			delivery_PedidoGson.setDelivery_information(delivery_information);
			
			delivery_PedidoGson.setProductos(productos);
			
		}catch(Exception e) {
		
			return new ResponseEntity<Delivery_PedidoGson>(delivery_PedidoGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<Delivery_PedidoGson>(delivery_PedidoGson,HttpStatus.OK);
		
		
	}

}
