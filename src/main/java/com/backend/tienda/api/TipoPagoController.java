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
import com.backend.tienda.service.TipoPagoService;

@RestController
@RequestMapping("/TipoPago")
public class TipoPagoController {
	
	@Autowired
	TipoPagoService tipoPagoService;
	
	@RequestMapping(value="/listaTipoPago",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoPago>> listaTipoPago(){
	
		List<TipoPago> listaTipoPago=tipoPagoService.listaTipoPago();
		
		return new ResponseEntity<List<TipoPago>>(listaTipoPago,HttpStatus.OK);	
	}

}
