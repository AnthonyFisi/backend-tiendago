package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.EmpresaOficial;
import com.backend.tienda.service.EmpresaOficialService;

@RestController
@RequestMapping(EmpresaOficialController.EMPRESA_OFICIAL_CONTROLLER)
public class EmpresaOficialController {
	
	public final static String EMPRESA_OFICIAL_CONTROLLER="/EmpresaOficialController";

	public final static String UPDATE_DESCUENTO_MENU="/updateDescuento/{idempresa}";
	
	@Autowired
	EmpresaOficialService empresaOficialService;
	
	@PostMapping(UPDATE_DESCUENTO_MENU)
	public ResponseEntity<?> updateDescuentoMenu(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("descuento") float descuento){
		
		EmpresaOficial empresa=empresaOficialService.updateValorDescuento(idEmpresa, descuento);
		
		if(empresa==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(empresa);
		
	}


}
