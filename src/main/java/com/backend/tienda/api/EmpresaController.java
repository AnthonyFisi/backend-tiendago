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

import com.backend.tiend.modelo.EmpresaGson;
import com.backend.tienda.entity.Empresa;
import com.backend.tienda.service.EmpresaService;

@RestController
@RequestMapping(EmpresaController.EMPRESA_CONTROLLER)
public class EmpresaController {
	
	public final static String EMPRESA_CONTROLLER="/EmpresaController";
	
	public final static String FIND_EMPRESA_SUBCATEGORIA="/findEmpresaByIdSubCategoria/{idSubCategoria}";
	
	
	@Autowired
	EmpresaService empresaService;
	
	
	@RequestMapping(value=FIND_EMPRESA_SUBCATEGORIA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaCategoriaEmpresa(@PathVariable("idSubCategoria") int idSubCategoria){
		
		EmpresaGson empresaGson =null;
		List<Empresa> lista=null;
		
		
		try {
			lista=empresaService.listaEmpresaFindByIdSubCategoria(idSubCategoria);
			empresaGson=new EmpresaGson();
			empresaGson.setListaEmpresa(lista);
		}catch(Exception e) 
		{
			return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.OK);

	}
	

}
