package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Envio_empresa;
import com.backend.tienda.gson.Envio_empresaGson;
import com.backend.tienda.service.Envio_empresaService;

@RestController
@RequestMapping(Envio_empresaController.ENVIO_EMPRESACONTROLLER)
public class Envio_empresaController {

	public final static String ENVIO_EMPRESACONTROLLER="/EnvioEmpresaController";


	public final static String LISTA_BY_IDEMPRESA="/ListafindByIdEmpresa/{idempresa}";
	
	public final static String LISTA="/Lista/{id}";

	
	@Autowired
	Envio_empresaService envio_empresaService;
	
	@GetMapping(LISTA_BY_IDEMPRESA)
	public ResponseEntity<?> listaEnvioByIdEmpresa(@PathVariable("idempresa") int idempresa){
		
		List<Envio_empresa> listaEmpresa=null;
		
		Envio_empresaGson envio_empresaGson=null;
		
		listaEmpresa=envio_empresaService.findByIdempresa(idempresa);
		
		if(listaEmpresa.size()<=0 || listaEmpresa==null) {
			
			return  ResponseEntity.badRequest().build();

		}
		
		envio_empresaGson=new Envio_empresaGson();
		
		envio_empresaGson.setListaEnvioEmpresa(listaEmpresa);
		
		return  ResponseEntity.ok(envio_empresaGson);


	}
	

	@GetMapping(LISTA)
	public ResponseEntity<?> listaa(@PathVariable("id") int id){
		
		List<Envio_empresa> listaEmpresa=null;
		
		
		listaEmpresa=envio_empresaService.listafindByIdtipoenvio(id);
		
		if(listaEmpresa.size()<=0 || listaEmpresa==null) {
			
			return  ResponseEntity.badRequest().build();

		}
		

		
		return  ResponseEntity.ok(listaEmpresa);


	}
}
