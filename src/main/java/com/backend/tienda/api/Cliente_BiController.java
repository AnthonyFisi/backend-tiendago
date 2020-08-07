package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Cliente_Bi;
import com.backend.tienda.service.Cliente_BiService;

@RestController
@RequestMapping(Cliente_BiController.CLIENTE_BI_CONTROLLER)
public class Cliente_BiController {
	
	
public final static String CLIENTE_BI_CONTROLLER="/clientebi";
	
	private final static String BASIC_INFORMATION="/basic/{idusuario}";
	
	
	@Autowired
	Cliente_BiService cliente_BiService;
	
	
	@GetMapping(BASIC_INFORMATION)
	public ResponseEntity<?> basicInformation(@PathVariable("idusuario") int idusuario){
		
		Cliente_Bi cliente_bi=null;
		
		try {
			
			cliente_bi=cliente_BiService.findCliente(idusuario);
			return ResponseEntity.ok(cliente_bi);
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(cliente_bi);
		}
		
	}
	
	

}
