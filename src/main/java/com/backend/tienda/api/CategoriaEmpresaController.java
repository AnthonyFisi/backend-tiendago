package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.CategoriaEmpresa;
import com.backend.tienda.gson.CategoriaEmpresaGson;
import com.backend.tienda.service.CategoriaEmpresaService;

/*
 * @PreAuthorize("authenticated")
 * */
@RestController
@RequestMapping(CategoriaEmpresaController.CATEGORIA_EMPRESA_CONTROLLER)
public class CategoriaEmpresaController {
	
	public static final String  CATEGORIA_EMPRESA_CONTROLLER="/categoriaEmpresa";
	
	public static final String  MOSTRAR_CATEGORIA="/mostrarCategoria";
	
	
	@Autowired
	CategoriaEmpresaService categoriaEmpresaService;
	
	
	@RequestMapping(value=MOSTRAR_CATEGORIA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaEmpresaGson> listaCategoriaEmpresa(){
		CategoriaEmpresaGson categoriaEmpresaGson =null;
		List<CategoriaEmpresa> lista =null;
		
		try {
			
			lista=categoriaEmpresaService.listaCategoriaEmpresa();
			categoriaEmpresaGson=new CategoriaEmpresaGson();
			categoriaEmpresaGson.setListaCategoriaEmpresa(lista);
			
		}catch(Exception e) {
			
			return new  ResponseEntity<CategoriaEmpresaGson>(categoriaEmpresaGson,HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<CategoriaEmpresaGson>(categoriaEmpresaGson,HttpStatus.OK);
		
	}
	
	
	
	
	

}
