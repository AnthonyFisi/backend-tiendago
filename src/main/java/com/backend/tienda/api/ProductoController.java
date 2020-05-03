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

import com.backend.tienda.entity.Producto;
import com.backend.tienda.service.ProductoService;



@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService service;
	private List<String> lista;
	
	@RequestMapping(value="/guardarProducto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertarProducto(@RequestBody Producto producto){
				service.ingresarProducto(producto);
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Producto>> obtenerLista(){
		
		List<Producto> alu= service.listaProductos();
		
		return new ResponseEntity<List<Producto>>(alu, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/lista/{idCategoria}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Producto>> obtenerListaByCategoria(@PathVariable("idCategoria") int idCategoria){
	
		List<Producto> alu= service.listaProductosByCategoria(idCategoria);		
		return new ResponseEntity<List<Producto>>(alu, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/eliminar/{idProducto}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> eliminarProducto(@PathVariable("idProducto") int idProducto){
		boolean rpt=false;
		if(service.eliminarProducto(idProducto)==true) {
			rpt=true;
			return new ResponseEntity<>(rpt, HttpStatus.OK);
			

		}else {
			rpt=false;
			return new ResponseEntity<>(rpt, HttpStatus.BAD_REQUEST);

		}

	}
	
	@RequestMapping(value = "/listaBusqueda", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> obtenerListaBuscar(){
		
		List<Producto> alu= service.listaProductos();
	
		String lista1="";
		return new ResponseEntity<String>(lista1, HttpStatus.OK);
	
	}
	
	
	
	
}
