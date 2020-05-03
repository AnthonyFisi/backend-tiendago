package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Mesa;
import com.backend.tienda.service.MesaService;

@RestController
@RequestMapping("/Mesa")
public class MesaController {
	
	@Autowired
	MesaService service;
	
	@RequestMapping(value="/listaMesa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Mesa>> listaMesa(){
		List<Mesa> lista=service.listaMesa();
		return  new ResponseEntity<List<Mesa>>(lista,HttpStatus.OK);
	}
	
	@RequestMapping(value="/guardarMesa", method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	public void ingresarMesa(@RequestBody Mesa mesa) {
		service.añadirMesa(mesa);
	}

}
