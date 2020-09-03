package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Empresa_bi2;
import com.backend.tienda.gson.DistritoGson;
import com.backend.tienda.gson.Empresa_favoritaGson;
import com.backend.tienda.service.Empresa_bi2Service;

@RestController
@RequestMapping(Empresa_bi2Controller.EMPRESA_BI2_CONTROLLER)
public class Empresa_bi2Controller {

	
public final static String EMPRESA_BI2_CONTROLLER="/EmpresaBi2Controller";
	
	public final static String FIND_BYID_USUARIO="/findBy/{idusuario}";
	
	@Autowired
	Empresa_bi2Service empresa_bi2Service;
	
	@GetMapping(FIND_BYID_USUARIO)
	public ResponseEntity<?> findByIdEmpresa_bi2(@PathVariable("idusuario") int idusuario){
		
		
		
		
		Empresa_bi2 empresa_bi2=null;
		
		empresa_bi2=empresa_bi2Service.findByIdUsuario(idusuario);
		
		if(empresa_bi2!=null) {
			
			return ResponseEntity.ok(empresa_bi2);
		}
		
		return ResponseEntity.badRequest().build();
		
	}
}
