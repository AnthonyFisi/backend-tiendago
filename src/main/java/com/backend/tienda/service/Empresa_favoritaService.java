package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Empresa_favorita;

public interface Empresa_favoritaService {
	
	List<Empresa_favorita> listaEmpresas(int idusuario);

}
