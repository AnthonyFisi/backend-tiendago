package com.backend.tienda.api;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.gson.Restaurante_PedidoGson;
import com.backend.tienda.gson.Tipo_EnvioGson;
import com.backend.tienda.service.Restaurante_PedidoService;

@RestController
@RequestMapping(Restaurante_PedidoController.RESTAURANTE_PEDIDO_CONTROLLER)
public class Restaurante_PedidoController {
	
	
	public static final String RESTAURANTE_PEDIDO_CONTROLLER="/RestaurantePedido";
	
	public static final String LISTA_BY_IDEMPRESA_FECHAVENTA="/listaPedidos/{idEmpresa}";
	
	
	@Autowired
	Restaurante_PedidoService restaurante_PedidoService;
	
	
	@RequestMapping(value=LISTA_BY_IDEMPRESA_FECHAVENTA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurante_PedidoGson>  listaPedidosRecientes(@PathVariable("idEmpresa") int idEmpresa){
		
		Timestamp fecha_entrega=new Timestamp(System.currentTimeMillis());
		System.out.println(fecha_entrega+ " ------------");

		Restaurante_PedidoGson restauranteGson= null;
		
		List<Restaurante_Pedido> listaRestaurante=null;
		
		try {
			
			listaRestaurante=restaurante_PedidoService.listaRestaurantePedidosNuevos(idEmpresa, fecha_entrega);
			restauranteGson= new Restaurante_PedidoGson();
			restauranteGson.setListaRestaurante_Pedido(listaRestaurante);
			
		}catch(Exception e) {
			return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	


}
