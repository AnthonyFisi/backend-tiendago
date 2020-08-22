package com.backend.tienda.api;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Orden_estado_general;
import com.backend.tienda.service.Orden_estado_generalService;

@RestController
@RequestMapping(Orden_estado_generalController.ORDEN_ESTADO_GENERAL_CONTROLLER)
public class Orden_estado_generalController {

	
	public static final String ORDEN_ESTADO_GENERAL_CONTROLLER="/OrdenEstadoGeneralController";
	
	public static final String ORDEN_REGISTRAR="/registrar";
	
	@Autowired
	Orden_estado_generalService orden_estado_generalService;
	
	@PostMapping(ORDEN_REGISTRAR)
	public ResponseEntity<?> registrarOrdenEstado( @RequestBody Orden_estado_general estado) {
		
		Timestamp time=new Timestamp(System.currentTimeMillis());

		estado.setFecha(time);
		
		Orden_estado_general response=orden_estado_generalService.guardar_estado(estado);
		
		return ResponseEntity.ok(response);
	}
	
}
