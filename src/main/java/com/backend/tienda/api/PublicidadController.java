package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tiend.modelo.PublicidadGson;
import com.backend.tienda.entity.Publicidad;
import com.backend.tienda.service.PublicidadService;

@RestController
@RequestMapping(PublicidadController.PUBLICIDAD_CONTROLLER)
public class PublicidadController {
	
	public final static String PUBLICIDAD_CONTROLLER="/PublicidadController";
	
	public final static String LISTA_PUBLICIDAD="/lista";
	
	@Autowired
	PublicidadService publicidadService;
	
	
	@RequestMapping(value=LISTA_PUBLICIDAD,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PublicidadGson> listaPublicidad(){
		PublicidadGson publicidadGson =null;
		List<Publicidad> lista =null;
		
		try {
			
			lista=publicidadService.listaPublicidad();
			publicidadGson=new PublicidadGson();
			publicidadGson.setListaPublicidad(lista);;
			
		}catch(Exception e) {
			
			return new  ResponseEntity<PublicidadGson>(publicidadGson,HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<PublicidadGson>(publicidadGson,HttpStatus.OK);
		
	}
	
	
	

}
