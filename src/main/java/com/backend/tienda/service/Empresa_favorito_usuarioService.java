package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Empresa_favorito_usuario;

public interface Empresa_favorito_usuarioService {
	
	
	Empresa_favorito_usuario guardarFavorito(Empresa_favorito_usuario favorito);
	
	Empresa_favorito_usuario eliminarFavorito(int idempresa,int idusuario);
	
	List<Empresa_favorito_usuario>  listaEmpresas(int idusuario);

}
