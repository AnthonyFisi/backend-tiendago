package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.MainPedido;
import com.backend.tienda.entity.Orden;
import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.gson.OrdenGson;
import com.backend.tienda.service.OrdenService;

@RestController
@RequestMapping(OrdenController.ORDEN_CONTROLLER)
public class OrdenController {
	
	public static final String ORDEN_CONTROLLER="/ordenController";
	
	public static final String LISTA_DISPONIBLE="/listaDisponible/{idUsuario}";
	
	
	@Autowired
	OrdenService ordenService;
	
	@RequestMapping(value=LISTA_DISPONIBLE,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenGson> listaOrdenesDisponibles(@PathVariable ("idUsuario") int idUsuario){
		
		List<Orden> lista=null;
		OrdenGson ordenGson=null;
		
		try {
			
			lista=ordenService.ordenDisponible(6, 7	,3, idUsuario);
			ordenGson=new OrdenGson();
			ordenGson.setListaOrden(lista);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<OrdenGson>(ordenGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<OrdenGson>(ordenGson,HttpStatus.OK);

	}
	

}
