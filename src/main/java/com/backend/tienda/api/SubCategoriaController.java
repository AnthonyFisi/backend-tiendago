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

import com.backend.tienda.entity.SubCategoria;
import com.backend.tienda.service.SubCategoriaService;

@RequestMapping("/SubCategoria")
@RestController
public class SubCategoriaController {
	
	
	@Autowired
	SubCategoriaService subCategoriaService;
	
	
	@RequestMapping(value="/listaSubCategoria",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubCategoria>> listaSubCategoria(){
	
		List<SubCategoria> listaSubCategoria=subCategoriaService.listaSubcategoria();
		
		return new ResponseEntity<List<SubCategoria>>(listaSubCategoria,HttpStatus.OK);	
	}
	
	
	@RequestMapping(value="/listaSubCategoria/{idCategoria}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubCategoria>> listaSubCategoria(@PathVariable("idCategoria") int idCategoria){
	
		List<SubCategoria> listaSubCategoria=subCategoriaService.listaSubCategoriaByidCategoria(idCategoria);
		
		return new ResponseEntity<List<SubCategoria>>(listaSubCategoria,HttpStatus.OK);	
	}

	
}
