package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Calificacion_Servicio;
import com.backend.tienda.service.Calificacion_ServicioService;

@RestController
@RequestMapping(Calificacion_ServicioController.CALIFICACION_SERVICIO_CONTROLLER)
public class Calificacion_ServicioController {
	
	public static final String CALIFICACION_SERVICIO_CONTROLLER="/CalificacionServicioController";
	
	public static final String AGREGAR="/agregar";
	
	@Autowired
	Calificacion_ServicioService calificacion_ServicioService ;
	


	@RequestMapping(value=AGREGAR,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Calificacion_Servicio> agregarCalificacion(@RequestBody Calificacion_Servicio calificacion){
	
		Calificacion_Servicio respuesta=null;
		
		try {
			
			respuesta=calificacion_ServicioService.agregarCalificacion(calificacion);
			
		}catch(Exception e) {
			
			return new ResponseEntity<Calificacion_Servicio> (respuesta,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<Calificacion_Servicio> (respuesta,HttpStatus.OK);

	}
	

}
