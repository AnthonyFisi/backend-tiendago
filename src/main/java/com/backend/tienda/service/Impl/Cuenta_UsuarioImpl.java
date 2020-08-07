package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Cuenta_Usuario;
import com.backend.tienda.repository.Cuenta_UsuarioRepository;
import com.backend.tienda.service.Cuenta_UsuarioService;

@Service
public class Cuenta_UsuarioImpl implements Cuenta_UsuarioService{
	
	@Autowired
	Cuenta_UsuarioRepository cuenta_UsuarioRepository;
	

	@Override
	public Cuenta_Usuario saveCuenta_Usuario(Cuenta_Usuario cuenta) {
		return cuenta_UsuarioRepository.save(cuenta);
	}

}
