package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Repartidor_historial;
import com.backend.tienda.gson.Repartidor_historialGson;
import com.backend.tienda.service.Repartidor_historialService;

@RestController
@RequestMapping(Repartidor_historialController.REPARTIDOR_HISTORIAL_CONTROLLER)
public class Repartidor_historialController {

public final static String REPARTIDOR_HISTORIAL_CONTROLLER="/RepartidorHistorialController";
	
	public final static String LISTA="/lista/{idrepartidor}/{idestadodelivery}";
	
	@Autowired
	Repartidor_historialService repartidor_historialService;
	
	@GetMapping(LISTA)
	@PreAuthorize("hasRole('ROLE_MOTORIZADO')")
	public ResponseEntity<?> informacionBasica(@PathVariable("idrepartidor")int idrepartidor,@PathVariable("idestadodelivery")int idestadodelivery){
	
		List<Repartidor_historial> listaData=null;
		
		Repartidor_historialGson gson=null;
		
		listaData=repartidor_historialService.listaHistorial(idrepartidor, idestadodelivery);
		
		if(listaData.size()<0) {
			
			return ResponseEntity.notFound().build();
			
		}
		
		gson=new Repartidor_historialGson();
		
		gson.setListaHistorial(listaData);
		
		return ResponseEntity.ok(gson);
	}
	
}
