package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Usuario;
import com.backend.tienda.repository.UsuarioRepository;
import com.backend.tienda.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
	
		return usuarioRepository.save(usuario);
	}

}
