package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Repartidor_Bi;
import com.backend.tienda.service.Repartidor_BiService;

@RestController
@RequestMapping(Repartidor_BiController.REPARTIDOR_BI_CONTROLLER)
public class Repartidor_BiController {
	
	public final static String REPARTIDOR_BI_CONTROLLER="/RepartidorBiController";
	
	public final static String INFORMACION_INICIO="/informacion/{idusuario}";
	
	@Autowired
	Repartidor_BiService repartidor_BiService;
	
	
	@GetMapping(INFORMACION_INICIO)
	@PreAuthorize("hasRole('ROLE_MOTORIZADO') or hasRole('ROLE_EMPRESA_ASOCIADA')")
	public ResponseEntity<?> informacionBasica(@PathVariable("idusuario")int idusuario){
	
		Repartidor_Bi repartidorData=null;
		
		repartidorData=repartidor_BiService.findByIdRepartidor(idusuario);
		
		if(repartidorData==null) {
			
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok(repartidorData);
	}

}
