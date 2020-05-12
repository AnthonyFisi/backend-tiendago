package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.TipoCuenta;
import com.backend.tienda.gson.TipoCuentaGson;
import com.backend.tienda.service.TipoCuentaService;

@RestController
@RequestMapping(TipoCuentaController.TIPO_CUENTA_CONTROLLER)
public class TipoCuentaController {
	
	public final static String TIPO_CUENTA_CONTROLLER="/TipoCuentaController";
	
	public final static String LIST_TIPO_CUENTA="/listaCuenta";
	
	@Autowired
	TipoCuentaService tipoCuentaService;
	
	
	@RequestMapping(value=LIST_TIPO_CUENTA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCuentaGson>  listaTipoCuenta(){
		
		TipoCuentaGson  tipoCuentaGson=null;
		List<TipoCuenta> lista=null;
 
		
		try {
			
			lista=tipoCuentaService.listaTipoCuenta();
			tipoCuentaGson=new TipoCuentaGson();
			tipoCuentaGson.setListaTipoCuenta(lista);
			
		}catch(Exception e) {
			
			return new  ResponseEntity<TipoCuentaGson>(tipoCuentaGson,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<TipoCuentaGson>(tipoCuentaGson,HttpStatus.OK);
		
	}

}
