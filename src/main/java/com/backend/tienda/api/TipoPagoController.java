package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.TipoPago;
import com.backend.tienda.gson.TipoPagoGson;
import com.backend.tienda.service.TipoPagoService;

@RestController
@RequestMapping(TipoPagoController.TIPO_PAGO_CONTROLLER)
public class TipoPagoController {
	
	public final static String TIPO_PAGO_CONTROLLER="/TipoPagoController";
	
	public final static String LISTA="/lista";
	
	@Autowired
	TipoPagoService tipoPagoService;
	
	@RequestMapping(value=LISTA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoPagoGson>  listaTipoPago(){
		
		List<TipoPago> listaTipoPago=null;
		TipoPagoGson tipoPagoGson=null;
		
		try {
			
			listaTipoPago=tipoPagoService.listaTipoPago();
			tipoPagoGson=new TipoPagoGson();
			tipoPagoGson.setListaTipoPago(listaTipoPago);
			
		}catch(Exception e) {
			return new  ResponseEntity<TipoPagoGson> (tipoPagoGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<TipoPagoGson> (tipoPagoGson,HttpStatus.OK);
	}

}
