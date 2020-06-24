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

import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.gson.Orden_estado_restauranteGson;
import com.backend.tienda.service.Orden_estado_restauranteService;

@RestController
@RequestMapping(Orden_estado_restauranteController.ORDEN_ESTADO_RESTAURANTE_CONTROLLER)
public class Orden_estado_restauranteController {

	public static final String ORDEN_ESTADO_RESTAURANTE_CONTROLLER="/Orden_Estado_RestauranteController";
	
	public static final String ORDEN_REGISTRAR="/registrarOrden";
	
	public static final String LISTA_ESTADO_BY_VENTA="/listaOrden/{idVenta}";
	
	
	@Autowired
	Orden_estado_restauranteService ordenService;
	
	@RequestMapping(value=LISTA_ESTADO_BY_VENTA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_restauranteGson> listaOrdenByVenta(@PathVariable ("idVenta") int idVenta){
		
		Orden_estado_restauranteGson ordenGson=null;
		
		List<Orden_estado_restaurante> listaOrden =null;
		
		try {
			
			listaOrden=ordenService.listaEstadosOrden(idVenta);
			
			ordenGson= new Orden_estado_restauranteGson();
			
			ordenGson.setListaOrden_estado_restaurante(listaOrden);
			
		}catch(Exception e) {
			return new ResponseEntity<Orden_estado_restauranteGson>(ordenGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<Orden_estado_restauranteGson>(ordenGson,HttpStatus.OK);
	}

}
