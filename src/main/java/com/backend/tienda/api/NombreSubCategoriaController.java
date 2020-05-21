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

import com.backend.tienda.entity.NombreSubcategoria;
import com.backend.tienda.entity.Producto;
import com.backend.tienda.gson.NombreSubCategoriaGson;
import com.backend.tienda.service.NombreSubCategoriaService;

@RestController
@RequestMapping(NombreSubCategoriaController.NOMBRE_SUBCATEGORIA_CONTROLLER)
public class NombreSubCategoriaController {
	
	public static final String  NOMBRE_SUBCATEGORIA_CONTROLLER="/NombreSubCategoria";
	
	public static final String  MOSTRAR_NOMBRES="/mostrarNombres";
	
	public static final String INSERTAR_NOMBRE_SUBCATEGORIA="/insertar";
	
	@Autowired
	NombreSubCategoriaService nombreSubCategoriaService;
	
	@RequestMapping(value=MOSTRAR_NOMBRES,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NombreSubCategoriaGson> listaNombresSubCategoria(){
		
		NombreSubCategoriaGson nombreSubCategoriaGson=null;
		List<NombreSubcategoria> lista=null;
		
		
		try {
			lista= nombreSubCategoriaService.listaNombreSubCategoria();
			
			nombreSubCategoriaGson=new NombreSubCategoriaGson();
			
			nombreSubCategoriaGson.setListaNombreSubCategoria(lista);
			
		}catch(Exception e) {
			
			return new ResponseEntity<NombreSubCategoriaGson>(nombreSubCategoriaGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<NombreSubCategoriaGson>(nombreSubCategoriaGson,HttpStatus.OK);

		
	}
	
	
	

	@RequestMapping(value=INSERTAR_NOMBRE_SUBCATEGORIA,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NombreSubcategoria> regitrarCuentaEmpresa(@RequestBody NombreSubcategoria nombreSubCategoria){
		
		NombreSubcategoria rpta=null;
		
		
		try {
			rpta=nombreSubCategoriaService.insertarNombreSubCategoria(nombreSubCategoria);
			
		}catch(Exception e) 
		{
			return new ResponseEntity<NombreSubcategoria>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<NombreSubcategoria>(rpta,HttpStatus.OK);

	}
	

}
