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
import com.backend.tienda.gson.ProductoGson;
import com.backend.tienda.service.ProductoService;

@RestController
@RequestMapping(ProductoController.PRODUCTO_CONTROLLER)
public class ProductoController {
	
	public final static String PRODUCTO_CONTROLLER="/productoController";
	
	public final static String LISTA_PRODUCTOS="/lista";
	
	public final static String INSERTAR_PRODUCTO="/insertar";
	
	public final static String LISTA_PRODUCTOS_FIND_IDCATEGORIA_IDEMPRESA="/listaCategoria/{idcategoriaproducto}/{idempresa}";

	
	
	@Autowired
	ProductoService productoService;
	
	

	@RequestMapping(value=INSERTAR_PRODUCTO,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> regitrarCuentaEmpresa(@RequestBody Producto producto){
		
		Producto rpta=null;
		
		
		try {
			rpta=productoService.insertarProducto(producto);
			
		}catch(Exception e) 
		{
			return new ResponseEntity<Producto>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Producto>(rpta,HttpStatus.OK);

	}
	
	

	@RequestMapping(value=LISTA_PRODUCTOS,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoGson> listaCuentaEmprsa(){
		
		List<Producto> rpta=null;
		ProductoGson productoGson=null;
		
		
		try {
			rpta=productoService.listaProducto();
			productoGson= new ProductoGson();
			productoGson.setListaProducto(rpta);
			
		}catch(Exception e) 
		{
			return new ResponseEntity<ProductoGson>(productoGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ProductoGson>(productoGson,HttpStatus.OK);

	}
	
	
	

	@RequestMapping(value=LISTA_PRODUCTOS_FIND_IDCATEGORIA_IDEMPRESA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoGson> listaCategoriaAndEmpresa(@PathVariable("idcategoriaproducto") int idcategoriaproducto,
			@PathVariable("idempresa") int idempresa){
		
		List<Producto> rpta=null;
		ProductoGson productoGson=null;
		
		
		try {
			rpta=productoService.listaIdcategoriaproductoAndIdempresa(idcategoriaproducto, idempresa);
			productoGson= new ProductoGson();
			productoGson.setListaProducto(rpta);
			
		}catch(Exception e) 
		{
			return new ResponseEntity<ProductoGson>(productoGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ProductoGson>(productoGson,HttpStatus.OK);

	}
	

}
