package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Usuario;
import com.backend.tienda.service.UsuarioService;

@RestController
@RequestMapping(UsuarioController.USUARIO_CONTROLLER)

public class UsuarioController {
	
	public final static String USUARIO_CONTROLLER="/UsuarioController";
	
	public final static String UPDATE_CORREO="/updateCorreo/{idusuario}/{correo}";
	
	public final static String UPDATE_CELULAR="/updateCelular/{idusuario}/{celular}";
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@PostMapping(UPDATE_CORREO)
	public ResponseEntity<Usuario>  updateCorreo(@PathVariable("idusuario")int idusuario,@PathVariable("correo")String correo){
		
		Usuario usuario=usuarioService.updateCorreo(idusuario, correo);
		
		
		if(usuario==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(usuario);

	}
	
	

	@PostMapping(UPDATE_CELULAR)
	public ResponseEntity<Usuario>  updateCelular(@PathVariable("idusuario")int idusuario,@PathVariable("celular")String celular){
		
		Usuario usuario=usuarioService.updateCelular(idusuario, celular);
		
		if(usuario==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(usuario);

	}

}
