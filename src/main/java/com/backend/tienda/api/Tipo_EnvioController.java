package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.backend.tienda.entity.Tipo_Envio;
import com.backend.tienda.gson.Tipo_EnvioGson;
import com.backend.tienda.service.Tipo_EnvioService;

@RestController
@RequestMapping(Tipo_EnvioController.TIPO_ENVIO_CONTROLLER)
public class Tipo_EnvioController {

	public final static String TIPO_ENVIO_CONTROLLER="/TipoEnvioController";
	
	public final static String LIST_TIPO_ENVIO="/lista";
	
	@Autowired
	Tipo_EnvioService tipo_EnvioService;
	
	@RequestMapping(value=LIST_TIPO_ENVIO,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tipo_EnvioGson>  listaTipoCuenta(){
		
		Tipo_EnvioGson  tipo_EnvioGson=null;
		List<Tipo_Envio> lista=null;
 
		
		try {
			
			lista=tipo_EnvioService.listaTipo_Envio();
			tipo_EnvioGson=new Tipo_EnvioGson();
			tipo_EnvioGson.setListaTipo_Envio(lista);
			
		}catch(Exception e) {
			
			return new  ResponseEntity<Tipo_EnvioGson>( tipo_EnvioGson,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<Tipo_EnvioGson>( tipo_EnvioGson,HttpStatus.OK);
		
	}


}
