package com.backend.tienda.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Usuario;
import com.backend.tienda.service.UsuarioService;

@RequestMapping("/Usuario")
@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	
	@RequestMapping(value = "/mostrarUsuario/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Usuario> guardarUsuario(@PathVariable("idUsuario")int idUsuario){
		Usuario usuario= service.mostrarByUsuario(idUsuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/mostrarUsuarioByCorreo/{correo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Usuario> mostrarUsuarioByCorreo(@PathVariable("correo")String correo){
		Usuario usuario= service.mostrarUsuarioByCorreo(correo);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	
	
	

	@RequestMapping(value = "/registrarUsuarioFirebase", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Integer> registrarUsuario(@RequestBody Usuario usuario){
		System.out.println("entramos");
		int respuesta=0;
		
		try {
			respuesta=service.añadirUsuario(usuario);
			return new ResponseEntity<Integer>(respuesta,HttpStatus.OK); 

		}catch(Exception e) {
			return new ResponseEntity<Integer>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	
	}

}
