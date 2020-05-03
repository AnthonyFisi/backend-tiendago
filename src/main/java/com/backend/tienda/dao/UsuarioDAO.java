package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.Usuario;

public interface UsuarioDAO {

	int añadirUsuario(Usuario usuario);
	boolean eliminarUsuario(int idUsuario);
	List<Usuario> listaUsuario();
	Usuario mostrarByUsuario(int idUsuario);
	Usuario mostrarUsuarioByCorreo(String correo);

}
