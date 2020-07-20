package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Calificacion_Usuario;
import com.backend.tienda.service.Calificacion_UsuarioService;

@RestController
@RequestMapping(Calificacion_UsuarioController.CALIFICACION_USUARIO_CONTROLLER)
public class Calificacion_UsuarioController {
	
	public static final String CALIFICACION_USUARIO_CONTROLLER="/CalificacionUsuarioController";
	
	public static final String AGREGAR="/agregar";
	
	@Autowired
	Calificacion_UsuarioService calificacion_UsuarioService ;
	
	

	@RequestMapping(value=AGREGAR,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Calificacion_Usuario> agregarCalificacion(@RequestBody Calificacion_Usuario calificacion){
	
		Calificacion_Usuario respuesta=null;
		
		try {
			
			respuesta=calificacion_UsuarioService.agregarCalificacion(calificacion);
			
		}catch(Exception e) {
			
			return new ResponseEntity<Calificacion_Usuario> (respuesta,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<Calificacion_Usuario> (respuesta,HttpStatus.OK);

	}
	

}