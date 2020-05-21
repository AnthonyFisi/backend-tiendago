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

import com.backend.tienda.entity.CuentaEmpresa;
import com.backend.tienda.gson.CuentaEmpresaGson;
import com.backend.tienda.service.CuentaEmpresaService;

@RestController
@RequestMapping(CuentaEmpresaController.CUENTA_EMPRESA_CONTROLLER)
public class CuentaEmpresaController {
	
	public final static String CUENTA_EMPRESA_CONTROLLER="/cuentaEmpresa";
	
	private final static String LISTA_CUENTA_EMPRESA="/listaTotal";
	
	private final static String INSERTAR_CUENTA_EMPRESA="/insertar";
	
	@Autowired
	CuentaEmpresaService cuentaEmpresaService;
	

	@RequestMapping(value=INSERTAR_CUENTA_EMPRESA,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CuentaEmpresa> regitrarCuentaEmpresa(@RequestBody CuentaEmpresa cuentaEmpresa){
		
		CuentaEmpresa rpta=null;
		
		
		try {
			rpta=cuentaEmpresaService.insertarCuentaEmpresa(cuentaEmpresa);
			
		}catch(Exception e) 
		{
			return new ResponseEntity<CuentaEmpresa>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CuentaEmpresa>(rpta,HttpStatus.OK);

	}
	
	

	@RequestMapping(value=LISTA_CUENTA_EMPRESA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CuentaEmpresaGson> listaCuentaEmprsa(){
		
		List<CuentaEmpresa> rpta=null;
		CuentaEmpresaGson cuentaEmpresaGson=null;
		
		
		try {
			rpta=cuentaEmpresaService.listaCuentaEmpresa();
			cuentaEmpresaGson= new CuentaEmpresaGson();
			cuentaEmpresaGson.setListaCuentaEmpresa(rpta);
			
		}catch(Exception e) 
		{
			return new ResponseEntity<CuentaEmpresaGson>(cuentaEmpresaGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CuentaEmpresaGson>(cuentaEmpresaGson,HttpStatus.OK);

	}
	
	
	
	
	
	

}
