package com.backend.tienda.service;

import com.backend.tienda.entity.Usuario;

public interface UsuarioService {
	
	Usuario mostrarByUsuario(int idUsuario);
	int añadirUsuario(Usuario usuario);
	Usuario mostrarUsuarioByCorreo(String correo);




}
