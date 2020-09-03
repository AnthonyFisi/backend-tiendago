package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Usuario_general;
import com.backend.tienda.service.Usuario_generalService;

@RestController
@RequestMapping(Usuario_generalController.USUARIO_CONTROLLER)

public class Usuario_generalController {
	
	public final static String USUARIO_CONTROLLER="/UsuarioController";
	
	public final static String UPDATE_CORREO="/updateCorreo/{idusuario}/{correo}";
	
	public final static String UPDATE_CELULAR="/updateCelular/{idusuario}/{celular}";
	
	@Autowired
	Usuario_generalService usuarioService;
	
	
	@PostMapping(UPDATE_CORREO)
	public ResponseEntity<Usuario_general>  updateCorreo(@PathVariable("idusuario")int idusuario,@PathVariable("correo")String correo){
		
		Usuario_general usuario=usuarioService.updateCorreo(idusuario, correo);
		
		
		if(usuario==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(usuario);

	}
	
	

	@PostMapping(UPDATE_CELULAR)
	public ResponseEntity<Usuario_general>  updateCelular(@PathVariable("idusuario")int idusuario,@PathVariable("celular")String celular){
		
		Usuario_general usuario=usuarioService.updateCelular(idusuario, celular);
		
		if(usuario==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(usuario);

	}

}
