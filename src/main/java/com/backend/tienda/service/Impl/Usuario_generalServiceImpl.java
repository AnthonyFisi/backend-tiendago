package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Usuario_general;
import com.backend.tienda.repository.Usuario_generalRepository;
import com.backend.tienda.service.Usuario_generalService;

@Service
public class Usuario_generalServiceImpl  implements Usuario_generalService{
	
	@Autowired
	Usuario_generalRepository usuarioRepository;

	@Override
	public Usuario_general updateCelular(int idusuario, String celular) {
	
		Usuario_general usuario=null;
		
		usuario=usuarioRepository.findById((long) idusuario).get();
		usuario.setCelular(celular);
		return usuarioRepository.save(usuario);
		
	}

	@Override
	public Usuario_general updateCorreo(int idusuario, String correo) {
		Usuario_general usuario=null;
		usuario=usuarioRepository.findById((long) idusuario).get();
		usuario.setCelular(correo);
		return usuarioRepository.save(usuario);
	}

}
