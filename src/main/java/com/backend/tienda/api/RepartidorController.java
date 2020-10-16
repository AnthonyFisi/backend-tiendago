package com.backend.tienda.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.backend.tienda.entity.Repartidor;
import com.backend.tienda.gson.Repartidor_BiGson;
import com.backend.tienda.service.RepartidorService;



@RestController
@RequestMapping(RepartidorController.REPARTIDOR_CONTROLLER)
public class RepartidorController {
	
	public static final String REPARTIDOR_CONTROLLER="/repartidorController";
	
	public static final String FIND_BY_IDREPARTIDOR="/findByRepartidor/{idRepartidor}";
	
	public static final String UPDATE_DISPONIBILIDAD="/disponibilidad/{idRepartidor}/{state}"; 

	public static final String LISTA_BY_IDEMPRESA="/listaEmpresa/{idempresa}"; 

	
	@Autowired
	RepartidorService repartidorService;
	
	
	@RequestMapping(value=FIND_BY_IDREPARTIDOR,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Repartidor> añadirProducto(@PathVariable("idRepartidor") int idRepartidor){
		
		Repartidor repartidor=null;
		try {
			
			repartidor=repartidorService.findRepartidorById(idRepartidor);
		
		}catch(Exception e) {
			return new ResponseEntity<Repartidor>(repartidor,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<Repartidor>(repartidor,HttpStatus.OK);
	
	}
	
	@PostMapping(UPDATE_DISPONIBILIDAD)
	public ResponseEntity<Repartidor> updateDisponibilidad(@PathVariable("idRepartidor") int idRepartidor,@PathVariable("state")boolean state){
		
		Repartidor repartidor=null;
		try {
			
			repartidor=repartidorService.updateDisponibilidad(idRepartidor, state);
		
		}catch(Exception e) {
			return  ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok(repartidor);
	
	}
	
	
/*	@GetMapping(LISTA_BY_IDEMPRESA)
	public ResponseEntity<Repartidor_BiGson> listaRepartidorEmpresa(@PathVariable("idempresa") int idempresa){
		
		List<Repartidor> listarepartidor=null;
		
		Repartidor_BiGson gson=null;
		
		
		try {
			
			listarepartidor=repartidorService.findByIdEmpresa(idempresa);
			gson=new Repartidor_BiGson();
			gson.setListaRepartidor(listarepartidor);
		
		}catch(Exception e) {
			
			return  ResponseEntity.notFound().build();

		}
		
		return ResponseEntity.ok(gson);
	
	}*/
	
	

}
