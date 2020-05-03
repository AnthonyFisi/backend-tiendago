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
import com.backend.tienda.entity.ProductoJOINCategoriaJOINImagen;
import com.backend.tienda.service.ProductoJOINCategoriaJOINImagenService;

@RestController
@RequestMapping("/productoJOINImagen")
public class ProductoJOINCategoriaJOINImagenController {
	
	@Autowired
	ProductoJOINCategoriaJOINImagenService service;

	@RequestMapping(value = "/lista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ProductoJOINCategoriaJOINImagen>> obtenerLista(){
	
		List<ProductoJOINCategoriaJOINImagen> alu= service.listaProductoJOINCategoriaJOINImagen();
		return new ResponseEntity<List<ProductoJOINCategoriaJOINImagen>>(alu, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/lista/{idCategoria}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ProductoJOINCategoriaJOINImagen>> obtenerListaByCategoria(@PathVariable("idCategoria") int idCategoria){
	
		List<ProductoJOINCategoriaJOINImagen> alu= service.listaProductoJOINCategoriaJOINImagenByCategoria(idCategoria);
		return new ResponseEntity<List<ProductoJOINCategoriaJOINImagen>>(alu, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/listaSubCategoria/{idSubCategoria}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ProductoJOINCategoriaJOINImagen>> obtenerListaBySubCategoria(@PathVariable("idSubCategoria") int idSubCategoria){
	
		List<ProductoJOINCategoriaJOINImagen> alu= service.listaProductoJOINCategoriaJOINImagenBySubCategoria(idSubCategoria);
		return new ResponseEntity<List<ProductoJOINCategoriaJOINImagen>>(alu, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/listaByTexto/{palabraClave}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ProductoJOINCategoriaJOINImagen>> obtenerListaByTexto(@PathVariable("palabraClave") String palabraClave){
	
		List<ProductoJOINCategoriaJOINImagen> alu= service.listaBusquedaByTexto(palabraClave);
		
		return new ResponseEntity<List<ProductoJOINCategoriaJOINImagen>>(alu, HttpStatus.OK);
	}

}
