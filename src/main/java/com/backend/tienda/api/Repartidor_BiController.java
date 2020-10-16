package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Repartidor_Bi;
import com.backend.tienda.gson.Repartidor_BiGson;
import com.backend.tienda.service.Repartidor_BiService;

@RestController
@RequestMapping(Repartidor_BiController.REPARTIDOR_BI_CONTROLLER)
public class Repartidor_BiController {
	
	public final static String REPARTIDOR_BI_CONTROLLER="/RepartidorBiController";
	
	public final static String INFORMACION_INICIO="/informacion/{idusuario}";
	
	public final static String LISTA_BYIDEMPRESA="/lista/{idempresa}";

	
	@Autowired
	Repartidor_BiService repartidor_BiService;
	
	
	@GetMapping(INFORMACION_INICIO)
	@PreAuthorize("hasRole('ROLE_MOTORIZADO')")
	public ResponseEntity<?> informacionBasica(@PathVariable("idusuario")int idusuariogeneral){
	
		Repartidor_Bi repartidorData=null;
		
		repartidorData=repartidor_BiService.findByIdUsuarioGeneral(idusuariogeneral);
		
		if(repartidorData==null) {
			
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok(repartidorData);
	}
	
	@GetMapping(LISTA_BYIDEMPRESA)
	public ResponseEntity<?> listaByEmpresa(@PathVariable("idempresa")int idempresa){
	
		List<Repartidor_Bi> listaRepartidor=null;
		
		Repartidor_BiGson gson=null;

	
		listaRepartidor=repartidor_BiService.findByIdempresa(idempresa);
		
		if(listaRepartidor.size()<0) {
			
			return ResponseEntity.notFound().build();
		}
		
		gson=new Repartidor_BiGson();
		
		gson.setListaRepartidor(listaRepartidor);
	
		
		return ResponseEntity.ok(gson);
	}

}
