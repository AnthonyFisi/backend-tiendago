package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Categoria;
import com.backend.tienda.entity.GsonCategoria;
import com.backend.tienda.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService service;
	
	
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Categoria>> obtenerLista(){
		List<Categoria> alu= service.listaCategoria();
		return new ResponseEntity<List<Categoria>>(alu, HttpStatus.OK);
	}
	
	

	@RequestMapping(value="/guardarCategoria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarProducto(@RequestBody Categoria categoria){
				service.añadirCategoria(categoria);
				return new ResponseEntity<String>("excelente", HttpStatus.OK);

	}
	
}
