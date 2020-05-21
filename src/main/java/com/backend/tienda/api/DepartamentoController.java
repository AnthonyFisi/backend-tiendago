package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Departamento;
import com.backend.tienda.gson.DepartamentoGson;
import com.backend.tienda.service.DepartamentoService;

@RestController
@RequestMapping(DepartamentoController.DEPARTAMENTO_CONTROLLER)
public class DepartamentoController {
	
	public final static String DEPARTAMENTO_CONTROLLER="/DepartamentoController";
	
	public final static String LISTA_DEPARTAMENTO="/lista";
	
	@Autowired
	DepartamentoService departamentoService;
	
	@RequestMapping(value=LISTA_DEPARTAMENTO,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartamentoGson> listaDepartamento(){
		
		List<Departamento> listaDepartamento=null;
		
		DepartamentoGson departamentoGson=null;
		
		try {
			
			listaDepartamento=departamentoService.listaDepartamento();
			departamentoGson=new DepartamentoGson();
			departamentoGson.setListaDepartamento(listaDepartamento);
			
		}catch(Exception e) {
			return new ResponseEntity<DepartamentoGson>(departamentoGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<DepartamentoGson>(departamentoGson,HttpStatus.OK);
		
		
	}
	

}
