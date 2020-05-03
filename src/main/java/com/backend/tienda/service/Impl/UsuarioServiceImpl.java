package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.UsuarioDAO;
import com.backend.tienda.entity.Usuario;
import com.backend.tienda.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario mostrarByUsuario(int idUsuario) {
		return usuarioDAO.mostrarByUsuario(idUsuario);
	}

	@Override
	public int añadirUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDAO.añadirUsuario(usuario);
	}

	@Override
	public Usuario mostrarUsuarioByCorreo(String correo) {
		return usuarioDAO.mostrarUsuarioByCorreo(correo);
	}

}
