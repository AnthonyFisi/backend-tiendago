package com.backend.tienda.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.backend.tienda.entity.Repartidor;
import com.backend.tienda.service.RepartidorService;



@RestController
@RequestMapping(RepartidorController.REPARTIDOR_CONTROLLER)
public class RepartidorController {
	
	public static final String REPARTIDOR_CONTROLLER="/repartidorController";
	
	public static final String FIND_BY_IDREPARTIDOR="/findByRepartidor/{idRepartidor}";


	
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
	
	
	

}
