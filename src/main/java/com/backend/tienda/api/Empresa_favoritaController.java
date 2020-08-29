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

import com.backend.tienda.entity.Empresa_favorita;
import com.backend.tienda.gson.DistritoGson;
import com.backend.tienda.service.Empresa_favoritaService;

@RestController
@RequestMapping(Empresa_favoritaController.EMPRESA_FAVORITA_CONTROLLER)
public class Empresa_favoritaController {

	
public final static String EMPRESA_FAVORITA_CONTROLLER="/EmpresaFavoritaController";
	
	public final static String LISTA_FAVORITOS="/lista/{idusuario}";
	
	@Autowired
	Empresa_favoritaService empresa_favoritaService;
	
	@GetMapping(LISTA_FAVORITOS)
	public ResponseEntity<?> listaDistrito(@PathVariable("idusuario") int idusuario){
		
		List<Empresa_favorita> listaEmpresa=null;
		
		listaEmpresa=empresa_favoritaService.listaEmpresas(idusuario);
		
		if(listaEmpresa.size()>0) {
			return ResponseEntity.ok(listaEmpresa);
		}
		
		return ResponseEntity.badRequest().build();
		
	}
}
