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

import com.backend.tienda.entity.HistorialProductos;
import com.backend.tienda.service.HistorialProductosService;

@RestController
@RequestMapping("/HistorialProductos")
public class HistorialProductosController {
	
	@Autowired
	HistorialProductosService historialProductosService;
	
	
	@RequestMapping(value = "/lista/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<HistorialProductos>> obtenerListaHistorialProductos(@PathVariable("idUsuario")int idUsuario){
		
		List<HistorialProductos> alu;
		try {
			alu= historialProductosService.listaHistorialProductos(idUsuario);
			return new ResponseEntity<List<HistorialProductos>>(alu, HttpStatus.OK);

		}catch(Exception e) {
			alu= null;
			return new ResponseEntity<List<HistorialProductos>>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
