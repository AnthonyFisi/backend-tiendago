package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Empresa_favorito_usuario;
import com.backend.tienda.repository.Empresa_favorito_usuarioRepository;
import com.backend.tienda.service.Empresa_favorito_usuarioService;

@Service
public class Empresa_favorito_usuarioServiceImpl implements  Empresa_favorito_usuarioService{
	
	@Autowired
	Empresa_favorito_usuarioRepository empresa_favorito_usuarioRepository;

	@Override
	public Empresa_favorito_usuario guardarFavorito(Empresa_favorito_usuario favorito) {
		
		return empresa_favorito_usuarioRepository.save(favorito);
	}

}
