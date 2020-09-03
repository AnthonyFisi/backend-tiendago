package com.backend.tienda.service;

import com.backend.tienda.entity.Usuario_general;

public interface Usuario_generalService {
	
	Usuario_general updateCelular(int idusuario,String celular);
	
	Usuario_general updateCorreo(int idusuario,String correo);

}
