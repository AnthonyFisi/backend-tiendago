package com.backend.tienda.service;

import com.backend.tienda.entity.Usuario;

public interface UsuarioService {
	
	Usuario updateCelular(int idusuario,String celular);
	
	Usuario updateCorreo(int idusuario,String correo);

}
