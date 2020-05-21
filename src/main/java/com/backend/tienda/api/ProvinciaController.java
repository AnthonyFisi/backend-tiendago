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

import com.backend.tienda.entity.Provincia;
import com.backend.tienda.gson.ProvinciaGson;
import com.backend.tienda.service.ProvinciaService;

@RestController
@RequestMapping(ProvinciaController.PROVINCIA_CONTROLLER)
public class ProvinciaController {
	
	public static final String PROVINCIA_CONTROLLER="/ProvinciaController";
	
	public static final String LISTA_PROVINCIA="/lista/{iddepartamento}";
	
	@Autowired
	ProvinciaService provinciaService;
	
	
	@RequestMapping(value=LISTA_PROVINCIA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProvinciaGson> listaProvincia(@PathVariable("iddepartamento") int iddepartamento){
		
		
		List<Provincia> lista=null;
		
		ProvinciaGson provinciaGson=null;
		
		try {
			
			lista=provinciaService.listaProvincia(iddepartamento);
			provinciaGson=new ProvinciaGson();
			provinciaGson.setListaProvincia(lista);
			
		}catch(Exception e) {
			return new ResponseEntity<ProvinciaGson>(provinciaGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<ProvinciaGson>(provinciaGson,HttpStatus.OK);
		
		
	}
	
	
}
