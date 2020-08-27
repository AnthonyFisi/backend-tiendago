package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Usuario;
import com.backend.tienda.repository.UsuarioRepository;
import com.backend.tienda.service.UsuarioService;

@Service
public class UsuarioServiceImpl  implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Usuario updateCelular(int idusuario, String celular) {
	
		Usuario usuario=null;
		
		usuario=usuarioRepository.findById((long) idusuario).get();
		usuario.setCelular(celular);
		return usuarioRepository.save(usuario);
		
	}

	@Override
	public Usuario updateCorreo(int idusuario, String correo) {
		Usuario usuario=null;
		usuario=usuarioRepository.findById((long) idusuario).get();
		usuario.setCelular(correo);
		return usuarioRepository.save(usuario);
	}

}
