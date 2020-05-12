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

import com.backend.tienda.entity.SubCategoriaEmpresa;
import com.backend.tienda.gson.CategoriaEmpresaGson;
import com.backend.tienda.gson.SubCategoriaEmpresaGson;
import com.backend.tienda.service.SubCategoriaEmpresaService;

/*
 * @PreAuthorize("authenticated")
 * */
@RestController
@RequestMapping(SubCategoriaEmpresaController.SUBCATEGORIA_EMPRESA_CONTROLLER)
public class SubCategoriaEmpresaController {
	
	public static final String  SUBCATEGORIA_EMPRESA_CONTROLLER="/subCategoriaEmpresa";
	
	public static final String  MOSTRAR_SUBCATEGORIA="/ListSubCategoriafindByIdEmpresa/{idCategoria}";
	
	
	@Autowired
	SubCategoriaEmpresaService subCategoriaEmpresaService;
	
	
	@RequestMapping(value=MOSTRAR_SUBCATEGORIA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubCategoriaEmpresaGson>  listaSubCategoriaEmpresaByIdCategoria(@PathVariable("idCategoria") int idCategoriaEmpresa){
		
		SubCategoriaEmpresaGson subCategoriaEmpresaGson =null;
		List<SubCategoriaEmpresa> lista =null;


		
		try {
			
			lista=subCategoriaEmpresaService.listaSubCategoriaEmpresaByIdCategoria(idCategoriaEmpresa);
			subCategoriaEmpresaGson=new SubCategoriaEmpresaGson();
			subCategoriaEmpresaGson.setListaSubCategoriaEmpresa(lista);
			
		}catch(Exception e) {
			
			return new  ResponseEntity<SubCategoriaEmpresaGson>(subCategoriaEmpresaGson,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<SubCategoriaEmpresaGson>(subCategoriaEmpresaGson,HttpStatus.OK);
		
	}



}
