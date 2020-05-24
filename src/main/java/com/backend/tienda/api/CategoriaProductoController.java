package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.CategoriaProducto;
import com.backend.tienda.gson.CategoriaProductoGson;
import com.backend.tienda.service.CategoriaProductoService;

@RestController
@RequestMapping(CategoriaProductoController.CATEGORIA_PRODUCTO_CONTROLLER)
public class CategoriaProductoController {
	
	public static final String CATEGORIA_PRODUCTO_CONTROLLER="/CategoriaProductoController";
	
	public static final String LISTA="/lista";
	
	@Autowired
	CategoriaProductoService categoriaProductoService;
	
	
	@RequestMapping(value=LISTA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaProductoGson> listaCategoriaProducto(){
		
		List<CategoriaProducto> rpta=null;
		CategoriaProductoGson categoriaProductoGson=null;
		
		
		try {
			rpta=categoriaProductoService.listaCategoriaProducto();
			categoriaProductoGson= new CategoriaProductoGson();
			categoriaProductoGson.setListaCategoriaProducto(rpta);
			
		}catch(Exception e) 
		{
			return new ResponseEntity<CategoriaProductoGson>(categoriaProductoGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoriaProductoGson>(categoriaProductoGson,HttpStatus.OK);

	}

}
